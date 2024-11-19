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
                                    <h1 class="home-heading">Modern Home</h1>
                                    <p class="home-price"><em>249.50 USD </em>/ 1 night</p>
                                    <hr class="left-hr" />
                                    <p class="home-desc"><em>Entire home </em>for <em>2 guest</em></p>
                                    <p class="home-desc">
                                        <em>Tue, July 23, 2022 </em>to <em>Thu, July 25, 2022</em>
                                    </p>
                                </div>
                            </div>

                            <div class="right-side" style="width: 425px;">
                                <div class="receipt">
                                    <h2 class="receipt-heading">Xác Nhận Đặt Hàng</h2>
                                    <div>
                                        <table class="table">
                                            <tr>
                                                <td>Tạm Tính</td>
                                                <td class="price">499.00 USD</td>
                                            </tr>
                                            <tr>
                                                <td>Chiết Khấu</td>
                                                <td class="price">0.00 USD</td>
                                            </tr>
                                            <tr>
                                                <td>Giảm Giá</td>
                                                <td class="price">499.00 USD</td>
                                            </tr>
                                            <tr>
                                                <td>Hình Thức Thanh Toán</td>
                                                <td class="price">Thanh Toán Khi Nhận Hàng</td>
                                            </tr>
                                            <tr class="total">
                                                <td>Thành Tiền</td>
                                                <td class="price">546.41 USD</td>
                                            </tr>
                                        </table>
                                    </div>
                                </div>

                                <div class="payment-info">
                                    <h3 class="payment-heading">Thông Tin Nhận Hàng</h3>
                                    <form class="form-box" enctype="text/plain" method="get" target="_blank">
                                        <div>
                                            <label for="full-name">Họ Tên</label>
                                            <input id="full-name" name="full-name" placeholder="Nhập tên của bạn.. "
                                                required type="text" />
                                        </div>
                                        <div>
                                            <label for="full-name">Địa Chỉ</label>
                                            <input id="full-name" name="full-name"
                                                placeholder="Nhập địa chỉ nhận hàng..." required type="text" />
                                        </div>
                                        <div>
                                            <label for="full-name">Số Điện Thoại</label>
                                            <input id="full-name" name="full-name"
                                                placeholder="Nhập số điện thoại nhận hàng..." required type="text" />
                                        </div>

                                        <!-- <div>
                                            <label for="credit-card-num">Card Number
                                                <span class="card-logos">
                                                    <i class="card-logo fa-brands fa-cc-visa"></i>
                                                    <i class="card-logo fa-brands fa-cc-amex"></i>
                                                    <i class="card-logo fa-brands fa-cc-mastercard"></i>
                                                    <i class="card-logo fa-brands fa-cc-discover"></i> </span></label>
                                            <input id="credit-card-num" name="credit-card-num"
                                                placeholder="1111-2222-3333-4444" required type="text" />
                                        </div> -->

                                        <!-- <div>
                                            <p class="expires">Expires on:</p>
                                            <div class="card-experation">
                                                <label for="expiration-month">Month</label>
                                                <select id="expiration-month" name="expiration-month" required>
                                                    <option value="">Month:</option>
                                                    <option value="">January</option>
                                                    <option value="">February</option>
                                                    <option value="">March</option>
                                                    <option value="">April</option>
                                                    <option value="">May</option>
                                                    <option value="">June</option>
                                                    <option value="">July</option>
                                                    <option value="">August</option>
                                                    <option value="">September</option>
                                                    <option value="">October</option>
                                                    <option value="">November</option>
                                                    <option value="">Decemeber</option>
                                                </select>

                                                <label class="expiration-year">Year</label>
                                                <select id="experation-year" name="experation-year" required>
                                                    <option value="">Year</option>
                                                    <option value="">2023</option>
                                                    <option value="">2024</option>
                                                    <option value="">2025</option>
                                                    <option value="">2026</option>
                                                </select>
                                            </div>
                                        </div> -->

                                        <!-- <div>
                                            <label for="cvv">CVV</label>
                                            <input id="cvv" name="cvv" placeholder="415" type="text" required />
                                            <a class="cvv-info" href="#">What is CVV?</a>
                                        </div> -->

                                        <button class="btn">
                                            <i class="fa-solid fa-lock"></i> Book Securely
                                        </button>
                                    </form>

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