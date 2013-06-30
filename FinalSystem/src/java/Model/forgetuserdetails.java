/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.Md5Encryption;
import com.mysql.jdbc.PreparedStatement;
import java.sql.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class forgetuserdetails extends Dbconnection {
   
    MailSender mail=new MailSender();
    Connection conn=Createconnection();
   public ResultSet Getforgetuserlogin(String _useremail,String _username)
   {
      ResultSet rsltst=null;     
        try
        {
//            CallableStatement cs=Createconnection().prepareCall("{call ChekForgetdetails(?,?)}");
//            cs.setString(1, _username);  
//            cs.setString(2, _useremail);
//            rsltst=cs.executeQuery();
            String Query="SELECT  sysusertbl.Email,logindetails.UserName,logindetails.Password "+
                         " FROM   `electionsystemdb`.`sysusertbl`, `electionsystemdb`.`logindetails`"+
                         " WHERE  logindetails.UserID=sysusertbl.UserID "+
			 " AND logindetails.UserName=? AND sysusertbl.Email=?";
            
            java.sql.PreparedStatement prestate=conn.prepareStatement(Query);
            prestate.setString(1,_username);
            prestate.setString(2, _useremail);
            rsltst=prestate.executeQuery();
            return rsltst;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            System.err.println(ex.getMessage());
            Logger.getLogger(UserRegister.class.getName()).log(Level.SEVERE, "Invalid Details Provided!", ex);
            return rsltst;  
        }
        finally
        {
           //return rsltst;
        }
   }
}
