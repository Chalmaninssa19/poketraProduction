package model.look;

import generalisation.annotations.DBField;
import generalisation.annotations.DBTable;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Zotah
 */
@DBTable(name = "Matiere", sequenceName = "seq_Matiere", prefix = "MAT")
public class Matiere {
    
    @DBField(name="id_matiere", isPrimaryKey = true)
    int id;
    
    @DBField(name="nom")
    String nom;
    
/// Getters et setters
    public int getId() {
        return id;
    }
    
    public String getNom() {
        return nom;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

///Constructors
    public Matiere() {
    }

    public Matiere(String nom) {
        this.nom = nom;
    }
    
    
    public Matiere(int i, String n) {
        setId(i);
        setNom(n);
    }
    
 /// Fonctions
}
