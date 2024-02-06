<%@page import="java.util.List"%>
<%@page import="model.production.*"%>
<%@page import="model.VenteClient.*"%>
<%@page import="model.user.*"%>

<body>
    <h3>Vente Client</h3>
    <form action="InsertVenteClient" method="POST">
        <label for="">Client</label>
        <select name="client" id="">
            <% if(request.getAttribute("clients") != null) { 
            List<Client> clients = (List<Client>)request.getAttribute("clients");
            for(Client item : clients) {
            %>
            <option value="<%=item.getIdClient() %>"><%=item.getNom() + " " + item.getPrenom()  %></option>
            <% } } %>
        </select>

        <label for="">Produit</label>
        <select name="product" id="">
            <% if(request.getAttribute("products") != null) { 
            List<Product> products = (List<Product>)request.getAttribute("products");
            for(Product item : products) {
            %>
            <option value="<%=item.getIdProduct() %>"><%=item.getDesignation() %></option>
            <% } } %>
        </select>

        <label for="">Quantite</label>
        <input type="number" id="number" name="quantite">

        <label for="">Date</label>
        <input type="date" name="date">

            <% if(request.getAttribute("error") != null) { %>
                <p class="text-error"><%=request.getAttribute("error") %></p>
            <% } %>
                        
        <input type="submit" value="Valider">
    </form>
</body>