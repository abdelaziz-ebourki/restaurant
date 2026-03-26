package com.restaurant.restaurant.web.controller;

import com.restaurant.restaurant.dao.PlatRepository;
import com.restaurant.restaurant.model.Plat;
import com.restaurant.restaurant.web.exceptions.ResourceNotFoundException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plats")
@Tag(name = "API Restaurant", description = "Gestion complète de la carte du restaurant (Plats, Calories, Prix)")
public class PlatController {

    private final PlatRepository platRepository;

    public PlatController(PlatRepository platRepository) {
        this.platRepository = platRepository;
    }

    @Operation(summary = "Récupérer tous les plats", description = "Retourne la liste complète des plats disponibles sur la carte.")
    @GetMapping
    public List<Plat> listePlats() {
        return platRepository.findAll();
    }

    @Operation(summary = "Trouver un plat par ID", description = "Recherche un plat spécifique via son identifiant unique. Renvoie une erreur 404 si l'ID n'existe pas.")
    @GetMapping("/{id}")
    public Plat getPlatById(@PathVariable Long id) {
        return platRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Plat non trouvé avec id : " + id));
    }

    @Operation(summary = "Menu Healthy", description = "Retourne uniquement les plats ayant moins de 500 calories. (Exigence Projet 10)")
    @GetMapping("/healthy")
    public List<Plat> getPlatsHealthy() {
        return platRepository.findByCaloriesLessThan(500);
    }

    @Operation(summary = "Ajouter un nouveau plat", description = "Enregistre un nouveau plat dans la base de données. Le prix doit être positif.")
    @PostMapping
    public ResponseEntity<Plat> ajouterPlat(@Valid @RequestBody Plat plat) {
        Plat platAjoute = platRepository.save(plat);
        return new ResponseEntity<>(platAjoute, HttpStatus.CREATED);
    }

    @Operation(summary = "Mettre à jour un plat", description = "Modifie les informations d'un plat existant identifié par son ID.")
    @PutMapping("/{id}")
    public ResponseEntity<Plat> modifierPlat(@PathVariable Long id, @Valid @RequestBody Plat platDetails) {
        Plat plat = platRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Plat non trouvé avec id : " + id));

        plat.setNom(platDetails.getNom());
        plat.setCalories(platDetails.getCalories());
        plat.setPrix(platDetails.getPrix());
        plat.setCoutIngredients(platDetails.getCoutIngredients());

        final Plat updatedPlat = platRepository.save(plat);
        return ResponseEntity.ok(updatedPlat);
    }

    @Operation(summary = "Supprimer un plat", description = "Supprime définitivement un plat de la base de données par son ID.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlat(@PathVariable Long id) {
        if (!platRepository.existsById(id)) {
            throw new ResourceNotFoundException("Plat non trouvé avec id : " + id);
        }
        platRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
