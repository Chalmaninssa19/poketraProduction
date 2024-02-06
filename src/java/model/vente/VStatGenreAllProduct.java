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
@DBTable(name = "v_stat_genre_allproduct",sequenceName = "")
public class VStatGenreAllProduct {
    @DBField(name="id_genre")
    int idGenre;
        
    @DBField(name="percent")
    Double percent;
    
///Getters et setters

    public int getIdGenre() {
        return idGenre;
    }

    public void setIdGenre(int idGenre) {
        this.idGenre = idGenre;
    }

    public Double getPercent() {
        return percent;
    }

    public void setPercent(Double percent) {
        this.percent = percent;
    }
    
    public String getGenreLetter() {
        if(this.getIdGenre() == 1) {
            return "Masculin";
        } 
        
        return "Feminin";
    }
///Constructors

    public VStatGenreAllProduct() {
    }

    public VStatGenreAllProduct(int idGenre, Double percent) {
        this.idGenre = idGenre;
        this.percent = percent;
    }
}
