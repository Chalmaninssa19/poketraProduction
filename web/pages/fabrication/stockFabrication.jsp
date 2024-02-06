<%@page import="java.util.List"%>
<%@page import="model.production.*"%>
<%@page import="model.fabrication.*"%>

<div class="page-header">
    <h3 class="page-title">
        <span class="page-title-icon bg-gradient-primary text-white me-2">
            <i class="mdi mdi-home"></i>
        </span> Stockage
    </h3>
</div>
<div class="row">
    <div class="col-12 grid-margin">
        <div class="card">
            <div class="card-body">
                <div class="mt-4 d-flex align-items-center justify-content-between">
                    <form action="./StockFabricationFilter" method="POST">
                        <div class="row align-items-end">
                            <div class="form-group col-md-5">
                                <label for="article">Produit</label>
                                <select name="product" class="form-control form-control-sm input-height mt-2">
                                    <% if(request.getAttribute("products") != null) { 
                                    List<Product> listes = (List<Product>)request.getAttribute("products");
                                    for(int i = 0; i < listes.size(); i++) {
                                    %>
                                    <option value="<%=listes.get(i).getIdProduct() %>"><%=listes.get(i).getDesignation() %></option>
                                    <% } } %>
                                </select>
                            </div>
                            <div class="form-group col-md-4">
                                <input type="submit" class="mx-2 btn btn-gradient-primary" value="Rechercher">                            
                            </div>
                        </div>
                                
                        </div>
                    </form>
                </div>
            </div>
                
                <div class="table-responsive mt-2">
                    <h4 class="card-text">Etat de stock fabrication </h4>
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th> ID </th>
                                <th> designation </th>
                                <th> entree </th>
                                <th> sortie </th>
                                <th> reste </th>
                                <th> prix vente </th>
                                <th> Montant </th>
                            </tr>
                        </thead>
                        <tbody>
                            <% if(request.getAttribute("stock") != null) { 
                                List<StockProductFabrique> stock =(List<StockProductFabrique>)request.getAttribute("stock");
                                for(int i = 0; i < stock.size(); i++) {
                            %>
                            <tr>
                                <td><%=stock.get(i).getIdProduct() %></td>
                                <td><%=stock.get(i).getDesignation() %></td>
                                <td><%=stock.get(i).getEntree() %></td>
                                <td><%=stock.get(i).getSortie() %></td>
                                <td><%=stock.get(i).getReste() %></td>
                                <td><%=stock.get(i).getPrixVente() %></td>
                                <td><%=stock.get(i).getMontant() %></td>
                            </tr>
                            <% } } %>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>