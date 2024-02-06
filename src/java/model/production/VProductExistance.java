/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.production;

import generalisation.GenericDAO.GenericDAO;
import generalisation.annotations.DBField;
import generalisation.annotations.DBTable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author chalman
 */
@DBTable(name = "v_product_existance", sequenceName = "")
public class VProductExistance {
    @DBField(name="id_product")
    private Integer idProduct;
    
    @DBField(name="designation")
    private String designation;
    
    @DBField(name="description")
    private String description;
    
    @DBField(name="size")
    private String size;
    
    @DBField(name="type")
    private String type;
    
    @DBField(name="look")
    private String look;
    
    @DBField(name="date_creation")
    private LocalDate dateCreation;
    
    @DBField(name="status")
    private Integer status;
    
    List<ProductMatiere> productsMatiere = new ArrayList<>();
    
///Getters et setters
    public String getId() {
        return "PROD00"+this.getIdProduct();
    }
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

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLook() {
        return look;
    }

    public void setLook(String look) {
        this.look = look;
    }

    public LocalDate getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(LocalDate dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<ProductMatiere> getProductsMatiere() {
        return productsMatiere;
    }

    public void setProductsMatiere(List<ProductMatiere> productsMatiere) {
        this.productsMatiere = productsMatiere;
    }
    
///Constructors

    public VProductExistance() {
    }

    public VProductExistance(String designation, String description, String size, String type, String look, LocalDate dateCreation, Integer status) {
        this.designation = designation;
        this.description = description;
        this.size = size;
        this.type = type;
        this.look = look;
        this.dateCreation = dateCreation;
        this.status = status;
    }

    public VProductExistance(Integer idProduct, String designation, String description, String size, String type, String look, LocalDate dateCreation, Integer status) {
        this.idProduct = idProduct;
        this.designation = designation;
        this.description = description;
        this.size = size;
        this.type = type;
        this.look = look;
        this.dateCreation = dateCreation;
        this.status = status;
    }
    
///Fonctions
    public static void addMatiereProduct(List<VProductExistance> list) throws Exception {
        List<ProductMatiere> productsMatiere = (List<ProductMatiere>)GenericDAO.getAll(ProductMatiere.class, null, null);
        for(VProductExistance item : list) {
            for(ProductMatiere productMatiere : productsMatiere) {
                if(item.getIdProduct() == productMatiere.getProduct().getIdProduct()) {
                    item.getProductsMatiere().add(productMatiere);
                }
            }
        }
    }
}
