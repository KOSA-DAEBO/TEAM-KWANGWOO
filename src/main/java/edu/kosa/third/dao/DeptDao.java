package edu.kosa.third.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.kosa.third.dto.DeptDto;
import edu.kosa.third.utils.ConnectionHelper;

public class DeptDao {
	
	// 부서추가
	public boolean insertDept(DeptDto deptDto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String insert = "insert into dept(deptno, deptname) values(?,?)";
		boolean result = false;
		try {
			conn = ConnectionHelper.getConnection("oracle");
			pstmt = conn.prepareStatement(insert);
			pstmt.setInt(1, deptDto.getDeptNo());
			pstmt.setString(2, deptDto.getDeptName());
			pstmt.execute();
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionHelper.close(pstmt);
			ConnectionHelper.close(conn);
		}
		return result;
	}

	// 부서변경
	public void updateDept(DeptDto deptDto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String update = "update dept set deptno = ?, deptname = ? where deptname = ?";
		try {
			conn = ConnectionHelper.getConnection("oracle");
			pstmt = conn.prepareStatement(update);
			pstmt.setInt(1, Integer.parseInt("deptNo"));
			pstmt.setString(2, "deptName");
			pstmt.setString(3, "deptName");
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
			pstmt.setInt(1, deptDto.getDeptNo());
			pstmt.setString(2, deptDto.getDeptName());

			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionHelper.close(pstmt);
			ConnectionHelper.close(conn);
		}
	}

}
