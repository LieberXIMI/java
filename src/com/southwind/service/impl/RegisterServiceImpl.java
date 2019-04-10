package com.southwind.service.impl;

import com.southwind.dao.ReaderDAO;
import com.southwind.dao.impl.ReaderDAOImpl;
import com.southwind.entity.Reader;
import com.southwind.service.RegisterService;

public class RegisterServiceImpl implements RegisterService{

	private ReaderDAO readerDAO = new ReaderDAOImpl();
	
	@Override
	public void register(Reader reader) {
		// TODO Auto-generated method stub
		readerDAO.register(reader);
	}

}
