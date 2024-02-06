<%@page import="java.util.List"%>
<%@page import="model.employe.*"%>
<%@page import="model.poste.*"%>
<%@page import="model.grade.*"%>

<div class="page-header">
    <h3 class="page-title">
        <span class="page-title-icon bg-gradient-primary text-white me-2">
            <i class="mdi mdi-home"></i>
        </span> Graduation
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
    <div class="col-8 grid-margin mx-auto">
        <div class="card">
            <div class="card-body">
                <div class="mt-4">
                    <div>
                        <a data-bs-toggle="modal" data-bs-target="#newGrade"
                            class="btn btn-gradient-primary">Nouvelle grade</a>
                        <a data-bs-toggle="modal" data-bs-target="#paramGraduation"
                            class="btn btn-gradient-primary">Parametre graduation</a>
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
                <h4 class="card-title">Liste grade</h4>
                <div class="table-responsive mt-2">
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th> Nom </th>
                                <th> Salaire/heure </th>
                                <th> Action </th>
                            </tr>
                        </thead>
                        <tbody>
                            <% if(request.getAttribute("roles") != null) { 
                                List<Profession> roles = (List<Profession>)request.getAttribute("roles");
                                for(int i = 0; i < roles.size(); i++) {
                            %>
                            <tr>
                                <td><%=roles.get(i).getNom() %></td>
                                <td><%=roles.get(i).getSalaire() %></td>
                                <td>
                                    <div class="d-flex align-items-center">
                                        <a href="./DeleteRole?idRole=<%=roles.get(i).getIdProfession() %>" class="text-danger action-icon"><i class="mdi mdi-delete"></i></a>
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
           
                        
                                           
<!-- Modal Nouvelle grade -->
<div class="modal fade" id="newGrade" tabindex="-1" aria-labelledby="exampleModalLabel"
    aria-hidden="true">
    <div class="modal-dialog  modal-content modal-dialog-centered">
        <div class="modal-content card-body">
            <div class="modal-header">
                <h1 class="modal-title fs-5" id="exampleModalLabel"> Nouvelle grade </h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <div class="mt-4">
                    <form action="./Grade" method="POST">
                        <div class="row align-items-end">
                            <div class="form-group col-md-8">
                                <label for="article">Nom</label>
                                <input type="text" class="form-control" name="name">
                            </div>
                        </div>
                       <div class="row align-items-end">
                            <div class="form-group col-md-8">
                                <label for="article">Niveau</label>
                                <input type="number" class="form-control" name="niveau">
                            </div>
                        </div>
                        <% if(request.getAttribute("error") != null) { %>
                            <p class="text-error"><%=request.getAttribute("error") %></p>
                        <% } %>
                        <div class="mt-3">
                            <button type="submit" class="btn btn-gradient-primary" data-bs-dismiss="modal">Valider</button>
                        </div>
                    </form>
                </div>

            </div>
        </div>
    </div>
</div>

                  
                        
<!-- Modal parametre graduation -->
<div class="modal fade" id="paramGraduation" tabindex="-1" aria-labelledby="exampleModalLabel"
    aria-hidden="true">
    <div class="modal-dialog  modal-xl modal-dialog-centered">
        <div class="modal-content card-body">
            <div class="modal-header">
                <h1 class="modal-title fs-5" id="exampleModalLabel"> Parametre graduation</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="col-md-5">
                        <h4 class="card-title">Nouvelle parametre</h4>
                        <hr>
                        <form action="./ParamGraduation" method="POST">
                            <div class="row align-items-end">
                                <div class="form-group col-md-5">
                                    <label for="article">Poste - grade</label>
                                    <select name="ancien" class="form-control form-control-sm input-height mt-2">
                                        <% if(request.getAttribute("posteGrades") != null) { 
                                        List<VPosteGrade> posteGrades = (List<VPosteGrade>)request.getAttribute("posteGrades");
                                        for(int i = 0; i < posteGrades.size(); i++) {
                                        %>
                                        <option value="<%=posteGrades.get(i).getIdPosteGrade() %>"><%=posteGrades.get(i).getPosteGradeLetter() %></option>
                                        <% } } %>
                                    </select>
                                </div>
                            </div>
                            <div class="row align-items-end">
                                <div class="form-group col-md-5">
                                    <label for="article">Devient</label>
                                    <select name="ajour" class="form-control form-control-sm input-height mt-2">
                                        <% if(request.getAttribute("posteGrades") != null) { 
                                        List<VPosteGrade> posteGrades = (List<VPosteGrade>)request.getAttribute("posteGrades");
                                        for(int i = 0; i < posteGrades.size(); i++) {
                                        %>
                                        <option value="<%=posteGrades.get(i).getIdPosteGrade() %>"><%=posteGrades.get(i).getPosteGradeLetter() %></option>
                                        <% } } %>
                                    </select>
                                </div>
                            </div>
                            <div class="row align-items-end">
                                <div class="form-group col-md-4">
                                    <label for="article">Apres</label>
                                    <input type="number" class="form-control" name="duree">
                                </div>
                            </div>
                            <% if(request.getAttribute("error") != null) { %>
                                <p class="text-error"><%=request.getAttribute("error") %></p>
                            <% } %>
                            <div class="mt-3">
                                <button type="submit" class="btn btn-gradient-primary" data-bs-dismiss="modal">Valider</button>
                            </div>
                        </form>
                    </div>
                    <div class="col-md-5" style="border: 1px solid black">
                                <h4 class="card-title">Les parametres</h4>
                                <hr>
                                <div class="table-responsive mt-2">
                                    <table class="table table-striped">
                                        <thead>
                                            <tr>
                                                <th> Poste </th>
                                                <th> A jour </th>
                                                <th> Apres </th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <% if(request.getAttribute("paramsGraduation") != null) { 
                                                List<VParamGraduation> paramGraduation = (List<VParamGraduation>)request.getAttribute("paramsGraduation");
                                                for(VParamGraduation item : paramGraduation) {
                                            %>
                                            <tr>
                                                <td><%=item.getPosteGradeLetter() %></td>
                                                <td><%=item.getPosteGradeAjourLetter() %></td>
                                                <td><%=item.getYear() %></td>
                                                <td>
                                                    <div class="d-flex align-items-center">
                                                        <a href="./DeleteRole?idRole=2" class="text-danger action-icon"><i class="mdi mdi-delete"></i></a>
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
    </div>
</div>