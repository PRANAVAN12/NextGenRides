package com.nextgen.web.customer;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nextgen.dao.CustomerDao;
import com.nextgen.model.Customers;

@WebServlet("/CustomerUpdate")
public class CustomerUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerDao customerDao;

	public void init() {
		customerDao = new CustomerDao();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String country = request.getParameter("country");
		String password = request.getParameter("password");
		String phone = request.getParameter("phone");

		Customers user = new Customers(id, username, email, country, password, phone);
		customerDao.updateUser(user);
		response.sendRedirect("Customerlist");

	}

}
