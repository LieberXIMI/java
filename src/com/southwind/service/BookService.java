package com.southwind.service;

import java.util.List;

import com.southwind.entity.Book;
import com.southwind.entity.Borrow;

public interface BookService {
	public List<Book> getByPage(int page);
	public int getPages();
	public void addBorrow(int bookid,int readerid);
	public List<Borrow> getBorrowByReaderId(int readerId);
	public void updateAbled(int bookId,int abled);
}
