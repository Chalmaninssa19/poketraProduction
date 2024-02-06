/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet.vente;

import generalisation.GenericDAO.GenericDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.vente.VStatGenreAllProduct;
import model.vente.VStatVenteGenre;

/**
 *
 * @author chalman
 */
@WebServlet(name = "ChargeDataJsonServlet", urlPatterns = {"/ChargeDataJson"})
public class ChargeDataJsonServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ChargeDataJsonServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ChargeDataJsonServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
             if(request.getSession().getAttribute("statProductFilter") != null) {
                List<VStatVenteGenre> stat = (List<VStatVenteGenre>)request.getSession().getAttribute("statProductFilter");
                // Simuler la récupération des données depuis une source de données (base de données, service, etc.)
                Double pinkValue = stat.get(0).getPercentNumber();
                Double blueValue = stat.get(1).getPercentNumber();

                // Convertir les données en format JSON
                String jsonData = "{ \"data\": [" + pinkValue + ", " + blueValue + " ] }";
                request.getSession().removeAttribute("statProductFilter");
                // Configurer l'en-tête de la réponse
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");

                // Écrire les données JSON dans le flux de sortie
                PrintWriter out = response.getWriter();
                out.print(jsonData);
                out.flush();            
            } else {
                List<VStatGenreAllProduct> statGenre = (List<VStatGenreAllProduct>)GenericDAO.getAll(VStatGenreAllProduct.class, null, null);

                // Simuler la récupération des données depuis une source de données (base de données, service, etc.)
                Double pinkValue = statGenre.get(0).getPercent();
                Double blueValue = statGenre.get(1).getPercent();

                // Convertir les données en format JSON
                String jsonData = "{ \"data\": [" + pinkValue + ", " + blueValue + " ] }";

                // Configurer l'en-tête de la réponse
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");

                // Écrire les données JSON dans le flux de sortie
                PrintWriter out = response.getWriter();
                out.print(jsonData);
                out.flush();
             }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            System.out.println("IO");
            System.out.println("statProduct = "+request.getSession().getAttribute("statProductFilter"));
            if(request.getSession().getAttribute("statProductFilter") != null) {
                List<VStatVenteGenre> stat = (List<VStatVenteGenre>)request.getSession().getAttribute("statProductFilter");
                // Simuler la récupération des données depuis une source de données (base de données, service, etc.)
                Double pinkValue = stat.get(0).getPercentNumber();
                Double blueValue = stat.get(1).getPercentNumber();

                // Convertir les données en format JSON
                String jsonData = "{ \"data\": [" + pinkValue + ", " + blueValue + " ] }";

                // Configurer l'en-tête de la réponse
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");

                // Écrire les données JSON dans le flux de sortie
                PrintWriter out = response.getWriter();
                out.print(jsonData);
                out.flush();            
            } else {
                List<VStatGenreAllProduct> vStatGenre = (List<VStatGenreAllProduct>)GenericDAO.getAll(VStatVenteGenre.class, null, null);

                // Simuler la récupération des données depuis une source de données (base de données, service, etc.)
                Double pinkValue = vStatGenre.get(0).getPercent();
                Double blueValue = vStatGenre.get(1).getPercent();

                // Convertir les données en format JSON
                String jsonData = "{ \"data\": [" + pinkValue + ", " + blueValue + " ] }";

                // Configurer l'en-tête de la réponse
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");

                // Écrire les données JSON dans le flux de sortie
                PrintWriter out = response.getWriter();
                out.print(jsonData);
                out.flush();
            
            }
           
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
