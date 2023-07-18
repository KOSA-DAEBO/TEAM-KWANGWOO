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

	public void updateEmpManage(DeptDto deptdto, PosDto posdto) {
		String update = "update smp set d.deptname=?, p.posname=? from pos p, dept d where usrid=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = ConnectionHelper.getConnection("oracle");
			pstmt = conn.prepareStatement(update);

			pstmt.setString(1, deptdto.getDeptName());
			pstmt.setString(2, posdto.getPosName());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionHelper.close(pstmt);
			ConnectionHelper.close(conn);
		}
	}

	public void updateEmpInfo(EmpDto empdto) {
		String update = "update emp set empname=?, empaddr=?, emptel=?, empemail=? where empno=?";
		Connection conn = ConnectionHelper.getConnection("oracle");
		PreparedStatement pstmt = null;
		try {

			pstmt = conn.prepareStatement(update);

			pstmt.setString(1, empdto.getEmpName());
			pstmt.setString(2, empdto.getEmpAddr());
			pstmt.setString(3, empdto.getEmpTel());
			pstmt.setString(4, empdto.getEmpEmail());
			pstmt.setInt(5, empdto.getEmpNo());
//			pstmt.setString(6, usrdto.getUsrimage());

			pstmt.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionHelper.close(pstmt);
			ConnectionHelper.close(conn);
		}
	}

	// 소비자 개인정보 조회
	public CustomerDto customerInfoAll(HttpServletRequest request) { // 개선 필요. 동일한 작업을 반복한다.

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

			while (rs.next()) {
				customdto.setCustomerNo(rs.getString("CustomerNo"));
				customdto.setUsrId(rs.getString("UsrId"));
				customdto.setCustomerEmail(rs.getString("CustomerEmail"));
				customdto.setCustomerTel(rs.getString("CustomerTel"));
				customdto.setCustomerGender(rs.getString("CustomerGender"));
				customdto.setCustomerBirth(rs.getDate("CustomerBirth"));
				customdto.setCustomerAddr(rs.getString("CustomerAddr"));
				customdto.setCustomerName(rs.getString("CustomerName"));

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
		String sql = "SELECT e.empno, e.usrid, e.empname, e.empbirth, e.empemail, e.empstatus,"
				+ " e.emptel, e.empgender, e.empaddr, e.hiredate, e.annualleave, d.deptname, p.posname"// u.usrimage
				+ " FROM emp e JOIN pos p ON e.posNo = p.posNo JOIN dept d ON e.deptNo = d.deptNo "
				+ " WHERE e.empNo = ?";

		EmpDetailsDto dto = null;
		try (Connection conn = ConnectionHelper.getConnection("oracle");
				PreparedStatement pstmt = conn.prepareStatement(sql)) {

			HttpSession session = request.getSession();
			EmpDto empdto = (EmpDto) session.getAttribute("login");
			pstmt.setInt(1, empdto.getEmpNo());

			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					EmpDto emp = new EmpDto();
					PosDto pos = new PosDto();
					DeptDto dept = new DeptDto();
					UsrDto usr = new UsrDto();
					
					emp.setEmpNo(rs.getInt("EmpNo"));
					emp.setUsrId(rs.getString("UsrId"));
					emp.setEmpName(rs.getString("EmpName"));
					emp.setEmpBirth(rs.getDate("EmpBirth"));
					emp.setEmpEmail(rs.getString("EmpEmail"));
					emp.setEmpStatus(rs.getBoolean("EmpStatus"));
					emp.setEmpTel(rs.getString("EmpTel"));
					emp.setEmpGender(rs.getString("EmpGender"));
					emp.setEmpAddr(rs.getString("EmpAddr"));
					emp.setHireDate(rs.getDate("HireDate"));
					emp.setAnnualLeave(rs.getInt("AnnualLeave"));
					dept.setDeptName(rs.getString("DeptName"));
					pos.setPosName(rs.getString("PosName"));
					
					dto = new EmpDetailsDto(emp, pos, dept, usr);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
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

				empdto.setUsrId(rs.getString("UsrId"));
				empdto.setEmpNo(rs.getInt("EmpNo"));
				empdto.setEmpName(rs.getString("EmpName"));
				empdto.setHireDate(rs.getDate("HireDate"));
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
