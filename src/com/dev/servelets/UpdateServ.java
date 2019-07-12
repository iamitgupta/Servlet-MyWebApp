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

@WebServlet("/updateserve")
public class UpdateServ extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter out=resp.getWriter();
		
		String uid=req.getParameter("user_id");
		String oldpassword=req.getParameter("oldpasswd");
		String newpassword=req.getParameter("newpasswd");
		
		UserService service =new UserServiceImpl();
		Boolean update=service.updatePassword(Integer.parseInt(uid), oldpassword,newpassword);
		
		
		if(update){
			req.getRequestDispatcher("./updatePassword.html").include(req, resp);
			
			out.println("<h1 style=\"color:red\">Password Updated Successful</h1>");
			
		}else{
			out.println("<h1 style=\"color:red\">Registration failed</h1>");
		}
		
		
		
	}

}
