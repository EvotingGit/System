/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.ProvinceRegister;
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
@WebServlet(name = "ProvinceEdit_Servlet", urlPatterns = {"/ProvinceEdit_Servlet"})
public class ProvinceEdit_Servlet extends HttpServlet {

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
        ProvinceRegister province=new ProvinceRegister();
         ArrayList provincedetailslist=new ArrayList();
        PrintWriter out = response.getWriter();
        try {
         String ProvinceID=null;
                ProvinceID=request.getParameter("datatobesend");
                if(ProvinceID!=null){
                   provincedetailslist= province.GetProvincedata(ProvinceID);
                    HttpSession session=request.getSession(true);
                   if(provincedetailslist!=null ||  provincedetailslist.isEmpty() ){
                      
                        session.setAttribute("province", provincedetailslist);
                        response.sendRedirect("../FinalSystem/JspPages/ProvinceDetailsEdit.jsp");
                   }
                   else{
                        session.setAttribute("province", "");
                        response.sendRedirect("../FinalSystem/JspPages/ProvinceDetails.jsp");
                   }
                }
                else if(request.getParameter("provinceupdatebtn")!=null){
                    String ProvincehidnID=request.getParameter("hidnprovinceid");
                    String ProvinceCode=request.getParameter("provincode");
                    String ProvinceName=request.getParameter("provincename");
                        String ProDecription=request.getParameter("decrp");
                    String No_of_district=request.getParameter("Nodistrcs");
                    boolean relst= province.UpdateProvinces(ProvincehidnID,ProvinceCode,ProvinceName,ProDecription,No_of_district); 
                    if(relst==true){
                        response.sendRedirect("../FinalSystem/JspPages/ProvinceDetails.jsp");
                    }
           }
            
        }catch(Exception ex){
            ex.toString();
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
