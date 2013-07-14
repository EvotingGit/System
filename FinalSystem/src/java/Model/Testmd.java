/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.io.*;
import java.sql.*;
import javax.crypto.*;
import java.security.*;
import java.security.spec.KeySpec;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.crypto.spec.DESedeKeySpec;
import sun.misc.*; 
import java.util.UUID;
import java.util.Date;
import org.jfree.data.jdbc.JDBCCategoryDataset;
import org.jfree.data.jdbc.JDBCPieDataset;
/**
 *
 * @author User
 */
public class Testmd extends Dbconnection{
    
 java.sql.Connection conn=Createconnection();
    
public void insertimage(String c) {
        boolean f=false;
    
     try
     {
        
         File file = new File("D:/"+c.toString());
         boolean x= file.canRead();
         boolean y= file.canExecute();
	 FileInputStream fin = new FileInputStream(file);
         String Inseret="insert into picture (id,image) values(?,?)";
         java.sql.PreparedStatement ps=conn.prepareStatement(Inseret);
         ps.setInt(1,1);
	 ps.setBinaryStream(1,fin,(int)file.length()); 
         int result=ps.executeUpdate();
          if(result>0){
              f =true;
          }
            ps.close();
            conn.close(); 
     }
     catch(Exception ex)
     {
        throw new UnsupportedOperationException("Not yet implemented");
     }
    }

  
  public boolean  insertpass(String passw) throws SQLException
  {
       boolean f=false;
       String sqlinsert="insert into upload_image (bImage) values(?)";
       java.sql.PreparedStatement prepare=conn.prepareStatement(sqlinsert);
       prepare.setString(1, passw);
       return f;
  }
  

 public ResultSet chekpass() {
        ResultSet rs=null;
        try
        {
            Statement st=con.createStatement();
            rs=st.executeQuery("Select * from upload_image where iImageID='1'");
            return  rs;
       }
       catch(Exception ex)
       {
           ex.toString();
       }
        finally
        {
            return  rs;
        }
    }


 public void test(String ElectionTypeID, String strdate) {
       try
       {
        String sqlinsert="insert into Tester (id,date) values(?,?)";
        java.sql.PreparedStatement prepare=conn.prepareStatement(sqlinsert);
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        String x=dateFormat.format(date);
        
        
        prepare.setString(1, ElectionTypeID);
        prepare.setString(2, x);
        int result=prepare.executeUpdate();
       }
       catch(Exception ex )
       {
           ex.printStackTrace();
            System.err.println(ex.getMessage());
       }
    }
    
 public void abc(String cc){
            try{
		 File imgfile = new File("C:/Users/Public/Pictures/Sample Pictures/"+cc);
		 FileInputStream fin = new FileInputStream(imgfile.getName());
                 String slectqry="insert into Image values(?,?,?)";
                 java.sql.PreparedStatement ps=conn.prepareStatement(slectqry);
		 ps.setString(1,"test");
		 ps.setInt(2,3);
		 ps.setBinaryStream(3,(InputStream)fin,(int)imgfile.length());
                 int x=ps.executeUpdate();
                 if(x>0)
                     System.out.println("Successfully inserted the file into the database!");

		 ps.close();
		 con.close(); 
		}catch (Exception e1){
			System.out.println(e1.getMessage());
		}
	}
 
 public ResultSet Getcandiesbyparty(String PartyId)
 {
     ResultSet rs=null;
     try
     {
         CallableStatement cs=Createconnection().prepareCall("{call GetCandidatesDetailsbypoliId(?)}");
           cs.setString(1,PartyId);
           rs = cs.executeQuery();
           if(rs!=null)
           {
               return rs;
           }
           return rs=null;
          
         
     }catch(Exception ex)
     {
         ex.toString();
         return rs;
     }
 }
 
 
 public JDBCPieDataset chart() {
        try
        {
            JDBCPieDataset dataset = new JDBCPieDataset(conn);
            String query="SELECT DivisionName,SUM(CandidatesSeats) As SeatCount,SUM(RegisterdVoters) As RegsitedVotes, "+
			 " SUM(VotedCount) As ValidVotedCount FROM     pollingdivisiontbl,votetable GROUP BY pollingdivisiontbl.DivisionName; ";
            //java.sql.PreparedStatement ps=conn.prepareStatement(query);
            //ps.executeQuery();
            dataset.executeQuery(query);  
                        
            return dataset;
        }
        catch(Exception ex){
        throw new UnsupportedOperationException("Not yet implemented");
        }
    }
 
 public JDBCCategoryDataset Barchart() {
        try
        {
            JDBCCategoryDataset dataset = new JDBCCategoryDataset(conn);
            String query="SELECT DivisionName,SUM(CandidatesSeats) As SeatCount,SUM(RegisterdVoters) As RegsitedVotes, "+
			 " SUM(VotedCount) As ValidVotedCount FROM     pollingdivisiontbl,votetable GROUP BY pollingdivisiontbl.DivisionName; ";
            //java.sql.PreparedStatement ps=conn.prepareStatement(query);
            //ps.executeQuery();
            dataset.executeQuery(query);  
                        
            return dataset;
        }
        catch(Exception ex){
        throw new UnsupportedOperationException("Not yet implemented");
        }
    }
 
            
}
