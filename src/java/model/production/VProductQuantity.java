/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.production;

import generalisation.annotations.DBField;
import generalisation.annotations.DBTable;

/**
 *
 * @author chalman
 */
@DBTable(name = "v_product_quantity_production", sequenceName = "")
public class VProductQuantity {
    @DBField(name="id_product")
    private Integer idProduct;
    
    @DBField(name="id_matiere")
    private Integer idMatiere;
    
    @DBField(name="matiere")
    private String matiere;
    
    @DBField(name="unity")
    private String unity;
    
    @DBField(name="quantity")
    private Double quantity;
    
///Getters et setters

    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }

    public Integer getIdMatiere() {
        return idMatiere;
    }

    public void setIdMatiere(Integer idMatiere) {
        this.idMatiere = idMatiere;
    }

    public String getMatiere() {
        return matiere;
    }

    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }

    public String getUnity() {
        return unity;
    }

    public void setUnity(String unity) {
        this.unity = unity;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }
    
///Constructors

    public VProductQuantity() {
    }

    public VProductQuantity(Integer idProduct, Integer idMatiere, String matiere, String unity, Double quantity) {
        this.idProduct = idProduct;
        this.idMatiere = idMatiere;
        this.matiere = matiere;
        this.unity = unity;
        this.quantity = quantity;
    }

}
