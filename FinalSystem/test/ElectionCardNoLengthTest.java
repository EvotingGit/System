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
public class ElectionCardNoLengthTest {
    
    public ElectionCardNoLengthTest() {
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
    // The methods use to check the electioncard number
    //which is automatically generate 

     @Test
     public void ElectionCardNoLength() {
         //if the passing value is UUID (randum) then check the output is contain 10 charcters values
         // which is first 10 number of the passed UUID
         String ecrdNo=CreateUniqueID.trimUUID("46c77f8f-92e8-47d7-a651-47c408569298");
         //{Test is Passed}
         assertEquals("46c77f8f-9", ecrdNo);   
         
     }
}
