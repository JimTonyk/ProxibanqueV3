package fr.proxibanque.model;

/**
 * Une agence ProxiBanque, disposant d'un gérant unique.
 * 
 * @author Jean-Michel Hiltbrunner, Ozlem Avci
 *
 */

public class Agence {

	// *** ATTRIBUTES ***

	private String id;
	private String dateCreation;
	private Gerant gerant;

	// *** CONSTRUCTORS ***

	public Agence(String id, String dateCreation, Gerant gerant) {
		this.id = id;
		this.dateCreation = dateCreation;
		this.gerant = gerant;
	}

	public String toString() {
		return "Agence " + id + " créée le : " + dateCreation + ", \nGérant :\n" + gerant.toString();
	}

}