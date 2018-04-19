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

		Client client1 = new Client(1, "Dupont", "Marc", "5 rue four", "75001", "Paris", "0000000000", null);

		CompteCourant compteCourant1 = new CompteCourant(10, 1000, "01/02/2018", client1);
		CompteEpargne compteEpargne1 = new CompteEpargne(11, 500, "01/03/2017", client1);

		compteDao.creerCompteCourant(compteCourant1);
//		compteDao.creerCompteEpargne(compteEpargne1);
		
		
	
//		clientDao.obtenirClient(1);
//		clientDao.obtenirTousClients();
//		clientDao.modifierClient(1, client1);
//		clientDao.supprimerClient(1);

	}

}
