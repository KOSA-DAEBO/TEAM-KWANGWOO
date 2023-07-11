package edu.kosa.third.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import edu.kosa.third.dto.CustomerDto;
import edu.kosa.third.dto.DeptDto;
import edu.kosa.third.dto.EmpDto;
import edu.kosa.third.dto.EmpsDetailDto;
import edu.kosa.third.dto.PosDto;
import edu.kosa.third.utils.ConnectionHelper;

public class UsrInfoDao {
	Connection conn = null;
	DataSource ds = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	// 소비자 - 소비자 확인 (전체조회 없음)
	public CustomerDto detailCustInfo(String usrId) {
		String sql = "select * from customer where usrid = ?";
		CustomerDto cto = null;
		try {
			conn = ConnectionHelper.getConnection("oracle");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "usrId");
			rs = pstmt.executeQuery();
			if (rs.next()) {
				cto = new CustomerDto();

				cto.setCustomerNo(rs.getString(1));
				cto.setUsrId(rs.getString(2));
				cto.setCustomerName(rs.getString(3));
				cto.setCustomerEmail(rs.getString(4));
				cto.setCustomerTel(rs.getString(5));
				cto.setCustomerAddr(rs.getString(6));
				cto.setCustomerGender(rs.getString(7));
				cto.setCustomerBirth(rs.getDate(8));

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionHelper.close(rs);
			ConnectionHelper.close(pstmt);
			ConnectionHelper.close(conn);
		}
		return cto;
	}

	// 직원 - 직원 본인 정보 상세조회
	public ArrayList<EmpsDetailDto> detailempInfo() {
		String sql = "select e.empno, e.usrid, e.empname, empbirth, e.empemail, e.empstatus,"
				+ "  e.emptel, e.empgender, e.empaddr, e.hiredate, "
				+ " e.annualleave, d.deptname, p.posname"
				+ "				 from emp e, pos p, dept d where e.deptNo = d.deptNo and e.posNo = p.posNo and usrId=?";
		ArrayList<EmpsDetailDto> list = new ArrayList<>();
		try {
			conn = ConnectionHelper.getConnection("oracle");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "asdsaad2114");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				EmpDto emp = new EmpDto();
				PosDto pos = new PosDto();
				DeptDto dept = new DeptDto();

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

				EmpsDetailDto dto = new EmpsDetailDto(emp, pos, dept);
				list.add(dto);
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

	// 전체 직원 조회
	public List<EmpDto> totalEmpInfo() {
		String select = "select usrid, empno, empname, hiredate from emp";
		List<EmpDto> list = null;
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
