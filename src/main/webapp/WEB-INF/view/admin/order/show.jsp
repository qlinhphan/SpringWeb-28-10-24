<%@ page contentType="text/html; charset=UTF-8" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
            <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
                <!DOCTYPE html>
                <html lang="en">

                <head>
                    <meta charset="utf-8" />
                    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
                    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
                    <meta name="description" content="" />
                    <meta name="author" content="" />
                    <title>Dashboard - SB Admin</title>
                    <link href="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/style.min.css"
                        rel="stylesheet" />
                    <link href="/css/styles.css" rel="stylesheet" />
                    <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js"
                        crossorigin="anonymous"></script>
                    <style>
                        table {
                            font-family: arial, sans-serif;
                            border-collapse: collapse;
                            width: 100%;
                        }

                        td,
                        th {
                            border: 1px solid #dddddd;
                            text-align: left;
                            padding: 8px;
                        }

                        tr:nth-child(even) {
                            background-color: #dddddd;
                        }
                    </style>
                </head>

                <body class="sb-nav-fixed">
                    <nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
                        <!-- Navbar Brand-->
                        <a class="navbar-brand ps-3" href="index.html">Laptop Shop</a>
                        <!-- Sidebar Toggle-->
                        <button class="btn btn-link btn-sm order-1 order-lg-0 me-4 me-lg-0" id="sidebarToggle"
                            href="#!"><i class="fas fa-bars"></i></button>
                        <!-- Navbar Search-->
                        <div
                            style="display: flex; justify-content: center; align-items: center; margin-top: 1.5%; margin-left: 33%;">
                            <p style="color: aliceblue;">Hi, ${currentUserLogin}</p>
                        </div>
                        <!-- Navbar-->

                    </nav>
                    <div id="layoutSidenav">
                        <div id="layoutSidenav_nav">
                            <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
                                <div class="sb-sidenav-menu">
                                    <div class="nav">
                                        <div class="sb-sidenav-menu-heading">Core</div>
                                        <a class="nav-link" href="/adminDash">
                                            <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                                            Dashboard
                                        </a>
                                        <a class="nav-link" href="/table/user">
                                            <div class="sb-nav-link-icon"><i class="fa-solid fa-users"></i></div>
                                            User
                                        </a>
                                        <a class="nav-link" href="/adminProduct">
                                            <div class="sb-nav-link-icon"><i class="fa-brands fa-product-hunt"></i>
                                            </div>
                                            Product
                                        </a>
                                        <a class="nav-link" href="/adminOrder">
                                            <div class="sb-nav-link-icon"><i class="fa-regular fa-newspaper"></i></div>
                                            Order
                                        </a>
                                        <!-- <div class="sb-sidenav-menu-heading">Interface</div>
                        <a class="nav-link collapsed" href="#" data-bs-toggle="collapse"
                            data-bs-target="#collapseLayouts" aria-expanded="false" aria-controls="collapseLayouts">
                            <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                            Layouts
                            <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                        </a>
                        <div class="collapse" id="collapseLayouts" aria-labelledby="headingOne"
                            data-bs-parent="#sidenavAccordion">
                            <nav class="sb-sidenav-menu-nested nav">
                                <a class="nav-link" href="layout-static.html">Static Navigation</a>
                                <a class="nav-link" href="layout-sidenav-light.html">Light Sidenav</a>
                            </nav>
                        </div> -->
                                        <!-- <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapsePages"
                            aria-expanded="false" aria-controls="collapsePages">
                            <div class="sb-nav-link-icon"><i class="fas fa-book-open"></i></div>
                            Pages
                            <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                        </a> -->
                                        <!-- <div class="collapse" id="collapsePages" aria-labelledby="headingTwo"
                            data-bs-parent="#sidenavAccordion">
                            <nav class="sb-sidenav-menu-nested nav accordion" id="sidenavAccordionPages">
                                <a class="nav-link collapsed" href="#" data-bs-toggle="collapse"
                                    data-bs-target="#pagesCollapseAuth" aria-expanded="false"
                                    aria-controls="pagesCollapseAuth">
                                    Authentication
                                    <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                                </a>
                                <div class="collapse" id="pagesCollapseAuth" aria-labelledby="headingOne"
                                    data-bs-parent="#sidenavAccordionPages">
                                    <nav class="sb-sidenav-menu-nested nav">
                                        <a class="nav-link" href="login.html">Login</a>
                                        <a class="nav-link" href="register.html">Register</a>
                                        <a class="nav-link" href="password.html">Forgot Password</a>
                                    </nav>
                                </div>
                                <a class="nav-link collapsed" href="#" data-bs-toggle="collapse"
                                    data-bs-target="#pagesCollapseError" aria-expanded="false"
                                    aria-controls="pagesCollapseError">
                                    Error
                                    <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                                </a>
                                <div class="collapse" id="pagesCollapseError" aria-labelledby="headingOne"
                                    data-bs-parent="#sidenavAccordionPages">
                                    <nav class="sb-sidenav-menu-nested nav">
                                        <a class="nav-link" href="401.html">401 Page</a>
                                        <a class="nav-link" href="404.html">404 Page</a>
                                        <a class="nav-link" href="500.html">500 Page</a>
                                    </nav>
                                </div>
                            </nav>
                        </div> -->
                                        <!-- <div class="sb-sidenav-menu-heading">Addons</div>
                        <a class="nav-link" href="charts.html">
                            <div class="sb-nav-link-icon"><i class="fas fa-chart-area"></i></div>
                            Charts
                        </a>
                        <a class="nav-link" href="tables.html">
                            <div class="sb-nav-link-icon"><i class="fas fa-table"></i></div>
                            Tables
                        </a> -->
                                    </div>
                                    <div class="nav">
                                        <div class="sb-sidenav-menu-heading">Different</div>
                                        <a class="nav-link" href="/cmtCus">
                                            <div class="sb-nav-link-icon"><i class="fa-solid fa-house-user"></i></i>
                                            </div>
                                            Customer's Cmt
                                        </a>
                                    </div>
                                </div>
                                <div class="sb-sidenav-footer">
                                    <div class="small">Logged in as:</div>
                                    Start Bootstrap
                                </div>
                            </nav>
                        </div>
                        <div id="layoutSidenav_content">
                            <main>
                                <div class="container-fluid px-4">
                                    <h1 class="mt-4">List Orders</h1>
                                    <ol class="breadcrumb mb-4">
                                        <li class="breadcrumb-item active">List Orders</li>
                                    </ol>
                                </div>

                                <table>
                                    <tr>
                                        <th>Id</th>
                                        <th>Total_Price</th>
                                        <th>Custom_Name</th>
                                        <th>Status</th>
                                        <th>Action</th>

                                    </tr>
                                    <c:forEach items="${oders}" var="oder">
                                        <tr>
                                            <td>${oder.id}</td>
                                            <td>
                                                <fmt:formatNumber type="number" value="${oder.totalPrice}" />
                                                Vnd
                                            </td>
                                            <td>${oder.receiverName}</td>
                                            <td>${oder.status}</td>

                                            <td>
                                                <button type="button" class="btn btn-primary"><a
                                                        href="/admin/order/detail/${oder.id}"
                                                        style="color: wheat; text-decoration: none;">View</a></button>
                                                <button type="button" class="btn btn-secondary"><a
                                                        href="/admin/order/update/${oder.id}"
                                                        style="color: wheat; text-decoration: none;">Edit</a></button>
                                                <button type="button" class="btn btn-success"><a
                                                        style="color: wheat; text-decoration: none;"
                                                        href="/admin/order/del/${oder.id}">Delete</a></button>
                                            </td>
                                        </tr>
                                    </c:forEach>

                                </table>
                                <nav aria-label="Page navigation example" style="margin-top: 17px;">
                                    <ul class="pagination justify-content-center">

                                        <c:if test="${currentPage < 2 }">
                                            <li class="page-item disabled"><a class="page-link" href="">Previous</a>
                                            </li>
                                        </c:if>
                                        <c:if test="${currentPage > 1 }">
                                            <li class="page-item"><a class="page-link"
                                                    href="/adminOrder?page=${currentPage-1}">Previous</a>
                                            </li>
                                        </c:if>

                                        <c:forEach begin="0" end="${totalPage}" varStatus="loop">
                                            <li
                                                class="${(loop.index+1) eq currentPage ? 'page-item active' : 'page-item'}">
                                                <a class="page-link"
                                                    href="/adminOrder?page=${loop.index+1}">${loop.index+1}</a>
                                            </li>
                                        </c:forEach>

                                        <c:if test="${currentPage > (totalPage-1) }">
                                            <li class="page-item disabled"><a class="page-link" href="">Next</a></li>
                                        </c:if>
                                        <c:if test="${currentPage < totalPage }">
                                            <li class="page-item"><a class="page-link"
                                                    href="/adminOrder?page=${currentPage+1}">Next</a></li>
                                        </c:if>

                                    </ul>
                                </nav>
                            </main>
                            <footer class="py-4 bg-light mt-auto">
                                <div class="container-fluid px-4">
                                    <div class="d-flex align-items-center justify-content-between small">
                                        <div class="text-muted">Copyright &copy; Your Website 2023</div>
                                        <div>
                                            <a href="#">Privacy Policy</a>
                                            &middot;
                                            <a href="#">Terms &amp; Conditions</a>
                                        </div>
                                    </div>
                                </div>
                            </footer>
                        </div>
                    </div>
                    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
                        crossorigin="anonymous"></script>
                    <script src="/js/scripts.js"></script>
                    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js"
                        crossorigin="anonymous"></script>
                    <script src="/js/chart-area-demo.js"></script>
                    <script src="/js/chart-bar-demo.js"></script>
                    <script src="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/umd/simple-datatables.min.js"
                        crossorigin="anonymous"></script>
                    <script src="/js/datatables-simple-demo.js"></script>
                </body>

                </html>