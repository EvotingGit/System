/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.CandidatesModel;
import Model.ElectionPartyReg;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author User
 */
@WebServlet(name = "BallotServlet", urlPatterns = {"/BallotServlet"})
public class BallotServlet extends HttpServlet {

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
    
 private static final long serialVersionUID = 1L;

 public BallotServlet() { }
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        ElectionPartyReg electiongrup=new ElectionPartyReg();
        ArrayList<CandidatesModel> candidateList = new ArrayList<CandidatesModel>();
        try {
            String politicl_Id = request.getParameter("postVariableName").toString(); 
            candidateList=electiongrup.GetCandiesbyPolitcalP_ID(politicl_Id);
            Gson gson = new Gson();
            JsonElement element = gson.toJsonTree(candidateList, new TypeToken<List<CandidatesModel>>(){}.getType());

            JsonArray jsonArray = element.getAsJsonArray();
            response.setContentType("application/json");
            response.getWriter().print(jsonArray);
               
        } 
        catch(Exception esd)
        {
            esd.toString();
        }finally {            
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
        
         ElectionPartyReg electiongrup=new ElectionPartyReg();
        ArrayList<CandidatesModel> candidateList = new ArrayList<CandidatesModel>();
        try {
            String politicl_Id = request.getParameter("postVariableName").toString(); 
            candidateList=electiongrup.GetCandiesbyPolitcalP_ID(politicl_Id);
            Gson gson = new Gson();
            JsonElement element = gson.toJsonTree(candidateList, new TypeToken<List<CandidatesModel>>(){}.getType());

            JsonArray jsonArray = element.getAsJsonArray();
            response.setContentType("application/json");
            response.getWriter().print(jsonArray);
               
        } 
        catch(Exception esd)
        {
            esd.toString();
        }
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
