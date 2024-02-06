/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.employe;

import generalisation.GenericDAO.GenericDAO;
import generalisation.annotations.DBField;
import generalisation.annotations.DBTable;

/**
 *
 * @author chalman
 */
@DBTable(name = "regle_graduation", sequenceName = "seq_regle_graduation")
public class RegleGraduation {
    @DBField(name="id_regle_graduation", isPrimaryKey = true)
    private int idRegleGraduation;
    
    @DBField(name="id_profession_ancien", isForeignKey = true)
    private Profession professionAncien;
    
    @DBField(name="id_profession_actuel", isForeignKey = true)
    private Profession professionActuel;
    
    @DBField(name="duree_annee_min")
    private Integer dureeAnneeMin;
    
    @DBField(name="duree_annee_max")
    private Integer dureeAnneeMax;

///Getters et setters

    public int getIdRegleGraduation() {
        return idRegleGraduation;
    }

    public void setIdRegleGraduation(int idRegleGraduation) {
        this.idRegleGraduation = idRegleGraduation;
    }
    public Profession getProfessionAncien() {
        return professionAncien;
    }
    public void setProfessionAncien(String idProfession) throws Exception {
        Profession profession = GenericDAO.findById(Profession.class, idProfession, null);
        this.setProfessionAncien(profession);
    }
    public void setProfessionAncien(Profession professionAncien) {
        this.professionAncien = professionAncien;
    }
    
    public Profession getProfessionActuel() {
        return professionActuel;
    }
    public void setProfessionActuel(String idProfession) throws Exception {
        Profession profession = GenericDAO.findById(Profession.class, idProfession, null);
        this.setProfessionActuel(profession);
    }
    public void setProfessionActuel(Profession professionActuel) {
        this.professionActuel = professionActuel;
    }

    public Integer getDureeAnneeMin() {
        return dureeAnneeMin;
    }
    public void setDureeAnneeMin(Integer dureeAnneeMin) {
        this.dureeAnneeMin = dureeAnneeMin;
    }
    public void setDureeAnneMin(String duree) throws Exception {
        if(duree.trim().equals("") || duree == null) {
            throw new Exception("Veuillez saisir une valeur");
        }
        Integer dureeParsed = Integer.valueOf(duree);
        if(dureeParsed < 0) {
            throw new Exception("Duree doit etre positive");
        }
        this.dureeAnneeMin = dureeParsed;
    }

    public Integer getDureeAnneeMax() {
        return dureeAnneeMax;
    }
    public void setDureeAnneeMax(Integer dureeAnneeMax) {
        this.dureeAnneeMax = dureeAnneeMax;
    }
    public void setDureeAnneMax(String duree) throws Exception {
        if(duree.trim().equals("") || duree == null) {
            throw new Exception("Veuillez saisir une valeur");
        }
        Integer dureeParsed = Integer.valueOf(duree);
        if(dureeParsed < 0) {
            throw new Exception("Duree doit etre positive");
        }
        this.dureeAnneeMax = dureeParsed;
    }

///Constructors

    public RegleGraduation() {
    }

    public RegleGraduation(int idRegleGraduation, Profession professionAncien, Profession professionActuel, Integer dureeAnneeMin, Integer dureeAnneeMax) {
        this.idRegleGraduation = idRegleGraduation;
        this.professionAncien = professionAncien;
        this.professionActuel = professionActuel;
        this.dureeAnneeMin = dureeAnneeMin;
        this.dureeAnneeMax = dureeAnneeMax;
    }

    public RegleGraduation(Profession professionAncien, Profession professionActuel, Integer dureeAnneeMin, Integer dureeAnneeMax) {
        this.professionAncien = professionAncien;
        this.professionActuel = professionActuel;
        this.dureeAnneeMin = dureeAnneeMin;
        this.dureeAnneeMax = dureeAnneeMax;
    }

    public RegleGraduation(String ancien, String actuel, String min, String max) throws Exception {
        try {
            this.setProfessionAncien(ancien);
            this.setProfessionActuel(actuel);
            this.setDureeAnneMin(min);
            this.setDureeAnneMax(max);
        } catch(Exception e) {
            throw e;
        }
    }
    
}
