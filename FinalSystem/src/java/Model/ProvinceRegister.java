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
    public List<ProvinceModel> stateList ;  
    private DataSource myDS;  
    private Context initCtx;  
    private Context envCtx;

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
       try  
        {  
          initCtx  =  new  InitialContext();  
          envCtx  =  (Context)  initCtx.lookup("java:comp/env");  
          myDS    =  (DataSource) envCtx.lookup("jdbc/test");  
        }   
        catch (Exception e)  
        {  
            System.out.println(e);  
        }  
         
        try
        {
            String slectqry="select ProvinceID,ProvinceName From  `electionsystemdb`.`ProvinceTbl`";
            PreparedStatement ps=con.prepareStatement(slectqry);
            rsltst=ps.executeQuery();
            while(rsltst.next())
            {
               String provinceID=rsltst.getString("ProvinceID");
               String provinceName=rsltst.getString("ProvinceName");
               ProvinceModel province=new ProvinceModel(provinceID,provinceName);
               stateList.add(province);
            }
            
        }
        catch(Exception exp)
        {
            exp.toString();
        }
        return stateList;
    }
    
     public ResultSet LoadProviceCombo()
     {
         ResultSet rsltst=null;
         try
        {
           /* CallableStatement cs=Createconnection().prepareCall("{call CountAsignTask(?)}");
            cs.setString(1, empid);
            rs = cs.executeQuery();*/
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
}
