package sopra.formation.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.formation.model.Praticien;

public interface IPraticienRepository extends JpaRepository<Praticien, Long> {
	@Query("select distinct p from Praticien p left join fetch p.specialites s")
	List<Praticien> findAllWithSpecialites();
	
	@Query("select distinct p from Praticien p left join fetch p.specialites s where p.id = :id")
	Optional<Praticien> findByIdWithSpecialites(@Param("id") Long id);
	
	@Query("select distinct p from Praticien p left join fetch p.lieux l")
	List<Praticien> findAllWithLieu();
	
	@Query("select distinct p from Praticien p left join fetch p.lieux l where p.id = :id")
	Optional<Praticien> findByIdWithLieu(@Param("id") Long id);
	
	@Query("select distinct p from Praticien p left join fetch p.creneaux c where p.id = :id")
	Optional<Praticien> findByIdWithCreneau(@Param("id") Long id);
	
	@Query("select distinct p from Praticien p where p.nom Like %:string%")
	List<Praticien> findAllLike(@Param("string") String string);
	
	@Query("select distinct p from Praticien p left join fetch p.lieux l where p.nom Like %:string% or l.adresse.ville Like %:string%")
	List<Praticien> findAllLikeWithLieux(@Param("string") String string);
	
	@Query("select distinct p from Praticien p where p.id = :id ")
	Optional<Praticien> findById2(@Param("id") Long id);
}
