package sopra.formation;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import sopra.formation.model.Adresse;
import sopra.formation.model.Civilite;
import sopra.formation.model.Praticien;
import sopra.formation.model.Secteur;
import sopra.formation.model.Specialite;
import sopra.formation.repository.IConsultationRepository;
import sopra.formation.repository.ICreneauRepository;
import sopra.formation.repository.ILieuRepository;
import sopra.formation.repository.IMotifRepository;
import sopra.formation.repository.IPatientRepository;
import sopra.formation.repository.IPraticienRepository;
import sopra.formation.repository.ISpecialiteRepository;
import sopra.formation.repository.IUtilisateurRepository;

@SpringBootTest
class MonRdvBackBootApplicationTests {
	
	@Autowired
	private IConsultationRepository consultationRepo;
	@Autowired
	private ICreneauRepository creneauRepo;
	@Autowired
	private ILieuRepository lieuRepo;
	@Autowired
	private IMotifRepository motifRepo;
	@Autowired
	private IPatientRepository patientRepo;
	@Autowired
	private IPraticienRepository praticienRepo;
	@Autowired
	private ISpecialiteRepository speRepo;
	@Autowired
	private IUtilisateurRepository utilisateurRepo;
	
	
	@Test
	void contextLoads() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Praticien pr1 = new Praticien();
		pr1.setId((long) 1);
		pr1.setVersion(0);
		pr1.setCivilite(Civilite.MME);
		pr1.setNom("Grey");
		pr1.setPrenom("Meredith");
		pr1.setTelephone("0606060606");
		pr1.setSecteur(Secteur.SECTEUR_1);
		pr1.setCarteVitale(true);
		pr1.setPhoto("photo1");
		pr1.setCarteBancaire(true);
		pr1.setCheque(false);
		pr1.setEspece(false);
		pr1.setDureeCreneau(15);
		
		Praticien pr2 = new Praticien();
		pr2.setId((long) 2);
		pr2.setVersion(0);
		pr2.setCivilite(Civilite.MME);
		pr2.setNom("Yang");
		pr2.setPrenom("Cristina");
		pr2.setTelephone("01010101");
		pr2.setSecteur(Secteur.SECTEUR_2);
		pr2.setCarteVitale(false);
		pr2.setPhoto("photo1");
		pr2.setCarteBancaire(true);
		pr2.setCheque(true);
		pr2.setEspece(true);
		pr2.setDureeCreneau(5);
		
		Praticien pr3 = new Praticien();
		pr3.setId((long) 3);
		pr3.setVersion(0);
		pr3.setCivilite(Civilite.M);
		pr3.setNom("Karev");
		pr3.setPrenom("Alex");
		pr3.setTelephone("1212121212");
		pr3.setSecteur(Secteur.SECTEUR_3);
		pr3.setCarteVitale(true);
		pr3.setPhoto("photo1");
		pr3.setCarteBancaire(false);
		pr3.setCheque(false);
		pr3.setEspece(true);
		pr3.setDureeCreneau(10);
		
		Adresse adr1 = new Adresse();
		adr1.setVoie("5 avenue villemejan");
		adr1.setComplement("Résidence Diderot");
		adr1.setCodePostal("33600");
		adr1.setVille("PESSAC");
		
		Adresse adr2 = new Adresse();
		adr2.setVoie("86 avenue JFK");
		adr2.setComplement("1er étage");
		adr2.setCodePostal("33700");
		adr2.setVille("Mérignac");
		
		Specialite spe1 = new Specialite();
		spe1.setId((long) 1);
		spe1.setVersion(0);
		spe1.setNom("Cardiologie");
		spe1.setPraticien(pr2);
		
		Specialite spe2 = new Specialite();
		spe1.setId((long) 2);
		spe1.setVersion(0);
		spe1.setNom("Neurologie");
		spe1.setPraticien(pr1);
		
	}

}