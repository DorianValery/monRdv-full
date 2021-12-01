package sopra.formation.web;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import sopra.formation.model.Praticien;
import sopra.formation.model.Specialite;
import sopra.formation.model.Views;
import sopra.formation.repository.IPraticienRepository;
import sopra.formation.repository.ISpecialiteRepository;

@RestController
@RequestMapping("/praticien")
@CrossOrigin("*")
public class PraticienRestController {

	@Autowired
	private IPraticienRepository praticienRepo;
	@Autowired
	private ISpecialiteRepository specialiteRepo;

	@GetMapping("")
	@JsonView(Views.ViewPraticien.class)
	public List<Praticien> findAll() {
		List<Praticien> praticiens = praticienRepo.findAll();

		return praticiens;
	}
	
	@GetMapping("Spe")
	@JsonView(Views.ViewPraticien.class)
	public List<Praticien> findAllWithSpecialites() {
		List<Praticien> praticiens = praticienRepo.findAllWithSpecialites();

		return praticiens;
	}
	
	@GetMapping("detail/lieux")
	@JsonView(Views.ViewPraticien.class)
	public List<Praticien> findAllWithLieux() {
		List<Praticien> praticiens = praticienRepo.findAllWithLieu();

		return praticiens;
	}
	
	@GetMapping("Cre/{id}")
	@JsonView(Views.ViewPraticien.class)
	public Optional<Praticien> findByIdWithCreneau(@PathVariable Long id) {
		Optional<Praticien> praticiens = praticienRepo.findByIdWithCreneau(id);

		return praticiens;
	}
	
	
	@GetMapping("/{id}/lieux")
	@JsonView(Views.ViewPraticien.class)
	public Optional<Praticien> findByIdWithLieu(@PathVariable Long id) {
		Optional<Praticien> praticiens = praticienRepo.findByIdWithLieu(id);

		return praticiens;
	}
	
	@GetMapping("Like/{String}")
	@JsonView(Views.ViewPraticien.class)
	public List<Praticien> findAllLike(@PathVariable String String) {
		List<Praticien> praticiens=null;
		try {
		praticiens = praticienRepo.findAllLikeWithLieux(String);}
		catch (Exception e) {
			e.printStackTrace();
		}
		try {
		List<Specialite> specialites = specialiteRepo.findAllLike(String);
		for (Specialite spe :specialites) {
			praticiens.add(praticienRepo.findById(spe.getPraticien().getId()).get());
		}}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		

		return praticiens;
	}

	@GetMapping("{id}")
	@JsonView(Views.ViewPraticien.class)
	public Praticien find(@PathVariable Long id) {
		Optional<Praticien> optpraticien = praticienRepo.findById(id);

		if (optpraticien.isPresent()) {
			return optpraticien.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "praticien non trouvé");
		}
	}

	@PostMapping("")
	@JsonView(Views.ViewPraticien.class)
	public Praticien create(@Valid @RequestBody Praticien praticien, BindingResult result) {
		
		
		praticien = praticienRepo.save(praticien);

		return praticien;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewPraticien.class)
	public Praticien update(@PathVariable Long id, @RequestBody Praticien praticien) {
		if (!praticienRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "praticien non trouvé");
		}

		praticien = praticienRepo.save(praticien);

		return praticien;
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		if (!praticienRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "praticien non trouvé");
		}
		
		praticienRepo.deleteById(id);
	}

}
