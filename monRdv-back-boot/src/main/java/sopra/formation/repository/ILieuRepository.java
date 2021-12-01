package sopra.formation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.formation.model.Lieu;
import sopra.formation.model.Praticien;

public interface ILieuRepository extends JpaRepository<Lieu, Long> {

	
	@Query("select distinct l from Lieu l where l.adresse.ville Like %:string%")
	List<Lieu> findAllLike(@Param("string") String string);
}
