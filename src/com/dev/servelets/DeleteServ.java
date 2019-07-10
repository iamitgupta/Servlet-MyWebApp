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

@WebServlet("/deleteserve")
public class DeleteServ extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter out=resp.getWriter();
		
		String uid=req.getParameter("user_id");
		String password=req.getParameter("passwd");
		
		UserService service =new UserServiceImpl();
		Boolean delete=service.deleteUser(Integer.parseInt(uid), password);
		
		if(delete){
			out.println("<h1 style=\"color:red\">Deleted Successful</h1>");
			
		}else{
			out.println("<h1 style=\"color:red\">Deletion failed</h1>");
		}
		
		
		
	}

}
