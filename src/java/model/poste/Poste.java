/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.poste;

import generalisation.GenericDAO.GenericDAO;
import generalisation.annotations.DBField;
import generalisation.annotations.DBTable;
import java.util.List;
import model.features_product.Matiere;

/**
 *
 * @author chalman
 */
@DBTable(name = "poste", sequenceName = "seq_poste")
public class Poste {
    
    @DBField(name="id_poste", isPrimaryKey = true)
    private int idPoste;
    
    @DBField(name="name")
    private String nom;
      
    @DBField(name="status")
    private Integer status;

///Getters et setters

    public int getIdPoste() {
        return idPoste;
    }

    public void setIdPoste(int idPoste) {
        this.idPoste = idPoste;
    }

    public String getNom() {
        return nom;
    }
    public void setNom(String nom) throws Exception {
        if(nom.trim().equals("") || nom == null) {
            throw new Exception("Veuillez saisir une valeur");
        }
        if(isExist(nom)) {
            throw new Exception("La valeur saisie existe deja, veuillez le changer");
        }
        this.nom = nom;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    
///Constructors

    public Poste() {
    }

    public Poste(int idPoste, String nom, Integer status) {
        this.idPoste = idPoste;
        this.nom = nom;
        this.status = status;
    }

    public Poste(String nom, Integer status) {
        this.nom = nom;
        this.status = status;
    }
    
    public Poste(String nom) throws Exception {
        try {
            this.setNom(nom);
            this.setStatus(1);
        } catch(Exception e) {
            throw e;
        }
    }
    
///Fonctions
    public boolean isExist(String name) throws Exception {
        String sql = "SELECT * FROM poste WHERE name = '"+name+"' AND status != 0";
        List<Poste> poste = (List<Poste>) GenericDAO.directQuery(Poste.class, sql, null);
        if(poste.size() == 0) {
            return false;
        }
        
        return true;
    }
}
