package com.southwind.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.southwind.entity.Borrow;
import com.southwind.service.AdminService;
import com.southwind.service.BookService;
import com.southwind.service.impl.AdminServiceImpl;
import com.southwind.service.impl.BookServiceImpl;

public class AdminServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String method = req.getParameter("method");
		AdminService adminService = new AdminServiceImpl();
		BookService bookService = new BookServiceImpl();
		if(method == null) {
			List<Borrow> list = adminService.getBorrows(0);
			req.setAttribute("list", list);
			req.getRequestDispatcher("admin.jsp").forward(req, resp);
		}else {
			String borrowIdStr = req.getParameter("borrowid");
			String adminIdStr = req.getParameter("adminid");
			String bookIdStr = req.getParameter("bookid");
			int borrowId = 0;
			int adminId = 0;
			int bookId = 0;
			if(borrowIdStr != null) {
				borrowId = Integer.parseInt(borrowIdStr);
			}
			if(adminIdStr != null) {
				adminId = Integer.parseInt(adminIdStr);
			}
			if(bookIdStr != null) {
				bookId = Integer.parseInt(bookIdStr);
			}
			switch(method) {
			case "agree":
				adminService.doBorrow(borrowId, adminId, 1);
				resp.sendRedirect("admin.do");
				break;
			case "refuse":
				adminService.doBorrow(borrowId, adminId, 2);
				bookService.updateAbled(bookId, 1);
				resp.sendRedirect("admin.do");
				break;
			case "return":
				adminService.doBorrow(borrowId, adminId, 3);
				bookService.updateAbled(bookId, 1);
				resp.sendRedirect("admin.do?method=getBorrowSuccessful");
				break;
			case "getBorrowSuccessful":
				List<Borrow> list2 = adminService.getBorrows(1);
				req.setAttribute("list", list2);
				req.getRequestDispatcher("return.jsp").forward(req, resp);
				break;
			}
		}
		
	}
}
