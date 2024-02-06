/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.features_product;

import generalisation.GenericDAO.GenericDAO;
import generalisation.annotations.DBField;
import generalisation.annotations.DBTable;
import java.util.List;

/**
 *
 * @author chalman
 */
@DBTable(name = "look", sequenceName = "seq_look")
public class Look {
    @DBField(name="id_look", isPrimaryKey = true)
    private int idLook;
    
    @DBField(name="name")
    private String name;
    
    @DBField(name="status")
    private Integer status;
    
///Getters et setters

    public int getIdLook() {
        return idLook;
    }

    public void setIdLook(int idLook) {
        this.idLook = idLook;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws Exception {
        if(name.trim().equals("") || name == null) {
            throw new Exception("Veuillez saisir une valeur");
        }
        if(isExist(name)) {
            throw new Exception("La valeur saisie existe deja, veuillez le changer");
        }
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    
///Constructors

    public Look() {
    }

    public Look(int idLook, String name, Integer status) {
        this.idLook = idLook;
        this.name = name;
        this.status = status;
    }

    public Look(String name, Integer status) throws Exception {
        try {
            this.setName(name);
            this.setStatus(status);
        } catch(Exception e) {
            throw e;
        }
    }

///Fonctions
    public boolean isExist(String name) throws Exception {
        String sql = "SELECT * FROM look WHERE name = '"+name+"' AND status != 0";
        List<Look> look = (List<Look>) GenericDAO.directQuery(Look.class, sql, null);
        if(look.size() == 0) {
            return false;
        }
        
        return true;
    }
    
}
