package edu.kosa.third.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.kosa.third.dto.DeptDto;
import edu.kosa.third.utils.ConnectionHelper;

public class DeptDao {

	public DeptDto SelectDept() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String select = "select * from dept";
		DeptDto deptdto = new DeptDto();
		try {
			conn = ConnectionHelper.getConnection("oracle");
			pstmt = conn.prepareStatement(select);
			rs = pstmt.executeQuery();
			
			deptdto = new DeptDto();
			
			while(rs.next()) {
			deptdto.setDeptNo(rs.getInt(1));
			deptdto.setDeptName(rs.getString(2));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
		}
		return deptdto;
	}
	
	// 부서추가
	public boolean insertDept(DeptDto deptDto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String insert = "insert into dept(deptno, deptname) values(?,?)";
		try {
			conn = ConnectionHelper.getConnection("oracle");
			pstmt = conn.prepareStatement(insert);
			pstmt.setInt(1, deptDto.getDeptNo());
			pstmt.setString(2, deptDto.getDeptName());
			
			pstmt.execute(); 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionHelper.close(pstmt);
			ConnectionHelper.close(conn);
		}
		return true;
	}

	// 부서변경
	public void updateDept(DeptDto deptDto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String update = "update dept set deptno = ?, deptname = ? where deptname = ?";
		try {
			conn = ConnectionHelper.getConnection("oracle");
			pstmt = conn.prepareStatement(update);
			pstmt.setInt(1,Integer.parseInt("deptNo"));
			pstmt.setString(2, "deptName");
			pstmt.setString(3, "deptName");
			System.out.println("dao No"+deptDto.getDeptName());
			System.out.println("dao Name"+deptDto.getDeptNo());
			pstmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionHelper.close(pstmt);
			ConnectionHelper.close(conn);
		}
	}

	// 부서삭제
	public void deleteDept(DeptDto deptDto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String delete = "delete from dept where deptno = ? and deptname = ? ";
		conn = ConnectionHelper.getConnection("oracle");
		try {
			pstmt = conn.prepareStatement(delete);
			pstmt.setString(2, deptDto.getDeptName());
			pstmt.setInt(1, deptDto.getDeptNo());

			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionHelper.close(pstmt);
			ConnectionHelper.close(conn);
		}
	}

}
