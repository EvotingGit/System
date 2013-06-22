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
public class ElectionType extends Dbconnection {
    
    Connection conn=Createconnection(); 
    
    public boolean InsertElectionTypes(String ElectionTypeID,String ElectionTypeCode,String ElectionType,String Year)
    {
        boolean flage=false;
        try
        {
            String Query="INSERT INTO `electionsystemdb`.`ElectionTypeTbl` "+
                         "(`ElectionTypeID`,`ElectionTypeCode`,`ElectionType`,`Year`) "+
                         " VALUES (?,?,?,?);";
            
            PreparedStatement prestate=conn.prepareStatement(Query);
            prestate.setString(1, ElectionTypeID);
            prestate.setString(2, ElectionTypeCode);
            prestate.setString(3, ElectionType);
            prestate.setString(4, Year);
          
            int rslt=prestate.executeUpdate();
            if(rslt>0)
                flage=true;
            return flage;
        }catch(Exception ex)
        {
           return flage;
        }
    }
    
     public ResultSet GetElectionTpeList()
     {
         ResultSet rsltst=null;
         try
         {
            CallableStatement cs=Createconnection().prepareCall("{call GetElectionType()}");
            rsltst = cs.executeQuery();
            return rsltst;
         }catch(Exception ex)
         {
            ex.printStackTrace();
            System.err.println(ex.getMessage());
            Logger.getLogger(UserRegister.class.getName()).log(Level.SEVERE, "Record Not Found !", ex);
            return  rsltst;
         }
     }
    
    public ResultSet LoadElectionType()
    {
        ResultSet rsltst=null;
        try
        {
            CallableStatement cs=Createconnection().prepareCall("{call ElectionTypecombo()}");
            rsltst = cs.executeQuery();
            return rsltst;
        }catch(Exception ex)
        {
            ex.printStackTrace();
            System.err.println(ex.getMessage());
            Logger.getLogger(UserRegister.class.getName()).log(Level.SEVERE, "Record Not Found !", ex);
            return  rsltst;
        }
        finally
        {
            return  rsltst;
        }
    }
}
