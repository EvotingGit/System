/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.Md5Encryption;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class VoterRegister  extends UserRegister{
    Connection conn=Createconnection(); 
    
    public boolean InsertVoterDetails(String UserId,String ElectionCrdNo,String poldivID,byte stats,String createdby,String createddate,String updatedby,String updateddate,String post)
    {
        boolean flage=false;
        String polipartyID="";
        try
        {
            String Query="INSERT INTO `electionsystemdb`.`VoterDetailTbl` "+
                         "(UserID,ElectionCardNo,DivisionID,`Status`,CreatedBy,CreatedDate,UpdateDate,UpdatedBy,PoliPartyID) "+
                         " VALUES (?,?,?,?,?,?,?,?,?);";
            
            PreparedStatement prestate=conn.prepareStatement(Query);
            prestate.setString(1, UserId);
            prestate.setString(2, ElectionCrdNo);
            prestate.setString(3, poldivID);
            prestate.setByte(4, stats);
            prestate.setString(5, createdby);
            prestate.setString(6, createddate);
            prestate.setString(7, updatedby);
            prestate.setString(8, updateddate);
            prestate.setString(9, polipartyID);
            int rslt=prestate.executeUpdate();
            if(rslt>0)
            {
                //update the polling division register voter count 
                PollingDivisionRegister polingdivisionReg=new PollingDivisionRegister();
                int regAmount=polingdivisionReg.GetCurrentVoteamount(poldivID);
                regAmount++;
                boolean updatesrsl=polingdivisionReg.UpdateRegisterVoters(poldivID,regAmount);
                if(updatesrsl==true){
                    return flage=true;
                }
                return flage;
            }
            else
            {
                    flage=false;
            }             
        }catch(Exception ex)
        {
            ex.printStackTrace();
            System.err.println(ex.getMessage());
            Logger.getLogger(UserRegister.class.getName()).log(Level.SEVERE, "Voter Loging Details Incomplete !", ex);
            return flage;
        }
        finally
        {
            return flage;
        }
    }
    
    //this function reslt set get the login details based on the nice no
     public ResultSet GetvoterLoginDetails(String loginnic,String polingDivid)
    {
        
     ResultSet rsltst=null;
        try
        {
            CallableStatement cs=Createconnection().prepareCall("{call voterLogin(?,?)}");
            cs.setString(1, loginnic);
            cs.setString(2,polingDivid);
            rsltst = cs.executeQuery();
            return rsltst;
        }
        catch(Exception ex)
        {
            Logger.getLogger(UserRegister.class.getName()).log(Level.SEVERE, "Password incorrect ", ex);
            return rsltst;
        } 
    }
     
     public boolean UpdateVoterStatus(String UseId, byte status)
     {
         
         boolean flage=false;
         try{
            CallableStatement cs=Createconnection().prepareCall("{call UpdateStatus(?,?)}");
            cs.setString(1, UseId);
            cs.setByte(2,status);
            int rslt=cs.executeUpdate();
             /*String updatequry="Update VoterDetailTbl SET VoterDetailTbl.Status=? WHERE VoterDetailTbl.UserID=?";
             PreparedStatement prestate=conn.prepareStatement(updatequry);
             String plainUse_id=Md5Encryption.decrypt(UseId);
             prestate.setByte(1, status);
             prestate.setString(2, plainUse_id);
             int rslt=prestate.executeUpdate();*/
            if(rslt>0){
                    return flage=true;
            }
            return flage;
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
            Logger.getLogger(UserRegister.class.getName()).log(Level.SEVERE, "Record Not Updated !", ext);
            return flage; 
        }
     }
     
     public boolean Isvotedbefore(String UseId){
          boolean flage=false;
          ResultSet rsltst=null;
          
         try{
            CallableStatement cs=Createconnection().prepareCall("{call Isvoted(?)}");
            cs.setString(1, UseId);
            rsltst = cs.executeQuery();
            while(rsltst.next()){
                  byte status=rsltst.getByte(1); 
                  if(status==1){
                      return flage=true;
                  }
            }
            return flage;
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
            Logger.getLogger(UserRegister.class.getName()).log(Level.SEVERE, "Record Not Updated !", ext);
            return flage; 
        }
     }
     
     public ResultSet Loadvoterlist(){
          ResultSet rsltst=null;
        try
        {
            CallableStatement cs=Createconnection().prepareCall("{call LoadAllVoterDetails()}");
            rsltst = cs.executeQuery();
            return rsltst;
        }
        catch(Exception ex)
        {
            Logger.getLogger(UserRegister.class.getName()).log(Level.SEVERE, "Password incorrect ", ex);
            return rsltst;
        } 
     }

    public boolean CreateAllVoterRepot(ResultSet votereslt) {
        java.util.Date date = new java.util.Date();
        boolean flage=false;
        Date printdate=(Date) date;
        try{
         com.itextpdf.text.Document doc = new com.itextpdf.text.Document();
         PdfWriter.getInstance(doc, new FileOutputStream("C:/Program Files/CreateAllVoterReport.pdf"));
         doc.open();

         if (votereslt.next())
                     {
                        PdfPTable table1 = new PdfPTable(2); //Specifies the number of columns in the table
                        Font font = new Font(Font.FontFamily.COURIER,5,Font.BOLD);
                        table1.setSpacingBefore(10f);
                        
                        PdfPCell cellTitle = new PdfPCell(new Paragraph("Title"));
                        cellTitle.setBackgroundColor(BaseColor.ORANGE);
                        
                        PdfPCell cellVle = new PdfPCell(new Paragraph("Candidates Detail"));
                        cellVle.setBackgroundColor(BaseColor.WHITE);
                        
                        PdfPCell cellTit1 = new PdfPCell(new Paragraph("Date"));
                        cellVle.setBackgroundColor(BaseColor.WHITE);
                        
                        PdfPCell cellVle1 = new PdfPCell(new Paragraph(printdate.toString()));
                        cellVle.setBackgroundColor(BaseColor.WHITE);
                                               
                        table1.addCell(cellTitle);
                        table1.addCell(cellVle);
                        table1.addCell(cellTit1);
                        table1.addCell(cellVle1);
                       
                        table1.setSpacingAfter(10f);
                        doc.add(table1);
                         
                        PdfPTable table2 = new PdfPTable(5); //5 Specifies the number of columns in the table
                        table2.setSpacingBefore(10f);
                        table2.setHorizontalAlignment(100); 
                        table2.setWidthPercentage(100);
                                
                        PdfPCell cell1 = new PdfPCell(new Paragraph("Code"));
                        cell1.setBackgroundColor(BaseColor.LIGHT_GRAY);
                        cell1.getBorderColor();
                        
                        PdfPCell cell2 = new PdfPCell(new Paragraph("Full Name"));
                        cell2.setBackgroundColor(BaseColor.LIGHT_GRAY);
                        
                        PdfPCell cell3 = new PdfPCell(new Paragraph("ElectionCard No"));
                        cell3.setBackgroundColor(BaseColor.LIGHT_GRAY);
                        
                        PdfPCell cell4 = new PdfPCell(new Paragraph("NIC No"));
                        cell4.setBackgroundColor(BaseColor.LIGHT_GRAY);
                        
                        PdfPCell cell5 = new PdfPCell(new Paragraph("Polling Division"));
                        cell4.setBackgroundColor(BaseColor.LIGHT_GRAY);
           
                        table2.addCell(cell1);
                        table2.addCell(cell2);
                        table2.addCell(cell3);
                        table2.addCell(cell4);
                        table2.addCell(cell5); 
                        
                        votereslt.beforeFirst();
                        while(votereslt.next())
                        {
                            PdfPCell cell6 = new PdfPCell(new Paragraph(votereslt.getString(1)));
                            PdfPCell cell7 = new PdfPCell(new Paragraph(votereslt.getString(2)+" "+votereslt.getString(3)));
                            PdfPCell cell8 = new PdfPCell(new Paragraph(votereslt.getString(4)));
                            PdfPCell cell9 = new PdfPCell(new Paragraph(votereslt.getString(5)));
                            PdfPCell cell10 = new PdfPCell(new Paragraph(votereslt.getString(6)));
                                   
                            table2.addCell(cell6);
                            table2.addCell(cell7); 
                            table2.addCell(cell8);
                            table2.addCell(cell9);
                            table2.addCell(cell10);
                            
                           }
                        table2.setFooterRows(5);
                        doc.add(table2);
                        Runtime.getRuntime().exec("rundll32 url.dll, FileProtocolHandler C:/Program Files/CreateAllVoterReport.pdf");
                        doc.close();
                        flage=true;
                     }
         return flage;
        }
        catch(DocumentException docex)
        {
            docex.printStackTrace();
            Logger.getLogger(UserRegister.class.getName()).log(Level.SEVERE, "Pdf Creation Fails !", docex);
            return flage;
        }
        catch(Exception ex )
        {
            ex.printStackTrace();
            System.err.println(ex.getMessage());
            Logger.getLogger(UserRegister.class.getName()).log(Level.SEVERE, "Record Not Found !", ex);
        }
        finally
        {
            return flage;
        }
    }
     
     
    
}
