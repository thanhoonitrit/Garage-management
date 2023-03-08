package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Report;

/**
 *
 * @author duc21
 */
public class ReportDBContext extends DBContext<Report>{

    @Override
    public ArrayList<Report> all() {
        ArrayList<Report> reports = new ArrayList<>();
        try {
            String sql = "select content from Report";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                Report r = new Report();
                r.setContent(rs.getString("content"));
                reports.add(r);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReportDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return reports;
    }

    @Override
    public Report get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insert(Report r) {
        String sql = "INSERT INTO [Report]\n" +
                    "           ([content])\n" +
                    "     VALUES\n" +
                    "           (?)";
        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement(sql);
            stm.setString(1, r.getContent());

            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ReportDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            if(stm!=null)
            {
                try {
                    stm.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ReportDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(connection != null)
            {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ReportDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void update(Report model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public int count()
    {
        try {
            String sql = "SELECT count(*) as Total FROM Report";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            if(rs.next())
            {
                return rs.getInt("Total");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReportDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    
    
    public ArrayList<Report> getlistpage(int page,ArrayList<Report> ar){
        ArrayList<Report> a=new ArrayList<>();
        for(int i=0;i<ar.size();i++){
            if(i>=((page-1)*5)&&i<(page*5))
                a.add(ar.get(i));
        }
        return a;
    }
    
}
