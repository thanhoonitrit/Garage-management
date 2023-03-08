package controller.auth;

import com.sun.java.swing.plaf.windows.resources.windows;
import dal.AccountDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Account;

/**
 *
 * @author duc21
 */
public class SigninController extends HttpServlet {


   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        AccountDBContext acdb = new AccountDBContext();
        Account account = acdb.getAccount(username, password);
        if (account == null) {
            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>\n" +
                "<head>\n" +
                "    <title>Quan ly nha xe</title>\n" +
                "    <link rel=\"icon\" href=\"/pic/logo.png\" type=\"image/x-icon\" />\n" +
                "    <meta charset=\"utf-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width\" />\n" +
                "</head>\n" +
                "<html>\n" +
                "    <style>\n" +
                "        html {\n" +
                "            color: red;\n" +
                "            font-size: 20px;\n" +
                "    background-color: #d7eaf7;\n" +
                "            \n" +
                "            font-family: Arial, Helvetica, sans-serif;\n" +
                "        }\n" +
                "        .cover {\n" +
                "            display: inline-block;\n" +
                "        position: fixed;\n" +
                "        top: 0;\n" +
                "        bottom: 0;\n" +
                "         left: 0;\n" +
                "         right: 0;\n" +
                "         width: 300px;\n" +
                "        height: 300px;\n" +
                "         margin: auto;\n" +
                "        background-color: rgb(134, 148, 147);\n" +
                "        }\n" +
                "        button {\n" +
                "            margin-left: 70px;\n" +
                "        }\n" +
                "        p {\n" +
                "            margin-top: 100px;\n" +
                "            margin-left: 20px;\n" +
                "        }\n" +
                "        .header {\n" +
                "    width: 100vw;\n" +
                "    height: 150px;\n" +
                "    display: flex;\n" +
                "    background-color: #d7eaf7;\n" +
                "}\n" +
                "\n" +
                "        .header-img {\n" +
                "            width: 15%;\n" +
                "        }\n" +
                "\n" +
                "        .header-nav {\n" +
                "            width: 70%;\n" +
                "        }\n" +
                "\n" +
                "        .header-nav ul{\n" +
                "            display: flex;\n" +
                "            margin-top: 50px;\n" +
                "            width: 100%;\n" +
                "        }\n" +
                "\n" +
                "        .header-nav ul li{\n" +
                "            list-style-type: none;\n" +
                "            width: 16%;\n" +
                "        }\n" +
                "\n" +
                "        .header-nav ul li a:hover {\n" +
                "            background-color:#94caee;\n" +
                "        }\n" +
                "\n" +
                "        .header-nav ul li a {\n" +
                "            color: #045056;\n" +
                "            font-size: 20px;\n" +
                "            text-decoration: none;\n" +
                "            background-color: #c4b897;\n" +
                "            padding: 7px;\n" +
                "            border-radius: 10px;\n" +
                "\n" +
                "        }\n" +
                "        \n" +
                "    </style>\n" +
                "<body>\n" +
                "    <div class=\"header\">\n" +
                "        <div class=\"header-img\">\n" +
                "            <img src=\"./pic/logo.png\" width=\"150px\" height=\"100px\" alt=\"\">\n" +
                "        </div>\n" +
                "        <div class=\"header-nav\">\n" +
                "            \n" +
                "        </div>\n" +
                "    </div>\n" +
                "    <div class=\"cover\">\n" +
                "    <p>Tên đăng nhập hoặc mật khẩu sai !</p>\n" +
                "  <button type=\"button\" onclick=\"quay_lai_trang_truoc()\">Quay lại trang trước</button>\n" +
                "</div>" +
                "  <script>\n" +
                "      function quay_lai_trang_truoc(){\n" +
                "          history.back();\n" +
                "      }\n" +
                "  </script>\n" +
                "\n" +
                "</body>\n" +
                "</html>");
            }
        } else {
            
                request.getSession().setAttribute("account", account);
                request.getRequestDispatcher("/view/welcome.jsp").forward(request, response);
            
        }
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
