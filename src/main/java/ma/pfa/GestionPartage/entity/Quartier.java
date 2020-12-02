package ma.pfa.GestionPartage.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Quartier {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_quartier;
	private String nom_quartier;
	private String adresse;
	private String ville;
	private String pays;
	@JsonIgnore
	@OneToMany(mappedBy="quartier", fetch=FetchType.EAGER)
	private List<User>user;
	
	public String getVille() {
		return ville;
	}


	public String getPays() {
		return pays;
	}
	

	public void setPays(String pays) {
		this.pays = pays;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public List<User> getUser() {
		return user;
	}

	public void setUser(List<User> user) {
		this.user = user;
	}

	public  Quartier() {}

	public int getId_quartier() {
		return id_quartier;
	}

	public void setId_quartier(int id_quartier) {
		this.id_quartier = id_quartier;
	}

	public String getNom_quartier() {
		return nom_quartier;
	}

	public void setNom_quartier(String nom_quartier) {
		this.nom_quartier = nom_quartier;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	

}
