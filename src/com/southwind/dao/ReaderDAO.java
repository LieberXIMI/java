package com.southwind.dao;

import com.southwind.entity.Reader;

public interface ReaderDAO {
	public Reader login(String username,String password);
	public void register(Reader reader);
}
