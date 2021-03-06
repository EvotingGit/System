/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.CreateUniqueID;
import Model.ElectionType;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
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
@WebServlet(name = "ElectionTypeRegister_Servlet", urlPatterns = {"/ElectionTypeRegister_Servlet"})
public class ElectionTypeRegister_Servlet extends HttpServlet {

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
        ElectionType electype=new ElectionType();
        CreateUniqueID createUUid=new CreateUniqueID();
        try {
            if(request.getParameter("eletypregbtn")!=null)
            {
                String ElectionTypeID=createUUid.UniqueID();
                String ElectionTypeCode=request.getParameter("electioncode");
                String ElectionType=request.getParameter("electyp");
                String Year=request.getParameter("year");

                boolean insertResltSet=electype.InsertElectionTypes(ElectionTypeID,ElectionTypeCode,ElectionType,Year);
                if(insertResltSet!=false){
                    HttpSession session=request.getSession(true);
                    session.setAttribute("EleTypeRset", insertResltSet);
                    response.sendRedirect("../FinalSystem/JspPages/ElectionTypes.jsp");
                    }
                }
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
