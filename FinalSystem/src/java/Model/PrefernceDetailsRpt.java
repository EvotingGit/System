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
import org.jfree.data.jdbc.JDBCCategoryDataset;

/**
 *
 * @author User
 */
public class PrefernceDetailsRpt extends Dbconnection{
 
    Connection conn=Createconnection();
    
    public boolean GeneratePrefernceByPoliticlaID(String partyId) {
        boolean crtepdf=false; 
        ResultSet reslts = null;
        CallableStatement cs=null;
        String parm="All";
        try
        {  
            if(!partyId.equalsIgnoreCase(parm))
            {
                cs=conn.prepareCall("{call GetsinglecandidatePrefernceRpt(?)}");
                cs.setString(1, partyId);
                reslts = cs.executeQuery();
                crtepdf=CreateRepot(reslts); 
                return crtepdf;
            }
            else
            {
                cs=conn.prepareCall("{call GetAllPrefernceRpt()}");
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
    
    
    public JDBCCategoryDataset prefernceBarchart() {
        try
        {
            JDBCCategoryDataset dataset = new JDBCCategoryDataset(conn);
            String query="SELECT sysusertbl.FirstName,politicalpartytbl.PoliticalPartyCode,SUM(PrefernceCount) As PrefernceCount "+
                         " FROM preferencetbl,sysusertbl,votetable,politicalpartytbl WHERE sysusertbl.UserID=preferencetbl.CandidateID "+
                         " AND votetable.VoteID=preferencetbl.VoteID AND votetable.PoliPartyID=politicalpartytbl.PoliPartyID "+
                         " AND sysusertbl.UserType='Candidate' group by politicalpartytbl.PoliticalPartyCode";
            
           dataset.executeQuery(query);      
            return dataset;  
        }
        catch(Exception ex){
         ex.printStackTrace();
         System.err.println(ex.getMessage());
         throw new UnsupportedOperationException("Not yet implemented");
        }
    }
    
     public boolean  CreateRepot(ResultSet reslts)  
    {
        boolean flage=false;
        try{
         com.itextpdf.text.Document doc = new com.itextpdf.text.Document();
         PdfWriter.getInstance(doc, new FileOutputStream("C:/Program Files/PrefernceReport.pdf"));
         doc.open();

         if (reslts.next())
                     {
                        PdfPTable table1 = new PdfPTable(2); //Specifies the number of columns in the table
                        Font font = new Font(Font.FontFamily.TIMES_ROMAN,8,Font.BOLD);
                        table1.setSpacingBefore(12f);
                        
                        PdfPCell cellTitle = new PdfPCell(new Paragraph("Title"));
                        cellTitle.setBackgroundColor(BaseColor.LIGHT_GRAY);
                        PdfPCell cellVle = new PdfPCell(new Paragraph("Prefernce Details"));
                       
                        PdfPCell cellDept = new PdfPCell(new Paragraph("Political Party"));
                        cellVle.setBackgroundColor(BaseColor.LIGHT_GRAY);
                        PdfPCell cellVD = new PdfPCell(new Paragraph(reslts.getString(3)));
                        
                        table1.addCell(cellTitle);
                        table1.addCell(cellVle);
                        table1.addCell(cellDept);
                        table1.addCell(cellVD);
                        table1.setSpacingAfter(25f);
                        doc.add(table1);
                         
                        PdfPTable table2 = new PdfPTable(4); //4 Specifies the number of columns in the table
                        table2.setSpacingBefore(10f);
                        table2.setHorizontalAlignment(100); 
                        table2.setWidthPercentage(100);
                        
                        PdfPCell cell1 = new PdfPCell(new Paragraph("Full Name"));
                        cell1.setBackgroundColor(BaseColor.LIGHT_GRAY);
                                
                        PdfPCell cell2 = new PdfPCell(new Paragraph("Political Party"));
                        cell2.setBackgroundColor(BaseColor.LIGHT_GRAY);
                        
                        PdfPCell cell3 = new PdfPCell(new Paragraph("Preference votes"));
                        cell3.setBackgroundColor(BaseColor.LIGHT_GRAY);
   
                        table2.addCell(cell1);
                        table2.addCell(cell2);
                        table2.addCell(cell3);
        
                        reslts.beforeFirst();
                        while(reslts.next())
                        {
                            PdfPCell cell4 = new PdfPCell(new Paragraph(reslts.getString(1)+" "+ reslts.getString(2)));
                            PdfPCell cell5 = new PdfPCell(new Paragraph(reslts.getString(3)));
                            PdfPCell cell6= new PdfPCell(new Paragraph(reslts.getString(4)));

                            table2.addCell(cell4);
                            table2.addCell(cell5); 
                            table2.addCell(cell6);
                        }
                        doc.add(table2);
                        Runtime.getRuntime().exec("rundll32 url.dll, FileProtocolHandler C:/Program Files/PrefernceReport.pdf");
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
