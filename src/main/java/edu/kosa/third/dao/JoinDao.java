package edu.kosa.third.dao;

import edu.kosa.third.dto.CustomerDto;
import edu.kosa.third.dto.UsrDto;
import edu.kosa.third.utils.ConnectionHelper;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JoinDao {

    public void joinchk(UsrDto usrDto, CustomerDto customerDto){
        Connection conn = null;
        PreparedStatement pstmt = null;
        PreparedStatement pstmt2 = null;
        ResultSet rs = null; // 두개 만들어야함 user 부터 만들고 그다음에  customer
        try{
            conn = ConnectionHelper.getConnection("oracle");
//            String sql="insert into usr(usrId,pwd,hex) values (?,?,"+"00000000"+");"; // hex 값은이후 추가
            String sql="insert into usr(usrId,pwd,salt) values (?,?,?)";
            pstmt = conn.prepareStatement(sql);

            MessageDigest md = MessageDigest.getInstance("SHA-512/256");
            md.update(usrDto.getPwd().getBytes());
            md.update(usrDto.getSalt().getBytes());
            String hex = String.format("%064x", new BigInteger(1, md.digest()));

            pstmt.setString(1, usrDto.getUsrid());
            pstmt.setString(2, hex);
            pstmt.setString(3, usrDto.getSalt());

            pstmt.execute();


            String sql2 = "insert into customer(usrId,customerEmail,customerTel,customerGender,customerBirth,customerAddr,customerName) values(?,?,?,?,?,?,?)"; // hex 값은이후 추가
            pstmt2 = conn.prepareStatement(sql2);

            pstmt2.setString(1, usrDto.getUsrid());
            pstmt2.setString(2, customerDto.getCustomeremail());
            pstmt2.setString(3, customerDto.getCustomertel());
            pstmt2.setString(4, customerDto.getCustomergender());
            pstmt2.setDate(5, customerDto.getCustomerbirth());
            pstmt2.setString(6, customerDto.getCustomeraddr());
            pstmt2.setString(7, customerDto.getCustomername());

            pstmt2.execute();


        } catch (SQLException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }finally {
            ConnectionHelper.close(pstmt);
            ConnectionHelper.close(conn);
        }



    }

}
