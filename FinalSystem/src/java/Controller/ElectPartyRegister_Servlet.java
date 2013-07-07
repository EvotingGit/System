/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.CreateUniqueID;
import Model.ElectionPartyReg;
import Model.ElectionType;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
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
        
        CreateUniqueID createUUid=new CreateUniqueID();
        byte[] logo=null; 
        ElectionPartyReg electionparty=new ElectionPartyReg();
        
        try {
           if(request.getParameter("ppartyregbtn")!=null)
           {
                //DiskFileItemFactory factory = new DiskFileItemFactory(); 
                //ServletFileUpload sfu = new ServletFileUpload(factory); 
                //List items = sfu.parseRequest(request); 
                //Iterator iter = items.iterator();
                String PoliPartyID=createUUid.UniqueID();
                String ElectioPcode=request.getParameter("electpcode");
                String ElectionPName=request.getParameter("partyname");
                String RegisterDate=request.getParameter("regdate");
                /*while (iter.hasNext()) { 
                        FileItem item = (FileItem) iter.next(); 
                            if (!item.isFormField()) { 
                                logo = item.get(); 
                            }   
                    } */
                String electypeid=request.getParameter("electype"); 
                int candidateamunt=Integer.parseInt(request.getParameter("candiamount")); 
                
                boolean reslt=electionparty.InsertElecitonPartyDetaisl(PoliPartyID,ElectioPcode,ElectionPName,RegisterDate,logo,electypeid,candidateamunt);
                 HttpSession session=request.getSession(true);
                if(reslt==true)
                {
                       
                        session.setAttribute("ElectPartyRegister", "Sucess");
                        response.sendRedirect("../FinalSystem/JspPages/PoliticalPartyList.jsp");
                }
                else
                {
                    session.setAttribute("ElectPartyRegister", "Error");
                    response.sendRedirect("../FinalSystem/JspPages/ElectionPartyregister.jsp");
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
