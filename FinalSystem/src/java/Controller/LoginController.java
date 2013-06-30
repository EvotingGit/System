/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.AdminRegister;
import Model.LoginDetails;
import Model.UserRegister;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author User
 */
@WebServlet(name = "LoginController", urlPatterns = {"/LoginController"})
public class LoginController extends HttpServlet {

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
        
        UserRegister users=new UserRegister();
        LoginDetails login=new LoginDetails();
        HttpSession session=request.getSession(true);
         
        try {
           if(request.getParameter("loginBtn")!=null)
            {
                String user=request.getParameter("username");
                String planepass=request.getParameter("password");
                
                ResultSet rsltst=login.GetLoginDetails(user);
                if(rsltst.next())
                {
                  String encrptpass= rsltst.getString(6);   
                  String plainpassagain=Md5Encryption.decrypt(encrptpass);
                  if(plainpassagain.equalsIgnoreCase(planepass))
                  {
                     String userId=rsltst.getString(1); 
                     String fstName=rsltst.getString(2);
                     String lstName=rsltst.getString(3);
                     String usertype=rsltst.getString(4);
                     if(usertype.equals("Administrator"))
                     {
                         ArrayList list =new ArrayList();
                         String fullName=fstName +" "+ lstName;
                          list.add(fullName);
                          list.add(userId);
                          list.add(usertype);
                          session.setAttribute("Admindetals", list);
                          response.sendRedirect("../FinalSystem/JspPages/FINAL_TEMP_1.jsp");
                     }
                    
                  }               
                }
            }
        }
        catch(Exception exp)
        {
            
        }
        finally {            
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
