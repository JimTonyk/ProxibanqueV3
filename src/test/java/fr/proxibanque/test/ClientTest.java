package fr.proxibanque.test;

import fr.proxibanque.model.Client;

import fr.proxibanque.model.CompteCourant;
import fr.proxibanque.model.CompteEpargne;

import fr.proxibanque.persistence.ClientDao;
import fr.proxibanque.persistence.ClientDaoImpl;

public class ClientTest {

	public static void main(String[] args) {

		ClientDao clientDao = new ClientDaoImpl();

		Client client1 = new Client();
		// Client client2 = new Client();
		// Client client3 = new Client(3, "cccc", "dd", "25 godre", "75003", "Pool",
		// "2222222222", null);

		CompteCourant compteCourant1 = new CompteCourant();
		CompteEpargne compteEpargne1 = new CompteEpargne();
		// CompteCourant compteCourant1 = new CompteCourant(10, 100.0, "01/02/2016",
		// client1);
		// CompteEpargne compteEpargne1 = new CompteEpargne(11, 200.0, "30/03/2017",
		// client1);

		clientDao.creerClient(client1);

		clientDao.obtenirClient(1);
		// clientDao.obtenirTousClients();

		clientDao.modifierClient(1, client1);

		clientDao.supprimerClient(1);
	}
}
