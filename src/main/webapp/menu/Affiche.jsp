<%@ page import="pizzaStore.beans.Pizza" %>
<%@ page import="pizzaStore.beans.Boisson" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Affiche Commande</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            text-align:center;
        }
        ul {
            list-style-type: none;
            padding: 0;
        }

        li {
            background-color: #eee;
            margin-bottom: 7px;
            padding: 10px;
            text-decoration: none;
        }

        .total {
            background-color: orange;
            color: black;
            padding: 10px;
            margin-top: 20px;
            text-align: center;
        }
         .tot {
            background-color:orange;
            color: black;
            padding: 10px;
            margin-top: 20px;
            text-align: center;
        }
        .form {
            display: inline-block;
            margin-top: 20px;
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
    </style>
</head>
<body>
    <h1>Votre Commande</h1>

<table border="1">
    <tr><th>Les Pizzas</th><th>Prix</th><th>Quantité</th></tr>
        <!-- Display selected pizzas -->
        <% List<pizzaStore.beans.Pizza> pizzas = (List<pizzaStore.beans.Pizza>) session.getAttribute("pizzas");
           double totalPizza = 0;
           if (pizzas != null && !pizzas.isEmpty()) {
               for (pizzaStore.beans.Pizza pizza : pizzas) {
                   totalPizza += pizza.getPrix()*pizza.getQuantite();
               %>
                   <tr><td><%= pizza.getNom() %>  </td><td> <%= pizza.getPrix() %> TND </td><td> Quantité: <%= pizza.getQuantite() %></td></tr>
        <%    }
           } %>
</table>

<table border="1">
    <tr><th>Les Boissons</th><th>Prix</th><th>Quantité</th></tr>
        <!-- Display selected beverages -->
        <% List<pizzaStore.beans.Boisson> boissons = (List<pizzaStore.beans.Boisson>) session.getAttribute("boissons");
       double totalBoisson = 0;
       if (boissons != null && !boissons.isEmpty()) {
           for (pizzaStore.beans.Boisson boisson : boissons) {
               totalBoisson += boisson.getPrix()*boisson.getQuantite();
           %>
                 <tr><td><%= boisson.getNom() %> </td><td> <%= boisson.getPrix() %> TND </td><td> Quantité: <%= boisson.getQuantite() %></td></tr>
    <%    }
       } %>
  </table>
    

    <div class="total">Total à payer : <%= totalPizza + totalBoisson %> TND</div>

    <form action="http://localhost:8080/PizzeriaProject/Supprimer" method="post" class="form">
        <!-- Add form elements for deleting pizzas -->
        <label for="pizzaName">Supprimer Pizza:</label>
        <select name="pizzaName">
            <% if (pizzas != null && !pizzas.isEmpty()) {
                   for (pizzaStore.beans.Pizza pizza : pizzas) { %>
                       <option value="<%= pizza.getNom() %>"><%= pizza.getNom() %></option>
            <%    }
               } %>
        </select>
        <input type="submit" value="Supprimer">
    </form>

    <form action="http://localhost:8080/PizzeriaProject/Supprimer" method="post" class="form">
        <!-- Add form elements for deleting beverages -->
        <label for="boissonName">Supprimer Boisson:</label>
        <select name="boissonName">
            <% if (boissons != null && !boissons.isEmpty()) {
                   for (pizzaStore.beans.Boisson boisson : boissons) { %>
                       <option value="<%= boisson.getNom() %>"><%= boisson.getNom() %></option>
            <%    }
               } %>
        </select>
        <input type="submit" value="Supprimer">
    </form>

   <div class="tot">
    <%
        // Check if both pizza and beverage lists are empty
        boolean isPizzaSelected = pizzas != null && !pizzas.isEmpty();
        boolean isBoissonSelected = boissons != null && !boissons.isEmpty();
        boolean canValidateOrder = isPizzaSelected || isBoissonSelected;

        // Display the "Valider la Commande" button only if at least one item is selected
        if (canValidateOrder) {
    %>
            <a href="Formulaire.html"><button>Valider la Commande</button></a>
    <%
        } else {
    %>
            <p>Veuillez sélectionner au moins une <a href="MenuPizza.html">pizza</a> ou une <a href="MenuBoisson.html">boisson</a> avant de valider la commande.</p>
    <%
        }
    %>
</div>
</body>
</html>