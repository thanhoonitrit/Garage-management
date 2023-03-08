package controller.manage;

import controller.auth.BaseController;
import dal.StudentDBContext;
import dal.VehicleDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author duc21
 */
public class DeleteController extends BaseController {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int vid = Integer.parseInt(request.getParameter("vid"));

        StudentDBContext db = new StudentDBContext();
        db.delete(id);
        VehicleDBContext vhdb = new VehicleDBContext();
        vhdb.delete(vid);
        response.sendRedirect("search");
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
    }

}
