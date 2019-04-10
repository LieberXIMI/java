package com.southwind.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.southwind.entity.Book;
import com.southwind.entity.Borrow;
import com.southwind.service.BookService;
import com.southwind.service.impl.BookServiceImpl;

public class BookServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String method = req.getParameter("method");
		BookService bookService = new BookServiceImpl();
		if(method == null) {
			String pageStr = req.getParameter("page");
			int page = 0;
			if(pageStr == null) {
				page = 1;
			}else {
				page = Integer.parseInt(pageStr);
			}
			List<Book> list = bookService.getByPage(page);
			req.setAttribute("list", list);
			//每页的记录数
			req.setAttribute("dataPrePage", list.size());
			//当前页码
			req.setAttribute("currentPage", page);
			//总页数
			req.setAttribute("pages", bookService.getPages());
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		}else {
			switch(method) {	
			case "borrow":
				String bookidStr = req.getParameter("bookid");
				String readeridStr = req.getParameter("readerid");
				int bookid = Integer.parseInt(bookidStr);
				int readerid = Integer.parseInt(readeridStr);
				bookService.addBorrow(bookid, readerid);
				//跳转到当前用户的借书列表
				List<Borrow> list = bookService.getBorrowByReaderId(readerid);
				req.setAttribute("list", list);
				req.getRequestDispatcher("borrow.jsp").forward(req, resp);
				break;
			case "getMyBorrow":
				String readeridStr2 = req.getParameter("readerid");
				int readerid2 = Integer.parseInt(readeridStr2);
				//跳转到当前用户的借书列表
				List<Borrow> list2 = bookService.getBorrowByReaderId(readerid2);
				req.setAttribute("list", list2);
				req.getRequestDispatcher("borrow.jsp").forward(req, resp);
				break;
			}
		}
		
	}
}
