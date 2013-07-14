/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nalin
 */
public class VoteSummary extends Dbconnection{
    Connection conn=Createconnection();
    MailSender mail=new MailSender();
    String userid="",politicalpartyid="",divisionid="";
    
    public boolean CreateVoteSummary(ArrayList sucesvotedetails) {
        
        boolean flage=false;
        try
        {
             Iterator summarylist = sucesvotedetails.iterator();
              while(summarylist.hasNext()){
                    userid=String.valueOf(summarylist.next()) ;
                    politicalpartyid=String.valueOf(summarylist.next()) ;
                    divisionid=String.valueOf(summarylist.next()) ;
                }
              //get the details from the database 
              try
            {
                CallableStatement cs=Createconnection().prepareCall("{call CreateSummary(?,?)}");
                cs.setString(1, userid);
                cs.setString(2, politicalpartyid);
                ResultSet rslt=cs.executeQuery();
                if(rslt.next())
                {
                     String _fname= rslt.getString(1);
                     String _lastname= rslt.getString(2); 
                     String _email= rslt.getString(3);
                     String _electionparty=rslt.getString(4);
                     String _fulname=_fname+_lastname;
                     mail.Sendsucessvotedetails(_email,_fulname,_electionparty);  
                     return flage=true;
                }
                else{
                    return flage;
                }   
            }
              catch(Exception ex)
              {
                ex.printStackTrace();
                System.err.println(ex.getMessage());
                Logger.getLogger(UserRegister.class.getName()).log(Level.SEVERE, "Database Error !", ex);
            }
         
        }catch(Exception ex){
                ex.printStackTrace();
                System.err.println(ex.getMessage());
                Logger.getLogger(UserRegister.class.getName()).log(Level.SEVERE, "No records Foundr !", ex);
        } 
        finally{
            return flage;
        }
    }   
}
