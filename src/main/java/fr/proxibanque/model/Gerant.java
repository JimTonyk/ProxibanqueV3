package fr.proxibanque.model;

/**
 * 
 * 
 * @author Jean-Michel Hiltbrunner,Ozlem Avci
 *
 */

public class Gerant {
	// *** ATTRIBUTES ***

	private int id;
	private String prenom;
	private String nom;
	private String login;
	private String password;

	// *** CONSTRUCTORS ***

	public Gerant() {
		super();
	}

	public Gerant(int id, String prenom, String nom, String login, String password) {
		super();
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
		return "Gerant [id=" + id + ", prenom=" + prenom + ", nom=" + nom + ", login=" + login + ", password="
				+ password + "]";
	}

}
