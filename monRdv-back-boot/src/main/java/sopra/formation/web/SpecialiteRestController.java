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

import sopra.formation.model.Specialite;
import sopra.formation.model.Views;
import sopra.formation.repository.ISpecialiteRepository;

@RestController
@RequestMapping("/Specialite")
@CrossOrigin("*")
public class SpecialiteRestController {

	@Autowired
	private ISpecialiteRepository SpecialiteRepo;

	@GetMapping("")
	@JsonView(Views.ViewSpecialite.class)
	public List<Specialite> findAll() {
		List<Specialite> Specialites = SpecialiteRepo.findAll();

		return Specialites;
	}
	
	

	@GetMapping("{id}")
	@JsonView(Views.ViewSpecialite.class)
	public Specialite find(@PathVariable Long id) {
		Optional<Specialite> optSpecialite = SpecialiteRepo.findById(id);

		if (optSpecialite.isPresent()) {
			return optSpecialite.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Specialite non trouvé");
		}
	}

	@PostMapping("")
	@JsonView(Views.ViewSpecialite.class)
	public Specialite create(@Valid @RequestBody Specialite Specialite, BindingResult result) {
		
		
		Specialite = SpecialiteRepo.save(Specialite);

		return Specialite;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewSpecialite.class)
	public Specialite update(@PathVariable Long id, @RequestBody Specialite Specialite) {
		if (!SpecialiteRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Specialite non trouvé");
		}

		Specialite = SpecialiteRepo.save(Specialite);

		return Specialite;
	}
	
	@DeleteMapping("/{id}")
	@JsonView(Views.ViewSpecialite.class)
	public void delete(@PathVariable Long id) {
		if (!SpecialiteRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Specialite non trouvé");
		}
		
		SpecialiteRepo.deleteById(id);
	}

}
