package user;

import generalisation.annotations.DBField;
import generalisation.annotations.DBTable;
import model.production.Product;

/**
 *
 * @author protosam
 */
@DBTable(name = "StatistiqueGenre",sequenceName = "seq_statistiquegenre")
public class StatistiqueGenre {
    @DBField(name="produit")
    Product produit;
    
    @DBField(name="stat_homme")
    double stat_Homme;
    
    @DBField(name="stat_femme")
    Double stat_Femme;
    
    //getters et setters

    public Product getProduit() {
        return produit;
    }

    public void setProduit(Product produit) {
        this.produit = produit;
    }

    public double getStat_Homme() {
        return stat_Homme;
    }

    public void setStat_Homme(double stat_Homme) {
        this.stat_Homme = stat_Homme;
    }

    public Double getStat_Femme() {
        return stat_Femme;
    }

    public void setStat_Femme(Double stat_Femme) {
        this.stat_Femme = stat_Femme;
    }
    
    //constructeurs

    public StatistiqueGenre() {
    }

    public StatistiqueGenre(Product produit, Double stat_Homme, Double stat_Femme) {
        this.setProduit(produit);
        this.setStat_Femme(stat_Femme);
        this.setStat_Homme(stat_Homme );
    }
    
    
}
