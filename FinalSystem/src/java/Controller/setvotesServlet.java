/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.CandidatesModel;
import Model.ElectionPartyReg;
import Model.Testmd;
import Model.Votes;
import java.io.IOException;
import java.io.PrintWriter;
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
        ArrayList<CandidatesModel> candidateList = new ArrayList<CandidatesModel>();
       Testmd tst=new Testmd();
        try {
            if(request.getParameter("hidenvotes") !=null)
            {
           
                 String partyvote=request.getParameter("vote");
                 ResultSet resultSet=tst.Getcandiesbyparty(partyvote);
                 HttpSession session=request.getSession(true);
                 if(resultSet!=null)
                    {
                         String fullName=partyvote;
                         item.add(fullName);
                         
                          session.setAttribute("partyvote", item);
                          response.sendRedirect("../FinalSystem/JspPages/BallotFormTest.jsp");
                    }
                 else
                 {response.sendRedirect("../FinalSystem/JspPages/BallotFormTest_1.jsp");
                 }
            }
            else if(request.getParameter("prefvote") !=null)
                 {
                     
                     String candid=request.getParameter("checkbox1");
                     String prfer2=request.getParameter("checkbox2");
                     String prfer3=request.getParameter("checkbox3");
                     String hidnpolitic="01ec7040-1c57-4c27-ba4d-eb76a18c43cd";
                     String userid="1736ef4b-06cc-4ac3-ba45-ee20ebe48b33";//request.getParameter("");
                     Votes vt=new Votes();
                     vt.Insertvote(userid, hidnpolitic, candid, prfer2, prfer3);
                 }
         
          
          
          
//          
//          if(resultSet!=null)
//          {
//               HttpSession session=request.getSession(true);
//          request.setAttribute("resultSet", resultSet);
//          response.sendRedirect("../FinalSystem/JspPages/BallotFormTest.jsp");
//          }
//         
 
          //String x="";
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
