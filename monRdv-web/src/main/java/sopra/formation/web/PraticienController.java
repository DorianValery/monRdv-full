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

import sopra.formation.web.dto.praticienDTO;
import sopra.monRdv.model.Praticien;
import sopra.monRdv.repository.IPraticienRepository;

@Controller
@RequestMapping("/praticien")
public class PraticienController {
	
	@Autowired
	private IPraticienRepository pratRepo = null;
	
	@GetMapping({"", "/list"})
	public String list(Model model) {
		List<Praticien> praticiens = pratRepo.findAll();
		List<praticienDTO> praticiensDTO = new ArrayList<praticienDTO>();
		
		for(Praticien praticien : praticiens) {
			praticiensDTO.add(new praticienDTO(praticien));
		}
		model.addAttribute("praticiens", praticiensDTO);
		
		return "praticien/list";
	}
	
	@GetMapping("/add")
	public String add(Model model) {
		model.addAttribute("praticien", new praticienDTO());
		return "praticien/form";
	}
	
	@GetMapping("/edit")
	public String edit(Model model, @RequestParam Long id) {
		Optional<Praticien> optPraticien = pratRepo.findById(id);
		if (optPraticien.isPresent()) {
			model.addAttribute("praticien", new praticienDTO(optPraticien.get()));
			return "praticien/form";
		}
		else {
			return "forward:list";
		}
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute("praticien")@Valid praticienDTO praticienDTO, BindingResult result ) {
	
		if(result.hasErrors()) {
			return "praticien/form";
		}
		
		Praticien praticien;
		if(praticienDTO.getId() !=0) {
			praticien=pratRepo.findById(praticienDTO.getId()).get();
		}else {
			praticien= new Praticien();
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
		
		pratRepo.save(praticien);
		
		return "redirect:list";		
	}
		
}
