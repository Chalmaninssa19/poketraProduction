/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.poste;

import generalisation.GenericDAO.GenericDAO;
import generalisation.annotations.DBField;
import generalisation.annotations.DBTable;
import java.util.List;
import model.features_product.Unity;
import model.grade.Grade;

/**
 *
 * @author chalman
 */
@DBTable(name = "poste_grade", sequenceName = "seq_poste_grade")
public class PosteGrade {
    
    @DBField(name="id_poste_grade", isPrimaryKey = true)
    private int idPosteGrade;
    
    @DBField(name="id_poste", isForeignKey = true)
    private Poste poste;
      
    @DBField(name="id_grade", isForeignKey = true)
    private Grade grade;
    
    @DBField(name="taux_horaire")
    private Double tauxHoraire;
    
///Getters et setters

    public int getIdPosteGrade() {
        return idPosteGrade;
    }
    public void setIdPosteGrade(int idPosteGrade) {
        this.idPosteGrade = idPosteGrade;
    }

    public Poste getPoste() {
        return poste;
    }
    public void setPoste(Poste poste) {
        this.poste = poste;
    }
    public void setPoste(String poste) throws Exception {
        Poste posteObject = GenericDAO.findById(Poste.class, poste, null);
        this.setPoste(posteObject);
    }

    public Grade getGrade() {
        return grade;
    }
    public void setGrade(Grade grade) {
        this.grade = grade;
    }
    public void setGrade(String grade) throws Exception {
        Grade gradeObject = GenericDAO.findById(Grade.class, grade, null);
        this.setGrade(gradeObject);
    }

    public Double getTauxHoraire() {
        return tauxHoraire;
    }
    public void setTauxHoraire(Double tauxHoraire) {
        this.tauxHoraire = tauxHoraire;
    }
    public void setTauxHoraire(String tauxHoraire) throws Exception {
        if(tauxHoraire.trim().equals("") || tauxHoraire == null) {
            throw new Exception("Veuillez saisir une valeur");
        }
        Double tauxHoraireParsed = Double.valueOf(tauxHoraire);
        if(tauxHoraireParsed < 0) {
            throw new Exception("Duree doit etre positive");
        }
        this.setTauxHoraire(tauxHoraireParsed);
    }
    public void setTauxHoraire(String posteRelier, String gradeRelier, String coefficient) throws Exception {
        if(coefficient.trim().equals("") || coefficient == null) {
            throw new Exception("Veuillez saisir une valeur");
        }
        if(posteRelier.trim().equals("") || posteRelier == null) {
            throw new Exception("Veuillez saisir une valeur");
        }
        if(gradeRelier.trim().equals("") || gradeRelier == null) {
            throw new Exception("Veuillez saisir une valeur");
        }
        
        Integer coefficientParsed = Integer.valueOf(coefficient);
        if(coefficientParsed < 0) {
            throw new Exception("Duree doit etre positive");
        }
        
        PosteGrade posteGrade = getPosteGrade(gradeRelier, posteRelier);
        
        this.setTauxHoraire(coefficientParsed * posteGrade.getTauxHoraire());
    }
    
///Constructors

    public PosteGrade() {
    }

    public PosteGrade(int idPosteGrade, Poste poste, Grade grade, Double tauxHoraire) {
        this.idPosteGrade = idPosteGrade;
        this.poste = poste;
        this.grade = grade;
        this.tauxHoraire = tauxHoraire;
    }

    public PosteGrade(Poste poste, Grade grade, Double tauxHoraire) {
        this.poste = poste;
        this.grade = grade;
        this.tauxHoraire = tauxHoraire;
    }

    public PosteGrade(String poste, String grade, String tauxHoraire) throws Exception {
        try {
            this.isExist(poste, grade);
            this.setPoste(poste);
            this.setGrade(grade);
            this.setTauxHoraire(tauxHoraire);
        } catch(Exception e) {
            throw e;
        }
    }
    
    public PosteGrade(String poste, String grade, String posteRelier, String gradeRelier, String coefficient) throws Exception {
        try {
            this.isExist(poste, grade);
            this.setPoste(poste);
            this.setGrade(grade);
            this.setTauxHoraire(posteRelier, gradeRelier, coefficient);
        } catch(Exception e) {
            throw e;
        }
    }
    
///Fonctions
    //Avoir le poste grade convenu
    public PosteGrade getPosteGrade(String grade, String poste) throws Exception {
        String sql = "SELECT * FROM poste_grade WHERE id_poste = "+poste+" AND id_grade = "+grade;
        System.out.println("SQL = "+sql);
        
        List<PosteGrade> posteGrade = (List<PosteGrade>)GenericDAO.directQuery(PosteGrade.class, sql, null);
        if(posteGrade.size() <= 0) {
            throw new Exception("Ce relation poste grade n'existe pas, vous devez en creer dans taux horaire type 1");
        } 
        
        return posteGrade.get(0);
    }
    
    //Est ce que le poste grade existe deja
    public void isExist(String poste, String grade) throws Exception {
        String sql = "SELECT * FROM poste_grade WHERE id_poste = "+poste+" AND id_grade = "+grade;
        
        List<PosteGrade> posteGrade = (List<PosteGrade>)GenericDAO.directQuery(PosteGrade.class, sql, null);
        if(posteGrade.size() > 0) {
            throw new Exception("Impossible d'en creer : cette relation poste-grade existe deja");
        } 
    }
}
