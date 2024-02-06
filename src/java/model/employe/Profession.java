/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.employe;

/**
 *
 * @author isaia
 */
import generalisation.GenericDAO.GenericDAO;
import generalisation.annotations.DBField;
import generalisation.annotations.DBTable;
import java.util.List;

@DBTable(name = "profession", sequenceName = "seq_profession")
public class Profession {
     @DBField(name="id_profession", isPrimaryKey = true)
    private int idProfession;
    
    @DBField(name="nom")
    private String nom;
    
    @DBField(name="salaire")
    private Double salaire;
      
    @DBField(name="status")
    private Integer status;

/// getter and setter
    public int getIdProfession() {
        return idProfession;
    }

    public void setIdProfession(int idProfession) {
        this.idProfession = idProfession;
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

    public Double getSalaire() {
        return salaire;
    }
    public void setSalaire(Double salaire) {
        this.salaire = salaire;
    }
    public void setSalaire(String salaire) throws Exception {
        if(salaire.trim().equals("") || salaire == null) {
            throw new Exception("Veuillez saisir une valeur");
        }
        Double salaireParsed = Double.valueOf(salaire);
        if(salaireParsed < 0) {
            throw new Exception("Duree doit etre positive");
        }
        this.salaire = salaireParsed;
    }

     public void setSalaireByProfession(String idProfession, String coefficient) throws Exception {
        Profession profession = GenericDAO.findById(Profession.class, idProfession, null);
        if(coefficient.trim().equals("") || coefficient == null) {
            throw new Exception("Veuillez saisir une valeur");
        }
      
        Double coefficientParsed = Double.valueOf(coefficient);
        if(coefficientParsed < 0) {
            throw new Exception("Duree doit etre positive");
        }
        this.setSalaire(coefficientParsed * profession.getSalaire());
    }
/// Constructor

    public Profession() {
    }

    public Profession(int idProfession, String nom, Double salaire, Integer status) {
        this.idProfession = idProfession;
        this.nom = nom;
        this.salaire = salaire;
        this.status = status;
    }

    public Profession(String nom, Double salaire, Integer status) {
        this.nom = nom;
        this.salaire = salaire;
        this.status = status;
    }

   public Profession(String nom, String salaire) throws Exception {
       try {
           this.setNom(nom);
           this.setSalaire(salaire);
           this.setStatus(1);
       } catch(Exception e) {
           throw e;
       }
   }

   public Profession(String nom, String salaire, String profession, String coefficient) throws Exception {
       try {
           this.setNom(nom);
           this.setSalaireByProfession(profession, coefficient);
           this.setStatus(1);
       } catch(Exception e) {
           throw e;
       }
   }
///Fonctions
     public boolean isExist(String name) throws Exception {
        String sql = "SELECT * FROM profession WHERE nom = '"+name+"' AND status != 0";
        List<Profession> profession = (List<Profession>) GenericDAO.directQuery(Profession.class, sql, null);
        if(profession.size() == 0) {
            return false;
        }
        
        return true;
    }
    
}
