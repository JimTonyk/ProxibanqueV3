package fr.proxibanque.persistence;

import java.util.ArrayList;
import java.util.List;

import fr.proxibanque.model.Client;

/**
 * Cette interface permet de réaliser les opérations du CRUD coté client dans la
 * base de données mySQL
 * 
 * @author Ozlem Avci et Jean-Michel Hiltbrunner
 *
 */
public interface ClientDao {

	/**
	 * Cette méthode permet d'ajouter un client à la base de données Clients
	 * 
	 * @param client
	 *            Client à persiter dans la base de données
	 */
	void creerClient(Client client);

	/**
	 * Cette méthode renvoie un client et ses informations associées connaissans son
	 * identifiant unique
	 * 
	 * @param idClient
	 *            Identifiant unique du client dont on souhaite obtenir les
	 *            informations
	 * @return Client avec les informations courantes (nom, prénom...)
	 */
	Client obtenirClient(int idClient);

	/**
	 * Cette méthode permet de retourner l'ensemble des clients des banques
	 * Proxibanque
	 * 
	 * @return Arraylist avec l'ensemble des clients et leurs information associées
	 */
	ArrayList<Client> obtenirTousClients();

	/**
	 * Cette méthode permet de modifier les informations sur un client (nom, prénom,
	 * adresse...) identifié par don numéro d'identification
	 * 
	 * @param idClient
	 *            identifiant unique du client dont on souhaite modifier les données
	 * @param client
	 *            CLient associé à l'idclient dont les données seront altérées
	 */
	void modifierClient(int idClient, Client client);

	/**
	 * Cette méthode permet de supprimer un client et l'ensemble de ses comptes
	 * associées de l'ensemble des bases de données Proxibanque
	 * 
	 * @param idClient
	 *            identifiant du client dont on souhaite réaliser la suppression
	 */
	void supprimerClient(int idClient);
}
