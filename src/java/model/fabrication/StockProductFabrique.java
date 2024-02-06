/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.fabrication;

import generalisation.annotations.DBField;
import generalisation.annotations.DBTable;

/**
 *
 * @author chalman
 */
@DBTable(name = "v_stock_product_fabrique", sequenceName = "")
public class StockProductFabrique {
    @DBField(name="id_product")
    private Integer idProduct;
    
    @DBField(name="designation")
    private String designation;
    
    @DBField(name="entree")
    private Double entree;
    
    @DBField(name="sortie")
    private Double sortie;
    
    @DBField(name="prix_vente")
    private Double prixVente;
    
    @DBField(name="reste")
    private Double reste;
    
    @DBField(name="montant")
    private Double montant;
    
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

    public Double getEntree() {
        return entree;
    }

    public void setEntree(Double entree) {
        this.entree = entree;
    }

    public Double getSortie() {
        return sortie;
    }

    public void setSortie(Double sortie) {
        this.sortie = sortie;
    }

    public Double getPrixVente() {
        return prixVente;
    }

    public void setPrixVente(Double prixVente) {
        this.prixVente = prixVente;
    }

    public Double getReste() {
        return reste;
    }

    public void setReste(Double reste) {
        this.reste = reste;
    }

    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }
    
///Constructors

    public StockProductFabrique() {
    }

    public StockProductFabrique(Integer idProduct, String designation, Double entree, Double sortie, Double prixVente, Double reste, Double montant) {
        this.idProduct = idProduct;
        this.designation = designation;
        this.entree = entree;
        this.sortie = sortie;
        this.prixVente = prixVente;
        this.reste = reste;
        this.montant = montant;
    }
    
}
