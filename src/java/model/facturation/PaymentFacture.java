/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.facturation;

import generalisation.GenericDAO.GenericDAO;
import generalisation.annotations.DBField;
import generalisation.annotations.DBTable;
import java.time.LocalDate;
import java.util.List;
import model.fabrication.StockProductFabrique;
import model.user.Client;

/**
 *
 * @author chalman
 */
@DBTable(name = "facture_payment", sequenceName = "seq_facture_payment")
public class PaymentFacture {
    @DBField(name="id_facture_paayment", isPrimaryKey = true)
    private int idFacturePayment;
    
     @DBField(name="id_facture", isForeignKey = true)
    private Facture facture;
     
    @DBField(name="date")
    private LocalDate date;
    
    @DBField(name="montant")
    private Double montant;
    
///Getters et setters

    public int getIdFacturePayment() {
        return idFacturePayment;
    }

    public void setIdFacturePayment(int idFacturePayment) {
        this.idFacturePayment = idFacturePayment;
    }

    public Facture getFacture() {
        return facture;
    }
    public void setFacture(Facture facture) {
        this.facture = facture;
    }
    public void setFacture(String idFacture) throws Exception {
        Facture facture = GenericDAO.findById(Facture.class, idFacture, null);
        this.setFacture(facture);
    }

    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public void setDate(String dateCreation) throws Exception {
        if(dateCreation.trim().equals("") || dateCreation == null) {
            throw new Exception("Veuillez saisir une valeur");
        }
        LocalDate date = LocalDate.parse(dateCreation);
        this.setDate(date);
    }

    public Double getMontant() {
        return montant;
    }
    public void setMontant(Double montant) {
        this.montant = montant;
    }
    public void setMontant(String montant) throws Exception {
        if(montant.trim().equals("") || montant == null) {
            throw new Exception("Veuillez saisir une valeur");
        }
        Double montantParsed = Double.valueOf(montant);
        if(montantParsed < 0) {
            throw new Exception("Duree doit etre positive");
        }
        this.setMontant(montantParsed);
    }
    
    public void checkPayment(String idFacture) throws Exception {
        String sql = "SELECT * FROM v_fiche_facture WHERE id_facture = "+idFacture;
        List<VFicheFacture> facture = (List<VFicheFacture>)GenericDAO.directQuery(VFicheFacture.class, sql, null);
        
        //StockProductFabrique stock = GenericDAO.findById(StockProductFabrique.class, product, null);
        
        if(facture.get(0).getRestePayer() - this.getMontant()< 0) {
            throw new Exception("Impossible d'effectuer cette payment : vous avez deja payer la totalite du facture");
        }
    }
///Constructors

    public PaymentFacture() {
    }

    public PaymentFacture(int idFacturePayment, Facture facture, LocalDate date, Double montant) {
        this.idFacturePayment = idFacturePayment;
        this.facture = facture;
        this.date = date;
        this.montant = montant;
    }

    public PaymentFacture(Facture facture, LocalDate date, Double montant) {
        this.facture = facture;
        this.date = date;
        this.montant = montant;
    }
    
    public PaymentFacture(String facture, String date, String montant) throws Exception {
        try {
            this.setFacture(facture);
            this.setDate(date);
            this.setMontant(montant);
            this.checkPayment(facture);
        } catch(Exception e) {
            throw e;
        }
    }
}
