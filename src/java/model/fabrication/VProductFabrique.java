/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.fabrication;

import generalisation.annotations.DBField;
import generalisation.annotations.DBTable;
import java.time.LocalDate;
import utilitaire.Util;

/**
 *
 * @author chalman
 */
@DBTable(name = "v_product_fabrique", sequenceName = "")
public class VProductFabrique {
    @DBField(name="id_product_fabrique")
    private Integer idProductFabrique;
    
    @DBField(name="id_product")
    private Integer idProduct;
    
    @DBField(name="designation")
    private String product;
    
    @DBField(name="quantite")
    private Double quantite;
    
    @DBField(name="date_fabrication")
    private LocalDate dateFabrication;
    
    @DBField(name="etat")
    private Integer etat;
    
    @DBField(name="montant")
    private Double montant;
    
    @DBField(name="prix_vente")
    private Double prixVente;
    
///Getters et setters
   public String getId() {
        return "PROD00"+this.getIdProduct();
    }
    public Integer getIdProductFabrique() {
        return idProductFabrique;
    }

    public void setIdProductFabrique(Integer idProductFabrique) {
        this.idProductFabrique = idProductFabrique;
    }

    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }

    public Double getQuantite() {
        return quantite;
    }

    public void setQuantite(Double quantite) {
        this.quantite = quantite;
    }

    public LocalDate getDateFabrication() {
        return dateFabrication;
    }

    public void setDateFabrication(LocalDate dateFabrication) {
        this.dateFabrication = dateFabrication;
    }

    public Integer getEtat() {
        return etat;
    }

    public void setEtat(Integer etat) {
        this.etat = etat;
    }

    public Double getPrixVente() {
        return prixVente;
    }
    public void setPrixVente(Double prixVente) {
        this.prixVente = prixVente;
    }
    public String getPrixVenteLetter() {
        return Util.formatMonetaire(this.getPrixVente());
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Double getMontant() {
        return montant;
    }
    public String getMontantLetter() {
        return Util.formatMonetaire(this.getMontant());
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }
    
    
///Constructors

    public VProductFabrique() {
    }

    public VProductFabrique(Integer idProductFabrique, Integer idProduct, String product, Double quantite, LocalDate dateFabrication, Integer etat, Double montant, Double prixVente) {
        this.idProductFabrique = idProductFabrique;
        this.idProduct = idProduct;
        this.product = product;
        this.quantite = quantite;
        this.dateFabrication = dateFabrication;
        this.etat = etat;
        this.montant = montant;
        this.prixVente = prixVente;
    }
}
