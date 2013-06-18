/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.sql.*;
/**
 *
 * @author User
 */
public class Dbconnection {
    Connection con=null;
    
    public Connection Createconnection()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/electionsystemdb","root","");
            return con;
        }
        catch(Exception ex)
        {
            con=null;
            ex.printStackTrace();
            System.err.println(ex.getMessage());
            return con;
        }
    }
}
