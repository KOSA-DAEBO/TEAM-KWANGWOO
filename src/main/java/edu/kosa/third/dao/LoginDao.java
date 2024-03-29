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

                customerDto = new CustomerDto(rs.getInt("CUSTOMERNO"),
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
        Connection conn = null;
        PreparedStatement pstmt2 = null;
        ResultSet rs2 = null;
        conn = ConnectionHelper.getConnection("oracle");
        String sql2 = "select status from USR where usrId = ?";
        pstmt2 = conn.prepareStatement(sql2);
        pstmt2.setString(1, id);
        rs2 = pstmt2.executeQuery();
        if (rs2.next()) {
            String withdrawalChk = rs2.getString("STATUS");
            if (withdrawalChk.equals("0")) {
                if (CheckInfo.PwdChk(id, pwd)) {
                    PreparedStatement pstmt = null;
                    ResultSet rs = null;
                    EmpDto empDto = null;
                    try {
                        String sql = "select * from Emp where usrId = ?";
                        pstmt = conn.prepareStatement(sql);
                        pstmt.setString(1, id);
                        rs = pstmt.executeQuery();
                        rs.next();

                        empDto = new EmpDto(rs.getInt("EMPNO"),
                                rs.getInt("ANNUALLEAVE"),
                                rs.getInt("DEPTNO"),
                                rs.getInt("POSNO"),
                                rs.getInt("SALARY"),
                                rs.getDate("EMPBIRTH"),
                                rs.getDate("HIREDATE"),
                                rs.getDate("DEPARTUREDATE"),
                                rs.getString("USRID"),
                                rs.getString("EMPNAME"),
                                rs.getString("EMPEMAIL"),
                                rs.getString("EMPTEL"),
                                rs.getString("EMPADDR"),
                                rs.getString("EMPGENDER"),
                                rs.getBoolean("EMPSTATUS"),
                                rs.getBoolean("ROLE"),
                                rs.getString("IMAGEPATH")
                        );

                    } catch (SQLException e) {
                        e.printStackTrace();

                    } finally {
                        ConnectionHelper.close(rs);
                        ConnectionHelper.close(pstmt);
                        ConnectionHelper.close(rs2);
                        ConnectionHelper.close(pstmt2);
                        ConnectionHelper.close(conn);
                    }
                    return empDto;
                }
            }
        }
        ConnectionHelper.close(rs2);
        ConnectionHelper.close(pstmt2);
        ConnectionHelper.close(conn);
        return null;

    }
}