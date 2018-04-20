package fr.proxibanque.persistence;

import java.util.ArrayList;
import java.util.List;

import fr.proxibanque.model.Client;

public interface ClientDao {

	void creerClient(Client client);
	
	Client obtenirClient(int idClient);

	ArrayList<Client> obtenirTousClients();

	void modifierClient(int idClient, Client client);

	void supprimerClient(int idClient);
}
