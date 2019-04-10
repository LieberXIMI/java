package com.southwind.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.southwind.dao.BookDAO;
import com.southwind.entity.Book;
import com.southwind.entity.BookCase;
import com.southwind.entity.Borrow;
import com.southwind.util.JDBCTools;

public class BookDAOImpl implements BookDAO{

	@Override
	public List<Book> getByPage(int start,int end) {
		// TODO Auto-generated method stub
		Connection conn = JDBCTools.getConn();
		String sql = "select b.id,b.name,b.author,b.publish,b.pages,b.price,bc.id as bcid, bc.name as bcname from book b,bookcase bc where b.bookcaseid = bc.id and abled = 1 limit ?,?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Book> list = new ArrayList<Book>();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String author = rs.getString(3);
				String publish = rs.getString(4);
				int pages = rs.getInt(5);
				double price = rs.getDouble(6);
				int bcid = rs.getInt(7);
				String bcname = rs.getString(8);
				Book book = new Book();
				BookCase bookCase = new BookCase();
				book.setId(id);
				book.setName(name);
				book.setAuthor(author);
				book.setPublish(publish);
				book.setPages(pages);
				book.setPrice(price);
				bookCase.setId(bcid);
				bookCase.setName(bcname);
				book.setBookCase(bookCase);
				list.add(book);
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
	public int getCount() {
		// TODO Auto-generated method stub
		Connection conn = JDBCTools.getConn();
		String sql = "select count(id) from book";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				int count = rs.getInt(1);
				return count;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTools.release(conn, pstmt, rs);
		}
		return 0;
	}

	/**
	 * 借书操作：有四种状态
	 * 未审核  0
	 * 同意   1
	 * 拒绝   2
	 * 归还   3
	 */
	@Override
	public void addBorrow(int bookid, int readerid, String borrowTime, String returnTime) {
		// TODO Auto-generated method stub
		Connection conn = JDBCTools.getConn();
		String sql = "insert into borrow(bookid,readerid,borrowtime,returntime,state) values(?,?,?,?,0)";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bookid);
			pstmt.setInt(2, readerid);
			pstmt.setString(3, borrowTime);
			pstmt.setString(4, returnTime);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTools.release(conn, pstmt, null);
		}
	}

	@Override
	public List<Borrow> getBorrowByReaderId(int readerId) {
		// TODO Auto-generated method stub
		Connection conn = JDBCTools.getConn();
		String sql = "select br.id,br.borrowtime,br.returntime,\n" + 
				"br.state,b.id,b.name,b.author from borrow br,book b where \n" + 
				"br.bookid = b.id and br.readerid = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Borrow> list = new ArrayList<Borrow>();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, readerId);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int borrowId = rs.getInt(1);
				String borrowTime = rs.getString(2);
				String returnTime = rs.getString(3);
				int state = rs.getInt(4);
				int bookId = rs.getInt(5);
				String bookName = rs.getString(6);
				String author = rs.getString(7);
				Book book = new Book();
				book.setId(bookId);
				book.setName(bookName);
				book.setAuthor(author);
				Borrow borrow = new Borrow();
				borrow.setId(borrowId);
				borrow.setBorrowTime(borrowTime);
				borrow.setReturnTime(returnTime);
				borrow.setState(state);
				borrow.setBook(book);
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
	public void updateAbled(int bookId,int abled) {
		// TODO Auto-generated method stub
		Connection conn = JDBCTools.getConn();
		String sql = "update book set abled = ? where id = ?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, abled);
			pstmt.setInt(2, bookId);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTools.release(conn, pstmt, null);
		}
	}

}
