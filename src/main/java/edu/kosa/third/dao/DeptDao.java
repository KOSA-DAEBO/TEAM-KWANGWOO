package edu.kosa.third.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import edu.kosa.third.utils.ConnectionHelper;

public class DeptDao {
	public int insertDept(int deptNO, String deptName) {
		Connection conn = null;
		DataSource ds = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int result = 0;
		String insert = "insert into dept(deptno, deptname) values(?,?)";

		try {
			conn = ConnectionHelper.getConnection("oracle");
			pstmt = conn.prepareStatement(insert);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
