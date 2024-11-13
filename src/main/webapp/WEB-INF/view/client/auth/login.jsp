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

            <link rel=”stylesheet” href=”https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css” />

            <link rel=”stylesheet” href=”https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css”
                integrity=”sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T”
                crossorigin=”anonymous”>

            <title>Hello, world!</title>

            <style>
                /**
Created by Sobola Timilehin David
*/
                @import url(https://use.fontawesome.com/releases/v5.0.11/css/all.css);

                html,
                body {
                    margin: 0 !important;
                    padding: 0 !important;
                    font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;
                    font-size: 85%;
                    width: 100%;
                    height: 100%;
                    background: #eaeaea;
                }

                * {
                    box-sizing: border-box;
                }

                *:focus {
                    outline-width: 0;
                }

                a {
                    text-decoration: none;
                    color: #000;
                }

                :root {
                    --primary: peru;
                    --dark: #c0c0;
                    --light: #fff;
                    --grad1: rgba(205, 134, 63, 0.767);
                    --grad2: rgba(205, 134, 63, 0.3);
                }

                .login-wrapper {
                    position: absolute;
                    top: 25%;
                    bottom: 25%;
                    display: block;
                    margin: 0 auto;
                    width: 100%;
                    height: 100%;
                    padding: 0;
                }

                .login-card {
                    display: block;
                    margin: 0 auto;
                    text-align: center;
                    padding: 0;
                    perspective: 1000px;
                    padding: 0;
                }

                .login-card,
                .login-inner {
                    width: 350px;
                }

                .inner {
                    transition: 0.8s;
                    transform-style: preserve-3d;
                    position: relative;
                }

                .inner:hover {
                    transform: rotateY(180deg);
                }

                .login-inner {
                    background: #fff;
                    padding: 10px;
                    margin: 0;
                    border: 1px solid rgba(0, 0, 0, 0.07);
                    box-shadow: 0 0 15px rgba(0, 0, 0, 0.2);
                    backface-visibility: hidden;
                }

                .login-header {
                    position: relative;
                    width: 100%;
                    height: 150px;
                    margin: 0;
                    align-items: center;
                    color: var(--primary);
                    padding: 10px;
                    text-align: left;
                    margin-bottom: 5px;
                }

                .login-header h2 {
                    font-size: 20px;
                    padding-bottom: 0;
                    margin: 0;
                }

                .login-header h3 {
                    color: #000;
                    font-size: 26px;
                    margin-bottom: 0;
                }

                .login-header p {
                    color: #5a5a5a;
                    font-size: 14px;
                    margin: 0;
                    padding: 0;
                }

                .login-card-title {
                    text-align: left;
                    position: relative;
                    color: var(--primary);
                    padding: 5px 10px 0 0;
                    font-size: 26px;
                }

                .login-group {
                    display: block;
                    margin: auto;
                    padding: 10px;
                    margin: 0;
                }

                .login-group .login-control {
                    width: 300px;
                    padding: 10px;
                    border: 0;
                    border-bottom: 1px solid var(--primary);
                    transition: all 0.6s ease-in-out;
                }

                input:focus {
                    border: 0;
                    border-bottom: 2px solid var(--primary);
                    padding: 3px 0px 3px 3px;
                    margin: 5px 1px 3px 0px;
                }

                .login-btn-group {
                    display: flex;
                    justify-content: space-between;
                    align-items: center;
                }

                .login-btn-group p a {
                    padding: 10px;
                }

                .login-group button {
                    position: relative;
                    padding: 10px;
                    cursor: pointer;
                    background: var(--primary);
                    border-radius: .3rem;
                    box-shadow: 0 0 5px var(--grad1);
                    border: 1px solid var(--grad2);
                    color: #fff;
                    transition: all 500ms ease-in-out;
                }

                .login-group button:hover,
                .login-group button:focus {
                    cursor: pointer;
                    background: var(--primary);
                    border-radius: .3rem;
                    box-shadow: 0 0 5px var(--grad1);
                    border: 1px solid var(--grad2);
                    color: #fff;
                }

                .login-bottom {
                    display: inline-flex;
                    flex-direction: row;
                    justify-content: space-between;
                    width: 100%;
                    padding: 10px;
                }

                #login-select {
                    border: none;
                    background: transparent;
                }

                .login-footer span a {
                    color: var(--primary);
                }

                .login-nav {
                    list-style: none;
                    display: flex;
                    justify-content: center;
                    align-items: center;
                }
            </style>

            <style>
                * {
                    margin: 0;
                    padding: 0;
                }

                .divider:after,
                .divider:before {
                    content: "";
                    flex: 1;
                    height: 1px;
                    background: #eee;
                }
            </style>
            <style>
                html,
                body {
                    height: 100%;
                    margin: 0;
                    padding: 0;
                    overflow: hidden;
                    /* Ngăn chặn thanh cuộn */
                }

                .container {
                    display: flex;
                    justify-content: center;
                    /* Căn giữa theo chiều ngang */
                    align-items: center;
                    /* Căn giữa theo chiều dọc */
                    height: 100%;
                    /* Đảm bảo container chiếm hết chiều cao của màn hình */
                }

                body {
                    padding: 100px 0;
                    background-color: #efefef
                }

                a,
                a:hover {
                    color: #333
                }
            </style>
        </head>

        <body>
            <!-- <div style="display: flex; justify-content: center; align-items: center;">
                <section class="vh-100">
                    <div class="container py-5 h-100" style="height: 100vh;">
                        <div class="row d-flex align-items-center justify-content-center h-100">
                            <div class="col-md-8 col-lg-7 col-xl-6">
                                <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/draw2.svg"
                                    class="img-fluid" alt="Phone image">
                            </div>
                            <div class="col-md-7 col-lg-5 col-xl-5 offset-xl-1">
                                <form action="/login" method="post">


                                    <div>
                                        <c:if test="${param.error != null}">
                                            <div class="my-2" style="color: red;">Incorrect email or password.</div>
                                        </c:if>

                                    </div>
                                    <div data-mdb-input-init class="form-outline mb-4">
                                        <input type="email" id="form1Example13" class="form-control form-control-lg"
                                            name="username" />
                                        <label class="form-label" for="form1Example13">Email address</label>
                                    </div>


                                    <div data-mdb-input-init class="form-outline mb-4">
                                        <input type="password" id="form1Example23" class="form-control form-control-lg"
                                            name="password" />
                                        <label class="form-label" for="form1Example23">Password</label>

                                    </div>



                                    <button type="submit" data-mdb-button-init data-mdb-ripple-init
                                        class="btn btn-primary btn-lg btn-block">Sign in</button>

                                    <div class="divider d-flex align-items-center my-4">
                                        <p class="text-center fw-bold mx-3 mb-0 text-muted"><a href="/register">Do you
                                                need
                                                an
                                                account?</a></p>
                                    </div>


                                </form>
                            </div>
                        </div>
                    </div>
                </section>
            </div> -->



            <form action="/login" method="post">
                <div class="login-wrapper">
                    <!--Front-->
                    <div class="login-card">
                        <div class="login-inner">
                            <div class="login-header">
                                <h2>Welcome to you</h2>
                                <h3>Sign In</h3>
                                <p>to get complete access</p>
                                <div class="login-card-title">
                                    <i class="fas fa-ellipsis-h"></i>
                                </div>
                            </div>
                            <!-- <h2 class="login-card-title">Login</h2> -->
                            <div>
                                <c:if test="${param.error != null}">
                                    <div class="my-2" style="color: red;">Incorrect email or password.</div>
                                </c:if>

                            </div>
                            <div>
                                <c:if test="${param.logout != null}">
                                    <div class="my-2" style="color: green;">Logout success.</div>
                                </c:if>

                            </div>
                            <div class="login-group">
                                <input type="text" class="login-control" placeholder="Email" name="username">
                            </div>
                            <div class="login-group">
                                <input type="text" class="login-control" placeholder="Password" name="password">
                            </div>

                            <div>
                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                            </div>

                            <div class="login-btn-group">
                                <p>
                                    <!-- <a href="">Forgotten password?</a> -->

                                    <input type="checkbox" name="remember-me" style="margin-left: 15px;" /> Remember me

                                </p>
                                <div class="login-group">
                                    <button type="submit" class="_btn">
                                        <i class="fas fa-sign-in-alt"></i> Login</button>
                                </div>
                            </div>
                            <div class="login-footer">
                                <p>Don't have account?
                                    <span>
                                        <a href="/register">click here..</a>
                                    </span>
                                </p>

                            </div>
                        </div>

                        <div class="login-bottom">
                            <select name="" id="login-select">
                                <option value="">English</option>
                            </select>
                            <ul class="login-nav">
                                <li><a href="#">Privacy Policy</a></li>
                            </ul>
                        </div>

                    </div>


                </div>
            </form>

            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
                crossorigin="anonymous"></script>


        </body>

        </html>