package edu.kosa.third.dao;

import edu.kosa.third.dto.CustomerDto;
import edu.kosa.third.dto.EmpDto;
import edu.kosa.third.utils.CheckInfo;
import edu.kosa.third.utils.ConnectionHelper;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class LoginDao {

    public CustomerDto customerChk(String id, String pwd) throws SQLException, NoSuchAlgorithmException {
        if (CheckInfo.PwdChk(id, pwd)) {
            Connection conn = null;
            PreparedStatement pstmt = null;
            ResultSet rs = null;
            CustomerDto customerDto = null;
            try {
                conn = ConnectionHelper.getConnection("oracle");
                String sql = "select * from Customer where usrId = ?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, id);
                rs = pstmt.executeQuery();
                rs.next();

                customerDto = new CustomerDto(rs.getString("CUSTOMERNO"),
                        rs.getString("USRID"),
                        rs.getString("CUSTOMEREMAIL"),
                        rs.getString("CUSTOMERTEL"),
                        rs.getString("CUSTOMERGENDER"),
                        rs.getDate("CUSTOMERBIRTH"),
                        rs.getString("CUSTOMERADDR"),
                        rs.getString("CUSTOMERNAME")
                );

            } catch (SQLException e) {
                e.printStackTrace();

            } finally {
                ConnectionHelper.close(rs);
                ConnectionHelper.close(pstmt);
                ConnectionHelper.close(conn);
            }
            return customerDto;
        }
        return null;

    }

    public EmpDto EmpChk(String id, String pwd) throws SQLException, NoSuchAlgorithmException {

        if (CheckInfo.PwdChk(id, pwd)) {
            Connection conn = null;
            PreparedStatement pstmt = null;
            ResultSet rs = null;
            EmpDto empDto = null;
            try {
                conn = ConnectionHelper.getConnection("oracle");
                String sql = "select * from Emp where usrId = ?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, id);
                rs = pstmt.executeQuery();
                rs.next();

                empDto = new EmpDto(rs.getInt("EMPNO"),
                        rs.getInt("ANNUALLEAVE"),
                        rs.getInt("DEPTNO"),
                        rs.getInt("POSNO"),
                        rs.getDate("EMPBIRTH"),
                        rs.getDate("HIREDATE"),
                        rs.getString("EMPNAME"),
                        rs.getString("EMPEMAIL"),
                        rs.getString("EMPTEL"),
                        rs.getString("EMPADDR"),
                        rs.getBoolean("EMPSTATUS"),
                        rs.getBoolean("ROLE"),
                        rs.getString("EMPGENDER")
                );

            } catch (SQLException e) {
                e.printStackTrace();

            } finally {
                ConnectionHelper.close(rs);
                ConnectionHelper.close(pstmt);
                ConnectionHelper.close(conn);
            }
            return empDto;

        }
        return null;

    }
}
