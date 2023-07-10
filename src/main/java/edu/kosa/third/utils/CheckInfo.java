package edu.kosa.third.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CheckInfo {

    public static boolean PwdChk(String id, String pwd) throws SQLException, NoSuchAlgorithmException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        conn = ConnectionHelper.getConnection("oracle");
        String sql="select * from Usr where usrId = ?";

        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, id);
        ResultSet rs = pstmt.executeQuery();

        if(rs.next()) {

            MessageDigest md = MessageDigest.getInstance("SHA-512/256");
            md.update(pwd.getBytes());
            md.update(rs.getString("salt").getBytes());
            String hex = String.format("%064x", new BigInteger(1, md.digest()));

            if(hex.equals(rs.getString("pwd"))){
                return true;
            }
        }
        return false;
    }
}
