package controller.manage;

import controller.auth.BaseController;
import dal.ClassDBContext;
import dal.StudentDBContext;
import dal.VehicleDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Account;
import model.Classes;
import model.Student;
import model.Vehicle;

/**
 *
 * @author duc21
 */
public class InsertController extends BaseController {

 

  
    @Override
     protected void processGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ClassDBContext db = new ClassDBContext();
        ArrayList<Classes> classes = db.getClasses();
        request.setAttribute("classes", classes);
        request.getRequestDispatcher("/view/insert.jsp").forward(request, response);
    }

    @Override
    protected void processPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String raw_id = request.getParameter("id");
        String raw_name = request.getParameter("name");
        String raw_dob = request.getParameter("dob");
        String raw_vid = request.getParameter("vid");
        String raw_vname = request.getParameter("vname");
        String raw_color = request.getParameter("color");
        String raw_cid = request.getParameter("cid");
        
        //processing - validate data
        int cid = Integer.parseInt(raw_cid);
        int id = Integer.parseInt(raw_id);
        StudentDBContext stdb = new StudentDBContext();
        Student s = stdb.get(id, cid);
        int vid = Integer.parseInt(raw_vid);    
        VehicleDBContext vhdb = new VehicleDBContext();
        Vehicle v = vhdb.get(vid,cid);
        if(s != null || v != null){
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
                        + "    <p>ID đã bị trùng, vui lòng nhập lại!</p>\n"
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
        String name = raw_name;
        Date dob = Date.valueOf(raw_dob);
        String vname = raw_vname;
        String color = raw_color;


        
        // construct student object
        Classes c = new Classes();
        c.setId(cid);

        Vehicle v1 = new Vehicle();
        v1.setId(vid);
        v1.setName(vname);
        v1.setColor(color);
        
        Student student = new Student();
        student.setId(id);
        student.setName(name);
        student.setDob(dob);
        student.setCid(cid);
        student.setVid(vid);

        student.setClasses(c);
        student.setVehicle(v1);

        vhdb.insert(v1);
        stdb.insert(student);
        
        //response.getWriter().println("student already added");
        response.sendRedirect("search");
        
        }
        

        
        }
        
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
