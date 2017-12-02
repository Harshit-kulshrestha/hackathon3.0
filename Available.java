import javax. servlet.*;
import javax. servlet.http.*;
import java .io.*;
import java.sql.*;
public class Available extends HttpServlet
{
public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
{
PrintWriter pw=res.getWriter();
pw.println("<html>");
pw.println("<body bgcolor='cyan'>");
pw.println("<center><marquee><h1>list of all services</center></marquee></h1>");
pw.println("<BR><table border=1>");
pw.println("<tr>");
pw.println("<th>HOSPITALS</th>");
pw.println("<th>SHOPS</th>");
pw.println("<th>RASHAN SHOPS</th>");
pw.println("<th>GOVERNMENT-DEPARTMENT</th>");
pw.println("<th>FREE-SERVICES</th>");
pw.println("<th>AARTHIK-SAHAYTA</th>");
pw.println("</tr>");
try
{

Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ebook","root","rat");
String query="select * from login";
PreparedStatement ps=con.prepareStatement(query);
ResultSet rs=ps.executeQuery();
while(rs.next())
{
String s1=rs.getString(1);
String s2=rs.getString(2);
String s3=rs.getString(3);
String s4=rs.getString(4);
String s5=rs.getString(5);
String s6=rs.getString(6);
pw.println("<tr>");
pw.println("<td>"+s1+"</td>");
pw.println("<td>"+s2+"</td>");
pw.println("<td>"+s3+"</td>");
pw.println("<td>"+s4+"</td>");
pw.println("<td>"+s5+"</td>");
pw.println("<td>"+s6+"</td>");
pw.println("</tr>");
}
}
catch(Exception e)
{
      e.printStackTrace();
	  }
	  pw.println("</tr>");
	  pw.println("</center></body></html>");
	 
	  }
	  }