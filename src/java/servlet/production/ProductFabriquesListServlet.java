/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet.production;

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
import model.fabrication.ProductFabrique;
import model.fabrication.VProductFabrique;
import model.features_product.Look;
import model.features_product.Size;
import model.features_product.Type;
import model.production.VProduct;

/**
 *
 * @author chalman
 */
@WebServlet(name = "ProductFabriquesListServlet", urlPatterns = {"/ProductFabriquesList"})
public class ProductFabriquesListServlet extends HttpServlet {

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
            out.println("<title>Servlet ProductFabriquesListServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProductFabriquesListServlet at " + request.getContextPath() + "</h1>");
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
            String sqlProductFabriques = "SELECT * FROM v_product_fabrique WHERE etat != 0";
            List<VProductFabrique> productsFabrique = (List<VProductFabrique>)GenericDAO.directQuery(VProductFabrique.class, sqlProductFabriques, null);
            
            String sqlProduct = "SELECT * FROM v_product WHERE status_product != 0";
            List<VProduct> products = (List<VProduct>)GenericDAO.directQuery(VProduct.class, sqlProduct, null);
            VProduct.addMatiereProduct(products);
            
            request.setAttribute("productsFilter", products);
            request.setAttribute("products", productsFabrique);
            
            String sqlSize ="SELECT * FROM size WHERE status != 0";
            String sqlType ="SELECT * FROM type WHERE status != 0";
            String sqlLook = "SELECT * FROM look WHERE status != 0";
            
            List<Size> sizes = (List<Size>)GenericDAO.directQuery(Size.class, sqlSize, null);
            List<Type> types = (List<Type>)GenericDAO.directQuery(Type.class, sqlType, null);
            List<Look> looks = (List<Look>)GenericDAO.directQuery(Look.class, sqlLook, null);

            request.setAttribute("sizes", sizes);
            request.setAttribute("types", types);
            request.setAttribute("looks", looks);
            
            // All required assets
            List<String> css = new ArrayList<>();
            css.add("assets/css/supplier/supplier.css");
            
            List<String> js = new ArrayList<>();
            js.add("assets/js/bootstrap.bundle.min.js");
            
            request.setAttribute("css", css);
            request.setAttribute("js", js);
            
            // Page definition
            request.setAttribute("title", "Creation produits");
            request.setAttribute("contentPage", "./pages/production/productFabriquesList.jsp");
            
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
        processRequest(request, response);
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
