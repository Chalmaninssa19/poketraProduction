<%@page import="java.util.List"%>
<%@page import="model.features_product.*"%>

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
                <h4 class="card-title">Nouvelle produit</h4>
                <div class="mt-4">
                    <form action="./ProductInsert" method="POST">
                        <div class="row align-items-end">
                            <div class="form-group col-md-4">
                                <label for="article">Designation</label>
                                <input type="text" class="form-control" name="designation">
                            </div>
                        </div>
                        <div class="row align-items-end">
                            <div class="form-group col-md-5">
                                <label for="article">Taille</label>
                                <select name="size" class="form-control form-control-sm input-height mt-2">
                                    <% if(request.getAttribute("sizes") != null) { 
                                    List<Size> sizes = (List<Size>)request.getAttribute("sizes");
                                    for(int i = 0; i < sizes.size(); i++) {
                                    %>
                                    <option value="<%=sizes.get(i).getIdSize() %>"><%=sizes.get(i).getName() %></option>
                                    <% } } %>
                                </select>
                            </div>
                        </div>
                        <div class="row align-items-end">
                            <div class="form-group col-md-5">
                                <label for="article">Type</label>
                                <select name="type" class="form-control form-control-sm input-height mt-2">
                                    <% if(request.getAttribute("types") != null) { 
                                    List<Type> types = (List<Type>)request.getAttribute("types");
                                    for(int i = 0; i < types.size(); i++) {
                                    %>
                                    <option value="<%=types.get(i).getIdType() %>"><%=types.get(i).getName() %></option>
                                    <% } } %>
                                </select>
                            </div>
                        </div>
                        <div class="row align-items-end">
                            <div class="form-group col-md-5">
                                <label for="article">Look</label>
                                <select name="look" class="form-control form-control-sm input-height mt-2">
                                    <% if(request.getAttribute("looks") != null) { 
                                    List<Look> looks = (List<Look>)request.getAttribute("looks");
                                    for(int i = 0; i < looks.size(); i++) {
                                    %>
                                    <option value="<%=looks.get(i).getIdLook() %>"><%=looks.get(i).getName() %></option>
                                    <% } } %>
                                </select>
                            </div>
                        </div>
                        <div class="row align-items-end">
                            <div class="form-group col-md-6">
                                    <label for="article">Matiere</label>
                                    <p>
                                        <% if(request.getAttribute("matieres") != null) { 
                                        List<Matiere> matieres = (List<Matiere>)request.getAttribute("matieres");
                                        for(int i = 0; i < matieres.size(); i++) {
                                        %>
                                        <input type="checkbox" class="form-check-input" value="<%=matieres.get(i).getIdMatiere() %>" name="matieres"> <%=matieres.get(i).getName() %> </label>
                                        <% } } %>
                                    </p>
                            </div>
                        </div>
                        <div class="row align-items-end">
                            <div class="form-group col-md-4">
                                <label for="article">Date creation</label>
                                <input type="date" class="form-control" name="date_creation">
                            </div>
                        </div>
                        <div class="row align-items-end">
                            <div class="form-group col-md-4">
                                <label for="article">Prix vente</label>
                                <input type="number" class="form-control" name="prixVente">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="exampleInputPassword1">Description</label>
                            <textarea name="description" class="form-control" id="" cols="30" rows="10"></textarea>
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