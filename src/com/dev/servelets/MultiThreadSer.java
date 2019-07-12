package com.dev.servelets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.SingleThreadModel;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/multith")
public class MultiThreadSer extends HttpServlet  implements SingleThreadModel{


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		synchronized (this) {
			//code to be Thread safe
		}

	}

}
