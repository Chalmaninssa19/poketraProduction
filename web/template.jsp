<%@ page contentType="text/html; charset=UTF-8" %>
<%@page import="java.util.List" %>
<% 
    List<String> css = (List<String>) request.getAttribute("css");
    List<String> js = (List<String>) request.getAttribute("js");
%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Purple Admin</title>
        <!-- plugins:css -->
        <link rel="stylesheet" href="assets/vendors/mdi/css/materialdesignicons.min.css">
        <link rel="stylesheet" href="assets/vendors/css/vendor.bundle.base.css">
        <!-- endinject -->
        <!-- Plugin css for this page -->
        <% for(String cssElement : css) { %>
        <link rel="stylesheet" href="<%= cssElement %>">
        <% } %>
        <!-- End plugin css for this page -->
        <!-- inject:css -->
        <!-- endinject -->
        <!-- Layout styles -->
        <link rel="stylesheet" href="assets/css/style.css">
        <!-- End layout styles -->
        <link rel="shortcut icon" href="assets/images/favicon.ico" />
        <script src="./assets/js/apexcharts.min.js"></script>
    </head>

    <body>
        <div class="container-scroller">
            <!-- partial:partials/_navbar.html -->
            <nav class="navbar default-layout-navbar col-lg-12 col-12 p-0 fixed-top d-flex flex-row">
                <div class="text-center navbar-brand-wrapper d-flex align-items-center justify-content-center">
                    <a class="navbar-brand brand-logo" href="index.html"><img src="assets/images/logo.svg"
                                                                              alt="logo" /></a>
                    <a class="navbar-brand brand-logo-mini" href="index.html"><img src="assets/images/logo-mini.svg"
                                                                                   alt="logo" /></a>
                </div>
                
            </nav>
            <!-- partial -->
            <div class="container-fluid page-body-wrapper">
                <!-- partial:partials/_sidebar.html -->
                <nav class="sidebar sidebar-offcanvas" id="sidebar">
                    <ul class="nav">
                        <li class="nav-item">
                            <a class="nav-link" data-bs-toggle="collapse" href="#ui-basic-vente" aria-expanded="false" aria-controls="ui-basic">
                                <span class="menu-title">Caracteristiques produits</span>
                                <i class="mdi mdi-cart menu-icon"></i>
                            </a>
                            <div class="collapse" id="ui-basic-vente">
                                <ul class="nav flex-column sub-menu">
                                    <li class="nav-item"> <a class="nav-link" href="./Size">Taille</a></li>
                                    <li class="nav-item"> <a class="nav-link" href="./Type">Type</a></li>
                                    <li class="nav-item"> <a class="nav-link" href="./Look">Look</a></li>
                                    <li class="nav-item"> <a class="nav-link" href="./Unity">Unite</a></li>
                                    <li class="nav-item"> <a class="nav-link" href="./Matiere">Matiere</a></li>
                                </ul>
                            </div>                                                                                                                                                            
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" data-bs-toggle="collapse" href="#ui-basic-vente" aria-expanded="false" aria-controls="ui-basic">
                                <span class="menu-title">Poste et grade</span>
                                <i class="mdi mdi-cart menu-icon"></i>
                            </a>
                            <div class="collapse" id="ui-basic-vente">
                                <ul class="nav flex-column sub-menu">
                                    <li class="nav-item"> <a class="nav-link" href="./Poste">Poste</a></li>
                                    <li class="nav-item"> <a class="nav-link" href="./Grade">Grade</a></li>
                                </ul>
                            </div>                                                                                                                                                            
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" data-bs-toggle="collapse" href="#ui-basic-vente" aria-expanded="false" aria-controls="ui-basic">
                                <span class="menu-title">Employe</span>
                                <i class="mdi mdi-cart menu-icon"></i>
                            </a>
                            <div class="collapse" id="ui-basic-vente">
                                <ul class="nav flex-column sub-menu">
                                    <li class="nav-item"> <a class="nav-link" href="./ListEmploye">employes</a></li>
                                </ul>
                            </div>                                                                                                                                                            
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" data-bs-toggle="collapse" href="#ui-basic-vente" aria-expanded="false" aria-controls="ui-basic">
                                <span class="menu-title">Formule</span>
                                <i class="mdi mdi-cart menu-icon"></i>
                            </a>
                            <div class="collapse" id="ui-basic-vente">
                                <ul class="nav flex-column sub-menu">
                                    <li class="nav-item"> <a class="nav-link" href="./MatiereLook">Matiere-Look</a></li>
                                    <li class="nav-item"> <a class="nav-link" href="./QuantityFormuleList">Quantite</a></li>
                                    <li class="nav-item"> <a class="nav-link" href="./TimeFormuleList">Duree employe</a></li>
                                </ul>
                            </div>                                                                                                                                                            
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" data-bs-toggle="collapse" href="#ui-basic-vente" aria-expanded="false" aria-controls="ui-basic">
                                <span class="menu-title">Stockage</span>
                                <i class="mdi mdi-cart menu-icon"></i>
                            </a>
                            <div class="collapse" id="ui-basic-vente">
                                <ul class="nav flex-column sub-menu">
                                    <li class="nav-item"> <a class="nav-link" href="./Mouvement">Mouvements</a></li>
                                    <li class="nav-item"> <a class="nav-link" href="./EtatStock">Etat de stock</a></li>
                                </ul>
                            </div>                                                                                                                                                            
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" data-bs-toggle="collapse" href="#ui-basic-vente" aria-expanded="false" aria-controls="ui-basic">
                                <span class="menu-title">Production et fabrication</span>
                                <i class="mdi mdi-cart menu-icon"></i>
                            </a>
                            <div class="collapse" id="ui-basic-vente">
                                <ul class="nav flex-column sub-menu">
                                    <li class="nav-item"> <a class="nav-link" href="./ProductList">Produits existants</a></li>
                                    <li class="nav-item"> <a class="nav-link" href="./ProductFabriquesList">Produits fabriques</a></li>
                                    <li class="nav-item"> <a class="nav-link" href="./StockFabrication">Stockage fabrication</a></li>
                                </ul>
                            </div>                                                                                                                                                            
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" data-bs-toggle="collapse" href="#ui-basic-vente" aria-expanded="false" aria-controls="ui-basic">
                                <span class="menu-title">Vente et client</span>
                                <i class="mdi mdi-cart menu-icon"></i>
                            </a>
                            <div class="collapse" id="ui-basic-vente">
                                <ul class="nav flex-column sub-menu">
                                    <li class="nav-item"> <a class="nav-link" href="./InsertClient">Client</a></li>
                                    <li class="nav-item"> <a class="nav-link" href="./InsertVenteClient">Insert vente</a></li>
                                    <li class="nav-item"> <a class="nav-link" href="./ListVenteClient">Liste vente</a></li>
                                </ul>
                            </div>                                                                                                                                                            
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" data-bs-toggle="collapse" href="#ui-basic-vente" aria-expanded="false" aria-controls="ui-basic">
                                <span class="menu-title">Facturation</span>
                                <i class="mdi mdi-cart menu-icon"></i>
                            </a>
                            <div class="collapse" id="ui-basic-vente">
                                <ul class="nav flex-column sub-menu">
                                    <li class="nav-item"> <a class="nav-link" href="./InsertFacture">Creer facture</a></li>
                                    <li class="nav-item"> <a class="nav-link" href="./ListFacture">listes factures</a></li>
                                </ul>
                            </div>                                                                                                                                                            
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="./Statistique">
                                <span class="menu-title">Statistiques</span>
                                <i class="mdi mdi-cart menu-icon"></i>
                            </a>
                        </li>
                    </ul>
                </nav>
                <!-- partial -->
                <div class="main-panel">
                    <div class="content-wrapper">
                        <jsp:include page="${contentPage}" />
                    </div>
                    <!-- content-wrapper ends -->
                    <!-- partial:/partials/_footer.html -->
                    <footer class="footer">
                        <div class="container-fluid d-flex justify-content-between">
                            <span class="text-muted d-block text-center text-sm-start d-sm-inline-block">Copyright �
                                bootstrapdash.com 2021</span>
                            <span class="float-none float-sm-end mt-1 mt-sm-0 text-end"> Free <a
                                    href="https://www.bootstrapdash.com/bootstrap-admin-template/" target="_blank">Bootstrap
                                    admin template</a> from Bootstrapdash.com</span>
                        </div>
                    </footer>
                    <!-- partial -->
                </div>
                <!-- main-panel ends -->
            </div>
            <!-- page-body-wrapper ends -->
        </div>
        <!-- container-scroller -->
        <!-- plugins:js -->
        <script src="./assets/vendors/js/vendor.bundle.base.js"></script>
        <!-- endinject -->
        <!-- Plugin js for this page -->
        <!-- End plugin js for this page -->
        <!-- inject:js -->
        <script src="./assets/js/off-canvas.js"></script>
        <script src="./assets/js/hoverable-collapse.js"></script>
        <script src="./assets/js/misc.js"></script>
        <!-- endinject -->
        <!-- Custom js for this page -->
        <% for(String jsElement : js) { %>
        <script src="<%= jsElement %>"></script>
        <% } %>
        <!-- End custom js for this page -->
    </body>

</html>

