package sopra.formation.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sopra.formation.web.dto.PatientDTO;
import sopra.monRdv.model.Adresse;
import sopra.monRdv.model.Patient;
import sopra.monRdv.repository.IPatientRepository;

@Controller
@RequestMapping("/patient")
public class PatientController {
	
	@Autowired
	private IPatientRepository patientRepo =null;
	
		@GetMapping({ "", "/list" })
		public String list(Model model) {
			List <Patient> patients = patientRepo.findAll();
			
			model.addAttribute("patients",patients);
			return "patient/list";
		}

		@GetMapping("/add")
		public String add(Model model) {
			model.addAttribute("patient", new Patient());
			
			
			return "patient/form";
		}

		@GetMapping("/edit")
		public String edit(Model model, @RequestParam Long id) {
			Optional<Patient> optPatient = patientRepo.findById(id);

			if (optPatient.isPresent())
			{
				model.addAttribute("patient",optPatient.get());
				return "patient/form";
			}else {
				return "forward:list";
			}
		}

		
		@PostMapping("/save")
		public String save(@ModelAttribute("patient") PatientDTO patientDTO ) {
			
			Patient patient=null;

			if(patientDTO.getId() != null) {
				patient = patientRepo.findById(patientDTO.getId()).get();
				
			} else {
				patient = new Patient();
			}
			
			patient.setNom(patientDTO.getNom());
			patient.setPrenom(patientDTO.getPrenom());
			patient.setTelephone(patientDTO.getTelephone());
			patient.setDtNaissance(patientDTO.getDtNaissance());
			patient.setEmail(patientDTO.getEmail());
			
			
			patient.setPrincipal(patientDTO.isPrincipal());
			System.out.println("##################### PATIENT avant adresse: " + patient);
			patient.setAdresse(new Adresse(patientDTO.getVoie(), patientDTO.getComplement(), patientDTO.getCodePostal(), patientDTO.getVille()));
			
			
			System.out.println("##################### PATIENT APRES adresse: " + patient);
			patientRepo.save(patient);
			
			

			return "redirect:list";
		}

		@GetMapping("/cancel")
		public String cancel() {
			return "forward:list";
		}

		@GetMapping("/remove")
		public String remove(@RequestParam Long id) {
			patientRepo.deleteById(id);

			return "redirect:list";
		}
}
