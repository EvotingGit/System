/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;

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
    
    
}
