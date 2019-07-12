package com.dev.servelets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/req")
public class RequestServ extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out=resp.getWriter();
		
		
	String url=	req.getRequestURL().toString();
	out.println("Url="+url);
	
	
	String data=req.getParameter("data");
	out.println(data);
		
	
	String lang[]=req.getParameterValues("lang");
	out.println(Arrays.toString(lang));
	
	String method=req.getMethod();
	out.println("method: "+method);
		
	}

}
