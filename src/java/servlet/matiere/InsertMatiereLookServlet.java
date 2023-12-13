/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet.matiere;

import connection.DBConnection;
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
import model.look.Look;
import model.look.Matiere;
import model.look.RMatiereLook;

/**
 *
 * @author chalman
 */
@WebServlet(name = "InsertMatiereLookServlet", urlPatterns = {"/InsertMatiereLook"})
public class InsertMatiereLookServlet extends HttpServlet {

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
            out.println("<title>Servlet InsertMatiereLookServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet InsertMatiereLookServlet at " + request.getContextPath() + "</h1>");
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
            
            List<Matiere> matieres = (List<Matiere>) GenericDAO.getAll(Matiere.class, null, null);
            List<Look> looks = (List<Look>) GenericDAO.getAll(Look.class, null, null);
            request.setAttribute("matieres", matieres);
            request.setAttribute("looks", looks);
            
            // All required assets
            List<String> css = new ArrayList<>();
            css.add("assets/css/style.css");
            
            List<String> js = new ArrayList<>();
            js.add("assets/js/bootstrap.bundle.min.js");
            
            request.setAttribute("css", css);
            request.setAttribute("js", js);
            
            // Page definition
            request.setAttribute("title", "Insertion matiere look");
            request.setAttribute("contentPage", "./pages/matiere/insertMatiereLook.jsp");

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
            String idMatiere = request.getParameter("matiere");
            String idLook = request.getParameter("look");
            
            RMatiereLook matiereLook = new RMatiereLook(idMatiere, idLook);
            GenericDAO.save(matiereLook, null);
            doGet(request, response);
            
        } catch(Exception e) {
            request.setAttribute("error", e.getMessage());
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
