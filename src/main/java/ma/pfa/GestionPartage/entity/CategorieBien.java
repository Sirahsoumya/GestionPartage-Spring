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
public class CategorieBien {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_catBien;
	private String desc_catBien;
	@JsonIgnore
	@OneToMany(mappedBy="categorieBien",fetch = FetchType.EAGER)
	private List<Bien>bien;
	public CategorieBien() {}

	public int getId_catBien() {
		return id_catBien;
	}

	public void setId_catBien(int id_catBien) {
		this.id_catBien = id_catBien;
	}

	public String getDesc_catBien() {
		return desc_catBien;
	}

	public void setDesc_catBien(String desc_catBien) {
		this.desc_catBien = desc_catBien;
	}

	public List<Bien> getBien() {
		return bien;
	}

	public void setBien(List<Bien> bien) {
		this.bien = bien;
	}
	
	
	
	
	
	
	
	
	
	
	

}
