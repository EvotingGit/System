/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Votes;
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
 * @author nalin
 */
@WebServlet(name = "AdminDash_Servlet", urlPatterns = {"/AdminDash_Servlet"})
public class AdminDash_Servlet extends HttpServlet {

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
        ArrayList progresslist=new ArrayList();
        Votes vote=new Votes();
        HttpSession session=request.getSession(true);
        try {
           if(request.getAttribute("hidenprogress")!=null)
           {
               //ResultSet prgresRslt=vote.CurrentPrgress();
               //if(prgresRslt.next())
//               {
//                   String progressofpartyName=prgresRslt.getString(1); 
//                   String progressofpartyValue=prgresRslt.getString(2); 
//                   progresslist.add(progressofpartyName);
//                   progresslist.add(progressofpartyValue);
//                   session.setAttribute("progresslist", progresslist);
//                   response.sendRedirect("../FinalSystem/JspPages/AdminDash.jsp");
//               }
//               else{
//                   session.setAttribute("progresslist", progresslist);
//                   response.sendRedirect("../FinalSystem/JspPages/AdminDash.jsp");
//               }
           }else{
               response.sendRedirect("../FinalSystem/JspPages/AdminDash.jsp");
           }
           
        }catch(Exception ex)
        {
            ex.toString();
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
