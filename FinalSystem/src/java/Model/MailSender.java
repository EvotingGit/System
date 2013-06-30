/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.MultiPartEmail;

/**
 *
 * @author User
 */
public class MailSender {
    
    public boolean Senderpassword(String sendermail, String passwrd)
    {
        boolean flage=false;
        String myEmailId = "hudsonuniversity@gmail.com";
        String myPassword = "hudson@university";
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
}
