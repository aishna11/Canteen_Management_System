package db;
import java.sql.*;
import javax.swing.JOptionPane;


/**
 *
 * @author aishna
 */
public class db_connection {
    public static Connection c;
    public static Statement st ;
    public static String NAME ;
    public static PreparedStatement deleteName,getName,createnewaccount,insertfoodItem,updatepass,entermess;
    static{
        try{
    Class.forName("com.mysql.jdbc.Driver");
    c=DriverManager.getConnection("jdbc:mysql://localhost:3306/canteen","root","gail2790");
    st = c.createStatement();
    getName=c.prepareStatement("select * from foodItem  where name like ?");
    createnewaccount=c.prepareStatement("insert into login_db (username,pass) values(?,?)");
    insertfoodItem=c.prepareStatement("insert into foodItem (Name,Price,Quantity) values(?,?,?)");
    updatepass=c.prepareStatement("update login_db set pass=?  where pass=?");
    entermess=c.prepareStatement("select * from mess_schedule where sr like ?");
    }catch(Exception ex){
            JOptionPane.showMessageDialog(null,ex+"mxla");
        }
    }
    static public void dbClose(){
        try{
            c.close();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,ex);
        }
    }

}
