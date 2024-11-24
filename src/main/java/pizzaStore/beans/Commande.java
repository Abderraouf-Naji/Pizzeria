package pizzaStore.beans;

import java.util.List;

public class Commande {
	private static int counter = 1;
    private int identifiant;
    private String nomClient;
    private String prenomClient;
    private String adresseClient;
    private List<Pizza> listePizzas;
    private List<Boisson> listeBoissons;
    private double prixTotal;

    public Commande() {
        this.identifiant = counter++;
    }

    // Getters and setters
    public int getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(int identifiant) {
        this.identifiant = identifiant;
    }

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public String getPrenomClient() {
        return prenomClient;
    }

    public void setPrenomClient(String prenomClient) {
        this.prenomClient = prenomClient;
    }

    public String getAdresseClient() {
        return adresseClient;
    }

    public void setAdresseClient(String adresseClient) {
        this.adresseClient = adresseClient;
    }

    public List<Pizza> getListePizzas() {
        return listePizzas;
    }

    public void setListePizzas(List<Pizza> listePizzas) {
        this.listePizzas = listePizzas;
    }

    public List<Boisson> getListeBoissons() {
        return listeBoissons;
    }

    public void setListeBoissons(List<Boisson> listeBoissons) {
        this.listeBoissons = listeBoissons;
    }

    public double getPrixTotal() {
        return prixTotal;
    }

    public void setPrixTotal(double prixTotal) {
        this.prixTotal = prixTotal;
    }
}
