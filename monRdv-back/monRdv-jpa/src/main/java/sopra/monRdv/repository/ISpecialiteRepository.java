package sopra.monRdv.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.monRdv.model.Specialite;

public interface ISpecialiteRepository extends JpaRepository<Specialite, Long> {
	
	@Query("select s from Specialite s where s.praticien.id= :idPraticien ")
	List<Specialite> findByPraticienId(@Param("idPraticien") Long idPraticien);

}
