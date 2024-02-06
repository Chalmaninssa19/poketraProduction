/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.facturation;

import generalisation.annotations.DBField;
import generalisation.annotations.DBTable;
import java.time.LocalDate;

/**
 *
 * @author chalman
 */
@DBTable(name = "facture_payment", sequenceName = "seq_facture_payment")
public class FacturePayment {
    @DBField(name="id_facture_payment", isPrimaryKey = true)
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }
    
///Constructors

    public FacturePayment() {
    }

    public FacturePayment(int idFacturePayment, Facture facture, LocalDate date, Double montant) {
        this.idFacturePayment = idFacturePayment;
        this.facture = facture;
        this.date = date;
        this.montant = montant;
    }

    public FacturePayment(Facture facture, LocalDate date, Double montant) {
        this.facture = facture;
        this.date = date;
        this.montant = montant;
    }
    
///Fonctions
    
}
