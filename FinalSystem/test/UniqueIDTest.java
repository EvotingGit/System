/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import Model.CreateUniqueID;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author User
 */
public class UniqueIDTest {
    
    public UniqueIDTest() {
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
    // The methods use to generate a unique Id before inserting record into the database 
    // and this method is generate a 36 characters key witch is unique as well.
    //this test function is use for test that function generated values are 36 charcters
    @Test
    public void TestUUIDLength() {
        CreateUniqueID creteID=new CreateUniqueID();
        String Uid="";
        Uid=creteID.UniqueID();
        int UUIdlength= Uid.length();
        
//      check the length of unique ID
//      {Test is Passed}
        assertEquals(36, UUIdlength);   
    }
   
    
}
