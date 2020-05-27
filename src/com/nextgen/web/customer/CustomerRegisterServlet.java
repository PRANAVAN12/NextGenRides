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

@WebServlet("/CustomerRegister")
public class CustomerRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CustomerDao userDao;

    public void init() {
        userDao = new CustomerDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        register(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.sendRedirect("Login.html");
    }

    private void register(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");
        

        Customers user = new Customers();
       
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setCountry(country);
        user.setPhone(phone);

        userDao.saveUser(user);

        RequestDispatcher dispatcher = request.getRequestDispatcher("Login.html");
        dispatcher.forward(request, response);
    }
}