/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import Model.LoginDetails;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author User
 */
public class UserloginTest {
    
    public UserloginTest() {
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
   // The methods is going to test the userlogin function is logoic:
    @Test
    public void Testuserlogin() {
        LoginDetails login=new LoginDetails();
        boolean rslt=false;
        //if we try to add the same data (duplicate) it won`t  insert that data
        rslt=login.insertlogindetl("c05ccbe5-f4c6-4f85-93a8-e9011b0b319b", "Admin", "test123", "Administrator");
        assertEquals(true, rslt);
        //[Test Passed]
    }
}
