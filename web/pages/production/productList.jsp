<%@page import="java.util.List"%>
<%@page import="model.features_product.*"%>
<%@page import="model.production.*"%>

<div class="page-header">
    <h3 class="page-title">
        <span class="page-title-icon bg-gradient-primary text-white me-2">
            <i class="mdi mdi-home"></i>
        </span> Creation produit
    </h3>
</div>
<div class="row">
    <div class="col-12 grid-margin">
        <div class="card">
            <div class="card-body">
                <div class="mt-4 d-flex align-items-center justify-content-between">
                    <form action="./ProductFilter" method="POST">
                        <input type="hidden" class="form-control" name="idHelp" value="1">
                        <div class="row align-items-end">
                            <div class="form-group col-md-4">
                                <input type="text" class="form-control" name="rechercher">
                            </div>
                            <div class="form-group col-md-4">
                                <input type="submit" class="mx-2 btn btn-gradient-primary" value="Rechercher">                            
                            </div>
                          
                        </div>
                    </form>
                     
                    <div>
                        <a href="./InsertPromotion"
                            class="btn btn-gradient-primary">Nouvelle promotion</a>
                        <a href="./ProductInsert"
                            class="btn btn-gradient-primary">Nouveau produit</a>
                    </div>
                </div>
                        <div class="input-groups d-flex align-items-center">
                            <form action="./ProductFilter" method="POST">
                                <input type="hidden" class="form-control" name="idHelp" value="2">
                                <div class="row align-items-end">
                                    <div class="form-group col-md-4">
                                        <input type="number" step="0.01" class="form-control" name="benefice_min" placeholder="Benefice min">
                                    </div>
                                    <div class="form-group col-md-4">
                                        <input type="number" step="0.01" class="form-control" name="benefice_max" placeholder="Benefice max">
                                    </div>
                                    <div class="form-group col-md-4">
                                        <input type="submit" class="mx-2 btn btn-gradient-primary" value="Rechercher">                            
                                    </div>

                                </div>
                            </form>
                        </div>
                
                <div class="table-responsive mt-2">
                    <h4 class="card-title">Liste des produits creer</h4>
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th> ID </th>
                                <th> Designation </th>
                                <th> Matiere </th>
                                <th> Taille </th>
                                <th> Type </th>
                                <th> Look </th>
                                <th> Date creation </th>
                                <th> Prix vente </th>
                                <th> Prix revient </th>
                                <th> Benefice </th>
                            </tr>
                        </thead>
                        <tbody>
                            <% if(request.getAttribute("products") != null) { 
                            List<VProductPrice> products = (List<VProductPrice>)request.getAttribute("products");
                            for(int i = 0; i < products.size(); i++) {
                            %>
                            <tr>
                                <td><%=products.get(i).getId() %></td>
                                <td><%=products.get(i).getDesignation() %></td>
                                <td>
                                    <% for(ProductMatiere item : products.get(i).getProductsMatiere()) { 
                                        out.print(item.getMatiere().getName() + ", ");
                                    } %>
                                </td>
                                <td><%=products.get(i).getSize() %></td>
                                <td><%=products.get(i).getType() %></td>
                                <td><%=products.get(i).getLook() %></td>
                                <td><%=products.get(i).getDateCreation() %></td>
                                <td><%=products.get(i).getPrixVente() %></td>
                                <td><%=products.get(i).getPrixRevientLetter() %></td>
                                <td><%=products.get(i).getBeneficeLetter() %></td>
                                <td>
                                    <div class="d-flex align-items-center">
                                        <a href="#" class="text-danger action-icon"><i class="mdi mdi-delete"></i></a>
                                        <a href="#" class="text-warning action-icon"><i class="mdi mdi-settings"></i></a>
                                        <a href="VoirPromotion?idProduct=<%=products.get(i).getIdProduct() %>" class="text-avatar">Voir promotions</a>
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