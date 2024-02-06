/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilitaire;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

/**
 *
 * @author Chalman
 */
public class DateManagement {
    public static LocalDate dateToLocalDate(Date date) throws Exception {
        return LocalDate.parse(date.toString());
    }
    
    public static int getDifferenceInYear(LocalDate date) throws Exception {
        Period period = Period.between(date, LocalDate.now());
        
        return period.getYears();
    }
}
