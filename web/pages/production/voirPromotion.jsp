<%@page import="java.util.List"%>
<%@page import="model.production.*"%>

<div class="page-header">
    <h3 class="page-title">
        <span class="page-title-icon bg-gradient-primary text-white me-2">
            <i class="mdi mdi-home"></i>
        </span> Produit en promotion
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
<% } 

    if(request.getAttribute("promotions") != null) {
        List<VPromotion> listes = (List<VPromotion>)request.getAttribute("promotions");
        for(VPromotion item : listes) {
%>
<div class="row">
    <div class="col-8 grid-margin mx-auto">
        <div class="card">
            <div class="card-body">
                <h3 class="card-text"><%=item.getDesignation() %></h3>
                <h4 class="card-text">Description </h4>
                <p class="card-description"><%=item.getDescription() %></p>
                <h4 class="card-text">Details promotion </h4>
                <p>Date debut : <%=item.getDateDebut() %></p>
                <p>Date fin : <%=item.getDateFin() %></p>
                <p>Prix de vente ulterieur : <%=item.getPrixExterieur() %> Ariary</p>
                <p>Remise : <%=item.getRemise() %> %</p>
                <p>Prix de vente avec remise : <%=item.getPrixInterieur() %> Ariary</p>
            </div>
        </div>
    </div>
</div>
<% } } %>