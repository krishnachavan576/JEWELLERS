package jewellers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class demo1 extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			Scanner sc = new Scanner(System.in);
			String name = req.getParameter("first");
			System.out.println("Enter email");
			String email = sc.nextLine();
			System.out.println("Enter phone");
			long phone = sc.nextLong();
			System.out.println("Enter adhar");
			long adhar = sc.nextLong();
			System.out.println("Enter age");
			int age = sc.nextInt();
			System.out.println("Enter reant");
			double reant = sc.nextDouble();
			System.out.println("Enter in");
			String in = sc.next();
			System.out.println("Enter out");
			String out = sc.next();
			System.out.println("Enter room type");
			String rtype = sc.next();
			System.out.println("Enter reating");
			int reating = sc.nextInt();

			Connection con = new JDBConnection().getConnection();
			// PreparedStatement pt=con.prepareStatement("INSERT INTO DITAILS
			// VALUES(?,?,?,?,?,?,?,?,?,?)");
			PreparedStatement pt = con.prepareStatement("INSERT INTO DITAILS VALUES(?,?,?,?,?,?,?,?,?,?)");
			pt.setString(1, name);
			pt.setString(2, email);
			pt.setLong(3, phone);
			pt.setLong(4, adhar);
			pt.setInt(5, age);
			pt.setDouble(6, reant);
			pt.setString(7, in);
			pt.setString(8, out);
			pt.setString(9, rtype);
			pt.setInt(10, reating);
			int x = pt.executeUpdate();
			System.out.println("done");

		} catch (Exception e) {
			System.out.println("SORRY");
			e.printStackTrace();

		}
	}
}
