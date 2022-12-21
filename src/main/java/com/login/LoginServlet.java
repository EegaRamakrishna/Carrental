package com.login;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection myCon;
	
	public LoginServlet() throws SQLException{
	String url="jdbc:mysql://localhost:3306/Carrental";
        String username="student";
        String Password="student";
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
			myCon=DriverManager.getConnection(url, username, Password);
			System.out.println("connected");
		} catch (ClassNotFoundException e) {
			System.out.println("class not found");
			e.printStackTrace();
		}
        
	}
   
        
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		HttpSession session=request.getSession();
		RequestDispatcher dispatcher=null;
		try {
			PreparedStatement PStm=myCon.prepareStatement("select * from users where username=? and password=?");
			PStm.setString(1, username);
			PStm.setString(2, password);
			ResultSet rs=PStm.executeQuery();
			if(rs.next()) {
				session.setAttribute("username", rs.getString("username"));
                                dispatcher=request.getRequestDispatcher("UserPage.jsp");
			}
                        else{
                            request.setAttribute("status", "failed");
                            dispatcher=request.getRequestDispatcher("login.jsp");
                        }
                        dispatcher.forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}

}
