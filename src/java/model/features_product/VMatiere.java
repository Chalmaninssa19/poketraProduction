/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.features_product;

import generalisation.annotations.DBField;
import generalisation.annotations.DBTable;
import utilitaire.Util;

/**
 *
 * @author chalman
 */
@DBTable(name = "v_matiere", sequenceName = "")
public class VMatiere {
    @DBField(name="id_matiere")
    private Integer idMatiere;
    
    @DBField(name="unity")
    private String unity;
    
    @DBField(name="matiere")
    private String matiere;
    
    @DBField(name="prix")
    private Double prix;
    
    @DBField(name="status")
    private Integer status;
    
///Getters et setters 

    public Integer getIdMatiere() {
        return idMatiere;
    }

    public void setIdMatiere(Integer idMatiere) {
        this.idMatiere = idMatiere;
    }

    public String getUnity() {
        return unity;
    }

    public void setUnity(String unity) {
        this.unity = unity;
    }

    public String getMatiere() {
        return matiere;
    }

    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }

    public Double getPrix() {
        return prix;
    }
    public String getPrixLetter() {
        return Util.formatMonetaire(this.getPrix());
    }
    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    
///Constructors

    public VMatiere() {
    }

    public VMatiere(Integer idMatiere, String unity, String matiere, Double prix, Integer status) {
        this.idMatiere = idMatiere;
        this.unity = unity;
        this.matiere = matiere;
        this.prix = prix;
        this.status = status;
    }
    
}
