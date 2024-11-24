package  pizzaStore.servlets;

import  pizzaStore.beans.Pizza;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import  pizzaStore.beans.Boisson;
import  pizzaStore.beans.Commande;

@WebServlet("/Commander")
public class Commander extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve the session
        HttpSession session = request.getSession(false);

        if (session != null) {
            // Retrieve client information from the request
            String nomClient = request.getParameter("nomClient");
            String prenomClient = request.getParameter("prenomClient");
            String adresseClient = request.getParameter("adresseClient");

            // Retrieve the list of pizzas and beverages from the session
            List<Pizza> pizzas = (List<Pizza>) session.getAttribute("pizzas");
            List<Boisson> boissons = (List<Boisson>) session.getAttribute("boissons");

            // Calculate the total price of the order
            double prixTotal = calculateTotalPrice(pizzas, boissons);

            // Create a new Commande object
            Commande commande = new Commande();
            commande.setNomClient(nomClient);
            commande.setPrenomClient(prenomClient);
            commande.setAdresseClient(adresseClient);
            commande.setListePizzas(pizzas);
            commande.setListeBoissons(boissons);
            commande.setPrixTotal(prixTotal);

            // Retrieve the list of commandes from the application context
            ServletContext context = getServletContext();
            List<Commande> commandes = (List<Commande>) context.getAttribute("commandes");

            if (commandes == null) {
                // If the list doesn't exist, create a new one
                commandes = new ArrayList<>();
            }

            // Add the new Commande object to the list
            commandes.add(commande);

            // Update the list of commandes in the application context
            context.setAttribute("commandes", commandes);

            // Clear the session (optional, depending on your application logic)
            session.invalidate();
        }

        // Redirect to a confirmation page or home page
        response.sendRedirect("admin/Commandes.jsp");
    }

    
    
    private double calculateTotalPrice(List<Pizza> pizzas, List<Boisson> boissons) {
        double totalPrixPizzas = 0.0;
        double totalPrixBoissons = 0.0;

        // Check if pizzas list is not null before processing
        if (pizzas != null) {
            totalPrixPizzas = pizzas.stream().mapToDouble(pizza -> pizza.getPrix() * pizza.getQuantite()).sum();
        }

        // Check if boissons list is not null before processing
        if (boissons != null) {
            totalPrixBoissons = boissons.stream().mapToDouble(boisson -> boisson.getPrix() * boisson.getQuantite()).sum();
        }

        return totalPrixPizzas + totalPrixBoissons;
    }
	
}
