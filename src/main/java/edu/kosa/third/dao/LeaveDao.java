package edu.kosa.third.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import edu.kosa.third.dto.LeaveDto;
import edu.kosa.third.utils.ConnectionHelper;

public class LeaveDao {
	public int applyLeave(String typeNo, String startDay, String endDay, String reason, String usrId) {

		int resultrow = 0;
		PreparedStatement pstmt = null;
		String sql = "insert into leave (startday, endday, reason, empno, usrid, typeno)"
					+" values(?,?,?,?,?,?)";
		// Pool
		Connection conn = null;
		int type = Integer.parseInt(typeNo);

		try {
			conn = ConnectionHelper.getConnection("oracle");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, startDay);
			pstmt.setString(2, endDay);
			pstmt.setString(3, reason);
			pstmt.setInt(4, searchEmpNo(usrId));
			pstmt.setString(5, usrId);
			pstmt.setInt(6, type);

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

	public ArrayList<HashMap<String, String>> selectAll() {
		PreparedStatement pstmt = null;
		StringBuilder sb = new StringBuilder();
		sb.append(
				"SELECT leaveno, e.empno, empname, deptname, posname, typeno, startday, endday, levstatus, e.annualLeave FROM leave l");
		sb.append(" left join emp e on e.empNo = l.empNo");
		sb.append(" left join dept d on d.deptNo = e.deptNo");
		sb.append(" left join pos p on p.posNo = e.posNo");
		String sql = sb.toString();

		/// Pool ///////////////////////////////////
		Connection conn = ConnectionHelper.getConnection("oracle");
		////////////////////////////////////////////
		ArrayList<HashMap<String, String>> list = new ArrayList<>();
		HashMap<String, String> map;
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				map = new HashMap<String, String>();
				map.put("leaveNo", rs.getInt(1) + "");
				map.put("empNo", rs.getInt(2) + "");
				map.put("empName", rs.getString(3));
				map.put("deptName", rs.getString(4));
				map.put("posName", rs.getString(5));
				map.put("typeNo", rs.getInt(6) + "");
				map.put("startDay", rs.getDate(7) + "");
				map.put("endDay", rs.getDate(8) + "");
				map.put("levStatus", rs.getInt(9) + "");
				map.put("annualLeave", rs.getInt(10) + "");
				list.add(map);
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<HashMap<String, String>> selectByNo(String leaveNo) {
		PreparedStatement pstmt = null;
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT * FROM leave l left join emp e on e.empNo = l.empNo");
		sb.append(" left join dept d on d.deptNo = e.deptNo");
		sb.append(" left join pos p on p.posNo = e.posNo");
		sb.append(" where leaveNo = ?");
		String sql = sb.toString();

		Connection conn = ConnectionHelper.getConnection("oracle");
		
		ArrayList<HashMap<String, String>> list = new ArrayList<>();
		HashMap<String, String> map;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(leaveNo));
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				map = new HashMap<String, String>();
				map.put("leaveNo", rs.getInt(1) + "");
				map.put("empNo", rs.getInt("EMPNO") + "");
				map.put("empName", rs.getString("EMPNAME"));
				map.put("deptName", rs.getString("DEPTNAME"));
				map.put("posName", rs.getString("POSNAME"));
				map.put("startDay", rs.getDate(2) + "");
				map.put("endDay", rs.getDate(3) + "");
				map.put("typeNo", rs.getInt("TYPENO") + "");
				map.put("reason", rs.getString("REASON"));
				map.put("empTel", rs.getString("EMPTEL"));
				map.put("empEmail", rs.getString("EMPEMAIL"));
				map.put("levStatus", rs.getInt(5) + "");
				list.add(map);
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public int approveLeave(int num, int leaveNo) {
		PreparedStatement pstmt = null;
		String sql = "update leave set LEVSTATUS = ? where leaveno= ?";
		Connection conn = ConnectionHelper.getConnection("oracle");
		int resultrow = 0;
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
	
	public void decAnnualLeave(String startDay, String endDay, String usrId) {
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		long days = 0;
		int annual = checkAnnual(usrId);
		try {
			Date sd = sdf.parse(startDay);
			Date ed = sdf.parse(endDay);
			long sec = ((ed.getTime() - sd.getTime())) / 1000;
			days = sec / (24 * 60 * 60);
			annual-=(days+1);

		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		PreparedStatement pstmt = null;
		String sql = "update EMP set AnnualLeave = ? where usrId = ?";
		Connection conn = ConnectionHelper.getConnection("oracle");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, annual);
			pstmt.setString(2, usrId);	
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int checkAnnual(String usrId) {
		PreparedStatement pstmt = null;
		String sql = "SELECT ANNUALLEAVE from EMP where usrId = ?";
		Connection conn = ConnectionHelper.getConnection("oracle");
		int num = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, usrId);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				num = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num;
	}

	public boolean checkDays(String usrId, String startDay, String endDay){
		PreparedStatement pstmt = null;
		String sql = "select * from leave where usrId= ? and ?>=startday and ?<=endday";
		Connection conn = ConnectionHelper.getConnection("oracle");
		boolean flag = false;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, usrId);
			pstmt.setString(2, startDay);
			pstmt.setString(3, endDay);
			ResultSet rs = pstmt.executeQuery();
			flag = rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	public int searchEmpNo(String usrId) {
		PreparedStatement pstmt = null;
		String sql = "select EmpNo from EMP where usrId= ?";
		Connection conn = ConnectionHelper.getConnection("oracle");
		int empNo=0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, usrId);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				empNo = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return empNo;
	}
}
