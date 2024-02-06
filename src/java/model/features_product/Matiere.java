/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.features_product;

import generalisation.GenericDAO.GenericDAO;
import generalisation.annotations.DBField;
import generalisation.annotations.DBTable;
import java.util.List;

/**
 *
 * @author chalman
 */
@DBTable(name = "matiere", sequenceName = "seq_matiere")
public class Matiere {
    @DBField(name="id_matiere", isPrimaryKey = true)
    private int idMatiere;
    
    @DBField(name="id_Unity", isForeignKey = true)
    private Unity unity;
     
    @DBField(name="name")
    private String name;
    
    @DBField(name="status")
    private Integer status;
    
    @DBField(name="prix")
    private Double prix;
///Getters et setters 

    public int getIdMatiere() {
        return idMatiere;
    }

    public void setIdMatiere(int idMatiere) {
        this.idMatiere = idMatiere;
    }

    public Unity getUnity() {
        return unity;
    }
    public void setUnity(Unity unity) {
        this.unity = unity;
    }
    public void setUnity(String unity) throws Exception {
        Unity unityObject = GenericDAO.findById(Unity.class, unity, null);
        this.setUnity(unityObject);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws Exception {
        if(name.trim().equals("") || name == null) {
            throw new Exception("Veuillez saisir une valeur");
        }
        if(isExist(name)) {
            throw new Exception("La valeur saisie existe deja, veuillez le changer");
        }
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }
    
    public void setPrix(String prix) throws Exception {
        if(prix.trim().equals("") || prix == null) {
            throw new Exception("Veuillez saisir une valeur");
        }
        Double prixParsed = Double.valueOf(prix);
        if(prixParsed < 0) {
            throw new Exception("Duree doit etre positive");
        }
        this.setPrix(prixParsed);
    }
    
///Constructors

    public Matiere() {
    }

    public Matiere(int idMatiere, Unity unity, String name, Integer status, Double prix) {
        this.idMatiere = idMatiere;
        this.unity = unity;
        this.name = name;
        this.status = status;
        this.prix = prix;
    }

    public Matiere(Unity unity, String name, Integer status, Double prix) {
        this.unity = unity;
        this.name = name;
        this.status = status;
        this.prix = prix;
    }
    
    public Matiere(String name, String unity, String prix) throws Exception {
        try {
            this.setName(name);
            this.setUnity(unity);
            this.setStatus(1);
            this.setPrix(prix);
        } catch(Exception e) {
            throw e;
        }
    }
    
///Fonctions
    public boolean isExist(String name) throws Exception {
        String sql = "SELECT * FROM matiere WHERE name = '"+name+"' AND status != 0";
        List<Matiere> matiere = (List<Matiere>) GenericDAO.directQuery(Matiere.class, sql, null);
        if(matiere.size() == 0) {
            return false;
        }
        
        return true;
    }
}
