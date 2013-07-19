/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import org.jfree.data.jdbc.JDBCCategoryDataset;

/**
 *
 * @author User
 */
public class ChartDetails extends Dbconnection{
    Connection conn=Createconnection(); 
     
     
    public JDBCCategoryDataset Barchart() {
        try
        {
            JDBCCategoryDataset dataset = new JDBCCategoryDataset(conn);
            String query="select politicalpartytbl.PoliticalPartyCode as PoliticalParty, SUM(No_of_Candidates) as CandidatesAmount "+
                         " from politicalpartytbl,candidatetble Where politicalpartytbl.PoliPartyID=candidatetble.PoliPartyID "+
                         " Group By politicalpartytbl.PoliticalPartyCode ";
            //java.sql.PreparedStatement ps=conn.prepareStatement(query);
            //ps.executeQuery();
             dataset.executeQuery(query);      
            return dataset; 
            
           
        }
        catch(Exception ex){
         ex.printStackTrace();
         System.err.println(ex.getMessage());
         throw new UnsupportedOperationException("Not yet implemented");
        }
    }
    
}
