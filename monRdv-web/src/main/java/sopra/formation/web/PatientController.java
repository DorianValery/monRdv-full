package sopra.formation.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

				return "patient/form";
		}

		
		@PostMapping("/save")
		public String save() {

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
