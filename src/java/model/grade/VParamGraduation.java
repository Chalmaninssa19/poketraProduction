/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.grade;

import generalisation.annotations.DBField;
import generalisation.annotations.DBTable;

/**
 *
 * @author chalman
 */
@DBTable(name = "v_param_graduation", sequenceName = "")
public class VParamGraduation {
    @DBField(name="id_param_graduation")
    private Integer idParamGraduation;
    
    @DBField(name="id_poste_grade_ancien")
    private Integer idPosteGradeAncien;
      
    @DBField(name="id_poste_ancien")
    private Integer idPosteAncien;
     
    @DBField(name="poste_ancien")
    private String posteAncien;
    
    @DBField(name="id_grade_ancien")
    private Integer idGradeAncien;
    
    @DBField(name="grade_ancien")
    private String gradeAncien;
    
    @DBField(name="niveau")
    private Integer niveau;
    
    @DBField(name="taux_horaire")
    private Double tauxHoraire;
        
    @DBField(name="id_poste_grade_ajour")
    private Integer idPosteGradeAjour;
    
    @DBField(name="poste_ajour")
    private String posteAjour;
    
    @DBField(name="grade_ajour")
    private String gradeAjour;
    
    @DBField(name="duree")
    private Integer duree;
    
///Getters et setters

    public int getIdParamGraduation() {
        return idParamGraduation;
    }

    public void setIdParamGraduation(int idParamGraduation) {
        this.idParamGraduation = idParamGraduation;
    }

    public Integer getIdPosteGradeAncien() {
        return idPosteGradeAncien;
    }

    public void setIdPosteGradeAncien(Integer idPosteGradeAncien) {
        this.idPosteGradeAncien = idPosteGradeAncien;
    }

    public Integer getIdPosteAncien() {
        return idPosteAncien;
    }

    public void setIdPosteAncien(Integer idPosteAncien) {
        this.idPosteAncien = idPosteAncien;
    }

    public String getPosteAncien() {
        return posteAncien;
    }

    public void setPosteAncien(String posteAncien) {
        this.posteAncien = posteAncien;
    }

    public Integer getIdGradeAncien() {
        return idGradeAncien;
    }

    public void setIdGradeAncien(Integer idGradeAncien) {
        this.idGradeAncien = idGradeAncien;
    }

    public String getGradeAncien() {
        return gradeAncien;
    }

    public void setGradeAncien(String gradeAncien) {
        this.gradeAncien = gradeAncien;
    }

    public Integer getNiveau() {
        return niveau;
    }

    public void setNiveau(Integer niveau) {
        this.niveau = niveau;
    }

    public Double getTauxHoraire() {
        return tauxHoraire;
    }

    public void setTauxHoraire(Double tauxHoraire) {
        this.tauxHoraire = tauxHoraire;
    }

    public Integer getIdPosteGradeAjour() {
        return idPosteGradeAjour;
    }

    public void setIdPosteGradeAjour(Integer idPosteGradeAjour) {
        this.idPosteGradeAjour = idPosteGradeAjour;
    }

    public String getPosteAjour() {
        return posteAjour;
    }

    public void setPosteAjour(String posteAjour) {
        this.posteAjour = posteAjour;
    }

    public String getGradeAjour() {
        return gradeAjour;
    }

    public void setGradeAjour(String gradeAjour) {
        this.gradeAjour = gradeAjour;
    }

    public Integer getDuree() {
        return duree;
    }

    public void setDuree(Integer duree) {
        this.duree = duree;
    }
    
///Constructors
    public VParamGraduation() {
    }

    public VParamGraduation(Integer idParamGraduation, Integer idPosteGradeAncien, Integer idPosteAncien, String posteAncien, Integer idGradeAncien, String gradeAncien, Integer niveau, Double tauxHoraire, Integer idPosteGradeAjour, String posteAjour, String gradeAjour, Integer duree) {
        this.idParamGraduation = idParamGraduation;
        this.idPosteGradeAncien = idPosteGradeAncien;
        this.idPosteAncien = idPosteAncien;
        this.posteAncien = posteAncien;
        this.idGradeAncien = idGradeAncien;
        this.gradeAncien = gradeAncien;
        this.niveau = niveau;
        this.tauxHoraire = tauxHoraire;
        this.idPosteGradeAjour = idPosteGradeAjour;
        this.posteAjour = posteAjour;
        this.gradeAjour = gradeAjour;
        this.duree = duree;
    }

    
///Fonctions
    public String getPosteGradeLetter() {
        return this.getPosteAncien()+" "+this.getGradeAncien();
    }
    
    public String getPosteGradeAjourLetter() {
        return this.getPosteAjour()+" "+this.getGradeAjour();
    }
    
    public String getYear() {
        return this.getDuree()+" ans";
    }
}
