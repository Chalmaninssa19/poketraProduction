<%@page import="java.util.List"%>
<%@page import="model.user.*"%>

<div class="row">
    <div class="col-12 grid-margin">
        <div class="card">
            <div class="card-body">

            <h3>Insertion Client</h3>
            <form action="InsertClient" method="POST">
                <label for="">Nom</label>
                <input type="text" id="name" name="nom">

                <label for="">Prenom</label>
                <input type="text" id="number" name="prenom">

                <label for="">Email</label>
                <input type="text" id="number" name="email">

                <label for="">Date</label>
                <input type="date" id="number" name="dateNaissance">

                <label for="">Genre</label>
                <select name="genre" id="genre" name="genre">
                    <option value="1">Masculin</option>
                    <option value="2">Feminin</option>
                </select>
                <% if(request.getAttribute("error") != null) { %>
                    <p class="text-error"><%=request.getAttribute("error") %></p>
                <% } %>
                <input type="submit" value="Valider">
            </form>
            </div>
        </div>
    </div>
</div>

<div class="row">
    <div class="col-12 grid-margin">
        <div class="card">
            <div class="card-body">
                <div class="table-responsive mt-2">
                    <h3>Listes client</h3>
                    <table class="table table-responsive">
                        <thead>
                            <tr>
                                <th> ID </th>
                                <th> Nom </th>
                                <th> Prenom </th>
                                <th> Email </th>
                                <th> Date naissance </th>
                                <th> Genre </th>
                            </tr>
                        </thead>
                        <tbody>
                            <% if(request.getAttribute("clients") != null) { 
                                List<Client> clients =(List<Client>)request.getAttribute("clients");
                                for(int i = 0; i < clients.size(); i++) {
                            %>
                            <tr>
                                <td><%=clients.get(i).getIdClient() %></td>
                                <td><%=clients.get(i).getNom() %></td>
                                <td><%=clients.get(i).getPrenom() %></td>
                                 <td><%=clients.get(i).getEmail() %></td>
                                <td><%=clients.get(i).getDate_naissance() %></td>
                                <td><%=clients.get(i).getGenreLetter() %></td>
                            </tr>
                            <% } } %>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>