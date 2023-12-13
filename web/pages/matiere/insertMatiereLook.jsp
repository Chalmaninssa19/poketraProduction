<%@page import="java.util.List"%>
<%@page import="model.look.*"%>
<div class="page-header">
    <h3 class="page-title">
        <span class="page-title-icon bg-gradient-primary text-white me-2">
            <i class="mdi mdi-home"></i>
        </span> Insertion matiere look
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


            <!-- Modal example -->
                <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel"
                     aria-hidden="true">
                    <div class="modal-dialog  modal-xl modal-dialog-centered">
                        <div class="modal-content card-body">
                            <div class="modal-header">
                                <h1 class="modal-title fs-5" id="exampleModalLabel"> Poste </h1>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                <hr>
                            </div>
                            <div class="modal-body">
                                <button type="submit" class="btn btn-gradient-primary me-2" data-bs-toggle="modal" id="nouveauProfile"
                                        data-bs-target="#newProfil">Crée un nouveau profile</button>

                                <div class="mt-4">
                                    <h4 class="card-title mb-4">Liste des anciens profiles existants</h4>
                                    
                                </div>

                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                <button onclick="profileValided()" type="button" class="btn btn-gradient-primary" data-bs-dismiss="modal">Valider</button>
                            </div>
                        </div>
                    </div>
                </div>

                <a data-bs-toggle="modal" data-bs-target="#exampleModal"
                    class="btn btn-gradient-primary me-1" href="#">Afficher modal</a>


<div class="row">
    <div class="col-8 grid-margin mx-auto">
        <div class="card">
            <div class="card-body">
                <h4 class="card-title">Inserer une matiere look</h4>
                <div class="mt-4">
                    <form action="./InsertMatiereLook" method="POST">
                        <div class="row align-items-end">
                            <div class="form-group col-md-5">
                                <% if(request.getAttribute("matieres") != null) { 
                                List<Matiere> matieres = (List<Matiere>)request.getAttribute("matieres");
                                %>
                                <label for="article">Matiere</label>
                                <select name="matiere" class="form-control form-control-sm input-height mt-2">
                                    <% for(int i = 0; i < matieres.size(); i++) { %>
                                    <option value="<%=matieres.get(i).getId() %>"><%=matieres.get(i).getNom() %></option>
                                    <% } %>
                                </select>
                                <% } %>
                            </div>
                        </div>
                        <div class="row align-items-end">
                            <div class="form-group col-md-5">
                                <% if(request.getAttribute("looks") != null) { 
                                List<Look> looks = (List<Look>)request.getAttribute("looks");
                                %>
                                <label for="article">Look</label>
                                <select name="look" class="form-control form-control-sm input-height mt-2">
                                    <% for(int i = 0; i < looks.size(); i++) { %>
                                    <option value="<%=looks.get(i).getId() %>"><%=looks.get(i).getNom() %></option>
                                    <% } %>
                                </select>
                                <% } %>
                            </div>
                        </div>
                        <% if(request.getAttribute("error") != null) { %>
                            <p class="text-error"><%=request.getAttribute("error") %></p>
                        <% } %>
                        <div class="mt-3">
                            <button type="submit"
                                class="btn btn-gradient-primary px-5 me-2">creer</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>