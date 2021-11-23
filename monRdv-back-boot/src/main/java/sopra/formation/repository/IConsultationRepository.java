package sopra.formation.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.formation.model.Consultation;

public interface IConsultationRepository extends JpaRepository<Consultation, Long> {
	
	@Query("select distinct c from Consultation c left join fetch c.motif m left join fetch c.patient p")
	List<Consultation> findAllConsultationWithMotifAndPatient(); 
	
	@Query("select distinct c from Consultation c left join fetch c.motif m left join fetch c.patient p where c.id = :id")
	Optional<Consultation> findByIdConsultationWithMotifAndPatient(@Param("id") Long id); 
	
	@Query("select distinct c from Consultation c left join fetch c.creneaux cr where c.id = :id")
	Optional<Consultation> findByIdConsultationWithCreneaux(@Param("id") Long id); 
	
}
