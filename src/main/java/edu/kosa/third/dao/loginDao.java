package edu.kosa.third.dao;

import edu.kosa.third.dto.CustomerDto;
import edu.kosa.third.dto.EmpDto;
import edu.kosa.third.dto.UsrDto;
import edu.kosa.third.utils.ConnectionHelper;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;

public class loginDao {

    public CustomerDto customerChk(String id, String pwd) throws SQLException, NoSuchAlgorithmException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        conn = ConnectionHelper.getConnection("oracle");
        String sql="select * from Usr where usrId = ?";

        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, id);
        ResultSet rs = pstmt.executeQuery();

        UsrDto usrDto = new UsrDto();

        if(rs.next()){

            MessageDigest md = MessageDigest.getInstance("SHA-512/256");
            md.update(pwd.getBytes());
            md.update(rs.getString("salt").getBytes());
            String hex = String.format("%064x", new BigInteger(1, md.digest()));

            if(hex.equals(rs.getString("pwd"))){
                String sql2= "select * from Customer where usrId = ?";
                PreparedStatement pstmt2 = conn.prepareStatement(sql2);
                pstmt2.setString(1, id);
                ResultSet rs2 = pstmt2.executeQuery();
                rs2.next();

                CustomerDto customerDto = new CustomerDto(rs2.getString("CUSTOMERNO"),
                        rs2.getString("USRID"),
                        rs2.getString("CUSTOMEREMAIL"),
                        rs2.getString("CUSTOMERTEL"),
                        rs2.getString("CUSTOMERGENDER"),
                        rs2.getDate("CUSTOMERBIRTH"),
                        rs2.getString("CUSTOMERADDR"),
                        rs2.getString("CUSTOMERNAME")
                );

                return customerDto;
            }
        }

        return null;

    }

    public EmpDto EmpChk(String id, String pwd) throws SQLException, NoSuchAlgorithmException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        conn = ConnectionHelper.getConnection("oracle");
        String sql="select * from Usr where usrId = ?";

        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, id);
        ResultSet rs = pstmt.executeQuery();

        UsrDto usrDto = new UsrDto();

        if(rs.next()){

            MessageDigest md = MessageDigest.getInstance("SHA-512/256");
            md.update(pwd.getBytes());
            md.update(rs.getString("salt").getBytes());
            String hex = String.format("%064x", new BigInteger(1, md.digest()));

            if(hex.equals(rs.getString("pwd"))){
                String sql2= "select * from Emp where usrId = ?";
                PreparedStatement pstmt2 = conn.prepareStatement(sql2);
                pstmt2.setString(1, id);
                ResultSet rs2 = pstmt2.executeQuery();
                rs2.next();

                EmpDto empDto = new EmpDto(rs2.getInt("EMPNO"),
                        rs2.getInt("ANNUALLEAVE"),
                        rs2.getInt("DEPTNO"),
                        rs2.getInt("POSNO"),
                        rs2.getDate("EMPBIRTH"),
                        rs2.getDate("HIREDATE"),
                        rs2.getString("EMPNAME"),
                        rs2.getString("EMPEMAIL"),
                        rs2.getString("EMPTEL"),
                        rs2.getString("EMPADDR"),
                        rs2.getBoolean("EMPSTATUS"),
                        rs2.getBoolean("ROLE"),
                        rs2.getString("EMPGENDER")
                );

                return empDto;
            }
        }


        return null;
    }
}
