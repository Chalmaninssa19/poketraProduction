/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.formule;

import generalisation.GenericDAO.GenericDAO;
import generalisation.annotations.DBField;
import generalisation.annotations.DBTable;
import java.util.List;
import model.employe.Profession;
import model.features_product.Look;
import model.features_product.Size;
import model.features_product.Type;

/**
 *
 * @author chalman
 */
@DBTable(name = "duration_production", sequenceName = "seq_duration_production")
public class DurationProduction {
    @DBField(name="id_duration_production", isPrimaryKey = true)
    private int idDurationProduction;
    
    @DBField(name="id_size", isForeignKey = true)
    private Size size;
     
    @DBField(name="id_type", isForeignKey = true)
    private Type type;
      
    @DBField(name="id_look", isForeignKey = true)
    private Look look;
    
    @DBField(name="duration")
    private Double duration;
    
    @DBField(name="status")
    private Integer status;
    
    @DBField(name="id_profession", isForeignKey = true)
    private Profession profession;
      
    @DBField(name="nombre_employe")
    private Integer nombreEmploye;
    
///Getters et setters

    public int getIdDurationProduction() {
        return idDurationProduction;
    }

    public void setIdDurationProduction(int idDurationProduction) {
        this.idDurationProduction = idDurationProduction;
    }

    public Size getSize() {
        return size;
    }
    public void setSize(Size size) {
        this.size = size;
    }
    public void setSize(String idSize) throws Exception {
        Size size = GenericDAO.findById(Size.class, idSize, null);
        this.setSize(size);
    }

    public Type getType() {
        return type;
    }
    public void setType(Type type) {
        this.type = type;
    }
    public void setType(String idType) throws Exception {
        Type type = GenericDAO.findById(Type.class, idType, null);
        this.setType(type);
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

    public Double getDuration() {
        return duration;
    }
    public void setDuration(Double duration) {
        this.duration = duration;
    }
    public void setDuration(String duration) throws Exception {
        if(duration.trim().equals("") || duration == null) {
            throw new Exception("Veuillez saisir une valeur");
        }
        Double durationParsed = Double.valueOf(duration);
        if(durationParsed < 0) {
            throw new Exception("Duree doit etre positive");
        }
        this.duration = durationParsed;
    }

    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) throws Exception {
        if(isExist(this.getSize().getIdSize(),  this.getLook().getIdLook(),this.getType().getIdType(), this.getProfession().getIdProfession())) {
            throw new Exception("Cette formule existe deja");
        }
        this.status = status;
    }

    public Profession getProfession() {
        return profession;
    }
    public void setProfession(Profession profession) {
        this.profession = profession;
    }
    public void setProfession(String idProfession) throws Exception {
        Profession profession = GenericDAO.findById(Profession.class, idProfession, null);
        this.setProfession(profession);
    }

    public Integer getNombreEmploye() {
        return nombreEmploye;
    }
    public void setNombreEmploye(Integer nombreEmploye) {
        this.nombreEmploye = nombreEmploye;
    }
    public void setNombreEmploye(String nombreEmploye) throws Exception {
        if(nombreEmploye.trim().equals("") || nombreEmploye == null) {
            throw new Exception("Veuillez saisir une valeur");
        }
        Integer nombreParsed = Integer.valueOf(nombreEmploye);
        if(nombreParsed < 0) {
            throw new Exception("Duree doit etre positive");
        }
        this.nombreEmploye = nombreParsed;
    }

    
///Constructors

    public DurationProduction() {
    }

    public DurationProduction(int idDurationProduction, Size size, Type type, Look look, Double duration, Integer status, Profession profession, Integer nombreEmploye) {
        this.idDurationProduction = idDurationProduction;
        this.size = size;
        this.type = type;
        this.look = look;
        this.duration = duration;
        this.status = status;
        this.profession = profession;
        this.nombreEmploye = nombreEmploye;
    }

    public DurationProduction(Size size, Type type, Look look, Double duration, Integer status, Profession profession, Integer nombreEmploye) {
        this.size = size;
        this.type = type;
        this.look = look;
        this.duration = duration;
        this.status = status;
        this.profession = profession;
        this.nombreEmploye = nombreEmploye;
    }
    
    public DurationProduction(String size, String type, String look, String duration, String role, String nombreEmploye) throws Exception {
        try {
            this.setSize(size);
            this.setType(type);
            this.setLook(look);
            this.setDuration(duration);
            this.setStatus(1);
            this.setProfession(role);
            this.setNombreEmploye(nombreEmploye);
        } catch(Exception e) {
            throw e;
        }
    }
///Fonctions
    public boolean isExist(int size, int look, int type, int idProfession) throws Exception {
        String sql = "SELECT * FROM duration_production WHERE id_size = "+size+"AND id_type = "+type+" AND id_look = "+look+" AND id_profession = "+idProfession+" AND status != 0";
        List<DurationProduction> durationProduction = (List<DurationProduction>) GenericDAO.directQuery(DurationProduction.class, sql, null);
        if(durationProduction.size() == 0) {
            return false;
        }
        
        return true;
    }
}
