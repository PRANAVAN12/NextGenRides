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

@WebServlet("/BookingUpdate")
public class BookingUpdateServlet extends HttpServlet {
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
		String username = request.getParameter("username");
		String rent_date = request.getParameter("rent_date");
		String destination_start = request.getParameter("destination_start");
		String destination_end = request.getParameter("destination_end");
		String payment = request.getParameter("payment");
		String bike = request.getParameter("bike");

		bookings user = new bookings(id, username, rent_date, destination_start, destination_end, payment, bike);
		userDao.updateUser(user);
		response.sendRedirect("list");

	}

}
