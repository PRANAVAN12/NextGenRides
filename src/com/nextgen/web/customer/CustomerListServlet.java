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



@WebServlet("/CustomerList")
public class CustomerListServlet extends HttpServlet {
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
		List<Customers> customer = customerDao.getAllUser();
		request.setAttribute("Customerlis", customer);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Customer-list.jsp");
		dispatcher.forward(request, response);

		
	}

	
	

	
}
