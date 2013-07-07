/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.LoginDetails;
import Model.VoterRegister;
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
@WebServlet(name = "VotersLogin_Servlet", urlPatterns = {"/VotersLogin_Servlet"})
public class VotersLogin_Servlet extends HttpServlet {

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
         ArrayList userprof =new ArrayList();
        VoterRegister login=new VoterRegister();
        
        
        try {
             if(request.getParameter("loginBtn")!=null)
             {
                String _electcrdno=request.getParameter("ElctioncrdNo");
                String _nicNo=request.getParameter("Nicno");
                String _pooliId=request.getParameter("pollid");
                ResultSet rsltst=login.GetvoterLoginDetails(_nicNo,_pooliId);
                if(rsltst.next())
                {
                  String _encrptelctioncrdno= rsltst.getString(1);   
                  String _pollingdivID= rsltst.getString(3); 
                  String userid= rsltst.getString(4);
                  userprof.add(_pollingdivID);
                  userprof.add(userid);
                  String _plainelecrdNo=Md5Encryption.decrypt(_encrptelctioncrdno);
                  if(_plainelecrdNo.equalsIgnoreCase(_electcrdno)&& _pollingdivID.equals(_pooliId))
                  {
                          HttpSession session=request.getSession(true);
                          session.setAttribute("Admindetals", "Sucess");
                          session.setAttribute("userprof", userprof);
                          response.sendRedirect("../FinalSystem/JspPages/BallotForm.jsp");
                  }
                  else
                  {
                       HttpSession session=request.getSession(true);
                       session.setAttribute("Login", "Error");
                       response.sendRedirect("../FinalSystem/JspPages/Voterlog.jsp");
                  }
                }
             }
             
        }
        catch(Exception ex)
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
