/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.employe;

import generalisation.annotations.DBField;
import generalisation.annotations.DBTable;
import java.time.LocalDate;

/**
 *
 * @author chalman
 */
@DBTable(name = "v_employe", sequenceName = "")
public class VEmploye {
    @DBField(name="id_employe")
    private int idEmploye;
    
    @DBField(name="nom")
    private String nom;
    
    @DBField(name="prenom")
    private String prenom;
    
    @DBField(name="date_naissance")
    private LocalDate dateNaissance;
    
    @DBField(name="id_poste_grade")
    private Integer idProfession;
    
    @DBField(name="poste")
    private String profession;
    
    @DBField(name="grade")
    private String grade;
    
    @DBField(name="niveau")
    private Integer niveau;
     
    @DBField(name="taux_horaire")
    private Double tauxHoraire;
    
     @DBField(name="status")
    private Integer status;
     
    @DBField(name="date_embauche")
    private LocalDate dateEmbauche;
    
///Getters et setters
    public String getId() {
        return "Emp00"+this.getIdEmploye();
    }
    public int getIdEmploye() {
        return idEmploye;
    }

    public void setIdEmploye(int idEmploye) {
        this.idEmploye = idEmploye;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public Integer getIdProfession() {
        return idProfession;
    }

    public void setIdProfession(Integer idProfession) {
        this.idProfession = idProfession;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
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

    public Double getTauxHoraire() {
        return tauxHoraire;
    }

    public void setTauxHoraire(Double tauxHoraire) {
        this.tauxHoraire = tauxHoraire;
    }


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public LocalDate getDateEmbauche() {
        return dateEmbauche;
    }

    public void setDateEmbauche(LocalDate dateEmbauche) {
        this.dateEmbauche = dateEmbauche;
    }
    
///Constructors

    public VEmploye() {
    }

    public VEmploye(int idEmploye, String nom, String prenom, LocalDate dateNaissance, Integer idProfession, String profession, String grade, Integer niveau, Double tauxHoraire, Integer status, LocalDate dateEmbauche) {
        this.idEmploye = idEmploye;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.idProfession = idProfession;
        this.profession = profession;
        this.grade = grade;
        this.niveau = niveau;
        this.tauxHoraire = tauxHoraire;
        this.status = status;
        this.dateEmbauche = dateEmbauche;
    }
    
///Fonctions
    public String getPosteGradeLetter() {
        return this.getProfession()+" "+this.getGrade();
    }
}
