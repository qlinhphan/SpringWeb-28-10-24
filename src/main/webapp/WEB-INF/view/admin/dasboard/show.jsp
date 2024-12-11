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

                    <link rel="stylesheet"
                        href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css"
                        integrity="sha512-Kc323vGBEqzTmouAECnVceyQqyqdsSiqLQISBL29aUW4U/M7pSPA/gEUZQqv1cwx4OnYxTxve5UMg5GT6L4JJg=="
                        crossorigin="anonymous" referrerpolicy="no-referrer" />
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


                    </nav>
                    <div id="layoutSidenav">
                        <div id="layoutSidenav_nav">
                            <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
                                <div class="sb-sidenav-menu">
                                    <div class="nav">
                                        <div class="sb-sidenav-menu-heading">Core</div>
                                        <a class="nav-link" href="/adminDash">
                                            <div class="sb-nav-link-icon"><i class="fa-solid fa-house-user"></i></i>
                                            </div>
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
                                        <a class="nav-link" href="adminOrder">
                                            <div class="sb-nav-link-icon"><i class="fa-regular fa-newspaper"></i></div>
                                            Order
                                        </a>
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
                                    <h1 class="mt-4" style="font-size: 19px;">Dashboard</h1>
                                    <div class="row">
                                        <div class="col-xl-4 col-md-6">
                                            <div class="card bg-primary text-white mb-4">
                                                <div class="card-body">Thống Kê Người Dùng (${countUsers})</div>
                                                <div
                                                    class="card-footer d-flex align-items-center justify-content-between">
                                                    <a class="small text-white stretched-link" href="/table/user">Xem
                                                        Chi Tiết</a>
                                                    <div class="small text-white"><i class="fas fa-angle-right"></i>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-xl-4 col-md-6">
                                            <div class="card bg-success text-white mb-4">
                                                <div class="card-body">Thống Kê Sản Phẩm (${countProducts})</div>
                                                <div
                                                    class="card-footer d-flex align-items-center justify-content-between">
                                                    <a class="small text-white stretched-link" href="/adminProduct">Xem
                                                        Chi Tiết</a>
                                                    <div class="small text-white"><i class="fas fa-angle-right"></i>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-xl-4 col-md-6">
                                            <div class="card bg-danger text-white mb-4">
                                                <div class="card-body">Thống Kê Đơn Hàng (${countOrders})</div>
                                                <div
                                                    class="card-footer d-flex align-items-center justify-content-between">
                                                    <a class="small text-white stretched-link" href="/adminOrder">Xem
                                                        Chi Tiết</a>
                                                    <div class="small text-white"><i class="fas fa-angle-right"></i>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>


                                    <div class="row">
                                        <div class="col-xl-4 col-md-6">
                                            <div class="card bg-primary text-white mb-4">
                                                <div class="card-body">Đơn Hàng Chờ Xác Nhận (${pending})</div>

                                            </div>
                                        </div>
                                        <div class="col-xl-4 col-md-6">
                                            <div class="card bg-success text-white mb-4">
                                                <div class="card-body">Đơn Hàng Đang Vận Chuyển (${delivering})</div>

                                            </div>
                                        </div>
                                        <div class="col-xl-4 col-md-6">
                                            <div class="card bg-danger text-white mb-4">
                                                <div class="card-body">Đơn Hàng Đã Vẫn Chuyển (${finish})</div>

                                            </div>
                                        </div>
                                    </div>

                                    <div class="row">
                                        <div class="col-xl-6">
                                            <div class="card mb-4">
                                                <div class="card-header">
                                                    <i class="fas fa-chart-area me-1"></i>
                                                    Thống Kê Doanh Thu Qua Các Ngày
                                                </div>
                                                <div class="card-body"><canvas id="myBarChart" width="100%"
                                                        height="40"></canvas></div>
                                            </div>
                                        </div>
                                        <div class="col-xl-6">
                                            <div class="card mb-4">
                                                <div class="card-header">
                                                    <i class="fas fa-chart-area me-1"></i>
                                                    Thống Kê Doanh Thu Trong Các Tháng
                                                </div>
                                                <div class="card-body"><canvas id="myBarCharts" width="100%"
                                                        height="40"></canvas></div>
                                            </div>
                                        </div>
                                        <div class="col-xl-12">
                                            <div class="card mb-4">
                                                <div class="card-header">
                                                    <i class="fas fa-chart-bar me-1"></i>
                                                    Thống kê lợi nhuận trong các tháng
                                                </div>
                                                <div class="card-body"><canvas id="myBarCharts3" width="100%"
                                                        height="40"></canvas></div>
                                            </div>
                                        </div>
                                    </div>

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
                        crossorigin="anonymous"></script>
                    <script src="/js/scripts.js"></script>
                    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js"
                        crossorigin="anonymous"></script>
                    <script src="/js/chart-area-demo.js"></script>
                    <script>
                        // Set new default font family and font color to mimic Bootstrap's default styling
                        Chart.defaults.global.defaultFontFamily = '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
                        Chart.defaults.global.defaultFontColor = '#292b2c';

                        // Bar Chart Example
                        let dataDate = [
                            <c:forEach var="order" items="${orders}" varStatus="status">
                                <c:if test="${status.index > 0}">,</c:if>
                                "<c:out value="${order.dateOrder}" />"
                            </c:forEach>
                        ]

                        //
                        let dataDateFinal = []
                        for (let i = 0; i < dataDate.length; i++) {
                            dataDateFinal.push(dataDate[i].split(" ")[0])    //cut cai gio di
                        }

                        //viet o day


                        let dataMoney = [
                            <c:forEach var="order" items="${orders}" varStatus="status">
                                <c:if test="${status.index > 0}">,</c:if>
                                "<c:out value="${order.totalPrice}" />"
                            </c:forEach>
                        ]

                        let money = []
                        for (let i = 0; i < dataDateFinal.length; i++) {
                            money[i] = parseFloat(dataMoney[i])
                            dataMoney[i] = money[i]
                        }

                        for (let i = 0; i < dataDateFinal.length; i++) {
                            for (let j = i + 1; j < dataDateFinal.length; j++) {
                                if (dataDateFinal[i] === dataDateFinal[j]) {
                                    money[i] = money[i] + money[j]
                                }
                            }
                        }

                        for (let i = 0; i < dataDateFinal.length; i++) {
                            for (let j = i + 1; j < dataDateFinal.length; j++) {
                                if (dataDateFinal[i] === dataDateFinal[j]) {
                                    dataDateFinal.splice(j, 1)
                                    money.splice(j, 1)
                                    j--
                                }
                            }
                        }


                        var ctx = document.getElementById("myBarChart");
                        var myLineChart = new Chart(ctx, {
                            type: 'bar',
                            data: {
                                labels: dataDateFinal,

                                datasets: [{
                                    label: "Revenue",
                                    backgroundColor: "rgba(2,117,216,1)",
                                    borderColor: "rgba(2,117,216,1)",
                                    data: money,
                                }],
                            },
                            options: {
                                scales: {
                                    xAxes: [{
                                        time: {
                                            unit: 'day'
                                        },
                                        gridLines: {
                                            display: false
                                        },
                                        ticks: {
                                            maxTicksLimit: 6
                                        }
                                    }],
                                    yAxes: [{
                                        ticks: {
                                            min: 0,
                                            max: 400000000,
                                            maxTicksLimit: 5
                                        },
                                        gridLines: {
                                            display: true
                                        }
                                    }],
                                },
                                legend: {
                                    display: false
                                }
                            }
                        });

                        myLineChart.update();


                    </script>

                    <script>
                        // Set new default font family and font color to mimic Bootstrap's default styling
                        Chart.defaults.global.defaultFontFamily = '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
                        Chart.defaults.global.defaultFontColor = '#292b2c';

                        // Bar Chart Example
                        let dataDates = [
                            <c:forEach var="order" items="${orders}" varStatus="status">
                                <c:if test="${status.index > 0}">,</c:if>
                                "<c:out value="${order.dateOrder}" />"
                            </c:forEach>
                        ]

                        //
                        let months = []
                        for (let i = 0; i < dataDates.length; i++) {
                            months.push(dataDate[i].split("-")[1])
                        }

                        for (let i = 0; i < months.length; i++) {
                            for (let j = i + 1; j < months.length; j++) {
                                if (months[i] > months[j]) {
                                    let tg = months[i];
                                    months[i] = months[j];
                                    months[j] = tg;
                                }
                            }
                        }


                        let dataMoneys = [
                            <c:forEach var="order" items="${orders}" varStatus="status">
                                <c:if test="${status.index > 0}">,</c:if>
                                "<c:out value="${order.totalPrice}" />"
                            </c:forEach>
                        ]

                        let moneys = []
                        for (let i = 0; i < dataMoneys.length; i++) {
                            dataMoneys[i] = parseFloat(dataMoneys[i])
                            moneys.push(dataMoneys[i])
                        }

                        for (let i = 0; i < months.length; i++) {
                            for (let j = i + 1; j < months.length; j++) {
                                if (months[i] === months[j]) {
                                    moneys[i] = moneys[i] + moneys[j]
                                }
                            }
                        }

                        for (let i = 0; i < months.length; i++) {
                            for (let j = i + 1; j < months.length; j++) {
                                if (months[i] === months[j]) {
                                    months.splice(j, 1)
                                    moneys.splice(j, 1)
                                    j--
                                }
                            }
                        }
                        // let k = 122;
                        // var b = [];
                        // for (var i = 0; i < 2; i++) {
                        //     console.log(k);
                        //     b.push("rgba(54," + k + ",91,1)");
                        //     k += 12;
                        // }
                        // console.log(b);

                        var ctx = document.getElementById("myBarCharts");
                        var myLineChart = new Chart(ctx, {
                            type: 'line',
                            data: {
                                labels: months,

                                datasets: [{
                                    label: "Revenue",
                                    backgroundColor: "rgba(2,117,216,1)",
                                    borderColor: "rgba(2,117,216,1)",
                                    boderWidth: 5,
                                    data: moneys,
                                }],
                            },
                            options: {
                                scales: {
                                    xAxes: [{
                                        time: {
                                            unit: 'day'
                                        },
                                        gridLines: {
                                            display: false
                                        },
                                        ticks: {
                                            maxTicksLimit: 6
                                        }
                                    }],
                                    yAxes: [{
                                        ticks: {
                                            min: 0,
                                            max: 400000000,
                                            maxTicksLimit: 5
                                        },
                                        gridLines: {
                                            display: true
                                        }
                                    }],
                                },
                                legend: {
                                    display: false
                                }
                            }
                        });



                    </script>

                    <script>
                        // Set new default font family and font color to mimic Bootstrap's default styling
                        Chart.defaults.global.defaultFontFamily = '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
                        Chart.defaults.global.defaultFontColor = '#292b2c';

                        // Bar Chart Example
                        let dataDatess = [
                            <c:forEach var="order" items="${orders}" varStatus="status">
                                <c:if test="${status.index > 0}">,</c:if>
                                "<c:out value="${order.dateOrder}" />"
                            </c:forEach>
                        ]

                        //
                        let month = []
                        for (let i = 0; i < dataDatess.length; i++) {
                            month.push(dataDate[i].split("-")[1])
                        }

                        for (let i = 0; i < month.length; i++) {
                            for (let j = i + 1; j < month.length; j++) {
                                if (month[i] > month[j]) {
                                    let tg = month[i];
                                    month[i] = month[j];
                                    month[j] = tg;
                                }
                            }
                        }


                        let dataMoneyy = [
                            <c:forEach var="order" items="${orders}" varStatus="status">
                                <c:if test="${status.index > 0}">,</c:if>
                                "<c:out value="${order.totalPrice}" />"
                            </c:forEach>
                        ]

                        let moneyy = []
                        for (let i = 0; i < dataMoneyy.length; i++) {
                            dataMoneyy[i] = parseFloat(dataMoneyy[i])
                            dataMoneyy[i] = dataMoneyy[i] * 0.15;
                            moneyy.push(dataMoneyy[i])
                        }

                        for (let i = 0; i < month.length; i++) {
                            for (let j = i + 1; j < month.length; j++) {
                                if (month[i] === month[j]) {
                                    moneyy[i] = moneyy[i] + moneyy[j]
                                }
                            }
                        }

                        for (let i = 0; i < month.length; i++) {
                            for (let j = i + 1; j < month.length; j++) {
                                if (month[i] === month[j]) {
                                    month.splice(j, 1)
                                    moneyy.splice(j, 1)
                                    j--
                                }
                            }
                        }
                        // let k = 122;
                        // var b = [];
                        // for (var i = 0; i < 2; i++) {
                        //     console.log(k);
                        //     b.push("rgba(54," + k + ",91,1)");
                        //     k += 12;
                        // }
                        // console.log(b);

                        var ctx = document.getElementById("myBarCharts3");
                        var myLineChart = new Chart(ctx, {
                            type: 'line',
                            data: {
                                labels: months,

                                datasets: [{
                                    label: "Revenue",
                                    backgroundColor: "rgba(2,117,216,1)",
                                    borderColor: "rgba(2,117,216,1)",
                                    boderWidth: 5,
                                    data: moneyy,
                                }],
                            },
                            options: {
                                scales: {
                                    xAxes: [{
                                        time: {
                                            unit: 'day'
                                        },
                                        gridLines: {
                                            display: false
                                        },
                                        ticks: {
                                            maxTicksLimit: 6
                                        }
                                    }],
                                    yAxes: [{
                                        ticks: {
                                            min: 0,
                                            max: 400000000,
                                            maxTicksLimit: 5
                                        },
                                        gridLines: {
                                            display: true
                                        }
                                    }],
                                },
                                legend: {
                                    display: false
                                }
                            }
                        });



                    </script>








                    <script src="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/umd/simple-datatables.min.js"
                        crossorigin="anonymous"></script>
                    <script src="/js/datatables-simple-demo.js"></script>

                </body>

                </html>