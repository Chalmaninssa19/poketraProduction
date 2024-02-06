/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.formule;

import generalisation.GenericDAO.GenericDAO;
import generalisation.annotations.DBField;
import generalisation.annotations.DBTable;
import java.util.List;
import model.features_product.Look;
import model.features_product.Matiere;

/**
 *
 * @author chalman
 */
@DBTable(name = "look_matiere", sequenceName = "seq_look_matiere")
public class LookMatiere {
    @DBField(name="id_look_matiere", isPrimaryKey = true)
    private int idLookMatiere;
    
    @DBField(name="id_look", isForeignKey = true)
    private Look look;
    
    @DBField(name="id_matiere", isForeignKey = true)
    private Matiere matiere;
    
    @DBField(name="status")
    private Integer status;
    
///Getters et setters

    public int getIdLookMatiere() {
        return idLookMatiere;
    }

    public void setIdLookMatiere(int idLookMatiere) {
        this.idLookMatiere = idLookMatiere;
    }

    public Look getLook() {
        return look;
    }
    public void setLook(Look look) {
        this.look = look;
    }
    public void setLook(String idLook) throws Exception {
        Look look = GenericDAO.findById(Look.class, idLook, null);
        this.setLook(look);
    }

    public Matiere getMatiere() {
        return matiere;
    }
    public void setMatiere(Matiere matiere) {
        this.matiere = matiere;
    }
    public void setMatiere(String idMatiere) throws Exception {
        Matiere matiere = GenericDAO.findById(Matiere.class, idMatiere, null);
        this.setMatiere(matiere);
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) throws Exception{
        if(isExist(this.getLook().getIdLook(), this.getMatiere().getIdMatiere())) {
            throw new Exception("Cette formule existe deja");
        }
        this.status = status;
    }
    
///Constructors

    public LookMatiere() {
    }

    public LookMatiere(int idLookMatiere, Look look, Matiere matiere, Integer status) {
        this.idLookMatiere = idLookMatiere;
        this.look = look;
        this.matiere = matiere;
        this.status = status;
    }

    public LookMatiere(Look look, Matiere matiere, Integer status) {
        this.look = look;
        this.matiere = matiere;
        this.status = status;
    }
    
    public LookMatiere(String matiere, String look) throws Exception {
        try {
            this.setLook(look);
            this.setMatiere(matiere);
            this.setStatus(1);
        } catch(Exception e) {
            throw e;
        }
    }
///Fonctions
    public void save() throws Exception {
        GenericDAO.save(this, null);
    }
    
    public boolean isExist(int look, int matiere) throws Exception {
        String sql = "SELECT * FROM look_matiere WHERE id_look = "+look+" AND id_matiere = "+matiere+" AND status != 0";
        List<LookMatiere> lookMatiere = (List<LookMatiere>) GenericDAO.directQuery(LookMatiere.class, sql, null);
        if(lookMatiere.size() == 0) {
            return false;
        }
        
        return true;
    }
}
