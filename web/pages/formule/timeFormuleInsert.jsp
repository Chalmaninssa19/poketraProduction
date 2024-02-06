<%@page import="java.util.List"%>
<%@page import="model.features_product.*"%>
<%@page import="model.employe.*"%>

<div class="page-header">
    <h3 class="page-title">
        <span class="page-title-icon bg-gradient-primary text-white me-2">
            <i class="mdi mdi-home"></i>
        </span> Formule quantite
    </h3>
    <nav aria-label="breadcrumb">
        <ul class="breadcrumb">
            <li class="breadcrumb-item active" aria-current="page">
                <span></span>Overview <i
                    class="mdi mdi-alert-circle-outline icon-sm text-primary align-middle"></i>
            </li>
        </ul>
    </nav>
</div>

<div class="row">
    <div class="col-8 grid-margin mx-auto">
        <div class="card">
            <div class="card-body">
                <h4 class="card-title">Nouvelle formule</h4>
                <div class="mt-4">
                    <form action="./TimeFormuleInsert" method="POST">
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
                            <div class="form-group col-md-5">
                                <label for="article">Profession</label>
                                <select name="profession" class="form-control form-control-sm input-height mt-2">
                                    <% if(request.getAttribute("professions") != null) { 
                                    List<Profession> roles = (List<Profession>)request.getAttribute("professions");
                                    for(int i = 0; i < roles.size(); i++) {
                                    %>
                                    <option value="<%=roles.get(i).getIdProfession() %>"><%=roles.get(i).getNom() %></option>
                                    <% } } %>
                                </select>
                            </div>
                        </div>
                        <div class="row align-items-end">
                            <div class="form-group col-md-4">
                                <label for="article">Duree</label>
                                <input type="number" class="form-control" name="duration">
                            </div>
                        </div>
                        <div class="row align-items-end">
                            <div class="form-group col-md-4">
                                <label for="article">Nombre employe</label>
                                <input type="number" class="form-control" name="nombreEmploye">
                            </div>
                        </div>
                        <% if(request.getAttribute("error") != null) { %>
                            <p class="text-error"><%=request.getAttribute("error") %></p>
                        <% } %>
                        <div class="mt-3">
                            <a href="./TimeFormuleList">
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