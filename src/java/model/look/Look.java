/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.look;

import generalisation.annotations.DBField;
import generalisation.annotations.DBTable;

/**
 *
 * @author Zotah
 */

@DBTable(name = "look", sequenceName = "seq_look")
public class Look {
    
    @DBField(name="id_look", isPrimaryKey = true)
    int id;
    
    @DBField(name="nom")
    String nom;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Look() {
    }

    public Look(String nom) {
        this.nom = nom;
    }

    public Look(int id_, String nom_) {
        setId(id_);
        setNom(nom_);
    }
    
    
}
