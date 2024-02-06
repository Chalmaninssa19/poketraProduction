<%@page import="java.util.List"%>
<%@page import="model.vente.*"%>
<%@page import="model.production.*"%>

<h3>Statistique vente par genre</h3>
<div class="row">
    <div class="col-12 grid-margin">
        <div class="card">
            <div class="card-body">
                <div id="formu">
                    <form action="StatVenteGenreFilter" method="POST">
                        <label for="">Produit</label>
                        <select name="product">
                            <% if(request.getAttribute("products") != null) { 
                            List<Product> products = (List<Product>)request.getAttribute("products");
                            for(Product item : products) {
                            %>
                            <option value="<%=item.getIdProduct() %>"><%=item.getDesignation() %></option>
                            <% } } %>
                        </select>

                        <button>Filtrer</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
                        
<div class="row">
    <div class="col-6 grid-margin">
        <div class="card">
            <div class="card-body">
                <div class="table-bordered mt-2">
                    <h4 class="card-title">Tableau statistique</h4>
                    <table class="table table-bordered">
                        <% if(request.getAttribute("statVenteByGenre") != null) { 
                            List<VStatGenreAllProduct> stat =(List<VStatGenreAllProduct>)request.getAttribute("statVenteByGenre");
                        %>
                        <tbody>
                            <% 
                                for(int i = 0; i < stat.size(); i++) {
                            %>
                            <tr>
                                <td>Total <%=stat.get(i).getGenreLetter() %></td>
                                <td><%=stat.get(i).getPercent() %> %</td>
                            </tr>
                        </tbody>
                        <% } }
                            if(request.getAttribute("statFilterByProduct") != null) { 
                            List<VStatVenteGenre> stat =(List<VStatVenteGenre>)request.getAttribute("statFilterByProduct");
                        %>
                        <thead>
                            <tr>
                                <th> Produit </th>
                                <th> Genre </th>
                                <th> Pourcentage % </th>
                            </tr>
                        </thead>
                        <tbody>
                            <% 
                                for(int i = 0; i < stat.size(); i++) {
                            %>
                            <tr>
                                <td><%=stat.get(i).getIdProduct() %></td>
                                <td><%=stat.get(i).getGenreLetter() %></td>
                                <td><%=stat.get(i).getPercentNumber() %> %</td>
                            </tr>
                        </tbody>
                        <% } }  %>
                    </table>
                </div>
                <div class="table-bordered mt-2">
                    <% 
                        if(request.getAttribute("allProduct") != null) { 
                        List<VStatVenteGenre> stat =(List<VStatVenteGenre>)request.getAttribute("allProduct");
                    %>
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th> Produit </th>
                                <th> Genre </th>
                                <th> client </th>
                            </tr>
                        </thead>
                        <tbody>
                            <% 
                                 for(int i = 0; i < stat.size(); i++) {
                            %>
                            <tr>
                                <td><%=stat.get(i).getIdProduct() %></td>
                                <td><%=stat.get(i).getGenreLetter() %></td>
                                <td><%=stat.get(i).getNumberClient() %></td>
                            </tr>
                            <% } %>
                        </tbody>
                    </table>    
                        <% } %>
                </div>

            </div>
        </div>
    </div>
                        
                    
    <div class="col-6 grid-margin">
        <div class="card">
            <div class="card-body">
                <div class="card">
                  <div class="card-body">
                    <h4 class="card-title">Chart</h4>
                    <canvas id="pieChart" style="height:250px"></canvas>
                  </div>
                </div>
            </div>
        </div>
    </div>
</div>