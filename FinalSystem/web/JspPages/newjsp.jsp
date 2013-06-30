<%-- 
    Document   : newjsp
    Created on : Jun 25, 2013, 10:01:10 PM
    Author     : User
--%>

<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%  
      String poli_id = request.getParameter("p_id").toString(); // query string capture
      %>
      alert(poli_id);
      <% String  data ="";
      Connection conn = null;
      int sumcount=0;
      Statement st;
    try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/electionsystemdb", "root", "");
            String query = "SELECT  candidatetble.UserID, candidatetble.PreferenceNo,sysusertbl.FirstName,sysusertbl.LastName "+
                           " FROM electionsystemdb.candidatetble,electionsystemdb.sysusertbl,electionsystemdb.politicalpartytbl "+
                           " WHERE  candidatetble.UserID=sysusertbl.UserID AND candidatetble.PoliPartyID=politicalpartytbl.PoliPartyID "+
                           " AND  candidatetble.PoliPartyID='"+poli_id.trim()+"'";
            st = conn.createStatement();
            ResultSet  rs = st.executeQuery(query);
                while(rs.next())
                {
                    String cid=rs.getString(1);
                    String cNo=rs.getString(2);
                    String candiFstName=rs.getString(3);
                    String candiLstName=rs.getString(4);
                    String FulName=candiFstName+" "+ candiLstName;
                    
                    data = ":" + cid + ":" + cNo+" "+ FulName;  // data concatenation separated via  ?:?
                }
                out.println(data);  // used to send data to the response object of the combo.jsp
        }
        catch (Exception e) {
             e.printStackTrace();
    }
 %>