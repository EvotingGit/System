/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.*;
import java.util.ArrayList;
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
   
   public ResultSet LoadBallotaFormFillList()
   {
       ResultSet rsltst=null;
        try
        {
           CallableStatement cs=Createconnection().prepareCall("{call FillBallotPaper()}");
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
   
//   public ResultSet GetCandiesbyPolitcalP_ID(String PoliticalId)
//   {
//        ResultSet rsltst=null;
//        try
//        {
//           CallableStatement cs=Createconnection().prepareCall("{call GetCandidatesDetailsbypoliId(?)}");
//           cs.setString(1,PoliticalId);
//           rsltst = cs.executeQuery();
//           return rsltst;
//        }
//       catch(Exception ex)
//       {
//           ex.printStackTrace();
//           System.err.println(ex.getMessage());
//           return rsltst;
//       }
//   }
   
   public ArrayList<CandidatesModel> GetCandiesbyPolitcalP_ID(String PoliticalId) 
   {
        ResultSet rsltst=null;
        ArrayList<CandidatesModel> candiList = new ArrayList<CandidatesModel>();
        
        try {
           CallableStatement cs=Createconnection().prepareCall("{call GetCandidatesDetailsbypoliId(?)}");
           cs.setString(1,PoliticalId);
           rsltst = cs.executeQuery();
           while(rsltst.next()) { 
             CandidatesModel candi=new CandidatesModel();
             candi.setUserID(rsltst.getString("UserID"));
             String Fname=rsltst.getString("FirstName");
             String LstName=rsltst.getString("LastName");
             String FulName=Fname+ LstName;
             candi.setName(FulName);
             candi.setPreferenceNo(rsltst.getString("PreferenceNo"));
             
             candiList.add(candi);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return candiList;
   }
 
}
