package fr.proxibanque.persistence;

import java.util.ArrayList;
import java.util.List;

import fr.proxibanque.model.Client;

/**
 * Cette interface permet de r�aliser les op�rations du CRUD cot� client dans la
 * base de donn�es mySQL
 * 
 * @author Ozlem Avci et Jean-Michel Hiltbrunner
 *
 */
public interface ClientDao {

	/**
	 * Cette m�thode permet d'ajouter un client � la base de donn�es Clients
	 * 
	 * @param client
	 *            Client � persiter dans la base de donn�es
	 */
	void creerClient(Client client);

	/**
	 * Cette m�thode renvoie un client et ses informations associ�es connaissans son
	 * identifiant unique
	 * 
	 * @param idClient
	 *            Identifiant unique du client dont on souhaite obtenir les
	 *            informations
	 * @return Client avec les informations courantes (nom, pr�nom...)
	 */
	Client obtenirClient(int idClient);

	/**
	 * Cette m�thode permet de retourner l'ensemble des clients des banques
	 * Proxibanque
	 * 
	 * @return Arraylist avec l'ensemble des clients et leurs information associ�es
	 */
	ArrayList<Client> obtenirTousClients();

	/**
	 * Cette m�thode permet de modifier les informations sur un client (nom, pr�nom,
	 * adresse...) identifi� par don num�ro d'identification
	 * 
	 * @param idClient
	 *            identifiant unique du client dont on souhaite modifier les donn�es
	 * @param client
	 *            CLient associ� � l'idclient dont les donn�es seront alt�r�es
	 */
	void modifierClient(int idClient, Client client);

	/**
	 * Cette m�thode permet de supprimer un client et l'ensemble de ses comptes
	 * associ�es de l'ensemble des bases de donn�es Proxibanque
	 * 
	 * @param idClient
	 *            identifiant du client dont on souhaite r�aliser la suppression
	 */
	void supprimerClient(int idClient);
}
