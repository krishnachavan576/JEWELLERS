package jewellers;

import java.io.IOException; 
import java.io.PrintWriter;
import java.sql.Connection;

import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Reg")
public class Restaition extends HttpServlet {

	static double gst1;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();

		String first = req.getParameter("Name");

		String last = req.getParameter("Lname");

		int gm = Integer.parseInt(req.getParameter("gm"));

		String Date = req.getParameter("date");

		int id = Integer.parseInt(req.getParameter("id"));

		double monay = 0;

		monay = gm * 6800;

		double gst = 0;
		gst = monay * 4 / 100;
		try {
			Connection con1 = new JDBConnection().getConnection();
			PreparedStatement pt = con1.prepareStatement("INSERT INTO JEWELLER VALUES (?,?,?,?,?,?,?)");
			pt.setInt(1, id);
			pt.setString(2, first);
			pt.setString(3, last);
			pt.setDouble(4, gm);
			pt.setString(5, Date);
			pt.setDouble(6, monay + gst);
			pt.setDouble(7, gst);
			pt.executeLargeUpdate();
			out.println("<html><body><center>");
			out.println("<h1>Sucssefull...<h1>");
			
			out.println("<button><a href=Homepage01.html>Home Page</a></button>");
			out.println("</center></body></html>");
		} catch (Exception e) {
			out.println("<html><body><center>");
			out.println("SOMETHING IS WORNG....<br><br>");
			out.println("<button><a href=Home.html>Home Page</a></button>");
			out.println("</center></body></html>");
		}
	}
}
