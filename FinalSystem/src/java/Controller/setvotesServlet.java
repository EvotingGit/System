/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
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
@WebServlet(name = "setvotesServlet", urlPatterns = {"/setvotesServlet"})
public class setvotesServlet extends HttpServlet {

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
        
        ElectionPartyReg electiongrup=new ElectionPartyReg();
        ArrayList item =new ArrayList();
        ArrayList candidateidlist =new ArrayList();
        Votes vote=new Votes();
        String PartyId="";
        HttpSession session=request.getSession(true);
        try {
            if(request.getParameter("hidenvotes") !=null)
            {
                 PartyId=request.getParameter("vote");
                 ResultSet resultSet=electiongrup.Getcandiesbyparty(PartyId);
                 
                 if(resultSet!=null)
                    {
                         item.add(PartyId);
                         session.setAttribute("partyvote", item);
                         response.sendRedirect("../FinalSystem/JspPages/BallotFormTest.jsp");
                    }
                 else{
                     response.sendRedirect("../FinalSystem/JspPages/BallotFormTest_1.jsp");
                 }
            }
            else if(request.getParameter("prefvote") !=null)
                 {
                     String[] checkboxNamesList=request.getParameterValues("checkbox");
                     for (int i = 0; i < checkboxNamesList.length; i++) {
                             String candidateid=checkboxNamesList[i];
                            // if null, it means checkbox is not in request
                            if (candidateid != null){
                                candidateidlist.add(candidateid.toString());       
                            }
                         }
                     String hidnpolitic= request.getParameter("politicalId");
                     String userid=request.getParameter("userId");
                     String encrpyuserid=Md5Encryption.encrypt(userid);
                     String pollingdidviosnId=request.getParameter("divisionid");
                     
                     boolean voterslt= vote.Insertvote(encrpyuserid, hidnpolitic,candidateidlist,pollingdidviosnId);
                     if(voterslt==true){
                          
                           ArrayList sucesvotedetails=new ArrayList();
                           VoteSummary votesumary=new VoteSummary();
                           
                           sucesvotedetails.add(userid);
                           sucesvotedetails.add(hidnpolitic);
                           sucesvotedetails.add(pollingdidviosnId);
                           votesumary.CreateVoteSummary(sucesvotedetails);
                           session.setAttribute("VoteSucess", "Sucess");
                           response.sendRedirect("../FinalSystem/JspPages/BallotFormTest.jsp");
                     }
                     else
                     {
                          session.setAttribute("VoteSucess", "Error");
                          response.sendRedirect("../FinalSystem/JspPages/BallotFormTest.jsp");
                     }
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
