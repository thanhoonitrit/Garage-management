<%-- 
    Document   : insert
    Created on : Mar 3, 2022, 11:14:40 AM
    Author     : duc21
--%>

<%@page import="model.Account"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Classes"%>
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
        <%
            ArrayList<Classes> classes = (ArrayList<Classes>) request.getAttribute("classes");
            Account account = (Account)request.getSession().getAttribute("account");
        %>
    </head>
    <body>
        <style>
            .cotainer {
                height: 700px;
                margin-left: 650px;
                margin-top: 100px;
            }
            .cotainer form {
                background-color: #d7eaf7;
                display: inline-block;
                padding: 90px;
                font-weight: bolder;
                border: 2px solid #87CEFA;
                width: 40%;
            }
            .cotainer form input {
                margin-bottom: 10px;
                padding: 5px;
            }
            #submit:hover {
                 background-color: #d7eaf7; 
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
        </style>
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
        <form action="insert" method="POST">
            <input type="text" name="id"  required pattern="([0-9])*" style="width:100%;" placeholder="ID"/> <br/>
            <input type="text" name="name"  required pattern="([a-zA-Z ])*" style="width:100%;" placeholder="Name"/> <br/>
            <input type="date" name="dob"  required style="width:100%;" placeholder="Date of birth"/> <br/>
            <input type="text" name="vid"  required pattern="([0-9])*" style="width:100%;" placeholder="Vehicle's ID"/> <br/>
            <input type="text" name="vname"  required pattern="([a-zA-Z ])*" style="width:100%;" placeholder="Vehicle's Name"/> <br/>
            <input type="text" name="color"  required pattern="([a-zA-Z ])*" style="width:100%;" placeholder="Vehicle's Color"/> <br/>
            Class <select name="cid">
                <% for (Classes c : classes) {
                %>
                <option value="<%=c.getId()%>"><%=c.getName()%></option>
                <%}%>
            </select>
            <br/>
            <input id="submit" type="submit" value="Save" style="margin-top: 30px; background-color: cornflowerblue;width: 30%; margin-left: 35%; color:white;"/>
        </form>
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
</html>
