<%@page import="java.util.List"%>
<%@page import="model.features_product.*"%>
<%@page import="model.employe.*"%>
<%@page import="model.poste.*"%>

<div class="page-header">
    <h3 class="page-title">
        <span class="page-title-icon bg-gradient-primary text-white me-2">
            <i class="mdi mdi-home"></i>
        </span> Employe
    </h3>
</div>

<div class="row">
    <div class="col-8 grid-margin mx-auto">
        <div class="card">
            <div class="card-body">
                <h4 class="card-title">Nouvelle employe</h4>
                <div class="mt-4">
                    <form action="./InsertEmploye" method="POST">
                        <div class="row align-items-end">
                            <div class="form-group col-md-4">
                                <label for="article">Nom</label>
                                <input type="text" class="form-control" name="nom">
                            </div>
                        </div>
                        <div class="row align-items-end">
                            <div class="form-group col-md-4">
                                <label for="article">Prenom</label>
                                <input type="text" class="form-control" name="prenom">
                            </div>
                        </div>
                        <div class="row align-items-end">
                            <div class="form-group col-md-4">
                                <label for="article">Date naissance</label>
                                <input type="date" class="form-control" name="dateNaissance">
                            </div>
                        </div>
                        <div class="row align-items-end">
                            <div class="form-group col-md-4">
                                <label for="article">Date embauche</label>
                                <input type="date" class="form-control" name="dateEmbauche">
                            </div>
                        </div>
                        <div class="row align-items-end">
                            <div class="form-group col-md-5">
                                <label for="article">Poste</label>
                                <select name="role" class="form-control form-control-sm input-height mt-2">
                                    <% if(request.getAttribute("professions") != null) { 
                                    List<VPosteGrade> roles = (List<VPosteGrade>)request.getAttribute("professions");
                                    for(int i = 0; i < roles.size(); i++) {
                                    %>
                                    <option value="<%=roles.get(i).getIdPosteGrade() %>"><%=roles.get(i).getPosteGradeLetter() %></option>
                                    <% } } %>
                                </select>
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
                                class="btn btn-gradient-primary px-5 me-2">Enregistrer</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>