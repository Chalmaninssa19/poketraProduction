<%@page import="java.util.List"%>
<%@page import="model.features_product.Size"%>

<div class="page-header">
    <h3 class="page-title">
        <span class="page-title-icon bg-gradient-primary text-white me-2">
            <i class="mdi mdi-home"></i>
        </span> Caractreristiques des produits
    </h3>
</div>

<div class="row">
    <div class="col-8 grid-margin mx-auto">
        <div class="card">
            <div class="card-body">
                <h4 class="card-title">Nouvelle taille</h4>
                <div class="mt-4">
                    <form action="./Size" method="POST">
                        <div class="row align-items-end">
                            <div class="form-group col-md-4">
                                <label for="article">Nom</label>
                                <input type="text" class="form-control" name="name">
                            </div>
                        </div>
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
                        
                        
<div class="row">
    <div class="col-12 grid-margin">
        <div class="card">
            <div class="card-body">
                <h4 class="card-title">Liste taille</h4>
                <div class="table-responsive mt-2">
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th> Nom </th>
                                <th> Action </th>
                            </tr>
                        </thead>
                        <tbody>
                            <% if(request.getAttribute("sizes") != null) { 
                                List<Size> sizes = (List<Size>)request.getAttribute("sizes");
                                for(int i = 0; i < sizes.size(); i++) {
                            %>
                            <tr>
                                <td><%=sizes.get(i).getName() %></td>
                                <td>
                                    <div class="d-flex align-items-center">
                                        <a href="./DeleteSize?idSize=<%=sizes.get(i).getIdSize() %>" class="text-danger action-icon"><i class="mdi mdi-delete"></i></a>
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