/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.formule;

import generalisation.annotations.DBField;
import generalisation.annotations.DBTable;

/**
 *
 * @author chalman
 */
@DBTable(name = "v_quantity_production", sequenceName = "")
public class VQuantityProduction {
    @DBField(name="id_quantity_matiere_production")
    private Integer idQuantityMatiereProduction;
    
    @DBField(name="look")
    private String look;
    
    @DBField(name="type")
    private String type;
    
    @DBField(name="size")
    private String size;
    
    @DBField(name="matiere")
    private String matiere;
    
    @DBField(name="quantity")
    private Double quantity;
    
    @DBField(name="status")
    private Integer status;
    
///Getters et setters

    public Integer getIdQuantityMatiereProduction() {
        return idQuantityMatiereProduction;
    }

    public void setIdQuantityMatiereProduction(Integer idQuantityMatiereProduction) {
        this.idQuantityMatiereProduction = idQuantityMatiereProduction;
    }

    public String getLook() {
        return look;
    }

    public void setLook(String look) {
        this.look = look;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getMatiere() {
        return matiere;
    }

    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    
///Constructors

    public VQuantityProduction() {
    }

    public VQuantityProduction(Integer idQuantityMatiereProduction, String look, String type, String size, String matiere, Double quantity, Integer status) {
        this.idQuantityMatiereProduction = idQuantityMatiereProduction;
        this.look = look;
        this.type = type;
        this.size = size;
        this.matiere = matiere;
        this.quantity = quantity;
        this.status = status;
    }
    
}
