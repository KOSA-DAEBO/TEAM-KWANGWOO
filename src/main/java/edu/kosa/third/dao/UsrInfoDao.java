package edu.kosa.third.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import edu.kosa.third.dto.CustomerDto;
import edu.kosa.third.dto.DeptDto;
import edu.kosa.third.dto.EmpDto;
import edu.kosa.third.dto.EmpDetailsDto;
import edu.kosa.third.dto.PosDto;
import edu.kosa.third.utils.ConnectionHelper;

public class UsrInfoDao {

	
	// 소비자 확인 (전체조회 없음)
	public ArrayList<CustomerDto> detailCustInfo() {
		String sql = "select * from customer where usrid=?";
		ArrayList<CustomerDto> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = ConnectionHelper.getConnection("oracle");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "asd");//나중에 로그인 기능 연동 후 usrId 로 바꿀것
			rs = pstmt.executeQuery();
			while (rs.next()) {
				CustomerDto customdto = new CustomerDto();
				customdto.setCustomerNo(rs.getString(1));
				customdto.setUsrId(rs.getString(2));
				customdto.setCustomerEmail(rs.getString(3));
				customdto.setCustomerTel(rs.getString(4));
				customdto.setCustomerGender(rs.getString(5));
				customdto.setCustomerBirth(rs.getDate(6));
				customdto.setCustomerAddr(rs.getString(7));
				customdto.setCustomerName(rs.getString(8));

				list.add(customdto);

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

	// 직원 - 직원 본인 정보 상세조회
	public EmpDetailsDto detailempInfo() {
		String sql = "select e.empno, e.usrid, e.empname, empbirth, e.empemail, e.empstatus,"
				+ "  e.emptel, e.empgender, e.empaddr, e.hiredate, " + " e.annualleave, d.deptname, p.posname"
				+ "				 from emp e, pos p, dept d where e.deptNo = d.deptNo and e.posNo = p.posNo and usrId = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		EmpDetailsDto dto = null;
		try {
			conn = ConnectionHelper.getConnection("oracle");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "asdsaad2114");//나중에 로그인 기능 연동 후 usrId 로 바꿀것
			rs = pstmt.executeQuery();
				
			
				EmpDto emp = new EmpDto();
				PosDto pos = new PosDto();
				DeptDto dept = new DeptDto();
					
				while(rs.next()) {
					
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
					dto = new EmpDetailsDto(emp, pos, dept);
				}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionHelper.close(rs);
			ConnectionHelper.close(pstmt);
			ConnectionHelper.close(conn);
		}
		System.out.println("usrdao"+dto.getDeptdto().getDeptName());
		System.out.println("empInfo"+dto.getPosdto().getPosName());
		System.out.println("empInfo"+dto.getEmpdto().getEmpName());
		return dto;
	}

	// 전체 직원 조회
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
