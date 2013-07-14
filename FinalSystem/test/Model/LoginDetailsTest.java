/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.ResultSet;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author nalin
 */
public class LoginDetailsTest {
    
    public LoginDetailsTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    /**
     * Test of insertlogindetl method, of class LoginDetails.
     */
    @Test
    public void testInsertlogindetl() {
        System.out.println("insertlogindetl");
        String UserId = "";
        String UserName = "";
        String Password = "";
        String Post = "";
        LoginDetails instance = new LoginDetails();
        boolean expResult = true;
        boolean result = instance.insertlogindetl(UserId, UserName, Password, Post);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of GetLoginDetails method, of class LoginDetails.
     */
    @Test
    public void testGetLoginDetails() {
        System.out.println("GetLoginDetails");
        String username = "";
        LoginDetails instance = new LoginDetails();
        ResultSet expResult = null;
        ResultSet result = instance.GetLoginDetails(username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
