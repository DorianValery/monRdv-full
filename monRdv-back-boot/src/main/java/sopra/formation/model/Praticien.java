package sopra.formation.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

@Entity

public class Praticien {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(Views.ViewCommon.class)
	private Long id;
	@Version
	@JsonView(Views.ViewCommon.class)
	private int version;
	@Enumerated(EnumType.STRING)
	@Column(length = 5)
	@JsonView(Views.ViewCommon.class)
	private Civilite civilite;
	@Column(length = 100)
	@JsonView(Views.ViewCommon.class)
	private String nom;
	@Column(length = 100)
	@JsonView(Views.ViewCommon.class)
	private String prenom;
	@Column(length = 15)
	@JsonView(Views.ViewCommon.class)
	private String telephone;
	@Enumerated(EnumType.STRING)
	@Column(length = 10)
	@JsonView(Views.ViewCommon.class)
	private Secteur secteur;
	@JsonView(Views.ViewCommon.class)
	private boolean carteVitale;
	@Column(length = 500)
	@JsonView(Views.ViewCommon.class)
	private String photo;
	@JsonView(Views.ViewCommon.class)
	private boolean carteBancaire;
	@JsonView(Views.ViewCommon.class)
	private boolean cheque;
	@JsonView(Views.ViewCommon.class)
	private boolean espece;
	@JsonView(Views.ViewCommon.class)
	private Integer dureeCreneau;
	@OneToMany(mappedBy = "praticien")
	@JsonView(Views.ViewPraticienDetail.class)
	private List<Specialite> specialites = new ArrayList<Specialite>();
	@OneToMany(mappedBy = "praticien")
	@JsonView(Views.ViewPraticien.class)
	private List<Creneau> creneaux = new ArrayList<Creneau>();
	@OneToMany(mappedBy = "praticien")
	@JsonView(Views.ViewPraticienDetail.class)
	private List<Lieu> lieux = new ArrayList<Lieu>();
	@OneToOne
	@JoinColumn(name="utilisateur_id")
	private Utilisateur utilisateur;

	public Praticien() {
		super();
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

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public boolean isCarteBancaire() {
		return carteBancaire;
	}

	public void setCarteBancaire(boolean carteBancaire) {
		this.carteBancaire = carteBancaire;
	}

}
