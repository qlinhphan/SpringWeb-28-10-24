<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!doctype html>
        <html lang="en">

        <head>

            <meta charset="utf-8">
            <meta name="viewport" content="width=device-width, initial-scale=1">

            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
                integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
                crossorigin="anonymous">

            <title>Hello, world!</title>
        </head>

        <body>
            <section class="vh-100" style="background-color: #eee;">
                <div class="container h-100">
                    <div class="row d-flex justify-content-center align-items-center h-100">
                        <div class="col-lg-12 col-xl-11">
                            <div class="card text-black" style="border-radius: 25px;">
                                <div class="card-body p-md-5">
                                    <div class="row justify-content-center">
                                        <div class="col-md-10 col-lg-6 col-xl-5 order-2 order-lg-1">


                                            <form:form class="mx-1 mx-md-4" action="/register" method="post"
                                                modelAttribute="regisNew">

                                                <div class="d-flex flex-row align-items-center mb-4">
                                                    <i class="fas fa-user fa-lg me-3 fa-fw"></i>
                                                    <div data-mdb-input-init class="form-outline flex-fill mb-0">
                                                        <form:input type="text" id="form3Example1c" class="form-control"
                                                            path="firstName" required="required" />
                                                        <label class="form-label" for="form3Example1c">First
                                                            Name</label>
                                                    </div>
                                                </div>

                                                <div class="d-flex flex-row align-items-center mb-4">
                                                    <i class="fas fa-envelope fa-lg me-3 fa-fw"></i>
                                                    <div data-mdb-input-init class="form-outline flex-fill mb-0">
                                                        <form:input type="text" id="form3Example3c" class="form-control"
                                                            path="lastName" required="required" />
                                                        <label class="form-label" for="form3Example3c">Last Name</label>
                                                    </div>
                                                </div>

                                                <div class="d-flex flex-row align-items-center mb-4">
                                                    <i class="fas fa-lock fa-lg me-3 fa-fw"></i>
                                                    <div data-mdb-input-init class="form-outline flex-fill mb-0">
                                                        <form:input type="email" id="form3Example4c"
                                                            class="form-control" path="email" required="required" />
                                                        <label class="form-label" for="form3Example4c">Email</label>
                                                        <span id="email" style="color: red;"></span>
                                                    </div>
                                                </div>



                                                <div style="display: flex; justify-content: space-between; align-items:
                                                    center;">
                                                    <div class="d-flex flex-row align-items-center mb-4">
                                                        <i class="fas fa-key fa-lg me-3 fa-fw"></i>
                                                        <div data-mdb-input-init class="form-outline flex-fill mb-0">
                                                            <form:input type="password" id="form3Example4cd"
                                                                class="form-control" path="password"
                                                                required="required" />
                                                            <label class="form-label" for="form3Example4cd">Password
                                                            </label>
                                                        </div>
                                                    </div>

                                                    <div class="d-flex flex-row align-items-center mb-4">
                                                        <i class="fas fa-key fa-lg me-3 fa-fw"></i>
                                                        <div data-mdb-input-init class="form-outline flex-fill mb-0">
                                                            <form:input type="password" id="form3Example4cd"
                                                                class="form-control" path="repeatPassword"
                                                                required="required" />
                                                            <label class="form-label" for="form3Example4cd">Repeat your
                                                                password</label>
                                                        </div>
                                                    </div>
                                                </div>

                                                <!-- <div class="form-check d-flex justify-content-center mb-5">
                                                    <p id="pass" style="color: red; font-size: 11px;">
                                                    </p>
                                                </div> -->




                                                <div class="d-flex justify-content-center mx-4 mb-3 mb-lg-4">
                                                    <button type="submit" data-mdb-button-init data-mdb-ripple-init
                                                        class="btn btn-primary btn-lg" id="butt">Create Account</button>
                                                </div>



                                                <!-- <p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">Create Account</p> -->
                                                <c:if test="${showMess}">
                                                    <script>
                                                        // document.getElementById('pass').innerHTML = "you can check and fix password and RepeatPass"
                                                        alert("you can check and fix password and RepeatPass")
                                                    </script>
                                                </c:if>

                                                <c:if test="${emailExist}">
                                                    <script>
                                                        alert("Email is exist in database")
                                                    </script>
                                                </c:if>



                                            </form:form>

                                        </div>
                                        <div
                                            class="col-md-10 col-lg-6 col-xl-7 d-flex align-items-center order-1 order-lg-2">

                                            <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-registration/draw1.webp"
                                                class="img-fluid" alt="Sample image">

                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>

            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
                crossorigin="anonymous"></script>


        </body>

        </html>