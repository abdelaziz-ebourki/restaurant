# Projet Micro-Service: Gestion de Restaurant

Ce projet implémente un microservice RESTful pour la gestion de la carte d'un restaurant, développé dans le cadre du module "Micro-Services". L'objectif est de démontrer la maîtrise des architectures microservices et de l'écosystème Spring Boot.

## Fonctionnalités (API REST)

Le microservice expose une API RESTful pour gérer les plats, incluant les opérations suivantes :

- **Création de plat** (`POST /api/v1/plats`) : Ajouter un nouveau plat avec validation des données.
- **Consultation de tous les plats** (`GET /api/v1/plats`) : Récupérer la liste complète des plats.
- **Consultation d'un plat par ID** (`GET /api/v1/plats/{id}`) : Obtenir les détails d'un plat spécifique.
- **Mise à jour de plat** (`PUT /api/v1/plats/{id}`) : Modifier un plat existant.
- **Suppression de plat** (`DELETE /api/v1/plats/{id}`) : Supprimer un plat.
- **Filtre "Healthy"** (`GET /api/v1/plats/healthy`) : Récupérer les plats ayant moins de 500 calories.

## Technologies Utilisées

- **Spring Boot** : Framework pour le développement d'applications Java autonomes et robustes.
- **Spring Data JPA** : Simplifie l'implémentation de la couche de persistance.
- **H2 Database** : Base de données en mémoire pour un développement et des tests rapides.
- **Maven** : Outil de gestion de projet et de dépendances.
- **Lombok** : Réduit le code répétitif (getters, setters, constructeurs).
- **Jakarta Validation (Bean Validation)** : Validation des données en entrée.
- **Jackson** : Gestion de la sérialisation/désérialisation JSON (incluant le filtrage de propriétés).
- **Springdoc OpenAPI (Swagger UI)** : Génération automatique de la documentation interactive de l'API.
- **Git/GitHub** : Versionnement du code et collaboration.

## Architecture

Le microservice suit une architecture modulaire avec une séparation claire des préoccupations (Contrôleurs, Services, DAO, Modèles, Exceptions). Il est conçu pour être résilient, avec une gestion globale des exceptions et une conformité aux codes de statut HTTP REST.

## Comment Lancer le Projet

### Prérequis

- Java 17 ou version ultérieure.
- Maven 3.6.x ou version ultérieure.

### Étapes

1.  **Cloner le dépôt :**

    ```bash
    git clone https://github.com/votre-utilisateur/restaurant.git
    cd restaurant
    ```

2.  **Construire le projet :**

    ```bash
    mvn clean install
    ```

3.  **Lancer l'application :**
    ```bash
    mvn spring-boot:run
    ```

L'application démarrera sur `http://localhost:8080`.

## Accès aux Interfaces

- **API Documentation (Swagger UI)** : `http://localhost:8080/swagger-ui.html` ou `http://localhost:8080/swagger-ui/index.html`
- **Console H2 (Base de données en mémoire)** : `http://localhost:8080/h2-console` (Utilisateur: `sa`, Mot de passe: vide)

## Structure du Projet

Le projet est organisé selon les conventions de Spring Boot, avec des packages dédiés pour les modèles (`model`), la couche d'accès aux données (`dao`), la logique métier (`service`), et la couche web (`web`).
