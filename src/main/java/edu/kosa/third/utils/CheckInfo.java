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
        ResultSet rs = null;
        try {
            conn = ConnectionHelper.getConnection("oracle");
            String sql = "select * from Usr where usrId = ?";

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();

            if (rs.next()) {

                MessageDigest md = MessageDigest.getInstance("SHA-512/256");
                md.update(pwd.getBytes());
                md.update(rs.getString("salt").getBytes());
                String hex = String.format("%064x", new BigInteger(1, md.digest()));

                if (hex.equals(rs.getString("pwd"))) {
                    return true;
                }
            }

        } catch (SQLException | NoSuchAlgorithmException e) {
            e.printStackTrace();

        } finally {
            ConnectionHelper.close(rs);
            ConnectionHelper.close(pstmt);
            ConnectionHelper.close(conn);
        }
        return false;
    }
}
