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

import sopra.formation.model.Motif;
import sopra.formation.model.Views;
import sopra.formation.repository.IMotifRepository;

@RestController
@RequestMapping("/motif")
@CrossOrigin("*")
public class MotifRestController {

	@Autowired
	private IMotifRepository MotifRepo;

	@GetMapping("")
	@JsonView(Views.ViewMotif.class)
	public List<Motif> findAll() {
		List<Motif> Motifs = MotifRepo.findAll();

		return Motifs;
	}
	
	@GetMapping("/spe/{id}")
	@JsonView(Views.ViewMotif.class)
	public Optional<Motif> findAllBySpecialite(@PathVariable Long id) {
		Optional<Motif> Motifs = MotifRepo.findAllBySpecialite(id);

		return Motifs;
	}

	@GetMapping("{id}")
	@JsonView(Views.ViewMotif.class)
	public Motif find(@PathVariable Long id) {
		Optional<Motif> optMotif = MotifRepo.findById(id);

		if (optMotif.isPresent()) {
			return optMotif.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Motif non trouvé");
		}
	}

	@PostMapping("")
	@JsonView(Views.ViewMotif.class)
	public Motif create(@Valid @RequestBody Motif Motif, BindingResult result) {
		
		
		Motif = MotifRepo.save(Motif);

		return Motif;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewMotif.class)
	public Motif update(@PathVariable Long id, @RequestBody Motif Motif) {
		if (!MotifRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Motif non trouvé");
		}

		Motif = MotifRepo.save(Motif);

		return Motif;
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		if (!MotifRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Motif non trouvé");
		}
		
		MotifRepo.deleteById(id);
	}

}
