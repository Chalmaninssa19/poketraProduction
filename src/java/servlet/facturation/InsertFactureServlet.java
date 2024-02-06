/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet.facturation;

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
import model.facturation.Facture;
import model.facturation.FactureDetails;
import model.features_product.Look;
import model.production.VProductPrice;
import model.user.Client;

/**
 *
 * @author chalman
 */
@WebServlet(name = "InsertFactureServlet", urlPatterns = {"/InsertFacture"})
public class InsertFactureServlet extends HttpServlet {

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
            out.println("<title>Servlet InsertFactureServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet InsertFactureServlet at " + request.getContextPath() + "</h1>");
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
            String sql ="SELECT * FROM v_product_price WHERE status_product != 0";
            String sqlClient ="SELECT * FROM client";

            List<VProductPrice> products = (List<VProductPrice>) GenericDAO.directQuery(VProductPrice.class, sql, null);
            List<Client> clients = (List<Client>) GenericDAO.directQuery(Client.class, sqlClient, null);

            request.setAttribute("products", products);
            request.setAttribute("clients", clients);
            
             // All required assets
            List<String> css = new ArrayList<>();
            css.add("assets/css/supplier/supplier.css");
            
            List<String> js = new ArrayList<>();
            js.add("assets/js/bootstrap.bundle.min.js");
            
            request.setAttribute("css", css);
            request.setAttribute("js", js);
            
            // Page definition
            request.setAttribute("title", "Facturation");
            request.setAttribute("contentPage", "./pages/facturation/insertFacture.jsp");
            
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
            String date = request.getParameter("date");
            String client = request.getParameter("client");
            
            String[] productChoisi = request.getParameterValues("products");
            
            if(productChoisi == null) {
                throw new Exception("Aucun produit choisi");
            }
            List<FactureDetails> factureDetails = new ArrayList<>();
            
            for(String item : productChoisi) {
                if(item != null) {
                    String quantite = request.getParameter("quantite"+item);
                    String remise = request.getParameter("remise"+item);
                    factureDetails.add(new FactureDetails(item, quantite, remise));
                }
            }
            
            // creer la facture
            Facture facture = new Facture(date, factureDetails, client);
            facture.save();
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
