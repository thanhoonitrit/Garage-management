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
import model.Classes;
import model.Student;
import model.Vehicle;

/**
 *
 * @author duc21
 */
public class EditController extends BaseController {

    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        StudentDBContext studentDB = new StudentDBContext();
        Student student = studentDB.get(id);
        request.setAttribute("student", student);
        
        ClassDBContext clDB = new ClassDBContext();
        ArrayList<Classes> classes = clDB.getClasses();
        request.setAttribute("classes", classes);
        
        request.getRequestDispatcher("/view/edit.jsp").forward(request, response);
    }

    @Override
    protected void processPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         String raw_id = request.getParameter("id");
        String raw_name = request.getParameter("name");
        String raw_dob = request.getParameter("dob");
        String raw_vname = request.getParameter("vname");
        String raw_color = request.getParameter("color");
        String raw_cid = request.getParameter("cid");
        String raw_vid = request.getParameter("vid");

        //processing - validate data
        int id = Integer.parseInt(raw_id);
        String name = raw_name;
        Date dob = Date.valueOf(raw_dob);
        String vname = raw_vname;
        String color = raw_color;
        int cid = Integer.parseInt(raw_cid);
        int vid = Integer.parseInt(raw_vid);

        
        // construct student object
        Classes c = new Classes();
        c.setId(cid);
        Student student = new Student();
        student.setId(id);
        student.setName(name);
        student.setDob(dob);
        Vehicle v = new Vehicle();
        v.setId(vid);
        v.setName(vname);
        v.setColor(color);
        student.setVehicle(v);
        student.setClasses(c);
        
        VehicleDBContext vdb = new VehicleDBContext();
        vdb.update(v);
        StudentDBContext db = new StudentDBContext();
        db.update(student);
        
        //response.getWriter().println("student already added");
        response.sendRedirect("search");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
