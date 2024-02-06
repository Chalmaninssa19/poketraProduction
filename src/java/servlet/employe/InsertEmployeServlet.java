/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet.employe;

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
import model.employe.Employe;
import model.employe.Profession;
import model.poste.PosteGrade;
import model.poste.VPosteGrade;
import utilitaire.DateManagement;
import utilitaire.Util;

/**
 *
 * @author chalman
 */
@WebServlet(name = "InsertEmployeServlet", urlPatterns = {"/InsertEmploye"})
public class InsertEmployeServlet extends HttpServlet {

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
            out.println("<title>Servlet InsertEmployeServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet InsertEmployeServlet at " + request.getContextPath() + "</h1>");
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
            //Liste
            String sql ="SELECT * FROM v_poste_grade WHERE (status_poste != 0 OR status_grade != 0) OR (status_poste != 0 AND status_grade != 0)";
            List<VPosteGrade> roles = (List<VPosteGrade>) GenericDAO.directQuery(VPosteGrade.class, sql, null);
            request.setAttribute("professions", roles);
            
             // All required assets
            List<String> css = new ArrayList<>();
            css.add("assets/css/supplier/supplier.css");
            
            List<String> js = new ArrayList<>();
            js.add("assets/js/bootstrap.bundle.min.js");
            
            request.setAttribute("css", css);
            request.setAttribute("js", js);
            
            // Page definition
            request.setAttribute("title", "Employe insertion");
            request.setAttribute("contentPage", "./pages/employe/insertEmploye.jsp");
            
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
            String nom = request.getParameter("nom");
            String prenom = request.getParameter("prenom");
            String dtn = request.getParameter("dateNaissance");
            String role = request.getParameter("role");
            String dateEmbauche = request.getParameter("dateEmbauche");
            
            Employe employe = new Employe(nom, prenom, dtn, role, dateEmbauche);
            int yearToWork = DateManagement.getDifferenceInYear(employe.getDateEmbauche());
            PosteGrade posteGrade = GenericDAO.findById(PosteGrade.class, role, null);
            
            PosteGrade posteGradeFinded = employe.getIdPosteGradeConvenable(yearToWork, posteGrade);
            employe.setPosteGrade(posteGradeFinded);
            GenericDAO.save(employe, null);
            response.sendRedirect("ListEmploye");
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
