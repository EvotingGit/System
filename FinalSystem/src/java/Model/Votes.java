/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class Votes extends Dbconnection{
  Connection conn=Createconnection(); 
  CreateUniqueID createUUid=new CreateUniqueID();
  String status="true";
  Double votecount=1.0;
  Map<String, Integer> map = new HashMap<String, Integer>();
  
  //this is the cunstructer in this class
  public Votes()
  {
      
  }
  
  // insert the votes in to vote tables 
  public boolean  Insertvote(String UserId,String p_party_id, String prifer_1,String prifer_2,String prifer_3) throws SQLException
  {
       
       boolean flage=false;
       String VoterID=createUUid.UniqueID();
       ArrayList candidatelist =new ArrayList();
       candidatelist.add(prifer_1);
       candidatelist.add(prifer_2);
       candidatelist.add(prifer_3);
       GetPrferncecount(candidatelist);
       
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
                return flage=true;
            }
            return  flage;
      }catch(Exception ext)
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
  
  //this use t oinsert the prfeence for perticular candidates,
  //this return a bollean value
  public boolean Addprefernce(String vote_Id,String UserId, String prifer_1,String prifer_2,String prifer_3) throws SQLException
  {
      boolean flage=false;
      String PrfernceID=createUUid.UniqueID();
      try
      {
          CallableStatement cs=Createconnection().prepareCall("{call AddPreference(?,?,?,?)}");
          cs.setString(1, PrfernceID);
          cs.setString(2, vote_Id);
          cs.setString(3, UserId);
          cs.setDouble(4, votecount);
          int rslt=cs.executeUpdate();
            if(rslt>0)
            {
                return flage=true;
            }
            return  flage;
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

  public void GetPrferncecount(ArrayList candidatelist) {
        
        String candidateId1="";
        String candidateId2 ="";
        String candidateId3 ="";
        String Matched="";
        int prfercont=0;
        try
        {
            if(candidatelist!=null)
            {
                Iterator iter = candidatelist.iterator();
                while(iter.hasNext()){
                    candidateId1 =String.valueOf(iter.next()) ;
                    candidateId2 =String.valueOf(iter.next()) ;
                    candidateId3 =String.valueOf(iter.next()) ;
                }
                if(candidateId1==candidateId2){
                    Matched=candidateId1;
                    
                    if(Matched==candidateId3)
                    {
                        Matched=candidateId3;
                        prfercont=3;
                        map.put(Matched, prfercont);
                        //System.out.println(map.get("dog"));
                    }
                        prfercont=3;
                }
            }
        }
        catch(Exception ex)
        {
        throw new UnsupportedOperationException("Not yet implemented");
        }
    }
   
    
}
