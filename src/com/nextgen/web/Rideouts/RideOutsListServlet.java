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

@WebServlet("/RideOutsList")
public class RideOutsListServlet extends HttpServlet {
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
		List<RideOuts> listUser = userDao.getAllUser();
		request.setAttribute("Rides", listUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("RidesOuts.jsp");
		dispatcher.forward(request, response);

	}

}
