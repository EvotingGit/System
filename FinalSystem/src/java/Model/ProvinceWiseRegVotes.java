/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import org.jfree.data.jdbc.JDBCCategoryDataset;

/**
 *
 * @author User
 */
public class ProvinceWiseRegVotes extends Dbconnection {
    Connection conn=Createconnection();
    
      public JDBCCategoryDataset RegistedvoteBarchart() {
        try
        {
            JDBCCategoryDataset dataset = new JDBCCategoryDataset(conn);
            String query="SELECT  provincetbl.ProvinceName, PollingDivisionTbl.RegisterdVoters,PollingDivisionTbl.VotedCount "+
                          " From `electionsystemdb`.`districtbl`, `electionsystemdb`.`PollingDivisionTbl` , `electionsystemdb`.`provincetbl` "+
                          " WHERE  provincetbl.ProvinceID=districtbl.ProvinceID AND PollingDivisionTbl.DistricID=districtbl.DistricID "+
                          " group by provincetbl.ProvinceID ";
            
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
