/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.formule;

import generalisation.GenericDAO.GenericDAO;
import generalisation.annotations.DBField;
import generalisation.annotations.DBTable;
import java.util.ArrayList;
import java.util.List;
import model.features_product.Look;
import model.features_product.Matiere;
import model.features_product.Size;
import model.features_product.Type;

/**
 *
 * @author chalman
 */
@DBTable(name = "quantity_matiere_production", sequenceName = "seq_quantity_matiere_production")
public class QuantityMatiereProduction {
    @DBField(name="id_quantity_matiere_production", isPrimaryKey = true)
    private int idQuantityMatiereProduction;
    
    @DBField(name="id_size", isForeignKey = true)
    private Size size;
     
    @DBField(name="id_type", isForeignKey = true)
    private Type type;
      
    @DBField(name="id_look", isForeignKey = true)
    private Look look;
    
    @DBField(name="status")
    private Integer status;
    
    List<MatiereQuantity> matiereQuantitys = new ArrayList<>();
    
///Getters et setters

    public int getIdQuantityMatiereProduction() {
        return idQuantityMatiereProduction;
    }

    public void setIdQuantityMatiereProduction(int idQuantityMatiereProduction) {
        this.idQuantityMatiereProduction = idQuantityMatiereProduction;
    }

    public Size getSize() {
        return size;
    }
    public void setSize(Size size) {
        this.size = size;
    }
    public void setSize(String size) throws Exception {
        Size sizeObject = GenericDAO.findById(Size.class, size, null);
        this.setSize(sizeObject);
    }

    public Type getType() {
        return type;
    }
    public void setType(Type type) {
        this.type = type;
    }
    public void setType(String type) throws Exception {
        Type typeObject = GenericDAO.findById(Type.class, type, null);
        this.setType(typeObject);
    }

    public Look getLook() {
        return look;
    }
    public void setLook(Look look) {
        this.look = look;
    }
    public void setLook(String look) throws Exception {
        Look lookObject = GenericDAO.findById(Look.class, look, null);
        this.setLook(lookObject);
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<MatiereQuantity> getMatiereQuantitys() {
        return matiereQuantitys;
    }

    public void setMatiereQuantitys(List<MatiereQuantity> matiereQuantitys) {
        this.matiereQuantitys = matiereQuantitys;
    }
    
///Constructors

    public QuantityMatiereProduction() {
    }

    public QuantityMatiereProduction(int idQuantityMatiereProduction, Size size, Type type, Look look, Integer status) {
        this.idQuantityMatiereProduction = idQuantityMatiereProduction;
        this.size = size;
        this.type = type;
        this.look = look;
        this.status = status;
    }

    public QuantityMatiereProduction(Size size, Type type, Look look, Integer status) {
        this.size = size;
        this.type = type;
        this.look = look;
        this.status = status;
    }
    
    public QuantityMatiereProduction(String size, String type, String look) throws Exception {
        try {
            this.setSize(size);
            this.setType(type);
            this.setLook(look);
            this.setStatus(1);
        } catch(Exception e) {
            throw e;
        }
    }
///Fonctions
    public MatiereQuantity addMatiereQuantity(String idMatiere, String quantity) throws Exception {
        if(quantity.trim().equals("") || quantity == null) {
            throw new Exception("Veuillez saisir une valeur");
        }
        
        Matiere matiere = GenericDAO.findById(Matiere.class, idMatiere, null);
        Double quantityParsed = Double.valueOf(quantity);
        
        if(quantityParsed < 0) {
            throw new Exception("Valeur quantite doit etre positive");
        }
        
        MatiereQuantity matiereQuantity = new MatiereQuantity();
        
        //Verification de l'existence de la matiere dans la liste
        if(isMatiereInList(matiere, quantityParsed) != -1) {
            int idMatiereAdded = isMatiereInList(matiere, quantityParsed);
            this.getMatiereQuantitys().get(idMatiereAdded).setQuantity(this.getMatiereQuantitys().get(idMatiereAdded).getQuantity() + quantityParsed);
            this.getMatiereQuantitys().get(idMatiereAdded).setIsExist(true);
            
            return this.getMatiereQuantitys().get(idMatiereAdded);
        } else {
            matiereQuantity = new MatiereQuantity(matiere, quantityParsed);
            this.getMatiereQuantitys().add(matiereQuantity);
            matiereQuantity.setIsExist(false);
        }

        return matiereQuantity;
    }

    //Verifier si la matiere est deja ajoute dans la liste
    public int isMatiereInList(Matiere matiere, Double newQuantity) throws Exception {
        for(int i = 0; i < this.getMatiereQuantitys().size(); i++) {
            if(matiere.getIdMatiere() == this.getMatiereQuantitys().get(i).getMatiere().getIdMatiere()) {
                return i;
            }
        }
        
        return -1;
    }
    
    // supprimer une matiere quantite
    public void deleteMatiereQuantity(String idMatiere) throws Exception {
        if (idMatiere.trim().equals("")) {
            throw new Exception("La matiere ne doit pas être vide ou null !");
        }

        for (int i = 0; i < this.getMatiereQuantitys().size(); i++) {
            if (this.getMatiereQuantitys().get(i).getMatiere().getIdMatiere() == Integer.valueOf(idMatiere)) {
                this.getMatiereQuantitys().remove(i);
            }
        }
    }

    // Pour avoir les informations a propos d'une demande
    public void getInformation() {
        for (MatiereQuantity matiereQuantity : this.getMatiereQuantitys()) {
            System.out.println("matiere = "+matiereQuantity.getMatiere().getName()+ ", quantity = " + matiereQuantity.getQuantity());
        }
    }
    
    //Sauvgarder les demandes
    public void save() throws Exception {
        GenericDAO.save(this, null);
        for(MatiereQuantity item : this.getMatiereQuantitys()) {
            item.setQuantityMatiereProduction(this);
            GenericDAO.save(item, null);
        }
    } 
}
