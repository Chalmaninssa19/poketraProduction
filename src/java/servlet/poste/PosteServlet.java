/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet.poste;

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
import model.employe.Profession;
import model.features_product.Look;
import model.grade.Grade;
import model.poste.Poste;
import model.poste.PosteGrade;
import model.poste.VPosteGrade;

/**
 *
 * @author chalman
 */
@WebServlet(name = "PosteServlet", urlPatterns = {"/Poste"})
public class PosteServlet extends HttpServlet {

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
            out.println("<title>Servlet PosteServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PosteServlet at " + request.getContextPath() + "</h1>");
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
            String sql ="SELECT * FROM profession WHERE status != 0";
            String sqlPoste ="SELECT * FROM poste WHERE status != 0";
            String sqlGrade ="SELECT * FROM grade WHERE status != 0";
            String sqlPosteGrade = "SELECT * FROM v_poste_grade WHERE (status_poste != 0 OR status_grade != 0) OR (status_poste != 0 AND status_grade != 0)";
            
            List<Poste> postes = (List<Poste>) GenericDAO.directQuery(Poste.class, sqlPoste, null);
            request.setAttribute("postes", postes);
            
            List<Grade> grades = (List<Grade>) GenericDAO.directQuery(Grade.class, sqlGrade, null);
            request.setAttribute("grades", grades);
            
            List<Profession> roles = (List<Profession>) GenericDAO.directQuery(Profession.class, sql, null);
            request.setAttribute("roles", roles);
            
             List<VPosteGrade> postegrades = (List<VPosteGrade>) GenericDAO.directQuery(VPosteGrade.class, sqlPosteGrade, null);
            request.setAttribute("postegrades", postegrades);
            
             // All required assets
            List<String> css = new ArrayList<>();
            css.add("assets/css/supplier/supplier.css");
            
            List<String> js = new ArrayList<>();
            js.add("assets/js/bootstrap.bundle.min.js");
            
            request.setAttribute("css", css);
            request.setAttribute("js", js);
            
            // Page definition
            request.setAttribute("title", "Poste");
            request.setAttribute("contentPage", "./pages/poste/poste.jsp");
            
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
            String nom = request.getParameter("name");
            Poste poste = new Poste(nom);
            GenericDAO.save(poste, null);
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
