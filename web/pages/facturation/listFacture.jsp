<%@page import="java.util.List"%>
<%@page import="model.production.*"%>
<%@page import="model.facturation.*"%>


<div class="page-header">
    <h3 class="page-title">
        <span class="page-title-icon bg-gradient-primary text-white me-2">
            <i class="mdi mdi-home"></i>
        </span> Facturation
    </h3>
</div>


<% if(request.getAttribute("error") != null) { %>          
<div class="row">
    <div class="col-12 grid-margin">
        <div class="card">
            <div class="card-body">
                    <p class="text-warning"><%=request.getAttribute("error") %></p>
            </div>
        </div>
    </div>
</div>
<% } %>

<div class="row">
    <div class="col-8 grid-margin mx-auto">
        <div class="card">
            <div class="card-body">
                <h2 class="card-text">Liste factures</h2>
                <div class="mt-4">
                        <table class="table">
                            <tr>
                                <th>Reference</th>
                                <th>Client</th>
                                <th>Date</th>
                                <th>Action</th>
                            </tr>
                           <% if(request.getAttribute("facture") != null) { 
                            List<Facture> list = (List<Facture>)request.getAttribute("facture");
                            for(Facture item : list) {
                           %>
                            <tr>
                                <td>
                                   <%=item.getReference() %>
                                </td>
                                <td>
                                   <%=item.getClient().getNom() %>
                                </td>
                                <td>
                                   <%=item.getDate() %>
                                </td>
                                <td>
                                    <a href="FicheFacture?idFacture=<%=item.getIdFacture() %>" class="text-avatar">Details</a>
                                </td>
                            </tr>
                            <% } } %>
                        </table>
                </div>
            </div>
        </div>
    </div>
</div>