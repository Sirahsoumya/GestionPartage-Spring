package ma.pfa.GestionPartage.entity;

import java.util.Date;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class DemandeService  {
	@JsonIgnore
	@EmbeddedId
	private DemandeServiceKey idDemServ;
	@Temporal(TemporalType.DATE)
	private Date date_demande;
	@Temporal(TemporalType.DATE)
	private Date date_retour;
	private String commentaire;
	
	@JoinColumn(name="user", referencedColumnName="id_user", insertable= false, updatable = false)
	@ManyToOne
	private User user;
	
	@JoinColumn(name="service", referencedColumnName="id_serv", insertable= false, updatable = false)
	@ManyToOne
	private Service service;
	

	public DemandeService() {
		super();
		this.idDemServ=new DemandeServiceKey();
		this.user=new User();
		this.service=new Service();
	}

	

	public DemandeService(DemandeServiceKey idDemServ,Date date_demande,
			Date date_retour, String commentaire, User user, Service service) {
		super();
		this.idDemServ = idDemServ;
		this.date_demande = date_demande;
		this.date_retour = date_retour;
		this.commentaire = commentaire;
		this.user = user;
		this.service = service;
	}



	public DemandeServiceKey getidDemServ() {
		return idDemServ;
	}

	public void setidDemServ(DemandeServiceKey idDemServ) {
		this.idDemServ = idDemServ;
	}


	public Date getDate_demande() {
		return date_demande;
	}

	public void setDate_demande(Date date_demande) {
		this.date_demande = date_demande;
	}


	public Date getDate_retour() {
		return date_retour;
	}

	public void setDate_retour(Date date_retour) {
		this.date_retour = date_retour;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}

    

	public DemandeServiceKey getIdDemServ() {
		return idDemServ;
	}



	public void setIdDemServ(DemandeServiceKey idDemServ) {
		this.idDemServ = idDemServ;
	}



	public Service getService() {
		return service;
	}


	public void setService(Service service) {
		this.service = service;
	}
	
	
	
	

}
