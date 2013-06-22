/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.*;
import java.util.List;

/**
 *
 * @author User
 */
public class ElectionPartyReg extends Dbconnection{
    
    Connection conn=Createconnection();
    
   public boolean InsertElecitonPartyDetaisl(String PoliPartyID,String ElectioPcode, String ElectionPName, String RegisterDate, byte[] Logo,String electypeid,int CandiCount) throws SQLException {
         boolean flage=false;
        try
        {
            String query="INSERT INTO `electionsystemdb`.`politicalpartytbl` "+
                         " (PoliPartyID,PoliticalPartyCode,PoliticalPartyName,RegisterdDate,Logo,No_of_Candidates,ElectionTypeID) "+
                         " VALUES (?,?,?,?,?,?,?);";
            
            PreparedStatement prestate=conn.prepareStatement(query);
            prestate.setString(1, PoliPartyID);
            prestate.setString(2, ElectioPcode);
            prestate.setString(3, ElectionPName);
            prestate.setString(4, RegisterDate);
            prestate.setBytes(5, Logo);
            prestate.setInt(6, CandiCount);
            prestate.setString(7, electypeid);
            
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
 
   public ResultSet LoadpolipartyCombo()
   {
        ResultSet rsltst=null;
        try
        {
           CallableStatement cs=Createconnection().prepareCall("{call LoadPoliticalCombo()}");
            rsltst = cs.executeQuery();
            return rsltst;
        }
        catch(Exception ex)
        {
            return rsltst;
        }
   }
   
   public ResultSet LoadpolipartyList()
   {
        ResultSet rsltst=null;
        try
        {
           CallableStatement cs=Createconnection().prepareCall("{call GetPoliticalPartiesList()}");
            rsltst = cs.executeQuery();
            return rsltst;
        }
       catch(Exception ex)
       {
           ex.printStackTrace();
           System.err.println(ex.getMessage());
           return rsltst;
       }
   }
   
}
