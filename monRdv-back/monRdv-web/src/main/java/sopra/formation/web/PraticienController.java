package sopra.formation.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sopra.formation.web.dto.PraticienDTO;
import sopra.monRdv.model.Civilite;
import sopra.monRdv.model.Praticien;
import sopra.monRdv.model.Secteur;
import sopra.monRdv.model.Specialite;
import sopra.monRdv.repository.IPraticienRepository;
import sopra.monRdv.repository.ISpecialiteRepository;

@Controller
@RequestMapping("/praticien")
public class PraticienController {

	@Autowired
	private IPraticienRepository pratRepo = null;

	@Autowired
	private ISpecialiteRepository specialiteRepo = null;

	@GetMapping({ "", "/list" })
	public String list(Model model) {
		List<Praticien> praticiens = pratRepo.findAllWithSpecialites();
		List<PraticienDTO> praticiensDTO = new ArrayList<PraticienDTO>();

		for (Praticien praticien : praticiens) {
			praticiensDTO.add(new PraticienDTO(praticien));
		}
		model.addAttribute("praticiens", praticiensDTO);

		return "praticien/list";
	}

	@GetMapping("/add")
	public String add(Model model) {
		model.addAttribute("praticien", new PraticienDTO());
		model.addAttribute("civilites", Civilite.values());
		model.addAttribute("secteurs", Secteur.values());

		return "praticien/form";
	}

	@GetMapping("/edit")
	public String edit(Model model, @RequestParam Long id) {
		Optional<Praticien> optPraticien = pratRepo.findByIdWithSpecialites(id);
		if (optPraticien.isPresent()) {
			model.addAttribute("secteurs", Secteur.values());
			model.addAttribute("civilites", Civilite.values());
			model.addAttribute("praticien", new PraticienDTO(optPraticien.get()));
			return "praticien/form";
		} else {
			return "forward:list";
		}
	}

	@PostMapping("/save")
	public String save(@ModelAttribute("praticien") @Valid PraticienDTO praticienDTO, BindingResult result) {

		if (result.hasErrors()) {
			return "praticien/form";
		}

		Praticien praticien;
		if (praticienDTO.getId() != null) {
			praticien = pratRepo.findById(praticienDTO.getId()).get();
		} else {
			praticien = new Praticien();
		}

		praticien.setCivilite(praticienDTO.getCivilite());
		praticien.setNom(praticienDTO.getNom());
		praticien.setPrenom(praticienDTO.getPrenom());
		praticien.setTelephone(praticienDTO.getTelephone());
		praticien.setSecteur(praticienDTO.getSecteur());
		praticien.setCarteVitale(praticienDTO.isCarteVitale());
		praticien.setPhoto(praticienDTO.getPhoto());
		praticien.setCarteBancaire(praticienDTO.isCarteBancaire());
		praticien.setCheque(praticienDTO.isCheque());
		praticien.setEspece(praticienDTO.isEspece());
		praticien.setDureeCreneau(praticienDTO.getDureeCreneau());

		praticien = pratRepo.save(praticien);
		
		
		for (Specialite specialite : specialiteRepo.findByPraticienId(praticien.getId())) {
			specialiteRepo.delete(specialite);
		}

		for (String spe : praticienDTO.getSpecialites()) {
			if (spe!="") {
			Specialite specialite = new Specialite();
			specialite.setNom(spe);
			specialite.setPraticien(praticien);
			specialiteRepo.save(specialite);}
		}

		return "redirect:list";
	}

	@GetMapping("/cancel")
	public String cancel() {
		return "forward:list";
	}

	@GetMapping("/remove")
	public String remove(@RequestParam Long id) {
		for (Specialite specialite : specialiteRepo.findByPraticienId(id)) {
			specialiteRepo.delete(specialite);
		}
		pratRepo.deleteById(id);

		return "redirect:list";
	}
}
