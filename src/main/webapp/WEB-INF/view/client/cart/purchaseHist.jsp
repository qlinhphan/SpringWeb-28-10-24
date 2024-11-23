<%@ page contentType="text/html; charset=UTF-8" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
            <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
                <!DOCTYPE html>
                <html lang="en">

                <head>
                    <meta charset="utf-8">
                    <title>Fruitables - Vegetable Website Template</title>
                    <meta content="width=device-width, initial-scale=1.0" name="viewport">
                    <meta content="" name="keywords">
                    <meta content="" name="description">

                    <!-- Google Web Fonts -->
                    <link rel="preconnect" href="https://fonts.googleapis.com">
                    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
                    <link
                        href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@400;600&family=Raleway:wght@600;800&display=swap"
                        rel="stylesheet">

                    <!-- Icon Font Stylesheet -->
                    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css" />
                    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css"
                        rel="stylesheet">

                    <!-- Libraries Stylesheet -->
                    <link href="/css/client/lightbox.min.css" rel="stylesheet">
                    <link href="/css/client/owl.carousel.min.css" rel="stylesheet">


                    <!-- Customized Bootstrap Stylesheet -->
                    <link href="/css/client/bootstrap.min.css" rel="stylesheet">

                    <!-- Template Stylesheet -->
                    <link href="css/client/style.css" rel="stylesheet">

                    <!-- <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
                        rel="stylesheet"
                        integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
                        crossorigin="anonymous"> -->


                    <style>
                        .dropbtn {
                            background-color: #4CAF50;
                            color: white;
                            padding: 16px;
                            font-size: 16px;
                            border: none;
                            cursor: pointer;
                        }

                        .dropdown {
                            position: relative;
                            display: inline-block;
                        }

                        .dropdown-content {
                            display: none;
                            position: absolute;
                            background-color: #f9f9f9;
                            min-width: 160px;
                            box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
                            z-index: 1;
                        }

                        .dropdown-content a {
                            color: black;
                            padding: 12px 16px;
                            text-decoration: none;
                            display: block;
                        }

                        .dropdown-content a:hover {
                            background-color: #f1f1f1
                        }

                        .dropdown:hover .dropdown-content {
                            display: block;
                        }

                        .dropdown:hover .dropbtn {
                            background-color: #3e8e41;
                        }
                    </style>

                    <script>
                        let kq = document.getElementById("tongtien")
                        kq.innerHTML = "thisss"
                    </script>
                </head>

                <body>

                    <!-- Spinner Start -->
                    <div id="spinner"
                        class="show w-100 vh-100 bg-white position-fixed translate-middle top-50 start-50  d-flex align-items-center justify-content-center">
                        <div class="spinner-grow text-primary" role="status"></div>
                    </div>
                    <!-- Spinner End -->


                    <!-- Navbar start -->
                    <div class="container-fluid fixed-top">
                        <div class="container topbar bg-primary d-none d-lg-block">
                            <div class="d-flex justify-content-between">
                                <div class="top-info ps-2">
                                    <small class="me-3"><i class="fas fa-map-marker-alt me-2 text-secondary"></i> <a
                                            href="https://www.google.com/maps/place/Ti%E1%BB%81n+H%E1%BA%A3i,+Ti%E1%BB%81n+H%E1%BA%A3i+District,+Thai+Binh/@20.4044091,106.5001131,15z/data=!3m1!4b1!4m6!3m5!1s0x3135f8c5b3919d0b:0x9ea9c50b834948b1!8m2!3d20.402609!4d106.5009617!16s%2Fg%2F122xl0yc?entry=ttu&g_ep=EgoyMDI0MTAyNy4wIKXMDSoASAFQAw%3D%3D"
                                            class="text-white">Tiền Hải, Thái Bình</a></small>
                                    <small class="me-3"><i class="fas fa-envelope me-2 text-secondary"></i><a href="#"
                                            class="text-white">pxql@gmail.com</a></small>
                                </div>
                            </div>
                        </div>
                        <div class="container px-0">
                            <nav class="navbar navbar-light bg-white navbar-expand-xl">
                                <a href="/" class="navbar-brand">
                                    <h1 class="text-primary display-6">Laptop Shop</h1>
                                </a>
                                <button class="navbar-toggler py-2 px-3" type="button" data-bs-toggle="collapse"
                                    data-bs-target="#navbarCollapse">
                                    <span class="fa fa-bars text-primary"></span>
                                </button>
                                <div class="collapse navbar-collapse bg-white" id="navbarCollapse">
                                    <div class="navbar-nav mx-auto">
                                        <a href="index.html" class="nav-item nav-link active">Trang Chủ</a>
                                        <a href="shop.html" class="nav-item nav-link">Của Hàng</a>
                                    </div>
                                    <div class="d-flex m-3 me-0">
                                        <c:if test="${not empty pageContext.request.userPrincipal}">


                                            <a href="#" class="position-relative me-4 my-auto">
                                                <i class="fa fa-shopping-bag fa-2x"></i>
                                                <span
                                                    class="position-absolute bg-secondary rounded-circle d-flex align-items-center justify-content-center text-dark px-1"
                                                    style="top: -5px; left: 15px; height: 20px; min-width: 20px;">${SumCarts}</span>
                                            </a>
                                            <div class="dropdown" style="color: wheat;">

                                                <a href="#" class="my-auto dropbtn"
                                                    style="display: flex; border-radius: 17px;">
                                                    <i class="fas fa-user fa-2x"></i>
                                                </a>
                                                <div class="dropdown-content">
                                                    <div>
                                                        <div style="margin-left: 16px;"><img
                                                                src="/images/avatar/1730739674234-but-xoa-Artline-600x600.jpg"
                                                                alt=""
                                                                style="width: 50xp; height: 50px; border-radius: 50%;">
                                                        </div>
                                                        <div>
                                                            <span
                                                                style="margin-left: 16px; font-size: 12px; box-shadow: 1px 1px 12px black; color: grey;">${pageContext.request.userPrincipal.name}</span>
                                                        </div>
                                                    </div>
                                                    <a href="#" style="font-size: 12px;">Quản Lý Tài Khoản</a>
                                                    <a href="#" style="font-size: 12px;">Lịch Sử Mua Hàng</a>
                                                    <hr>
                                                    <form action="/logout" method="post">
                                                        <div>
                                                            <input type="hidden" name="${_csrf.parameterName}"
                                                                value="${_csrf.token}" />
                                                        </div>
                                                        <button
                                                            style="font-size: 12px; margin-left: 15px; margin-bottom: 14px; box-shadow: 2px 2px 4px grey;"
                                                            type="submit">Đăng
                                                            Xuất</button>
                                                    </form>

                                                </div>
                                            </div>

                                        </c:if>

                                        <c:if test="${empty pageContext.request.userPrincipal}">
                                            <a href="#" class="position-relative me-4 my-auto">
                                                <!-- <i class="fa fa-shopping-bag fa-2x"></i> -->
                                                <a href="/login"
                                                    style="color: black; text-decoration: none; box-shadow: 3px 3px 3px red; background-color: wheat;">Đăng
                                                    nhập</a>
                                                <!-- <span
                                                    class="position-absolute bg-secondary rounded-circle d-flex align-items-center justify-content-center text-dark px-1"
                                                    style="top: -5px; left: 15px; height: 20px; min-width: 20px;">3</span> -->
                                            </a>
                                        </c:if>
                                    </div>
                                </div>
                            </nav>
                        </div>
                    </div>
                    <!-- Navbar End -->


                    <!-- Modal Search Start -->
                    <div class="modal fade" id="searchModal" tabindex="-1" aria-labelledby="exampleModalLabel"
                        aria-hidden="true">
                        <div class="modal-dialog modal-fullscreen">
                            <div class="modal-content rounded-0">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLabel">Search by keyword</h5>
                                    <button type="button" class="btn-close" data-bs-dismiss="modal"
                                        aria-label="Close"></button>
                                </div>
                                <div class="modal-body d-flex align-items-center">
                                    <div class="input-group w-75 mx-auto d-flex">
                                        <input type="search" class="form-control p-3" placeholder="keywords"
                                            aria-describedby="search-icon-1">
                                        <span id="search-icon-1" class="input-group-text p-3"><i
                                                class="fa fa-search"></i></span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- Modal Search End -->


                    <!-- Single Page Header start -->
                    <div class="container-fluid page-header py-5">
                        <h1 class="text-center text-white display-6">Hàng Bạn Đã Mua</h1>

                    </div>
                    <!-- Single Page Header End -->


                    <!-- Cart Page Start -->
                    <div class="container-fluid py-5">
                        <div class="container py-5">
                            <div class="table-responsive">
                                <table class="table">
                                    <thead>
                                        <tr>
                                            <!-- <th scope="col">Id</th> -->
                                            <th scope="col">Sản Phẩm</th>
                                            <th scope="col">Tên Sản Phẩm</th>
                                            <th scope="col">Giá</th>
                                            <th scope="col">Số Lượng</th>
                                            <th scope="col">Tổng tiền</th>

                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="orderDetail" items="${orderDetails}">
                                            <tr>

                                                <td style="display: none;">
                                                    <p class="mb-0 mt-4">
                                                        <input type="text" value="${orderDetail.id}" />
                                                    </p>
                                                </td>
                                                <th scope="row">
                                                    <div class="d-flex align-items-center">
                                                        <img src="/images/product/${orderDetail.products.image}"
                                                            class="img-fluid me-5 rounded-circle"
                                                            style="width: 80px; height: 80px;" alt="">
                                                    </div>
                                                </th>

                                                <td>
                                                    <p class="mb-0 mt-4">${orderDetail.products.name}</p>
                                                </td>
                                                <td>
                                                    <p class="mb-0 mt-4">

                                                        <fmt:formatNumber type="number"
                                                            value="${orderDetail.products.price}" />Vnd
                                                    </p>
                                                </td>
                                                <td>
                                                    <div class="input-group quantity mt-4" style="width: 100px;">
                                                        <!-- <div class="input-group-btn">
                                                                <button
                                                                    class="btn btn-sm btn-minus rounded-circle bg-light border">
                                                                    <i class="fa fa-minus"></i>
                                                                </button>
                                                            </div> -->
                                                        <input type="text"
                                                            class="form-control form-control-sm text-center border-0"
                                                            value="${orderDetail.quantity}" />
                                                        <!-- <div class="input-group-btn">
                                                                <button
                                                                    class="btn btn-sm btn-plus rounded-circle bg-light border">
                                                                    <i class="fa fa-plus"></i>
                                                                </button>
                                                            </div> -->
                                                    </div>
                                                </td>
                                                <td>
                                                    <p class="mb-0 mt-4" id="tongtien">

                                                        <fmt:formatNumber type="number"
                                                            value="${orderDetail.price*orderDetail.quantity}" />
                                                        Vnd
                                                    </p>
                                                </td>


                                            </tr>
                                        </c:forEach>

                                    </tbody>
                                </table>
                            </div>
                            <!-- <div class="mt-5">
                                <input type="text" class="border-0 border-bottom rounded me-5 py-3 mb-4"
                                    placeholder="Coupon Code">
                                <button class="btn border-secondary rounded-pill px-4 py-3 text-primary"
                                    type="button">Apply
                                    Coupon</button>
                            </div> -->

                        </div>
                    </div>
                    <!-- Cart Page End -->


                    <!-- Footer Start -->
                    <div class="container-fluid bg-dark text-white-50 footer pt-5 mt-5">
                        <div class="container py-5">
                            <div class="pb-4 mb-4" style="border-bottom: 1px solid rgba(226, 175, 24, 0.5) ;">
                                <div class="row g-4">
                                    <div class="col-lg-3">
                                        <a href="#">
                                            <h1 class="text-primary mb-0">Fruitables</h1>
                                            <p class="text-secondary mb-0">Fresh products</p>
                                        </a>
                                    </div>
                                    <div class="col-lg-6">
                                        <div class="position-relative mx-auto">
                                            <input class="form-control border-0 w-100 py-3 px-4 rounded-pill"
                                                type="number" placeholder="Your Email">
                                            <button type="submit"
                                                class="btn btn-primary border-0 border-secondary py-3 px-4 position-absolute rounded-pill text-white"
                                                style="top: 0; right: 0;">Subscribe Now</button>
                                        </div>
                                    </div>
                                    <div class="col-lg-3">
                                        <div class="d-flex justify-content-end pt-3">
                                            <a class="btn  btn-outline-secondary me-2 btn-md-square rounded-circle"
                                                href=""><i class="fab fa-twitter"></i></a>
                                            <a class="btn btn-outline-secondary me-2 btn-md-square rounded-circle"
                                                href=""><i class="fab fa-facebook-f"></i></a>
                                            <a class="btn btn-outline-secondary me-2 btn-md-square rounded-circle"
                                                href=""><i class="fab fa-youtube"></i></a>
                                            <a class="btn btn-outline-secondary btn-md-square rounded-circle" href=""><i
                                                    class="fab fa-linkedin-in"></i></a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row g-5">
                                <div class="col-lg-3 col-md-6">
                                    <div class="footer-item">
                                        <h4 class="text-light mb-3">Why People Like us!</h4>
                                        <p class="mb-4">typesetting, remaining essentially unchanged. It was
                                            popularised in the 1960s with the like Aldus PageMaker including of Lorem
                                            Ipsum.</p>
                                        <a href="" class="btn border-secondary py-2 px-4 rounded-pill text-primary">Read
                                            More</a>
                                    </div>
                                </div>
                                <div class="col-lg-3 col-md-6">
                                    <div class="d-flex flex-column text-start footer-item">
                                        <h4 class="text-light mb-3">Shop Info</h4>
                                        <a class="btn-link" href="">About Us</a>
                                        <a class="btn-link" href="">Contact Us</a>
                                        <a class="btn-link" href="">Privacy Policy</a>
                                        <a class="btn-link" href="">Terms & Condition</a>
                                        <a class="btn-link" href="">Return Policy</a>
                                        <a class="btn-link" href="">FAQs & Help</a>
                                    </div>
                                </div>
                                <div class="col-lg-3 col-md-6">
                                    <div class="d-flex flex-column text-start footer-item">
                                        <h4 class="text-light mb-3">Account</h4>
                                        <a class="btn-link" href="">My Account</a>
                                        <a class="btn-link" href="">Shop details</a>
                                        <a class="btn-link" href="">Shopping Cart</a>
                                        <a class="btn-link" href="">Wishlist</a>
                                        <a class="btn-link" href="">Order History</a>
                                        <a class="btn-link" href="">International Orders</a>
                                    </div>
                                </div>
                                <div class="col-lg-3 col-md-6">
                                    <div class="footer-item">
                                        <h4 class="text-light mb-3">Contact</h4>
                                        <p>Address: 1429 Netus Rd, NY 48247</p>
                                        <p>Email: Example@gmail.com</p>
                                        <p>Phone: +0123 4567 8910</p>
                                        <p>Payment Accepted</p>
                                        <img src="img/payment.png" class="img-fluid" alt="">
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- Footer End -->

                    <!-- Copyright Start -->
                    <div class="container-fluid copyright bg-dark py-4">
                        <div class="container">
                            <div class="row">
                                <div class="col-md-6 text-center text-md-start mb-3 mb-md-0">
                                    <span class="text-light"><a href="#"><i
                                                class="fas fa-copyright text-light me-2"></i>Your Site
                                            Name</a>, All right reserved.</span>
                                </div>
                                <div class="col-md-6 my-auto text-center text-md-end text-white">
                                    <!--/*** This template is free as long as you keep the below author’s credit link/attribution link/backlink. ***/-->
                                    <!--/*** If you'd like to use the template without the below author’s credit link/attribution link/backlink, ***/-->
                                    <!--/*** you can purchase the Credit Removal License from "https://htmlcodex.com/credit-removal". ***/-->
                                    Designed By <a class="border-bottom" href="https://htmlcodex.com">HTML Codex</a>
                                    Distributed By <a class="border-bottom" href="https://themewagon.com">ThemeWagon</a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- Copyright End -->



                    <!-- Back to Top -->
                    <a href="#" class="btn btn-primary border-3 border-primary rounded-circle back-to-top"><i
                            class="fa fa-arrow-up"></i></a>


                    <!-- JavaScript Libraries -->
                    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
                    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
                    <script src="/js/client/easing.min.js"></script>
                    <script src="/js/client/waypoints.min.js"></script>
                    <script src="/js/client/lightbox.min.js"></script>
                    <script src="/js/client/owl.carousel.min.js"></script>
                    <!-- <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
                        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
                        crossorigin="anonymous"></script> -->


                    <!-- Template Javascript -->
                    <script src="/js/client/main.js"></script>
                </body>

                </html>