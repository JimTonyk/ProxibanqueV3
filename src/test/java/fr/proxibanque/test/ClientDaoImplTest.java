package fr.proxibanque.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fr.proxibanque.model.Client;
import fr.proxibanque.persistence.ClientDao;
import fr.proxibanque.persistence.ClientDaoImpl;

public class ClientDaoImplTest {

	ClientDao dao = new ClientDaoImpl();
	
	@Test
	public void clientAjouteALaBaseDeDonnees() {
		Client c1 = new Client(2,"Test","Jean","Avenue essai","75000","Paris","0102030405",null);
		dao.creerClient(c1);
		Client retour = dao.obtenirClient(2);
		boolean test=false;
		if (retour != null)
			test = true;
		assertEquals(true, test);
		
	}
	
	@Test
	public void recupererInformationsClientsAPartirDeSonId() {
		Client client = dao.obtenirClient(1);
		String nom = "Mele";
		assertEquals(client.getNom(), nom);
	}

}
