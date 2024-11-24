User: +add
      +edit
      +delete
      +view detail
      +view short

Product: +add
         +edit
         +delete
         +view detail
         +view short

database of Product (copy vao workbench va chay): => 10 items
INSERT INTO trang.products VALUES 
(1, 'ASUS TUF Gaming F15 FX506HF HN017W la chiec laptop gaming gia re nhung vo cung manh me. Khong chi bo vi xu ly Intel the he thu 11, card do hoa RTX 20 series ma diem manh con den tu viec trang bi san 16GB RAM, cho ban hieu nang xuat sac ma khong can nang cap may.', 'ASUS', '1711078092373-asus-01.png', 'Laptop Asus TUF Gaming', 17490000, 100, ' Intel, Core i5, 11400H', 0, 'GAMING'),
(2, 'Kham pha suc manh toi uu tu Dell Inspiron 15 N3520, chiec laptop co cau hinh cuc manh voi bo vi xu ly Intel Core i5 1235U the he moi va dung luong RAM len toi 16GB. Ban co the thoai mai xu ly nhieu tac vu, nang cao nang suat trong cong viec ma khong gap bat ky tro ngai nao.', 'DELL', '1711078452562-dell-01.png', 'Laptop Dell Inspiron 15 ', 15490000, 200, 'i5 1235U/16GB/512GB/15.6"FHD', 0, 'SINHVIEN-VANPHONG'),
(3, 'Moi day, Lenovo da tung ra thi truong mot san pham gaming the he moi voi hieu nang manh me, thiet ke toi gian, lich lam phu hop cho nhung game thu thich su don gian. Tan nhiet mat me voi he thong quat kep kiem soat duoc nhiet do may luon mat me khi choi game.', 'LENOVO', '1711079073759-lenovo-01.png', 'Lenovo IdeaPad Gaming 3', 19500000, 150, ' i5-10300H, RAM 8G', 0, 'GAMING'),
(4, 'Tan huong cam giac mat lanh sanh dieu voi thiet ke kim loai. Duoc thiet ke de dap ung nhung nhu cau dien toan hang ngay cua ban, dong may tinh xach tay ASUS K Series so huu thiet ke toi gian, gon nhe va cuc mong voi mot lop vo hoa tiet van kim loai phong cach. Hieu nang cua may rat manh me nho trang bi bo vi xu ly Intel® Core™ i7 processor va do hoa moi nhat. Ben canh do, cac cong nghe sang tao doc quyen cua ASUS dua thiet bi len dang cap moi, cho ban mot trai nghiem nguoi dung truc quan va tinh nang cong thai hoc vuot troi.', 'ASUS', '1711079496409-asus-02.png', 'Asus K501UX', 11900000, 99, 'VGA NVIDIA GTX 950M- 4G', 0, 'THIET-KE-DO-HOA'),
(5, 'Chiec MacBook Air co hieu nang dot pha nhat tu truoc den nay da xuat hien. Bo vi xu ly Apple M1 hoan toan moi dua suc manh cua MacBook Air M1 13 inch 2020 vuot xa khoi mong doi nguoi dung, co the chay duoc nhung tac vu nang va thoi luong pin dang kinh ngac.', 'APPLE', '1711079954090-apple-01.png', 'MacBook Air 13', 17690000, 99, 'Apple M1 GPU 7 nhan', 0, 'GAMING'),
(6, '14.0 Chinh: inch, 2880 x 1800 Pixels, OLED, 90 Hz, OLED', 'LG', '1711080386941-lg-01.png', 'Laptop LG Gram Style', 31490000, 99, 'Intel Iris Plus Graphics', 0, 'DOANH-NHAN'),
(7, 'Khong chi khoi goi cam hung qua viec cach tan thiet ke, MacBook Air M2 2022 con chua dung nguon suc manh lon lao voi chip M2 sieu manh, thoi luong pin cham ngur 18 gio, man hinh Liquid Retina tuyet dep va he thong camera ket hop cung am thanh tan tien.', 'APPLE', '1711080787179-apple-02.png', 'MacBook Air 13 ', 24990000, 99, ' Apple M2 GPU 8 nhan', 0, 'MONG-NHE'),
(8, 'La chiec laptop gaming the he moi nhat thuoc dong Nitro 5 luon chiem duoc rat nhieu cam tinh cua game thu truoc day, Acer Nitro Gaming AN515-58-769J nay con an tuong hon nua voi bo vi xu ly Intel Core i7 12700H cuc khung va card do hoa RTX 3050, san sang cung ban chinh phuc nhung dinh cao.', 'ACER', '1711080948771-acer-01.png', 'Laptop Acer Nitro ', 23490000, 99, 'AN515-58-769J i7 12700H', 0, 'SINHVIEN-VANPHONG'),
(9, '15.6 inch, FHD (1920 x 1080), IPS, 144 Hz, 250 nits, Acer ComfyView LED-backlit', 'ASUS', '1711081080930-asus-03.png', 'Laptop Acer Nitro V', 26999000, 99, ' NVIDIA GeForce RTX 4050', 0, 'MONG-NHE'),
(10, 'Dell Inspiron N3520 la chiec laptop ly tuong cho cong viec hang ngay. Bo vi xu ly Intel Core i5 the he thu 12 hieu suat cao, man hinh lon 15,6 inch Full HD 120Hz muot ma, thiet ke ben bi se giup ban giai quyet cong viec nhanh chong moi luc moi noi.', 'DELL', '1711081278418-dell-02.png', 'Laptop Dell Latitude 3420', 21399000, 99, ' Intel Iris Xe Graphics', 0, 'MONG-NHE');

