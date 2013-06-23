/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.UUID;

/**
 *
 * @author User
 */
public class CreateUniqueID {
    
    public void CreateUniqueID(String uuid)
    {
        trimUUID(uuid);
    }
    
    public String UniqueID()
    { 
        UUID GenrateUUID= UUID.randomUUID();
        return GenrateUUID.toString();
    }
    
    public static String trimUUID(String uuid)
     { 
        char[] uuidChars = uuid.toCharArray();
        String newUUID ="";
        for(int i = 0; i<10;i++)
        {
            newUUID += uuidChars[i];
        }                           
        return newUUID;
    }  
}
