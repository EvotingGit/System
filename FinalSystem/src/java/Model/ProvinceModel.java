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
    
    private String provinceID;  
    private String provinceName;  
  
    public ProvinceModel()  
    {  
    }  
      
    public void ProvinceModel(String provinceID,String provinceName)  
    {  
        this.provinceID = provinceID ;  
        this.provinceName = provinceName;  
    }  
  
    public String getID()  
    {  
        return this.provinceID ;  
    }  
      
    public String getName()  
    {  
        return this.provinceName ;  
    }

}
