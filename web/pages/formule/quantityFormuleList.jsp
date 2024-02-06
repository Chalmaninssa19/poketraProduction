<%@page import="java.util.List"%>
<%@page import="model.features_product.*"%>
<%@page import="model.formule.*"%>

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
    <div class="col-12 grid-margin">
        <div class="card">
            <div class="card-body">
                <h4 class="card-title">Quantite par matiere</h4>
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
                        <a href="./QuantityFormuleInsert"
                            class="btn btn-gradient-primary">Nouvelle formule</a>
                    </div>
                </div>
                <div class="table-responsive mt-2">
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th> Look </th>
                                <th> Type </th>
                                <th> Taille </th>
                                <th> Matiere </th>
                                <th> Quantite </th>
                                <th> Action </th>
                            </tr>
                        </thead>
                        <tbody>
                        <% if(request.getAttribute("quantityMatiereProds") != null) { 
                        List<VQuantityProduction> qmp = (List<VQuantityProduction>)request.getAttribute("quantityMatiereProds");
                        for(int i = 0; i < qmp.size(); i++) {
                        %>
                            <tr>
                                <td><%=qmp.get(i).getLook() %></td>
                                <td><%=qmp.get(i).getType() %></td>
                                <td><%=qmp.get(i).getSize() %></td>
                                <td><%=qmp.get(i).getMatiere() %></td>
                                <td><%=qmp.get(i).getQuantity() %></td>
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