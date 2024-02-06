/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.grade;

import generalisation.GenericDAO.GenericDAO;
import generalisation.annotations.DBField;
import generalisation.annotations.DBTable;
import model.poste.PosteGrade;

/**
 *
 * @author chalman
 */
@DBTable(name = "param_graduation", sequenceName = "seq_param_graduation")
public class ParamGraduation {
    
    @DBField(name="id_param_graduation", isPrimaryKey = true)
    private int idParamGraduation;
    
    @DBField(name="ancien", isForeignKey = true)
    private PosteGrade ancien;
    
    @DBField(name="ajour", isForeignKey = true)
    private PosteGrade ajour;
    
    @DBField(name="duree")
    private Integer duree;

///Getters et setters

    public int getIdParamGraduation() {
        return idParamGraduation;
    }

    public void setIdParamGraduation(int idParamGraduation) {
        this.idParamGraduation = idParamGraduation;
    }

    public PosteGrade getAncien() {
        return ancien;
    }
    public void setAncien(PosteGrade ancien) {
        this.ancien = ancien;
    }
    public void setAncien(String ancien) throws Exception {
        PosteGrade ancienObject = GenericDAO.findById(PosteGrade.class, ancien, null);
        this.setAncien(ancienObject);
    }

    public PosteGrade getAjour() {
        return ajour;
    }
    public void setAjour(PosteGrade ajour) {
        this.ajour = ajour;
    }
    public void setAjour(String ajour) throws Exception {
        PosteGrade ajourObject = GenericDAO.findById(PosteGrade.class, ajour, null);
        this.setAjour(ajourObject);
    }

    public Integer getDuree() {
        return duree;
    }
    public void setDuree(Integer duree) {
        this.duree = duree;
    }
    public void setDuree(String duree) throws Exception {
        if(duree.trim().equals("") || duree == null) {
            throw new Exception("Veuillez saisir une valeur");
        }
        Integer dureeParsed = Integer.valueOf(duree);
        if(dureeParsed < 0) {
            throw new Exception("Duree doit etre positive");
        }
        this.setDuree(dureeParsed);
    }

    
///Constructors

    public ParamGraduation() {
    }

    public ParamGraduation(int idParamGraduation, PosteGrade ancien, PosteGrade ajour, Integer duree) {
        this.idParamGraduation = idParamGraduation;
        this.ancien = ancien;
        this.ajour = ajour;
        this.duree = duree;
    }

    public ParamGraduation(PosteGrade ancien, PosteGrade ajour, Integer duree) {
        this.ancien = ancien;
        this.ajour = ajour;
        this.duree = duree;
    }
    
    public ParamGraduation(String ancien, String ajour, String duree) throws Exception {
        try {
            this.setAncien(ancien);
            this.setAjour(ajour);
            this.setDuree(duree);
        } catch(Exception e) {
            throw e;
        }
    }
///Fonctions
    
}
