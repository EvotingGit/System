/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.CreateUniqueID;
import Model.DistricRegister;
import Model.ProvinceRegister;
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
@WebServlet(name = "DistrictRegister_Servlet", urlPatterns = {"/DistrictRegister_Servlet"})
public class DistrictRegister_Servlet extends HttpServlet {

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
        
        CreateUniqueID createUUid=new CreateUniqueID();
        PrintWriter out = response.getWriter();
       try {
           if(request.getParameter("districtregbtn")!=null);
           {
               String DistricID=createUUid.UniqueID();
               String DistricCode=request.getParameter("districtcode");
               String DistricName=request.getParameter("districtname");
               String NumberOfPollingDivitions=request.getParameter("Nodistrcs");
               String ProvinceID=request.getParameter("provinceid");
               
               HttpSession session=request.getSession(true);
               DistricRegister districRegmodel=new DistricRegister();
               boolean rslt = districRegmodel.InsertDistrict(DistricID, DistricCode, DistricName, NumberOfPollingDivitions, ProvinceID);
               if(rslt==true) {
                    session.setAttribute("Register", "Sucess");
                    response.sendRedirect("../FinalSystem/JspPages/AddDistricDetails.jsp");
                }
               else {
                   session.setAttribute("Register", "Sucess");
                   response.sendRedirect("../FinalSystem/JspPages/AddDistricDetails.jsp");
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
