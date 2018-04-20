package fr.proxibanque.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fr.proxibanque.model.Client;
import fr.proxibanque.model.Compte;
import fr.proxibanque.model.CompteCourant;
import fr.proxibanque.model.CompteEpargne;

public class CompteDaoImpl implements CompteDao {

	@Override
	public void creerCompteCourant(CompteCourant compteCourant) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-pu");
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();

		CompteCourant compteCourant1 = new CompteCourant();

		try {
			txn.begin();
			em.persist(compteCourant1);
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
	public void creerCompteEpargne(CompteEpargne compteEpargne) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-pu");
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();

		CompteEpargne compteEpargne1 = new CompteEpargne();

		try {
			txn.begin();
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
	public CompteCourant obtenirCompteCourant(int idClient) {

		Client client3 = null;
		CompteCourant compteCourant3 = null;

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-pu");
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();

		try {
			txn.begin();
//			compteCourant3.getClient();
			compteCourant3 = em.find(CompteCourant.class, 2);
			compteCourant3.setSolde(50.0);;
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
		return compteCourant3;
	}

	@Override
	public CompteEpargne obtenirCompteEpargne(int idClient) {
		Client client3 = null;
		CompteEpargne compteEpargne3 = null;

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-pu");
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();

		try {
			txn.begin();
//			compteEpargne3.getClient();
			compteEpargne3 = em.find(CompteEpargne.class, 1);
			compteEpargne3.setSolde(100.0);;
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
		return compteEpargne3;
	}

	@Override
	public void modifierCompteCourant(int idClient) {
		Client client4 = null;
		CompteCourant compteCourant3 = null;
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-pu");
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();

		try {
			txn.begin();
			compteCourant3 = em.find(CompteCourant.class, 2);
			compteCourant3.setDateOuverture("01/02/2017");
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
	public void modifierCompteEpargne(int idClient, CompteEpargne compteEpargne) {
		// TODO Auto-generated method stub

	}

	@Override
	public void supprimerCompteCourant(CompteCourant compteCourant) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-pu");
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();

		try {
			txn.begin();
			em.remove(em.find(CompteCourant.class, 2));
			// em.remove(em.find(CompteCourant.class, compteCourant.getNumeroCompte()));
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
	public void supprimerCompteEpargne(CompteEpargne compteEpargne) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-pu");
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();

		try {
			txn.begin();
			em.remove(em.find(CompteEpargne.class, 1));
			// em.remove(em.find(CompteEpargne.class, compteEpargne.getNumeroCompte()));
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
