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
import java.io.FileOutputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class SeatDetailsRpt extends Dbconnection {
    
    Connection conn=Createconnection();
    
    public boolean GenrateSeatDetails(String Provin_id)
    {  
       boolean crtepdf=false; 
       ResultSet reslts = null;
        CallableStatement cs=null;
        try
        {  
            if(Provin_id!="All")
            {
                cs=conn.prepareCall("{call GetSeatonProvinceRpt(?)}");
                cs.setString(1, Provin_id);
                reslts = cs.executeQuery();
                crtepdf=CreateRepot(reslts); 
                return crtepdf;
            }
            else
            {
                cs=conn.prepareCall("{call GetAllSeatonProvinceRpt()}");
                reslts = cs.executeQuery();
                crtepdf=CreateRepot(reslts); 
                return crtepdf;
            }
            
          
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            System.err.println(ex.getMessage());
            Logger.getLogger(UserRegister.class.getName()).log(Level.SEVERE, "Record Not Found !", ex);
            return crtepdf;
        }
        finally
        {
            return crtepdf;
        }
    }
    
    public boolean  CreateRepot(ResultSet reslts)  
    {
        boolean flage=false;
        try{
         com.itextpdf.text.Document doc = new com.itextpdf.text.Document();
         PdfWriter.getInstance(doc, new FileOutputStream("C:/Program Files/SeatDetailsReport.pdf"));
         doc.open();

         if (reslts.next())
                     {
                        PdfPTable table1 = new PdfPTable(2); //Specifies the number of columns in the table
                        Font font = new Font(Font.FontFamily.TIMES_ROMAN,8,Font.BOLD);
                        table1.setSpacingBefore(12f);
                        //table1.setWidthPercentage(100);
                        table1.setWidthPercentage(100);
                        table1.getDefaultCell();
                        
                        PdfPCell cellTitle = new PdfPCell(new Paragraph("Title"));
                        cellTitle.setBackgroundColor(BaseColor.LIGHT_GRAY);
                        PdfPCell cellVle = new PdfPCell(new Paragraph("Client Detail"));
                       
                        PdfPCell cellDept = new PdfPCell(new Paragraph("Selected Province"));
                        cellVle.setBackgroundColor(BaseColor.LIGHT_GRAY);
                        PdfPCell cellVD = new PdfPCell(new Paragraph(reslts.getString(1)));
                        
                        table1.addCell(cellTitle);
                        table1.addCell(cellVle);
                        table1.addCell(cellDept);
                        table1.addCell(cellVD);
                        table1.setSpacingAfter(25f);
                        doc.add(table1);
                         
                        PdfPTable table2 = new PdfPTable(5); //5 Specifies the number of columns in the table
                        table2.setSpacingBefore(10f);
                        table2.setHorizontalAlignment(100); 
                        table2.setWidthPercentage(100);
                        
                        PdfPCell cell1 = new PdfPCell(new Paragraph("Province Name"));
                        cell1.setBackgroundColor(BaseColor.LIGHT_GRAY);
                        
                        PdfPCell cell2 = new PdfPCell(new Paragraph("District Name"));
                        cell2.setBackgroundColor(BaseColor.LIGHT_GRAY);
                        
                        PdfPCell cell3 = new PdfPCell(new Paragraph("Polling Division"));
                        cell3.setBackgroundColor(BaseColor.LIGHT_GRAY);
                        
                        PdfPCell cell4 = new PdfPCell(new Paragraph("Registerd voters"));
                        cell4.setBackgroundColor(BaseColor.LIGHT_GRAY);
                        
                        PdfPCell cell5 = new PdfPCell(new Paragraph("Candidates Seats"));
                        cell5.setBackgroundColor(BaseColor.LIGHT_GRAY);
       
                        table2.addCell(cell1);
                        table2.addCell(cell2);
                        table2.addCell(cell3);
                        table2.addCell(cell4);                        
                        table2.addCell(cell5);
                      
                        
                        
                        reslts.beforeFirst();
                        while(reslts.next())
                        {
                            PdfPCell cell8 = new PdfPCell(new Paragraph(reslts.getString(1)));
                            PdfPCell cell9 = new PdfPCell(new Paragraph(reslts.getString(2)));
                            PdfPCell cell10 = new PdfPCell(new Paragraph(reslts.getString(3)));
                            PdfPCell cell11 = new PdfPCell(new Paragraph(reslts.getString(4)));
                            PdfPCell cell12 = new PdfPCell(new Paragraph(reslts.getString(5)));
       
                            table2.addCell(cell8);
                            table2.addCell(cell9); 
                            table2.addCell(cell10);
                            table2.addCell(cell11); 
                            table2.addCell(cell12);
                            
                        }
                        table2.setFooterRows(1);
                        doc.add(table2);
                        Runtime.getRuntime().exec("rundll32 url.dll, FileProtocolHandler C:/Program Files/SeatDetailsReport.pdf");
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
