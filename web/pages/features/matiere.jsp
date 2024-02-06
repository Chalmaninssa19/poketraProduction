<%@page import="java.util.List"%>
<%@page import="model.features_product.*"%>

<div class="page-header">
    <h3 class="page-title">
        <span class="page-title-icon bg-gradient-primary text-white me-2">
            <i class="mdi mdi-home"></i>
        </span> Caractreristiques des produits
    </h3>
</div>

<div class="row">
    <div class="col-8 grid-margin mx-auto">
        <div class="card">
            <div class="card-body">
                <h4 class="card-title">Nouvelle matiere</h4>
                <div class="mt-4">
                    <form action="./Matiere" method="POST">
                        <div class="row align-items-end">
                            <div class="form-group col-md-4">
                                <label for="article">Nom</label>
                                <input type="text" class="form-control" name="name">
                            </div>
                            <div class="form-group me-4">
                                <label for="">Unite</label>
                                <select name="unity" id="" class="form-control form-control-sm px-5 mt-2">
                                <% if(request.getAttribute("unitys") != null) { 
                                    List<Unity> unitys = (List<Unity>)request.getAttribute("unitys");
                                    for(int i = 0; i < unitys.size(); i++) {
                                %>
                                    <option value="1"><%=unitys.get(i).getName() %></option>
                                <% } } %>
                                </select>
                            </div>
                            <div class="form-group col-md-4">
                                <label for="article">Prix</label>
                                <input type="number" step="0.01" class="form-control" name="prix">
                            </div>
                        </div>
                        <% if(request.getAttribute("error") != null) { %>
                            <p class="text-error"><%=request.getAttribute("error") %></p>
                        <% } %>
                        <div class="mt-3">
                            <button type="submit"
                                class="btn btn-gradient-primary px-5 me-2">Creer</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
                        
                        
<div class="row">
    <div class="col-12 grid-margin">
        <div class="card">
            <div class="card-body">
                <h4 class="card-title">Liste matiere</h4>
                <div class="table-responsive mt-2">
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th> Nom </th>
                                <th> Unite </th>
                                <th> Prix </th>
                                <th> Action </th>
                            </tr>
                        </thead>
                        <tbody>
                            <% if(request.getAttribute("matiere") != null) { 
                                List<VMatiere> matieres = (List<VMatiere>)request.getAttribute("matiere");
                                for(int i = 0; i < matieres.size(); i++) {
                            %>
                            <tr>
                                <td><%=matieres.get(i).getMatiere() %></td>
                                <td><%=matieres.get(i).getUnity() %></td>
                                <td><%=matieres.get(i).getPrixLetter() %></td>
                                <td>
                                    <div class="d-flex align-items-center">
                                        <a href="./DeleteMatiere?idMatiere=<%=matieres.get(i).getIdMatiere() %>" class="text-danger action-icon"><i class="mdi mdi-delete"></i></a>
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