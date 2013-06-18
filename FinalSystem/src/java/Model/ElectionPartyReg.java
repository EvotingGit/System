/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.*;

/**
 *
 * @author User
 */
public class ElectionPartyReg extends Dbconnection{
    
    Connection conn=Createconnection();
    
   public boolean InsertElecitonPartyDetaisl(String ElectioPcode, String ElectionPName, String RegisterDate, byte[] Logo, String SectryID, int CandiCount) throws SQLException {
         boolean flage=false;
        try
        {
            String query="";
            
            PreparedStatement prestate=conn.prepareStatement(query);
            
            prestate.setString(1, ElectioPcode);
            prestate.setString(2, ElectionPName);
            prestate.setString(3, RegisterDate);
            prestate.setBytes(4, Logo);
            prestate.setString(5, SectryID);
            prestate.setInt(6, CandiCount);
            
            int result=prestate.executeUpdate();
            if(result>0)
            {
                flage=true;
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
        conn.close();
        return flage;
        }
    }
    
}
