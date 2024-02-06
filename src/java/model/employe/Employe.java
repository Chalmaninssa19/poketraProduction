/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.employe;

/**
 *
 * @author isaia
 */
import generalisation.GenericDAO.GenericDAO;
import generalisation.annotations.DBField;
import generalisation.annotations.DBTable;
import java.time.LocalDate;
import java.util.List;
import model.grade.VParamGraduation;
import model.poste.PosteGrade;

@DBTable(name = "employe", sequenceName = "seq_employe")
public class Employe {
    
    @DBField(name="id_employe", isPrimaryKey = true)
    private int idEmploye;
    
    @DBField(name="nom")
    private String nom;
    
    @DBField(name="prenom")
    private String prenom;
    
    @DBField(name="date_naissance")
    private LocalDate dateNaissance;
    
    @DBField(name="id_poste_grade", isForeignKey= true)
    private PosteGrade posteGrade;
    
    @DBField(name="status")
    private Integer status ;
    
    @DBField(name="date_embauche")
    private LocalDate dateEmbauche;
      

// getter and setter
    public String getId() {
        return "Emp00"+this.getIdEmploye();
    }
    public int getIdEmploye() {
        return idEmploye;
    }

    public void setIdEmploye(int idEmploye) {
        this.idEmploye = idEmploye;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) throws Exception {
        if(nom.trim().equals("") || nom == null) {
            throw new Exception("Veuillez saisir une valeur");
        }
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) throws Exception {
        if(prenom.trim().equals("") || prenom == null) {
            throw new Exception("Veuillez saisir une valeur");
        }
        this.prenom = prenom;
    }

    public PosteGrade getPosteGrade() {
        return posteGrade;
    }
    public void setPosteGrade(PosteGrade posteGrade) {
        this.posteGrade = posteGrade;
    }
     public void setPosteGrade(String idPosteGrade) throws Exception {
        PosteGrade posteGrade = GenericDAO.findById(PosteGrade.class, idPosteGrade, null);
        this.setPosteGrade(posteGrade);
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }
    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }
    public void setDateNaissance(String dateNaisance) throws Exception {
        if(dateNaisance.trim().equals("") || dateNaisance == null) {
            throw new Exception("Veuillez saisir une valeur");
        }
        LocalDate date = LocalDate.parse(dateNaisance);
        this.setDateNaissance(date);
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public LocalDate getDateEmbauche() {
        return dateEmbauche;
    }

    public void setDateEmbauche(LocalDate dateEmbauche) {
        this.dateEmbauche = dateEmbauche;
    }
    public void setDateEmbauche(String dateEmbauche) throws Exception {
        if(dateEmbauche.trim().equals("") || dateEmbauche == null) {
            throw new Exception("Veuillez saisir une valeur");
        }
        LocalDate date = LocalDate.parse(dateEmbauche);
        this.setDateEmbauche(date);
    }
    
///Coonstructors

    public Employe() {
    }

    public Employe(int idEmploye, String nom, String prenom, LocalDate dateNaissance, PosteGrade posteGrade, Integer status, LocalDate dateEmbauche) {
        this.idEmploye = idEmploye;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.posteGrade = posteGrade;
        this.status = status;
        this.dateEmbauche = dateEmbauche;
    }

    public Employe(String nom, String prenom, LocalDate dateNaissance, PosteGrade profession, Integer status, LocalDate dateEmbauche) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.posteGrade = profession;
        this.status = status;
        this.dateEmbauche = dateEmbauche;
    }

    public Employe(String nom, String prenom, String dateNaissance, String role, String dateEmbauche) throws Exception {
        try {
            this.setNom(nom);
            this.setPrenom(prenom);
            this.setDateNaissance(dateNaissance);
            this.setPosteGrade(role);
            this.setStatus(1);
            this.setDateEmbauche(dateEmbauche);
        } catch(Exception e) {
            throw e;
        }
    }
    
///Fonctions
    public PosteGrade getIdPosteGradeConvenable(int year, PosteGrade posteGrade) throws Exception {
        String sql = "select * from v_param_graduation WHERE id_poste_ancien="+posteGrade.getPoste().getIdPoste()+" AND niveau >= "+posteGrade.getGrade().getNiveau()+" ORDER BY niveau ASC";
        
        int idPosteGradeAJour = 0;
        int valueYear = year;
        
        List<VParamGraduation> paramGraduation = (List<VParamGraduation>)GenericDAO.directQuery(VParamGraduation.class, sql, null);
        
        if(paramGraduation.size() <= 0) {
            return posteGrade;
        } 
        for(VParamGraduation item : paramGraduation) {
            if(item.getDuree() - valueYear < 0) {
                idPosteGradeAJour = item.getIdPosteGradeAjour();
                valueYear = valueYear - item.getDuree();
            } else {
                 idPosteGradeAJour = item.getIdPosteGradeAncien();
                 break;
            }
        }
        return GenericDAO.findById(PosteGrade.class, idPosteGradeAJour, null);
    }
}
