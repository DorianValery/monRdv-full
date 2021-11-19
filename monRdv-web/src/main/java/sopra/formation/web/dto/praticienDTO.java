package sopra.formation.web.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Version;

import sopra.monRdv.model.Civilite;
import sopra.monRdv.model.Creneau;
import sopra.monRdv.model.Lieu;
import sopra.monRdv.model.Praticien;
import sopra.monRdv.model.Secteur;
import sopra.monRdv.model.Specialite;
import sopra.monRdv.model.Utilisateur;

public class praticienDTO {
	
	private Long id;
	private int version;
	private Civilite civilite;
	private String nom;
	private String prenom;
	private String telephone;
	private Secteur secteur;
	private boolean carteVitale;
	private String photo;
	private List<String> paiement;
	private boolean carteBancaire;
	private boolean cheque;
	private boolean espece;
	private Integer dureeCreneau;
	private List<Specialite> specialites = new ArrayList<Specialite>();
	private List<Creneau> creneaux = new ArrayList<Creneau>();
	private List<Lieu> lieux = new ArrayList<Lieu>();

	
	public praticienDTO() {
		super();
	}
	
	
	public praticienDTO(Praticien praticien) {
		super();
		this.id = praticien.getId();
		this.civilite = praticien.getCivilite();
		this.nom = praticien.getNom();
		this.prenom = praticien.getPrenom();
		this.telephone = praticien.getTelephone();
		this.secteur = praticien.getSecteur();
		this.carteVitale = praticien.isCarteVitale();
		this.photo = praticien.getPhoto();
		this.carteBancaire = praticien.isCarteBancaire();
		this.cheque = praticien.isCheque();
		this.espece = praticien.isEspece();
		this.dureeCreneau = praticien.getDureeCreneau();
		this.specialites = praticien.getSpecialites();
		this.creneaux = praticien.getCreneaux();
		this.lieux = praticien.getLieux();
		if(this.carteBancaire) {this.paiement.add("carte Bancaire");}
		if(this.cheque) {this.paiement.add("cheque");}
		if(this.espece) {this.paiement.add("espece");}
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public Civilite getCivilite() {
		return civilite;
	}
	public void setCivilite(Civilite civilite) {
		this.civilite = civilite;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public Secteur getSecteur() {
		return secteur;
	}
	public void setSecteur(Secteur secteur) {
		this.secteur = secteur;
	}
	public boolean isCarteVitale() {
		return carteVitale;
	}
	public void setCarteVitale(boolean carteVitale) {
		this.carteVitale = carteVitale;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public List<String> getPaiement() {
		return paiement;
	}
	public void setPaiement(List<String> paiement) {
		this.paiement = paiement;
	}
	public boolean isCarteBancaire() {
		return carteBancaire;
	}
	public void setCarteBancaire(boolean carteBancaire) {
		this.carteBancaire = carteBancaire;
	}
	public boolean isCheque() {
		return cheque;
	}
	public void setCheque(boolean cheque) {
		this.cheque = cheque;
	}
	public boolean isEspece() {
		return espece;
	}
	public void setEspece(boolean espece) {
		this.espece = espece;
	}
	public Integer getDureeCreneau() {
		return dureeCreneau;
	}
	public void setDureeCreneau(Integer dureeCreneau) {
		this.dureeCreneau = dureeCreneau;
	}
	public List<Specialite> getSpecialites() {
		return specialites;
	}
	public void setSpecialites(List<Specialite> specialites) {
		this.specialites = specialites;
	}
	public List<Creneau> getCreneaux() {
		return creneaux;
	}
	public void setCreneaux(List<Creneau> creneaux) {
		this.creneaux = creneaux;
	}
	public List<Lieu> getLieux() {
		return lieux;
	}
	public void setLieux(List<Lieu> lieux) {
		this.lieux = lieux;
	}
	
	

}
