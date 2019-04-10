package com.southwind.dao;

import java.util.List;

import com.southwind.entity.Admin;
import com.southwind.entity.Book;
import com.southwind.entity.Borrow;

public interface AdminDAO {
	public Admin login(String username,String password);
	public List<Borrow> getBorrows(int state);
	public void doBorrow(int borrowId,int adminId,int state);
}