<%@page import="java.util.List"%>
<%@page import="model.features_product.*"%>

<div class="page-header">
    <h3 class="page-title">
        <span class="page-title-icon bg-gradient-primary text-white me-2">
            <i class="mdi mdi-home"></i>
        </span> Mouvements
    </h3>
</div>
      
<% if(request.getAttribute("error") != null) { %>
<div class="row">
    <div class="col-6 grid-margin mx-auto">
        <div class="card">
            <div class="card-body">
                <p class="text-error"><%=request.getAttribute("error") %></p>
            </div>
        </div>
    </div>
</div>
<% } %>

<div class="row">
    <div class="col-6 grid-margin mx-auto">
        <div class="card">
            <div class="card-body">
                <h4 class="card-title">Entree</h4>
                <form action="./Mouvement" method="POST">
                        <input type="hidden" value="1" name="typeMouvement"/>
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
                            <div class="form-group col-md-5">
                                <label for="article">Prix unitaire</label>
                                <input type="number" class="form-control" name="prixUnitaire">
                            </div>
                        </div>
                        <div class="row align-items-end">
                            <div class="form-group col-md-5">
                                <label for="article">Quantite</label>
                                <input type="number" class="form-control" name="quantite">
                            </div>
                        </div>
                        <div class="row align-items-end">
                            <div class="form-group col-md-5">
                                <label for="article">Date</label>
                                <input type="date" class="form-control" name="date">
                            </div>
                        </div>
                          
                        <button type="submit"
                            class="btn btn-gradient-primary px-5 me-2">Entrer</button>
                    </form>
            </div>
        </div>
    </div>
    <div class="col-6 grid-margin mx-auto">
        <div class="card">
            <div class="card-body">
                <h4 class="card-title">Sortie</h4>
                <form action="./Mouvement" method="POST">
                    <input type="hidden" value="2" name="typeMouvement"/>
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
                            <div class="form-group col-md-5">
                                <label for="article">Quantite</label>
                                <input type="number" class="form-control" name="quantite">
                            </div>
                        </div>
                        <div class="row align-items-end">
                            <div class="form-group col-md-5">
                                <label for="article">Date</label>
                                <input type="date" class="form-control" name="date">
                            </div>
                        </div>
                          
                        <button type="submit"
                            class="btn btn-gradient-primary px-5 me-2">Sortie</button>
                </form>
            </div>
        </div>
    </div>
</div>