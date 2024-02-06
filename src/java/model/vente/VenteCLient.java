/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.vente;

import generalisation.GenericDAO.GenericDAO;
import generalisation.annotations.DBField;
import generalisation.annotations.DBTable;
import java.time.LocalDate;
import java.util.List;
import model.fabrication.StockProductFabrique;
import model.production.Product;
import model.user.Client;

/**
 *
 * @author protosam
 */
@DBTable(name = "vente_client",sequenceName = "seq_vente_client")
public class VenteCLient {
    @DBField(name="id_vente_client", isPrimaryKey = true)
    int idVenteClient;
    
    @DBField(name="id_product", isForeignKey = true)
    Product product;
    
    @DBField(name="id_client", isForeignKey = true)
    Client client;
    
    @DBField(name="quantite")
    Double Quantite;
    
    @DBField(name="date")
    LocalDate date;
   
    //getters et setters 

    public int getIdVenteClient() {
        return idVenteClient;
    }

    public void setIdVenteClient(int idVenteClient) {
        this.idVenteClient = idVenteClient;
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

    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
    public void setProduct(String idProduct) throws Exception {
         Product product = GenericDAO.findById(Product.class, idProduct, null);
        this.setProduct(product);
    }

    public Double getQuantite() {
        return Quantite;
    }
    public void setQuantite(Double Quantite) {
        this.Quantite = Quantite;
    }
    public void setQuantite(String quantite) throws Exception {
        if(quantite.trim().equals("") || quantite == null) {
            throw new Exception("Veuillez saisir une valeur");
        }
        Double quantiteParsed = Double.valueOf(quantite);
        if(quantiteParsed < 0) {
            throw new Exception("Duree doit etre positive");
        }
        this.Quantite = quantiteParsed;
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

    public void checkQuantite(String product) throws Exception {
        String sql = "SELECT * FROM v_stock_product_fabrique WHERE id_product = "+product;
        List<StockProductFabrique> stock = (List<StockProductFabrique>)GenericDAO.directQuery(StockProductFabrique.class, sql, null);
        
        //StockProductFabrique stock = GenericDAO.findById(StockProductFabrique.class, product, null);
        
        if(stock.get(0).getReste() - this.getQuantite() < 0) {
            throw new Exception("Impossible d'effectuer cette vente : le stock du produit est insuffisant");
        }
    }
    // constructeurs

    public VenteCLient() {
    }

    public VenteCLient(int idVenteClient, Product product, Client client, Double Quantite, LocalDate date) {
        this.idVenteClient = idVenteClient;
        this.product = product;
        this.client = client;
        this.Quantite = Quantite;
        this.date = date;
    }

    public VenteCLient(Product product, Client client, Double Quantite, LocalDate date) {
        this.product = product;
        this.client = client;
        this.Quantite = Quantite;
        this.date = date;
    }

    public VenteCLient(String client, String product, String quantite, String date) throws Exception {
        try {
            this.setClient(client);
            this.setProduct(product);
            this.setQuantite(quantite);
            this.checkQuantite(product);
            this.setDate(date);
        } catch(Exception e) {
            throw e;
        }
    }
    
//Fonctions
    
}
