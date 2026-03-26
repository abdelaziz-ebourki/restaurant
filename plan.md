🍽️ Projet 10 : Gestion d’un Restaurant — Répartition des 9 Rôles

⸻

👤 Personne 1 — L'Architecte (Configuration du projet)
Le chef d'orchestre. Sans lui, personne ne peut commencer.

Créer le projet sur Spring Initializr (Java 17, Maven).

Ajouter les dépendances dans le pom.xml : Spring Web, Spring Data JPA, H2 Database, Validation, Lombok, Springdoc OpenAPI (Swagger).

Configurer application.properties :

Properties
spring.h2.console.enabled=true
spring.datasource.url=jdbc:h2:mem:restaurantdb
spring.jpa.hibernate.ddl-auto=none
spring.jpa.defer-datasource-initialization=true
spring.jpa.show-sql=true
Créer l'arborescence vide pour l'équipe : model, dao, web.controller, web.exceptions.

Partager le code (GitHub ou Drive) pour que le reste de l'équipe puisse coder.

⸻

👤 Personne 2 — Le Concepteur (Model & Sécurité des données)
Celui qui définit à quoi ressemble un Plat.

Créer la classe Plat.java dans le package model.

Ajouter les annotations JPA : @Entity, @Id, @GeneratedValue(strategy = GenerationType.IDENTITY).

Ajouter la Validation (Exigence du projet) : Mettre @Min(value = 0, message = "Le prix doit être positif") (ou @Positive) sur l'attribut prix.

Ajouter le Filtrage JSON (Exigence du projet) : Mettre @JsonIgnore sur l'attribut coutIngredients pour qu'il n'apparaisse jamais sur internet.

Générer les Getters/Setters/Constructeurs.

⸻

👤 Personne 3 — Le Data Master (Repository & SQL)
Celui qui gère la base de données et la requête métier.

Créer l'interface PlatRepository.java dans le package dao.

Implémenter la requête métier (Exigence du projet) :

Java
List<Plat> findByCaloriesLessThan(int calories);
Créer schema.sql dans src/main/resources pour créer la table plat.

Créer data.sql pour insérer au moins 5 plats de test (ex: Salade avec 200 calories, Burger avec 800 calories) pour que l'équipe puisse tester.

⸻

👤 Personne 4 — Le Contrôleur Principal (POST & GET All)
Celui qui ouvre les premières portes de l'API.

Créer la classe PlatController.java dans web.controller avec @RestController et @RequestMapping("/plats").

Gérer l'injection du Repository via le constructeur (pour les 5 points de propreté).

Créer l'endpoint POST (@PostMapping) pour ajouter un plat. Attention : utiliser @Valid et @RequestBody.

Créer l'endpoint GET (@GetMapping) pour retourner la liste complète List<Plat>.

⸻

👤 Personne 5 — L'Expert Recherche (GET par ID & Recherche Métier)
Celui qui trouve les informations spécifiques.

Travailler dans PlatController.java.

Créer l'endpoint GET par ID : @GetMapping("/{id}"). Si le plat n'existe pas, lancer une ResourceNotFoundException.

Créer l'endpoint GET Healthy (Exigence du projet) : @GetMapping("/healthy"). Utiliser la méthode du Repository pour retourner uniquement les plats de moins de 500 calories.

⸻

👤 Personne 6 — Le Modificateur (PUT)
Celui qui met à jour la carte du restaurant.

Travailler dans PlatController.java.

Créer l'endpoint PUT : @PutMapping("/{id}").

Logique : Chercher le plat par son ID. S'il existe, modifier son nom, calories, prix et coutIngredients avec les nouvelles données envoyées par l'utilisateur, puis faire un .save(). N'oublie pas le @Valid !

⸻

👤 Personne 7 — Le Nettoyeur (DELETE)
Celui qui supprime les plats de la carte.

Travailler dans PlatController.java.

Créer l'endpoint DELETE : @DeleteMapping("/{id}").

Logique : Vérifier si le plat existe. Si oui, .deleteById(id).

Règle REST : Retourner un code HTTP 204 No Content via un ResponseEntity.noContent().build();.

⸻

👤 Personne 8 — Le Bouclier (Gestion des Exceptions)
Celui qui empêche l'application de crasher en affichant de beaux messages d'erreur.

Créer la classe ResourceNotFoundException.java dans web.exceptions.

Créer la classe GlobalExceptionHandler.java avec @ControllerAdvice.

Capturer l'erreur 404 (Plat non trouvé) et renvoyer un JSON propre.

Capturer l'erreur 400 (MethodArgumentNotValidException) si quelqu'un essaie d'envoyer un prix négatif, et renvoyer le message d'erreur.

⸻

👤 Personne 9 — L'Inspecteur Qualité (Swagger & Postman)
Celui qui prouve au professeur que tout fonctionne parfaitement.

Swagger : Ajouter des descriptions propres sur les endpoints du Controller avec des annotations comme @Operation(summary = "Ajouter un nouveau plat").

Vérifier que le Swagger s'affiche bien sur http://localhost:8080/swagger-ui/index.html.

Postman : Créer une collection complète avec :

Un test pour ajouter un plat (Succès).

Un test pour ajouter un plat avec un prix négatif (Vérifier que ça échoue bien).

Un test pour chercher un plat qui n'existe pas (ID 999).

Un test sur /plats/healthy.

Exporter la collection au format JSON pour le dossier final.
