/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import  java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author User
 */
public class PollingDivisionRegister extends Dbconnection{
    
    Connection conn =Createconnection();
    
    //this insert function use to insert the district details in to database
    //and this is return a boolean value according to the status
    public boolean InsertPollingDivision(String DivisionID,String DivisionCode,String DivisionName,int RegisterdCandidates,int RegisterdVoters, String DistricID,int VotedCountAmount)
    {
        boolean flage=false;
        try
        {
             String query="INSERT INTO `electionsystemdb`.`PollingDivisionTbl` " +
                          "(DivisionID,DivisionCode,DivisionName,CandidatesSeats,RegisterdVoters,DistricID,VotedCount) "+
                          "VALUES (?,?,?,?,?,?,?);";
             
             java.sql.PreparedStatement prestate=conn.prepareStatement(query);
             prestate.setString(1, DivisionID);
             prestate.setString(2, DivisionCode);
             prestate.setString(3, DivisionName);
             prestate.setInt(4, RegisterdCandidates);
             prestate.setInt(5, RegisterdVoters);
             prestate.setString(6, DistricID);
             prestate.setInt(7, VotedCountAmount);
             int result=prestate.executeUpdate();
             if(result>0){
                  flage=true;
                  return flage;
             }
             else{
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
            return flage;
        }
    }
      
    //this function is returning a result set 
    //which is contain the relavent details about the polling divisions
    public ResultSet ViewPollingDivision()
    {
         ResultSet rsltst=null;
         try
         {
            CallableStatement cs=Createconnection().prepareCall("{call GetPollingDiveDetails()}");
            rsltst = cs.executeQuery();
            return rsltst;
         }
         catch(Exception ex)
         {
             ex.toString();
             return rsltst;
         }
     }
      
    public ResultSet LoadPollingDivCombo()
    {
          ResultSet rsltstcombo=null;
        try
        {
            String slectqry="SELECT DivisionID,DivisionName FROM PollingDivisionTbl";
            PreparedStatement ps=con.prepareStatement(slectqry);
            rsltstcombo=ps.executeQuery();
            return rsltstcombo;
        }
        catch(Exception ex)
        {
            return rsltstcombo;
        }
      }
      
      
     public ResultSet LoadDistricCombo()
     {
         ResultSet rsltst=null;
         try
        {
            String slectqry="select DistricID,DistricName From  `electionsystemdb`.`DistricTbl`";
            PreparedStatement ps=con.prepareStatement(slectqry);
            rsltst=ps.executeQuery();
            
            return rsltst;
        }
        catch(Exception ex)
        {
            return rsltst;
        }
     }
     
     //get the count of the votes that already voted in this polling division
     public int GetCurrentVoteamount(String P_divisionID)
     {
         int exisitingcount=0;
         ResultSet getresult=null;
        try
        {
             String query="select SUM(VotedCount) from pollingdivisiontbl "+
                        " where pollingdivisiontbl.DivisionID=?;";
          java.sql.PreparedStatement prestate=conn.prepareStatement(query);
          prestate.setString(1, P_divisionID);
          getresult=prestate.executeQuery();
          if(getresult.next()){
                 return  exisitingcount= getresult.getInt(1);
             }
             return  exisitingcount;
        }
        catch(Exception ex)
        {
            
        }
        finally{
           return  exisitingcount; 
        }
     }
    
    //get the registerd voter count in the perticulaar polling didvision
    public int GetRegistersVoterAmount(String P_divisionID)
     {
         int exisitingregitedcount=0;
         ResultSet getresult=null;
        try
        {
             String query="select SUM(RegisterdVoters) from pollingdivisiontbl "+
                        " where pollingdivisiontbl.DivisionID=?;";
          java.sql.PreparedStatement prestate=conn.prepareStatement(query);
          prestate.setString(1, P_divisionID);
          getresult=prestate.executeQuery();
          if(getresult.next()){
                 return  exisitingregitedcount= getresult.getInt(1);
             }
             return  exisitingregitedcount;
        }
        catch(Exception ex)
        {
            
        }
        finally{
           return  exisitingregitedcount; 
        }
     }

    boolean UpdateRegisterVoters(String poldivID, int regAmount) {
       
        boolean relt=false;
        try
        {
          String query="Update pollingdivisiontbl SET  RegisterdVoters=? "+
                        " where pollingdivisiontbl.DivisionID=? ";
          
          java.sql.PreparedStatement prestate=conn.prepareStatement(query);
          prestate.setInt(1, regAmount);
          prestate.setString(2, poldivID);
          int updatersl=prestate.executeUpdate();
          if(updatersl>0){
                 return  relt=true;
             }
             return  relt=false;
        }
        catch(Exception ex)
        {
            return relt;
        }
       
    }
    
    
    boolean Updatevotedcount(String pollingdviosn_Id, int VoteCount){
       
        boolean updatersltst=false;
        try
        {
           CallableStatement cs=Createconnection().prepareCall("{call UpdatevalidVotscount(?,?)}");
           cs.setInt(1, VoteCount); 
           cs.setString(2, pollingdviosn_Id); 
           int rsltst = cs.executeUpdate();
           if(rsltst>0){
                 return  updatersltst=true;
             }
             return  updatersltst=false;
        }
        catch(Exception ex)
        {
            return updatersltst;
        }
       
    }
}
