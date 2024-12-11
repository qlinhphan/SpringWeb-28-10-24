<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

        <!-- tag thu nhat dung de dung path, form
        tag thu hai dung de render du lieu ra bang -->
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Document</title>
            <link rel="stylesheet" href="/css/demos.css">
            <link href="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/style.min.css" rel="stylesheet" />
            <link href="/css/styles.css" rel="stylesheet" />
            <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
                integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
                crossorigin="anonymous">

        </head>
        </head>

        <body>
            <nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
                <!-- Navbar Brand-->
                <a class="navbar-brand ps-3" href="index.html">Laptop Shop</a>
                <!-- Sidebar Toggle-->
                <button class="btn btn-link btn-sm order-1 order-lg-0 me-4 me-lg-0" id="sidebarToggle" href="#!"><i
                        class="fas fa-bars"></i></button>
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
                                    <div class=" sb-nav-link-icon"><i class="fa-solid fa-users"></i>
                                    </div>
                                    User
                                </a>
                                <a class="nav-link" href="/adminProduct">
                                    <div class="sb-nav-link-icon"><i class="fa-brands fa-product-hunt"></i></div>
                                    Product
                                </a>
                                <a class="nav-link" href="/adminOrder">
                                    <div class="sb-nav-link-icon"><i class="fa-regular fa-newspaper"></i></div>
                                    Order
                                </a>
                                <!-- <div class="sb-s idenav-menu-heading">Interface</div>
                                <a class="nav-link collapsed" href="#" data-bs-toggle="collapse"
                                    data-bs-target="#collapseLayouts" aria-expanded="false"
                                    aria-controls="collapseLayouts">
                                    <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                                    Layouts
                                    <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                                </a> -->
                                <!-- <div class="collapse" id="collapseLayouts" aria-labelledby="headingOne"
                                    data-bs-parent="#sidenavAccordion">
                                    <nav class="sb-sidenav-menu-nested nav">
                                        <a class="nav-link" href="layout-static.html">Static Navigation</a>
                                        <a class="nav-link" href="layout-sidenav-light.html">Light Sidenav</a>
                                    </nav>
                                </div>
                                <a class="nav-link collapsed" href="#" data-bs-toggle="collapse"
                                    data-bs-target="#collapsePages" aria-expanded="false" aria-controls="collapsePages">
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
                                            <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i>
                                            </div>
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
                                            <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i>
                                            </div>
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
                                </div>
                                <div class="sb-sidenav-menu-heading">Addons</div>
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
                                    <div class="sb-nav-link-icon"><i class="fa-solid fa-house-user"></i></i></div>
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
                            <section class="vh-100">
                                <div class="container-fluid h-custom">
                                    <div class="row d-flex justify-content-center align-items-center h-100">
                                        <div class="col-md-9 col-lg-6 col-xl-5">
                                            <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/draw2.webp"
                                                class="img-fluid" alt="Sample image">
                                        </div>
                                        <div class="col-md-8 col-lg-6 col-xl-4 offset-xl-1">
                                            <form:form method="post" action="/create/user/finish"
                                                modelAttribute="newUser" enctype="multipart/form-data">

                                                <!-- Email input -->
                                                <div data-mdb-input-init class="form-outline mb-4">
                                                    <form:input type="email" id="form3Example3"
                                                        class="form-control form-control-lg"
                                                        placeholder="Enter a valid email address" path="email" />
                                                    <label class="form-label" for="form3Example3">Email</label>
                                                </div>

                                                <div style="display: flex;">
                                                    <!-- Password input -->
                                                    <div data-mdb-input-init class="form-outline mb-3">
                                                        <form:input type="password" id="form3Example4"
                                                            class="form-control form-control-lg"
                                                            placeholder="Enter password" path="password"
                                                            style="width: 93%;" />
                                                        <label class="form-label" for="form3Example4">Password</label>
                                                    </div>

                                                    <!-- fullname -->
                                                    <div data-mdb-input-init class="form-outline mb-3">
                                                        <form:input type="text" id="form3Example4"
                                                            class="form-control form-control-lg"
                                                            placeholder="Enter password" path="fullname"
                                                            style="width: 93%; margin-left: 7%;" />
                                                        <label class="form-label" for="form3Example4"
                                                            style="margin-left: 7%;">Full Name</label>
                                                    </div>
                                                </div>

                                                <div style="display: flex;">
                                                    <!-- address -->
                                                    <div data-mdb-input-init class="form-outline mb-3">
                                                        <form:input type="text" id="form3Example4"
                                                            class="form-control form-control-lg"
                                                            placeholder="Enter password" path="address"
                                                            style="width: 93%;" />
                                                        <label class="form-label" for="form3Example4">Address</label>
                                                    </div>

                                                    <!-- phone -->
                                                    <div data-mdb-input-init class="form-outline mb-3">
                                                        <form:input type="text" id="form3Example4"
                                                            class="form-control form-control-lg"
                                                            placeholder="Enter password" path="phone"
                                                            style="width: 93%; margin-left: 7%;" />
                                                        <label class="form-label" for="form3Example4"
                                                            style="margin-left: 7%;">Phone</label>
                                                    </div>
                                                </div>

                                                <form:select class="form-select" aria-label="Default select example"
                                                    path="roles.name">
                                                    <form:option value="Admin">Admin</form:option>
                                                    <form:option value="User">User</form:option>
                                                </form:select>

                                                <!-- <label class="form-label" for="customFile">Default file input
                                                    example</label> -->
                                                <div data-mdb-input-init class="form-outline mb-3"
                                                    style="margin-top: 17px;">
                                                    <input type="file" class="form-control" id="customFile"
                                                        name="fileName" />
                                                </div>

                                                <div class="text-center text-lg-start mt-4 pt-2">
                                                    <button type="submit" data-mdb-button-init data-mdb-ripple-init
                                                        class="btn btn-primary btn-lg"
                                                        style="padding-left: 2.5rem; padding-right: 2.5rem;">Create
                                                        User</button>
                                                </div>


                                            </form:form>
                                        </div>
                                    </div>
                                </div>
                            </section>
                        </div>
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
                integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
                crossorigin="anonymous"></script>

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