/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class Votes extends Dbconnection{
  
  Connection conn=Createconnection(); 
  CreateUniqueID createUUid=new CreateUniqueID();
  Byte status=1;
  Double votecount=1.0;
  Map<String, Integer> candidatedictionary = null;
  
  //this is the cunstructer in this class
  public Votes()
  {
      
  }
  
  // insert the votes in to vote tables 
  public boolean  Insertvote(String UserId,String p_party_id,ArrayList candidateidlist) throws SQLException
  {
       boolean flage=false;
       String VoterID=createUUid.UniqueID();
      try
      {
          CallableStatement cs=Createconnection().prepareCall("{call InsrtVotes(?,?,?,?)}");
          cs.setString(1, VoterID);
          cs.setString(2, p_party_id);
          cs.setString(3, UserId);
          cs.setDouble(4, votecount);
          int rslt=cs.executeUpdate();
            if(rslt>0)
            {
                //boolean prferncerslt=Addprefernce(VoterID,UserId,prifer_1, prifer_2, prifer_3);
                Map<String, Integer> prferncedictionary =GetPrferncecount(candidateidlist);
                boolean prefernrslt= Addprefernce(VoterID,prferncedictionary);
                
                //after add the prefernece and the votings 
                // voter status must update to remove the duplication of revoting
                if(prefernrslt==true)
                {
                    VoterRegister voterreg=new VoterRegister();
                    boolean resltvoterreg= voterreg.UpdateVoterStatus(UserId,status);
                    if(resltvoterreg==true){
                        return flage=true;
                    }     
                }
                return flage=false;
            }
            return  flage;
      }
      catch(SQLException sqlex)
      {
            sqlex.printStackTrace();
            System.err.println(sqlex.getMessage());
            Logger.getLogger(UserRegister.class.getName()).log(Level.SEVERE, "Connection Error !", sqlex);
            return flage;
      }
      catch(Exception ext)
      {
            ext.printStackTrace();
            System.err.println(ext.getMessage());
            Logger.getLogger(UserRegister.class.getName()).log(Level.SEVERE, "Record Not Found !", ext);
            return flage; 
      }
      finally
      {
          conn.close();
      }
  }
  
 public Map<String, Integer> GetPrferncecount(ArrayList candidatelist) {
        
        String candidateId="";
        String Cand_ID="";
        int prfercont=1;
        int curentcout=0;
        candidatedictionary=new HashMap<String, Integer>();
        try
        {
            if(candidatelist!=null)
            {
                Iterator iter = candidatelist.iterator();
                while(iter.hasNext()){
                    candidateId =String.valueOf(iter.next()) ;
                    if(candidatedictionary.containsKey(candidateId)){
                       curentcout = candidatedictionary.get(candidateId.toString());
                       curentcout++;
                       candidatedictionary.put(Cand_ID, curentcout);
                   }
                    else{
                        Cand_ID=candidateId;
                        candidatedictionary.put(Cand_ID, prfercont);
                    }
                 }
            }
             return candidatedictionary;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            System.err.println(ex.getMessage());
            Logger.getLogger(UserRegister.class.getName()).log(Level.SEVERE, "No Preference Found !", ex);
            return candidatedictionary;
        }
        finally
        {
             return candidatedictionary;
        }
    }

  
  
  //this use t oinsert the prfeence for perticular candidates,
  //this return a bollean value
 private boolean Addprefernce(String VoterID, Map<String, Integer> prferncedictionary){

     boolean flage=false;
     // Get a set of the entries
     Set set = prferncedictionary.entrySet();
     // Get an iterator
     Iterator newitor = set.iterator();
     int rslt=0;
     
      try
      {
         CallableStatement cs=Createconnection().prepareCall("{call AddPreference(?,?,?,?)}");
         while(newitor.hasNext()) {
         Map.Entry mapEntry = (Map.Entry)newitor.next();
         String PrfernceID=createUUid.UniqueID();
         
         cs.setString(1, PrfernceID);
         cs.setString(2, VoterID);
         cs.setString(3, mapEntry.getKey().toString());
         cs.setDouble(4, Double.parseDouble(mapEntry.getValue().toString()));
         rslt=cs.executeUpdate();
         }
          if(rslt>0)
            {
                return flage=true; 
            }
            return flage;
      }
       catch(SQLException sqlex)
      {
            sqlex.printStackTrace();
            System.err.println(sqlex.getMessage());
            Logger.getLogger(UserRegister.class.getName()).log(Level.SEVERE, "Connection Error !", sqlex);
           //conn.close();
            return flage;
      }
      catch(Exception ext)
      {
            ext.printStackTrace();
            System.err.println(ext.getMessage());
            Logger.getLogger(UserRegister.class.getName()).log(Level.SEVERE, "Record Not Found !", ext);
            return flage; 
      }
      finally
      {
          return flage;
      }
    }  
}
