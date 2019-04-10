package com.southwind.dao;

import java.util.List;

import com.southwind.entity.Book;
import com.southwind.entity.Borrow;

public interface BookDAO {
	public List<Book> getByPage(int start,int end);
	public int getCount();
	public void addBorrow(int bookid,int readerid,String borrowTime,String returnTime);
	public List<Borrow> getBorrowByReaderId(int readerId);
	public void updateAbled(int bookId,int abled);
}
