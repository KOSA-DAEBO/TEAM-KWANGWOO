package edu.kosa.third.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import edu.kosa.third.dto.CustomerDto;
import edu.kosa.third.dto.EmpDto;
import edu.kosa.third.dto.UsrDto;
import edu.kosa.third.utils.ConnectionHelper;

public class UsrInfoDao {
	Connection conn = null;
	DataSource ds = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	// 소비자 - 소비자 확인 (전체조회 없음)
	public Map<String, Object> detailCustInfo() {
		String sql = "select u.usrid, c.customerName, c.customerEmail, c.customertel, "
				+ " c.customeraddr, c.customergender, c.customerBirth "
				+ " from customer c, usr u where u.usrid = c.usrid and c.usrid= ?";
		CustomerDto cto = new CustomerDto();
		UsrDto uto = new UsrDto();

		Map<String, Object> resultMap = new HashMap<>();
		try {
			conn = ConnectionHelper.getConnection("oracle");
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				cto = new CustomerDto();
				uto = new UsrDto();

				uto.setUsrId(rs.getString(1));
				cto.setCustomerName(rs.getString(2));
				cto.setCustomerEmail(rs.getString(3));
				cto.setCustomerTel(rs.getString(4));
				cto.setCustomerAddr(rs.getString(5));
				cto.setCustomerGender(rs.getString(6));
				cto.setCustomerBirth(rs.getDate(7));

				resultMap.put("CustomerDto", cto);
				resultMap.put("usrDto", uto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionHelper.close(rs);
			ConnectionHelper.close(pstmt);
			ConnectionHelper.close(conn);
		}
		return resultMap;
	}

	// 직원 - 직원 본인 정보 상세조회
//	public Map<String, Object> detailempInfo() {
//		String sql = "select e.empno, u.usrid, e.empName, e.empbirth ,e.empemail, e.emptel, e.empstatus, e.empgender, e.empaddr, e.hiredate, "
//				+ " d.deptname, p.posname "
//				+ " from emp e, dept d, pos p , usr u "
//				+ " where e.usrid = u.usrid and e.deptno = d.deptno and e.posno = p.posno and u.usrid = ?";
//		Map<String, Object> resultMap = new HashMap<>();
//		try {
//			conn = ConnectionHelper.getConnection("oracle");
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, "park");
//			rs = pstmt.executeQuery();
//			System.out.println("change");
//			if (rs.next()) {
//				EmpDto emp = new EmpDto();
//				PosDto pos = new PosDto();
//				UsrDto usr = new UsrDto();
//				DeptDto dept = new DeptDto();
//				emp.setEmpNo(rs.getInt(1));
//				usr.setUsrId(rs.getString(2));
//				emp.setEmpName(rs.getString(3));
//				emp.setEmpBirth(rs.getDate(4));
//				emp.setEmpEmail(rs.getString(5));
//				emp.setEmpTel(rs.getString(6));
//				emp.setEmpStatus(rs.getBoolean(7));
//				emp.setEmpGender(rs.getBoolean(8));
//				emp.setEmpAddr(rs.getString(9));
//				emp.setHiredate(rs.getDate(10));
//				dept.setDeptName(rs.getString(11));
//				pos.setPosName(rs.getString(12));
//
//				resultMap.put("etoDto", emp);
//				resultMap.put("posDto", pos);
//				resultMap.put("usrDto", usr);
//				resultMap.put("deptDto", dept);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			ConnectionHelper.close(rs);
//			ConnectionHelper.close(pstmt);
//			ConnectionHelper.close(conn);
//		}
//		return resultMap;
//	}

	// 전체 직원 조회 -- list호 바꿔서 나중에 반복가능하게 할 것
	
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
	// 정상작동
}
