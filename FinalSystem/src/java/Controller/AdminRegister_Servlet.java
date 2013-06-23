/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.*;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;
import java.util.*;
import java.text.SimpleDateFormat;
import javax.servlet.http.*;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;
import org.apache.jasper.tagplugins.jstl.core.Catch;
import javax.servlet.http.Part;

import java.sql.ResultSet;
import java.text.DateFormat;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.fileupload.FileUploadException;
import java.util.Date;

/*
/**
 *
 * @author User
 */
@WebServlet(name = "AdminRegister_Servlet", urlPatterns = {"/AdminRegister_Servlet"})
public class AdminRegister_Servlet extends HttpServlet {

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
        AdminRegister adminReg=new AdminRegister();
        UserRegister userreg=new UserRegister();
        CandiRegister candiReg=new CandiRegister();
        Security securepass=new Security();
        VoterRegister voter=new VoterRegister();
        byte[] image=null; 

        try {
            if(request.getParameter("adminregbtn")!=null)
                {
                   // DiskFileItemFactory factory = new DiskFileItemFactory(); 
                   // ServletFileUpload sfu = new ServletFileUpload(factory); 
                    //List items = sfu.parseRequest(request); 
                    //Iterator iter = items.iterator();
                    
                    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
                    Date date = new Date();
                    String UserID=createUUid.UniqueID();
                    String userCode=request.getParameter("usercode");
                    String usertype=request.getParameter("usrtyp");
                    String fistname=request.getParameter("fname");
                    String lstname=request.getParameter("lname");
                    String gender=request.getParameter("gndr");
                    String birthdy=request.getParameter("birthday");
                    String mbno=request.getParameter("mbno");
                    String lndno=request.getParameter("lndno");
                    String nic=request.getParameter("nic");
                    String email=request.getParameter("e_mail");
                    
                    //String image=null; //request.getParameter("propic");
                    //while (iter.hasNext()) { 
                       // FileItem item = (FileItem) iter.next(); 
                          //  if (!item.isFormField()) { 
                              //  image = item.get(); 
                         //   }   
                    //} 
                    
                    String createdby=null;
                    String createddate=dateFormat.format(date);  
                    String updatedby=null;
                    String updateddate=null;
                    String usernm=request.getParameter("usernam");
                    String pass=request.getParameter("passwrd");
                    String encrptpass=securepass.CallMainFunction(pass);
                    
                    ResultSet rslt=userreg.insertUserdetails(UserID,userCode,usertype,fistname, lstname,gender,birthdy,mbno, lndno, nic, email,image,createdby,createddate,updatedby, updateddate);
                    if(rslt!=null)
                    {
                        //ResultSet rs=userreg.GetuserdetailsbyID(UserID,usertype);
                        if(rslt.next())
                        {
                            String UserId=rslt.getString(1);
                            String post=rslt.getString(2);
                            
                            if(post.equals("Administrator"))
                              {
                                String location=request.getParameter("loc");
                                boolean boolrs1=adminReg.insertAdminDetail(UserId, location, createdby,createddate,updatedby, updateddate,usernm,encrptpass,post);
                                if(boolrs1==true)
                                {
                                     HttpSession session=request.getSession(true);
                                     session.setAttribute("AdminRegister", "Sucess");
                                     response.sendRedirect("../FinalSystem/JspPages/Adminregister.jsp");
                                }
                              }
                            if(post.equals("Candidate"))
                            {
                                 String partyid=request.getParameter("politicalparty");
                                 String seat=request.getParameter("seat");
                                 String electNo=request.getParameter("electno");
                                 boolean boolrs1=candiReg.insertCandiDetail(UserId,partyid,seat,electNo,createdby,createddate,updatedby, updateddate,usernm,encrptpass,post);
                                 if(boolrs1==true)
                                {
                                     HttpSession session=request.getSession(true);
                                     session.setAttribute("CandidateRegister", "Sucess");
                                     response.sendRedirect("../FinalSystem/JspPages/CandidateList.jsp");
                                }
                            }
                              if(post.equals("Sectary"))
                            {
                                Sectary sectry=new Sectary();
                                String regparty=request.getParameter("regpoliparty");
                                boolean boolrs1=sectry.InsertSectaryDetails(UserId,regparty,createdby,createddate,updatedby, updateddate,usernm,encrptpass,post);
                                 if(boolrs1==true)
                                {
                                     HttpSession session=request.getSession(true);
                                     session.setAttribute("SectaryRegister", "Sucess");
                                     response.sendRedirect("../FinalSystem/JspPages/SecatryList.jsp");
                                }
                            }
                              if(post.equals("Voter"))
                            {
                                 String electuuid  =createUUid.UniqueID();
                                 CreateUniqueID.trimUUID(electuuid.toString());
                                 String stats="False"; 
                                 String poldiv=request.getParameter("polingdiv");
                                 String voterpass=request.getParameter("nic");
                                 String electNo=electuuid.toString();
                                 boolean vtrboolrs1=voter.InsertVoterDetails(UserId,electNo,poldiv,stats,createdby,createddate,updatedby, updateddate,voterpass,post);
                                 if(vtrboolrs1==true)
                                {
                                     HttpSession session=request.getSession(true);
                                     session.setAttribute("Register", "Sucess");
                                     response.sendRedirect("../Evoting/JspPages/Adminregister.jsp");
                                }
                            }
                            
                        }
                        else
                        {
                             HttpSession session=request.getSession(true);
                             session.setAttribute("RegisterError", "Error");
                             response.sendRedirect("../Evoting/JspPages/Adminregister.jsp");
                        }
                    } 
                    else 
                    {
                         HttpSession session=request.getSession(true);
                         session.setAttribute("RegisterError", "Error");
                         response.sendRedirect("../Evoting/JspPages/Adminregister.jsp");
                    }                  
                }
        } 
        catch(Exception ex)
        {
            System.out.print(ex);
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
       //try {
            processRequest(request, response);
//        } catch (FileUploadException ex) {
////            Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
////        }
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
//         try {
            processRequest(request, response);
//        } 
//         catch (FileUploadException ex) {
//            Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
//        }
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
