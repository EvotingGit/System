/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.MultiPartEmail;

/**
 *
 * @author User
 */
public class MailSender {
    
    String myEmailId = "electionvotecounting@gmail.com";
    String myPassword = "electionvote@count";
        
    public boolean Senderpassword(String sendermail, String passwrd)
    {
        boolean flage=false;
     
        try {
            MultiPartEmail email = new MultiPartEmail();
            email.setSmtpPort(587);
            email.setAuthenticator(new DefaultAuthenticator(myEmailId, myPassword));
            email.setDebug(true);
            email.setHostName("smtp.gmail.com");
            email.setFrom(myEmailId);
            email.setSubject("Hi, ");
            email.setMsg("This is a Regarding your Login Detail ... :-)\n\n and This is Your Password : "+ passwrd +" \n\nThanks,\n Administrator");
            email.addTo(sendermail);
            email.setTLS(true);

            /*EmailAttachment attachment = new EmailAttachment();
            attachment.setPath("/Users/fahadparkar/Desktop/Fahim/tables.xlsx");
            attachment.setDisposition(EmailAttachment.ATTACHMENT);
            attachment.setDescription("Excel");
            attachment.setName("tables.xlsx");
            email.attach(attachment);*/

            email.send();
            flage=true;
            return flage;
            
        }
        catch (Exception e) 
        {
            //System.out.println("Exception :: " + e);
            return flage;
        }
    }
    
     public boolean SenderegisterSucess(String sendermail, String passwrd)
    {
        boolean flage=false;
        
        try {
            MultiPartEmail email = new MultiPartEmail();
            email.setSmtpPort(587);
            email.setAuthenticator(new DefaultAuthenticator(myEmailId, myPassword));
            email.setDebug(true);
            email.setHostName("smtp.gmail.com");
            email.setFrom(myEmailId);
            email.setSubject("Hi, ");
            email.setMsg("This is a Regarding your Sucesfull registration with the Evoting System ... :-)\n\n and This is Your Password : "+ passwrd +" \n\nThanks,\n Administrator");
            email.addTo(sendermail);
            email.setTLS(true);
            email.send();
            flage=true;
            return flage;
            
        }
        catch (Exception e) 
        {
           Logger.getLogger(UserRegister.class.getName()).log(Level.SEVERE, "Mail send fails ", e);
            return flage;
        }
    }
     
      public boolean Sendsucessvotedetails(String sendermail,String name,String party)
    {
        boolean flage=false;
        
        try {
            MultiPartEmail email = new MultiPartEmail();
            email.setSmtpPort(587);
            email.setAuthenticator(new DefaultAuthenticator(myEmailId, myPassword));
            email.setDebug(true);
            email.setHostName("smtp.gmail.com");
            email.setFrom(myEmailId);
            email.setSubject("Hi, ");
            email.setMsg("This is a Regarding your Sucesfull voting summary ... :-)\n\n Voter Full Name : "+ name +" \n\n Voted Party :"+party+" \n\n Thank you,\n Administrator");
            email.addTo(sendermail);
            email.setTLS(true);
            email.send();
            flage=true;
            return flage;
            
        }
        catch (Exception e) 
        {
           Logger.getLogger(UserRegister.class.getName()).log(Level.SEVERE, "Mail send fails ", e);
            return flage;
        }
    }
}
