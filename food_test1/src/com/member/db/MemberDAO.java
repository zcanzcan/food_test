package com.member.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;



public class MemberDAO {

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql ="";
	
	private Connection getCon() throws Exception {
		Context initCTX = new InitialContext();
		DataSource ds
		   = (DataSource) initCTX.lookup("java:comp/env/jdbc/food");
		con = ds.getConnection();
		
		System.out.println("DAO : ��� ���� ����! -> "+con);
		
		return con;
	}
	
	// �ڿ����� 
	public void closeDB(){
		try {
			if(rs != null){ rs.close(); }
			if(pstmt != null){ pstmt.close(); }
			if(con != null){ con.close(); }
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void insertMember(MemberBean mb){
		
		try {
			con = getCon();
			sql = "insert into itwill_member (num,id,pass,name,phone,addr,addr1,addr2,email,nick,date,ip) "
				+ "values(?,?,?,?,?,?,?,?,?,?,now(),?)";
			
			pstmt = con.prepareStatement(sql);
		
			System.out.println("@@@@");
			
			
		
		// 4. sql ����
			pstmt.executeUpdate();
		
			System.out.println("DAO : ȸ������ �Ϸ�!");		
		
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("DAO : ȸ������ ����!");
		} finally {
			closeDB();	
		}
	}
	//insertMember(MemberBean mb)
	
	
	
	
}
