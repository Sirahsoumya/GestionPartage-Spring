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
public class Categorie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_catServ;
	private String desc_catServ;
	@JsonIgnore
	@OneToMany(mappedBy="categorie", fetch=FetchType.EAGER)
	private List<Service>service;
	
	 public Categorie() {}
	public int getId_catServ() {
		return id_catServ;
	}
	public void setId_catServ(int id_catServ) {
		this.id_catServ = id_catServ;
	}
	public String getDesc_catServ() {
		return desc_catServ;
	}
	public void setDesc_catServ(String desc_catServ) {
		this.desc_catServ = desc_catServ;
	}
	public List<Service> getService() {
		return service;
	}
	public void setService(List<Service> service) {
		this.service = service;
	}
	 

}
