/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Dbconnection;
import java.awt.BasicStroke;
import java.awt.Color;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import java.io.OutputStream;
import java.sql.SQLException;
import org.jfree.chart.entity.StandardEntityCollection;
import org.jfree.data.jdbc.JDBCPieDataset;

/**
 *
 * @author User
 */
@WebServlet(name = "PieChartDemo", urlPatterns = {"/PieChartDemo"})
public class PieChartDemo extends HttpServlet {

    private static final long serialVersionUID=1L;
    
    public PieChartDemo(){}
    
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
        try {
            Dbconnection dbcon=new  Dbconnection();
            Connection connection= dbcon.Createconnection();
         // if(request.getParameter("hiidenchrtbtn1")!=null){
              
              JDBCPieDataset dataset = new JDBCPieDataset(connection);
              try {
                    dataset.executeQuery("SELECT ProvinceTbl.ProvinceName,pollingdivisiontbl.CandidatesSeats"
                                       + " FROM  electionsystemdb.ProvinceTbl,electionsystemdb.districtbl,electionsystemdb.pollingdivisiontbl "+
                                         " WHERE ProvinceTbl.ProvinceID=districtbl.ProvinceID AND  PollingDivisionTbl.DistricID=districtbl.DistricID");
                    JFreeChart chart = ChartFactory.createPieChart("Country - Revenue Chart", dataset, true, true, false);
                    chart.setBorderPaint(Color.black);
                    chart.setBorderStroke(new BasicStroke(10.0f));
                    chart.setBorderVisible(true);
                    if (chart != null) {
                    int width = 500;
                    int height = 350;
                    final ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
                    response.setContentType("image/png");
                    //ChartUtilities.writeChartAsPNG(out, chart, width, height,info);
}
              }
             catch (SQLException e) {
                e.printStackTrace();
                }
          // }
        }catch(Exception ex)
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
        try {
          if(request.getParameter("hiidenchrtbtn")!=null){
              Dbconnection dbcon=new  Dbconnection();
              Connection connection= dbcon.Createconnection();
              JDBCPieDataset dataset = new JDBCPieDataset(connection);
              try {
                   dataset.executeQuery("SELECT ProvinceTbl.ProvinceName,pollingdivisiontbl.CandidatesSeats"
                                       + " FROM  electionsystemdb.ProvinceTbl,electionsystemdb.districtbl,electionsystemdb.pollingdivisiontbl "+
                                         " WHERE ProvinceTbl.ProvinceID=districtbl.ProvinceID AND  PollingDivisionTbl.DistricID=districtbl.DistricID");
                    JFreeChart chart = ChartFactory.createPieChart("Country - Revenue Chart", dataset, true, true, false);
                    chart.setBorderPaint(Color.black);
                    chart.setBorderStroke(new BasicStroke(10.0f));
                    chart.setBorderVisible(true);
                    if (chart != null) {
                    int width = 500;
                    int height = 350;
                    final ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
                    response.setContentType("image/png");
                    OutputStream out=response.getOutputStream();
                    ChartUtilities.writeChartAsPNG(out, chart, width, height,info);
                    //OutputStream out=response.getOutputStream();
                   // ChartUtilities.writeChartAsPNG(out, chart, width, height,info);
}
              }
                catch (SQLException e) {
                e.printStackTrace();
                }
           }
        }catch(Exception ex)
        {
            ex.toString();
        }
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
