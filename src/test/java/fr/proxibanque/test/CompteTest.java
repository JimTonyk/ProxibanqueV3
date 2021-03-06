package fr.proxibanque.test;

import fr.proxibanque.model.Client;
import fr.proxibanque.model.Compte;
import fr.proxibanque.model.CompteCourant;
import fr.proxibanque.model.CompteEpargne;
import fr.proxibanque.model.Conseiller;
import fr.proxibanque.persistence.CompteDao;
import fr.proxibanque.persistence.CompteDaoImpl;

public class CompteTest {

	public static void main(String[] args) {

		CompteDao compteDao = new CompteDaoImpl();

		Client client1 = new Client();
		
		CompteCourant compteCourant1 = new CompteCourant();
		CompteEpargne compteEpargne1 = new CompteEpargne();

		compteDao.creerCompteCourant(compteCourant1);
		compteDao.creerCompteEpargne(compteEpargne1);
		// System.out.println(compteCourant1.getNumeroCompte());

		compteDao.obtenirCompteCourant(1);
		compteDao.obtenirCompteEpargne(1);

		compteDao.modifierCompteCourant(1);
		compteDao.modifierCompteEpargne(1);

		 compteDao.supprimerCompteCourant(compteCourant1);
		 compteDao.supprimerCompteEpargne(compteEpargne1);
	}
}
