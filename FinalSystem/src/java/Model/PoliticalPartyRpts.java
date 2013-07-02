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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class PoliticalPartyRpts extends Dbconnection {
    
    Connection conn=Createconnection();
    
    public boolean GenrateSeatDetails(String Party_id)
    {  
       boolean crtepdf=false; 
       ResultSet reslts = null;
        CallableStatement cs=null;
        String param="All";
        try
        {  
            if(Party_id.equalsIgnoreCase(param))
            {
                cs=conn.prepareCall("{call GetAllpartyRpt()}");
                reslts = cs.executeQuery();
                crtepdf=CreatepoliticalpartyRepot(reslts); 
                return crtepdf;
            }
            else
            {
                cs=conn.prepareCall("{call GetsinglepartyRpt(?)}");
                cs.setString(1, Party_id);
                reslts = cs.executeQuery();
                crtepdf=CreatepoliticalpartyRepot(reslts); 
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
    
    public boolean  CreatepoliticalpartyRepot(ResultSet reslts)  
    {
       //DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
       Date date = new Date();
        boolean flage=false;
        try{
         com.itextpdf.text.Document doc = new com.itextpdf.text.Document();
         PdfWriter.getInstance(doc, new FileOutputStream("C:/Users/User/Desktop/completedigrams/PoliticalPartyReport.pdf"));
         doc.open();

         if (reslts.next())
                     {
                        PdfPTable table1 = new PdfPTable(2); //Specifies the number of columns in the table
                        Font font = new Font(Font.FontFamily.COURIER,5,Font.BOLD);
                        table1.setSpacingBefore(12f);
                        
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
                        table1.setSpacingAfter(12f);
                        doc.add(table1);
                         
                        PdfPTable table2 = new PdfPTable(5); //7 Specifies the number of columns in the table
                        table2.setSpacingBefore(10f);
                        
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
                        doc.add(table2);
                        Runtime.getRuntime().exec("rundll32 url.dll, FileProtocolHandler C:/Users/User/Desktop/completedigrams/PoliticalPartyReport.pdf");
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
