/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.facturation;

import generalisation.GenericDAO.GenericDAO;
import generalisation.annotations.DBField;
import generalisation.annotations.DBTable;
import model.features_product.Unity;
import model.production.Product;

/**
 *
 * @author chalman
 */
@DBTable(name = "facture_details", sequenceName = "")
public class FactureDetails {
    @DBField(name="id_facture", isForeignKey = true)
    private Facture facture;
    
    @DBField(name="id_product", isForeignKey = true)
    private Product product;
    
    @DBField(name="quantite")
    private Double quantite;
    
    @DBField(name="remise")
    private Double remise;
    
///Getters et setters

    public Facture getFacture() {
        return facture;
    }
    public void setFacture(Facture facture) {
        this.facture = facture;
    }

    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
    public void setProduct(String idproduct) throws Exception {
        Product product = GenericDAO.findById(Product.class, idproduct, null);
        this.setProduct(product);
    }

    public Double getQuantite() {
        return quantite;
    }
    public void setQuantite(Double quantite) {
        this.quantite = quantite;
    }
    public void setQuantite(String quantite) throws Exception {
        if(quantite.trim().equals("") || quantite == null) {
            throw new Exception("Veuillez saisir une valeur");
        }
        Double quantiteParsed = Double.valueOf(quantite);
        if(quantiteParsed < 0) {
            throw new Exception("Duree doit etre positive");
        }
        this.setQuantite(quantiteParsed);
    }

    public Double getRemise() {
        return remise;
    }
    public void setRemise(Double remise) {
        this.remise = remise;
    }
    public void setRemise(String remise) throws Exception {
        if(remise.trim().equals("") || remise == null) {
            throw new Exception("Veuillez saisir une valeur");
        }
        Double remiseParsed = Double.valueOf(remise);
        if(remiseParsed < 0) {
            throw new Exception("Duree doit etre positive");
        }
        this.setRemise(remiseParsed);
    }
    
///Constructors

    public FactureDetails() {
    }

    public FactureDetails(Facture facture, Product product, Double quantite, Double remise) {
        this.facture = facture;
        this.product = product;
        this.quantite = quantite;
        this.remise = remise;
    }
    
    public FactureDetails(String product, String quantite, String remise) throws Exception {
        try {
            this.setProduct(product);
            this.setQuantite(quantite);
            this.setRemise(remise);
        } catch(Exception e) {
            throw e;
        }
    }
}
