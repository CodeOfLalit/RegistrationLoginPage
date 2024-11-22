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

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("userEmail");
		String password = request.getParameter("userPassword");
		try {
			UserDao dao = new UserDao(DBConnect.getConnection());
			User user = dao.getLogin(email, password);
			if (user != null) {
				HttpSession session=request.getSession();
				session.setAttribute("user-obj", user);
				response.sendRedirect("HomePage.jsp");
			}else {
			    request.setAttribute("errorMessage", "Invalid email or password.");
			    request.getRequestDispatcher("LoginPage.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
