/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.CreateUniqueID;
import Model.DistricRegister;
import Model.PollingDivisionRegister;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;
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
@WebServlet(name = "PollingDivisionRegister_Servlet", urlPatterns = {"/PollingDivisionRegister_Servlet"})
public class PollingDivisionRegister_Servlet extends HttpServlet {

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
        
        CreateUniqueID createUUid=new CreateUniqueID();
       try {
           if(request.getParameter("polldivisionregbtn")!=null);
           {
               String PollingDivisionID=createUUid.UniqueID();
               String PollingDivisionCode=request.getParameter("p_divisioncode");
               String PollingDivisionName=request.getParameter("p_divisionname");
               int RegPoliticalParty=Integer.parseInt(request.getParameter("Seatsamount"));
               int RegVotersamuont=0;//Integer.parseInt(request.getParameter("regisvoteramount"));
               int Votedamuont=0;
               String DistricID=request.getParameter("distrcid");
               
               HttpSession session=request.getSession(true);
               PollingDivisionRegister pollingDivisionRegmodel=new PollingDivisionRegister();
               boolean rslt = pollingDivisionRegmodel.InsertPollingDivision(PollingDivisionID, PollingDivisionCode, PollingDivisionName, RegPoliticalParty, RegVotersamuont, DistricID,Votedamuont);
               if(rslt==true)
                {       session.setAttribute("Register", "Sucess");
                        response.sendRedirect("../FinalSystem/JspPages/AddPollingDivisionDetails.jsp");
                }
               else
               {
                    session.setAttribute("Register", "Error");
                    response.sendRedirect("../FinalSystem/JspPages/AddPollingDivisionDetails.jsp");
               }
           }
        } finally {            
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
