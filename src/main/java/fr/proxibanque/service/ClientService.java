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
 * Cette interface permet de réaliser les opérations du CRUD aussi bien dans la
 * base de données que dans le WebService Proxibanque
 * 
 * @author Avci et Jean-Michel Hiltbrunner
 *
 */
@Produces({ "application/xml", "application/json" })
public interface ClientService {

	/**
	 * Cette méthode permet d'ajouter un client à la bases de données et au
	 * WebService Proxibanque
	 * 
	 * @param client
	 *            Client à ajouter dans les domaines Proxibanques
	 * @return Requête HTTP 200 confirmant l'ajout du client à la base
	 */
	@POST
	@Path("/Clients/")
	Response ajouterClient(Client client);

	/**
	 * Cette méthode permet d'obtenir un client ainsi que ses comptes courants et
	 * épargne à partir de son identifiant unique
	 * 
	 * @param id
	 *            Identifiant unique du client (assimilable à son numéro de compte)
	 * @return Client identifié à partir de son numéro de client
	 */
	@GET
	@Path("/Clients/{idClient}")
	Client obtenirClient(@PathParam("idClient") String id);

	/**
	 * Cette méthode permet de modifier les données d'un client (son adresse, ville
	 * et code Postal voire le nom et le prénom en cas de coquille lors de la
	 * saisie)
	 * 
	 * @param idClient
	 *            Identifiant unique du client dont on souhaite modifier les données
	 * @param client
	 *            Client dont on souhaite modifier les données
	 * @return Requête HTTP 200 si les informations ont bien été modifiées ou 304 si
	 *         le client n'existe pas et/ou aucune information modifée dans la base
	 *         de données (cas du rollback)
	 */
	@PUT
	@Path("/Clients/")
	Response modifierClient(int idClient, Client client);

	/**
	 * Cette méthode permet de supprimer un client ainsi que l'ensemble de ses
	 * comptes des bases de stockage Proxibanque
	 * 
	 * @param id
	 *            Identifiant unique du client à supprimer
	 * @return Requête HTTP 200 si le client a bien été supprimé ou 304 si le client
	 *         n'existe pas ou n'a pas été supprimé pour cause de rollback de la
	 *         BDD.
	 */
	@DELETE
	@Path("/Clients/{idClient}")
	Response supprimerClient(@PathParam("idClient") String id);

}
