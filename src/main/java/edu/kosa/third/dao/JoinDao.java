package edu.kosa.third.dao;

import edu.kosa.third.dto.CustomerDto;
import edu.kosa.third.dto.EmpDto;
import edu.kosa.third.dto.UsrDto;
import edu.kosa.third.utils.ConnectionHelper;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JoinDao {

    public void joinCustomerChk(UsrDto usrDto, CustomerDto customerDto){
        Connection conn = null;
        PreparedStatement pstmt = null;
        PreparedStatement pstmt2 = null;
        try{
            conn = ConnectionHelper.getConnection("oracle");
            String sql="insert into usr(usrId,pwd,salt) values (?,?,?)";
            pstmt = conn.prepareStatement(sql);

            MessageDigest md = MessageDigest.getInstance("SHA-512/256");
            md.update(usrDto.getPwd().getBytes());
            md.update(usrDto.getSalt().getBytes());
            String hex = String.format("%064x", new BigInteger(1, md.digest()));

            pstmt.setString(1, usrDto.getUsrId());
            pstmt.setString(2, hex);
            pstmt.setString(3, usrDto.getSalt());

            pstmt.execute();

            String sql2 = "insert into customer(usrId,customerEmail,customerTel,customerGender,customerBirth,customerAddr,customerName) values(?,?,?,?,?,?,?)"; // hex 값은이후 추가
            pstmt2 = conn.prepareStatement(sql2);

            pstmt2.setString(1, usrDto.getUsrId());
            pstmt2.setString(2, customerDto.getCustomerEmail());
            pstmt2.setString(3, customerDto.getCustomerTel());
            pstmt2.setString(4, customerDto.getCustomerGender());
            pstmt2.setDate(5, customerDto.getCustomerBirth());
            pstmt2.setString(6, customerDto.getCustomerAddr());
            pstmt2.setString(7, customerDto.getCustomerName());

            pstmt2.execute();

        } catch (SQLException | NoSuchAlgorithmException e) {
            e.printStackTrace();

        }finally {
            ConnectionHelper.close(pstmt);
            ConnectionHelper.close(conn);
        }

    }

    public void joinEmpChk(UsrDto usrDto, EmpDto empDto){
        Connection conn = null;
        PreparedStatement pstmt = null;
        PreparedStatement pstmt2 = null;
        try{
            conn = ConnectionHelper.getConnection("oracle");
            String sql="insert into usr(usrId,pwd,salt) values (?,?,?)";
            pstmt = conn.prepareStatement(sql);

            MessageDigest md = MessageDigest.getInstance("SHA-512/256");
            md.update(usrDto.getPwd().getBytes());
            md.update(usrDto.getSalt().getBytes());
            String hex = String.format("%064x", new BigInteger(1, md.digest()));

            pstmt.setString(1, usrDto.getUsrId());
            pstmt.setString(2, hex);
            pstmt.setString(3, usrDto.getSalt());
            pstmt.execute();

            String sql2 = "insert into emp(usrid,empname,empbirth,empemail,emptel,empgender,empaddr,hiredate,deptno,posno) values(?,?,?,?,?,?,?,?,?,?)";
            pstmt2 = conn.prepareStatement(sql2);

            pstmt2.setString(1, usrDto.getUsrId());
            pstmt2.setString(2, empDto.getEmpName());
            pstmt2.setDate(3, empDto.getEmpBirth());
            pstmt2.setString(4, empDto.getEmpEmail());
            pstmt2.setString(5, empDto.getEmpTel());
            pstmt2.setString(6, empDto.isEmpGender());
            pstmt2.setString(7, empDto.getEmpAddr());
            pstmt2.setDate(8, empDto.getHireDate());
            pstmt2.setInt(9, empDto.getDeptNo());
            pstmt2.setInt(10, empDto.getPosNo());

            pstmt2.execute();

        } catch (SQLException | NoSuchAlgorithmException e) {
            e.printStackTrace();

        }finally {
            ConnectionHelper.close(pstmt);
            ConnectionHelper.close(conn);
        }

    }

}
