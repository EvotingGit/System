/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class VoterRegister  extends UserRegister{
    Connection conn=Createconnection(); 
    
    public boolean InsertVoterDetails(String UserId,String ElectionCrdNo,String poldiv,String stats,String createdby,String createddate,String updatedby,String updateddate,String voterpass,String post)
    {
        boolean flage=false;
        try
        {
            String Query="INSERT INTO `electionsystemdb`.`VoterDetailTbl` "+
                         "(UserID,ElectionCardNo,pollingDivision,`Status`,CreatedBy,CreatedDate,UpdateDate,UpdatedBy) "+
                         " VALUES (?,?,?,?,?,?,?,?);";
            
            PreparedStatement prestate=conn.prepareStatement(Query);
            prestate.setString(1, UserId);
            prestate.setString(2, ElectionCrdNo);
            prestate.setString(3, poldiv);
            prestate.setString(4, stats);
            prestate.setString(5, createdby);
            prestate.setString(6, createddate);
            prestate.setString(7, updatedby);
            prestate.setString(8, updateddate);
            
            int rslt=prestate.executeUpdate();
            if(rslt>0)
            {
                LoginDetails userlogin=new LoginDetails();
                boolean loginrslt=userlogin.insertlogindetl(UserId,ElectionCrdNo,voterpass, post);
                  if(loginrslt==true)
                {
                    flage=true;
                }else
                {
                    flage=false;
                }
                return flage;
            }
            
        }catch(Exception ex)
        {
            
            ex.printStackTrace();
            System.err.println(ex.getMessage());
            Logger.getLogger(UserRegister.class.getName()).log(Level.SEVERE, "Voter Loging Details Incomplete !", ex);
            return flage;
        }
        finally
        {
            return flage;
        }
    }
    
}
