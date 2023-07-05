package edu.kosa.third.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.kosa.third.dto.LeaveDto;
import edu.kosa.third.utils.ConnectionHelper;

public class LeaveDao {
	public int applyLeave(String typeNo, String startDate, String endDate, String reason) {

		int resultrow = 0;
		PreparedStatement pstmt = null;
		String sql = "insert into leave values(autoleave.nextval, ?,?,?,0,20230001,'crush0327', ?)";
		// Pool
		Connection conn = null;
		int type = Integer.parseInt(typeNo);

		try {
			conn = ConnectionHelper.getConnection("oracle");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, startDate);
			pstmt.setString(2, endDate);
			pstmt.setString(3, reason);
			pstmt.setInt(4, type);

			resultrow = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ConnectionHelper.close(pstmt);
				ConnectionHelper.close(conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return resultrow;
	}

	public List<LeaveDto> selectAll() {
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM Leave order by LeaveNo";

		/// Pool ///////////////////////////////////
		Connection conn = ConnectionHelper.getConnection("oracle");
		////////////////////////////////////////////
		List<LeaveDto> list = null;
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			list = new ArrayList<>();

			while (rs.next()) {
				LeaveDto dto = new LeaveDto();
				dto.setLeaveNo(rs.getInt(1));
				dto.setStartDay(rs.getDate(2));
				dto.setEndDay(rs.getDate(3));
				dto.setReason(rs.getString(4));
				dto.setLevStatus(rs.getInt(5));
				dto.setEmpNo(rs.getInt(6));
				dto.setUsrId(rs.getString(7));
				dto.setTypeNo(rs.getInt(8));
				list.add(dto);
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<LeaveDto> selectByNo(int leaveNo){
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM Leave where LeaveNo = ?";

		Connection conn = ConnectionHelper.getConnection("oracle");
		List<LeaveDto> list = null;
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			list = new ArrayList<>();

			while (rs.next()) {
				LeaveDto dto = new LeaveDto();
				dto.setLeaveNo(rs.getInt(1));
				dto.setStartDay(rs.getDate(2));
				dto.setEndDay(rs.getDate(3));
				dto.setReason(rs.getString(4));
				dto.setLevStatus(rs.getInt(5));
				dto.setEmpNo(rs.getInt(6));
				dto.setUsrId(rs.getString(7));
				dto.setTypeNo(rs.getInt(8));
				list.add(dto);
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public int approveLeave(int num, int leaveNo){
		PreparedStatement pstmt = null;
		String sql = "update leave set LEVSTATUS = ? where leaveno= ?";
		Connection conn = ConnectionHelper.getConnection("oracle");
		int resultrow=0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setInt(2, leaveNo);			
			resultrow = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultrow;
	}
}
