<%@page import="java.util.List"%>
<%@page import="model.features_product.*"%>
<%@page import="model.formule.*"%>

<div class="page-header">
    <h3 class="page-title">
        <span class="page-title-icon bg-gradient-primary text-white me-2">
            <i class="mdi mdi-home"></i>
        </span> Formule matiere-look
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
    <div class="col-12 grid-margin">
        <div class="card">
            <div class="card-body">
                <% if(request.getAttribute("error") != null) { %>
                    <p class="text-error"><%=request.getAttribute("error") %></p>
                <% } %>
            </div>
        </div>
    </div>
</div>
<div class="row">
    <div class="col-12 grid-margin">
        <div class="card">
            <div class="card-body">
                <h4 class="card-title">Matiere-Look</h4>
                <div class="mt-4 d-flex align-items-center justify-content-between">
                    <form action="./MatiereLookFilter" method="POST">
                        <div class="input-groups d-flex align-items-center">
                            <div class="form-group me-4">
                                <label for="">Look</label>
                                <select name="look" id="" class="form-control form-control-sm px-5 mt-2">
                                <% if(request.getAttribute("looks") != null) { 
                                    List<Look> looks = (List<Look>)request.getAttribute("looks");
                                    for(int i = 0; i < looks.size(); i++) {
                                %>
                                    <option value="<%=looks.get(i).getIdLook() %>"><%=looks.get(i).getName() %></option>
                                <% } } %>
                                </select>
                            </div>
                            <div>
                                <input type="submit" class="mx-2 btn btn-gradient-primary"
                                    value="Filtrer">
                            </div>
                        </div>
                    </form>
                    <div>
                        <a data-bs-toggle="modal" data-bs-target="#insertMatiereLookModal"
                            class="btn btn-gradient-primary">Nouvelle formule</a>
                    </div>
                </div>
                <div class="table-responsive mt-2">
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th> Matiere </th>
                                <th> Look  </th>
                                <th> Action </th>
                            </tr>
                        </thead>
                        <tbody>
                            <% if(request.getAttribute("lookMatieres") != null) { 
                            List<LookMatiere> lookMatieres = (List<LookMatiere>)request.getAttribute("lookMatieres");
                            for(int i = 0; i < lookMatieres.size(); i++) {
                            %>
                            <tr>
                                <td><%=lookMatieres.get(i).getMatiere().getName() %></td>
                                <td><%=lookMatieres.get(i).getLook().getName() %></td>
                                <td>
                                    <div class="d-flex align-items-center">
                                        <a href="#" class="text-danger action-icon"><i class="mdi mdi-delete"></i></a>
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


<!-- Modal nouvelle formule -->
<div class="modal fade" id="insertMatiereLookModal" tabindex="-1" aria-labelledby="exampleModalLabel"
    aria-hidden="true">
    <div class="modal-dialog  modal-xl modal-dialog-centered">
        <div class="modal-content card-body">
            <div class="modal-header">
                <h1 class="modal-title fs-5" id="exampleModalLabel"> Nouvelle formule </h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                <hr>
            </div>
            <div class="modal-body">
                <div class="mt-4">
                    <form action="./MatiereLook" method="POST">
                        <div class="row align-items-end">
                            <div class="form-group col-md-5">
                                <label for="article">Matiere</label>
                                <select name="matiere" class="form-control form-control-sm input-height mt-2">
                                    <% if(request.getAttribute("matieres") != null) { 
                                    List<Matiere> matieres = (List<Matiere>)request.getAttribute("matieres");
                                    for(int i = 0; i < matieres.size(); i++) {
                                    %>
                                    <option value="<%=matieres.get(i).getIdMatiere() %>"><%=matieres.get(i).getName() %></option>
                                    <% } } %>
                                </select>
                            </div>
                        </div>
                        <div class="row align-items-end">
                            <div class="form-group col-md-6">
                                    <label for="article">Look</label>
                                    <p>
                                        <% if(request.getAttribute("looks") != null) { 
                                        List<Look> looks = (List<Look>)request.getAttribute("looks");
                                        for(int i = 0; i < looks.size(); i++) {
                                        %>
                                        <input type="checkbox" class="form-check-input" value="<%=looks.get(i).getIdLook() %>" name="look"> <%=looks.get(i).getName() %> </label>
                                        <% } } %>
                                    </p>
                            </div>
                        </div>
                        <% if(request.getAttribute("error") != null) { %>
                            <p class="text-error"><%=request.getAttribute("error") %></p>
                        <% } %>
                        <div class="mt-3">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                            <button type="submit" class="btn btn-gradient-primary" data-bs-dismiss="modal">Valider</button>
                        </div>
                    </form>
                </div>

            </div>
        </div>
    </div>
</div>

