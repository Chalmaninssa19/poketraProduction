/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.stockage;

import connection.DBConnection;
import generalisation.GenericDAO.GenericDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import model.features_product.Matiere;

/**
 *
 * @author chalman
 */
public class EtatStock {
    private LocalDate dateDebut;
    private LocalDate dateFin;
    List<Stock> stockList = new ArrayList<>();
    
///Getters et setters

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }


    public List<Stock> getStockList() {
        return stockList;
    }

    public void setStockList(List<Stock> stockList) {
        this.stockList = stockList;
    }
    
///Constructors

    public EtatStock() {
    }

    public EtatStock(LocalDate dateDebut, LocalDate dateFin) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }
    
///Fonctions
    //Obtenir l'etat de stock des matieres
    public static EtatStock getEtatStock() throws Exception {
        String sqlAsc = "SELECT * FROM entree ORDER BY date_entree ASC";
        
        List<Entree> entreeAsc = (List<Entree>)GenericDAO.directQuery(Entree.class, sqlAsc, null);
        
        return getEtatStock(entreeAsc.get(0).getDateEntree(), LocalDate.now());
    }
    public static EtatStock getEtatStock(LocalDate dateDebut, LocalDate dateFin, String matiere) throws Exception {
        EtatStock etatStock = new EtatStock(dateDebut, dateFin);
        
        String query = "SELECT * FROM get_etat_stock('"+dateDebut+"', '"+dateFin+"') WHERE id_matiere = "+matiere;

        Connection connection = null;
        Statement statement = null;
        ResultSet resultset = null;

        try {
            connection = DBConnection.getConnection();
            statement = connection.createStatement();
            resultset = statement.executeQuery(query);

            while (resultset.next()) {
                int idMatiere = resultset.getInt("id_matiere");
                String matiereString = resultset.getString("matiere");
                String unity = resultset.getString("unity");
                Double quantiteInitial = resultset.getDouble("quantite_initial");
                Double entree = resultset.getDouble("entree");
                Double sortie = resultset.getDouble("sortie");
                Double quantiteFinal = (entree - sortie);
                Double prixUnitaire = resultset.getDouble("prix_unitaire");
                Double montant = prixUnitaire * quantiteFinal;
                
                Stock stock = new Stock(idMatiere, matiereString, unity, quantiteInitial, entree, sortie, quantiteFinal, prixUnitaire, montant);
                etatStock.getStockList().add(stock);
            }

            resultset.close();
            statement.close();
            connection.close();

            return etatStock;
        } catch (Exception e) {
            if (resultset != null) {
                resultset.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
            throw e;
        }
    }
    public static EtatStock getEtatStock(LocalDate dateDebut, LocalDate dateFin) throws Exception {
        EtatStock etatStock = new EtatStock(dateDebut, dateFin);
        
        String query = "SELECT * FROM get_etat_stock('"+dateDebut+"', '"+dateFin+"')";

        Connection connection = null;
        Statement statement = null;
        ResultSet resultset = null;

        try {
            connection = DBConnection.getConnection();
            statement = connection.createStatement();
            resultset = statement.executeQuery(query);

            while (resultset.next()) {
                int idMatiere = resultset.getInt("id_matiere");
                String matiereString = resultset.getString("matiere");
                String unity = resultset.getString("unity");
                Double quantiteInitial = resultset.getDouble("quantite_initial");
                Double entree = resultset.getDouble("entree");
                Double sortie = resultset.getDouble("sortie");
                Double quantiteFinal = (entree - sortie);
                Double prixUnitaire = resultset.getDouble("prix_unitaire");
                Double montant = prixUnitaire * quantiteFinal;
                
                Stock stock = new Stock(idMatiere, matiereString, unity, quantiteInitial, entree, sortie, quantiteFinal, prixUnitaire, montant);
                etatStock.getStockList().add(stock);
            }

            resultset.close();
            statement.close();
            connection.close();

            return etatStock;
        } catch (Exception e) {
            if (resultset != null) {
                resultset.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
            throw e;
        }
    }
    public static EtatStock getEtatStock(LocalDate targetDate, Integer idMatierePara) throws Exception {
        EtatStock etatStock = new EtatStock();
        
        String query = "SELECT * FROM get_etat_stock('"+targetDate+"') WHERE id_matiere = "+idMatierePara;

        Connection connection = null;
        Statement statement = null;
        ResultSet resultset = null;

        try {
            connection = DBConnection.getConnection();
            statement = connection.createStatement();
            resultset = statement.executeQuery(query);

            while (resultset.next()) {
                int idMatiere = resultset.getInt("id_matiere");
                String matiereString = resultset.getString("matiere");
                String unity = resultset.getString("unity");
                Double quantiteInitial = resultset.getDouble("quantite_initial");
                Double entree = resultset.getDouble("entree");
                Double sortie = resultset.getDouble("sortie");
                Double quantiteFinal = (entree - sortie);
                Double prixUnitaire = resultset.getDouble("prix_unitaire");
                Double montant = prixUnitaire * quantiteFinal;
                
                Stock stock = new Stock(idMatiere, matiereString, unity, quantiteInitial, entree, sortie, quantiteFinal, prixUnitaire, montant);
                etatStock.getStockList().add(stock);
            }

            resultset.close();
            statement.close();
            connection.close();

            return etatStock;
        } catch (Exception e) {
            if (resultset != null) {
                resultset.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
            throw e;
        }
    }
}
