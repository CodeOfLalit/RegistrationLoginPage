package com.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.UserDao;
import com.DB.DBConnect;
import com.entities.User;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name=request.getParameter("userName");
		String email=request.getParameter("userEmail");
		String password=request.getParameter("userPassword");
		
		User user=new User();
		user.setName(name);
		user.setEmail(email);
		user.setPassword(password);
		try {
			UserDao uDao=new UserDao(DBConnect.getConnection());
			boolean f= uDao.userRegister(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(true) {
			HttpSession session=request.getSession();
			session.setAttribute("reg-msg", "Registration Successfully ");
			response.sendRedirect("RegistrationPage.jsp");
		}
		
		
	}

}
