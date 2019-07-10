package com.dev.servelets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/date")
public class MYFirstServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String firstName=req.getParameter("fname");
		String lastName=req.getParameter("lname");
		
		PrintWriter out=resp.getWriter();
		out.println("<h1>the current date and time is:"+new Date()+"</h1>");
		
		
		
		out.println(firstName+" "+lastName);
		
	}
	
	
}
