package fr.proxibanque.service;

import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.proxibanque.model.Client;
import fr.proxibanque.model.CompteCourant;
import fr.proxibanque.model.CompteEpargne;
import fr.proxibanque.persistence.ClientDao;
import fr.proxibanque.persistence.ClientDaoImpl;
import fr.proxibanque.persistence.CompteDao;
import fr.proxibanque.persistence.CompteDaoImpl;

public class ProxibanqueServiceImpl implements ClientService, CompteService {

	private static Logger LOGGER = LoggerFactory.getLogger(ProxibanqueServiceImpl.class);

	ClientDao daoclient = new ClientDaoImpl();
	CompteDao daocompte = new CompteDaoImpl();
	
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
		Response response = null;
		daocompte.creerCompteCourant(compte);
		response = Response.ok().build();
		LOGGER.info("Le compte courant " + compte.getNumeroCompte() + " a été ajouté à la base.");
		return response;
	}

	@Override
	public CompteCourant obtenirCompteCourant(String numeroCompte) {
		int requete = Integer.parseInt(numeroCompte);
		CompteCourant compte = daocompte.obtenirCompteCourant(requete);
		LOGGER.info(
				"Des informations sur le compte courant " + compte.getNumeroCompte() + " ont été demandées.");
		return compte;
	}

	@Override
	public Response modifierCompteCourant(CompteCourant compte) {
		Response response = null;
		CompteCourant modif = daocompte.obtenirCompteCourant(compte.getNumeroCompte());
		if (modif != null) {
			daocompte.modifierCompteCourant(modif.getNumeroCompte());
			response = Response.ok().build();
			LOGGER.info("Des informations sur le compte courant " + modif.getNumeroCompte()
					+ " ont été modifiées.");
		} else {
			response = Response.notModified().build();
			LOGGER.info(
					"Une tentative de modification de compte courant a été réalisée sans succés. La table n'a pas été modifiée");
		}
		return response;
	}

	@Override
	public Response supprimerCompteCourant(CompteCourant numeroCompte) {
		Response response = null;
		CompteCourant modif = daocompte.obtenirCompteCourant(numeroCompte.getNumeroCompte());
		if (modif != null) {
			LOGGER.info("Le compte courant " + numeroCompte.getNumeroCompte()
			+ " a été effacé de la base Proxibanque");
			daocompte.supprimerCompteCourant(modif);;
			response = Response.ok().build();
		} else {
			response = Response.notModified().build();
			LOGGER.info(
					"Une tentative de suppression de compte courant a été réalisée sans succés. La table n'a pas été modifiée");
		}
		return response;
	}

	@Override
	public Response ajouterCompteEpargne(CompteEpargne compte) {
		Response response = null;
		daocompte.creerCompteEpargne(compte);
		response = Response.ok().build();
		LOGGER.info("Le compte épargne " + compte.getNumeroCompte() + " a été ajouté à la base.");
		return response;
	}

	@Override
	public CompteEpargne obtenirCompteEpargne(String numeroCompte) {
		int requete = Integer.parseInt(numeroCompte);
		CompteEpargne compte = daocompte.obtenirCompteEpargne(requete);
		LOGGER.info(
				"Des informations sur le compte courant " + compte.getNumeroCompte() + " ont été demandées.");
		return compte;
	}

	@Override
	public Response modifierCompteEpargne(CompteEpargne compte) {
		Response response = null;
		CompteEpargne modif = daocompte.obtenirCompteEpargne(compte.getNumeroCompte());
		if (modif != null) {
			daocompte.modifierCompteEpargne(modif.getNumeroCompte());
			response = Response.ok().build();
			LOGGER.info("Des informations sur le compte épargne " + modif.getNumeroCompte()
					+ " ont été modifiées.");
		} else {
			response = Response.notModified().build();
			LOGGER.info(
					"Une tentative de modification de compte épargne a été réalisée sans succés. La table n'a pas été modifiée");
		}
		return response;
	}

	@Override
	public Response supprimerCompteEpargne(CompteEpargne numeroCompte) {
		Response response = null;
		CompteEpargne modif = daocompte.obtenirCompteEpargne(numeroCompte.getNumeroCompte());
		if (modif != null) {
			LOGGER.info("Le compte épargne " + modif.getNumeroCompte() + " a été supprimé de la base Proxibanque.");
			daocompte.supprimerCompteEpargne(modif);;
			response = Response.ok().build();
		} else {
			response = Response.notModified().build();
			LOGGER.info(
					"Une tentative de suppression de compte épargne a été réalisée sans succés. La table n'a pas été modifiée");
		}
		return response;
	}

}
