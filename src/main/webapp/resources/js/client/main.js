(function ($) {
    "use strict";

    // Spinner
    var spinner = function () {
        setTimeout(function () {
            if ($('#spinner').length > 0) {
                $('#spinner').removeClass('show');
            }
        }, 1);
    };
    spinner(0);


    // Fixed Navbar
    $(window).scroll(function () {
        if ($(window).width() < 992) {
            if ($(this).scrollTop() > 55) {
                $('.fixed-top').addClass('shadow');
            } else {
                $('.fixed-top').removeClass('shadow');
            }
        } else {
            if ($(this).scrollTop() > 55) {
                $('.fixed-top').addClass('shadow').css('top', -55);
            } else {
                $('.fixed-top').removeClass('shadow').css('top', 0);
            }
        }
    });


    // Back to top button
    $(window).scroll(function () {
        if ($(this).scrollTop() > 300) {
            $('.back-to-top').fadeIn('slow');
        } else {
            $('.back-to-top').fadeOut('slow');
        }
    });
    $('.back-to-top').click(function () {
        $('html, body').animate({ scrollTop: 0 }, 1500, 'easeInOutExpo');
        return false;
    });


    // Testimonial carousel
    $(".testimonial-carousel").owlCarousel({
        autoplay: true,
        smartSpeed: 2000,
        center: false,
        dots: true,
        loop: true,
        margin: 25,
        nav: true,
        navText: [
            '<i class="bi bi-arrow-left"></i>',
            '<i class="bi bi-arrow-right"></i>'
        ],
        responsiveClass: true,
        responsive: {
            0: {
                items: 1
            },
            576: {
                items: 1
            },
            768: {
                items: 1
            },
            992: {
                items: 2
            },
            1200: {
                items: 2
            }
        }
    });


    // vegetable carousel
    $(".vegetable-carousel").owlCarousel({
        autoplay: true,
        smartSpeed: 1500,
        center: false,
        dots: true,
        loop: true,
        margin: 25,
        nav: true,
        navText: [
            '<i class="bi bi-arrow-left"></i>',
            '<i class="bi bi-arrow-right"></i>'
        ],
        responsiveClass: true,
        responsive: {
            0: {
                items: 1
            },
            576: {
                items: 1
            },
            768: {
                items: 2
            },
            992: {
                items: 3
            },
            1200: {
                items: 4
            }
        }
    });


    // Modal Video
    $(document).ready(function () {
        var $videoSrc;
        $('.btn-play').click(function () {
            $videoSrc = $(this).data("src");
        });
        console.log($videoSrc);

        $('#videoModal').on('shown.bs.modal', function (e) {
            $("#video").attr('src', $videoSrc + "?autoplay=1&amp;modestbranding=1&amp;showinfo=0");
        })

        $('#videoModal').on('hide.bs.modal', function (e) {
            $("#video").attr('src', $videoSrc);
        })
    });



    // Product Quantity
    $('.quantity button').on('click', function () {
        var button = $(this);
        var oldValue = button.parent().parent().find('input').val();
        if (button.hasClass('btn-plus')) {
            var newVal = parseFloat(oldValue) + 1;
        } else {
            if (oldValue > 0) {
                var newVal = parseFloat(oldValue) - 1;
            } else {
                newVal = 0;
            }
        }
        button.parent().parent().find('input').val(newVal);
    });



    $("#btnFilter").click(function () {
        let fact = [];
        let target = [];
        let money = [];
        let sort = [];

        $("#nameFilter .form-check-input:checked").each(function () {
            fact.push($(this).val())
        })

        $("#targetFilter .form-check-input:checked").each(function () {
            target.push($(this).val())
        })

        $("#sortFilter .form-check-input:checked").each(function () {
            sort.push($(this).val())
        })

        $("#moneyFilter .form-check-input:checked").each(function () {
            money.push($(this).val())
        })

        // $("#moneyFilter .form-check-input:checked").each(function () {
        //     money.push($(this).val())
        // })
        // $("#sortFilter .form-check-input:checked").each(function () {
        //     sort.push($(this).val())
        // })

        console.log(fact)
        console.log(target)
        // console.log(money)

        let currentUrl = new URL(window.location.href)
        let searchParams = currentUrl.searchParams

        if (target.length > 0) {
            searchParams.set("target", target.join(','))
        } else {
            searchParams.delete('target')
        }

        if (fact.length > 0) {
            searchParams.set("fact", fact.join(','))
        } else {
            searchParams.delete('fact')
        }

        if (money.length > 0) {
            searchParams.set("money", money.join(','))
        } else {
            searchParams.delete('money')
        }

        if (sort.length > 0) {
            searchParams.set("sort", sort.join(','))
        } else {
            searchParams.delete('sort')
        }

        // searchParams.set('page', '1')

        history.pushState('', {}, currentUrl.toString());
        location.reload(true);
    })


    $(document).ready(function () {
        let currentUrl = new URL(window.location.href);
        let searchParams = currentUrl.searchParams;

        let nameParam = searchParams.get("fact");
        let nameArray = nameParam ? nameParam.split(',') : [];

        let targetParam = searchParams.get("target");
        let targetArray = targetParam ? targetParam.split(',') : [];

        let moneyParam = searchParams.get("money");
        let moneyArray = moneyParam ? moneyParam.split(',') : [];

        let sortParam = searchParams.get('sort')
        let sortArray = sortParam ? sortParam.split(',') : []

        // Tích chọn các checkbox dựa trên các giá trị trong URL
        $("#nameFilter .form-check-input").each(function () {
            if (nameArray.includes($(this).val())) {
                $(this).prop("checked", true);
            }
        });

        $("#targetFilter .form-check-input").each(function () {
            if (targetArray.includes($(this).val())) {
                $(this).prop("checked", true);
            }
        });

        $("#moneyFilter .form-check-input").each(function () {
            if (moneyArray.includes($(this).val())) {
                $(this).prop("checked", true);
            }
        });

        $("#sortFilter .form-check-input").each(function () {
            if (sortArray.includes($(this).val())) {
                $(this).prop("checked", true);
            }
        });

        // $("#moneyFilter .form-check-input").each(function () {
        //     if (nameArray.includes($(this).val())) {
        //         $(this).prop("checked", true);
        //     }
        // });
    });

    // sang trang se ko mat di phan tim kiem
    $(".pagination a").click(function (event) {
        event.preventDefault(); // Ngừng tải lại trang
        let page = $(this).data("page"); // Lấy số trang từ data attribute

        if (page === undefined || page === null || page === "") {
            console.error("Số trang không hợp lệ.");
            return;
        }

        let currentUrl = new URL(window.location.href);
        let searchParams = currentUrl.searchParams;

        // Chỉ thay đổi tham số page mà không thay đổi các tham số khác
        searchParams.set('page', page);
        alert(typeof page);

        // Cập nhật URL mới
        history.pushState('', {}, currentUrl.toString());

        // Tải lại trang với tham số mới
        location.reload(true);
    });


})(jQuery);

