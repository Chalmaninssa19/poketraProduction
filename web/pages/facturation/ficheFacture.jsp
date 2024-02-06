<%@page import="java.util.List"%>
<%@page import="model.facturation.*"%>

<% if(request.getAttribute("ficheFacture") != null) { 
VFicheFacture fichefacture = (VFicheFacture)request.getAttribute("ficheFacture");
%>
<div class="row">
    <div class="col-12 grid-margin">
        <div class="card">
            <div class="card-body">
                <h1 style="text-align: center;margin-bottom:10%;">Fiche de Facture</h1>
                <p style="margin-left:15%;  width:70%;"><h4>Reference : <%=fichefacture.getReference() %></h4></p>
                <p style="margin-left:15%;  width:70%;"><h4>Client : <%=fichefacture.getClient() %></h4></p>
                <p style="margin-left:15%;  width:70%;"><h4>Date: <%=fichefacture.getDate() %></h4></p>
                <p style="margin-left:15%; width:70%;"><h4>Total: <%=fichefacture.getTotalFacture() %> ariary</h4></p>
                <p style="margin-left:15%; width:70%;"><h4>Total remise: <%=fichefacture.getTotalRemise() %> ariary</h4></p>
                <p style="margin-left:15%; width:70%;"><h4>Total a payer avec remise: <%=fichefacture.getWithRemise() %> ariary</h4></p>
                <p style="margin-left:15%; width:70%;"><h4>Rest a payer: <%=fichefacture.getRestePayer() %> ariary</h4></p>
                <p style="margin-left:15%; width:70%;"><h4>deja payer: <%=fichefacture.getDejaPayer() %> ariary</h4></p>

                    <div class="mt-4">
                        <table class="table">
                            <tr>
                                <th>Produit</th>
                                <th>Quantite</th>
                                <th>Prix unitaire</th>
                                <th>Remise %</th>
                                <th>Montant</th>
                                <th>Montant avec remise</th>
                            </tr>
                            <% for(VDetailsFacture item : fichefacture.getDetailsFacture()) { %>
                            <tr>
                                <td><%=item.getProduct() %></td>
                                <td><%=item.getQuantite() %></td>
                                <td><%=item.getPrixVente() %></td>
                                <td><%=item.getRemise() %> %</td>
                                <td><%=item.getMontant() %></td>
                                <td><%=item.getMontantRemise() %></td>
                            </tr>
                            <% } %>
                        </table>
                    </div>
                    
                </div>
            </div>
        </div>
    </div>
<div class="row">
    <div class="col-12 grid-margin">
        <div class="card">
            <div class="card-body">
                <div class="col-5">
                    <h4>Payement</h4>
                    <form action="PaymentFacture" method="POST" >
                        <input type="hidden" name="id" value="<%=fichefacture.getIdFacture() %>"/>
                        <div class="row align-items-end">
                            <div class="form-group col-md-8">
                                <label for="article">Date</label>
                                <input type="date" class="form-control" name="date">
                            </div>
                        </div>
                        <div class="row align-items-end">
                            <div class="form-group col-md-8">
                                <label for="article">Montant</label>
                                <input type="number" step="0.01" class="form-control" name="montant">
                            </div>
                        </div>
                         <% if(request.getAttribute("error") != null) { %>
                            <p class="text-error"><%=request.getAttribute("error") %></p>
                        <% } %>
                        <input type="submit" value="Payer" class="btn btn-primary">
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<% } %>