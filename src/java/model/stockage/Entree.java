/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.stockage;

import generalisation.GenericDAO.GenericDAO;
import generalisation.annotations.DBField;
import generalisation.annotations.DBTable;
import java.time.LocalDate;
import model.features_product.Matiere;

/**
 *
 * @author chalman
 */
@DBTable(name = "entree", sequenceName = "seq_entree")
public class Entree {
    @DBField(name="id_entree", isPrimaryKey = true)
    private int idEntree;
    
    @DBField(name="id_matiere", isForeignKey = true)
    private Matiere matiere;
    
    @DBField(name="prix_unitaire")
    private Double prixUnitaire;
    
    @DBField(name="quantite")
    private Double quantite;
    
    @DBField(name="date_entree")
    private LocalDate dateEntree;
    
    @DBField(name="etat")
    private Integer etat;
    
///Getters et setters

    public int getIdEntree() {
        return idEntree;
    }

    public void setIdEntree(int idEntree) {
        this.idEntree = idEntree;
    }

    public Matiere getMatiere() {
        return matiere;
    }
    public void setMatiere(Matiere matiere) {
        this.matiere = matiere;
    }
    public void setMatiere(String idMatiere) throws Exception {
        Matiere matiere = GenericDAO.findById(Matiere.class, idMatiere, null);
        this.setMatiere(matiere);
    }

    public Double getPrixUnitaire() {
        return prixUnitaire;
    }
    public void setPrixUnitaire(Double prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }
    public void setPrixUnitaire(String prixUnitaire) throws Exception {
        if(prixUnitaire.trim().equals("") || prixUnitaire == null) {
            throw new Exception("Veuillez saisir une valeur");
        }
        Double prixUnitaireParsed = Double.valueOf(prixUnitaire);
        if(prixUnitaireParsed < 0) {
            throw new Exception("Nombre doit etre positive");
        }
        this.prixUnitaire = prixUnitaireParsed;
    }

    public Double getQuantite() {
        return quantite;
    }
    public void setQuantite(Double quantite) {
        this.quantite = quantite;
    }
    public void setQuantite(String quantite) throws Exception {
        if(quantite.trim().equals("") || quantite == null) {
            throw new Exception("Veuillez saisir une valeur");
        }
        Double quantiteParsed = Double.valueOf(quantite);
        if(quantiteParsed < 0) {
            throw new Exception("Nombre doit etre positive");
        }
        this.quantite = quantiteParsed;
    }

    public LocalDate getDateEntree() {
        return dateEntree;
    }
    public void setDateEntree(LocalDate dateEntreeStock) {
        this.dateEntree = dateEntreeStock;
    }
    public void setDateEntree(String dateEntree) throws Exception {
        if(dateEntree.trim().equals("") || dateEntree == null) {
            throw new Exception("Veuillez saisir une valeur");
        }
        LocalDate dateParsed = LocalDate.parse(dateEntree);
        this.dateEntree = dateParsed;
    }

    public Integer getEtat() {
        return etat;
    }

    public void setEtat(Integer etat) {
        this.etat = etat;
    }
    
    
///Constructors
    public Entree() {
    }

    public Entree(int idEntree, Matiere matiere, Double prixUnitaire, Double quantite, LocalDate dateEntreeStock, Integer etat) {
        this.idEntree = idEntree;
        this.matiere = matiere;
        this.prixUnitaire = prixUnitaire;
        this.quantite = quantite;
        this.dateEntree = dateEntreeStock;
        this.etat = etat;
    }

    public Entree(Matiere matiere, Double prixUnitaire, Double quantite, LocalDate dateEntreeStock, Integer etat) {
        this.matiere = matiere;
        this.prixUnitaire = prixUnitaire;
        this.quantite = quantite;
        this.dateEntree = dateEntreeStock;
        this.etat = etat;
    }

   public Entree(String matiere, String prixUnitaire, String quantite, String date) throws Exception {
       try {
           this.setMatiere(matiere);
           this.setPrixUnitaire(prixUnitaire);
           this.setQuantite(quantite);
           this.setDateEntree(date);
           this.setEtat(1);
       } catch(Exception e) {
           throw e;
       }
   }
    
///Fonctions

}
