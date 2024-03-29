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
		sb.append(" order by amount desc");
		String sql = sb.toString();
		Connection conn = ConnectionHelper.getConnection("oracle");
		ArrayList<HashMap<String, String>> list = new ArrayList<>();
		HashMap<String, String> map;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				map = new HashMap<String, String>();
				String s = rs.getDate(6) + "";
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

	public ArrayList<HashMap<String, String>> selectMonth(String field1, String field2) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT amount, e.empno,empname, deptname, posname, payday , e.salary FROM sal s");
		sb.append(" left join emp e on e.empNo = s.empno");
		sb.append(" left join dept d on d.deptNo = e.deptNo");
		sb.append(" left join pos p on p.posNo = e.posNo");
		sb.append(" WHERE payDay=?");
		String sql = sb.toString();
		
		String day=field1.substring(2,4);
		day+=field2.substring(0,2);
		day+="20";
		
		Connection conn = ConnectionHelper.getConnection("oracle");
		ArrayList<HashMap<String, String>> list = new ArrayList<>();
		HashMap<String, String> map;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, day);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				map = new HashMap<String, String>();
				String s = rs.getDate(6) + "";
				String payMonth = s.substring(2, 7);
				String year = s.substring(0,4);
				String month = s.substring(5,7);
				String title = year+"년 "+month+"월";
				
				map.put("payMonth", payMonth);
				map.put("amount", rs.getInt(1) + "");
				map.put("empNo", rs.getInt(2) + "");
				map.put("empName", rs.getString(3));
				map.put("deptName", rs.getString(4));
				map.put("posName", rs.getString(5));
				map.put("payDay", rs.getDate(6) + "");
				map.put("salary", rs.getInt(7) + "");
				map.put("title", title);
				
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
				map.put("salary", rs.getDouble(5) + "");

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

	// ^(0[1-9]|1[0-2])(0[1-9]|1[0-9]|2[0-9]|3[0-1])$
	// ^(2[0-3])(0[1-9]|1[0-2])$

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
		HashMap<String, String> map = new HashMap<>();

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(empNo));
			rs = pstmt.executeQuery();

			while (rs.next()) {
				double salary = rs.getInt(5) * 10000;
				int a = (int) (salary * 0.045);
				int b = (int) (salary * 0.035);
				int c = (int) (salary * 0.0045);
				int d = (int) (salary * 0.009);
				int rankAllowance = 0;

				switch (rs.getString(4)) {
				case "대표이사":
					rankAllowance = 2000000;
					break;
				case "이사":
					rankAllowance = 1500000;
					break;
				case "부장":
					rankAllowance = 1000000;
					break;
				case "차장":
					rankAllowance = 700000;
					break;
				case "과장":
					rankAllowance = 500000;
					break;
				case "대리":
					rankAllowance = 300000;
					break;
				case "주임":
					rankAllowance = 100000;
					break;
				}

				map.put("empNo", rs.getInt(1) + "");
				map.put("empName", rs.getString(2));
				map.put("deptName", rs.getString(3));
				map.put("posName", rs.getString(4));
				map.put("salary", (rs.getInt(5) * 10000) + "");
				map.put("rankAllowance", rankAllowance + "");
				map.put("NP", a + "");
				map.put("HI", b + "");
				map.put("EI", c + "");
				map.put("CI", d + "");

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

	public int applySal(String total, String empNo, String bonus) {
		PreparedStatement pstmt = null;
		String sql = "insert into sal(amount,payday,empno,usrid,bonus) values (?,TRUNC(SYSDATE, 'MM') + INTERVAL '19' DAY,?,?,?)";
		Connection conn = ConnectionHelper.getConnection("oracle");
		int resultrow = 0;
		double amount = Double.parseDouble(total) / 10000;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setDouble(1, amount);
			pstmt.setInt(2, Integer.parseInt(empNo));
			pstmt.setString(3, searchUsrId(empNo));
			pstmt.setInt(4, Integer.parseInt(bonus));
			resultrow = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionHelper.close(pstmt);
			ConnectionHelper.close(conn);
		}
		return resultrow;
	}

	public String searchUsrId(String empNo) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select usrId from EMP where empNo = ?";
		Connection conn = ConnectionHelper.getConnection("oracle");
		String usrId = "";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(empNo));
			rs = pstmt.executeQuery();
			while (rs.next()) {
				usrId = rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionHelper.close(rs);
			ConnectionHelper.close(pstmt);
			ConnectionHelper.close(conn);
		}
		return usrId;
	}

	public HashMap<String, String> selectBySalNo(String empNo, String payDay) {
		PreparedStatement pstmt = null;
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT amount, empname, e.empno, deptname, posname, payday , e.salary, bonus FROM sal s");
		sb.append(" left join emp e on e.empNo = s.empno");
		sb.append(" left join dept d on e.deptNo = d.deptNo");
		sb.append(" left join pos p on p.posNo = e.posNo");
		sb.append(" where payday=? and e.empno=?");
		String sql = sb.toString();

		Connection conn = ConnectionHelper.getConnection("oracle");
		ResultSet rs = null;
		HashMap<String, String> map = new HashMap<>();

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, payDay);
			pstmt.setInt(2, Integer.parseInt(empNo));
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int salary = rs.getInt(7) * 10000;
				int a = (int) (salary * 0.045);
				int b = (int) (salary * 0.035);
				int c = (int) (salary * 0.0045);
				int d = (int) (salary * 0.009);
				int totalExpense = a + b + c + d;
				int rankAllowance = 0;

				switch (rs.getString(5)) {
				case "대표이사":
					rankAllowance = 2000000;
					break;
				case "이사":
					rankAllowance = 1500000;
					break;
				case "부장":
					rankAllowance = 1000000;
					break;
				case "차장":
					rankAllowance = 700000;
					break;
				case "과장":
					rankAllowance = 500000;
					break;
				case "대리":
					rankAllowance = 300000;
					break;
				case "주임":
					rankAllowance = 100000;
					break;
				}
				int totalAllowance = rankAllowance + salary + 200000 + rs.getInt(8);

				map.put("amount", rs.getDouble(1) + "");
				map.put("empName", rs.getString(2));
				map.put("empNo", rs.getInt(3) + "");
				map.put("deptName", rs.getString(4));
				map.put("posName", rs.getString(5));
				map.put("payDay", rs.getDate(6) + "");
				map.put("salary", (rs.getInt(7) * 10000) + "");
				map.put("bonus", rs.getInt(8) + "");
				map.put("rankAllowance", rankAllowance + "");
				map.put("totalExpense", totalExpense + "");
				map.put("totalAllowance", totalAllowance + "");
				map.put("NP", a + "");
				map.put("HI", b + "");
				map.put("EI", c + "");
				map.put("CI", d + "");
				System.out.println(map.get("bonus"));
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

	public ArrayList<HashMap<String, String>> selectAllById(String usrId) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT amount, e.empno, empname, deptname, posname, payday , e.salary FROM sal s");
		sb.append(" left join emp e on e.empNo = s.empno");
		sb.append(" left join dept d on d.deptNo = e.deptNo");
		sb.append(" left join pos p on p.posNo = e.posNo");
		sb.append(" where e.usrId=?");
		sb.append(" order by payDay desc");
		String sql = sb.toString();
		Connection conn = ConnectionHelper.getConnection("oracle");
		ArrayList<HashMap<String, String>> list = new ArrayList<>();
		HashMap<String, String> map;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, usrId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				map = new HashMap<String, String>();
				String s = rs.getDate(6) + "";
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

	public void deleteSal(String empNo, String payDay) {
		PreparedStatement pstmt = null;
		String sql = "delete from sal where payday=? and empno=?";
		Connection conn = ConnectionHelper.getConnection("oracle");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, payDay);
			pstmt.setInt(2, Integer.parseInt(empNo));
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionHelper.close(pstmt);
			ConnectionHelper.close(conn);
		}
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

	public void modifySal(String bonus, String amount, String empNo, String payDay) {
		PreparedStatement pstmt = null;
		String sql = "update sal set bonus= ? , amount=? where empNo=? and payDay=?";
		Connection conn = ConnectionHelper.getConnection("oracle");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(bonus));
			pstmt.setInt(2, Integer.parseInt(amount)/10000);
			pstmt.setInt(3, Integer.parseInt(empNo));
			pstmt.setString(4, payDay);
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