/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.employe;
import generalisation.annotations.DBField;
import generalisation.annotations.DBTable;
import model.production.Product;
/**
 *
 * @author isaia
 */
@DBTable(name = "prix_vente_product", sequenceName = "seq_prix_vente_product")
public class PrixVenteProduct {
     @DBField(name="product", isPrimaryKey = true)
    private Product product;
    
    @DBField(name="nom", isForeignKey = true)
    private Double prix;
    
    // getter and setter

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }
    
    /// Constructor

    public PrixVenteProduct() {
    }

    public PrixVenteProduct(Product product, Double prix) {
        this.product = product;
        this.prix = prix;
    }
    
    
    
}
