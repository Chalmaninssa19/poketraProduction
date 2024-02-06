/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.facturation;

import generalisation.annotations.DBField;
import generalisation.annotations.DBTable;
import java.time.LocalDate;

/**
 *
 * @author chalman
 */
@DBTable(name = "v_fiche_facture", sequenceName = "")
public class VDetailsFacture {
    @DBField(name="id_facture")
    int idFacture;
    
    @DBField(name="product")
    String product;
    
    @DBField(name="quantite")
    Double quantite;
       
    @DBField(name="prix_vente")
    Double prixVente;
       
    @DBField(name="remise")
    Double remise;
    
    @DBField(name="montant")
    Double montant;
    
    @DBField(name="montant_with_remise")
    Double montantRemise;
    
    @DBField(name="value_remise")
    Double valueRemise;
    
 ///Getters et setters

    public int getIdFacture() {
        return idFacture;
    }

    public void setIdFacture(int idFacture) {
        this.idFacture = idFacture;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Double getQuantite() {
        return quantite;
    }

    public void setQuantite(Double quantite) {
        this.quantite = quantite;
    }

    public Double getPrixVente() {
        return prixVente;
    }

    public void setPrixVente(Double prixVente) {
        this.prixVente = prixVente;
    }

    public Double getRemise() {
        return remise;
    }

    public void setRemise(Double remise) {
        this.remise = remise;
    }

    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    public Double getMontantRemise() {
        return montantRemise;
    }

    public void setMontantRemise(Double montantRemise) {
        this.montantRemise = montantRemise;
    }

    public Double getValueRemise() {
        return valueRemise;
    }

    public void setValueRemise(Double valueRemise) {
        this.valueRemise = valueRemise;
    }
    
///Constructors

    public VDetailsFacture() {
    }

    public VDetailsFacture(int idFacture, String product, Double quantite, Double prixVente, Double remise, Double montant, Double montantRemise, Double valueRemise) {
        this.idFacture = idFacture;
        this.product = product;
        this.quantite = quantite;
        this.prixVente = prixVente;
        this.remise = remise;
        this.montant = montant;
        this.montantRemise = montantRemise;
        this.valueRemise = valueRemise;
    }
    
}
