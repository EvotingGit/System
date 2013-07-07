/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.MailSender;
import Model.forgetuserdetails;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author User
 */
@WebServlet(name = "ForgetPasswrd_Servlet", urlPatterns = {"/ForgetPasswrd_Servlet"})
public class ForgetPasswrd_Servlet extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        forgetuserdetails forgetuser=new forgetuserdetails();
        MailSender mail=new MailSender();
        try {
            if(request.getParameter("sendBtn")!=null)
            {
                 String usermail=request.getParameter("email");
                 String user=request.getParameter("usersname");
                 
                 ResultSet rsltst=forgetuser.Getforgetuserlogin(usermail,user);
                  if(rsltst.next())
                  {
                    String email=rsltst.getString(1);
                    String UserName=rsltst.getString(2);
                    String Password=rsltst.getString(3);
                    String DefultPass="defult123";
                    String encrypdefltpass=Md5Encryption.encrypt(DefultPass);
                    boolean defltrestlset=forgetuser.ResetPassword(UserName,encrypdefltpass);
                    if(defltrestlset==true)
                    {
                         boolean sendmail=mail.Senderpassword(email, DefultPass);
                            if(sendmail==true){
                                request.setAttribute("mailsend", "Sucess");
                                response.sendRedirect("../FinalSystem/JspPages/Forgetpass.jsp");
                            }
                            else{
                            request.setAttribute("mailsend", "Error");
                            response.sendRedirect("../FinalSystem/JspPages/Forgetpass.jsp");
                        } 
                    }
                   
                }
            } 
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }finally
        {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
