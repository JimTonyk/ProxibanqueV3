package fr.proxibanque.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fr.proxibanque.model.Client;
import fr.proxibanque.model.CompteCourant;
import fr.proxibanque.model.CompteEpargne;

public class ClientDaoImpl implements ClientDao {

	@Override
	public void creerClient(Client client) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-pu");
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();

		Client client1 = new Client();
		Client client2 = new Client();

		CompteCourant compteCourant1 = new CompteCourant();
		CompteEpargne compteEpargne1 = new CompteEpargne();

		try {
			txn.begin();
			em.persist(client1);
			em.persist(client2);
			em.persist(compteCourant1);
			em.persist(compteEpargne1);
			txn.commit();

		} catch (Exception e) {
			if (txn != null) {
				txn.rollback();
			}
			e.printStackTrace();

		} finally {
			if (em != null) {
				em.close();
			}
		}

	}

	@Override
	public Client obtenirClient(int idClient) {
		//
		Client client1 = new Client();

		CompteCourant compteCourant1 = new CompteCourant();
		CompteEpargne compteEpargne1 = new CompteEpargne();

		// // ajout des comptes au client1
		client1.getComptes().add(compteCourant1);
		client1.getComptes().add(compteCourant1);

		// // ajout du client1 aux comptes=FK
		compteCourant1.setClient(client1);
		compteEpargne1.setClient(client1);

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-pu");
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();

		try {
			txn.begin();
			em.persist(client1);
			txn.commit();

		} catch (Exception e) {
			if (txn != null) {
				txn.rollback();
			}
			e.printStackTrace();

		} finally {
			if (em != null) {
				em.close();
				emf.close();
			}
		}
		return client1;
	}

	@Override
	public List<Client> obtenirTousClients() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modifierClient(int idClient, Client client) {
		// TODO Auto-generated method stub

	}

	@Override
	public void supprimerClient(int idClient) {
		// TODO Auto-generated method stub

	}

}