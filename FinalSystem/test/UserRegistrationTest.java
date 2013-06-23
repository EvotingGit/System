/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import Model.UserRegister;
import java.sql.ResultSet;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author User
 */
public class UserRegistrationTest {
    
    public UserRegistrationTest() {
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
    
    // The methods check whther the userdetails table (Parent table) get insert the data and after that 
    // the relevent user table insertion also should happen
    @Test
    public void TestInsertUserdetails() {
    
        UserRegister userregstertest=new UserRegister();
        byte[] image=null;
        ResultSet Rset=null;
        // this function use to check wether the insertUserdetails function accept all the null values that 
        // are passed to the function {Mainly the unique value can contain empty or null}
        Rset=userregstertest.insertUserdetails(null, null, null, null, null, null, null, null, null, null, null, image, null, null, null, null);
        //fuction not accepting the null values for UserID, User code
        // {Test Passed}
        assertEquals(null, Rset);

    }
}
