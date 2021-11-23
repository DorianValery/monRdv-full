package sopra.formation.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.formation.model.Praticien;
import sopra.formation.model.Specialite;

public interface ISpecialiteRepository extends JpaRepository<Specialite, Long> {
	
	
	@Query("select s from Specialite s where s.praticien.id= :idPraticien ")
	List<Specialite> findByPraticienId(@Param("idPraticien") Long idPraticien);

	@Query("select distinct s from Specialite s where s.nom Like %:string% ")
	List<Specialite> findAllLike(@Param("string") String string);
}
