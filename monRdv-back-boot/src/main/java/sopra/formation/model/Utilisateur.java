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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

import sopra.formation.model.Views.ViewCommon;
import sopra.formation.model.Views.ViewUtilisateurPatientDetail;
import sopra.formation.model.Views.ViewUtilisateurPraticien;

@Entity
@JsonView(ViewCommon.class)
public class Utilisateur {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Version
	private int version;
	@Column(length = 255)
	private String email;
	@Column(length = 30)
	private String motDePasse;
	@Enumerated(EnumType.STRING)
	@Column(length = 15)
	private Type type;
	@JsonView(ViewUtilisateurPraticien.class)
	@OneToOne(mappedBy = "utilisateur")
	private Praticien praticien;
	@JsonView(ViewUtilisateurPatientDetail.class)
	@OneToMany(mappedBy = "utilisateur")
	private List<Patient> patients = new ArrayList<Patient>();

	public Utilisateur() {
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Praticien getPraticien() {
		return praticien;
	}

	public void setPraticien(Praticien praticien) {
		this.praticien = praticien;
	}

	public List<Patient> getPatients() {
		return patients;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}

}
