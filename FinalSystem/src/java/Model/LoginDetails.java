/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.Md5Encryption;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class LoginDetails extends Dbconnection {
    
    Connection con=Createconnection();
    MailSender mail=new MailSender();
    public boolean insertlogindetl(String UserId,String UserName,String Password, String Post)
    {
       boolean flag=false;
       try
        {
           if(UserId!=null)
           {
            String query="insert into logindetails (UserID,UserName,Password,UserType) values (?,?,?,?)";
            PreparedStatement ps=con.prepareStatement(query);
            ps.setString(1, UserId);
            ps.setString(2, UserName); 
            ps.setString(3, Password);
            ps.setString(4, Post); 

            int rslt=ps.executeUpdate();
            if(rslt>0)
            {
                if(Post!="Voter")
                {
                    String planpass=Md5Encryption.decrypt(Password);
                    mail.SenderegisterSucess(UserName, planpass);
                }
                flag=true;
            }
            return flag;
           }
           else
           {
               Logger.getLogger(UserRegister.class.getName()).log(Level.SEVERE, "No User Id for this user");
           }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            System.err.println(ex.getMessage());
            return flag;
        }
       finally
       {
           return flag;
       }
    }
    
    public ResultSet GetLoginDetails(String username)
    {
       ResultSet rs=null;
        try
        {
            String slectqry="SELECT sysusertbl.UserID,sysusertbl.FirstName, sysusertbl.LastName,logindetails.UserType,logindetails.UserName,`logindetails`.`Password` "+ 
                            " FROM electionsystemdb.logindetails,electionsystemdb.sysusertbl"+
                            " where  logindetails.UserID=sysusertbl.UserID and logindetails.UserName=?";
            PreparedStatement ps=con.prepareStatement(slectqry);
            ps.setString(1, username);
            rs=ps.executeQuery();
            return  rs;
        }
        catch(Exception ex)
        {
            Logger.getLogger(UserRegister.class.getName()).log(Level.SEVERE, "Password incorrect ", ex);
            return rs;
        } 
    }
   
}
