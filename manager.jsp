<%-- 
    Document   : manager
    Created on : Feb 28, 2022, 9:55:40 PM
    Author     : duc21
--%>

<%@page import="model.Account"%>
<%@page import="model.Student"%>
<%@page import="model.Classes"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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
        <%  ArrayList<Classes> classes = (ArrayList<Classes>)request.getAttribute("classes");
            ArrayList<Student> students = (ArrayList<Student>)request.getAttribute("listpage");
            int id = (Integer)request.getAttribute("id");
            Account account = (Account)request.getSession().getAttribute("account");
            int endP = (Integer)request.getAttribute("endP");
        %>
        <script>
            function submitForm()
            {
                document.getElementById("searchForm").submit();
            }
            
            function deleteStudent(id, vid)
            {
                var result = confirm("Are you sure?");
                if(result)
                {
                    window.location.href = "delete?id=" + id + "&vid=" + vid;
                }
            }
        </script>
    </head>
    <body>
        <style>
            .cotainer {
                height: 600px;
                margin-left: 400px;
                margin-top: 100px;
                font-size: 18px;
                font-weight: bolder;
            }
            .cotainer table {
                width: 80%;
                height: 60%;
                margin-bottom: 30px;
            }
            .cotainer a {
                text-decoration: none;
                background-color: #d7eaf7;
                padding: 3px;
                border-radius: 10px;
            }
            
            .insert {
                margin-top: 5px;
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
option {
    background-color: #87CEFA;
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
                <form  method="GET" id="searchForm"> 
                Class <select name="id" onchange="submitForm();">
                <option value="-1" >Please select a Class</option>
                <% for (Classes d : classes) {
                %>
                <option 
                    <%=(d.getId()==id)?"selected=\"selected\"":""%>
                    value="<%=d.getId()%>" ><%=d.getName()%></option>
                <%}%>
            </select>
        </form>
        <form action="addclass" method="GET">
        <input id="submit" type="submit" value="Add Class" style="margin-top: 30px"/> <input type="text" name="nameclass"  required pattern="([0-9a-zA-Z ])*"/>
        </form>
        <br/>
        <table border="2px">
            <tr style="border-bottom: 2px solid black;">
                <td >Id</td>
                <td>Name</td>
                <td>Dob</td>
                <td>Vehicle's ID</td>
                <td>Vehicle's Name</td>
                <td>Vehicle's Color</td>
                <td></td>
            </tr>
            <% for (Student s : students) {
            %>
            <tr>
                <td style="border-bottom: 2px solid black;"><%=s.getId() %></td>
                <td style="border-bottom: 2px solid black;"><%=s.getName()%></td>
                <td style="border-bottom: 2px solid black;"><%=s.getDob()%></td>
                <td style="border-bottom: 2px solid black;"><%=s.getVehicle().getId() %></td>
                <td style="border-bottom: 2px solid black;"><%=s.getVehicle().getName()%></td>
                <td style="border-bottom: 2px solid black;"><%=s.getVehicle().getColor()%></td>
                <td style="border-bottom: 2px solid black;"><a href="edit?id=<%=s.getId()%>">Edit</a>
                    <a href="#" onclick="deleteStudent(<%=s.getId()%>, <%=s.getVehicle().getId()%>)">Delete</a>
                </td>
            </tr>
            <%}%>
        </table> 
        Page: <% for (int i = 1; i <= endP; i++) {
            %>
            <a href="search?index=<%=i%>&id=<%=id%>"><%=i%></a>
            <%}%> <br/>
        <a class="insert" href="insert">Insert</a>
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
