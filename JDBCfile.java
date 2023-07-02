package assignment2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.*;
import java.io.*;
public class Seven {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
		String urljdbc = "jdbc:mysql://localhost:3306/new";
		Connection con = DriverManager.getConnection(urljdbc, "root", "root");
		Statement stmt = con.createStatement();
		con.setAutoCommit(false);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try 
		{
			PreparedStatement ps = con.prepareStatement("insert into education(ssc_marks,hsc_marks,graduation_marks)values(?,?,?);");
			System.out.println("=========ENTER EDUCATIONAL DETAILS===========");
			System.out.println("enter ssc marks :");
			int m = Integer.parseInt(br.readLine());
			ps.setInt(1, m);
			System.out.println("enter hsc marks :");
			int l = Integer.parseInt(br.readLine());
			ps.setInt(2, l);
			System.out.println("enter graduation marks :");
			int p = Integer.parseInt(br.readLine());
			ps.setInt(3, p);
			
			int n = ps.executeUpdate();
			
			System.out.println("numbber of changes in education table is : "+n);
			
			
			System.out.println("=========ENTER USER DETAILS===========");
			PreparedStatement ps1 = con.prepareStatement("insert into user values(?,?,?,?,?)");
	
			System.out.println("enter userID (MUST BE AN INTEGER NUMBER) :");
			int m1 = Integer.parseInt(br.readLine());
			ps1.setInt(1, m1);
			System.out.println("enter NAME :");
			String L = br.readLine();
			ps1.setString(2, L);
			System.out.println("enter EMAIL :");
			String e = br.readLine();
			ps1.setString(3, e);
			System.out.println("enter CONTACT_NO :");
			int c = Integer.parseInt(br.readLine());
			ps1.setInt(4, c);
			System.out.println("enter CITY :");
			String a = br.readLine();
			ps1.setString(5, a);
			
			int s = ps1.executeUpdate();
			
			con.commit();
			System.out.println("number of changes in user table is : "+s);
			System.out.println("\n========educational data and user data inserted successfully============");
			
		}
		catch(SQLException e)
		{
			con.rollback();
		}
	}

}
