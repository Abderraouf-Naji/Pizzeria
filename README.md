Pizza Store Management System
Description
Le système de gestion des commandes de pizzeria est une application web dynamique qui permet aux clients de commander des pizzas et des boissons, et aux administrateurs de suivre et de gérer les commandes. Ce projet utilise des technologies modernes pour offrir une expérience utilisateur conviviale et efficace.

Fonctionnalités principales
Clients :
Passer des commandes en ligne pour des pizzas et des boissons.
Consulter les détails de la commande avant validation.
Administrateurs :
Visualiser les commandes en attente.
Consulter les détails d'une commande spécifique.


Architecture du projet
Backend
Langage : Java
Serveur d'application : Apache Tomcat
Frameworks utilisés : JSP, Servlets
Gestion des données : Attributs d'application pour stocker les commandes temporairement.
Frontend
Technologies : HTML5, CSS3
Style : Palette de couleurs évoquant une pizzeria :
Rouge pour les pizzas
Vert pour les boissons
Bleu pour les boutons d'action
Composants principaux :
Formulaire de commande
Liste des commandes non traitées
Vue des détails d'une commande


Installation
Clonez ce dépôt sur votre machine locale :
git clone https://github.com:Abderraouf-Naji/Pizzeria.git
Importez le projet dans votre IDE (Eclipse, IntelliJ, etc.).
Déployez le projet sur un serveur Tomcat.
Accédez à l'application via un navigateur à l'adresse :
http://localhost:8080/PizzeriaProject


Utilisation
Client :
Accédez à la page de commande (Formulaire.html).
Remplissez les informations personnelles et sélectionnez vos produits.
Validez la commande.
Administrateur :
Accédez à la page des commandes (Commandes.jsp).
Consultez les commandes non traitées et leurs détails (Details.jsp).


Structure des fichiers
📂 src/
├── 📂 pizzaStore.beans/
│   ├── Commande.java  # Classe représentant une commande
│   ├── Pizza.java     # Classe représentant une pizza
│   ├── Boisson.java   # Classe représentant une boisson
├── 📂 WEB-INF/
│   ├── web.xml        # Configuration du projet
├── 📂 pages/
│   ├── Formulaire.html
│   ├── Commandes.jsp
│   ├── Details.jsp
Exemples de données
Commande d'exemple
Nom : Naji
Prénom : Abderraouf
Adresse : Sfax
Pizzas :
  - Margherita - 8 €
  - Pepperoni - 10 €
Boissons :
  - Coca-Cola - 3 €
  - Eau minérale - 2 €
Total : 23 €

Améliorations futures
Gestion des utilisateurs (authentification et autorisations).
Ajout de fonctionnalités pour modifier ou annuler des commandes.
Responsive design pour une meilleure expérience mobile.

Contributeurs
Naji Abderraouf
Développement backend, conception du frontend, intégration.

Licence
Ce projet est sous licence MIT. Vous êtes libre de l'utiliser et de le modifier selon vos besoins.

Avec ce README, votre projet est bien documenté et facile à comprendre pour les collaborateurs ou les utilisateurs potentiels.
