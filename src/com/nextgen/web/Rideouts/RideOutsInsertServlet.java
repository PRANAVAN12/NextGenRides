package com.nextgen.web.Rideouts;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nextgen.dao.RideoutsDao;
import com.nextgen.model.RideOuts;

@WebServlet("/RideOutsInsert")
public class RideOutsInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private RideoutsDao userDao;

	public void init() {

		userDao = new RideoutsDao();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String rent_date = request.getParameter("rent_date");
		String days = request.getParameter("days");
		Float feedbacks = Float.parseFloat("feedbacks");
		String bike = request.getParameter("bike");
		String points = request.getParameter("points");

		RideOuts newUser = new RideOuts( username, rent_date, feedbacks, days, bike,points);
		userDao.saveUser(newUser);
		response.sendRedirect("/RideOutsList");

	}

}
