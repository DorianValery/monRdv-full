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

import com.fasterxml.jackson.annotation.JsonView;

import sopra.formation.model.Consultation;
import sopra.formation.model.Views;
import sopra.formation.repository.IConsultationRepository;

@RestController
@RequestMapping("/consultation")
@CrossOrigin("*")
public class ConsultationRestController {

	@Autowired
	private IConsultationRepository consultationRepo;

	@GetMapping("")
	@JsonView(Views.ViewConsultation.class)
	public List<Consultation> findAll() {
		List<Consultation> consultations = consultationRepo.findAll();

		return consultations;
	}
	
	@GetMapping("list/detail")
	@JsonView(Views.ViewConsultationDetail.class)
	public List<Consultation> findAllDetails() {
		List<Consultation> consultations = consultationRepo.findAllConsultationWithMotifAndPatient();

		return consultations;
	}

	@GetMapping("{id}")
	@JsonView(Views.ViewConsultation.class)
	public Consultation find(@PathVariable Long id) {
		Optional<Consultation> optConsultation = consultationRepo.findById(id);

		if (optConsultation.isPresent()) {
			return optConsultation.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Consultation non trouv??");
		}
	}
	
	@GetMapping("{id}/detail")
	@JsonView(Views.ViewConsultationDetail.class)
	public Consultation findDetail(@PathVariable Long id) {
		Optional<Consultation> optConsultation = consultationRepo.findByIdConsultationWithMotifAndPatient(id);

		if (optConsultation.isPresent()) {
			return optConsultation.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Consultation non trouv??");
		}
	}
	
	@GetMapping("{id}/detailCreneaux")
	@JsonView(Views.ViewConsultationCreneaux.class)
	public Consultation findDetailCreneaux(@PathVariable Long id) {
		Optional<Consultation> optConsultation = consultationRepo.findByIdConsultationWithCreneaux(id);

		if (optConsultation.isPresent()) {
			return optConsultation.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Consultation non trouv??");
		}
	}

	@PostMapping("")
	@JsonView(Views.ViewConsultation.class)
	public Consultation create(@RequestBody Consultation consultation) {
		consultation = consultationRepo.save(consultation);

		return consultation;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewConsultation.class)
	public Consultation update(@PathVariable Long id, @RequestBody Consultation consultation) {
		if (!consultationRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Consultation non trouv??");
		}

		consultation = consultationRepo.save(consultation);

		return consultation;
	}


	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		if (!consultationRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Consultation non trouv??");
		}
		
		consultationRepo.deleteById(id);
	}

}
