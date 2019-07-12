package com.dev.servelets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/respo")
public class ResponseServ extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
		PrintWriter out=resp.getWriter();
		out.println("<h1>This is getWriter() method");
		
		
		resp.setContentType("text/html");
		
		
		resp.sendError(999, "Custom error");
		
	}

}
