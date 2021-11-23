package sopra.formation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import sopra.formation.model.Patient;

public interface IPatientRepository extends JpaRepository<Patient, Long> {

	@Query("select distinct p from Patient p left join fetch p.consultations")
	List <Patient> findPatientWithConsultations();
}
