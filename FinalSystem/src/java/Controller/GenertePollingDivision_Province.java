/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.SeatDetailsRpt;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "GenertePollingDivision_Province", urlPatterns = {"/GenertePollingDivision_Province"})
public class GenertePollingDivision_Province extends HttpServlet {

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
        SeatDetailsRpt rprtgenrter=new SeatDetailsRpt();
        try {
            if(request.getParameter("hiidenbtn")!=null)
             {
                request.getRequestDispatcher("PollingDivision_Province.jsp").forward(request, response);
                response.sendRedirect("PollingDivision_Province.jsp");
            }
            if(request.getParameter("btngnerate")!=null)
            {
                boolean reprt=false;
                HttpSession session=request.getSession(true);
                String provinceId = request.getParameter("provinceid");
                 if(provinceId!=null)
                 {
                     reprt= rprtgenrter.GenrateSeatDetails(provinceId);
                         if(reprt==true)
                         {
                            session.setAttribute("SectaryRegister", "Sucess");
                            response.sendRedirect("../FinalSystem/JspPages/PollingDivision_Province.jsp"); 
                         } 
                         else
                         {
                           session.setAttribute("SectaryRegister", "Error");
                           response.sendRedirect("../FinalSystem/JspPages/PollingDivision_Province.jsp");
                         }
                 }
            }
        }
        catch(Exception ex)
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
