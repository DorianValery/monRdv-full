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

import sopra.formation.model.Lieu;
import sopra.formation.model.Views;
import sopra.formation.repository.ILieuRepository;

@RestController
@RequestMapping("/Lieu")
@CrossOrigin("*")
public class LieuRestController {

	@Autowired
	private ILieuRepository LieuRepo;

	@GetMapping("")
	
	public List<Lieu> findAll() {
		List<Lieu> Lieus = LieuRepo.findAll();

		return Lieus;
	}
	
	

	@GetMapping("{id}")
	public Lieu find(@PathVariable Long id) {
		Optional<Lieu> optLieu = LieuRepo.findById(id);

		if (optLieu.isPresent()) {
			return optLieu.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Lieu non trouvé");
		}
	}

	@PostMapping("")
	public Lieu create(@Valid @RequestBody Lieu Lieu, BindingResult result) {
		
		
		Lieu = LieuRepo.save(Lieu);

		return Lieu;
	}

	@PutMapping("/{id}")
	public Lieu update(@PathVariable Long id, @RequestBody Lieu Lieu) {
		if (!LieuRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Lieu non trouvé");
		}

		Lieu = LieuRepo.save(Lieu);

		return Lieu;
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		if (!LieuRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Lieu non trouvé");
		}
		
		LieuRepo.deleteById(id);
	}

}
