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
            String selectquery="SELECT * FROM `electionsystemdb`.`ElectionTypeTbl` "+
                               " WHERE ElectionTypeID=?";
            PreparedStatement ps;
            ps=conn.prepareCall(selectquery);
            ps.setString(1, ElectionTypeID);
            rst=ps.executeQuery();
            return  rst;
        }catch(Exception ex)
        {
            ex.printStackTrace();
            System.err.println(ex.getMessage());
            Logger.getLogger(UserRegister.class.getName()).log(Level.SEVERE, "Record Not Found !", ex);
            return  rst;
        }
        finally
        {
            return  rst;
        }
    }
}
