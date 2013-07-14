/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author nalin
 */
public class MailSenderTest {
    
    public MailSenderTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    /**
     * Test of Senderpassword method, of class MailSender.
     */
    @Test
    public void testSenderpassword() {
        System.out.println("Senderpassword");
        String sendermail = "cnalinhudson@gmail.com";
        String passwrd = "123";
        MailSender instance = new MailSender();
        boolean expResult = true;
        boolean result = instance.Senderpassword(sendermail, passwrd);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of SenderegisterSucess method, of class MailSender.
     */
    @Test
    public void testSenderegisterSucess() {
        System.out.println("SenderegisterSucess");
         String sendermail = "cnalinhudson@gmail.com";
        String passwrd = "123";
        MailSender instance = new MailSender();
        boolean expResult = true;
        boolean result = instance.SenderegisterSucess(sendermail, passwrd);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of Sendsucessvotedetails method, of class MailSender.
     */
    @Test
    public void testSendsucessvotedetails() {
        System.out.println("Sendsucessvotedetails");
        String sendermail = "cnalinhudson@gmail.com";
        String name = "123";
        String party = "abc";
        MailSender instance = new MailSender();
        boolean expResult = true;
        boolean result = instance.Sendsucessvotedetails(sendermail, name, party);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
}
