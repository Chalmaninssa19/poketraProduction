<%@page import="java.util.List"%>
<%@page import="model.production.*"%>
<%@page import="model.vente.*"%>

<div class="page-header">
    <h3 class="page-title">
        <span class="page-title-icon bg-gradient-primary text-white me-2">
            <i class="mdi mdi-home"></i>
        </span> Vente
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
                    
                     
                </div>
                
                <div class="table-responsive mt-2">
                    <h4 class="card-title">Liste des ventes</h4>
                    <table>
                        <thead>
                            <tr>
                                <th> Date </th>
                                <th> Produit </th>
                                <th> Client </th>
                                <th> Quantite </th>
                            </tr>
                        </thead>
                        <tbody>
                            <% if(request.getAttribute("venteClients") != null) { 
                                List<VVenteClient> ventes =(List<VVenteClient>)request.getAttribute("venteClients");
                                for(int i = 0; i < ventes.size(); i++) {
                            %>
                            <tr>
                                <td><%=ventes.get(i).getDate() %></td>
                                <td><%=ventes.get(i).getDesignation() %></td>
                                <td><%=ventes.get(i).getNom() +" "+ventes.get(i).getPrenom() %></td>
                                <td><%=ventes.get(i).getQuantite() %></td>
                            </tr>
                            <% } } %>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>