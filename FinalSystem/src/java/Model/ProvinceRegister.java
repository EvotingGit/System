/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class ProvinceRegister  extends Dbconnection{
    
    Connection conn=Createconnection();
    private List<ProvinceModel> stateList ;  

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
    
    public List<ProvinceModel> getStateList() 
    {
        ResultSet rsltst=null;
        stateList=new ArrayList<ProvinceModel>();
        ProvinceModel province=new ProvinceModel();
        try
        {
            String slectqry="select ProvinceID,ProvinceName From  `electionsystemdb`.`ProvinceTbl`";
            PreparedStatement ps=con.prepareStatement(slectqry);
            rsltst=ps.executeQuery();
            while(rsltst.next())
            {
               String ProId=rsltst.getString("ProvinceID");
               String ProvName=rsltst.getString("ProvinceName");
               province.ProvinceModel(ProId,ProvName);
               stateList.add(province);
               
            }
            
        }
        catch(Exception exp)
        {
            exp.toString();
        }
        return stateList;
    }
}
