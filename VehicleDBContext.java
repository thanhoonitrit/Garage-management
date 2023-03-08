package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;
import model.Classes;
import model.Student;
import model.Vehicle;

/**
 *
 * @author duc21
 */
public class VehicleDBContext extends DBContext<Vehicle>{

    @Override
    public ArrayList<Vehicle> all() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public Vehicle get(int vid, int cid) {
        try {
            String sql = "SELECT s.sid, s.sname, s.dob, v.vid, v.vname, v.color, c.cid, c.cname  FROM Vehicle v INNER JOIN Student s ON v.vid = s.vid \n" +
"                       INNER JOIN Class c ON s.cid = c.cid\n" +
"                        WHERE v.vid = ? and c.cid = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, vid);
            stm.setInt(2, cid);


            ResultSet rs = stm.executeQuery();
            if(rs.next()) {
                Vehicle v = new Vehicle();
               
                v.setId(rs.getInt("vid"));
                v.setName(rs.getString("vname"));
                v.setColor(rs.getString("color"));
                return v;
            }
        } catch (SQLException ex) {
            Logger.getLogger(VehicleDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void insert(Vehicle v) {
        String sql = "INSERT INTO [Vehicle]\n" +
                    "           ([vid]\n" +
                    "           ,[vname]\n" +
                    "           ,[color])\n" +
                    "     VALUES\n" +
                    "           (?\n" +
                    "           ,?\n" +
                    "           ,?)";
        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement(sql);
            stm.setInt(1, v.getId());
            stm.setString(2, v.getName());
            stm.setString(3, v.getColor());

            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(VehicleDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            if(stm!=null)
            {
                try {
                    stm.close();
                } catch (SQLException ex) {
                    Logger.getLogger(VehicleDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(connection != null)
            {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(VehicleDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void update(Vehicle v) {
        String sql = "UPDATE [Vehicle]\n" +
                            "   SET [vname] = ?\n" +
                            "      ,[color] = ?\n" +
                            " WHERE [vid] = ?";
        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement(sql);
            stm.setInt(3, v.getId());
            stm.setString(1, v.getName());
            stm.setString(2, v.getColor());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(VehicleDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            if(stm!=null)
            {
                try {
                    stm.close();
                } catch (SQLException ex) {
                    Logger.getLogger(VehicleDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(connection != null)
            {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(VehicleDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void delete(int vid) {
        String sql = "DELETE Vehicle" +
                     " WHERE [vid] = ?";
        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement(sql);
            stm.setInt(1, vid);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(VehicleDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            if(stm!=null)
            {
                try {
                    stm.close();
                } catch (SQLException ex) {
                    Logger.getLogger(VehicleDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(connection != null)
            {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(VehicleDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public Vehicle get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
