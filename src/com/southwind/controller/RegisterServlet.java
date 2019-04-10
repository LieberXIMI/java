package com.southwind.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.southwind.entity.Reader;
import com.southwind.service.RegisterService;
import com.southwind.service.impl.RegisterServiceImpl;

public class RegisterServlet extends HttpServlet{
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
		String gender = req.getParameter("gender");
		String name = req.getParameter("name");
		String cardid = req.getParameter("cardid");
		String tel = req.getParameter("tel");
		Reader reader = new Reader(username,password,name,gender,cardid,tel);
		RegisterService registerService = new RegisterServiceImpl();
		registerService.register(reader);
		resp.sendRedirect("login.jsp");
	}
}
