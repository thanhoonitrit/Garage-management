package controller.manage;

import dal.ClassDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Classes;

/**
 *
 * @author duc21
 */
public class AddClassController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nameclass = request.getParameter("nameclass");
        ClassDBContext cbd = new ClassDBContext();
        int lastID = cbd.getLastID();
        Classes classes = cbd.get(nameclass);
        if(classes != null){
            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>\n"
                        + "<html>\n"
                        + "    <style>\n"
                        + "        html {\n"
                        + "            background-color: #9ebed3;\n"
                        + "            color: red;\n"
                        + "            font-size: 20px;\n"
                        + "            font-weight: 700;\n"
                        + "            font-family: Arial, Helvetica, sans-serif;\n"
                        + "        }\n"
                        + "        .cover {\n"
                        + "            display: inline-block;\n"
                        + "        position: fixed;\n"
                        + "        top: 0;\n"
                        + "        bottom: 0;\n"
                        + "         left: 0;\n"
                        + "         right: 0;\n"
                        + "         width: 300px;\n"
                        + "        height: 300px;\n"
                        + "         margin: auto;\n"
                        + "        background-color: rgb(134, 148, 147);\n"
                        + "        }\n"
                        + "        button {\n"
                        + "            margin-left: 70px;\n"
                        + "        }\n"
                        + "        p {\n"
                        + "            margin-top: 100px;\n"
                        + "            margin-left: 20px;\n"
                        + "        }\n"
                        + "    </style>\n"
                        + "<body>\n"
                        + "    <div class=\"cover\">\n"
                        + "    <p>Tên class đã trùng, vui lòng nhập lại!</p>\n"
                        + "  <button type=\"button\" onclick=\"quay_lai_trang_truoc()\">Quay lại trang trước</button>\n"
                        + "</div>\n"
                        + "  <script>\n"
                        + "      function quay_lai_trang_truoc(){\n"
                        + "          history.back();\n"
                        + "      }\n"
                        + "  </script>\n"
                        + "\n"
                        + "</body>\n"
                        + "</html>");
            }
        }else {
            Classes c = new Classes();
            c.setId(lastID+1);
            c.setName(nameclass);
            cbd.insert(c);
            response.sendRedirect("search");
        }
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
