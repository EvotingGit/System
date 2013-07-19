/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.mysql.jdbc.Connection;
import java.io.FileOutputStream;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class CandiRegister extends Dbconnection{
    
    java.sql.Connection conn=Createconnection(); 
    
    public boolean insertCandiDetail(String UserId,String Electpartyid,String Seat,String ElectNo,String createdby,String createddate,String updatedby,String updateddate,String UserName, String Password, String Post)
    {
        boolean rst=false;
        
        try{
            String Query="INSERT INTO `electionsystemdb`.`candidatetble` "+
                         "(UserID,PoliPartyID,SeatName,PreferenceNo,CreateDate,CreatedBy,UpdateDate,UpdatedBy) "+
                         " VALUES (?,?,?,?,?,?,?,?);";
            PreparedStatement prestate=conn.prepareStatement(Query);
            prestate.setString(1, UserId);
            prestate.setString(2, Electpartyid);
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
            CallableStatement cs=Createconnection().prepareCall("{call CandidateListtable()}");
            rsltst = cs.executeQuery();
            return rsltst;
         }
         catch(Exception ex)
         {
             ex.toString();
             return rsltst;
         }
     }

    public boolean CreateAllCandiesRepot(ResultSet reslts) {
        Date date = new Date();
        boolean flage=false;
        try{
         com.itextpdf.text.Document doc = new com.itextpdf.text.Document();
         PdfWriter.getInstance(doc, new FileOutputStream("C:/Program Files/CreateAllCandiesReport.pdf"));
         doc.open();

         if (reslts.next())
                     {
                        PdfPTable table1 = new PdfPTable(2); //Specifies the number of columns in the table
                        Font font = new Font(Font.FontFamily.COURIER,5,Font.BOLD);
                        table1.setSpacingBefore(10f);
                        
                        PdfPCell cellTitle = new PdfPCell(new Paragraph("Title"));
                        cellTitle.setBackgroundColor(BaseColor.ORANGE);
                        
                        PdfPCell cellVle = new PdfPCell(new Paragraph("Candidates Detail"));
                        cellVle.setBackgroundColor(BaseColor.LIGHT_GRAY);
                                               
                        table1.addCell(cellTitle);
                        table1.addCell(cellVle);
                       
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
                        
                        PdfPCell cell3 = new PdfPCell(new Paragraph("Seat"));
                        cell3.setBackgroundColor(BaseColor.LIGHT_GRAY);
                        
                        PdfPCell cell4 = new PdfPCell(new Paragraph("Prefernce No"));
                        cell4.setBackgroundColor(BaseColor.LIGHT_GRAY);
                        
                        PdfPCell cell5 = new PdfPCell(new Paragraph("Politial Party"));
                        cell4.setBackgroundColor(BaseColor.LIGHT_GRAY);
           
                        table2.addCell(cell1);
                        table2.addCell(cell2);
                        table2.addCell(cell3);
                        table2.addCell(cell4);
                        table2.addCell(cell5); 
                        
                        reslts.beforeFirst();
                        while(reslts.next())
                        {
                            PdfPCell cell6 = new PdfPCell(new Paragraph(reslts.getString(1)));
                            PdfPCell cell7 = new PdfPCell(new Paragraph(reslts.getString(2)+" "+reslts.getString(3)));
                            PdfPCell cell8 = new PdfPCell(new Paragraph(reslts.getString(4)));
                            PdfPCell cell9 = new PdfPCell(new Paragraph(reslts.getString(5)));
                            PdfPCell cell10 = new PdfPCell(new Paragraph(reslts.getString(6)));
                                   
                            table2.addCell(cell6);
                            table2.addCell(cell7); 
                            table2.addCell(cell8);
                            table2.addCell(cell9);
                            table2.addCell(cell10);
                            
                           }
                        doc.add(table2);
                        Runtime.getRuntime().exec("rundll32 url.dll, FileProtocolHandler C:/Program Files/CreateAllCandiesReport.pdf");
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
