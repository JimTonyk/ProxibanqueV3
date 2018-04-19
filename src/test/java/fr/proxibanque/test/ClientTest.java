package fr.proxibanque.test;

import fr.proxibanque.model.Client;
import fr.proxibanque.model.Compte;
import fr.proxibanque.model.CompteCourant;
import fr.proxibanque.model.CompteEpargne;
import fr.proxibanque.model.Conseiller;
import fr.proxibanque.persistence.ClientDao;
import fr.proxibanque.persistence.ClientDaoImpl;





public class ClientTest {

	public static void main(String[] args) {
		
		ClientDao clientDao = new ClientDaoImpl();

		Client client1 = new Client(1, "Dupont", "Marc", "5 rue four", "75001", "Paris", "0000000000");
		
		CompteCourant compteCourant1 = new CompteCourant();
		CompteEpargne compteEpargne1 = new CompteEpargne();
//		Conseiller conseiller1 = new Conseiller();
		
		clientDao.creerClient(client1);
		
	}

}
