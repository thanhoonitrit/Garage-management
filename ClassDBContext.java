package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Classes;

/**
 *
 * @author duc21
 */
public class ClassDBContext extends DBContext{
    public ArrayList<Classes> getClasses(){
        ArrayList<Classes> classes = new ArrayList<>();
        try {
            String sql = "select cid, cname from Class";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                Classes c = new Classes();
                c.setId(rs.getInt("cid"));
                c.setName(rs.getString("cname"));
                classes.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClassDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return classes;
    }

    @Override
    public ArrayList all() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Classes get(String name) {
        try {
            String sql = "SELECT cname from Class\n" +
                    "WHERE cname = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, name);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                Classes c = new Classes();
                c.setName(rs.getString("cname"));
                return c;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClassDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    
    public void insert(Classes c) {
        String sql = "INSERT INTO [Class]\n" +
                    "           ([cid]\n" +
                    "           ,[cname])\n" +
                    "     VALUES\n" +
                    "           (?\n" +
                    "           ,?)"; 

        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement(sql);
            stm.setInt(1, c.getId());
            stm.setString(2, c.getName());

            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClassDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            if(stm!=null)
            {
                try {
                    stm.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ClassDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(connection != null)
            {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ClassDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public int getLastID(){
        try {
            String sql = "SELECT TOP 1 cid as idlast\n" +
                    " FROM Class\n" +
                    " ORDER BY CID desc";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            if(rs.next()){
                return rs.getInt("idlast");     
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClassDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    @Override
    public void update(Object model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insert(Object model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
