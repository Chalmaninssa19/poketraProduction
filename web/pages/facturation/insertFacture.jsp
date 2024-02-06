<%@page import="java.util.List"%>
<%@page import="model.production.*"%>
<%@page import="model.user.*"%>

<div class="page-header">
    <h3 class="page-title">
        <span class="page-title-icon bg-gradient-primary text-white me-2">
            <i class="mdi mdi-home"></i>
        </span> Facturation
    </h3>
</div>

<div class="row">
    <div class="col-8 grid-margin mx-auto">
        <div class="card">
            <div class="card-body">
                <h2 class="card-text">Creer facture</h2>
                <div class="mt-4">
                    <form action="./InsertFacture" method="POST">
                        <div class="row align-items-end">
                            <div class="form-group col-md-4">
                                <label for="article">Date</label>
                                <input type="date" class="form-control" name="date">
                            </div>
                        </div>
                         <div class="row align-items-end">
                            <div class="form-group col-md-5">
                                <label for="article">Client</label>
                                <select name="client" class="form-control form-control-sm input-height mt-2">
                                    <% if(request.getAttribute("clients") != null) { 
                                    List<Client> clients = (List<Client>)request.getAttribute("clients");
                                    for(Client item : clients) {
                                    %>
                                    <option value="<%=item.getIdClient() %>"><%=item.getNom() + " " + item.getPrenom()  %></option>
                                    <% } } %>
                                </select>
                            </div>
                        </div>
                        
                        <h4>Detaille</h4>
                        <table class="table">
                            <tr>
                            <th>Produit</th>
                            <th>Quantite</th>
                            <th>Remise %</th>
                            </tr>
                             <% if(request.getAttribute("products") != null) { 
                                    List<VProductPrice> listes = (List<VProductPrice>)request.getAttribute("products");
                                    for(int i = 0; i < listes.size(); i++) {
                                    %>
                            <tr>
                                <td>
                                    <input class="form-check-input" type="checkbox" id="gridCheck" name="products" value="<%= listes.get(i).getIdProduct()%>">
                                    <label class="form-check-label" for="gridCheck" ><%= listes.get(i).getDesignation() + ", " + listes.get(i).getPrixVente()%> ariary </label>               
                                </td>
                                <td>
                                    <input class="form-control" type="number" step="0.01" name="quantite<%= listes.get(i).getIdProduct()%>">           
                                </td>
                                <td>
                                    <input class="form-control" type="number" step="0.01" name="remise<%= listes.get(i).getIdProduct()%>">           
                                </td>
                            </tr>

                            <%        }
                                }
                            %>
                        </table>
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