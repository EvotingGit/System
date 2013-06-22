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
public class DistricRegister extends Dbconnection{
    
    Connection conn=Createconnection();
    
     public boolean InsertDistrict(String DistricID,String DistricCode,String DistricName,String NumberOfPollingDivitions,String ProvinceID)
    {
        boolean flage=false;
        try
        {
             String query="INSERT INTO `electionsystemdb`.`DistricTbl` "+
                          "(DistricID,DistricCode,DistricName,NumberOfPollingDivitions,ProvinceID) "+
                          "VALUES (?,?,?,?,?);";
             
             java.sql.PreparedStatement prestate=conn.prepareStatement(query);
             prestate.setString(1, DistricID);
             prestate.setString(2, DistricCode);
             prestate.setString(3, DistricName);
             prestate.setString(4, NumberOfPollingDivitions);
             prestate.setString(5, ProvinceID);
             
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
     
     public ResultSet ViewDistrict()
     {
         ResultSet rsltst=null;
         try
         {
            String slectqry="select * From `electionsystemdb`.`DistricTbl`";
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
}
