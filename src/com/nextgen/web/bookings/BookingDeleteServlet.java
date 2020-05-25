package com.nextgen.web.bookings;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nextgen.dao.UserDao;
import com.nextgen.model.bookings;

@WebServlet("/BookingDelete")
public class BookingDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserDao userDao;

	public void init() {

		userDao = new UserDao();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		userDao.deleteUser(id);
		response.sendRedirect("/BookingList");

	}

}
