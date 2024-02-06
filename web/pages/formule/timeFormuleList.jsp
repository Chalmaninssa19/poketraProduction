<%@page import="java.util.List"%>
<%@page import="model.features_product.*"%>
<%@page import="model.formule.*"%>

<div class="page-header">
    <h3 class="page-title">
        <span class="page-title-icon bg-gradient-primary text-white me-2">
            <i class="mdi mdi-home"></i>
        </span> Formule duree
    </h3>
</div>
<div class="row">
    <div class="col-12 grid-margin">
        <div class="card">
            <div class="card-body">
                <h4 class="card-title">Duree par produit</h4>
                <div class="mt-4 d-flex align-items-center justify-content-between">
                    <form action="./PurchaseRequestFilter" method="POST">
                        <div class="input-groups d-flex align-items-center">
                            <div class="form-group me-4">
                                <label for="">Look</label>
                                <select name="status" id=""
                                    class="form-control form-control-sm px-5 mt-2">
                                    <option value="1">Luxe</option>
                                    <option value="2">Degrader</option>
                                    <option value="0">Normal</option>
                                </select>
                            </div>
                            <div>
                                <input type="submit" class="mx-2 btn btn-gradient-primary"
                                    value="Filtrer">
                            </div>
                        </div>
                    </form>
                    <div>
                        <a href="./TimeFormuleInsert"
                            class="btn btn-gradient-primary">Nouvelle formule</a>
                    </div>
                </div>
                <div class="table-responsive mt-2">
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th> Taille </th>
                                <th> Type </th>
                                <th> Look </th>
                                <th> Duree </th>
                                <th> Profession </th>
                                <th> Employe </th>
                                <th> Action </th>
                            </tr>
                        </thead>
                        <tbody>
                            <% if(request.getAttribute("durationProduction") != null) { 
                                List<DurationProduction> durationProduction = (List<DurationProduction>)request.getAttribute("durationProduction");
                                for(int i = 0; i < durationProduction.size(); i++) {
                            %>
                            <tr>
                                <td><%=durationProduction.get(i).getSize().getName() %></td>
                                <td><%=durationProduction.get(i).getType().getName() %></td>
                                <td><%=durationProduction.get(i).getLook().getName() %></td>
                                <td><%=durationProduction.get(i).getDuration() %> heure</td>
                                <td><%=durationProduction.get(i).getProfession().getNom() %></td>
                                <td><%=durationProduction.get(i).getNombreEmploye() %></td>
                                <td>
                                    <div class="d-flex align-items-center">
                                        <a href="#" class="text-danger action-icon"><i class="mdi mdi-delete"></i></a>
                                        <a href="#" class="text-warning action-icon"><i class="mdi mdi-settings"></i></a>
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