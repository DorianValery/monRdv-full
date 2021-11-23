package sopra.formation.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.formation.model.Motif;

public interface IMotifRepository extends JpaRepository<Motif, Long> {
	@Query("select distinct m from Motif m left join fetch m.specialite s where m.specialite.id = :idSpe")
	Optional<Motif> findAllBySpecialite(@Param("idSpe") Long idSpe);

}
