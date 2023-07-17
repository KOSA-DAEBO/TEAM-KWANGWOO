package edu.kosa.third.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import edu.kosa.third.dto.CustomerDto;
import edu.kosa.third.dto.DeptDto;
import edu.kosa.third.dto.EmpDetailsDto;
import edu.kosa.third.dto.EmpDto;
import edu.kosa.third.dto.PosDto;
import edu.kosa.third.dto.UsrDto;
import edu.kosa.third.utils.ConnectionHelper;

public class UsrInfoDao {
	
	public void updateEmpInfo(EmpDto empdto) {
		String update = "update emp set empname=?, empaddr=?, emptel=?, empemail=? where empno=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = ConnectionHelper.getConnection("oracle");
			pstmt = conn.prepareStatement(update);
			
			
			pstmt.setString(1, empdto.getEmpName());
			pstmt.setString(2, empdto.getEmpAddr());
			pstmt.setString(3, empdto.getEmpTel());
			pstmt.setString(4, empdto.getEmpEmail());
			pstmt.setInt(5, empdto.getEmpNo());
//			pstmt.setString(6, usrdto.getUsrimage());
			pstmt.execute();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			ConnectionHelper.close(pstmt);
			ConnectionHelper.close(conn);
		}
	}

	//관리자 직원 정보 조회
	public int managerEmp(String usrId) {
		String select = "select role from emp where usrId = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = ConnectionHelper.getConnection("oracle");
			pstmt = conn.prepareStatement(select);
			pstmt.setString(1, usrId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getInt("role");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionHelper.close(rs);
			ConnectionHelper.close(pstmt);
			ConnectionHelper.close(conn);
		}
		return 0;
	}

	// 소비자 개인정보 조회
	public CustomerDto customerInfoAll(HttpServletRequest request) {
		String sql = "select * from customer where customerno=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		CustomerDto customdto = null;
		try {
			conn = ConnectionHelper.getConnection("oracle");
			pstmt = conn.prepareStatement(sql);

			HttpSession session = request.getSession();
			CustomerDto custdto = new CustomerDto();
			custdto = (CustomerDto) session.getAttribute("login");

			pstmt.setString(1, custdto.getCustomerNo());

			rs = pstmt.executeQuery();
			customdto = new CustomerDto();

			while (rs.next()) {
				customdto.setCustomerNo(rs.getString(1));
				customdto.setUsrId(rs.getString(2));
				customdto.setCustomerEmail(rs.getString(3));
				customdto.setCustomerTel(rs.getString(4));
				customdto.setCustomerGender(rs.getString(5));
				customdto.setCustomerBirth(rs.getDate(6));
				customdto.setCustomerAddr(rs.getString(7));
				customdto.setCustomerName(rs.getString(8));

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionHelper.close(rs);
			ConnectionHelper.close(pstmt);
			ConnectionHelper.close(conn);
		}
		return customdto;
	}

	// 직원 - 직원 개인 정보 상세조회
	public EmpDetailsDto detailEmpInfo(HttpServletRequest request) {
		String sql = "select e.empno, e.usrid, e.empname, e.empbirth, e.empemail, e.empstatus,"
				+ " e.emptel, e.empgender, e.empaddr, e.hiredate, e.annualleave, d.deptname, p.posname, e.role "//u.usrimage
				+ " from emp e, pos p, dept d where e.deptNo = d.deptNo and e.posNo = p.posNo and e.empNo = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		EmpDetailsDto dto = null;
		try {
			conn = ConnectionHelper.getConnection("oracle");
			pstmt = conn.prepareStatement(sql);

			HttpSession session = request.getSession();
			EmpDto empdto = new EmpDto();
			empdto = (EmpDto) session.getAttribute("login");

			pstmt.setInt(1, empdto.getEmpNo());
			rs = pstmt.executeQuery();

			EmpDto emp = new EmpDto();
			PosDto pos = new PosDto();
			DeptDto dept = new DeptDto();
			UsrDto usr = new UsrDto();
			
			while (rs.next()) {

				emp.setEmpNo(rs.getInt(1));
				emp.setUsrId(rs.getString(2));
				emp.setEmpName(rs.getString(3));
				emp.setEmpBirth(rs.getDate(4));
				emp.setEmpEmail(rs.getString(5));
				emp.setEmpStatus(rs.getBoolean(6));
				emp.setEmpTel(rs.getString(7));
				emp.setEmpGender(rs.getString(8));
				emp.setEmpAddr(rs.getString(9));
				emp.setHireDate(rs.getDate(10));
				emp.setAnnualLeave(rs.getInt(11));
				dept.setDeptName(rs.getString(12));
				pos.setPosName(rs.getString(13));
				emp.setRole(rs.getBoolean(14));
//				usr.setUsrimage(rs.getString(15));
				
				dto = new EmpDetailsDto(emp, pos, dept, usr);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionHelper.close(rs);
			ConnectionHelper.close(pstmt);
			ConnectionHelper.close(conn);
		}
		return dto;
	}

	// 전체 직원 조회 반복문 사용
	public List<EmpDto> totalEmpInfo() {
		String select = "select usrid, empno, empname, hiredate from emp";
		List<EmpDto> list = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			list = new ArrayList<>();
			conn = ConnectionHelper.getConnection("oracle");
			pstmt = conn.prepareStatement(select);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				EmpDto empdto = new EmpDto();

				empdto.setUsrId(rs.getString(1));
				empdto.setEmpNo(rs.getInt(2));
				empdto.setEmpName(rs.getString(3));
				empdto.setHireDate(rs.getDate(4));
				list.add(empdto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionHelper.close(rs);
			ConnectionHelper.close(pstmt);
			ConnectionHelper.close(conn);
		}
		return list;
	}
}
