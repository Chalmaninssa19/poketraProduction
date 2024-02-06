/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.production;

import generalisation.GenericDAO.GenericDAO;
import generalisation.annotations.DBField;
import generalisation.annotations.DBTable;
import java.time.LocalDate;
import model.features_product.Size;

/**
 *
 * @author chalman
 */
@DBTable(name = "promotion", sequenceName = "seq_promotion")
public class Promotion {
    @DBField(name="id_promotion", isPrimaryKey = true)
    private int idPromotion;
    
    @DBField(name="id_product", isForeignKey = true)
    private Product product;
       
    @DBField(name="date_debut")
    private LocalDate dateDebut;
    
    @DBField(name="date_fin")
    private LocalDate dateFin;
    
    @DBField(name="remise")
    private Double remise;
    
///Getters et setters

    public int getIdPromotion() {
        return idPromotion;
    }
    public void setIdPromotion(int idPromotion) {
        this.idPromotion = idPromotion;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }
    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }
    public void setDateDebut(String dateDebut) throws Exception {
        if(dateDebut.trim().equals("") || dateDebut == null) {
            throw new Exception("Veuillez saisir une valeur");
        }
        LocalDate date = LocalDate.parse(dateDebut);
        this.setDateDebut(date);
    }

    public LocalDate getDateFin() {
        return dateFin;
    }
    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }
    public void setDateFin(String dateFin) throws Exception {
        if(dateFin.trim().equals("") || dateFin == null) {
            throw new Exception("Veuillez saisir une valeur");
        }
        LocalDate date = LocalDate.parse(dateFin);
        this.setDateFin(date);
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
        this.remise = remiseParsed;
    }

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

    
///Constructors

    public Promotion() {
    }

    public Promotion(Product product, LocalDate dateDebut, LocalDate dateFin, Double remise) {
        this.product = product;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.remise = remise;
    }

    public Promotion(int idPromotion, Product product, LocalDate dateDebut, LocalDate dateFin, Double remise) {
        this.idPromotion = idPromotion;
        this.product = product;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.remise = remise;
    }
    
    public Promotion(String product, String dateDebut, String dateFin, String remise) throws Exception {
        try {
            this.setProduct(product);
            this.setDateDebut(dateDebut);
            this.setDateFin(dateFin);
            this.setRemise(remise);
        } catch(Exception e) {
            throw e;
        }
    }
    
///Fonctions

    
}
