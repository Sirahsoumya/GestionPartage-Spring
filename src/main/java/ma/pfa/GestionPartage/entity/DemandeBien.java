package ma.pfa.GestionPartage.entity;

import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class DemandeBien {
	@JsonIgnore
	@EmbeddedId
	private DemandeBienKey idDemandeBien;
	
	@Temporal(TemporalType.DATE)
	private Date date_demande;
	@Temporal(TemporalType.DATE)
	private Date date_retour;
	private String commentaire;
	@JoinColumn(name="userB", referencedColumnName="id_user", nullable = false, insertable= false, updatable = false)
	@ManyToOne(fetch = FetchType.EAGER)
	private User userB;
	
	@JoinColumn(name="bienB", referencedColumnName="id_bien", nullable = false, insertable= false, updatable = false)
	@ManyToOne(fetch = FetchType.EAGER)
	private Bien bienB;

	public DemandeBien() {
		super();
		this.idDemandeBien = new DemandeBienKey();
		this.userB = new User();
		this.bienB = new Bien();
	}
	public DemandeBienKey getIdDemandeBien() {
		return idDemandeBien;
	}
	public void setIdDemandeBien(DemandeBienKey idDemandeBien) {
		this.idDemandeBien = idDemandeBien;
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
	
	public User getUserB() {
		return userB;
	}
	public void setUserB(User userB) {
		this.userB = userB;
	}
	public Bien getBienB() {
		return bienB;
	}
	public void setBienB(Bien bienB) {
		this.bienB = bienB;
	}
	
	
	

}
