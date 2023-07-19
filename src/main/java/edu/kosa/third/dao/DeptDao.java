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
	
	//부서 출력
	public List<DeptDto> totalDept(){
		String select ="select * from dept";
		List<DeptDto> list = null;
		Connection conn = ConnectionHelper.getConnection("oracle");
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			list = new ArrayList<>();
			pstmt = conn.prepareStatement(select);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				DeptDto deptDto = new DeptDto();
				
				deptDto.setDeptName(rs.getString("DeptName"));
				deptDto.setDeptNo(rs.getInt("DeptNo"));
				
				list.add(deptDto);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			ConnectionHelper.close(rs);
			ConnectionHelper.close(pstmt);
			ConnectionHelper.close(conn);
		}
		return list;
	}
	
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
		Connection conn = ConnectionHelper.getConnection("oracle");
		PreparedStatement pstmt = null; 
		String update = "update dept set deptname = ? where deptno = ?"; // 번호만 수정된다.  고정 되어야 할것은 부서 번호
		try {
			pstmt = conn.prepareStatement(update);
			
//			pstmt.setInt(1, deptDto.getDeptNo());
			pstmt.setString(1, deptDto.getDeptName());
			pstmt.setInt(2, deptDto.getDeptNo());
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
