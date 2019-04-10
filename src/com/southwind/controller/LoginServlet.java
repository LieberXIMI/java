package com.southwind.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.southwind.entity.Admin;
import com.southwind.entity.Book;
import com.southwind.entity.Reader;
import com.southwind.service.AdminService;
import com.southwind.service.BookService;
import com.southwind.service.ReaderService;
import com.southwind.service.impl.AdminServiceImpl;
import com.southwind.service.impl.BookServiceImpl;
import com.southwind.service.impl.ReaderServiceImpl;

public class LoginServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String type = req.getParameter("type");
		if(type.equals("reader")) {
			ReaderService readerService = new ReaderServiceImpl();
			Reader reader = readerService.login(username, password);
			if(reader!=null) {
				HttpSession session = req.getSession();
				session.setAttribute("reader", reader);
				resp.sendRedirect("book.do");
			}else {
				resp.sendRedirect("login.jsp");
			}
		}
		if(type.equals("admin")) {
			AdminService adminService = new AdminServiceImpl();
			Admin admin = adminService.login(username, password);
			if(admin != null) {
				HttpSession session = req.getSession();
				session.setAttribute("admin", admin);
				resp.sendRedirect("admin.do");
			}else {
				resp.sendRedirect("login.jsp");
			}
		}
	}
}
