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
                <!-- <ul class="navbar-nav ms-auto ms-md-0 me-3 me-lg-4">
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button"
                            data-bs-toggle="dropdown" aria-expanded="false"><i class="fas fa-user fa-fw"></i></a>
                        <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
                            <li><a class="dropdown-item" href="#!">Settings</a></li>
                            <li><a class="dropdown-item" href="#!">Activity Log</a></li>
                            <li>
                                <hr class="dropdown-divider" />
                            </li>
                            <li><a class="dropdown-item" href="#!">Logout</a></li>
                        </ul>
                    </li>
                </ul> -->
            </nav>
            <div id="layoutSidenav">
                <div id="layoutSidenav_nav">
                    <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
                        <div class="sb-sidenav-menu">
                            <div class="nav">
                                <div class="sb-sidenav-menu-heading">Core</div>
                                z
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
                                            <img src="/images/product/rubbish.jpg" class="img-fluid" alt="Sample image"
                                                style="border-radius: 21px; box-shadow: 9px 9px 4px grey;">
                                        </div>
                                        <div class="col-md-8 col-lg-6 col-xl-4 offset-xl-1">
                                            <form:form action="/del/finish" method="post" modelAttribute="product">


                                                <!-- <div data-mdb-input-init class="form-outline mb-4"
                                                    style="display: none;">
                                                    <input type="text" id="form3Example3"
                                                        class="form-control form-control-lg"
                                                        placeholder="Enter a valid email address" />
                                                    <label class="form-label" for="form3Example3">Id</label>
                                                </div>
                                                <div data-mdb-input-init class="form-outline mb-4">
                                                    <input type="text" id="form3Example3"
                                                        class="form-control form-control-lg"
                                                        placeholder="Enter a valid email address" />
                                                    <label class="form-label" for="form3Example3">Name</label>
                                                </div>

                                                <div style="display: flex;">
                                                    
                                                    <div data-mdb-input-init class="form-outline mb-3">
                                                        <input type="text" id="form3Example4"
                                                            class="form-control form-control-lg"
                                                            placeholder="Enter password" style="width: 180px;" />
                                                        <label class="form-label" for="form3Example4">Price</label>
                                                    </div>

                                                    
                                                    <div data-mdb-input-init class="form-outline mb-3">
                                                        <input type="text" id="form3Example4"
                                                            class="form-control form-control-lg"
                                                            placeholder="Enter password"
                                                            style="width: 180px; margin-left: 31px;" />
                                                        <label class="form-label" for="form3Example4"
                                                            style="margin-left: 31px;">Detail Description</label>
                                                    </div>
                                                </div>

                                                <div style="display: flex;">
                                                    
                                                    <div data-mdb-input-init class="form-outline mb-3">
                                                        <input type="text" id="form3Example4"
                                                            class="form-control form-control-lg"
                                                            placeholder="Enter password" style="width: 180px;" />
                                                        <label class="form-label" for="form3Example4">Short
                                                            Description</label>
                                                    </div>

                                                    
                                                    <div data-mdb-input-init class="form-outline mb-3">
                                                        <input type="text" id="form3Example4"
                                                            class="form-control form-control-lg"
                                                            placeholder="Enter password"
                                                            style="width: 180px; margin-left: 31px;" />
                                                        <label class="form-label" for="form3Example4"
                                                            style="margin-left: 31px;">Quantity</label>
                                                    </div>
                                                </div>

                                                <select class="form-select" aria-label="Default select example">
                                                    <option value="Apple">Apple</option>
                                                    <option value="Dell">Dell</option>
                                                    <option value="Acer">Acer</option>
                                                    <option value="HP">HP</option>
                                                    <option value="Asus">Asus</option>
                                                    <option value="Microsoft">Microsoft</option>
                                                    <option value="Lenovo">Lenovo</option>
                                                    <option value="Msi">Msi</option>
                                                </select>
                                                <p>Factory: </p>

                                                <select class="form-select" aria-label="Default select example">
                                                    <option value="Study">Study</option>
                                                    <option value="Game">Game</option>
                                                    <option value="Graphics">Graphics</option>
                                                    <option value="Code">Code</option>
                                                    <option value="Normal">Normal</option>
                                                </select>
                                                <p>Target: ${product.target}</p>

                                                <div data-mdb-input-init class="form-outline mb-3"
                                                    style="margin-top: 17px; display: none;">
                                                    <input type="file" class="form-control" id="customFile" />
                                                    <p style="display: none;">Image: </p>
                                                </div>


                                                <div class="text-center text-lg-start mt-4 pt-2">
                                                    <button type="submit" data-mdb-button-init data-mdb-ripple-init
                                                        class="btn btn-primary btn-lg"
                                                        style="padding-left: 2.5rem; padding-right: 2.5rem;">Delete This
                                                        Product</button>
                                                </div> -->
                                                <div class="alert alert-success" role="alert">
                                                    <h4 class="alert-heading">Warning!</h4>
                                                    <p>Do you want to delete this product with Id: <span
                                                            style="color: red">${product.id}</span>
                                                    </p>
                                                    <form:input type="text" value="${product.id}" style="display: none;"
                                                        path="id" />
                                                    <p>And if you delete, you can't restore it. Are you sure?</p>
                                                    <hr>
                                                    <div style="display: flex; gap: 17px">
                                                        <button type="submit" class="btn btn-danger">Yes</button>
                                                    </div>
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