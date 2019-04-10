package com.southwind.service.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.southwind.dao.BookDAO;
import com.southwind.dao.impl.BookDAOImpl;
import com.southwind.entity.Book;
import com.southwind.entity.Borrow;
import com.southwind.service.BookService;

public class BookServiceImpl implements BookService{

	private int dataPrePage = 10;

	private BookDAO bookDAO = new BookDAOImpl();
	
	@Override
	public List<Book> getByPage(int page) {
		// TODO Auto-generated method stub
		int start = (page-1)*dataPrePage;
		int end = dataPrePage;
		return bookDAO.getByPage(start,end);
	}

	@Override
	public int getPages() {
		// TODO Auto-generated method stub
		int count = bookDAO.getCount();
		int pages = 0;
		if(count%dataPrePage == 0) {
			pages = count/dataPrePage;
		}else {
			pages = count/dataPrePage+1;
		}
		return pages;
	}

	@Override
	public void addBorrow(int bookid, int readerid) {
		// TODO Auto-generated method stub
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String borrowTime = dateFormat.format(date);
		Calendar calendar = Calendar.getInstance();
	    calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) + 14);
	    Date date2 = calendar.getTime();
	    String returnTime = dateFormat.format(date2);
	    bookDAO.addBorrow(bookid, readerid, borrowTime, returnTime);
	    bookDAO.updateAbled(bookid, 0);
	}

	@Override
	public List<Borrow> getBorrowByReaderId(int readerId) {
		// TODO Auto-generated method stub
		return bookDAO.getBorrowByReaderId(readerId);
	}

	@Override
	public void updateAbled(int bookId, int abled) {
		// TODO Auto-generated method stub
		bookDAO.updateAbled(bookId, abled);
	}

}
