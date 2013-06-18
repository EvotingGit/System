/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.*;
import javax.crypto.*;
import java.security.*;
import java.security.spec.KeySpec;
import javax.crypto.spec.DESedeKeySpec;
import org.apache.catalina.util.Base64;
import sun.misc.*; 
import java.util.UUID;
/**
 *
 * @author User
 */
public class Testmd extends Dbconnection{
    
 java.sql.Connection conn=Createconnection();
    
public void insertimage(byte[] b) {
        boolean f=false;
    
     try
     {
         
        String sqlImageInsertDatabase="insert into upload_image (bImage) values(?)"; 
       
        java.sql.PreparedStatement prestate=conn.prepareStatement(sqlImageInsertDatabase);
        prestate.setBytes(1, b);
        prestate.executeUpdate(); 
      
     }
     catch(Exception ex)
     {
        throw new UnsupportedOperationException("Not yet implemented");
     }
    }

public ResultSet getimages() {
        try
        {
            ResultSet rs=null;
            String slectqry="SELECT bImage from upload_image";
            java.sql.PreparedStatement ps=conn.prepareStatement(slectqry);
            rs = ps.executeQuery(slectqry);  
                        
            return rs;
        }
        catch(Exception ex){
        throw new UnsupportedOperationException("Not yet implemented");
        }
    }
    
  
  public boolean  insertpass(String passw) throws SQLException
  {
       boolean f=false;
       String sqlinsert="insert into upload_image (bImage) values(?)";
       java.sql.PreparedStatement prepare=conn.prepareStatement(sqlinsert);
       prepare.setString(1, passw);
       return f;
  }
  
  public String  encrypt(String pass)
  {
      String plainData=pass,cipherText,decryptedText;
      try
      {
    KeyGenerator keyGen = KeyGenerator.getInstance("AES");
    keyGen.init(128);
    SecretKey secretKey = keyGen.generateKey();
    Cipher aesCipher = Cipher.getInstance("AES");
    aesCipher.init(Cipher.ENCRYPT_MODE,secretKey);
    byte[] byteDataToEncrypt = plainData.getBytes();
    byte[] byteCipherText = aesCipher.doFinal(byteDataToEncrypt);
    cipherText = new BASE64Encoder().encode(byteCipherText);
//    aesCipher.init(Cipher.DECRYPT_MODE,secretKey,aesCipher.getParameters());
//    byte[] byteDecryptedText = aesCipher.doFinal(byteCipherText);
//    decryptedText = new String(byteDecryptedText);
//    System.out.println("\n Plain Data : "+plainData+
//    " \n Cipher Data : "+cipherText+" \n Decrypte");
    return cipherText;
      }
      catch(Exception ex)
      {
          
      }
      return plainData;
  }
  
  
 public String CallMainFunction(String abc)
 {
   String Rest= encrypt(abc);
    return Rest;
    
 }
 
 


    public ResultSet chekpass() {
        ResultSet rs=null;
        try
        {
            Statement st=con.createStatement();
            rs=st.executeQuery("Select * from upload_image where iImageID='1'");
            return  rs;
       }
       catch(Exception ex)
       {
           ex.toString();
       }
        finally
        {
            return  rs;
        }
    }
            
}
