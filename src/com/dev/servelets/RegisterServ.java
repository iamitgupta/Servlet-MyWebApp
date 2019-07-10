package com.dev.servelets;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.beans.User;
import com.dev.services.UserService;
import com.dev.services.UserServiceImpl;

@WebServlet("/registerserve")
public class RegisterServ extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter out=resp.getWriter();
		UserService service =new UserServiceImpl();
		
		
		String uid=req.getParameter("user_id");
		String firstName=req.getParameter("firstName");
		String lastName=req.getParameter("lastName");
		String password=req.getParameter("passwd");
		
		User user=new User();
		user.setUserId(Integer.parseInt(uid));
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setPassword(password);
		
		
		
		Boolean reg=service.createProfile(user);
		if(reg){
			out.println("<h1 style=\"color:red\">Registration Successful</h1>");
			//resp.sendRedirect("./login.html");
			
		}else{
			out.println("<h1 style=\"color:red\">Registration failed</h1>");
		}
		
		
		
	}

}
