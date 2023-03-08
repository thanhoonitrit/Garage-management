package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Classes;
import model.Student;
import model.Vehicle;

/**
 *
 * @author duc21
 */
public class StudentDBContext extends DBContext<Student> {

    public ArrayList<Student> getStudentByClass(int cid) {
        ArrayList<Student> students = new ArrayList<>();
        try {
            String sql = "SELECT s.sid, s.sname, s.dob, v.vid, v.vname, v.color, c.cid, c.cname FROM Student s INNER JOIN Class c ON s.cid = c.cid\n" +
"                    INNER JOIN Vehicle v ON s.vid = v.vid";
            if (cid > -1) {
                sql += " WHERE c.cid = ?";
            }
            PreparedStatement stm = connection.prepareStatement(sql);

            if (cid > -1) {
                stm.setInt(1, cid);
            }
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Student s = new Student();
                Classes c = new Classes();
                Vehicle v = new Vehicle();
                s.setId(rs.getInt("sid"));
                s.setName(rs.getString("sname"));
                s.setDob(rs.getDate("dob"));
                c.setId(rs.getInt("cid"));
                c.setName(rs.getString("cname"));
                v.setId(rs.getInt("vid"));
                v.setName(rs.getString("vname"));
                v.setColor(rs.getString("color"));
                s.setClasses(c);
                s.setVehicle(v);
                students.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return students;
    }
    
    @Override
    public ArrayList<Student> all() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
    @Override
    public void insert(Student s) {
        String sql = "INSERT INTO [Student]\n" +
                    "           ([sid]\n" +
                    "           ,[sname]\n" +
                    "           ,[dob]\n" +
                    "           ,[cid]\n" +
                    "           ,[vid])\n" +
                    "     VALUES\n" +
                    "           (?\n" +
                    "           ,?\n" +
                    "           ,?\n" +
                    "           ,?\n" +
                    "           ,?)"; 

        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement(sql);
            stm.setInt(1, s.getId());
            stm.setString(2, s.getName());
            stm.setDate(3, s.getDob());
            stm.setInt(4, s.getClasses().getId());
            stm.setInt(5, s.getVehicle().getId());

            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            if(stm!=null)
            {
                try {
                    stm.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(connection != null)
            {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void update(Student s) {
        String sql = "UPDATE [Student]\n" +
                            "   SET [sname] = ?\n" +
                            "      ,[dob] = ?\n" +
                            "      ,[cid] = ?\n" +
                            " WHERE [sid] = ?";
        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement(sql);
            stm.setInt(4, s.getId());
            stm.setString(1, s.getName());
            stm.setDate(2, s.getDob());
            stm.setInt(3, s.getClasses().getId());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            if(stm!=null)
            {
                try {
                    stm.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(connection != null)
            {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE Student" +
                     " WHERE [sid] = ?";
        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            if(stm!=null)
            {
                try {
                    stm.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(connection != null)
            {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    
    public Student get(int id, int cid) {
        try {
            String sql = "SELECT s.sid, s.sname, s.dob, s.vid, c.cid, c.cname FROM Student s INNER JOIN Class c ON s.cid = c.cid\n" +
                    "WHERE s.sid = ? and c.cid = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            stm.setInt(2, cid);
            ResultSet rs = stm.executeQuery();
            if(rs.next()){
                Student s = new Student();
                s.setId(rs.getInt("sid"));
                s.setName(rs.getString("sname"));
                s.setDob(rs.getDate("dob"));
                s.setCid(rs.getInt("cid"));
                s.setVid(rs.getInt("vid"));
                return s;
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Student get(int id) {
        try {
            String sql = "SELECT s.sid, s.sname, s.dob, v.vid, v.vname, v.color, c.cid, c.cname  FROM Vehicle v INNER JOIN Student s ON v.vid = s.vid \n" +
"                       INNER JOIN Class c ON s.cid = c.cid\n" +
"                        WHERE s.sid = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            
            ResultSet rs = stm.executeQuery();
            if(rs.next())
            {
                Student s = new Student();
                Vehicle v = new Vehicle();
                Classes c = new Classes();
                
                s.setId(rs.getInt("sid"));
                s.setName(rs.getString("sname"));
                s.setDob(rs.getDate("dob"));
                v.setId(rs.getInt("vid"));
                v.setName(rs.getString("vname"));
                v.setColor(rs.getString("color"));
                c.setId(rs.getInt("cid"));
                c.setName(rs.getString("cname"));

                s.setClasses(c);
                s.setVehicle(v);
                return s;
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public int count(int cid)
    {
        try {
            String sql = "SELECT count(*) as Total FROM Student";
             if (cid > -1) {
                sql += " WHERE cid = ?";
            }
            PreparedStatement stm = connection.prepareStatement(sql);
            if (cid > -1) {
                stm.setInt(1, cid);
            }
            ResultSet rs = stm.executeQuery();
            if(rs.next())
            {
                return rs.getInt("Total");
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    
    
    public ArrayList<Student> getlistpage(int page,ArrayList<Student> ar){
        ArrayList<Student> a=new ArrayList<>();
        for(int i=0;i<ar.size();i++){
            if(i>=((page-1)*5)&&i<(page*5))
                a.add(ar.get(i));
        }
        return a;
    }
}
