<%@page import="java.util.List"%>
<%@page import="model.features_product.*"%>
<%@page import="model.stockage.*"%>

<% 
    EtatStock etatStock = new EtatStock();
    if(request.getAttribute("etatStock") != null) { 
        etatStock = (EtatStock)request.getAttribute("etatStock");
    }
%>
<div class="page-header">
    <h3 class="page-title">
        <span class="page-title-icon bg-gradient-primary text-white me-2">
            <i class="mdi mdi-home"></i>
        </span> Etat de stock
    </h3>
</div>
<div class="row">
    <div class="col-12 grid-margin">
        <div class="card">
            <div class="card-body">
                    
                    <form action="./EtatStockFilter" method="POST">
                        <div class="input-groups d-flex align-items-center">
                            <div class="col-md-3 form-group mb-2 px-4">
                                <label for="" class="form-label">Date debut</label>
                                <input type="date" class="form-control" name="dateDebut" value="<%=etatStock.getDateDebut() %>">
                            </div>
                            <div class="col-md-3 form-group mb-2 px-4">
                                <label for="" class="form-label">Date fin</label>
                                <input type="date" class="form-control" name="dateFin" value="<%=etatStock.getDateFin() %>">
                            </div>
                            <div class="col-md-3 form-group mb-2 px-4">
                                <label for="" class="form-label">Matiere</label>
                                <select name="matiere" id="" class="form-select form-control same-height">
                                    <option value="0">Tous</option>
                                    <% if(request.getAttribute("matieres") != null) { 
                                        List<Matiere> matieres =(List<Matiere>)request.getAttribute("matieres");
                                        for(int i = 0; i < matieres.size(); i++) {
                                    %>
                                    <option value="<%=matieres.get(i).getIdMatiere() %>"><%=matieres.get(i).getName() %></option>
                                    <% } } %>
                                </select>
                            </div>
                            <div class="col-md-3 form-group mb-2 px-4 d-flex align-items-end">
                                <button type="submit" class="btn btn-gradient-primary same-height">Filtrer</button>
                            </div>
                        </div>
                    </form>
                
                <div class="table-responsive mt-2">
                    <h4 class="card-title">Etat de stock</h4>
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th> Matiere </th>
                                <th> Qte initial </th>
                                <th> Entree </th>
                                <th> Sortie </th>
                                <th> Qte final </th>
                                <th> PU </th>
                                <th> Montant </th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                for(Stock item : etatStock.getStockList()) {
                            %>
                            <tr>
                                <td><%=item.getMatiere() %></td>
                                <td><%=item.getQuantiteInitial() %></td>
                                <td><%=item.getEntree() %></td>
                                <td><%=item.getSortie() %></td>
                                <td><%=item.getQuantiteFinal() %></td>
                                <td><%=item.getPrixUnitaireLetter() %></td>
                                <td><%=item.getMontantLetter() %></td>
                            </tr>
                            <% } %>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>