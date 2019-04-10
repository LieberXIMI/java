package com.southwind.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.southwind.dao.ReaderDAO;
import com.southwind.entity.Reader;
import com.southwind.util.JDBCTools;

public class ReaderDAOImpl implements ReaderDAO{

	@Override
	public Reader login(String username, String password) {
		// TODO Auto-generated method stub
		Connection conn = JDBCTools.getConn();
		String sql = "select * from reader where username = ? and password = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Reader reader = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(4);
				reader = new Reader();
				reader.setId(id);
				reader.setName(name);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTools.release(conn, pstmt, rs);
		}
		return reader;
	}

	@Override
	public void register(Reader reader) {
		// TODO Auto-generated method stub
			Connection conn = JDBCTools.getConn();
			String sql = "insert into reader(username,password,name,gender,cardid,tel) values(?,?,?,?,?,?)";
			PreparedStatement pstmt = null;
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, reader.getUsername());
				pstmt.setString(2, reader.getPassword());
				pstmt.setString(3, reader.getName());
				pstmt.setString(4, reader.getGender());
				pstmt.setString(5, reader.getCardid());
				pstmt.setString(6, reader.getTel());
				pstmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				JDBCTools.release(conn, pstmt, null);
			}
	}

}
