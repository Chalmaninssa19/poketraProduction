<%@page import="java.util.List"%>
<%@page import="model.employe.*"%>
<%@page import="model.poste.*"%>
<%@page import="model.grade.*"%>


<div class="page-header">
    <h3 class="page-title">
        <span class="page-title-icon bg-gradient-primary text-white me-2">
            <i class="mdi mdi-home"></i>
        </span>  Poste
    </h3>
</div>

<% if(request.getAttribute("error") != null) { %>
<div class="row">
    <div class="col-12 grid-margin">
        <div class="card">
            <div class="card-body">
                    <p class="text-error"><%=request.getAttribute("error") %></p>
            </div>
        </div>
    </div>
</div>
<% } %>


<div class="row">
    <div class="col-10 grid-margin mx-auto">
        <div class="card">
            <div class="card-body">
                <div class="mt-4">
                    <div>
                        <a data-bs-toggle="modal" data-bs-target="#createNewPoste"
                            class="btn btn-gradient-primary">Nouvelle poste</a>
                        <a data-bs-toggle="modal" data-bs-target="#posteGrade1"
                            class="btn btn-gradient-primary">Taux horaire type 1</a>
                        <a data-bs-toggle="modal" data-bs-target="#posteGrade2"
                            class="btn btn-gradient-primary">Taux horaire type 2</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
                        
                        
