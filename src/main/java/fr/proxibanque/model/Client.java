package fr.proxibanque.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * Création d'un objet Client pour lui associer dans la suite comptes et cartes
 * 
 * @author Jean-Michel Hiltbrunner et Ozlem Avci
 *
 */

@Entity
@XmlRootElement(name="client")
public class Client {

	// *** ATTRIBUTS ***

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "client_idClient")
	private int idClient;
	private String nom;
	private String prenom;
	private String adresse;
	private String codePostal;
	private String ville;
	private String telephone;

	@OneToMany(mappedBy = "client", cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
	private Set<Compte> comptes = new HashSet<>();

	public void addCompte(Compte compte) {
		comptes.add(compte);
		compte.setClient(this);
	}

	// *** CONSTRUCTEURS ***

	public Client() {
		super();
	}

	public Client(int idClient, String nom, String prenom, String adresse, String codePostal, String ville,
			String telephone, Set<Compte> comptes) {
		super();
		this.idClient = idClient;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.ville = ville;
		this.telephone = telephone;
		this.comptes = comptes;
	}

	// *** GETTERS and SETTERS ***

	public int getIdClient() {
		return idClient;
	}

	@XmlElement(name="id")
	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public String getNom() {
		return nom;
	}

	@XmlElement(name="nom")
	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	@XmlElement(name="prenom")
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	@XmlElement(name="adresse")
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getCodePostal() {
		return codePostal;
	}

	@XmlElement(name="codepostal")
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	@XmlElement(name="ville")
	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getTelephone() {
		return telephone;
	}

	@XmlElement(name="telephone")
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Set<Compte> getComptes() {
		return comptes;
	}

	@XmlElement(name="compte")
	public void setComptes(Set<Compte> comptes) {
		this.comptes = comptes;
	}

	// *** AUTRES METHODES ***

	@Override
	public String toString() {
		return "Client [idClient=" + idClient + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse
				+ ", codePostal=" + codePostal + ", ville=" + ville + ", telephone=" + telephone + ", comptes="
				+ comptes + "]";
	}

}