/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.poste;

import generalisation.annotations.DBField;
import generalisation.annotations.DBTable;

/**
 *
 * @author chalman
 */
@DBTable(name = "v_poste_grade", sequenceName = "")
public class VPosteGrade {
    
    @DBField(name="id_poste_grade")
    private int idPosteGrade;
    
    @DBField(name="id_poste")
    private Integer idPoste;
      
    @DBField(name="poste")
    private String poste;
    
    @DBField(name="status_poste")
    private Integer statusPoste;
    
    @DBField(name="id_grade")
    private Integer idGrade;
    
    @DBField(name="grade")
    private String grade;
    
    @DBField(name="niveau")
    private Integer niveau;
    
    @DBField(name="status_grade")
    private Integer statusGrade;
    
    @DBField(name="taux_horaire")
    private Double tauxHoraire;
    
///Getters et setters

        public int getIdPosteGrade() {
            return idPosteGrade;
        }

        public void setIdPosteGrade(int idPosteGrade) {
            this.idPosteGrade = idPosteGrade;
        }

        public Integer getIdPoste() {
            return idPoste;
        }

        public void setIdPoste(Integer idPoste) {
            this.idPoste = idPoste;
        }

        public String getPoste() {
            return poste;
        }

        public void setPoste(String poste) {
            this.poste = poste;
        }

        public Integer getStatusPoste() {
            return statusPoste;
        }

        public void setStatusPoste(Integer statusPoste) {
            this.statusPoste = statusPoste;
        }

        public Integer getIdGrade() {
            return idGrade;
        }

        public void setIdGrade(Integer idGrade) {
            this.idGrade = idGrade;
        }

        public String getGrade() {
            return grade;
        }

        public void setGrade(String grade) {
            this.grade = grade;
        }

        public Integer getNiveau() {
            return niveau;
        }

        public void setNiveau(Integer niveau) {
            this.niveau = niveau;
        }

        public Integer getStatusGrade() {
            return statusGrade;
        }

        public void setStatusGrade(Integer statusGrade) {
            this.statusGrade = statusGrade;
        }

        public Double getTauxHoraire() {
            return tauxHoraire;
        }

        public void setTauxHoraire(Double tauxHoraire) {
            this.tauxHoraire = tauxHoraire;
        }
    
///Constructors

        public VPosteGrade() {
        }

        public VPosteGrade(int idPosteGrade, Integer idPoste, String poste, Integer statusPoste, Integer idGrade, String grade, Integer niveau, Integer statusGrade, Double tauxHoraire) {
            this.idPosteGrade = idPosteGrade;
            this.idPoste = idPoste;
            this.poste = poste;
            this.statusPoste = statusPoste;
            this.idGrade = idGrade;
            this.grade = grade;
            this.niveau = niveau;
            this.statusGrade = statusGrade;
            this.tauxHoraire = tauxHoraire;
        }
        
///Fonctions
        public String getPosteGradeLetter() {
            return this.getPoste()+" "+this.getGrade();
        }
}
