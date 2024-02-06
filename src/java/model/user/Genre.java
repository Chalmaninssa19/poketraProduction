/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.user;
import generalisation.GenericDAO.GenericDAO;
import generalisation.annotations.DBField;
import generalisation.annotations.DBTable;
import java.util.List;
import model.features_product.Look;

/**
 *
 * @author protosam
 */
@DBTable(name = "genre",sequenceName = "seq_genre")
public class Genre {
    @DBField(name="id_genre", isPrimaryKey = true)
    int idGenre;
     
    @DBField(name="genre")
    String genre;
    
    //getters et setters

    public int getIdGenre() {
        return idGenre;
    }

    public void setIdGenre(int idGenre) {
        this.idGenre = idGenre;
    }

    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) throws Exception {
        if(genre.trim().equals("") || genre == null) {
            throw new Exception("Veuillez saisir une valeur");
        }
        
        this.genre = genre;
    }
    
    //COnstructeurs

    public Genre() {
    }

    public Genre(int idGenre, String genre) throws Exception {
        try {
            this.setIdGenre(idGenre);
            this.setGenre(genre);
        } catch(Exception e) {
            throw e;
        }
    }

    public Genre(String genre) throws Exception {
        try {
            this.setGenre(genre);
        } catch(Exception e) {
            throw e;
        }
    }
    
//Fonctions
}