auth: register => first name, last name, email, password, confirm password


Mapper laf chuyen doi du lieu va thuong duoc thuc hien trong kieu can chuyen doi

khi đăng ký tài khoản phải check xem email đã tồn tại hay chưa và pass và repass có trùng nhau hay không thì mới tiếp tục


                        <div>
                            <form:select class="form-select" aria-label="Default select example" path="roless.name">
                                <form:option value="Admin">Admin</form:option>
                                <form:option value="User">User</form:option>
                            </form:select>
                        </div>


// @Bean
    // public SecurityFilterChain securityFilterChain(HttpSecurity http) throws
    // Exception {
    // http
    // .csrf(AbstractHttpConfigurer::disable)
    // .authorizeHttpRequests(
    // authorizationManagerRequestMatcherRegistry ->
    // authorizationManagerRequestMatcherRegistry
    // .requestMatchers("/error").permitAll()
    // .anyRequest().authenticated())
    // .formLogin().loginPage("/loginMy").defaultSuccessUrl("/homePage/client",
    // true).permitAll()
    // .and()
    // .logout().permitAll();

    // return http.build();
    // }

    // @Bean
    // public SecurityFilterChain securityFilterChain(HttpSecurity http) throws
    // Exception {
    // http
    // .csrf(AbstractHttpConfigurer::disable)
    // .authorizeHttpRequests(
    // authorizationManagerRequestMatcherRegistry ->
    // authorizationManagerRequestMatcherRegistry
    // .requestMatchers("/error").permitAll()
    // .requestMatchers("/login").permitAll() // Cho phép truy cập vào trang đăng
    // nhập
    // .anyRequest().authenticated()) // Yêu cầu xác thực cho các yêu cầu khác
    // .formLogin().loginPage("/login").defaultSuccessUrl("/homePage/client",
    // true).permitAll()
    // .and()
    // .logout().permitAll();

    // return http.build();
    // }


    Khi nào khách hàng đã thanh toán nhớ lưu order, orderDetail và xóa đi cart lẫn cartDetail 
    tại 1 phiên đăng nhập thì 1 người dùng có 1 cart và nhiều cartDetail
    nhưng khi lưu xuống database thì 1 người dùng có nhiều order vì mua hàng các thời điểm khác nhau(ý là đặt cart này xong đặt cart khác) 
    vaf 1 order thì có nhiều orderDetail