package ma.pfa.GestionPartage.entity;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_user;
	private String nom;
	private String Prenom;
	private String email;
	private String password;
	private String tel;
	private String note;
	// @cascade pour resoudre le probléme de cette exception
	// SQLIntegrityConstraintViolationException
	@Cascade({ CascadeType.REMOVE, CascadeType.DETACH })
	@OneToMany(mappedBy = "user1", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Plainte> plainte;
	@OneToMany(mappedBy = "userB")
	@JsonIgnore
	private List<DemandeBien> demandebien;

	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
	@JsonIgnore
	private List<DemandeService> demandes;

	@ManyToOne
	private Quartier quartier;

	public User() {
		super();
	}

	public User(int id_user, String nom, String prenom, String note, String email, String password, String tel,
			List<DemandeService> demandes) {
		super();
		this.id_user = id_user;
		this.nom = nom;
		this.note = note;
		this.Prenom = prenom;
		this.email = email;
		this.password = password;
		this.tel = tel;
		this.demandes = demandes;
	}

	public List<Plainte> getPlainte() {
		return plainte;
	}

	public void setPlainte(List<Plainte> plainte) {
		this.plainte = plainte;
	}

	public Quartier getQuartier() {
		return quartier;
	}

	public void setQuartier(Quartier quartier) {
		this.quartier = quartier;
	}

	/*
	 * public Plainte getPlainte() { return plainte; }
	 * 
	 * 
	 * 
	 * public void setPlainte(Plainte plainte) { this.plainte = plainte; }
	 */

	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return Prenom;
	}

	public void setPrenom(String prenom) {
		Prenom = prenom;
	}

	public String getemail() {
		return email;
	}

	public void setemail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public List<DemandeService> getDemandes() {
		return demandes;
	}

	public void setDemandes(List<DemandeService> demandes) {
		this.demandes = demandes;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public List<DemandeBien> getDemandebien() {
		return demandebien;
	}

	public void setDemandebien(List<DemandeBien> demandebien) {
		this.demandebien = demandebien;
	}

}
