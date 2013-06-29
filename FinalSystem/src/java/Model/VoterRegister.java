/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class VoterRegister  extends UserRegister{
    Connection conn=Createconnection(); 
    
    public boolean InsertVoterDetails(String UserId,String ElectionCrdNo,String poldivID,String stats,String createdby,String createddate,String updatedby,String updateddate,String post)
    {
        boolean flage=false;
        String polipartyID="";
        try
        {
            String Query="INSERT INTO `electionsystemdb`.`VoterDetailTbl` "+
                         "(UserID,ElectionCardNo,DivisionID,`Status`,CreatedBy,CreatedDate,UpdateDate,UpdatedBy,PoliPartyID) "+
                         " VALUES (?,?,?,?,?,?,?,?,?);";
            
            PreparedStatement prestate=conn.prepareStatement(Query);
            prestate.setString(1, UserId);
            prestate.setString(2, ElectionCrdNo);
            prestate.setString(3, poldivID);
            prestate.setString(4, stats);
            prestate.setString(5, createdby);
            prestate.setString(6, createddate);
            prestate.setString(7, updatedby);
            prestate.setString(8, updateddate);
            prestate.setString(9, polipartyID);
            int rslt=prestate.executeUpdate();
            if(rslt>0)
            {
               flage=true;
            }
            else
            {
                    flage=false;
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
    //this function reslt set get the login details based on the nice no
     public ResultSet GetvoterLoginDetails(String loginnic,String polingDivid)
    {
        
     ResultSet rsltst=null;
        try
        {
            CallableStatement cs=Createconnection().prepareCall("{call voterLogin(?,?)}");
            cs.setString(1, loginnic);
            cs.setString(2,polingDivid);
            rsltst = cs.executeQuery();
            return rsltst;
        }
        catch(Exception ex)
        {
            Logger.getLogger(UserRegister.class.getName()).log(Level.SEVERE, "Password incorrect ", ex);
            return rsltst;
        } 
    }
    
}
