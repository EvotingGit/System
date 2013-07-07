/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.*;
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
     
     public boolean UpdateVoterStatus(String UseId, byte status)
     {
         
         boolean flage=false;
         try{
            CallableStatement cs=Createconnection().prepareCall("{call UpdateStatus(?,?)}");
            cs.setString(1, UseId);
            cs.setByte(2,status);
            int rslt=cs.executeUpdate();
            if(rslt>0){
                    return flage=true;
            }
            return flage;
         }
         catch(SQLException sqlex)
         {
            sqlex.printStackTrace();
            System.err.println(sqlex.getMessage());
            Logger.getLogger(UserRegister.class.getName()).log(Level.SEVERE, "Connection Error !", sqlex);
            return flage;
        }
        catch(Exception ext)
        {
            ext.printStackTrace();
            System.err.println(ext.getMessage());
            Logger.getLogger(UserRegister.class.getName()).log(Level.SEVERE, "Record Not Updated !", ext);
            return flage; 
        }
     }
     
     public boolean Isvotedbefore(String UseId){
          boolean flage=false;
          ResultSet rsltst=null;
          
         try{
            CallableStatement cs=Createconnection().prepareCall("{call Isvoted(?)}");
            cs.setString(1, UseId);
            rsltst = cs.executeQuery();
            while(rsltst.next()){
                  byte status=rsltst.getByte(1); 
                  if(status==1){
                      return flage=true;
                  }
            }
            return flage;
         }
         catch(SQLException sqlex)
         {
            sqlex.printStackTrace();
            System.err.println(sqlex.getMessage());
            Logger.getLogger(UserRegister.class.getName()).log(Level.SEVERE, "Connection Error !", sqlex);
            return flage;
        }
        catch(Exception ext)
        {
            ext.printStackTrace();
            System.err.println(ext.getMessage());
            Logger.getLogger(UserRegister.class.getName()).log(Level.SEVERE, "Record Not Updated !", ext);
            return flage; 
        }
     }
    
}
