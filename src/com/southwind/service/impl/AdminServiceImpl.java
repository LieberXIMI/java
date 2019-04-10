package com.southwind.service.impl;

import java.util.List;

import com.southwind.dao.AdminDAO;
import com.southwind.dao.impl.AdminDAOImpl;
import com.southwind.entity.Admin;
import com.southwind.entity.Book;
import com.southwind.entity.Borrow;
import com.southwind.service.AdminService;

public class AdminServiceImpl implements AdminService{

	private AdminDAO adminDAO = new AdminDAOImpl();
	
	@Override
	public Admin login(String username, String password) {
		// TODO Auto-generated method stub
		return adminDAO.login(username, password);
	}

	@Override
	public List<Borrow> getBorrows(int state) {
		// TODO Auto-generated method stub
		return adminDAO.getBorrows(state);
	}

	@Override
	public void doBorrow(int borrowId, int adminId, int state) {
		// TODO Auto-generated method stub
		adminDAO.doBorrow(borrowId, adminId, state);
	}

}
