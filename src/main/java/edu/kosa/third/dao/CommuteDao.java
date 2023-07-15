package edu.kosa.third.dao;

import edu.kosa.third.dto.EmpDto;
import edu.kosa.third.utils.ConnectionHelper;

import java.sql.*;
import java.text.SimpleDateFormat;

public class CommuteDao {

    public void goCommute(EmpDto empDto) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        PreparedStatement pstmt2 = null;

        try{
            conn = ConnectionHelper.getConnection("oracle");
            Date now = new Date(System.currentTimeMillis());
            String sql="insert into att(nowdate,starttime,endtime,attstatus,empno,usrid) values (?,current_timestamp,null,'출근',?,?)";
            pstmt = conn.prepareStatement(sql);

            pstmt.setDate(1, now);
            pstmt.setInt(2, empDto.getEmpNo());
            pstmt.setString(3, empDto.getUsrId());

            pstmt.execute();

            String sql2 ="update emp set empstatus = 1 where empno = ?";
            pstmt2 = conn.prepareStatement(sql2);

            pstmt2.setInt(1, empDto.getEmpNo());

            pstmt2.execute();

        } catch (SQLException e) {
            e.printStackTrace();

        }finally {
            ConnectionHelper.close(pstmt);
            ConnectionHelper.close(pstmt2);
            ConnectionHelper.close(conn);
        }

    }

    public void leaveCommute(EmpDto empDto) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        PreparedStatement pstmt2 = null;

        try{
            conn = ConnectionHelper.getConnection("oracle");
            Date now = new Date(System.currentTimeMillis());
            String sql="update att set endtime = current_timeStamp where StartTime = (select Max(StartTime) from att) and ATTSTATUS='출근' and empno = ?";
            pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, empDto.getEmpNo());

            pstmt.execute();

            String sql2 ="update emp set empstatus = 1 where empno = ?";
            pstmt2 = conn.prepareStatement(sql2);

            pstmt2.setInt(1, empDto.getEmpNo());

            pstmt2.execute();
        } catch (SQLException e) {
            e.printStackTrace();

        }finally {
            ConnectionHelper.close(pstmt2);
            ConnectionHelper.close(pstmt);
            ConnectionHelper.close(conn);
        }
    }


    public String[] commuteTimeChk(EmpDto dto) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try{
            conn = ConnectionHelper.getConnection("oracle");
            String sql="SELECT * FROM att WHERE TO_CHAR(NOWDATE,'YYYYMMDD') = TO_CHAR(SYSDATE,'YYYYMMDD') and StartTime = (select Max(StartTime) from att) and empno = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, dto.getEmpNo());

            rs = pstmt.executeQuery();

            if(rs.next()){
                if(rs.getTimestamp("ENDTIME") == null){ //퇴근안함
                    String startTime = new SimpleDateFormat("HH:mm:ss").format(rs.getTimestamp("startTime"));
                    return new String[]{startTime, "퇴근 전"};
                }else{
                    String startTime = new SimpleDateFormat("HH:mm:ss").format(rs.getTimestamp("startTime"));
                    String endTime = new SimpleDateFormat("HH:mm:ss").format(rs.getTimestamp("endTime"));
                    return new String[]{startTime,endTime};
                }
            }else{
                return new String[]{"출근 전", "퇴근 전"};
            }

        } catch (SQLException e) {
            e.printStackTrace();

        }finally {
            ConnectionHelper.close(rs);
            ConnectionHelper.close(pstmt);
            ConnectionHelper.close(conn);
        }

        return null;
    }
}
