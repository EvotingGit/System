/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.CreateUniqueID;
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
@WebServlet(name = "ProvinceRegister_Servlet", urlPatterns = {"/ProvinceRegister_Servlet"})
public class ProvinceRegister_Servlet extends HttpServlet {

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
           if(request.getParameter("provinceregbtn")!=null);
           {             
               String ProvinceID=createUUid.UniqueID();
               String ProvinceCode=request.getParameter("provincode");
               String ProvinceName=request.getParameter("provincename");
               String ProDecription=request.getParameter("decrp");
               String No_of_district=request.getParameter("Nodistrcs");
               
               HttpSession session=request.getSession(true);
               ProvinceRegister provincemodel=new ProvinceRegister();
               boolean rslt = provincemodel.InsertProvince(ProvinceID, ProvinceCode, ProvinceName, ProDecription, No_of_district);
               if(rslt==true){ 
                        session.setAttribute("Register", "Sucess");
                        response.sendRedirect("../FinalSystem/JspPages/ProvinceDetails.jsp");
                }
               else {
                   session.setAttribute("Register", "Error");
                   response.sendRedirect("../FinalSystem/JspPages/ProvinceDetails.jsp");
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
