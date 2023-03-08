<%-- 
    Document   : report
    Created on : Mar 10, 2022, 11:36:03 AM
    Author     : duc21
--%>

<%@page import="model.Account"%>
<%@page import="model.Report"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
    <% ArrayList<Report> Reports = (ArrayList<Report>)request.getAttribute("listpage");
    Account account = (Account)request.getSession().getAttribute("account");
    int endP = (Integer)request.getAttribute("endP");
    %>
    </head>
    <style>
        .cotainer {
                height: 600px;
                margin-left: 700px;
                margin-top: 100px;
                font-size: 18px;
                font-weight: bolder;
            }
        .cotainer table {
                width: 50%;
                margin-bottom: 30px;
        }
        .cotainer a {
            text-decoration: none;
            background-color: #d7eaf7;
            padding: 3px;
            border-radius: 10px;
        }
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
.stars {
   width: 300px;
   height: 80px;
   text-align: center;
   position: absolute;
   top: 50%;
   left: 50%;
   transform: translate(-50%, -50%);
   -webkit-transform: translate(-50%, -50%);
   -ms-transform: translate(-50%, -50%);
   margin-top: 300px;
}

.stars .star {
   width: 84px;
   position: absolute;
   top: 0;
   font-size: 70px;
   color: #FFFD5A;
   text-shadow: 1px 2px 4px #C3C11C;
   padding: 0 5px;
}

.stars-ghost {
   width: 0px;
   position: relative;
   float: left;
   overflow: hidden;
   height: 100%;
   z-index: 2;
}

.stars .star:nth-child(1) {
   left: 0;
}

.stars .star:nth-child(2) {
   left: 84px;
}

.stars .star:nth-child(3) {
   left: 168px;
}

.stars .star:nth-child(4) {
   left: 252px;
}

.stars .star:nth-child(5) {
   left: 336px;
}

body {
   background: #fff;
}

.info {
   width: 100%;
   font-size: 30px;
   text-align: center;
   font-family: "Consolas";
   position: absolute;
   top: -80px;
}

body,
html {
   overflow: hidden;
}

*,
*:after,
*::before {
   -webkit-box-sizing: border-box;
   -moz-box-sizing: border-box;
   box-sizing: border-box;
   margin: 0;
   padding: 0;
   text-decoration: none;
}
#feed-back_text {
    border:0; outline:0; background-color: transparent;border-bottom: 1px solid #282d32;
}
    </style>
    <body>
        <div class="header">
            <div class="header-img">
                <img src="../pic/logo.png" width="150px" height="100px" alt="">
            </div>
            <div class="header-nav">
                <ul>
                    <li><a href="/"><i class="fa fa-home" style="margin-right: 10px;"></i>Home</a></li>
                    <li><a href="/search"><i class="fa fa-cogs" style="margin-right: 10px;"></i>Manage</a></li>
                    <li><a href="/report"><i class="fa fa-bullhorn" style="margin-right: 10px;"></i>Report</a></li>
                    <li><a href="/contact"><i class="fa fa-envelope" style="margin-right: 10px;"></i>Contact</a></li>
                    <li><a href="/profile">Hello <%=account.getUsername()%></a></li>
                    <li><a href="/logout">Log Out</a></li>
                </ul>
            </div>
        </div>
        <div class="cotainer">
            
        <form action="report" method="POST">
                Your's feedback: <input id="feed-back_text" type="text" name="report" required pattern="([0-9a-zA-Z ])*"/> <br/>  
                <input style="margin-left: 300px; margin-top: 20px;" type="submit" value="Save"/> <br/>
        </form>
            <br/>
        <table style="border:2px solid blue;text-align: center;height: 50px;">
            
                    <tr>
                        <td style="color: blue;"><p style="background-color: #d7eaf7; display: inline-block; border-radius: 10px; margin-top: 10px;">FeedBack: </p></td> <br/>
                    </tr>
                        <% for (Report r : Reports) {
                          %>  
                    <tr>
                        <td><%=r.getContent() %></td> 
                        <%}%>
                    </tr>
        </table>
            Page: <% for (int i = 1; i <= endP; i++) {
            %>
            <a href="report?index2=<%=i%>"><%=i%></a>
            <%}%> <br/>
            
        </div>
            <div class="stars">
            <div class="stars-ghost">
               <div class="star"><i class="fa fa-star"></i></div>
               <div class="star"><i class="fa fa-star"></i></div>
               <div class="star"><i class="fa fa-star"></i></div>
               <div class="star"><i class="fa fa-star"></i></div>
               <div class="star"><i class="fa fa-star"></i></div>
            </div>
            <div class="star"><i class="fa fa-star-o"></i></div>
            <div class="star"><i class="fa fa-star-o"></i></div>
            <div class="star"><i class="fa fa-star-o"></i></div>
            <div class="star"><i class="fa fa-star-o"></i></div>
            <div class="star"><i class="fa fa-star-o"></i></div>
         </div>
            <script>
                $(".stars").mousemove(function(e) {
                var gLeft = $(".stars .stars-ghost").offset().left,
                   pX = e.pageX;

                $(".stars .stars-ghost").width(pX - gLeft);

             });
            </script>
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
</html>
