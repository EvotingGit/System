/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class Sectary extends UserRegister {
    
     Connection conn=Createconnection(); 
   
    public boolean InsertSectaryDetails(String UserID,String regparty,String createdby,String createddate,String updatedby,String updateddate,String UserName, String Password, String Post)
    {
         boolean flage=false;
         try
         {
            String query="INSERT INTO `electionsystemdb`.`SectaryTble` "+
                         "(UserID,RegsterPoliticalParty,CreatedBy,CreatedDate,UpdatedBy,UpdatedDate) "+ 
                         "VALUES (?,?,?,?,?,?);";
            
            PreparedStatement prestate=conn.prepareStatement(query);
            prestate.setString(1, UserID);
            prestate.setString(2, regparty);
            prestate.setString(3, createdby);
            prestate.setString(4, createddate);
            prestate.setString(5, updatedby);
            prestate.setString(6, updateddate);
            
            int rslt=prestate.executeUpdate();
            if(rslt>0)
            {
                LoginDetails userlogin=new LoginDetails();
                boolean loginrslt=userlogin.insertlogindetl(UserID,UserName,Password, Post);
                if(loginrslt==true)
                {
                    flage=true;
                }else
                {
                    flage=false;
                }
                return flage;
            }
         }
         catch(Exception ex)
         { 
            ex.printStackTrace();
            System.err.println(ex.getMessage());
            Logger.getLogger(UserRegister.class.getName()).log(Level.SEVERE, "Record Not Found !", ex);
            return flage;
        }
        finally
        {
            return flage;
        }
    }
    
     public ResultSet LoadSectrycombo()
     {
         ResultSet rsltst=null;
         try
        {
           /* CallableStatement cs=Createconnection().prepareCall("{call CountAsignTask(?)}");
            cs.setString(1, empid);
            rs = cs.executeQuery();*/
            String slectqry="select UserID,FirstName From `electionsystemdb`.`DistricTbl` WHERE UserType=(?) AND RegsterPoliticalParty=(?) ";
            PreparedStatement ps=con.prepareStatement(slectqry);
            rsltst=ps.executeQuery();
            
            return rsltst;
        }
        catch(Exception ex)
        {
            return rsltst;
        }
     }
    
}
