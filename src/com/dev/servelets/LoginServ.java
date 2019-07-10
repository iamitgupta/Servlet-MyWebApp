package com.dev.servelets;

import java.io.IOException;
import java.io.PrintWriter;
import com.dev.beans.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.dev.services.UserService;
import com.dev.services.UserServiceImpl;

@WebServlet("/loginserve")
public class LoginServ extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter out=resp.getWriter();
		
		String uid=req.getParameter("user_id");
		String password=req.getParameter("passwd");
		
		UserService service =new UserServiceImpl();
		User user=service.loginUser(Integer.parseInt(uid), password);
		
		if(user!=null){
			out.println("<h1 style=\"color:green\">Hello "+user.getFirstName()+" "+user.getLastName() +"</h1>");
			out.println("<h1 style=\"color:red\">"+user+"</h1>");
		}else{
			out.println("<h1 style=\"color:red\">Login failed</h1>");
		}
		
		
		
	}

}
