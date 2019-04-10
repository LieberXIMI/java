package com.southwind.service.impl;

import com.southwind.dao.ReaderDAO;
import com.southwind.dao.impl.ReaderDAOImpl;
import com.southwind.entity.Reader;
import com.southwind.service.ReaderService;

public class ReaderServiceImpl implements ReaderService{

	private ReaderDAO readerDAO = new ReaderDAOImpl();
	
	@Override
	public Reader login(String username, String password) {
		// TODO Auto-generated method stub
		return readerDAO.login(username, password);
	}

}
