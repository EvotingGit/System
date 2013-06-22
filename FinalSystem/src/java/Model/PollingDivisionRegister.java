/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author User
 */
public class PollingDivisionRegister extends Dbconnection{
    
    Connection conn =Createconnection();
    
      public boolean InsertPollingDivision(String DivisionID,String DivisionCode,String DivisionName,int RegisterdCandidates,int RegisterdVoters, String DistricID)
    {
        boolean flage=false;
        try
        {
             String query="INSERT INTO `electionsystemdb`.`PollingDivisionTbl` " +
                          "(DivisionID,DivisionCode,DivisionName,RegisterdCandidates,RegisterdVoters,DistricID) "+
                          "VALUES (?,?,?,?,?,?);";
             
             java.sql.PreparedStatement prestate=conn.prepareStatement(query);
             prestate.setString(1, DivisionID);
             prestate.setString(2, DivisionCode);
             prestate.setString(3, DivisionName);
             prestate.setInt(4, RegisterdCandidates);
             prestate.setInt(5, RegisterdVoters);
             prestate.setString(6, DistricID);
             
             int result=prestate.executeUpdate();
             if(result>0){
                  flage=true;
                  return flage;
             }
             else{
                  return flage;
             }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            System.err.println(ex.getMessage());
            return flage;
        }
        finally
        {
            return flage;
        }
    }
      
      public ResultSet ViewPollingDivision()
     {
         ResultSet rsltst=null;
         try
         {
            String slectqry="select * From `electionsystemdb`.`PollingDivisionTbl`";
            PreparedStatement ps=con.prepareStatement(slectqry);
            rsltst=ps.executeQuery();
            return rsltst;
         }
         catch(Exception ex)
         {
             ex.toString();
             return rsltst;
         }
     }
      
     public ResultSet LoadDistricCombo()
     {
         ResultSet rsltst=null;
         try
        {
           /* CallableStatement cs=Createconnection().prepareCall("{call CountAsignTask(?)}");
            cs.setString(1, empid);
            rs = cs.executeQuery();*/
            String slectqry="select DistricID,DistricName From  `electionsystemdb`.`DistricTbl`";
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
