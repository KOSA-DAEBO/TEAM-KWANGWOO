package edu.kosa.third.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import edu.kosa.third.dto.DeptDto;
import edu.kosa.third.utils.ConnectionHelper;

public class DeptDao {

	// 부서추가
	public boolean insertDept(DeptDto deptdto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean result = false;
		try {
			String insert = "insert into dept(deptno, deptname) values(?,?)";
			conn = ConnectionHelper.getConnection("oracle");
			pstmt = conn.prepareStatement(insert);
			pstmt.setInt(1, deptdto.getDeptNo());
			pstmt.setString(2, deptdto.getDeptName());

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
	public boolean updateDept(DeptDto deptdto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String update = "update dept set deptno = ?, deptname = ? where deptname = ?";
		boolean result = false;
		try {
			conn = ConnectionHelper.getConnection("oracle");
			pstmt = conn.prepareStatement(update);
			pstmt.setInt(1, deptdto.getDeptNo());
			pstmt.setString(2, deptdto.getDeptName());
			pstmt.setString(3, deptdto.getDeptName());
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionHelper.close(pstmt);
			ConnectionHelper.close(conn);
		}
		return result;
	}

	public boolean deleteDept(DeptDto deptdto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String delete = "delete from dept where deptname = ?";
		conn = ConnectionHelper.getConnection("oracle");
		boolean result = false;
		try {
			pstmt = conn.prepareStatement(delete);
			pstmt.setString(1, deptdto.getDeptName());//boolean result 추가할것 삭제 여부 확인하려면 try 안에서 써야함
			result = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionHelper.close(pstmt);
			ConnectionHelper.close(conn);
		}
		return result;
	}
}
