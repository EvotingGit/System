/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author User
 */
public class ProvinceModel {
    
    public String provinceID;  
    public String provinceName;  
  
 
    ProvinceModel(String ProId, String ProvName) {
        this.provinceID = ProId ;  
        this.provinceName = ProvName;  
    }
      
//    public void ProvinceModel(String provinceID,String provinceName)  
//    {  
//       
//    }  
  
    public String getID()  
    {  
        return this.provinceID ;  
    }  
      
    public String getName()  
    {  
        return this.provinceName ;  
    }

}
