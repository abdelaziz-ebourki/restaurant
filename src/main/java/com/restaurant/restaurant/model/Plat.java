package com.restaurant.restaurant.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

@Entity
public class Plat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Le nom du plat est obligatoire")
    private String nom;
    private int calories;
    @Positive(message = "Le prix doit être positif")
    private double prix;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private double coutIngredients;

    public Plat() {

    }

    public Plat(String nom, int calories, double prix, double coutIngredients) {
        this.nom = nom;
        this.calories = calories;
        this.prix = prix;
        this.coutIngredients = coutIngredients;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public double getCoutIngredients() {
        return coutIngredients;
    }

    public void setCoutIngredients(double coutIngredients) {
        this.coutIngredients = coutIngredients;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "Plat[id=" + id + ",nom=" + nom + ",prix=" + prix + "]";
    }
}