package sopra.formation.web;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;


import sopra.formation.model.Consultation;
import sopra.formation.repository.IConsultationRepository;

@RestController
@RequestMapping("/consultation")
@CrossOrigin("*")
public class ConsultationRestController {

	@Autowired
	private IConsultationRepository consultationRepo;

	@GetMapping("")
//	@JsonView(Views.ViewConsultation.class)
	public List<Consultation> findAll() {
		List<Consultation> consultations = consultationRepo.findAll();

		return consultations;
	}

	@GetMapping("{id}")
//	@JsonView(Views.ViewConsultation.class)
	public Consultation find(@PathVariable Long id) {
		Optional<Consultation> optConsultation = consultationRepo.findById(id);

		if (optConsultation.isPresent()) {
			return optConsultation.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Consultation non trouvé");
		}
	}
	
	@GetMapping("{id}/detail")
//	@JsonView(Views.ViewConsultation.class)
	public Consultation detail(@PathVariable Long id) {
		Optional<Consultation> optConsultation = consultationRepo.findById(id);

		if (optConsultation.isPresent()) {
			return optConsultation.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Consultation non trouvé");
		}
	}

	@PostMapping("")
//	@JsonView(Views.Viewconsultation.class)
	public Consultation create(@RequestBody Consultation consultation) {
		consultation = consultationRepo.save(consultation);

		return consultation;
	}

	@PutMapping("/{id}")
//	@JsonView(Views.Viewconsultation.class)
	public Consultation update(@PathVariable Long id, @RequestBody Consultation consultation) {
		if (!consultationRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Consultation non trouvé");
		}

		consultation = consultationRepo.save(consultation);

		return consultation;
	}


	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		if (!consultationRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Consultation non trouvé");
		}
		
		consultationRepo.deleteById(id);
	}

}
