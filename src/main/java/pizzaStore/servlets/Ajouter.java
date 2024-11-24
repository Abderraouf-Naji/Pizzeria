package pizzaStore.servlets;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import pizzaStore.beans.Boisson;
import pizzaStore.beans.Pizza;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@WebServlet("/Ajouter")
public class Ajouter extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);

        String[] selectedPizzas = request.getParameterValues("pizza");
        if (selectedPizzas != null && selectedPizzas.length > 0) {
            for (String pizza : selectedPizzas) {
                switch (pizza) {
                    case "Margherita":
                        addPizzaToSession(session, "Margherita", 22.99, 1); // Modify parameters as needed
                        break;
                    case "Pepperoni":
                        addPizzaToSession(session, "Pepperoni", 18.99, 1); // Modify parameters as needed
                        break;
                    case "Vegetarian":
                        addPizzaToSession(session, "Vegetarian", 26.99, 1); // Modify parameters as needed
                        break;
                    case "Hawaienne":
                        addPizzaToSession(session, "Hawaienne", 20.99, 1); // Modify parameters as needed
                        break;
                    case "Quatre fromages ":
                        addPizzaToSession(session, "Quatre fromages", 22.99, 1); // Modify parameters as needed
                        break;
                    case "Calzone":
                        addPizzaToSession(session, "Calzone", 18.99, 1); // Modify parameters as needed
                        break;
                    // Add cases for other pizza types if needed
                    default:
                        // Handle unknown pizza type, if necessary
                        break;
                }
            }
            response.sendRedirect("menu/MenuPizza.html"); // Redirect to MenuPizza.html after processing pizzas
        }
        
        String[] selectedBeverages = request.getParameterValues("boisson");
        if (selectedBeverages != null && selectedBeverages.length > 0) {
            for (String beverage : selectedBeverages) {
                switch (beverage) {
                    case "Coca-Cola":
                        addBoissonToSession(session, "Coca-Cola", 12.00,1);
                        break;
                    case "Sprite":
                        addBoissonToSession(session, "Sprite", 12.00, 1);
                        break;
                    case "EauMinerale":
                        addBoissonToSession(session, "EauMinerale", 12.00, 1);
                        break;
                    case "IceCoffee":
                        addBoissonToSession(session, "IceCoffee", 15.00, 1);
                        break;
                    case "Soda":
                        addBoissonToSession(session, "Soda", 10.00, 1);
                        break;
                    case "JusOrange":
                        addBoissonToSession(session, "JusOrange", 8.00, 1);
                        break;
                    case "Limonade":
                        addBoissonToSession(session, "Limonade", 10.00, 1);
                        break;
                    case "Cappuccino":
                        addBoissonToSession(session, "Cappuccino", 10.00, 1);
                        break;
                    // Add cases for other beverage types if needed
                    default:
                        // Handle unknown beverage type, if necessary
                        break;
                }
            }
            response.sendRedirect("menu/MenuBoisson.html");
        }
        
	}
        

    private void addPizzaToSession(HttpSession session, String nom, double prix, int quantite) {
        List<Pizza> pizzas = (List<Pizza>) session.getAttribute("pizzas");
        if (pizzas != null) {
            for (Pizza pizza : pizzas) {
                if (pizza.getNom().equals(nom)) {
                    // Update quantity and price of existing pizza
                    pizza.setQuantite(pizza.getQuantite() + quantite);
                    pizza.setPrix(prix);
                    return;
                }
            }
        }
        // Add new pizza if it doesn't already exist
        Pizza newPizza = new Pizza(nom, prix, quantite);
        if (pizzas == null) {
            pizzas = new ArrayList<>();
        }
        pizzas.add(newPizza);
        session.setAttribute("pizzas", pizzas);
    }

    private void addBoissonToSession(HttpSession session, String nom, double prix, int quantite) {
        List<Boisson> boissons = (List<Boisson>) session.getAttribute("boissons");
        if (boissons != null) {
            for (Boisson boisson : boissons) {
                if (boisson.getNom().equals(nom)) {
                    // Update quantity and price of existing beverage
                    boisson.setQuantite(boisson.getQuantite() + quantite);
                    boisson.setPrix(prix);
                    return;
                }
            }
        }
        // Add new beverage if it doesn't already exist
        Boisson newBoisson = new Boisson(nom, prix, quantite);
        if (boissons == null) {
            boissons = new ArrayList<>();
        }
        boissons.add(newBoisson);
        session.setAttribute("boissons", boissons);
    }
}