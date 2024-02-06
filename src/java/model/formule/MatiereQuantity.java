/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.formule;

import generalisation.annotations.DBField;
import generalisation.annotations.DBTable;
import model.features_product.Matiere;
import model.features_product.Type;

/**
 *
 * @author chalman
 */
@DBTable(name = "matiere_quantity", sequenceName = "seq_matiere_quantity")
public class MatiereQuantity {
    @DBField(name="id_matiere_quantity", isPrimaryKey = true)
    private int idMatiereQuantity;
    
    @DBField(name="id_matiere", isForeignKey = true)
    private Matiere matiere;
    
    @DBField(name="id_quantity_matiere_production", isForeignKey = true)
    private QuantityMatiereProduction quantityMatiereProduction;
    
    @DBField(name="quantity")
    private Double quantity;
    
    private boolean isExist;
    
///Getters et setters

    public int getIdMatiereQuantity() {
        return idMatiereQuantity;
    }

    public void setIdMatiereQuantity(int idMatiereQuantity) {
        this.idMatiereQuantity = idMatiereQuantity;
    }

    public Matiere getMatiere() {
        return matiere;
    }

    public void setMatiere(Matiere matiere) {
        this.matiere = matiere;
    }

    public QuantityMatiereProduction getQuantityMatiereProduction() {
        return quantityMatiereProduction;
    }

    public void setQuantityMatiereProduction(QuantityMatiereProduction quantityMatiereProduction) {
        this.quantityMatiereProduction = quantityMatiereProduction;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public boolean isIsExist() {
        return isExist;
    }

    public void setIsExist(boolean isExist) {
        this.isExist = isExist;
    }
    
///Constructors

    public MatiereQuantity() {
    }

    public MatiereQuantity(int idMatiereQuantity, Matiere matiere, QuantityMatiereProduction quantityMatiereProduction, Double quantity) {
        this.idMatiereQuantity = idMatiereQuantity;
        this.matiere = matiere;
        this.quantityMatiereProduction = quantityMatiereProduction;
        this.quantity = quantity;
    }

    public MatiereQuantity(Matiere matiere, QuantityMatiereProduction quantityMatiereProduction, Double quantity) {
        this.matiere = matiere;
        this.quantityMatiereProduction = quantityMatiereProduction;
        this.quantity = quantity;
    }
    
    public MatiereQuantity(Matiere matiere, Double quantity) {
        this.matiere = matiere;
        this.quantity = quantity;
    }
///Fonctions
   
}
