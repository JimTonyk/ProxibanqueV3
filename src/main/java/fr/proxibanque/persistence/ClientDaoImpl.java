package fr.proxibanque.persistence;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import fr.proxibanque.model.Client;
import fr.proxibanque.model.CompteCourant;
import fr.proxibanque.model.CompteEpargne;

public class ClientDaoImpl implements ClientDao {

	private ClientDao dao;
	
	public ClientDao getDao() {
		return dao;
	}

	public void setDao(ClientDao dao) {
		this.dao = dao;
	}

	@Override
	public void creerClient(Client client) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-pu");
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();

		

//		CompteCourant compteCourant1 = new CompteCourant();
//		CompteEpargne compteEpargne1 = new CompteEpargne();

		// ajout des comptes au client1
//		client.getComptes().add(compteCourant1);
//		client.getComptes().add(compteEpargne1);

		// client.getComptes().add(compteCourant1);
		// client.getComptes().add(compteEpargne1);

		// ajout du client1 aux comptes=FK
//		compteCourant1.setClient(client);
//		compteEpargne1.setClient(client);

		// compteCourant1.setClient(client);
		// compteEpargne1.setClient(client);

		try {
			txn.begin();
			// em.persist(client);
			em.persist(client);
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

		Client client3 = null;

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-pu");
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();

		try {
			txn.begin();
			client3 = em.find(Client.class, idClient);
			//client3.setNom("Bob");
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
		return client3;

	}

	@Override
	public List<Client> obtenirTousClients() {

		List<Client> client5 = new ArrayList<>();

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-pu");
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();

		try {
			txn.begin();
			TypedQuery<Client> queryClients = em.createQuery("from Client", Client.class);
			client5 = queryClients.getResultList();
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
		return client5;

	}

	@Override
	public void modifierClient(int idClient, Client client) {
		Client client4 = null;

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-pu");
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();

		try {
			txn.begin();
			client4 = em.find(Client.class, 1);
			client4.setVille("Cherbourg");
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
	public void supprimerClient(int idClient) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-pu");
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();

		try {
			txn.begin();
			em.remove(em.find(Client.class, 2));
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
		emf.close();
	}
}
