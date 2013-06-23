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
public class DuplicationUUIDTest {
    
    public DuplicationUUIDTest() {
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
    // The methods use to chaeck the unique ID which is generated is duplicated 
    // when calls to that function several times
     @Test
     public void TestUUIDuplication() {
        CreateUniqueID creteID=new CreateUniqueID();
        String Uid="";
        Uid=creteID.UniqueID();
        
        //check the unique ID is duplicating 
        assertEquals("46c77f8f-92e8-47d7-a651-47c408569298", Uid);   
    }
}
