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
@DBTable(name = "type", sequenceName = "seq_type")
public class Type {
    @DBField(name="id_type", isPrimaryKey = true)
    private int idType;
    
    @DBField(name="name")
    private String name;
    
    @DBField(name="status")
    private Integer status;
    
///Getters et setters

    public int getIdType() {
        return idType;
    }

    public void setIdType(int idType) {
        this.idType = idType;
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

    public Type() {
    }

    public Type(int idType, String name, Integer status) {
        this.idType = idType;
        this.name = name;
        this.status = status;
    }
    
    public Type(String name, Integer status) throws Exception {
        try {
            this.setName(name);
            this.setStatus(status);
        } catch(Exception e) {
            throw e;
        }
    }

///Fonctions
     public boolean isExist(String name) throws Exception {
        String sql = "SELECT * FROM type WHERE name = '"+name+"' AND status != 0";
        List<Type> type = (List<Type>) GenericDAO.directQuery(Type.class, sql, null);
        if(type.size() == 0) {
            return false;
        }
        
        return true;
    }
}
