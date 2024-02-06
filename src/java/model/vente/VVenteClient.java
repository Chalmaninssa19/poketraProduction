/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.vente;

import generalisation.annotations.DBField;
import generalisation.annotations.DBTable;
import java.time.LocalDate;
import model.production.Product;
import model.user.Client;

/**
 *
 * @author chalman
 */
@DBTable(name = "v_vente_client",sequenceName = "")
public class VVenteClient {
    @DBField(name="id_vente_client")
    int idVenteClient;
    
    @DBField(name="id_client")
    int idClient;
    
    @DBField(name="nom")
    String nom;
     
    @DBField(name="prenom")
    String prenom;
      
    @DBField(name="id_genre")
    int idGenre;
    
    @DBField(name="quantite")
    Double quantite;
    
    @DBField(name="date")
    LocalDate date;
    
    @DBField(name="designation")
    String designation;
    
///Getters et setters

    public int getIdVenteClient() {
        return idVenteClient;
    }

    public void setIdVenteClient(int idVenteClient) {
        this.idVenteClient = idVenteClient;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
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

    public int getIdGenre() {
        return idGenre;
    }

    public void setIdGenre(int idGenre) {
        this.idGenre = idGenre;
    }

    public Double getQuantite() {
        return quantite;
    }

    public void setQuantite(Double quantite) {
        this.quantite = quantite;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
    
///Constructors

    public VVenteClient() {
    }

    public VVenteClient(int idVenteClient, int idClient, String nom, String prenom, int idGenre, Double quantite, LocalDate date, String designation) {
        this.idVenteClient = idVenteClient;
        this.idClient = idClient;
        this.nom = nom;
        this.prenom = prenom;
        this.idGenre = idGenre;
        this.quantite = quantite;
        this.date = date;
        this.designation = designation;
    }
    
}
