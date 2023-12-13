<%@page import="java.util.List"%>
<%@page import="model.look.*" %>

<%@page contentType="text/html; charset=UTF-8" %>
<%
    List<RMatiereLook> rMatiereLook = (List<RMatiereLook>) request.getAttribute("rMatiereLooks");
%>
<div class="page-header">
    <h3 class="page-title">
        <span class="page-title-icon bg-gradient-primary text-white me-2">
            <i class="mdi mdi-home"></i>
        </span> Matiere look
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
                <h4 class="card-title">Listes des matiere par look</h4>
                <div class="mt-4 d-flex align-items-center justify-content-between">
                    <form action="./FilterMatiere" method="POST">
                        <div class="input-groups d-flex align-items-center">
                            <div class="row align-items-end">
                                <div class="form-group col-md-5">
                                    <% if(request.getAttribute("looks") != null) { 
                                    List<Look> looks = (List<Look>)request.getAttribute("looks");
                                    %>
                                    <label for="article">Look</label>
                                    <select name="look" class="form-control form-control-sm input-height mt-2">
                                        <% for(int i = 0; i < looks.size(); i++) { %>
                                        <option value="<%=looks.get(i).getId() %>"><%=looks.get(i).getNom() %></option>
                                        <% } %>
                                    </select>
                                    <% } %>
                                </div>
                            </div>
                            <div>
                                <input type="submit" class="mx-2 btn btn-gradient-primary"
                                       value="filtrer">
                            </div>
                        </div>
                    </form>
                </div>
                <div class="mt-3">
                    <a href="./InsertMatiereLook">
                        <button type="submit"
                        class="btn btn-gradient-primary px-5 me-2">Ajouter un nouveau matiere</button>
                    </a>
                </div>
                <div class="table-responsive mt-2">
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th> ID </th>
                                <th> Matiere </th>
                                <th> Look </th>
                                <th> Etat </th>
                                <th>Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            <% for(int i=0;i<rMatiereLook.size();i++) { %>
                            <tr>
                                <td><%= rMatiereLook.get(i).getId() %></td>
                                <td><%= rMatiereLook.get(i).getMatiere().getNom() %></td>
                                <td><%= rMatiereLook.get(i).getLook().getNom() %></td>
                                 <td><%= rMatiereLook.get(i).getEtat() %></td>
                            </tr>
                            <% } %>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>

