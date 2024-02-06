<%@page import="java.util.List"%>
<%@page import="model.production.*"%>

<div class="page-header">
    <h3 class="page-title">
        <span class="page-title-icon bg-gradient-primary text-white me-2">
            <i class="mdi mdi-home"></i>
        </span> Production
    </h3>
</div>

<div class="row">
    <div class="col-8 grid-margin mx-auto">
        <div class="card">
            <div class="card-body">
                <h4 class="card-title">Nouvelle promotion</h4>
                <div class="mt-4">
                    <form action="./InsertPromotion" method="POST">
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
                        </div>
                        <div class="row align-items-end">
                            <div class="form-group col-md-4">
                                <label for="article">Date debut</label>
                                <input type="date" class="form-control" name="dateDebut">
                            </div>
                        </div>
                        <div class="row align-items-end">
                            <div class="form-group col-md-4">
                                <label for="article">Date fin</label>
                                <input type="date" class="form-control" name="dateFin">
                            </div>
                        </div>
                        <div class="row align-items-end">
                            <div class="form-group col-md-4">
                                <label for="article">Remise</label>
                                <input type="number" step="0.01" class="form-control" name="remise">
                            </div>
                        </div>
                        <% if(request.getAttribute("error") != null) { %>
                            <p class="text-error"><%=request.getAttribute("error") %></p>
                        <% } %>
                        <div class="mt-3">
                            <a href="./ProductList">
                                <button type="button"
                                class="btn btn-gradient-light px-5 me-2">Retour</button>
                            <a>
                            <button type="submit"
                                class="btn btn-gradient-primary px-5 me-2">Creer</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>