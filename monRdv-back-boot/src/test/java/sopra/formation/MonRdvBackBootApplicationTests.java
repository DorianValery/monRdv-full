package sopra.formation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import sopra.formation.model.Adresse;
import sopra.formation.model.Civilite;
import sopra.formation.model.Lieu;
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
		
		pr1 = (Praticien) praticienRepo.save(pr1);
		
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
		
		pr2 = (Praticien) praticienRepo.save(pr2);
		
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
		pr3 = (Praticien) praticienRepo.save(pr3);
		
		Specialite spe1 = new Specialite();
		spe1.setId((long) 1);
		spe1.setVersion(0);
		spe1.setNom("Cardiologie");
		spe1 = (Specialite) speRepo.save(spe1);
		
		
		Specialite spe2 = new Specialite();
		spe2.setId((long) 2);
		spe2.setVersion(0);
		spe2.setNom("Neurologie");
		spe2 = (Specialite) speRepo.save(spe2);
		
		List<Specialite> spes1 = new ArrayList<Specialite>();
		spes1.add(spe1);
		spes1.add(spe2);
		pr1.setSpecialites(spes1);
		pr1 = (Praticien) praticienRepo.save(pr1);
		
		List<Specialite> spes2 = new ArrayList<Specialite>();
		spes2.add(spe2);
		pr2.setSpecialites(spes2);
		pr2 = (Praticien) praticienRepo.save(pr2);
		
		Lieu lieu1 = new Lieu();
		lieu1.setId((long) 1);
		lieu1.setVersion(0);
		lieu1.setNom("Clinique");
		lieu1.setInformations("C'est sympa");
		lieu1.setPraticien(pr1);
		
		Lieu lieu2 = new Lieu();
		lieu2.setId((long) 2);
		lieu2.setVersion(0);
		lieu2.setNom("Hopital");
		lieu2.setInformations("C'est grand");
		lieu2.setPraticien(pr1);
		
		
		Adresse adr1 = new Adresse();
		adr1.setVoie("5 avenue villemejan");
		adr1.setComplement("Résidence Diderot");
		adr1.setCodePostal("33600");
		adr1.setVille("PESSAC");
		lieu1.setAdresse(adr1);
		
		lieu1 = (Lieu) lieuRepo.save(lieu1);
		
		
		
		Adresse adr2 = new Adresse();
		adr2.setVoie("86 avenue JFK");
		adr2.setComplement("1er étage");
		adr2.setCodePostal("33700");
		adr2.setVille("Mérignac");
		lieu2.setAdresse(adr2);
		lieu2 = (Lieu) lieuRepo.save(lieu2);
		
		
		
		
		
	}

}