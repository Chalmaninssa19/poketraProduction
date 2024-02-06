/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.fabrication;

import generalisation.GenericDAO.GenericDAO;
import generalisation.annotations.DBField;
import generalisation.annotations.DBTable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import model.features_product.Size;
import model.production.Product;
import model.production.VProductQuantity;
import model.stockage.EtatStock;
import model.stockage.Sortie;

/**
 *
 * @author chalman
 */
@DBTable(name = "product_fabrique", sequenceName = "seq_product_fabrique")
public class ProductFabrique {
    @DBField(name="id_product_fabrique", isPrimaryKey = true)
    private int idProductFabrique;
    
    @DBField(name="id_product", isForeignKey = true)
    private Product product;
    
    @DBField(name="quantite")
    private Double quantite;
    
    @DBField(name="date_fabrication")
    private LocalDate dateFabrication;
    
    @DBField(name="etat")
    private Integer etat;
    
    List<VProductQuantity> productQuantity = new ArrayList<>(); 
    
///Getters et setters
    public String getId() {
        return "PROD00"+this.getProduct().getIdProduct();
    }
    public int getIdProductFabrique() {
        return idProductFabrique;
    }

    public void setIdProductFabrique(int idProductFabrique) {
        this.idProductFabrique = idProductFabrique;
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

    public LocalDate getDateFabrication() {
        return dateFabrication;
    }
    public void setDateFabrication(LocalDate dateFabrication) {
        this.dateFabrication = dateFabrication;
    }
     public void setDateFabrication(String dateFabrication) throws Exception {
        if(dateFabrication.trim().equals("") || dateFabrication == null) {
            throw new Exception("Veuillez saisir une valeur");
        }
        LocalDate date = LocalDate.parse(dateFabrication);
        this.setDateFabrication(date);
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
        String sql = "SELECT * FROM v_product_quantity_production WHERE id_product = "+this.getProduct().getIdProduct();
        List<VProductQuantity> productQuantityList = (List<VProductQuantity>)GenericDAO.directQuery(VProductQuantity.class, sql, null);
        
        for(int i = 0; i < productQuantityList.size(); i++) {
            EtatStock etatStock = EtatStock.getEtatStock(this.getDateFabrication(), productQuantityList.get(i).getIdMatiere());
            Double quantiteMatiereUsed = productQuantityList.get(i).getQuantity() * quantiteParsed;
            if(etatStock.getStockList().get(0).getQuantiteFinal() - quantiteMatiereUsed < 0) {
                String error = "Nombre de stock "+productQuantityList.get(i).getMatiere()+" insuffisant, actuellement "+etatStock.getStockList().get(0).getQuantiteFinal()+" "+productQuantityList.get(i).getUnity();
                String errorSuite = error + ", quantite necessaire = "+quantiteMatiereUsed+" "+productQuantityList.get(i).getUnity();
                Double quantiteInsuffisant = quantiteMatiereUsed - etatStock.getStockList().get(0).getQuantiteFinal();
                String errorSuit = errorSuite + ", quantite insuffisant = "+quantiteInsuffisant+" "+ productQuantityList.get(i).getUnity();
                throw new Exception(errorSuit);
            }
            this.getProductQuantity().add(productQuantityList.get(i));
        }
        this.quantite = quantiteParsed;
    }

    public Integer getEtat() {
        return etat;
    }
    public void setEtat(Integer etat) {
        this.etat = etat;
    }

    public List<VProductQuantity> getProductQuantity() {
        return productQuantity;
    }
    public void setProductQuantity(List<VProductQuantity> productQuantity) {
        this.productQuantity = productQuantity;
    }
    
 ///constructors
    public ProductFabrique() {
    }
    
    public ProductFabrique(int idProductFabrique, Product product, Double quantite, LocalDate dateFabrication, Integer etat) {
        this.idProductFabrique = idProductFabrique;
        this.product = product;
        this.quantite = quantite;
        this.dateFabrication = dateFabrication;
        this.etat = etat;
    }

    public ProductFabrique(Product product, Double quantite, LocalDate dateFabrication, Integer etat) {
        this.product = product;
        this.quantite = quantite;
        this.dateFabrication = dateFabrication;
        this.etat = etat;
    }

    public ProductFabrique(String product, String quantite, String dateFabrication) throws Exception {
        try {
            this.setProduct(product);
            this.setDateFabrication(dateFabrication);
            this.setQuantite(quantite);
            this.setEtat(1);
        } catch(Exception e) {
            throw e;
        }
    }
///Fonctions
    public void save() throws Exception {
        GenericDAO.save(this, null);
        for(VProductQuantity item : this.getProductQuantity()) {
            Sortie sortie = new Sortie();
            sortie.setMatiere(item.getIdMatiere().toString());
            sortie.setDateSortie(this.getDateFabrication().toString());
            Double quantiteDouble = item.getQuantity() * this.getQuantite();
            sortie.setQuantite(quantiteDouble.toString());
            sortie.setEtat(1);
            GenericDAO.save(sortie, null);
        }
    }
}
