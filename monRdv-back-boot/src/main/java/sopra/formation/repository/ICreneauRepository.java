package sopra.formation.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.formation.model.Consultation;
import sopra.formation.model.Creneau;

public interface ICreneauRepository extends JpaRepository<Creneau, Long> {

	@Query("select distinct c from Creneau c left join fetch c.praticien p left join fetch c.consultation co left join fetch c.lieu l")
	List<Creneau> findAllCreneauWithPraticienAndConsultationAndLieu(); 

	
}
