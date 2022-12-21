package com.Register;



import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection myCon;
        RequestDispatcher dispatcher=null;
	
	public RegisterServlet() throws SQLException{
		String url="jdbc:mysql://localhost:3306/Carrental";
        String username="student";
        String Password="student";
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
			myCon=DriverManager.getConnection(url, username, Password);
//			Statement myStm=myCon.createStatement();
			System.out.println("connected");
		} catch (ClassNotFoundException e) {
			System.out.println("class not found");
			e.printStackTrace();
		}
        
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String firstname=request.getParameter("firstname");
		String lastname=request.getParameter("lastname");
		String mobilenumber=request.getParameter("phone");
		String email=request.getParameter("email");
		String gender=request.getParameter("gender");
		String password=request.getParameter("password");
		String usertablequery="insert into users (username,firstname,lastname,MobileNumber,Email,gender,password) values(?,?,?,?,?,?,?)";
		System.out.println("");
		try {
			PreparedStatement st=myCon.prepareStatement(usertablequery);
			st.setString(1, username);
            st.setString(2, firstname);
            st.setString(3, lastname);
            st.setString(4, mobilenumber);
            st.setString(5, email);
            st.setString(6, gender);
            st.setString(7, password);
            int rowcount=st.executeUpdate();
            if(rowcount>0) {
                
                dispatcher=request.getRequestDispatcher("login.jsp");
            	System.out.println("Excuted"+rowcount);
                request.setAttribute("status", "success");
            }
            dispatcher.forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				myCon.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
