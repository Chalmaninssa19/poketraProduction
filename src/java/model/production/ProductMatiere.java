/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.production;

import generalisation.GenericDAO.GenericDAO;
import generalisation.annotations.DBField;
import generalisation.annotations.DBTable;
import model.features_product.Look;
import model.features_product.Matiere;
import model.features_product.Size;

/**
 *
 * @author chalman
 */
@DBTable(name = "product_matiere", sequenceName = "")
public class ProductMatiere {
    @DBField(name="id_product", isForeignKey = true)
    private Product product;
    
    @DBField(name="id_matiere", isForeignKey = true)
    private Matiere matiere;
    
///Getters et setters
    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
    public void setProduct(String idProduct) throws Exception {
        Product product = GenericDAO.findById(Product.class, idProduct, null);
        this.setProduct(product);
    }

    public Matiere getMatiere() {
        return matiere;
    }
    public void setMatiere(Matiere matiere) {
        this.matiere = matiere;
    }
    public void setMatiere(String idMatiere) throws Exception {
        Matiere matiere = GenericDAO.findById(Matiere.class, idMatiere, null);
        this.setMatiere(matiere);
    }
    
///Constructors

    public ProductMatiere() {
    }

    public ProductMatiere(Product product, Matiere matiere) {
        this.product = product;
        this.matiere = matiere;
    }
    
    public ProductMatiere(String matiere) throws Exception {
        try {
            this.setMatiere(matiere);
        } catch(Exception e) {
            throw e;
        }
    }
}
