package ma.pfa.GestionPartage.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Service {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_serv;
	private String type_service;
	private String cout;
	private boolean status;
	@Temporal(TemporalType.DATE)
	private Date date_debut;
	@Temporal(TemporalType.DATE)
	private Date date_fin;
	@OneToMany(mappedBy="service", fetch=FetchType.EAGER)
	@JsonIgnore
	private List<DemandeService> demandes;
	@ManyToOne
	private Categorie categorie;
	
	public Service() {
		super();
	}

	public Service(int id_serv, String type_service, String cout, boolean status, Date date_debut, Date date_fin,
			List<DemandeService> demandes, Categorie categorie) {
		super();
		this.id_serv = id_serv;
		this.type_service = type_service;
		this.cout = cout;
		this.status = status;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		this.demandes = demandes;
		this.categorie = categorie;
	}


	public boolean isStatus() {
		return status;
	}
	


	public Date getDate_debut() {
		return date_debut;
	}

	public void setDate_debut(Date date_debut) {
		this.date_debut = date_debut;
	}

	public Date getDate_fin() {
		return date_fin;
	}

	public void setDate_fin(Date date_fin) {
		this.date_fin = date_fin;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}


	public Categorie getCategorie() {
		return categorie;
	}


	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}


	public int getId_serv() {
		return id_serv;
	}

	public void setId_serv(int id_serv) {
		this.id_serv = id_serv;
	}

	public String getType_service() {
		return type_service;
	}

	public void setType_service(String type_service) {
		this.type_service = type_service;
	}

	

	public String getCout() {
		return cout;
	}

	public void setCout(String cout) {
		this.cout = cout;
	}

	public List<DemandeService> getDemandes() {
		return demandes;
	}

	public void setDemandes(List<DemandeService> demandes) {
		this.demandes = demandes;
	}
	
	

}
