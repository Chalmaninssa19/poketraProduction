/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.user;

import generalisation.GenericDAO.GenericDAO;
import generalisation.annotations.DBField;
import generalisation.annotations.DBTable;
import java.time.LocalDate;
/**
 *
 * @author protosam
 */
@DBTable(name = "client",sequenceName = "seq_client")
public class Client {
    @DBField(name="id_client", isPrimaryKey = true)
    int idClient;
    
    @DBField(name="nom")
    String nom;
    
    @DBField(name="prenom")
    String prenom;
    
    @DBField(name="date_naissance")
    LocalDate date_naissance;
    
    @DBField(name="email")
    String email;
    
    @DBField(name="id_genre", isForeignKey = true)
    Genre genre;

       //getters et setters
    
    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
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

    public LocalDate getDate_naissance() {
        return date_naissance;
    }
    public void setDate_naissance(LocalDate date_naissance) {
        this.date_naissance = date_naissance;
    }
    public void setDateNaissance(String dateNaissance) throws Exception {
        if(dateNaissance.trim().equals("") || dateNaissance == null) {
            throw new Exception("Veuillez saisir une valeur");
        }
        LocalDate date = LocalDate.parse(dateNaissance);
        this.setDate_naissance(date);
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) throws Exception {
        if(email.trim().equals("") || email == null) {
            throw new Exception("Veuillez saisir une valeur");
        }
        this.email = email;
    }

    public Genre getGenre() {
        return genre;
    }
    public void setGenre(Genre genre) {
        this.genre = genre;
    }
     public void setGenre(String idGenre) throws Exception {
         Genre genre = GenericDAO.findById(Genre.class, idGenre, null);
        this.setGenre(genre);
    }
    public String getGenreLetter() {
        if(this.getGenre().getIdGenre() == 1) {
            return "Masculin";
        } else {
            return "Feminin";
        }
    }
    
    //Constructeurs

    public Client() {
    }

    public Client(int idClient, String nom, String prenom, LocalDate date_naissance, String email, Genre genre) {
        this.idClient = idClient;
        this.nom = nom;
        this.prenom = prenom;
        this.date_naissance = date_naissance;
        this.email = email;
        this.genre = genre;
    }

    public Client(String nom, String prenom, LocalDate date_naissance, String email, Genre genre) {
        this.nom = nom;
        this.prenom = prenom;
        this.date_naissance = date_naissance;
        this.email = email;
        this.genre = genre;
    }

    public Client(String nom, String prenom, String email, String date, String genre) throws Exception {
        try {
            this.setNom(nom);
            this.setPrenom(prenom);
            this.setDateNaissance(date);
            this.setEmail(email);
            this.setGenre(genre);
        } catch(Exception e) {
            throw e;
        }
    }
    
    
    
}
