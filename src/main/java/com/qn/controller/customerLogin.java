package com.qn.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.qn.model.Customer;

public class customerLogin extends HttpServlet {
@Override
protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub
	String username=request.getParameter("username");
	String password=request.getParameter("password");
	Customer c=new Customer();
	c.setUsername(username);
	c.setPassword(password);
	int status=c.customerLogin();
	if(status==1) {
		String name=c.getName();
		HttpSession session=request.getSession();
		session.setAttribute("sname", name);
		session.setAttribute("susername", username);
		response.sendRedirect("/car-service-system/customerLoginSuccess.jsp");
	}
	else if (status==0) {
		response.sendRedirect("/car-service-system/invalidCustomerPassword.jsp");
	}
	else {
		response.sendRedirect("/car-service-system/invalidCustomerUsername.jsp");
	}
}
}
