<%@ page import="java.util.List" %>
<%@ page import="pizzaStore.beans.Commande" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Commandes non traitées</title>

    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        h1 {
            text-align: center;
            color: #333;
        }

        table {
            width: 80%;
            margin: 20px auto;
            border-collapse: collapse;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            background-color: #fff;
        }

        th, td {
            padding: 12px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        th {
            background-color: orange;
            color: black;
        }

        tr:hover {
            background-color: #f5f5f5;
        }

        a {
            text-decoration: none;
            color: #007BFF;
        }

        a:hover {
            text-decoration: underline;
        }
        .tot {
            background-color: orange;
            color: black;
            padding: 10px;
            margin-top: 20px;
            text-align: center;
        }
    </style>
</head>
<body>
    <h1>Commandes non traitées</h1>
    <form action="http://localhost:8080/PizzeriaProject/Sauvegarder" method="post">
                    
    <table>
        <tr>
            <th></th>
            <th>Nom</th>
            <th>Prénom</th>
            <th>Adresse</th>
            <th>Prix Total</th>
        </tr>

        <!-- Display the list of non-processed orders -->
        <% List<Commande> commandes = (List<Commande>) application.getAttribute("commandes");
           if (commandes != null) {
               for (Commande commande : commandes) { %>
                   <tr>
                       <td><a href="Details.jsp?identifiant=<%= commande.getIdentifiant() %>">Voir Détails</a></td>
                       <td><%= commande.getNomClient() %></td>
                       <td><%= commande.getPrenomClient() %></td>
                       <td><%= commande.getAdresseClient() %></td>
                       <td><%= commande.getPrixTotal() %> TND</td>
                   </tr>
               <% }
           } %>
    </table>
    <div class="tot">
    <%
        // Check if both pizza and beverage lists are empty
        boolean isCommandeSelected = commandes != null && !commandes.isEmpty();
        boolean canValidateOrder = isCommandeSelected;

        // Display the "Valider la Commande" button only if at least one item is selected
        if (canValidateOrder) {
    %>
           <button types="submit">Sauvegarder</button>
    <%
        } else {
    %>
            <p>Veuillez avoir au moins une <a href="admin/../../menu/MenuPizza.html">Commande</a> pour la sauvegarder.</p>
    <%
        }
    %>
</div>
</form>
</body>
</html>
