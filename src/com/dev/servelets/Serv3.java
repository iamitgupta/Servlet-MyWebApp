package com.dev.servelets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns="/serv3",
	initParams=@WebInitParam(name="msg",value="hello"))
public class Serv3 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
		PrintWriter out=resp.getWriter();
		ServletContext context = getServletContext();
		String email=context.getInitParameter("email");
		out.println(email);
		
		ServletConfig config=getServletConfig();
		out.println(config.getInitParameter("msg"));
		
		
	}

}
