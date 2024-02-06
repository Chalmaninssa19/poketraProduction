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
import model.production.Product;
import model.user.Client;

/**
 *
 * @author chalman
 */
@DBTable(name = "facture", sequenceName = "seq_facture")
public class Facture {
    @DBField(name="id_facture", isPrimaryKey = true)
    private int idFacture;
    
    @DBField(name="date")
    private LocalDate date;
    
    @DBField(name="status")
    private Integer status;
    
    @DBField(name="id_client", isForeignKey = true)
    private Client client;
      
    List<FactureDetails> factureDetails;
///Getters et setters
    public String getReference() {
        return "FAC00"+this.getIdFacture();
    }
    
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
    public void setDate(String dateCreation) throws Exception {
        if(dateCreation.trim().equals("") || dateCreation == null) {
            throw new Exception("Veuillez saisir une valeur");
        }
        LocalDate date = LocalDate.parse(dateCreation);
        this.setDate(date);
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<FactureDetails> getFactureDetails() {
        return factureDetails;
    }

    public void setFactureDetails(List<FactureDetails> factureDetails) {
        this.factureDetails = factureDetails;
    }

    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }
    public void setClient(String idClient) throws Exception {
        Client client = GenericDAO.findById(Client.class, idClient, null);
        this.setClient(client);
    }
    
///Constructors

    public Facture() {
    }

    public Facture(int idFacture, LocalDate date, Integer status, Client client) {
        this.idFacture = idFacture;
        this.date = date;
        this.status = status;
        this.client = client;
    }

    public Facture(LocalDate date, Integer status, Client client) {
        this.date = date;
        this.status = status;
        this.client = client;
    }
    
    public Facture(String date, List<FactureDetails> factureDetails, String client) throws Exception {
        try {
            this.setDate(date);
            this.setFactureDetails(factureDetails);
            this.setStatus(1);
            this.setClient(client);
        } catch(Exception e) {
            throw e;
        }
    }
    
///Fonctions
    public void save() throws Exception {
        GenericDAO.save(this, null);
        for(FactureDetails item : this.getFactureDetails()) {
            item.setFacture(this);
            GenericDAO.save(item, null);
        }
    }
}
