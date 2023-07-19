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

public class SalDao {
	public ArrayList<HashMap<String, String>> selectTM() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT amount, e.empno, empname, deptname, posname, payday , e.salary FROM sal s");
		sb.append(" left join emp e on e.empNo = s.empno");
		sb.append(" left join dept d on d.deptNo = e.deptNo");
		sb.append(" left join pos p on p.posNo = e.posNo");
		sb.append(" WHERE EXTRACT(MONTH FROM payday) = EXTRACT(MONTH FROM SYSDATE)");
		sb.append(" AND EXTRACT(YEAR FROM payday) = EXTRACT(YEAR FROM SYSDATE)");
		String sql = sb.toString();
		Connection conn = ConnectionHelper.getConnection("oracle");
		ArrayList<HashMap<String, String>> list = new ArrayList<>();
		HashMap<String, String> map;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				map = new HashMap<String, String>();
				String s = rs.getDate(6)+"";
				String payMonth = s.substring(2, 7);
				map.put("payMonth", payMonth);
				map.put("amount", rs.getInt(1) + "");
				map.put("empNo", rs.getInt(2) + "");
				map.put("empName", rs.getString(3));
				map.put("deptName", rs.getString(4));
				map.put("posName", rs.getString(5));
				map.put("payDay", rs.getDate(6) + "");
				map.put("salary", rs.getInt(7) + "");
				
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
	
	public ArrayList<HashMap<String, String>> selectEmpAll() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuilder sb = new StringBuilder();
		sb.append("select e.empno, empname, deptname, posname, salary from emp e");
		sb.append(" left join dept d on e.deptNo = d.deptNo");
		sb.append(" left join pos p on p.posNo = e.posNo");
		sb.append(" order by e.empno");
		String sql = sb.toString();
		Connection conn = ConnectionHelper.getConnection("oracle");
		ArrayList<HashMap<String, String>> list = new ArrayList<>();
		HashMap<String, String> map;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				map = new HashMap<String, String>();
				map.put("empNo", rs.getInt(1) + "");
				map.put("empName", rs.getString(2));
				map.put("deptName", rs.getString(3));
				map.put("posName", rs.getString(4));
				map.put("salary", rs.getInt(5) + "");
				
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
	
	public ArrayList<HashMap<String, String>> selectEmpTM() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuilder sb = new StringBuilder();
		sb.append("select e.empno, empname, deptname, posname, salary from emp e");
		sb.append(" left join dept d on e.deptNo = d.deptNo");
		sb.append(" left join pos p on p.posNo = e.posNo");
		sb.append(" WHERE NOT EXISTS (");
		sb.append(" SELECT * FROM sal");
		sb.append(" WHERE EXTRACT(MONTH FROM payday) = EXTRACT(MONTH FROM SYSDATE)");
		sb.append(" AND EXTRACT(YEAR FROM payday) = EXTRACT(YEAR FROM SYSDATE)");
		sb.append(" AND sal.empno = e.empno)");
		sb.append(" order by e.empno");
		String sql = sb.toString();
		Connection conn = ConnectionHelper.getConnection("oracle");
		ArrayList<HashMap<String, String>> list = new ArrayList<>();
		HashMap<String, String> map;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				map = new HashMap<String, String>();
				map.put("empNo", rs.getInt(1) + "");
				map.put("empName", rs.getString(2));
				map.put("deptName", rs.getString(3));
				map.put("posName", rs.getString(4));
				map.put("salary", rs.getInt(5) + "");
				
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
	

	public int checkSalary(String empNo) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT Salary from EMP where empNo = ?";
		Connection conn = ConnectionHelper.getConnection("oracle");
		int num = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, empNo);
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
	
		//^(0[1-9]|1[0-2])(0[1-9]|1[0-9]|2[0-9]|3[0-1])$
		//^(2[0-3])(0[1-9]|1[0-2])$
	
	public HashMap<String, String> selectByNo(String empNo) {
		PreparedStatement pstmt = null;
		StringBuilder sb = new StringBuilder();
		sb.append("select e.empno, empname, deptname, posname, salary from emp e");
		sb.append(" left join dept d on e.deptNo = d.deptNo");
		sb.append(" left join pos p on p.posNo = e.posNo");
		sb.append(" where e.empno=?");
		String sql = sb.toString();

		Connection conn = ConnectionHelper.getConnection("oracle");
		ResultSet rs = null;
		HashMap<String, String> map= new HashMap<>();

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(empNo));
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int salary = rs.getInt(5)*10000;
				int a = (int)(salary*0.045);
				int b = (int)(salary*0.035);
				int c = (int)(salary*0.0045);
				int d = (int)(salary*0.009);
				
				map.put("empNo",rs.getInt(1) + "");
				map.put("empName",rs.getString(2));
				map.put("deptName",rs.getString(3));
				map.put("posName",rs.getString(4));
				map.put("NP",a + "");
				map.put("HI",b + "");
				map.put("EI",c + "");
				map.put("CI",d + "");
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionHelper.close(rs);
			ConnectionHelper.close(pstmt);
			ConnectionHelper.close(conn);
		}
		return map;
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

	public boolean checkDays(String usrId, String startDay, String endDay) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from leave where usrId= ? and levstatus=0 and ?>=startday and ?<=endday";
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