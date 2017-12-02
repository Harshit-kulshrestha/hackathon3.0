import javax.servlet.*;
import javax.servlet.http.*;
import java .io.*;
import java.sql.*;
public class Feedback extends HttpServlet
{
public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
{
PrintWriter pw=res.getWriter();
pw.println("<html><body bgcolor='lavender'>");
pw.println("<center>");
String s1=req.getParameter("name");
String s2=req.getParameter("email");
String s3=req.getParameter("feedback");
int i=0;
try
{
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bhamasha","root","rat123");
String query="insert into feedback(username,email,feedback)values(?,?,?)";
PreparedStatement ps=con.prepareStatement(query);
		ps.setString(1, s1);
		ps.setString(2, s2);
		ps.setString(3, s3);
		 i=ps.executeUpdate();
		}
		catch (Exception e)
    {
        e.printStackTrace();
    } 
	if(i!=0)
	{
	pw.println("<h1>Thanku</h1>");
	
	}
	else
	{
		pw.println("<h1><font color='red'>Feedback failed</font></h1>");
		pw.println("<BR><a href='../feedback.html'>RETRY</a>");
	}
	
	pw.println("</center></body></html>");
	}
	}

	