/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.test;
import java.net.ConnectException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class UserRegister extends Dbconnection {
    
    Connection conn=Createconnection(); 
    public ResultSet GetuserdetailsbyID(String UserCode,String  UserID)
    {
       ResultSet rs=null;
        try
        {
            String slectqry="SELECT `sysusertbl`.`UserID`,`sysusertbl`.`UserType`"+
                            " FROM `electionsystemdb`.`sysusertbl` where  UserCode=? and UserID=?";
              
            PreparedStatement ps=con.prepareStatement(slectqry);
            ps.setString(1, UserCode);
            ps.setString(2, UserID);
            rs=ps.executeQuery();
            return  rs;
        }
        catch(Exception ex)
        {
            Logger.getLogger(UserRegister.class.getName()).log(Level.SEVERE, "Record Not Found !", ex);
            return rs;
        } 
    }

    public ResultSet insertUserdetails(String UserId,String userCode, String usertype, String fistname, String lstname, String gender, String birthdy, String mbno, String lndno, String nic, String email, byte[] image, String createdby, String createddate, String updatedby, String updateddate) {
        ResultSet Rset=null;
        
        try
        {
           if(UserId!=null && userCode!=null)
           {
                String query="INSERT INTO `electionsystemdb`.`sysusertbl` "+
                         " (UserId,UserCode,UserType,FirstName,LastName,Gender, DateofBirth,MobileNo,LandNo,NIC_No,Email,Image, CreatedBy,CreatedDate,UpdatedBy, UpdatedDate) "+ 
                         " values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            
            PreparedStatement prestate=conn.prepareStatement(query);
            prestate.setString(1, UserId);
            prestate.setString(2, userCode);
            prestate.setString(3, usertype);
            prestate.setString(4, fistname);
            prestate.setString(5, lstname);
            prestate.setString(6, gender);
            prestate.setString(7, birthdy);
            prestate.setString(8, mbno);
            prestate.setString(9, lndno);
            prestate.setString(10, nic);
            prestate.setString(11,email);
            prestate.setBytes(12, image);
            prestate.setString(13, createdby);
            prestate.setString(14, createddate);
            prestate.setString(15, updatedby);
            prestate.setString(16, updateddate);
          
            int rslt=prestate.executeUpdate();
            if(rslt>0)
            {
                Rset=GetuserdetailsbyID(userCode,UserId);
                return  Rset;
            }
           }
           else
           {
               Logger.getLogger(UserRegister.class.getName()).log(Level.SEVERE, "User Code nd User ID is missing");
           }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            System.err.println(ex.getMessage());
            Logger.getLogger(UserRegister.class.getName()).log(Level.SEVERE, "User Registration Fail, Please Try again !", ex);
            return Rset;
        }
        finally
        {
        return Rset;
        }
    }
    
    public ResultSet GetUserProPicture() {
        try
        {
            ResultSet rs=null;
            String slectqry="SELECT Image from sysusertbl";
            java.sql.PreparedStatement ps=conn.prepareStatement(slectqry);
            rs = ps.executeQuery(slectqry);        
            return rs;
        }
        catch(Exception ex){
        throw new UnsupportedOperationException("Not yet implemented");
        }
    }
    
}
