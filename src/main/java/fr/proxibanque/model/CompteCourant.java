package fr.proxibanque.model;

/**
 * Cette classe d�crit les caract�ristiques d'un compte courant ProxiBanque.
 * Chaque client dispose d'un compte courant g�n�r� automatiquement � la
 * cr�ation client. Une carte bancaire peut �tre associ�e � un compte courant
 * par un conseiller ProxiBanque.
 * 
 * @author Jean-Michel Hiltbrunner, Ozlem Avci
 *
 */

public class CompteCourant extends Compte {

	// *** ATTRIBUTES ***

	public static final double DECOUVERT_MAX = -1000.0;

	// *** CONSTRUCTORS ***

	public CompteCourant() {
		super();
	}

	// TODO L'idClient est-il n�cessaire ? � refactoriser
	public CompteCourant(int numeroCompte, double solde, String dateOuverture) {
		// Le compte courant est cr�� sans carte bancaire par d�faut
		super(numeroCompte, solde, dateOuverture);
	}

}
