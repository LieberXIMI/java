package com.southwind.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.southwind.entity.Book;
import com.southwind.entity.Reader;

public class LoginFilter implements Filter{

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req = (HttpServletRequest) arg0;
		HttpServletResponse resp = (HttpServletResponse) arg1;
		HttpSession session = req.getSession();
		Reader reader = (Reader) session.getAttribute("reader");
		List<Book> list = (List<Book>) req.getAttribute("book");
		if(reader != null) {
			if(list != null) {
				arg2.doFilter(arg0, arg1);
			}else {
				resp.sendRedirect("book.do");
			}
		}else {
			resp.sendRedirect("login.jsp");
		}
	}

}
