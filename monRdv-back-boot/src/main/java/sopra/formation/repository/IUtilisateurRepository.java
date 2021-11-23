package sopra.formation.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.formation.model.Patient;
import sopra.formation.model.Utilisateur;

public interface IUtilisateurRepository extends JpaRepository<Utilisateur, Long> {

	@Query("select u from Utilisateur u left join fetch u.patients where u.id=:id")
	Optional<Utilisateur> findByIdWithPatient(@Param ("id") Long id);
	
}
