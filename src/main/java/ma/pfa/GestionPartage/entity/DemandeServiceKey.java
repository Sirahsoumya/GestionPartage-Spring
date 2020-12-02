package ma.pfa.GestionPartage.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class DemandeServiceKey implements Serializable{
	private int user;
	private int service;
	
	public DemandeServiceKey() {
		super();
	}

	public DemandeServiceKey(int user, int service) {
		super();
		this.user = user;
		this.service = service;
	}

	public int getUser() {
		return user;
	}

	public void setUser(int user) {
		this.user = user;
	}

	public int getService() {
		return service;
	}

	public void setService(int service) {
		this.service = service;
	}
	
	
}
