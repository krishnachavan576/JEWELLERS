package jewellers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/Forget")
public class ForgetId extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out=resp.getWriter();
		JDBConnection jd=new JDBConnection();
		
		String Fname=req.getParameter("Fist").strip();
		String Lname=req.getParameter("Last").strip();
		try {
		Connection con=jd.getConnection();
		PreparedStatement pt=con.prepareStatement(new JDBConnection().FORGET_PIN);	
		pt.setString(1, Fname.toUpperCase());
		pt.setString(2, Lname.toUpperCase());
		pt.executeLargeUpdate();
		ResultSet rs = pt.executeQuery();
		while (rs.next()) {
			out.println("<html><body><center>");
			out.println(
					"<style> table { width: 100%; border-collapse: collapse; border: 1px solid #ddd;} th, td{ padding: 8px;text-align: left;border-bottom: 1px solid #ddd;}th {background-color: #f2f2f2;} </style>");
			out.println("<table>"
					+ "<tr><th>ID</th><th>FIRST </th><th>LAST  </th><th>GRAM  </th><th>DATE   </th> <th>MONEY </th><th>GST </th></tr> "
					+ " <tr><td>" + rs.getString(1) + "</td><td>" + rs.getString(2) + "</td><td>" + rs.getString(3)
					+ "</td><td>" + rs.getString(4) + "</td><td>" + rs.getDate(5) + "</td> <td>" + rs.getString(6)
					+ "</td> <td>" + rs.getString(7) + "</td></tr></table>");
			out.println("<br><br><button> <a href=Home.html>BACK</a></button>");
			out.println("</center><body><html>");
		}
	} catch (SQLException e) {
out.println("<html><body><center>");
out.println("<button><a herf=Home.html><--BACK</a></button>");

out.println("</center><body><html>");
	}
}

	
}















