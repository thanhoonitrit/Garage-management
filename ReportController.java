package controller.report;

import controller.auth.BaseController;
import dal.ReportDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Report;

/**
 *
 * @author duc21
 */
public class ReportController extends BaseController {

    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ReportDBContext rpdb = new ReportDBContext();
        ArrayList<Report> reports = rpdb.all();
        
        String index_raw = request.getParameter("index2");
        if (index_raw == null || index_raw.length() == 0) {
            index_raw = "1";
        }
        int index = Integer.parseInt(index_raw);
        
        
        ArrayList<Report> listpage = rpdb.getlistpage(index, reports);
        request.setAttribute("listpage", listpage);
        
        int count = rpdb.count();
        int endPage = count/5;
        if(count % 5 != 0){
            endPage++;
        }
        
        request.setAttribute("endP", endPage);
        
        request.getRequestDispatcher("/view/report.jsp").forward(request, response);
    }

    @Override
    protected void processPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String report = request.getParameter("report");
        Report r = new Report();
        r.setContent(report);
        ReportDBContext rpdb = new ReportDBContext();
        rpdb.insert(r);
        response.sendRedirect("report");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
