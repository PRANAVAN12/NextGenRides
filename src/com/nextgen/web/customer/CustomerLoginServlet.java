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

@WebServlet("/CustomerLogin")
public class CustomerLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerDao loginDao;

	  public void init() {
	        loginDao = new CustomerDao();
	    }

	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	        response.sendRedirect("login.jsp");
	    }

	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	        try {
	            authenticate(request, response);
	        } catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	    }

	    private void authenticate(HttpServletRequest request, HttpServletResponse response)
	    throws Exception {
	        String username = request.getParameter("username");
	        String password = request.getParameter("password");

	        if (loginDao.validate(username, password)) {
	            RequestDispatcher dispatcher = request.getRequestDispatcher("index.html");
	            dispatcher.forward(request, response);
	        } else {
	            throw new Exception("Login not successful..");
	        }
	    }
	
}
