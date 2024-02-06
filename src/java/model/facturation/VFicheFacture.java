/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.facturation;

import generalisation.annotations.DBField;
import generalisation.annotations.DBTable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author chalman
 */
@DBTable(name = "v_fiche_facture", sequenceName = "")
public class VFicheFacture {
    @DBField(name="id_facture")
    int idFacture;
    
    @DBField(name="date")
    LocalDate date;
    
    @DBField(name="total_facture")
    Double totalFacture;
    
    @DBField(name="total_remise")
    Double totalRemise;
    
    @DBField(name="total_payer_with_remise")
    Double withRemise;
    
    @DBField(name="montant_deja_payer")
    Double dejaPayer;
    
    @DBField(name="reste_payer")
    Double restePayer;
    
    @DBField(name="nom")
    String nom;
    
    @DBField(name="prenom")
    String prenom;
    
    List<VDetailsFacture> detailsFacture = new ArrayList<>();
    
///Getters et setters

    public int getIdFacture() {
        return idFacture;
    }

    public void setIdFacture(int idFacture) {
        this.idFacture = idFacture;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getTotalFacture() {
        return totalFacture;
    }

    public void setTotalFacture(Double totalFacture) {
        this.totalFacture = totalFacture;
    }

    public Double getTotalRemise() {
        return totalRemise;
    }

    public void setTotalRemise(Double totalRemise) {
        this.totalRemise = totalRemise;
    }

    public Double getWithRemise() {
        return withRemise;
    }

    public void setWithRemise(Double withRemise) {
        this.withRemise = withRemise;
    }

    public Double getDejaPayer() {
        return dejaPayer;
    }

    public void setDejaPayer(Double dejaPayer) {
        this.dejaPayer = dejaPayer;
    }

    public Double getRestePayer() {
        return restePayer;
    }

    public void setRestePayer(Double restePayer) {
        this.restePayer = restePayer;
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
    
    public String getClient() {
        return nom+" "+prenom;
    }

    public List<VDetailsFacture> getDetailsFacture() {
        return detailsFacture;
    }

    public void setDetailsFacture(List<VDetailsFacture> detailsFacture) {
        this.detailsFacture = detailsFacture;
    }
    
    public String getReference() {
        return "FAC00"+this.getIdFacture();
    }
///Constructors

    public VFicheFacture() {
    }

    public VFicheFacture(int idFacture, LocalDate date, Double totalFacture, Double totalRemise, Double withRemise, Double dejaPayer, Double restePayer, String nom, String prenom) {
        this.idFacture = idFacture;
        this.date = date;
        this.totalFacture = totalFacture;
        this.totalRemise = totalRemise;
        this.withRemise = withRemise;
        this.dejaPayer = dejaPayer;
        this.restePayer = restePayer;
        this.nom = nom;
        this.prenom = prenom;
    }
    
}