<div class="row">
    <div class="col-12 grid-margin">
        <div class="card">
            <div class="card-body">
                <h4 class="card-text">Taux horaires des postes</h4>
                <div class="table-responsive mt-2">
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th> Poste </th>
                                <th> Grade </th>
                                <th> Niveau </th>
                                <th> Taux horaire </th>
                            </tr>
                        </thead>
                        <tbody>
                            <% if(request.getAttribute("postegrades") != null) { 
                                List<VPosteGrade> postegrades = (List<VPosteGrade>)request.getAttribute("postegrades");
                                for(int i = 0; i < postegrades.size(); i++) {
                            %>
                            <tr>
                                <td><%=postegrades.get(i).getPoste() %></td>
                                <td><%=postegrades.get(i).getGrade() %></td>
                                <td><%=postegrades.get(i).getNiveau() %></td>
                                <td><%=postegrades.get(i).getTauxHoraire() %></td>
                                <td>
                                    <div class="d-flex align-items-center">
                                        <a href="./DeleteRole?idRole=<%=postegrades.get(i).getIdPosteGrade() %>" class="text-danger action-icon"><i class="mdi mdi-delete"></i></a>
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
                        
                        
                        
<!-- Modal nouvelle poste -->
<div class="modal fade" id="createNewPoste" tabindex="-1" aria-labelledby="exampleModalLabel"
    aria-hidden="true">
    <div class="modal-dialog  modal-xl modal-dialog-centered">
        <div class="modal-content card-body">
            <div class="modal-header">
                <h1 class="modal-title fs-5" id="exampleModalLabel"> Nouvelle poste </h1>
                <hr>
            </div>
            <div class="modal-body">
                <div class="mt-4">
                   <form action="./Poste" method="POST">
                        <div class="row align-items-end">
                            <div class="form-group col-md-4">
                                <label for="article">Nom</label>
                                <input type="text" class="form-control" name="name">
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

                  
                        
<!-- Modal parametre poste-grade 1 -->
<div class="modal fade" id="posteGrade1" tabindex="-1" aria-labelledby="exampleModalLabel"
    aria-hidden="true">
    <div class="modal-dialog  modal-xl modal-dialog-centered">
        <div class="modal-content card-body">
            <div class="modal-header">
                <h1 class="modal-title fs-5" id="exampleModalLabel"> Taux horaire type 1</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                <hr>
            </div>
            <div class="modal-body">
                <div class="mt-4">
                   <form action="./PosteGrade" method="POST">
                       <input type=hidden class="form-control" name="type" value="1">
                        <div class="row align-items-end">
                            <div class="form-group col-md-5">
                                <label for="article">Poste</label>
                                <select name="poste" class="form-control form-control-sm input-height mt-2">
                                    <% if(request.getAttribute("postes") != null) { 
                                    List<Poste> postes = (List<Poste>)request.getAttribute("postes");
                                    for(int i = 0; i < postes.size(); i++) {
                                    %>
                                    <option value="<%=postes.get(i).getIdPoste() %>"><%=postes.get(i).getNom() %></option>
                                    <% } } %>
                                </select>
                            </div>
                        </div>
                        <div class="row align-items-end">
                            <div class="form-group col-md-5">
                                <label for="article">Grade</label>
                                <select name="grade" class="form-control form-control-sm input-height mt-2">
                                    <% if(request.getAttribute("grades") != null) { 
                                    List<Grade> grades = (List<Grade>)request.getAttribute("grades");
                                    for(int i = 0; i < grades.size(); i++) {
                                    %>
                                    <option value="<%=grades.get(i).getIdGrade() %>"><%=grades.get(i).getName() %></option>
                                    <% } } %>
                                </select>
                            </div>
                        </div>
                        <div class="row align-items-end">
                            <div class="form-group col-md-4">
                                <label for="article">Taux horaire</label>
                                <input type="number" step="0.01" class="form-control" name="tauxHoraire">
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
                        
                                          
                        
<!-- Modal parametre poste-grade2 -->
<div class="modal fade" id="posteGrade2" tabindex="-1" aria-labelledby="exampleModalLabel"
    aria-hidden="true">
    <div class="modal-dialog  modal-xl modal-dialog-centered">
        <div class="modal-content card-body">
            <div class="modal-header">
                <h1 class="modal-title fs-5" id="exampleModalLabel"> Taux horaire type 2 </h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                <hr>
            </div>
            <div class="modal-body">
                <div class="mt-4">
                   <form action="./PosteGrade" method="POST">
                        <input type=hidden class="form-control" name="type" value="2">
                        <div class="row align-items-end">
                             <h4 class="modal-title fs-5" id="exampleModalLabel"> Taux horaire de </h4>
                            <div class="form-group col-md-3">
                                <label for="article">Poste</label>
                                <select name="poste" class="form-control form-control-sm input-height mt-2">
                                    <% if(request.getAttribute("postes") != null) { 
                                    List<Poste> postes = (List<Poste>)request.getAttribute("postes");
                                    for(int i = 0; i < postes.size(); i++) {
                                    %>
                                    <option value="<%=postes.get(i).getIdPoste() %>"><%=postes.get(i).getNom() %></option>
                                    <% } } %>
                                </select>
                                <label for="article">Grade</label>
                                <select name="grade" class="form-control form-control-sm input-height mt-2">
                                    <% if(request.getAttribute("grades") != null) { 
                                    List<Grade> grades = (List<Grade>)request.getAttribute("grades");
                                    for(int i = 0; i < grades.size(); i++) {
                                    %>
                                    <option value="<%=grades.get(i).getIdGrade() %>"><%=grades.get(i).getName() %></option>
                                    <% } } %>
                                </select>
                            </div>
                        </div>
                        <div class="row align-items-end">
                            <h4 class="modal-title fs-5" id="exampleModalLabel"> Relier au taux horaire de </h4>
                            <div class="form-group col-md-3">
                                    <label for="article">Poste</label>
                                    <select name="posteRelier" class="form-control form-control-sm input-height mt-2">
                                        <% if(request.getAttribute("postes") != null) { 
                                        List<Poste> postes = (List<Poste>)request.getAttribute("postes");
                                        for(int i = 0; i < postes.size(); i++) {
                                        %>
                                        <option value="<%=postes.get(i).getIdPoste() %>"><%=postes.get(i).getNom() %></option>
                                        <% } } %>
                                    </select>
                                    <label for="article">Grade</label>
                                    <select name="gradeRelier" class="form-control form-control-sm input-height mt-2">
                                        <% if(request.getAttribute("grades") != null) { 
                                        List<Grade> grades = (List<Grade>)request.getAttribute("grades");
                                        for(int i = 0; i < grades.size(); i++) {
                                        %>
                                        <option value="<%=grades.get(i).getIdGrade() %>"><%=grades.get(i).getName() %></option>
                                        <% } } %>
                                    </select>
                            </div>
                        </div>
                        <div class="row align-items-end">
                            <div class="form-group col-md-4">
                                <label for="article">Avec coefficient de</label>
                                 <input type="number" step="0.01" class="form-control" name="coefficient">
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



