package ma.pfa.GestionPartage.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToOne;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Plainte {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_plainte;
	@Temporal(TemporalType.DATE)
	private Date date_plainte;
	private String desc_plainte;
	// @JoinColumn(name="user1", referencedColumnName="id_user", insertable= false,
	// updatable = false)
	//@Cascade(CascadeType.REMOVE)
	@ManyToOne(fetch = FetchType.LAZY)
	private User user1;
	public Plainte() {
	}

	public User getUser1() {
		return user1;
	}

	public void setUser1(User user1) {
		this.user1 = user1;
	}

	public int getId_plainte() {
		return id_plainte;
	}

	public void setId_plainte(int id_plainte) {
		this.id_plainte = id_plainte;
	}

	public Date getDate_plainte() {
		return date_plainte;
	}

	public void setDate_plainte(Date date_plainte) {
		this.date_plainte = date_plainte;
	}

	public String getDesc_plainte() {
		return desc_plainte;
	}

	public void setDesc_plainte(String desc_plainte) {
		this.desc_plainte = desc_plainte;
	}
	

}
