package controller.manage;

import controller.auth.BaseController;
import dal.ClassDBContext;
import dal.StudentDBContext;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Account;
import model.Classes;
import model.Student;

/**
 *
 * @author duc21
 */
public class ManageController extends BaseController {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ClassDBContext dbcl = new ClassDBContext();
        ArrayList<Classes> classes = dbcl.getClasses();
        request.setAttribute("classes", classes);
        String raw_id = request.getParameter("id");
        if (raw_id == null || raw_id.length() == 0) {
            raw_id = "-1";
        }
        int id = Integer.parseInt(raw_id);
        StudentDBContext dbStudent = new StudentDBContext();
        ArrayList<Student> students = dbStudent.getStudentByClass(id);
        
        String index_raw = request.getParameter("index");
        if (index_raw == null || index_raw.length() == 0) {
            index_raw = "1";
        }
        int index = Integer.parseInt(index_raw);
        
        
        ArrayList<Student> listpage = dbStudent.getlistpage(index, students);
        request.setAttribute("listpage", listpage);
        request.setAttribute("id", id);
        
        int count = dbStudent.count(id);
        int endPage = count/5;
        if(count % 5 != 0){
            endPage++;
        }
        
        request.setAttribute("endP", endPage);
        
        request.getRequestDispatcher("/view/manager.jsp").forward(request, response);
    }

    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void processPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
