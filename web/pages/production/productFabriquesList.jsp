<%@page import="java.util.List"%>
<%@page import="model.features_product.*"%>
<%@page import="model.fabrication.*"%>
<%@page import="model.production.*"%>

<div class="page-header">
    <h3 class="page-title">
        <span class="page-title-icon bg-gradient-primary text-white me-2">
            <i class="mdi mdi-home"></i>
        </span> Fabrication produit
    </h3>
</div>
<div class="row">
    <div class="col-12 grid-margin">
        <div class="card">
            <div class="card-body">
                <div class="mt-4 d-flex align-items-center justify-content-between">
                    <form action="./PurchaseRequestFilter" method="POST">
                        <div class="row align-items-end">
                            <div class="form-group col-md-4">
                                <input type="text" class="form-control" name="date_creation">
                            </div>
                            <div class="form-group col-md-4">
                                <input type="submit" class="mx-2 btn btn-gradient-primary" value="Rechercher">                            
                            </div>
                          
                        </div>
                    </form>
                    
                     
                    <div>
                        <a href="./ProductFabriquesInsert"
                            class="btn btn-gradient-primary">Nouvelle fabrication</a>
                    </div>
                </div>
                    <form action="./PurchaseRequestFilter" method="POST">
                        <div class="input-groups d-flex align-items-center">
                            <div class="col-md-3 form-group mb-2 px-4">
                                <label for="" class="form-label">Date creation</label>
                                <input type="date" class="form-control" name="prix2">
                            </div>
                            <div class="col-md-3 form-group mb-2 px-4 d-flex align-items-end">
                                <button type="submit" class="btn btn-gradient-primary same-height">Filtrer</button>
                            </div>
                        </div>
                    </form>
                
                <div class="table-responsive mt-2">
                    <h4 class="card-title">Liste des produits fabriques</h4>
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th> ID </th>
                                <th> Designation </th>
                                <th> Quantite </th>
                                <th> Prix unitaire </th>
                                <th> Valeur </th>
                                <th> Date fabrication </th>
                            </tr>
                        </thead>
                        <tbody>
                            <% if(request.getAttribute("products") != null) { 
                            List<VProductFabrique> products = (List<VProductFabrique>)request.getAttribute("products");
                            for(int i = 0; i < products.size(); i++) {
                            %>
                            <tr>
                                <td><%=products.get(i).getId() %></td>
                                <td><%=products.get(i).getProduct() %></td>
                                <td><%=products.get(i).getQuantite() %></td>
                                <td><%=products.get(i).getPrixVenteLetter() %></td>
                                <td><%=products.get(i).getMontantLetter() %></td>
                                <td><%=products.get(i).getDateFabrication() %></td>
                                <td>
                                    <div class="d-flex align-items-center">
                                        <a href="#" class="text-danger action-icon"><i class="mdi mdi-delete"></i></a>
                                        <a href="#" class="text-warning action-icon"><i class="mdi mdi-settings"></i></a>
                                    </div>
                                </td>
                            </tr>
                            <% } } %>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>