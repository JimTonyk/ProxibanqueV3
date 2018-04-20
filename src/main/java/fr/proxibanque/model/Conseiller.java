package fr.proxibanque.model;

/**
 * Cette classe factorise les informations sur un conseiller afin de lui
 * associer des clients. Cette implémentation fera l'objet de la 2ème version du
 * livrable.
 * 
 * @author Jean-Michel Hiltbrunner,Ozlem Avci
 *
 */

public class Conseiller {

	// *** ATTRIBUTES ***

	private int id;
	private String prenom;
	private String nom;
	private String login;
	private String password;

	// *** CONSTRUCTORS ***

	public Conseiller() {
		super();
	}

	public Conseiller(String prenom, String nom, String login, String password, int id) {
		this.id = id;
		this.prenom = prenom;
		this.nom = nom;
		this.login = login;
		this.password = password;
	}

	// *** GETTERS and SETTERS ***

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	// *** OTHER METHODS ***

	@Override
	public String toString() {
		return "Conseiller [id=" + id + ", prenom=" + prenom + ", nom=" + nom + ", login=" + login + ", password="
				+ password + "]";
	}

}
