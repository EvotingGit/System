/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import com.mysql.jdbc.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

/**
 *
 * @author User
 */
public class CandiRegister extends Dbconnection{
    
    java.sql.Connection conn=Createconnection(); 
    
    public boolean insertCandiDetail(String UserId,String Electparty,String Seat,String ElectNo,String createdby,String createddate,String updatedby,String updateddate,String UserName, String Password, String Post)
    {
        boolean rst=false;
        
        try{
            String Query="INSERT INTO `electionsystemdb`.`candidatetble` "+
                         "(UserID,ElectionTypeID,SeatName,ElectionNo,CreateDate,CreatedBy,UpdateDate,UpdatedBy) "+
                         " VALUES (?,?,?,?,?,?,?,?);";
            PreparedStatement prestate=conn.prepareStatement(Query);
            prestate.setString(1, UserId);
            prestate.setString(2, Electparty);
            prestate.setString(3, Seat);
            prestate.setString(4, ElectNo);
            prestate.setString(5, createddate);
            prestate.setString(6, createdby);
            prestate.setString(7, updateddate);
            prestate.setString(8, updatedby);
            
            int out=prestate.executeUpdate();
                if(out>0)
                {
                    LoginDetails userlogin=new LoginDetails();
                    boolean loginrslt=userlogin.insertlogindetl(UserId,UserName,Password, Post);
                    if(loginrslt==true)
                    {
                        rst=true;
                    }else
                    {
                        rst=false;
                    }
                    return rst;
                }
            }
            catch(Exception ex)
            { 
            ex.printStackTrace();
            System.err.println(ex.getMessage());
            return rst;
            }
            finally
            {
                return rst;
            }
        } 
    
     public ResultSet GetCandiProPicture() {
        try
        {
            ResultSet rs=null;
            String slectqry="SELECT Image from sysusertbl";
            java.sql.PreparedStatement ps=conn.prepareStatement(slectqry);
            rs = ps.executeQuery(slectqry);  
                        
            return rs;
        }
        catch(Exception ex){
        throw new UnsupportedOperationException("Not yet implemented");
        }
    }
     
     public ResultSet GetCandidateList()
     {
         ResultSet rsltst=null;
         try
         {
            String slectqry="select UserID, From `electionsystemdb`.`candidatetble`";
            PreparedStatement ps=con.prepareStatement(slectqry);
            rsltst=ps.executeQuery();
            return rsltst;
         }
         catch(Exception ex)
         {
             ex.toString();
             return rsltst;
         }
     }
    
}
