/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import Model.Security;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author User
 */
public class EncryptedDataTest {
    
    public EncryptedDataTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods connect with the data encryption function
    // in that case this unit test wether user pass word is correctly encrypted in 
    // AES (crypto) formate and its duplication 
    // 
     @Test
     public void TestEncryptedData() {
         Security dataencrypt=new Security();
         String encryptdata="";
         encryptdata=dataencrypt.CallMainFunction("Admin123");
         assertEquals("Pqo9M4kLvIlbz+FskB9bUg==", encryptdata);
         //it is in the correct formate and it is not duplicating 
         // [Test Passed]
     }
}
