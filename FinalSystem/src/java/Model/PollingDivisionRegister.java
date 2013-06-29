/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import  java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author User
 */
public class PollingDivisionRegister extends Dbconnection{
    
    Connection conn =Createconnection();
    
    //this insert function use to insert the district details in to database
    //and this is return a boolean value according to the status
    public boolean InsertPollingDivision(String DivisionID,String DivisionCode,String DivisionName,int RegisterdCandidates,int RegisterdVoters, String DistricID)
    {
        boolean flage=false;
        try
        {
             String query="INSERT INTO `electionsystemdb`.`PollingDivisionTbl` " +
                          "(DivisionID,DivisionCode,DivisionName,CandidatesSeats,RegisterdVoters,DistricID) "+
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
      
    //this function is returning a result set 
    //which is contain the relavent details about the polling divisions
    public ResultSet ViewPollingDivision()
    {
         ResultSet rsltst=null;
         try
         {
            CallableStatement cs=Createconnection().prepareCall("{call GetPollingDiveDetails()}");
            rsltst = cs.executeQuery();
            return rsltst;
         }
         catch(Exception ex)
         {
             ex.toString();
             return rsltst;
         }
     }
      
    public ResultSet LoadPollingDivCombo()
    {
          ResultSet rsltstcombo=null;
        try
        {
           /*CallableStatement cs=conn.prepareCall("{call PollingDivComobo(?)}");
           rsltstcombo = cs.executeQuery();*/
            String slectqry="SELECT DivisionID,DivisionName FROM PollingDivisionTbl";
            PreparedStatement ps=con.prepareStatement(slectqry);
            rsltstcombo=ps.executeQuery();
            return rsltstcombo;
        }
        catch(Exception ex)
        {
            return rsltstcombo;
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
