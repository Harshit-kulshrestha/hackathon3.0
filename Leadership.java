import javax.servlet.*;
import javax.servlet.http.*;
import java .io.*;
import java.sql.*;
public class Leadership extends HttpServlet
{
public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
{
PrintWriter pw=res.getWriter();
pw.println("<html><body bgcolor='lavender'>");
pw.println("<center>");
String s1=req.getParameter("name");
String s2=req.getParameter("ad");
String s3=req.getParameter("adress");
String s4=req.getParameter("number");
String s5=req.getParameter("field");

int i=0;
try
{
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bhamasha","root","rat123");
String query="insert into leadership(name,aadhar,adress,number,field)values(?,?,?,?,?)";
PreparedStatement ps=con.prepareStatement(query);
		ps.setString(1, s1);
		ps.setString(2, s2);
		ps.setString(3, s3);
		ps.setString(4, s4);
		ps.setString(5, s5);
		 i=ps.executeUpdate();
		}
		catch (Exception e)
    {
        e.printStackTrace();
    } 
	if(i!=0)
	{
	pw.println("<h1>thanku</br></h1>");
	
	}
	else
	{
		pw.println("<h1><font color='red'>Sorry try again</font></h1>");
		pw.println("<BR><a href='../leadership.html'>RETRY</a>");
	}
	
	pw.println("</center></body></html>");
	}
	}

	