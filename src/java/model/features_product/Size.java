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
@DBTable(name = "size", sequenceName = "seq_size")
public class Size {
    @DBField(name="id_size", isPrimaryKey = true)
    private int idSize;
    
    @DBField(name="name")
    private String name;
    
    @DBField(name="status")
    private Integer status;
    
/// Getters et setters
    public int getIdSize() {
        return idSize;
    }

    public void setIdSize(int idSize) {
        this.idSize = idSize;
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
    
/// Constructors

    public Size() {
    }

    public Size(int idSize, String name, Integer status) {
        this.idSize = idSize;
        this.name = name;
        this.status = status;
    }

    public Size(String name, Integer status) throws Exception {
        try {
            this.setName(name);
            this.setStatus(status);
        } catch(Exception e) {
            throw e;
        }
    }

/// Fonctions
    public boolean isExist(String name) throws Exception {
        String sql = "SELECT * FROM size WHERE name = '"+name+"' AND status != 0";
        List<Size> size = (List<Size>) GenericDAO.directQuery(Size.class, sql, null);
        if(size.size() == 0) {
            return false;
        }
        
        return true;
    }

}
