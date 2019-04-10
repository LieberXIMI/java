package com.southwind.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.southwind.dao.AdminDAO;
import com.southwind.entity.Admin;
import com.southwind.entity.Book;
import com.southwind.entity.Borrow;
import com.southwind.entity.Reader;
import com.southwind.util.JDBCTools;

public class AdminDAOImpl implements AdminDAO{

	@Override
	public Admin login(String username, String password) {
		// TODO Auto-generated method stub
		Connection conn = JDBCTools.getConn();
		String sql = "select * from bookadmin where username = ? and password = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Admin admin = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				int id = rs.getInt(1);
				String username2 = rs.getString(2);
				admin = new Admin();
				admin.setId(id);
				admin.setUsername(username2);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTools.release(conn, pstmt, rs);
		}
		return admin;
	}

	@Override
	public List<Borrow> getBorrows(int state) {
		// TODO Auto-generated method stub
		Connection conn = JDBCTools.getConn();
		String sql = "select br.id,b.name,b.price,r.name,r.cardid,r.tel,br.borrowtime,br.returntime,b.id,r.id from book b,borrow br,reader r\n" + 
				"where b.id = br.bookid and r.id = br.readerid and br.state = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Borrow> list = new ArrayList<Borrow>();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, state);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int borrowId = rs.getInt(1);
				String bookName = rs.getString(2);
				double price = rs.getDouble(3);
				String readerName = rs.getString(4);
				String cardid = rs.getString(5);
				String tel = rs.getString(6);
				String borrowTime = rs.getString(7);
				String returnTime = rs.getString(8);
				int bookId = rs.getInt(9);
				int readerId = rs.getInt(10);
				Book book = new Book();
				book.setId(bookId);
				book.setName(bookName);
				book.setPrice(price);
				Reader reader = new Reader();
				reader.setId(readerId);
				reader.setName(readerName);
				reader.setCardid(cardid);
				reader.setTel(tel);
				Borrow borrow = new Borrow();
				borrow.setId(borrowId);
				borrow.setBorrowTime(borrowTime);
				borrow.setReturnTime(returnTime);
				borrow.setBook(book);
				borrow.setReader(reader);
				list.add(borrow);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTools.release(conn, pstmt, rs);
		}
		
		return list;
	}

	@Override
	public void doBorrow(int borrowId, int adminId, int state) {
		// TODO Auto-generated method stub
		Connection conn = JDBCTools.getConn();
		String sql = "update borrow set adminid = ?,state = ? where id = ?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, adminId);
			pstmt.setInt(2, state);
			pstmt.setInt(3, borrowId);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTools.release(conn, pstmt, null);
		}
	}

}
