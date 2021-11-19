package sopra.formation.web.dto;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class PatientDTO {

	private Long id;
	private String nom;
	private String prenom;
	private String telephone;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dtNaissance;
	private String email;
	private boolean principal;
	private String voie;
	private String complement;
	private String codePostal;
	private String ville;
	
	public PatientDTO() {
		super();
	}



	public PatientDTO(Long id, String nom, String prenom, String telephone, LocalDate dtNaissance, String email,
			boolean principal, String voie, String complement, String codePostal, String ville) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
		this.dtNaissance = dtNaissance;
		this.email = email;
		this.principal = principal;
		this.voie = voie;
		this.complement = complement;
		this.codePostal = codePostal;
		this.ville = ville;
	}



	
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
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

	public LocalDate getDtNaissance() {
		return dtNaissance;
	}

	public void setDtNaissance(LocalDate dtNaissance) {
		this.dtNaissance = dtNaissance;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isPrincipal() {
		return principal;
	}

	public void setPrincipal(boolean principal) {
		this.principal = principal;
	}

	public String getVoie() {
		return voie;
	}

	public void setVoie(String voie) {
		this.voie = voie;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}
	
	

	
}
