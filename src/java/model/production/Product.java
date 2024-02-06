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
import model.features_product.*;

/**
 *
 * @author chalman
 */
@DBTable(name = "product", sequenceName = "seq_product")
public class Product {
    @DBField(name="id_product", isPrimaryKey = true)
    private int idProduct;
    
    @DBField(name="id_size", isForeignKey = true)
    private Size size;
     
    @DBField(name="id_type", isForeignKey = true)
    private Type type;
      
    @DBField(name="id_look", isForeignKey = true)
    private Look look;
    
    @DBField(name="designation")
    private String designation;
    
    @DBField(name="description")
    private String description;
    
    @DBField(name="date_creation")
    private LocalDate dateCreation;
    
    @DBField(name="status")
    private Integer status;
    
    @DBField(name="prix_vente")
    private Double prixVente;
     
    List<ProductMatiere> productMatieres = new ArrayList<>();
    
///Getters et setters
    public String getId() {
        return "PROD00"+this.getIdProduct();
    }
    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public Size getSize() {
        return size;
    }
    public void setSize(Size size) {
        this.size = size;
    }
    public void setSize(String idSize) throws Exception {
        Size size = GenericDAO.findById(Size.class, idSize, null);
        this.setSize(size);
    }

    public Type getType() {
        return type;
    }
    public void setType(Type type) {
        this.type = type;
    }
    public void setType(String idType) throws Exception {
        Type type = GenericDAO.findById(Type.class, idType, null);
        this.setType(type);
    }

    public Look getLook() {
        return look;
    }
    public void setLook(Look look) {
        this.look = look;
    }
    public void setLook(String idLook) throws Exception {
        Look look = GenericDAO.findById(Look.class, idLook, null);
        this.setLook(look);
    }

    public String getDesignation() {
        return designation;
    }
    public void setDesignation(String designation) throws Exception {
        if(designation.trim().equals("") || designation == null) {
            throw new Exception("Veuillez saisir une valeur");
        }

        this.designation = designation;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) throws Exception {
        if(description.trim().equals("") || description == null) {
            throw new Exception("Veuillez saisir une valeur");
        }
        
        this.description = description;
    }

    public LocalDate getDateCreation() {
        return dateCreation;
    }
    public void setDateCreation(LocalDate dateCreation) {
        this.dateCreation = dateCreation;
    }
    public void setDateCreation(String dateCreation) throws Exception {
        if(dateCreation.trim().equals("") || dateCreation == null) {
            throw new Exception("Veuillez saisir une valeur");
        }
        LocalDate date = LocalDate.parse(dateCreation);
        this.setDateCreation(date);
    }

    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<ProductMatiere> getProductMatieres() {
        return productMatieres;
    }

    public void setProductMatieres(List<ProductMatiere> productMatieres) {
        this.productMatieres = productMatieres;
    }

    public Double getPrixVente() {
        return prixVente;
    }
    public void setPrixVente(Double prixVente) {
        this.prixVente = prixVente;
    }
    public void setPrixVente(String prixVente) throws Exception {
        if(prixVente.trim().equals("") || prixVente == null) {
            throw new Exception("Veuillez saisir une valeur");
        }
        Double prixVenteParsed = Double.valueOf(prixVente);
        if(prixVenteParsed < 0) {
            throw new Exception("Duree doit etre positive");
        }
        this.prixVente = prixVenteParsed;
    }
    
///Constructors

    public Product() {
    }

    public Product(int idProduct, Size size, Type type, Look look, String designation, String description, LocalDate dateCreation, Integer status, Double prixVente) {
        this.idProduct = idProduct;
        this.size = size;
        this.type = type;
        this.look = look;
        this.designation = designation;
        this.description = description;
        this.dateCreation = dateCreation;
        this.status = status;
        this.prixVente = prixVente;
    }

    public Product(Size size, Type type, Look look, String designation, String description, LocalDate dateCreation, Integer status, Double prixVente) {
        this.size = size;
        this.type = type;
        this.look = look;
        this.designation = designation;
        this.description = description;
        this.dateCreation = dateCreation;
        this.status = status;
        this.prixVente = prixVente;
    }

    public Product(String designation, String size, String type, String look, String dateCreation, String description, String prixVente) throws Exception {
        try {
            this.setDesignation(designation);
            this.setSize(size);
            this.setType(type);
            this.setLook(look);
            this.setDateCreation(dateCreation);
            this.setDescription(description);
            this.setStatus(1);
            this.setPrixVente(prixVente);
        } catch(Exception e) {
            throw e;
        }
    }
    
///Fonctions
    public void save() throws Exception {
        System.out.println("Object = "+this.getDesignation());
        System.out.println("Object = "+this.getSize().getName());
        System.out.println("Object = "+this.getType().getName());
        System.out.println("Object = "+this.getLook().getName());
        System.out.println("Object = "+this.getDateCreation());
        System.out.println("Object = "+this.getDescription());
        System.out.println("Object = "+this.getStatus());
        
        GenericDAO.save(this, null);
        for(ProductMatiere item : this.getProductMatieres()) {
            item.setProduct(this);
            GenericDAO.save(item, null);
        }
    }
}