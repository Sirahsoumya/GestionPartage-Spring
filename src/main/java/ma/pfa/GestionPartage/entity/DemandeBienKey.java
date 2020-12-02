package ma.pfa.GestionPartage.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class DemandeBienKey implements Serializable{
	private int user;
	private int bien;
	
	public DemandeBienKey() {
		super();
	}

	public DemandeBienKey(int user, int bien) {
		super();
		this.user = user;
		this.bien = bien;
	}

	public int getUser() {
		return user;
	}

	public void setUser(int user) {
		this.user = user;
	}

	public int getbien() {
		return bien;
	}

	public void setbien(int bien) {
		this.bien = bien;
	}
	
	
}



