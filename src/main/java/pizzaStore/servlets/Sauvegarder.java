package  pizzaStore.servlets;

import  pizzaStore.beans.Commande;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletContext;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/Sauvegarder")
public class Sauvegarder extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ServletContext context = getServletContext();

        List<Commande> commandes = (List<Commande>) getServletContext().getAttribute("commandes");
        
        // Save the list of commandes to the database
        saveCommandesToDatabase(commandes);

        // Clear the list of commandes from the application context
        getServletContext().removeAttribute("commandes");

        // Redirect to a confirmation page or home page
        response.sendRedirect("admin/AdminInterface.html");
    }
        
    private void saveCommandesToDatabase(List<Commande> commandes) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/pizzeria?useSSL=false&serverTimezone=UTC";
        String jdbcUsername = "root";
        String jdbcPassword = "";

        try {
            // Load the MySQL JDBC driver
        	Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection connection = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword)) {
                for (Commande commande : commandes) {
                    String sql = "INSERT INTO Commande (nom, prenom, adresse, prix_total) VALUES (?, ?, ?, ?)";

                    try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                        preparedStatement.setString(1, commande.getNomClient());
                        preparedStatement.setString(2, commande.getPrenomClient());
                        preparedStatement.setString(3, commande.getAdresseClient());
                        preparedStatement.setDouble(4, commande.getPrixTotal());

                        preparedStatement.executeUpdate();
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
        
      
