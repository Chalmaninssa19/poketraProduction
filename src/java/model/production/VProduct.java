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
import utilitaire.Util;

/**
 *
 * @author chalman
 */
@DBTable(name = "v_product", sequenceName = "")
public class VProduct {
    @DBField(name="id_product")
    private Integer idProduct;
    
    @DBField(name="designation")
    private String designation;
    
    @DBField(name="description")
    private String description;
    
    @DBField(name="id_size")
    private Integer idSize;
    
    @DBField(name="size")
    private String size;
    
    @DBField(name="id_type")
    private Integer idType;
      
    @DBField(name="type")
    private String type;
    
    @DBField(name="id_look")
    private Integer idLook;
      
    @DBField(name="look")
    private String look;
    
    @DBField(name="date_creation")
    private LocalDate dateCreation;
    
    @DBField(name="status_product")
    private Integer status;
    
    @DBField(name="prix_product")
    private Double prixProduct;
      
    @DBField(name="prix_vente")
    private Double prixVente;
    
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

    public Integer getIdSize() {
        return idSize;
    }

    public void setIdSize(Integer idSize) {
        this.idSize = idSize;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Integer getIdType() {
        return idType;
    }

    public void setIdType(Integer idType) {
        this.idType = idType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getIdLook() {
        return idLook;
    }

    public void setIdLook(Integer idLook) {
        this.idLook = idLook;
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

    public Double getPrixProduct() {
        return prixProduct;
    }
    public String getPrixProductLetter() {
        return Util.formatMonetaire(this.getPrixProduct());
    }

    public void setPrixProduct(Double prixProduct) {
        this.prixProduct = prixProduct;
    }

    public Double getPrixVente() {
        return prixVente;
    }

    public void setPrixVente(Double prixVente) {
        this.prixVente = prixVente;
    }
    
///Constructors

    public VProduct() {
    }

    public VProduct(Integer idProduct, String designation, String description, Integer idSize, String size, Integer idType, String type, Integer idLook, String look, LocalDate dateCreation, Integer status, Double prixProduct, Double prixVente) {
        this.idProduct = idProduct;
        this.designation = designation;
        this.description = description;
        this.idSize = idSize;
        this.size = size;
        this.idType = idType;
        this.type = type;
        this.idLook = idLook;
        this.look = look;
        this.dateCreation = dateCreation;
        this.status = status;
        this.prixProduct = prixProduct;
        this.prixVente = prixVente;
    }

///Fonctions
    public static void addMatiereProduct(List<VProduct> list) throws Exception {
        List<ProductMatiere> productsMatiere = (List<ProductMatiere>)GenericDAO.getAll(ProductMatiere.class, null, null);
        for(VProduct item : list) {
            for(ProductMatiere productMatiere : productsMatiere) {
                if(item.getIdProduct() == productMatiere.getProduct().getIdProduct()) {
                    item.getProductsMatiere().add(productMatiere);
                }
            }
        }
    }
}
