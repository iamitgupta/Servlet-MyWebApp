package com.dev.servelets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Multiserv")
public class MultiSearchServ extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String keyword=req.getParameter("keyword");
		String engine=req.getParameter("engine");
		
		if(engine.equalsIgnoreCase("Google")){
			String url="https://www.google.com/search?q="+keyword;
			resp.sendRedirect(url);
		}
		else if(engine.equalsIgnoreCase("DuckDuckGo")){
			String url="https://duckduckgo.com/?q="+keyword;
			resp.sendRedirect(url);
		}
		else if(engine.equalsIgnoreCase("Bing")){
			String url="https://www.bing.com/search?q="+keyword;
			resp.sendRedirect(url);
		}
		
		
		
		
		
	}

}
