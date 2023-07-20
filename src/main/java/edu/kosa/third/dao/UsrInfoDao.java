package edu.kosa.third.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import edu.kosa.third.dto.DeptDto;
import edu.kosa.third.dto.EmpDetailsDto;
import edu.kosa.third.dto.EmpDto;
import edu.kosa.third.dto.PosDto;
import edu.kosa.third.dto.UsrDto;
import edu.kosa.third.utils.ConnectionHelper;

public class UsrInfoDao {

	//관리자 - 퇴사 처리
	public boolean deleteEmpInfo(EmpDetailsDto empDetailDto) {
		String delete = "update usr set status = ?  where usrid = ?";
		String delete2 = "update emp set DEPARTUREDATE = ? where  empno = ?";
		Connection conn = ConnectionHelper.getConnection("oracle");
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		boolean result = false;
		try {
			pstmt = conn.prepareStatement(delete);
			pstmt.setString(1, empDetailDto.getUsrDto().getStatus());
			pstmt.setString(2, empDetailDto.getUsrDto().getUsrId());
			pstmt.execute();
		
			pstmt2 = conn.prepareStatement(delete2);
			pstmt2.setDate(1, empDetailDto.getEmpDto().getDepartureDate());
			pstmt2.setInt(2, empDetailDto.getEmpDto().getEmpNo());
			pstmt2.execute();
				
			result = true;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			ConnectionHelper.close(pstmt);
			ConnectionHelper.close(conn);
		}
		return result;
	}
	
	//관리자 - 인사 정보 변경
	public void updateManageEmpInfo(int empNo) {
		String update="update emp set deptno = ? , posno = ? , salary = ? where empno = ?";
		Connection conn = ConnectionHelper.getConnection("oracle");
		PreparedStatement pstmt;
		try {
		pstmt = conn.prepareStatement(update);
//		pstmt.setInt(1, empDto.getDeptNo());
//		pstmt.setInt(2, empDto.getPosNo());
//		pstmt.setInt(3, empDto.getSalary());
//		pstmt.setInt(4, empDto.getEmpNo());
		pstmt.execute();
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//직원 -  개인 정보 변경
	public void updateEmpInfo(EmpDto empDto) {
		String update = "update emp set empname = ? , empaddr = ?, emptel = ?, empemail = ? where empno = ? ";
		Connection conn = ConnectionHelper.getConnection("oracle");
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(update);
			pstmt.setString(1, empDto.getEmpName());
			pstmt.setString(2, empDto.getEmpAddr());
			pstmt.setString(3, empDto.getEmpTel());
			pstmt.setString(4, empDto.getEmpEmail());
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
		EmpDetailsDto dto =  null;
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
//				usr.setUsrimage(rs.getString("UsrimagePath"));
				
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

	// 관리자 - 전직원 조회 반복문 사용
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
			
			if(rs.next()) {
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
