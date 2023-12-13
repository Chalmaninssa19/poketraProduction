/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.look;

import generalisation.GenericDAO.GenericDAO;
import generalisation.annotations.DBField;
import generalisation.annotations.DBTable;
import model.look.Look;
import model.look.Matiere;

/**
 *
 * @author Zotah
 */

@DBTable(name = "r_matiere_look", sequenceName = "seq_r_matiere_look")
public class RMatiereLook {
    @DBField(name = "id_r_matiere_look", isPrimaryKey=true)
    int id;
    @DBField(name = "id_matiere", isForeignKey=true)
    Matiere matiere;
    
    @DBField(name = "id_look", isForeignKey=true)
    Look look;
    
    @DBField(name = "status")
    int etat;

    public int getId() {
        return id;
    }

    public int getEtat() {
        return etat;
    }

    public Matiere getMatiere() {
        return matiere;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public void setMatiere(Matiere matiere) {
        this.matiere = matiere;
    }
    public void setMatiere(String matiere) throws Exception {
        Integer idMatiere = Integer.valueOf(matiere);
        Matiere matiereObject = GenericDAO.findById(Matiere.class, idMatiere, null);
        this.matiere = matiereObject;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLook(Look look) {
        this.look = look;
    }
    public void setLook(String look) throws Exception {
        Integer idLook = Integer.valueOf(look);
        Look lookObject = GenericDAO.findById(Look.class, idLook, null);
        this.look = lookObject;
    }

    public Look getLook() {
        return look;
    }

/// Constructors
    
    public RMatiereLook() {
    }

    public RMatiereLook(int id, Matiere matiere, Look look, int etat) {
        this.id = id;
        this.matiere = matiere;
        this.look = look;
        this.etat = etat;
    }

    public RMatiereLook(Matiere matiere, Look look, int etat) {
        this.matiere = matiere;
        this.look = look;
        this.etat = etat;
    }
    
    public RMatiereLook(String idMatiere, String idLook) throws Exception {
        try {
            this.setMatiere(idMatiere);
            this.setLook(idLook);
            this.etat = 1;
        } catch(Exception e) {
            throw e;
        }
    }
}
