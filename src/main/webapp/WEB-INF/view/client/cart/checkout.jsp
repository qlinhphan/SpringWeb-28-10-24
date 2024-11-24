<%@ page contentType="text/html; charset=UTF-8" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
            <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
                <!DOCTYPE html>
                <html lang="en">

                <head>
                    <meta charset="UTF-8">
                    <title>Checkout</title>
                    <link rel="stylesheet" href="/">
                    <style>
                        * {
                            box-sizing: border-box;
                            margin: 0;
                            padding: 0;
                        }

                        html {
                            font-size: 62.5%;
                            /* 10/16 = 0.625 * 100 */
                        }

                        body {
                            background: url('https://images.pexels.com/photos/2876787/pexels-photo-2876787.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2');
                            background-position: center;
                            background-size: cover;
                            backdrop-filter: blur(8px);
                            color: #3c3c39;

                            display: flex;
                            justify-content: center;
                            height: 100vh;
                            font-family: 'Monsterrat', sans-serif;
                            position: relative;
                            padding: 2rem 0;
                        }

                        .checkout-container {
                            /* background-color: red; */
                            max-width: 120rem;
                            height: 50rem;
                            display: grid;
                            grid-template-columns: 1fr 1fr;
                            justify-content: center;
                            /* margin-bottom: 10rem; */
                        }

                        em {
                            font-style: normal;
                            font-weight: 700;
                        }

                        hr {
                            color: #fff;
                            margin-bottom: 1.2rem;
                        }

                        /* Left Side Of Container */
                        .left-side {
                            background: url('/images/product/1000s.jpg');
                            background-position: center;
                            background-size: cover;
                            position: relative;
                        }

                        .text-box {
                            background: rgba(95, 121, 134, 0.8);
                            width: 100%;
                            padding: 1rem 2rem;
                            position: absolute;
                            bottom: 0;
                        }

                        /* Left container text */

                        .home-heading {
                            color: #e8e8e1;
                            font-size: 3.2rem;
                            font-weight: 700;
                            line-height: 1;
                            margin-bottom: 1rem;
                        }

                        .home-price {
                            color: #aeae97;
                            font-size: 2rem;
                            margin-bottom: 1.2rem;
                        }

                        .home-desc {
                            color: #e8e8e1;
                            font-size: 1.2rem;
                            line-height: 1.5;
                            letter-spacing: 0.5px;
                        }

                        /* Right Side of container */

                        .right-side {
                            background-color: #fff;
                            padding: 1.8rem 3.2rem;
                        }

                        .receipt {
                            display: flex;
                            flex-direction: column;
                            gap: 1rem;
                            border-bottom: solid 1px;
                            margin-bottom: 1rem;
                        }

                        .receipt-heading {
                            font-size: 1.6rem;
                            text-align: left;
                        }

                        .table {
                            border-collapse: separate;
                            border-spacing: 0 1.5rem;
                            color: #64645f;
                            font-size: 1.2rem;
                            margin-bottom: 0.5rem;
                            width: 100%;
                        }

                        .total td {
                            font-size: 1.4rem;
                            font-weight: 700;
                        }

                        .price {
                            text-align: end;
                        }

                        /* Payment Section */

                        .payment-heading {
                            font-size: 1.4rem;
                            margin-bottom: 1rem;
                        }

                        .form-box {
                            display: grid;
                            grid-template-rows: 1fr;
                            gap: 1.5rem;
                        }

                        .card-logo {
                            font-size: 2rem;
                        }

                        .expires,
                        .form-box label {
                            font-size: 1.2rem;
                            font-weight: 700;
                        }

                        .form-box input {
                            font-family: inherit;
                            font-size: 1.2rem;
                            padding: 0.5rem;
                            width: 100%;
                        }

                        .form-box select {
                            padding: 0.5rem;
                        }

                        .form-box #cvv {
                            width: 25%;
                        }

                        .cvv-info:link,
                        .cvv-info:visited {
                            color: inherit;
                            text-decoration: underline;
                        }

                        .cvv-info:hover,
                        .cvv-info:active {
                            color: #5f7986;
                            text-decoration: none;
                        }

                        .btn {
                            background-color: #4c616b;
                            border: none;
                            border-radius: 8px;
                            color: #eff2f3;
                            font-size: 1.6rem;
                            font-weight: 700;
                            letter-spacing: 0.5px;
                            margin-bottom: 1rem;
                            padding: 1.5rem;
                            cursor: pointer;
                        }

                        .btn:hover {
                            background-color: #5f7986;
                            transition: ease-out 0.1s;
                        }

                        .footer-text {
                            font-size: 1rem;
                            text-align: center;
                        }

                        .form-box *:focus {
                            outline: none;
                            box-shadow: 0 0 0 0.8rem rgba(139, 139, 107, 0.5);
                            border-radius: 8px;
                        }
                    </style>

                </head>

                <body>
                    <!-- partial:index.partial.html -->
                    <!-- Font Awesome -->
                    <script src="https://kit.fontawesome.com/bb515311f9.js" crossorigin="anonymous"></script>

                    <title>Day 002 - Credit Card Checkout</title>

                    <body style="display: flex; align-items: center;">
                        <div class="checkout-container">
                            <div class="left-side">
                                <div class="text-box">
                                    <h1 class="home-heading">Laptop Store</h1>
                                    <p class="home-price"><em>Chỉ từ 8.500.000 </em>/ 1 máy</p>
                                    <hr class="left-hr" />
                                    <p class="home-desc"><em>Chúng tôi </em>hy vọng <em>bạn sẽ tìm thấy thứ mình thích
                                            tại đây</em></p>

                                </div>
                            </div>

                            <div class="right-side" style="width: 425px;">
                                <div class="receipt">
                                    <h2 class="receipt-heading">Xác Nhận Đặt Hàng</h2>
                                    <div>
                                        <table class="table">
                                            <tr>
                                                <td>Tạm Tính</td>
                                                <!-- <td class="price">${totals}</td> -->
                                                <td class="price">
                                                    <fmt:formatNumber type="number" value="${sums}" />
                                                    Vnd
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>Chiết Khấu</td>
                                                <td class="price">0 Vnd</td>
                                            </tr>
                                            <tr>
                                                <td>Giảm Giá</td>
                                                <td class="price">0 Vnd</td>
                                            </tr>
                                            <tr>
                                                <td>Hình Thức Thanh Toán</td>
                                                <td class="price">Thanh Toán Khi Nhận Hàng</td>
                                            </tr>
                                            <tr class="total">
                                                <td>Thành Tiền</td>

                                                <td class="price">
                                                    <fmt:formatNumber type="number" value="${sums}" />
                                                    Vnd
                                                </td>

                                            </tr>
                                        </table>
                                    </div>
                                </div>

                                <div class="payment-info">
                                    <h3 class="payment-heading">Thông Tin Nhận Hàng</h3>
                                    <form:form action="/create/order" method="post" modelAttribute="UserInfRec">
                                        <div>
                                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                                        </div>
                                        <!-- <div>
                                            <label for="full-name">Họ Tên</label>
                                            <form:input id="full-name" path="receiverName" />
                                        </div> -->
                                        <div class="form-group row">
                                            <label for="inputPassword" class="col-sm-2 col-form-label">Họ Tên</label>
                                            <div class="col-sm-10">
                                                <form:input type="text" class="form-control"
                                                    style="width: 68%; border: none; box-shadow: 1px 1px 2.5px grey;"
                                                    path="receiverName" />
                                            </div>
                                        </div>
                                        <div class="form-group row" style="margin-top: 17px;">
                                            <label for="inputPassword" class="col-sm-2 col-form-label">Địa Chỉ</label>
                                            <div class="col-sm-10">
                                                <form:input type="text" class="form-control"
                                                    style="width: 68%; border: none; box-shadow: 1px 1px 2.5px grey;"
                                                    path="receiverAddress" />
                                            </div>
                                        </div>
                                        <div class="form-group row" style="margin-top: 17px;">
                                            <label for="inputPassword" class="col-sm-2 col-form-label">Số Điện
                                                Thoại</label>
                                            <div class="col-sm-10">
                                                <form:input type="text" class="form-control"
                                                    style="width: 68%; border: none; box-shadow: 1px 1px 2.5px grey;"
                                                    path="receiverPhone" />
                                            </div>
                                        </div>

                                        <button class="btn" type="submit" style="margin-top: 15px;">
                                            <i class="fa-solid fa-lock"></i> Đặt Hàng
                                        </button>
                                    </form:form>

                                    <p class="footer-text">
                                        <i class="fa-solid fa-lock"></i>
                                        Your credit card infomration is encrypted
                                    </p>
                                </div>
                            </div>
                        </div>
                    </body>
                    <!-- partial -->

                </body>

                </html>