/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.CreateUniqueID;
import Model.Testmd;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.KeyGenerator;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import java.util.Date;

/**
 *
 * @author User
 */
@WebServlet(name = "test", urlPatterns = {"/test"})
public class test extends HttpServlet {

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
//        byte[] b=null; 
//         
//        try {
//               DiskFileItemFactory factory = new DiskFileItemFactory(); 
//               ServletFileUpload sfu = new ServletFileUpload(factory); 
//               List items = sfu.parseRequest(request); 
//
//               Iterator iter = items.iterator(); 
//       
//                while (iter.hasNext()) { 
//                    FileItem item = (FileItem) iter.next(); 
//                    if (!item.isFormField()) { 
//                        b = item.get(); 
//                    } 
//                } 
//                Testmd tst=new Testmd();
//                tst.insertimage(b);
//                
//        }catch(Exception ex)
//        {
//            ex.toString();
//        }
//        finally {            
//            out.close();
//        }
//        try
//        {
//             System.out.println("inside jsp try");
//             Testmd tst=new Testmd();
//             ResultSet rsltst=tst.getimages();
//             String imgLen = "";  
//                while (rsltst.next()) {  
//                    imgLen = rsltst.getString(1);  
//                    System.out.println(imgLen.length());  
//                    int len = imgLen.length();  
//                    byte[] rb = new byte[len];  
//                    InputStream readImg = rsltst.getBinaryStream(1);  
//                    int index = readImg.read(rb, 0, len);  
//                    System.out.println("Index.........." + index);  
//  
//                    response.reset();  
//                    response.setContentType("image/jpg");  
//                    response.getOutputStream().write(rb, 0, len);  
//                    response.getOutputStream().flush();  
//                }  
//        }
//        catch(Exception ex)
//        {
//            System.out.println("Error" + ex);  
//        }
        try
        {
            String pass=request.getParameter("pro");
            String encryptPas=Md5Encryption.encrypt(pass);
            String plainpassagain=Md5Encryption.decrypt(encryptPas);
            
        }
        catch(Exception ex)
        {    
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
