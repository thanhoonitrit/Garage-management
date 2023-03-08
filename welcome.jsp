<%-- 
    Document   : welcome
    Created on : Feb 16, 2022, 2:46:47 PM
    Author     : duc21
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Account"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
    <title>Quan ly nha xe</title>
    <link rel="icon" href="/pic/logo.png" type="image/x-icon" />
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width" />
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <!-- JavaScript Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
    <script src="https://kit.fontawesome.com/7a93c85040.js" crossorigin="anonymous"></script>
    <link href="./css/css.css" rel="stylesheet" type="text/css"/>
    <script src="./js/js.js" type="text/javascript"></script>
</head>
<body>
    <style>
        .footer-dark {
        padding:50px 0;
        color:#f0f9ff;
        background-color:#282d32;
      }

      .footer-dark h3 {
        margin-top:0;
        margin-bottom:12px;
        font-weight:bold;
        font-size:16px;
      }

      .footer-dark ul {
        padding:0;
        list-style:none;
        line-height:1.6;
        font-size:14px;
        margin-bottom:0;
      }

      .footer-dark ul a {
        color:inherit;
        text-decoration:none;
        opacity:0.6;
      }

      .footer-dark ul a:hover {
        opacity:0.8;
      }

      @media (max-width:767px) {
        .footer-dark .item:not(.social) {
          text-align:center;
          padding-bottom:20px;
        }
      }

      .footer-dark .item.text {
        margin-bottom:36px;
      }

      @media (max-width:767px) {
        .footer-dark .item.text {
          margin-bottom:0;
        }
      }

      .footer-dark .item.text p {
        opacity:0.6;
        margin-bottom:0;
      }

      .footer-dark .item.social {
        text-align:center;
      }

      @media (max-width:991px) {
        .footer-dark .item.social {
          text-align:center;
          margin-top:20px;
        }
      }

      .footer-dark .item.social > a {
        font-size:20px;
        width:36px;
        height:36px;
        line-height:36px;
        display:inline-block;
        text-align:center;
        border-radius:50%;
        box-shadow:0 0 0 1px rgba(255,255,255,0.4);
        margin:0 8px;
        color:#fff;
        opacity:0.75;
      }

      .footer-dark .item.social > a:hover {
        opacity:0.9;
      }

      .footer-dark .copyright {
        text-align:center;
        padding-top:24px;
        opacity:0.3;
        font-size:13px;
        margin-bottom:0;
      }

    </style>
    <div class="header">
        <div class="header-img">
            <img src="./pic/logo.png" width="150px" height="100px" alt="">
        </div>
        <div class="header-nav">
            <ul>
                <li><a href="/"><i class="fa fa-home" style="margin-right: 10px;"></i>Home</a></li>
                <li><a href="/search"><i class="fa fa-cogs" style="margin-right: 10px;"></i>Manage</a></li>
                <li><a href="/report"><i class="fa fa-bullhorn" style="margin-right: 10px;"></i>Report</a></li>
                <li><a href="/contact"><i class="fa fa-envelope" style="margin-right: 10px;"></i>Contact</a></li>
                <li id="signin" onclick="signin_open()"><a href="#">Sign In</a></li>
                <li id="signup" onclick="signup_open()"><a href="#">Sign Up</a></li> 
            </ul>
        </div>
    </div>
    <div id="form_signin">
        <form method="POST" action="/signin">
            <i class="fa-solid fa-x close_item1" onclick="signin_close()"></i>
            <label id="form_signin_title">Sign In</label> <br/>
            
            <input name="username" type="text" id="username" placeholder="Username"  pattern="([0-9a-zA-Z ])*" style="border:0; outline:0; background-color: transparent;border-bottom: 1px solid #fff; width: 80%;"/> <br/>
            <input name="password" type="password" id="password"  placeholder="Password"  pattern="([0-9a-zA-Z ])*" style="border:0; outline:0; background-color: transparent;border-bottom: 1px solid #fff; width: 80%;"/>
            <i onclick="openeye()" class="fa-solid fa-eye eye1"></i> <br/>
            <input type="submit" value="Sign In" onclick="validate()" style="width:80%;"/>
            <br/>
            <p onclick="signupnow()">Bạn chưa có tài khoản ? <a href="#">Đăng ký ngay</a></p>
        </form>
    </div>
    <div id="form_signup">
        <form method="POST" action="/signup">
            <i class="fa-solid fa-x close_item2" onclick="signup_close()"></i>
            <label id="form_signup_title">Sign up</label> <br/>
            <input name="username1" type="text" id="username1" placeholder="Username" pattern="([0-9a-zA-Z ])*" style="border:0; outline:0; background-color: transparent;border-bottom: 1px solid #fff; width: 80%;"/> <br/>
            <input name="password1" type="password" id="password1" placeholder="Password"  pattern="([0-9a-zA-Z ])*" style="border:0; outline:0; background-color: transparent;border-bottom: 1px solid #fff; width: 80%;"/>
            <i onclick="openeye1()" class="fa-solid fa-eye eye2"></i> <br/>
            <input type="password" id="password2" placeholder="RePassword"  pattern="([0-9a-zA-Z ])*" style="border:0; outline:0; background-color: transparent;border-bottom: 1px solid #fff; width: 80%;"/>
            <i onclick="openeye2()" class="fa-solid fa-eye eye3"></i> <br/>
            <input type="submit" value="Sign up" onclick="validate1()" style="width:80%;"/>
            <br/> 
            <p onclick="signinnow()">Bạn đã có tài khoản ? <a href="#">Đăng nhập ngay</a> </p>
        </form>
    </div>
    <div class="cotainer1">
        <div id="carouselExampleDark" class="carousel carousel-dark slide" data-bs-ride="carousel">
            <div class="carousel-indicators">
                <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
                <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="1" aria-label="Slide 2"></button>
                <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="2" aria-label="Slide 3"></button>
            </div>
            <div class="carousel-inner">
                <div class="carousel-item active" data-bs-interval="10000">
                    <img src="/pic/anhgiaothong1.jpg" class="d-block w-100" alt="...">
                    <div class="carousel-caption d-none d-md-block">
                    </div>
                </div>
                <div class="carousel-item" data-bs-interval="2000">
                    <img src="/pic/anhgiaothong2 (1).jpg" class="d-block w-100" alt="...">
                    <div class="carousel-caption d-none d-md-block">
                    </div>
                </div>
                <div class="carousel-item">
                    <img src="/pic/anhgiaothong3.jpg" class="d-block w-100" alt="...">
                    <div class="carousel-caption d-none d-md-block">
                    </div>
                </div>
            </div>
            <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleDark" data-bs-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Previous</span>
            </button>
            <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleDark" data-bs-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Next</span>
            </button>
        </div>
    </div>
    <div class="cotainer3">
        <h2>Giới thiệu</h2>
        <div class="introduce">
            <img src="/pic/nhà xe giáo viên.jpg" width="500px" height="500px" alt="">
            <p>Nhận thấy sự khó khăn trong công việc quản lý nhà xe của các trường THPT, chúng tôi
                đã phát triển và tạo ra 1 web application giúp xử lý điều này.
                <br/>
                Phần mềm quản lý nhà xe giúp kiểm soát thông tin chặt chẽ với trên nhiều báo từ tổng quan đến chi tiết. Công nghệ quản trị khoa học và hiệu quả được tích hợp trong giải pháp quản lý giúp người quản lý nắm rõ được tình hình lấp đầy xe, dễ dàng điều hành, phân loại được các loại xe thân thiết, thao tác đặt/dời/sửa/xóa xe nhanh chóng.
                <br/>
                Đặc biệt, ứng dụng quản lý xe của chúng tôi giúp hãng xe hoàn toàn chủ động trong khâu quản trị từ xa văn phòng, mọi thao tác đều nằm gọn trên chiếc máy tính cá nhân.
            </p>
        </div>
    </div>
    <div class="cotainer2">
        <h2>Lợi ích khi sử dụng</h2>
        <div class="benefit">
            <div class="benefit-col benefit-col1">Lưu trữ thông tin nhanh gọn</div>
            <div class="benefit-col benefit-col2">Bảo mật thông tin an toàn</div>
            <div class="benefit-col benefit-col3">Tiện lợi trong công việc quản lý</div>

        </div>
    </div>
    <div class="cotainer4">
        <h2>Mọi người nói gì khi sử dụng</h2>
        <div class="feedback">
            <div class="feedback-all feedback-1">
                <img src="/pic/feedback1.jpg" width="150px" height="150px" alt="">
                <p>Nhờ sử dụng hệ thống công nghệ quản trị nhà xe trực tuyến của MVN các nhà trường hoạt động trơn tru hơn, không cần phải gọi điện qua lại, tiết kiệm được thời gian và chi phí.</p>
                <h5>- Anh Tùng</h5>
            </div>
            <div class="feedback-all feedback-2">
                <img src="/pic/feedback2.jpg" width="150px" height="150px" alt="">
                <p>Chị đã U40 rồi, chưa bao giờ đụng vô máy tính nên lúc đầu ngại lắm. Nhưng đội ngũ MVN hỗ trợ chị rất kỹ và tận tình. Bản thân chị cũng thấy phần mềm quản lý nhà xe dễ hiểu và dễ sử dụng lắm. Từ khi quen với việc dùng giải pháp quản trị của MVN thì thấy tiện ích vô cùng nhanh và chính xác.</p>
                <h5>- Cô Tâm</h5>
            </div>
            <div class="feedback-all feedback-3">
                <img src="/pic/feedback3.png"width="150px" height="150px"  alt="">
                <p>Từ khi dùng giải pháp quản trị hãng xe và ứng dụng quản lý xe của MVN, phần thống kê – báo cáo cực nhanh và chính xác. Giờ đây dù anh ở xa nhưng vẫn dễ dàng nắm được tình hình nhà xe thông qua qua phần mềm nhà xe MVN, rất hữu ích cho anh!</p>
                <h5>- Thầy Hùng</h5>
            </div>
        </div>
    </div>
    <div class="map-section">
        <img src="/pic/map.jpg" alt="Map">
    </div>   
    <div class="footer-dark">
        <footer>
            <div class="container">
                <div class="row">
                    <div class="col-sm-6 col-md-3 item">
                        <h3>Services</h3>
                        <ul>
                            <li><a href="#">Web design</a></li>
                            <li><a href="#">Development</a></li>
                            <li><a href="#">Hosting</a></li>
                        </ul>
                    </div>
                    <div class="col-sm-6 col-md-3 item">
                        <h3>About</h3>
                        <ul>
                            <li><a href="#">Company</a></li>
                            <li><a href="#">Team</a></li>
                            <li><a href="#">Careers</a></li>
                        </ul>
                    </div>
                    <div class="col-md-6 item text">
                        <h3>MVN</h3>
                        <p>We are committed to the quality of this application. Always update and develop more based on everyone's feedback.</p>
                    </div>
                    <div class="col item social"><a href="https://www.facebook.com/nhatduc2110/"><i class="fb fa-brands fa-facebook"></i> </a><a href="https://www.instagram.com/evannnn2110/"><i class="im fa-brands fa-instagram"></i> </a>
                    <a href="https://twitter.com/Nhtc17"><i class="tw fa-brands fa-twitter"></i> </a>    
                    </div>
                </div>
                <p class="copyright">Company Name © 2022</p>
            </div>
        </footer>
    </div>
</body>