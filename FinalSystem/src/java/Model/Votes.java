/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.Md5Encryption;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.jsp.jstl.sql.Result;

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
  int curentAlcount=0;
  //this is the cunstructer in this class
  public Votes()
  {
      
  }
  
  // insert the votes in to vote tables 
  public boolean  Insertvote(String UserId,String p_party_id,ArrayList candidateidlist,String pollingdidviosnId) throws SQLException
  {
       boolean flage=false;
       String VoterID=createUUid.UniqueID();
       PollingDivisionRegister pollingdivisionReg=new PollingDivisionRegister();
       String plainuserid=Md5Encryption.decrypt(UserId);
      try
      {
          CallableStatement cs=Createconnection().prepareCall("{call InsrtVotes(?,?,?,?)}");
          cs.setString(1, VoterID);
          cs.setString(2, p_party_id);
          cs.setString(3, plainuserid);
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
                    boolean resltvoterreg= voterreg.UpdateVoterStatus(plainuserid,status);
                    if(resltvoterreg==true){
                     
                        //update the polling divison table voted count (valid votes amount)
                        int curentvotes=pollingdivisionReg.GetCurrentVoteamount(VoterID);
                        curentvotes++;
                        boolean addresult=pollingdivisionReg.Updatevotedcount(pollingdidviosnId,curentvotes);
                        if(addresult==true){
                            return flage=true;
                        }
                         return flage=false;
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
  

    public ArrayList CurrentPrgress() {
        
        ResultSet resltd=null;
        ArrayList progresslist=new ArrayList();
       try{
            CallableStatement cs=Createconnection().prepareCall("{call GetcurrentProgrss()}");
            resltd = cs.executeQuery(); 
            if(resltd.next())
               {
                   int Allcount=GetCurentAllVotes();
                   String progressofpartycode=resltd.getString(1); 
                   String progressofpartyName=resltd.getString(2); 
                   int progressofpartyValue=resltd.getInt(3);
                   double presentage=calculatepresentage(Allcount,progressofpartyValue);
                   
                   progresslist.add(progressofpartycode);
                   progresslist.add(progressofpartyName);
                   progresslist.add(progressofpartyValue);
                   progresslist.add(presentage);
               }
            return progresslist;
       } catch(Exception ext)
        {
            ext.printStackTrace();
            System.err.println(ext.getMessage());
            Logger.getLogger(UserRegister.class.getName()).log(Level.SEVERE, "Record Not Found !", ext);
            return progresslist; 
      }
    }

    private int GetCurentAllVotes() throws SQLException {
        
        try
        {
            ResultSet resltd=null;
            CallableStatement cs=Createconnection().prepareCall("{call GetAllVotesCountCurrntly()}");
            resltd = cs.executeQuery(); 
            if(resltd.next())
            {
                curentAlcount=resltd.getInt(1);
            }
            return curentAlcount;
        }catch(Exception exc)
        {
            exc.toString();
        }finally{
            con.close();
            return curentAlcount;
        }
    }

    private double calculatepresentage(int Allcount,int progressofpartyValue) {
        try
        {
            double newallcunt=(double)Allcount;
            double currentcunt=(double)progressofpartyValue;
            double presentagevalue=(currentcunt/newallcunt)*100;
                    
            return presentagevalue;
        }
        catch(Exception exc){
        throw new UnsupportedOperationException("Not yet implemented");
        }
    }
 
}
