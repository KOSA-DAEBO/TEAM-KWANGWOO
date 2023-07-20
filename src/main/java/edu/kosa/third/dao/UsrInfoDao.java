package edu.kosa.third.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import edu.kosa.third.dto.CustomerDto;
import edu.kosa.third.dto.DeptDto;
import edu.kosa.third.dto.EmpDetailsDto;
import edu.kosa.third.dto.EmpDto;
import edu.kosa.third.dto.PosDto;
import edu.kosa.third.dto.UsrDto;
import edu.kosa.third.utils.ConnectionHelper;

public class UsrInfoDao {

	//관리자 - 소비자 정보
	public List<CustomerDto> totalCustom() {
		String sql = "select * from customer";
		Connection conn = ConnectionHelper.getConnection("oracle");
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<CustomerDto> list = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				CustomerDto customDto = new CustomerDto();

				customDto.setCustomerNo(rs.getInt("customerNo"));
				customDto.setUsrId(rs.getString("usrId"));
				customDto.setCustomerEmail(rs.getString("customerEmail"));
				customDto.setCustomerTel(rs.getString("customerTel"));
				customDto.setCustomerGender(rs.getString("customerGender"));
				customDto.setCustomerBirth(rs.getDate("customerBirth"));
				customDto.setCustomerAddr(rs.getString("customerAddr"));
				customDto.setCustomerName(rs.getString("customerName"));

				list.add(customDto);
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

	// 관리자 - 소비자 개인정보 조회(상세보기)
	public CustomerDto customDetail(int customNo) {
		Connection conn = ConnectionHelper.getConnection("oracle");
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String select = "Select * from customer where customerNo = ?";
		CustomerDto dto = new CustomerDto();
		try {
			pstmt = conn.prepareStatement(select);
			pstmt.setInt(1, customNo);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				dto.setCustomerNo(rs.getInt("customerNo"));
				dto.setUsrId(rs.getString("usrId"));
				dto.setCustomerEmail(rs.getString("customerEmail"));
				dto.setCustomerTel(rs.getString("customerTel"));
				dto.setCustomerGender(rs.getString("customerGender"));
				dto.setCustomerBirth(rs.getDate("customerBirth"));
				dto.setCustomerAddr(rs.getString("customerAddr"));
				dto.setCustomerName(rs.getString("customerName"));

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

	// 관리자 - 퇴사 처리
	public boolean deleteEmpInfo(String usrId, int empNo) {
		String delete = "update emp set DEPARTUREDATE = current_timestamp where  empno = ?";
		String delete2 = "update usr set status = 1 , IMAGEPATH = null, THUMBNAILPATH = null where usrid = ?";
		Connection conn = ConnectionHelper.getConnection("oracle");
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		boolean result = false;
		try {
			pstmt = conn.prepareStatement(delete);
			pstmt.setInt(1, empNo);
			pstmt.execute();

			pstmt2 = conn.prepareStatement(delete2);
			pstmt2.setString(1, usrId);
			pstmt2.execute();

			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionHelper.close(pstmt);
			ConnectionHelper.close(pstmt2);
			ConnectionHelper.close(conn);
		}
		return result;
	}

	// 관리자 - 인사 정보 변경
	public void updateManageEmpInfo(int empNo, int posNo, int salary, int deptNo) {
		String update = "update emp set deptno = ? , posno = ? , salary = ? where empno = ?";
		Connection conn = ConnectionHelper.getConnection("oracle");
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(update);
			pstmt.setInt(1, deptNo);
			pstmt.setInt(2, posNo);
			pstmt.setInt(3, salary);
			pstmt.setInt(4, empNo);
			pstmt.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 직원 - 개인 정보 변경
	public void updateEmpInfo(EmpDto empDto) {
		String update = "update emp set empaddr = ?, emptel = ?, empemail = ?, imagepath = ? where empno = ?";
		Connection conn = ConnectionHelper.getConnection("oracle");
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(update);
			pstmt.setString(1, empDto.getEmpAddr());
			pstmt.setString(2, empDto.getEmpTel());
			pstmt.setString(3, empDto.getEmpEmail());
			pstmt.setString(4, empDto.getImagePath());
			pstmt.setInt(5, empDto.getEmpNo());
			pstmt.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionHelper.close(pstmt);
			ConnectionHelper.close(conn);
		}
	}

	// 직원 - 직원 개인 정보 상세조회
	public EmpDetailsDto detailEmpInfo(int empNo) {
		String sql = "SELECT d.deptname, p.posname, u.status"
				+ "	 FROM emp e JOIN pos p ON e.posNo = p.posNo JOIN dept d ON e.deptNo = d.deptNo JOIN usr u ON u.usrid = e.usrid"
				+ "	 WHERE e.empNo = ?";
		Connection conn = ConnectionHelper.getConnection("oracle");
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		EmpDetailsDto dto = null;
		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, empNo);
			rs = pstmt.executeQuery();

			PosDto posDto = new PosDto();
			DeptDto deptDto = new DeptDto();
			UsrDto usrDto = new UsrDto();

			while (rs.next()) {
				deptDto.setDeptName(rs.getString("DeptName"));
				posDto.setPosName(rs.getString("PosName"));
				usrDto.setStatus(rs.getString("Status"));

				dto = new EmpDetailsDto(posDto, deptDto, usrDto);
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

	// 관리자 - 전직원 요약 정보 조회 반복문 사용
	public List<EmpDto> totalEmpInfo() {
		String select = "select usrid, empno, empname, hiredate, imagepath from emp";
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
				EmpDto empDto = new EmpDto();

				empDto.setUsrId(rs.getString("UsrId"));
				empDto.setEmpNo(rs.getInt("EmpNo"));
				empDto.setEmpName(rs.getString("EmpName"));
				empDto.setHireDate(rs.getDate("HireDate"));
				empDto.setImagePath(rs.getString("imagePath"));
				list.add(empDto);
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

	// 직원 정보 조회
	public EmpDto selectEmpDetail(int empNo) {
		String sql = "SELECT * FROM EMP WHERE EMPNO = ?";
		Connection conn = ConnectionHelper.getConnection("oracle");
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		EmpDto dto = new EmpDto();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, empNo);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				dto.setEmpNo(rs.getInt("empNo"));
				dto.setUsrId(rs.getString("usrId"));
				dto.setEmpName(rs.getString("empName"));
				dto.setEmpBirth(rs.getDate("empBirth"));
				dto.setEmpEmail(rs.getString("empEmail"));
				dto.setEmpTel(rs.getString("empTel"));
				dto.setEmpStatus(rs.getBoolean("empStatus"));
				dto.setRole(rs.getBoolean("role"));
				dto.setEmpGender(rs.getString("empGender"));
				dto.setEmpAddr(rs.getString("empAddr"));
				dto.setHireDate(rs.getDate("hireDate"));
				dto.setAnnualLeave(rs.getInt("annualLeave"));
				dto.setDeptNo(rs.getInt("deptNo"));
				dto.setPosNo(rs.getInt("posNo"));
				dto.setSalary(rs.getInt("salary"));
				dto.setDepartureDate(rs.getDate("departureDate"));
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

}
