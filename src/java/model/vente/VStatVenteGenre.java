/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.vente;

import generalisation.annotations.DBField;
import generalisation.annotations.DBTable;

/**
 *
 * @author chalman
 */
@DBTable(name = "v_stat_genre_product_vente",sequenceName = "")
public class VStatVenteGenre {
    @DBField(name="id_product")
    int idProduct;
        
    @DBField(name="id_genre")
    int idGenre;
      
    @DBField(name="designation")
    String designation;
       
    @DBField(name="number_client")
    int numberClient;
     
    @DBField(name="percent_number")
    Double percentNumber;
    
///Getters et setters

    public int getNumberClient() {
        return numberClient;
    }

    public void setNumberClient(int numberClient) {
        this.numberClient = numberClient;
    }

    public Double getPercentNumber() {
        return percentNumber;
    }

    public void setPercentNumber(Double percentNumber) {
        this.percentNumber = percentNumber;
    }

    public int getIdGenre() {
        return idGenre;
    }

    public void setIdGenre(int idGenre) {
        this.idGenre = idGenre;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getGenreLetter() {
        if(this.getIdGenre() == 1) {
            return "Masculin";
        } 
        
        return "Feminin";
    }
///Constructors

    public VStatVenteGenre() {
    }

    public VStatVenteGenre(int idProduct, int idGenre, String designation, int numberClient, Double percentNumber) {
        this.idProduct = idProduct;
        this.idGenre = idGenre;
        this.designation = designation;
        this.numberClient = numberClient;
        this.percentNumber = percentNumber;
    }
}
