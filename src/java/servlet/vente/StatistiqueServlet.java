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
import java.util.ArrayList;
import java.util.List;
import model.production.Product;
import model.vente.VStatGenreAllProduct;
import model.vente.VStatVenteGenre;
import model.vente.VVenteClient;

/**
 *
 * @author chalman
 */
@WebServlet(name = "StatistiqueServlet", urlPatterns = {"/Statistique"})
public class StatistiqueServlet extends HttpServlet {

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
            out.println("<title>Servlet StatistiqueServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet StatistiqueServlet at " + request.getContextPath() + "</h1>");
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
            
            List<Product> products = (List<Product>)GenericDAO.getAll(Product.class, null, null);
            
            if(request.getAttribute("statFilterByProduct") != null) {
                request.setAttribute("statFilterByProduct", request.getAttribute("statFilterByProduct"));
            } else {
                List<VStatVenteGenre> vStatGenre = (List<VStatVenteGenre>)GenericDAO.getAll(VStatVenteGenre.class, null, null);
                request.setAttribute("allProduct", vStatGenre);

                List<VStatGenreAllProduct> statGenre = (List<VStatGenreAllProduct>)GenericDAO.getAll(VStatGenreAllProduct.class, null, null);
                request.setAttribute("statVenteByGenre", statGenre);
            }
            request.setAttribute("products", products);

            
            // All required assets
            List<String> css = new ArrayList<>();
            css.add("assets/css/supplier/supplier.css");
            css.add("assets/css/Statistique/Statistique.css");
            
            List<String> js = new ArrayList<>();
            js.add("assets/js/bootstrap.bundle.min.js");
            js.add("assets/js/chart/chart.js");
            js.add("assets/vendors/chart.js/Chart.min.js");

            request.setAttribute("css", css);
            request.setAttribute("js", js);
            
            // Page definition
            request.setAttribute("title", "Vente client");
            request.setAttribute("contentPage", "./pages/statistique/Statistique.jsp");
            
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
        doGet(request, response);
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
