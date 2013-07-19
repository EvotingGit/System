/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.activation.DataSource;
import javax.naming.Context;
import javax.naming.InitialContext;

/**
 *
 * @author User
 */
public class ProvinceRegister  extends Dbconnection{
    
    Connection conn=Createconnection();
    public List<CandidatesModel> stateList ;  
    private DataSource myDS;  
    private Context initCtx;  
    private Context envCtx;

    //this methode is use to insert the data of the province into database
    public boolean InsertProvince(String ProvinceID,String ProvinceCode,String ProvinceName,String Description,String NumberOfDestrict)
    {
        boolean flage=false;
        try
        {
             String query="INSERT INTO `electionsystemdb`.`ProvinceTbl`"+
                         "(ProvinceID,ProvinceCode,ProvinceName,Description,NumberOfDestrict)"+
                         "VALUES (?,?,?,?,?);";
             
             java.sql.PreparedStatement prestate=conn.prepareStatement(query);
             prestate.setString(1, ProvinceID);
             prestate.setString(2, ProvinceCode);
             prestate.setString(3, ProvinceName);
             prestate.setString(4, Description);
             prestate.setString(5, NumberOfDestrict);
             
             int result=prestate.executeUpdate();
             if(result>0){
                  flage=true;
                  return flage;
             }
             else{
                  return flage;
             }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            System.err.println(ex.getMessage());
            return flage;
        }
        finally
        {
            return flage;
        }
    }
    
    
    //this will get the province details and use to load the combo box in the JSP page
     public ResultSet LoadProviceCombo()
     {
         ResultSet rsltst=null;
         try
        {
            String slectqry="select ProvinceID,ProvinceName From  `electionsystemdb`.`ProvinceTbl`";
            PreparedStatement ps=con.prepareStatement(slectqry);
            rsltst=ps.executeQuery();
            
            return rsltst;
        }
        catch(Exception ex)
        {
            return rsltst;
        }
     }
     
     //this may use to virew the all information about the province details
     public ResultSet ViewProvince()
     {
         ResultSet rsltst=null;
         try
         {
            String slectqry="select * From `electionsystemdb`.`ProvinceTbl`";
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

    public boolean UpdateProvinces(String ProvinceID,String ProvinceCode,String ProvinceName,String ProDecription,String No_of_district) {
         boolean provinceupdaterslt=false;
         try
         {
            CallableStatement cs=Createconnection().prepareCall("{call updateprovinceDetails(?,?,?,?,?)}");
            cs.setString(1, ProvinceCode);
            cs.setString(2, ProvinceName);
            cs.setString(3, ProDecription);
            cs.setString(4, No_of_district);
            cs.setString(5, ProvinceID);
            
            int rslt=cs.executeUpdate();
            if(rslt>0){
                provinceupdaterslt=true;
            }
            return provinceupdaterslt;
         }
         catch(Exception ex)
         {
            ex.printStackTrace();
            System.err.println(ex.getMessage());
            return provinceupdaterslt;
         }
    }

    public ArrayList GetProvincedata(String ProvinceID) {
         ArrayList list=new ArrayList();
          ResultSet provinceitems=null;
         try
         {
            CallableStatement cs=Createconnection().prepareCall("{call GetprovinceDetails(?)}");
            cs.setString(1, ProvinceID);
            provinceitems = cs.executeQuery();
            if(provinceitems.next()){
                 list.add(provinceitems.getString(1)); 
                 list.add(provinceitems.getString(2)); 
                 list.add(provinceitems.getString(3)); 
                 list.add(provinceitems.getString(4)); 
                 list.add(provinceitems.getString(5)); 
            }
            return list;
         }
         catch(Exception ex)
         {
            ex.printStackTrace();
            System.err.println(ex.getMessage());
            return list;
         }
    }
}
