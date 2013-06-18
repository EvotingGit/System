/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.ElectionPartyReg;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author User
 */
@WebServlet(name = "ElectPartyRegister_Servlet", urlPatterns = {"/ElectPartyRegister_Servlet"})
public class ElectPartyRegister_Servlet extends HttpServlet {

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
        
        byte[] logo=null; 
        ElectionPartyReg electionparty=new ElectionPartyReg();
        
        try {
           if(request.getParameter("ppartyregbtn")!=null)
           {
                //DiskFileItemFactory factory = new DiskFileItemFactory(); 
                //ServletFileUpload sfu = new ServletFileUpload(factory); 
                //List items = sfu.parseRequest(request); 
                //Iterator iter = items.iterator();
                
                String ElectioPcode=request.getParameter("electpcode");
                String ElectionPName=request.getParameter("electpcode");
                String RegisterDate=request.getParameter("regdate");
                /*while (iter.hasNext()) { 
                        FileItem item = (FileItem) iter.next(); 
                            if (!item.isFormField()) { 
                                logo = item.get(); 
                            }   
                    } */
                String sectryid=request.getParameter("secname"); 
                int candidateamunt=Integer.parseInt(request.getParameter("candiamount")); 
                
                boolean reslt=electionparty.InsertElecitonPartyDetaisl(ElectioPcode,ElectionPName,RegisterDate,logo,sectryid,candidateamunt);
                if(reslt==true)
                {
                     HttpSession session=request.getSession(true);
                     session.setAttribute("Register", "Sucess");
                     response.sendRedirect("~/JspPages/Adminregister.jsp");
                }
           }
        }
        catch(Exception exp)
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
