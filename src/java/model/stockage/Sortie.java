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
@DBTable(name = "sortie", sequenceName = "seq_sortie")
public class Sortie {
    @DBField(name="id_sortie", isPrimaryKey = true)
    private int idSortie;
    
    @DBField(name="id_matiere", isForeignKey = true)
    private Matiere matiere;
    
    @DBField(name="quantite")
    private Double quantite;
    
    @DBField(name="date_sortie")
    private LocalDate dateSortie;
    
    @DBField(name="etat")
    private Integer etat;
    
///Getters et setters

    public int getIdSortie() {
        return idSortie;
    }

    public void setIdSortie(int idSortie) {
        this.idSortie = idSortie;
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
        EtatStock etatStock = EtatStock.getEtatStock(this.getDateSortie(), this.getMatiere().getIdMatiere());
        
        if(etatStock.getStockList().get(0).getQuantiteFinal() - quantiteParsed < 0) {
            String error = "Nombre de stock "+this.getMatiere().getName()+" insuffisant, actuellement "+etatStock.getStockList().get(0).getQuantiteFinal()+" "+this.getMatiere().getUnity().getName();
            throw new Exception(error);
        }
        this.quantite = quantiteParsed;
    }

    public LocalDate getDateSortie() {
        return dateSortie;
    }
    public void setDateSortie(LocalDate dateSortie) {
        this.dateSortie = dateSortie;
    }
    public void setDateSortie(String dateSortie) throws Exception {
        if(dateSortie.trim().equals("") || dateSortie == null) {
            throw new Exception("Veuillez saisir une valeur");
        }
        LocalDate dateParsed = LocalDate.parse(dateSortie);
        this.dateSortie = dateParsed;
    }

    public Integer getEtat() {
        return etat;
    }

    public void setEtat(Integer etat) {
        this.etat = etat;
    }
    
///Constructors

    public Sortie() {
    }

    public Sortie(int idSortie, Matiere matiere, Double quantite, LocalDate dateSortie, Integer etat) {
        this.idSortie = idSortie;
        this.matiere = matiere;
        this.quantite = quantite;
        this.dateSortie = dateSortie;
        this.etat = etat;
    }

    public Sortie(Matiere matiere, Double quantite, LocalDate dateSortie, Integer etat) {
        this.matiere = matiere;
        this.quantite = quantite;
        this.dateSortie = dateSortie;
        this.etat = etat;
    }
    
    public Sortie(String matiere, String quantite, String date) throws Exception {
        try {
            this.setMatiere(matiere);
            this.setDateSortie(date);
            this.setQuantite(quantite);
            this.setEtat(1);
        } catch(Exception e) {
            throw e;
        }
    }
}
