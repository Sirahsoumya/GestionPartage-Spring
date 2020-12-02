package ma.pfa.GestionPartage.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Bien {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_bien;
	private String type_bien;
	private boolean status;
	private String cout;
	private String image;
	@Temporal(TemporalType.DATE)
	private Date date_debut;
	@Temporal(TemporalType.DATE)
	private Date date_fin;
	@OneToMany(mappedBy="bienB")
	@JsonIgnore
	private List<DemandeBien> demandebien;
	@ManyToOne
	private CategorieBien categorieBien;
	public Bien() {}
	public int getId_bien() {
		return id_bien;
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
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public void setId_bien(int id_bien) {
		this.id_bien = id_bien;
	}
	public String getType_bien() {
		return type_bien;
	}
	public void setType_bien(String type_bien) {
		this.type_bien = type_bien;
	}
	
	public String getCout() {
		return cout;
	}
	public void setCout(String cout) {
		this.cout = cout;
	}
	public List<DemandeBien> getDemandebien() {
		return demandebien;
	}
	public void setDemandebien(List<DemandeBien> demandebien) {
		this.demandebien = demandebien;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public CategorieBien getCategorieBien() {
		return categorieBien;
	}
	public void setCategorieBien(CategorieBien categorieBien) {
		this.categorieBien = categorieBien;
	}
	
	
	
	
	
	
	
	
	
	

}
