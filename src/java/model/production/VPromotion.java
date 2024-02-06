/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.production;

import generalisation.annotations.DBField;
import generalisation.annotations.DBTable;
import java.time.LocalDate;

/**
 *
 * @author chalman
 */
@DBTable(name = "v_promotion", sequenceName = "")
public class VPromotion {
    @DBField(name="id_product")
    private Integer idProduct;
    
    @DBField(name="designation")
    private String designation;
    
    @DBField(name="description")
    private String description;
    
    @DBField(name="prix_exterieur")
    private Double prixExterieur;
    
    @DBField(name="id_promotion")
    private Integer idPromotion;
    
    @DBField(name="remise")
    private Double remise;
    
    @DBField(name="prix_interieur")
    private Double prixInterieur;
    
    @DBField(name="date_debut")
    private LocalDate dateDebut;
    
    @DBField(name="date_fin")
    private LocalDate dateFin;
    
///Getters et setters

    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrixExterieur() {
        return prixExterieur;
    }

    public void setPrixExterieur(Double prixExterieur) {
        this.prixExterieur = prixExterieur;
    }

    public Integer getIdPromotion() {
        return idPromotion;
    }

    public void setIdPromotion(Integer idPromotion) {
        this.idPromotion = idPromotion;
    }

    public Double getRemise() {
        return remise;
    }

    public void setRemise(Double remise) {
        this.remise = remise;
    }

    public Double getPrixInterieur() {
        return prixInterieur;
    }

    public void setPrixInterieur(Double prixInterieur) {
        this.prixInterieur = prixInterieur;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }
    
///Costructors

    public VPromotion() {
    }

    public VPromotion(String designation, String description, Double prixExterieur, Integer idPromotion, Double remise, Double prixInterieur, LocalDate dateDebut, LocalDate dateFin) {
        this.designation = designation;
        this.description = description;
        this.prixExterieur = prixExterieur;
        this.idPromotion = idPromotion;
        this.remise = remise;
        this.prixInterieur = prixInterieur;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    public VPromotion(Integer idProduct, String designation, String description, Double prixExterieur, Integer idPromotion, Double remise, Double prixInterieur, LocalDate dateDebut, LocalDate dateFin) {
        this.idProduct = idProduct;
        this.designation = designation;
        this.description = description;
        this.prixExterieur = prixExterieur;
        this.idPromotion = idPromotion;
        this.remise = remise;
        this.prixInterieur = prixInterieur;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }
    
///Fonctions

    
}
