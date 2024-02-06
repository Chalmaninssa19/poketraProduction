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
@DBTable(name = "unity", sequenceName = "seq_unity")
public class Unity {
    @DBField(name="id_unity", isPrimaryKey = true)
    private int idUnity;
    
    @DBField(name="name")
    private String name;
    
    @DBField(name="status")
    private Integer status;
    
///Getters et setters

    public int getIdUnity() {
        return idUnity;
    }

    public void setIdUnity(int idUnity) {
        this.idUnity = idUnity;
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

    public Unity() {
    }

    public Unity(int idUnity, String name, Integer status) {
        this.idUnity = idUnity;
        this.name = name;
        this.status = status;
    }
    
    public Unity(String name, Integer status) throws Exception {
        try {
            this.setName(name);
            this.setStatus(status);
        } catch(Exception e) {
            throw e;
        }
    }

///Fonctions
    public boolean isExist(String name) throws Exception {
        String sql = "SELECT * FROM unity WHERE name = '"+name+"' AND status != 0";
        List<Unity> unity = (List<Unity>) GenericDAO.directQuery(Unity.class, sql, null);;
        if(unity.size() == 0) {
            return false;
        }
        
        return true;
    }
    
}
