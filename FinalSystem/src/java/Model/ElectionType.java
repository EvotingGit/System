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
public class ElectionType extends Dbconnection {
    
    Connection conn=Createconnection(); 
    
    public ResultSet InsertElectionTypes(String ElectionTypeID,String ElectionTypeCode,String ElectionType,String Year,String Date)
    {
        ResultSet returnset=null;
        try
        {
            String Query="INSERT INTO `electionsystemdb`.`ElectionTypeTbl` "+
                         "(`ElectionTypeID`,`ElectionTypeCode`,`ElectionType`,`Year`,`Date`) "+
                         " VALUES (?,?,?,?,?);";
            
            PreparedStatement prestate=conn.prepareStatement(Query);
            prestate.setString(1, ElectionTypeID);
            prestate.setString(2, ElectionTypeCode);
            prestate.setString(3, ElectionType);
            prestate.setString(4, Year);
            prestate.setString(5, Date);
                        
            int rslt=prestate.executeUpdate();
            if(rslt>0)
            {
                returnset= SelectElectionTypeList(ElectionTypeID);
            }
            return returnset;
            
        }catch(Exception ex)
        {
           return returnset;
        }
    }
    
    public ResultSet  SelectElectionTypeList(String ElectionTypeID)
    {
        ResultSet rst=null;
        try
        {
            
            return  rst;
            
        }catch(Exception ex)
        {
            
        }
        finally
        {
            return  rst;
        }
    }
}
