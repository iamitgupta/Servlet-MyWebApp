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

@WebServlet("/searchserve")
public class SearchServ extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter out=resp.getWriter();
		
		String uid=req.getParameter("user_id");
		
		UserService service =new UserServiceImpl();
		User user=service.searchUser(Integer.parseInt(uid));
		
		if(user!=null){
			req.getRequestDispatcher("./search.html").include(req, resp);
			out.println("<h1 style=\"color:green\">"+user+"</h1>");
		}else{
			out.println("<h1 style=\"color:red\">No user found with id"+uid+"</h1>");
		}
		
		
		
	}

}
