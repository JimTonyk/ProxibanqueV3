package fr.proxibanque.service;


import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.proxibanque.model.Client;
import fr.proxibanque.model.CompteCourant;
import fr.proxibanque.model.CompteEpargne;
import fr.proxibanque.persistence.ClientDao;
import fr.proxibanque.persistence.ClientDaoImpl;

public class ProxibanqueServiceImpl implements ClientService, CompteService {

	private static Logger LOGGER = LoggerFactory.getLogger(ProxibanqueServiceImpl.class);

	ClientDao daoclient = new ClientDaoImpl();
	
	public ProxibanqueServiceImpl() {
		initialisation();
	}

	final void initialisation() {
		Client client = new Client();
		client.setNom("Mele");
		client.setPrenom("Jean");
		client.setAdresse("5 Villa Lourcine");
		client.setVille("Paris");
		client.setCodePostal("75014");
		client.setTelephone("0102030405");
		ajouterClient(client);
	}

	@Override
	public Response ajouterClient(Client client) {
		Response response = null;
		daoclient.creerClient(client);
		response = Response.ok().build();
		LOGGER.info("Le client " + client.getPrenom() + " " + client.getNom() + " a été ajouté à la liste");
		return response;
	}

	@Override
	public Client obtenirClient(String id) {
		int requete = Integer.parseInt(id);
		Client choix = daoclient.obtenirClient(requete);
		LOGGER.info(
				"Des informations sur le client " + choix.getPrenom() + " " + choix.getNom() + " ont été demandées.");
		return choix;
	}

	@Override
	public Response modifierClient(int idClient, Client client) {
		Response response = null;
		Client modif = daoclient.obtenirClient(idClient);
		if (modif != null) {
			daoclient.modifierClient(idClient, client);
			response = Response.ok().build();
			LOGGER.info("Des informations sur le client " + client.getPrenom() + " " + client.getNom()
					+ " ont été modifiées.");
		} else {
			response = Response.notModified().build();
			LOGGER.info(
					"Une tentative de modification de client a été réalisée sans succés. La table n'a pas été modifiée");
		}
		return response;
	}

	@Override
	public Response supprimerClient(String id) {
		Response response = null;
		int requete = Integer.parseInt(id);
		Client client = daoclient.obtenirClient(requete);
		if (client != null) {
			LOGGER.info(
					"Le client " + client.getPrenom() + " " + client.getNom() + " a été supprimé de la base clients");
			daoclient.supprimerClient(requete);
			response = Response.ok().build();
		} else
			response = Response.notModified().build();
		LOGGER.info("Une tentative de suppression de client a été réalisée sans succés. La table n'a pas été modifiée");
		return response;
	}

	@Override
	public Response ajouterCompteCourant(CompteCourant compte) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CompteCourant obtenirCompteCourant(String numeroCompte) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response modifierCompteCourant(CompteCourant compte) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response supprimerCompteCourant(CompteCourant numeroCompte) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response ajouterCompteEpargne(CompteEpargne compte) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CompteCourant obtenirCompteEpargne(String numeroCompte) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response modifierCompteEpargne(CompteEpargne compte) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response supprimerCompteEpargne(CompteEpargne numeroCompte) {
		// TODO Auto-generated method stub
		return null;
	}

}
