package  pizzaStore.servlets;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pizzaStore.beans.Pizza;
import pizzaStore.beans.Boisson;

@WebServlet("/Supprimer")
public class Supprimer extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve the session
        HttpSession session = request.getSession(false);

        if (session != null) {
            // Get the selected pizza name to be removed
            String pizzaName = request.getParameter("pizzaName");

            // Retrieve the list of pizzas from the session
            List<Pizza> pizzas = (List<Pizza>) session.getAttribute("pizzas");

            if (pizzas != null) {
                // Find and remove the selected pizza from the list
                Iterator<Pizza> iterator = pizzas.iterator();
                while (iterator.hasNext()) {
                    Pizza pizza = iterator.next();
                    if (pizza.getNom().equals(pizzaName)) {
                        iterator.remove();
                        break;
                    }
                }

                // Update the list of pizzas in the session
                session.setAttribute("pizzas", pizzas);
            }
            else {
            	response.sendRedirect("menu/Affiche.jsp");
            }
        }
        
        if (session != null) {
            // Get the selected pizza name to be removed
            String boissonName = request.getParameter("boissonName");

            // Retrieve the list of pizzas from the session
            List<Boisson> boissons = (List<Boisson>) session.getAttribute("boissons");

            if (boissons != null) {
                // Find and remove the selected pizza from the list
                Iterator<Boisson> iterator = boissons.iterator();
                while (iterator.hasNext()) {
                    Boisson boisson = iterator.next();
                    if (boisson.getNom().equals(boissonName)) {
                        iterator.remove();
                        break;
                    }
                }

        // Redirect back to the menu page
        response.sendRedirect("menu/Affiche.jsp");
    }else {
    	response.sendRedirect("menu/Affiche.jsp");
    }
}
	}}
