/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.stockage;

import utilitaire.Util;

/**
 *
 * @author chalman
 */
public class Stock {
    private Integer idMatiere;
    private String matiere;
    private String unity;
    private Double quantiteInitial;
    private Double entree;
    private Double sortie;
    private Double quantiteFinal;
    private Double prixUnitaire;
    private Double montant;
    
///Getters et setters

    public Integer getIdMatiere() {
        return idMatiere;
    }

    public void setIdMatiere(Integer idMatiere) {
        this.idMatiere = idMatiere;
    }

    public String getMatiere() {
        return matiere;
    }

    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }

    public String getUnity() {
        return unity;
    }

    public void setUnity(String unity) {
        this.unity = unity;
    }

    public Double getQuantiteInitial() {
        return quantiteInitial;
    }

    public void setQuantiteInitial(Double quantiteInitial) {
        this.quantiteInitial = quantiteInitial;
    }

    public Double getEntree() {
        return entree;
    }

    public void setEntree(Double entree) {
        this.entree = entree;
    }

    public Double getSortie() {
        return sortie;
    }

    public void setSortie(Double sortie) {
        this.sortie = sortie;
    }

    public Double getQuantiteFinal() {
        return quantiteFinal;
    }

    public void setQuantiteFinal(Double quantiteFinal) {
        this.quantiteFinal = quantiteFinal;
    }

    public Double getPrixUnitaire() {
        return prixUnitaire;
    }
    public String getPrixUnitaireLetter() {
        return Util.formatMonetaire(this.getPrixUnitaire());
    }

    public void setPrixUnitaire(Double prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    public Double getMontant() {
        return montant;
    }
    public String getMontantLetter() {
        return Util.formatMonetaire(this.getMontant());
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }
    
///Constructors

    public Stock() {
    }

    public Stock(Integer idMatiere, String matiere, String unity, Double quantiteInitial, Double entree, Double sortie, Double quantiteFinal, Double prixUnitaire, Double montant) {
        this.idMatiere = idMatiere;
        this.matiere = matiere;
        this.unity = unity;
        this.quantiteInitial = quantiteInitial;
        this.entree = entree;
        this.sortie = sortie;
        this.quantiteFinal = quantiteFinal;
        this.prixUnitaire = prixUnitaire;
        this.montant = montant;
    }
    
///Fonctions
    
}
