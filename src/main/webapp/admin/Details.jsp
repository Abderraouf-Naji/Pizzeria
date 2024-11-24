<%@ page import="pizzaStore.beans.Commande" %>
<%@ page import="pizzaStore.beans.Pizza" %>
<%@ page import="pizzaStore.beans.Boisson" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Détails de la Commande</title>

    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
            text-align:center;
        }

        h1, h2, h3 {
            color: #333;
        }

        p {
            color: #555;
        }

        ul {
            list-style-type: none;
            padding: 0;
        }

        li {
            margin: 5px 0;
            color: #777;
        }
         table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        th,
        td {
            
            padding: 10px;
            text-align: center;
            border: 1px solid #ddd;
        }

        a {
            display: inline-block;
            margin-top: 20px;
            padding: 10px;
            background-color: #3498db;
            color: white;
            text-decoration: none;
            border-radius: 5px;
            transition: background-color 0.3s;
        }

        a:hover {
            background-color: #2980b9;
        }

        /* Pizza-related colors */
        .pizza {
            color: #e74c3c; /* Red color */
        }

        /* Beverage-related colors */
        .boisson {
            color: #27ae60; /* Green color */
        }
    </style>
</head>
<body>
    <h1>Détails de la Commande</h1>

    <%
        String identifiantParam = request.getParameter("identifiant");
        int orderId = (identifiantParam != null && !identifiantParam.isEmpty()) ? Integer.parseInt(identifiantParam) : 0;
        List<Commande> commandes = (List<Commande>) application.getAttribute("commandes");

        Commande selectedCommande = null;
        for (Commande commande : commandes) {
            if (commande.getIdentifiant() == orderId) {
                selectedCommande = commande;
                break; // Exit the loop once found
            }
        }

        List<Pizza> pizzas = (selectedCommande != null) ? selectedCommande.getListePizzas() : null;
        List<Boisson> boissons = (selectedCommande != null) ? selectedCommande.getListeBoissons() : null;
    %>

    <h2>Client: <%= (selectedCommande != null) ? selectedCommande.getNomClient() + " " + selectedCommande.getPrenomClient() : "" %></h2>
    <p>Adresse: <%= (selectedCommande != null) ? selectedCommande.getAdresseClient() : "" %></p>

    <h3>Pizzas:</h3>
    <table>
        <tr><th>Les Pizzas</th><th>Prix</th><th>Quantité</th></tr>
        <!-- Display selected pizzas -->
        <%
           double totalPizza = 0;
           if (pizzas != null && !pizzas.isEmpty()) {
               for (Pizza pizza : pizzas) {
                   totalPizza += pizza.getPrix() * pizza.getQuantite();
        %>
                   <tr><td><%= pizza.getNom() %>  </td><td> <%= pizza.getPrix() %> TND </td><td> Quantité: <%= pizza.getQuantite() %></td></tr>
        <%
               }
           }
        %>
    </table>

    <h3>Boissons:</h3>
    <table>
        <tr><th>Les Boissons</th><th>Prix</th><th>Quantité</th></tr>
        <!-- Display selected beverages -->
        <%
           double totalBoisson = 0;
           if (boissons != null && !boissons.isEmpty()) {
               for (Boisson boisson : boissons) {
                   totalBoisson += boisson.getPrix() * boisson.getQuantite();
        %>
                   <tr><td><%= boisson.getNom() %> </td><td> <%= boisson.getPrix() %> TND </td><td> Quantité: <%= boisson.getQuantite() %></td></tr>
        <%
               }
           }
        %>
    </table>

    <p>Total: <%= (selectedCommande != null) ? selectedCommande.getPrixTotal() : 0 %> TND</p>

    <a href="Commandes.jsp">Retour aux Commandes</a>
</body>
</html>