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
    
   public boolean InsertElecitonPartyDetaisl(String PoliPartyID,String ElectioPcode, String ElectionPName, String RegisterDate, byte[] Logo, String SectryID, int CandiCount) throws SQLException {
         boolean flage=false;
        try
        {
            String query="INSERT INTO `electionsystemdb`.`politicalpartytbl` "+
                         " (PoliPartyID,PoliticalPartyCode,PoliticalPartyName,Logo,No_of_Candidates,RegisterdDate,UserID) "+
                         " VALUES (?,?,?,?,?,?,?);";
            
            PreparedStatement prestate=conn.prepareStatement(query);
            prestate.setString(1, PoliPartyID);
            prestate.setString(2, ElectioPcode);
            prestate.setString(3, ElectionPName);
            prestate.setBytes(4, Logo);
            prestate.setInt(5, CandiCount);
            prestate.setString(6, RegisterDate);
            prestate.setString(7, SectryID);
            
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
