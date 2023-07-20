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
		String sql = "insert into leave (startday, endday, reason, empno, usrid, typeno)" + " values(?,?,?,?,?,?)";
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
			ConnectionHelper.close(pstmt);
			ConnectionHelper.close(conn);
		}
		return resultrow;
	}

	public ArrayList<HashMap<String, String>> selectAll() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuilder sb = new StringBuilder();
		sb.append(
				"SELECT leaveno, empname, e.empno, deptname, posname, typeno, startday, endday, levstatus, e.annualLeave FROM leave l");
		sb.append(" left join emp e on e.empNo = l.empNo");
		sb.append(" left join dept d on d.deptNo = e.deptNo");
		sb.append(" left join pos p on p.posNo = e.posNo");
		sb.append(" order by leaveno");
		String sql = sb.toString();

		/// Pool ///////////////////////////////////
		Connection conn = ConnectionHelper.getConnection("oracle");
		////////////////////////////////////////////
		ArrayList<HashMap<String, String>> list = new ArrayList<>();
		HashMap<String, String> map;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				map = new HashMap<String, String>();
				map.put("leaveNo", rs.getInt(1) + "");
				map.put("empName", rs.getString(2));
				map.put("empNo", rs.getInt(3) + "");
				map.put("deptName", rs.getString(4));
				map.put("posName", rs.getString(5));
				map.put("typeNo", rs.getInt(6) + "");
				map.put("startDay", rs.getDate(7) + "");
				map.put("endDay", rs.getDate(8) + "");
				map.put("levStatus", rs.getInt(9) + "");
				map.put("annualLeave", rs.getInt(10) + "");
				list.add(map);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionHelper.close(rs);
			ConnectionHelper.close(pstmt);
			ConnectionHelper.close(conn);
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
		sb.append(" order by leaveno");
		String sql = sb.toString();

		Connection conn = ConnectionHelper.getConnection("oracle");
		ResultSet rs = null;
		ArrayList<HashMap<String, String>> list = new ArrayList<>();
		HashMap<String, String> map;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(leaveNo));
			rs = pstmt.executeQuery();

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
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionHelper.close(rs);
			ConnectionHelper.close(pstmt);
			ConnectionHelper.close(conn);
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
		} finally {
			ConnectionHelper.close(pstmt);
			ConnectionHelper.close(conn);
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
			annual -= (days + 1);

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
		} finally {
			ConnectionHelper.close(pstmt);
			ConnectionHelper.close(conn);
		}
	}

	public int checkAnnual(String usrId) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT ANNUALLEAVE from EMP where usrId = ?";
		Connection conn = ConnectionHelper.getConnection("oracle");
		int num = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, usrId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				num = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionHelper.close(rs);
			ConnectionHelper.close(pstmt);
			ConnectionHelper.close(conn);
		}
		return num;
	}

	public boolean checkDays(String usrId, String startDay, String endDay) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from leave where usrId= ? and (levstatus = 0 OR levstatus = 1) and ? < endday and ? > startday";
		Connection conn = ConnectionHelper.getConnection("oracle");
		boolean flag = false;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, usrId);
			pstmt.setString(2, startDay);
			pstmt.setString(3, endDay);
			rs = pstmt.executeQuery();
			flag = rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionHelper.close(rs);
			ConnectionHelper.close(pstmt);
			ConnectionHelper.close(conn);
		}
		return flag;
	}

	public int searchEmpNo(String usrId) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select EmpNo from EMP where usrId= ?";
		Connection conn = ConnectionHelper.getConnection("oracle");
		int empNo = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, usrId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				empNo = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionHelper.close(rs);
			ConnectionHelper.close(pstmt);
			ConnectionHelper.close(conn);
		}
		return empNo;
	}

	public void deleteLeave(int leaveNo) {
		PreparedStatement pstmt = null;
		String sql = "delete from leave where leaveno= ?";
		Connection conn = ConnectionHelper.getConnection("oracle");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, leaveNo);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionHelper.close(pstmt);
			ConnectionHelper.close(conn);
		}
	}

	public ArrayList<HashMap<String, String>> selectById(String usrId) {
		PreparedStatement pstmt = null;
		StringBuilder sb = new StringBuilder();
		sb.append(
				"SELECT leaveno, e.empno, empname, deptname, posname, typeno, startday, endday, levstatus, e.annualLeave FROM leave l");
		sb.append(" left join emp e on e.empNo = l.empNo");
		sb.append(" left join dept d on d.deptNo = e.deptNo");
		sb.append(" left join pos p on p.posNo = e.posNo");
		sb.append(" where l.usrId= ?");
		sb.append(" order by leaveno");
		String sql = sb.toString();

		/// Pool ///////////////////////////////////
		ResultSet rs = null;
		Connection conn = ConnectionHelper.getConnection("oracle");
		////////////////////////////////////////////
		ArrayList<HashMap<String, String>> list = new ArrayList<>();
		HashMap<String, String> map;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, usrId);
			rs = pstmt.executeQuery();
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
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionHelper.close(rs);
			ConnectionHelper.close(pstmt);
			ConnectionHelper.close(conn);
		}
		return list;
	}

	public void incAnnualLeave(String startDay, String endDay, String usrId) {
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		long days = 0;
		int annual = checkAnnual(usrId);
		try {
			Date sd = sdf.parse(startDay);
			Date ed = sdf.parse(endDay);
			long sec = ((ed.getTime() - sd.getTime())) / 1000;
			days = sec / (24 * 60 * 60);
			annual += (days + 1);

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
		} finally {
			ConnectionHelper.close(pstmt);
			ConnectionHelper.close(conn);
		}
	}

	public void modifyLeave(String startDay, String endDay, String reason, int typeNo, int leaveNo) {
		PreparedStatement pstmt = null;
		String sql = "update Leave set startday = ?, endday = ?, reason=?, typeno=? where leaveno = ?";
		Connection conn = ConnectionHelper.getConnection("oracle");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, startDay);
			pstmt.setString(2, endDay);
			pstmt.setString(3, reason);
			pstmt.setInt(4, typeNo);
			pstmt.setInt(5, leaveNo);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionHelper.close(pstmt);
			ConnectionHelper.close(conn);
		}

	}

	public ArrayList<HashMap<String, String>> selectByEmpNo(int empNo) {
		PreparedStatement pstmt = null;
		StringBuilder sb = new StringBuilder();
		sb.append(
				"SELECT leaveno, e.empno, empname, deptname, posname, typeno, startday, endday, levstatus, e.annualLeave FROM leave l");
		sb.append(" left join emp e on e.empNo = l.empNo");
		sb.append(" left join dept d on d.deptNo = e.deptNo");
		sb.append(" left join pos p on p.posNo = e.posNo");
		sb.append(" where e.empno= ?");
		sb.append(" order by leaveno");
		String sql = sb.toString();

		/// Pool ///////////////////////////////////
		ResultSet rs = null;
		Connection conn = ConnectionHelper.getConnection("oracle");
		////////////////////////////////////////////
		ArrayList<HashMap<String, String>> list = new ArrayList<>();
		HashMap<String, String> map;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, empNo);
			rs = pstmt.executeQuery();
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
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionHelper.close(rs);
			ConnectionHelper.close(pstmt);
			ConnectionHelper.close(conn);
		}
		return list;
	}

	public ArrayList<HashMap<String, String>> selectByPosName(String posName) {
		PreparedStatement pstmt = null;
		StringBuilder sb = new StringBuilder();
		sb.append(
				"SELECT leaveno, e.empno, empname, deptname, posname, typeno, startday, endday, levstatus, e.annualLeave FROM leave l");
		sb.append(" left join emp e on e.empNo = l.empNo");
		sb.append(" left join dept d on d.deptNo = e.deptNo");
		sb.append(" left join pos p on p.posNo = e.posNo");
		sb.append(" where p.posName= ?");
		sb.append(" order by leaveno");
		String sql = sb.toString();

		/// Pool ///////////////////////////////////
		ResultSet rs = null;
		Connection conn = ConnectionHelper.getConnection("oracle");
		////////////////////////////////////////////
		ArrayList<HashMap<String, String>> list = new ArrayList<>();
		HashMap<String, String> map;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, posName);
			rs = pstmt.executeQuery();
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
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionHelper.close(rs);
			ConnectionHelper.close(pstmt);
			ConnectionHelper.close(conn);
		}
		return list;
	}
	
	public ArrayList<HashMap<String, String>> selectByDeptName(String deptName) {
		PreparedStatement pstmt = null;
		StringBuilder sb = new StringBuilder();
		sb.append(
				"SELECT leaveno, e.empno, empname, deptname, posname, typeno, startday, endday, levstatus, e.annualLeave FROM leave l");
		sb.append(" left join emp e on e.empNo = l.empNo");
		sb.append(" left join dept d on d.deptNo = e.deptNo");
		sb.append(" left join pos p on p.posNo = e.posNo");
		sb.append(" where d.deptName= ?");
		sb.append(" order by leaveno");
		String sql = sb.toString();

		/// Pool ///////////////////////////////////
		ResultSet rs = null;
		Connection conn = ConnectionHelper.getConnection("oracle");
		////////////////////////////////////////////
		ArrayList<HashMap<String, String>> list = new ArrayList<>();
		HashMap<String, String> map;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, deptName);
			rs = pstmt.executeQuery();
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
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionHelper.close(rs);
			ConnectionHelper.close(pstmt);
			ConnectionHelper.close(conn);
		}
		return list;
	}

}