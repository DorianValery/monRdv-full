package sopra.formation.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import sopra.formation.model.Creneau;
import sopra.formation.model.Views;
import sopra.formation.repository.ICreneauRepository;

@RestController
@RequestMapping("/creneau")
@CrossOrigin("*")
public class CreneauRestController {

	@Autowired
	private ICreneauRepository creneauRepo;

	@GetMapping("")
	@JsonView(Views.ViewCreneau.class)
	public List<Creneau> findAll() {
		List<Creneau> creneaux = creneauRepo.findAll();

		return creneaux;
	}
	
	
	@GetMapping("/detail")
	@JsonView(Views.ViewCreneauDetail.class)
	public List<Creneau> findAllCreneauWithPraticienAndConsultationAndLieu() {
		List<Creneau> creneaux = creneauRepo.findAll();

		return creneaux;
	}
	

	@GetMapping("{id}")
	@JsonView(Views.ViewCreneau.class)
	public Creneau find(@PathVariable Long id) {
		Optional<Creneau> optCreneau = creneauRepo.findById(id);

		if (optCreneau.isPresent()) {
			return optCreneau.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Creneau non trouvé");
		}
	}
	
	@GetMapping("{id}/detail")
	@JsonView(Views.ViewCreneauDetail.class)
	public Creneau findDetail(@PathVariable Long id) {
		Optional<Creneau> optCreneau = creneauRepo.findByIdCreneauWithPraticienAndConsultationAndLieu(id);

		if (optCreneau.isPresent()) {
			return optCreneau.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Creneau non trouvé");
		}
	}
	

	@PostMapping("")
	@JsonView(Views.ViewCreneau.class)
	public Creneau create(@RequestBody Creneau creneau) {
		creneau = creneauRepo.save(creneau);

		return creneau;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewCreneau.class)
	public Creneau update(@PathVariable Long id, @RequestBody Creneau creneau) {
		if (!creneauRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Creneau non trouvé");
		}

		creneau = creneauRepo.save(creneau);

		return creneau;
	}


	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		if (!creneauRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Creneau non trouvé");
		}
		
		creneauRepo.deleteById(id);
	}

}

