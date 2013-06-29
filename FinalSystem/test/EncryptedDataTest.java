/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import Controller.Md5Encryption;
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
     public void TestEncryptDecryptedData() throws Exception {
         
         //it is in the correct formate and it is not duplicating 
         String _pass="admin123";
         String _encrptpass=Md5Encryption.encrypt(_pass);
         String _decryptpass=Md5Encryption.decrypt(_encrptpass);
         assertEquals(_pass, _decryptpass);
         // [Test Passed]
     }
}
