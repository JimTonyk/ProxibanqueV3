package fr.proxibanque.service;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import fr.proxibanque.model.Client;

/**
 * Cette interface permet de r�aliser les op�rations du CRUD aussi bien dans la
 * base de donn�es que dans le WebService Proxibanque
 * 
 * @author Avci et Jean-Michel Hiltbrunner
 *
 */
@Produces({ "application/xml", "application/json" })
public interface ClientService {

	/**
	 * Cette m�thode permet d'ajouter un client � la bases de donn�es et au
	 * WebService Proxibanque
	 * 
	 * @param client
	 *            Client � ajouter dans les domaines Proxibanques
	 * @return Requ�te HTTP 200 confirmant l'ajout du client � la base
	 */
	@POST
	@Path("/Clients/")
	Response ajouterClient(Client client);

	/**
	 * Cette m�thode permet d'obtenir un client ainsi que ses comptes courants et
	 * �pargne � partir de son identifiant unique
	 * 
	 * @param id
	 *            Identifiant unique du client (assimilable � son num�ro de compte)
	 * @return Client identifi� � partir de son num�ro de client
	 */
	@GET
	@Path("/Clients/{idClient}")
	Client obtenirClient(@PathParam("idClient") String id);

	/**
	 * Cette m�thode permet de modifier les donn�es d'un client (son adresse, ville
	 * et code Postal voire le nom et le pr�nom en cas de coquille lors de la
	 * saisie)
	 * 
	 * @param idClient
	 *            Identifiant unique du client dont on souhaite modifier les donn�es
	 * @param client
	 *            Client dont on souhaite modifier les donn�es
	 * @return Requ�te HTTP 200 si les informations ont bien �t� modifi�es ou 304 si
	 *         le client n'existe pas et/ou aucune information modif�e dans la base
	 *         de donn�es (cas du rollback)
	 */
	@PUT
	@Path("/Clients/")
	Response modifierClient(int idClient, Client client);

	/**
	 * Cette m�thode permet de supprimer un client ainsi que l'ensemble de ses
	 * comptes des bases de stockage Proxibanque
	 * 
	 * @param id
	 *            Identifiant unique du client � supprimer
	 * @return Requ�te HTTP 200 si le client a bien �t� supprim� ou 304 si le client
	 *         n'existe pas ou n'a pas �t� supprim� pour cause de rollback de la
	 *         BDD.
	 */
	@DELETE
	@Path("/Clients/{idClient}")
	Response supprimerClient(@PathParam("idClient") String id);

}
