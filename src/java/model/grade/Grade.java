/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.grade;

import generalisation.GenericDAO.GenericDAO;
import generalisation.annotations.DBField;
import generalisation.annotations.DBTable;
import java.util.List;
import model.poste.Poste;

/**
 *
 * @author chalman
 */
@DBTable(name = "grade", sequenceName = "seq_grade")
public class Grade {
    
    @DBField(name="id_grade", isPrimaryKey = true)
    private int idGrade;
    
    @DBField(name="name")
    private String name;
    
    @DBField(name="niveau")
    private Integer niveau;
    
    @DBField(name="status")
    private Integer status;
    
///Getters et setters

    public int getIdGrade() {
        return idGrade;
    }

    public void setIdGrade(int idGrade) {
        this.idGrade = idGrade;
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

    public Integer getNiveau() {
        return niveau;
    }
    public void setNiveau(Integer niveau) {
        this.niveau = niveau;
    }
    public void setNiveau(String niveau) throws Exception {
        if(niveau.trim().equals("") || niveau == null) {
            throw new Exception("Veuillez saisir une valeur");
        }
        Integer niveauParsed = Integer.valueOf(niveau);
        if(niveauParsed < 0) {
            throw new Exception("Duree doit etre positive");
        }
        this.setNiveau(niveauParsed);
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    
///Constructors

    public Grade() {
    }

    public Grade(int idGrade, String name, Integer niveau, Integer status) {
        this.idGrade = idGrade;
        this.name = name;
        this.niveau = niveau;
        this.status = status;
    }

    public Grade(String name, Integer niveau, Integer status) {
        this.name = name;
        this.niveau = niveau;
        this.status = status;
    }
    public Grade(String name, String niveau) throws Exception {
        try {
            this.setName(name);
            this.setNiveau(niveau);
            this.setStatus(1);
        } catch(Exception e) {
            throw e;
        }
    }
    
///Fonctions
    public boolean isExist(String name) throws Exception {
        String sql = "SELECT * FROM grade WHERE name = '"+name+"' AND status != 0";
        List<Grade> grade = (List<Grade>) GenericDAO.directQuery(Grade.class, sql, null);
        if(grade.size() == 0) {
            return false;
        }
        
        return true;
    }
}
