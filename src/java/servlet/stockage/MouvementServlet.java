/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet.stockage;

import generalisation.GenericDAO.GenericDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import model.features_product.Look;
import model.features_product.Matiere;
import model.features_product.Size;
import model.features_product.Type;
import model.stockage.Entree;
import model.stockage.Sortie;

/**
 *
 * @author chalman
 */
@WebServlet(name = "MouvementServlet", urlPatterns = {"/Mouvement"})
public class MouvementServlet extends HttpServlet {

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
            out.println("<title>Servlet MouvementServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet MouvementServlet at " + request.getContextPath() + "</h1>");
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
             //Liste des objets necessaires a l'affichage
            String sqlMatiere ="SELECT * FROM matiere WHERE status != 0";
            
            List<Matiere> matieres = (List<Matiere>)GenericDAO.directQuery(Matiere.class, sqlMatiere, null);

            request.setAttribute("matieres", matieres);
            
             // All required assets
            List<String> css = new ArrayList<>();
            css.add("assets/css/supplier/supplier.css");
            
            List<String> js = new ArrayList<>();
            js.add("assets/js/bootstrap.bundle.min.js");
            
            request.setAttribute("css", css);
            request.setAttribute("js", js);
            
            // Page definition
            request.setAttribute("title", "Stockage");
            request.setAttribute("contentPage", "./pages/stockage/mouvements.jsp");
            
            request.getRequestDispatcher("./template.jsp").forward(request, response);
        } catch(Exception e) {
            request.setAttribute("error", e.getMessage());
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
            if(request.getParameter("typeMouvement").equals("1")) {   //Entree
                String matiere = request.getParameter("matiere");
                String prixUnitaire = request.getParameter("prixUnitaire");
                String quantite = request.getParameter("quantite");
                String date = request.getParameter("date");
                
                Entree entree = new Entree(matiere, prixUnitaire, quantite, date);
                GenericDAO.save(entree, null);
            } else if (request.getParameter("typeMouvement").equals("2")) {    //Sortie
                String matiere = request.getParameter("matiere");
                String quantite = request.getParameter("quantite");
                String date = request.getParameter("date");
                
                Sortie sortie = new Sortie(matiere, quantite, date);
                GenericDAO.save(sortie, null);
            }
            doGet(request, response);
        } catch(Exception e) {
            request.setAttribute("error", e.getMessage());
            e.printStackTrace();
            doGet(request, response);
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
