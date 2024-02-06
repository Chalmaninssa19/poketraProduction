<%@page import="java.util.List"%>
<%@page import="model.features_product.*"%>
<%@page import="model.production.*"%>
<%@page import="model.employe.*"%>

<div class="page-header">
    <h3 class="page-title">
        <span class="page-title-icon bg-gradient-primary text-white me-2">
            <i class="mdi mdi-home"></i>
        </span> Employe
    </h3>
</div>
<div class="row">
    <div class="col-12 grid-margin">
        <div class="card">
            <div class="card-body">
                <div class="mt-4 d-flex align-items-center justify-content-between">
                    <form action="./PurchaseRequestFilter" method="POST">
                        <div class="row align-items-end">
                            <div class="form-group col-md-4">
                                <input type="text" class="form-control" name="nomEmploye">
                            </div>
                            <div class="form-group col-md-4">
                                <input type="submit" class="mx-2 btn btn-gradient-primary" value="Rechercher">                            
                            </div>
                          
                        </div>
                    </form>
                    
                     
                    <div>
                        <a href="./InsertEmploye"
                            class="btn btn-gradient-primary">Nouvelle employe</a>
                    </div>
                </div>
                
                <div class="table-responsive mt-2">
                    <h4 class="card-title">Liste des employes</h4>
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th> ID </th>
                                <th> Nom </th>
                                <th> Prenom </th>
                                <th> Profession </th>
                                <th> Date naissance </th>
                                <th> Date embauche </th>
                                <th> Taux horaire </th>
                            </tr>
                        </thead>
                        <tbody>
                            <% if(request.getAttribute("employes") != null) { 
                                List<VEmploye> employes =(List<VEmploye>)request.getAttribute("employes");
                                for(int i = 0; i < employes.size(); i++) {
                            %>
                            <tr>
                                <td><%=employes.get(i).getId() %></td>
                                <td><%=employes.get(i).getNom() %></td>
                                <td><%=employes.get(i).getPrenom() %></td>
                                <td><%=employes.get(i).getPosteGradeLetter() %></td>
                                <td><%=employes.get(i).getDateNaissance() %></td>
                                <td><%=employes.get(i).getDateEmbauche() %></td>
                                <td><%=employes.get(i).getTauxHoraire() %></td>
                            </tr>
                            <% } } %>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>