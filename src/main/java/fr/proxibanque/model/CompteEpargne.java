package fr.proxibanque.model;

import javax.persistence.Entity;

/**
 * Cette classe d�crit les caract�ristiques d'un compte �pargne ProxiBanque.
 * Chaque client peut disposer d'un compte �pargne apr�s ajout explicite par un
 * conseiller. Aucune carte bancaire n'est associ�e � un compte �pargne.
 * 
 * @author Jean-Michel Hiltbrunner, Ozlem Avci
 *
 */

@Entity
public class CompteEpargne extends Compte {

	// *** ATTRIBUTES ***

	// TODO Le taux n'est pas utilis� dans ProxiBanqueSI
	private double tauxRemun = 3.0;

	// *** CONSTRUCTORS ***

	public CompteEpargne() {
		super();
	}

	public CompteEpargne(int numeroCompte, double solde, String dateOuverture, Client client) {
		super(numeroCompte, solde, dateOuverture, client);
	}

	// *** GETTERS and SETTERS ***

	public double getTauxRemun() {
		return tauxRemun;
	}

	public void setTauxRemun(double tauxRemun) {
		this.tauxRemun = tauxRemun;
	}

}
