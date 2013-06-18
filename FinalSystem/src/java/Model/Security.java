/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import sun.misc.BASE64Encoder;

/**
 *
 * @author User
 */
public class Security {
    
    public String CallMainFunction(String orinalpasswrd)
    {
        String Rest= encrypt(orinalpasswrd);
        return Rest;
    
    } 
    
    private String  encrypt(String orinalpasswrd)
    {
      String plainData=orinalpasswrd,encrptedText,decryptedText;
      try
      {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(128);
        SecretKey secretKey = keyGen.generateKey();
        Cipher aesCipher = Cipher.getInstance("AES");
        aesCipher.init(Cipher.ENCRYPT_MODE,secretKey);
        byte[] byteDataToEncrypt = plainData.getBytes();
        byte[] byteCipherText = aesCipher.doFinal(byteDataToEncrypt);
        encrptedText = new BASE64Encoder().encode(byteCipherText);
//        aesCipher.init(Cipher.DECRYPT_MODE,secretKey,aesCipher.getParameters());
//        byte[] byteDecryptedText = aesCipher.doFinal(byteCipherText);
//        
//        decryptedText = new String(byteDecryptedText);
//        System.out.println("\n Plain Data : "+plainData+
//        " \n Cipher Data : "+cipherText+" \n Decrypte");
        return encrptedText;
      }
      catch(Exception ex)
      {
          ex.toString();
          Logger.getLogger(Security.class.getName()).log(Level.SEVERE, "Error With Encrypt Password !", ex);
      }
      return plainData;
  }
    
    private String dencrypt(String encryptpswd)
    {
       String plainData=encryptpswd,encrptedText,decryptedText;
      try
      {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(128);
        SecretKey secretKey = keyGen.generateKey();
        Cipher aesCipher = Cipher.getInstance("AES");
        aesCipher.init(Cipher.ENCRYPT_MODE,secretKey);
        byte[] byteDataToEncrypt = plainData.getBytes();
        byte[] byteCipherText = aesCipher.doFinal(byteDataToEncrypt);
        encrptedText = new BASE64Encoder().encode(byteCipherText);
        aesCipher.init(Cipher.DECRYPT_MODE,secretKey,aesCipher.getParameters());
        byte[] byteDecryptedText = aesCipher.doFinal(byteCipherText);
        
        decryptedText = new String(byteDecryptedText);
        return decryptedText;
      }
      catch(Exception ex)
      {
          ex.toString();
          Logger.getLogger(Security.class.getName()).log(Level.SEVERE, "Error With Encrypt Password !", ex);
      }
      return plainData;
  }
     
     public String Decryption(String encryptpswd)
    {
        String Reset= dencrypt(encryptpswd);
        return Reset;
    
    } 
     
    
}
