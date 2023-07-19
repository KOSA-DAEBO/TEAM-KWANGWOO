package edu.kosa.third.dao;

import edu.kosa.third.dto.EmpDto;
import edu.kosa.third.utils.ConnectionHelper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.sql.*;
import java.util.HashMap;

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
            String sql="SELECT TO_CHAR(starttime, 'HH24:MI:SS') AS \"startTime\" ,  TO_CHAR(endtime, 'HH24:MI:SS') AS \"endTime\" FROM att WHERE TO_CHAR(NOWDATE,'YYYYMMDD') = TO_CHAR(SYSDATE,'YYYYMMDD') and StartTime = (select Max(StartTime) from att) and empno = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, dto.getEmpNo());

            rs = pstmt.executeQuery();

            if(rs.next()){
                if(rs.getString("endTime") == null){ //퇴근안함
                    return new String[]{rs.getString("startTime"), "퇴근 전"};
                }else{
                    return new String[]{rs.getString("startTime"),rs.getString("endTime")};
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

    public JSONArray calendar(EmpDto dto) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        PreparedStatement pstmt2 = null;
        ResultSet rs = null;
        ResultSet rs2 = null;

        HashMap<String, String> hashMap = new HashMap<>();
        JSONObject jsonObject;
        JSONArray jsonArray = new JSONArray();

        try{
            conn = ConnectionHelper.getConnection("oracle");
            //출근
            String sql = "SELECT TO_CHAR(starttime, 'HH24:MI') || ' ~ ' || TO_CHAR(endtime, 'HH24:MI') AS \"title\", TO_CHAR(STARTTIME, 'yyyy-MM-dd') AS \"date\" FROM att WHERE empno = ? AND endtime IS NOT NULL";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, dto.getEmpNo());
            rs = pstmt.executeQuery();

            while(rs.next()){
                hashMap.put("title", rs.getString("title"));
                hashMap.put("start", rs.getString("date"));
                hashMap.put("end", rs.getString("date"));
                hashMap.put("color", "#50bcdf");
                jsonObject = new JSONObject(hashMap);
                jsonArray.add(jsonObject);

            }

            //휴가
            String sql2 = "SELECT TO_CHAR(leave.startday, 'yyyy-MM-dd') AS \"startday\", TO_CHAR(leave.endday, 'yyyy-MM-dd') AS \"endday\", leave.levstatus, leaveType.typename FROM leave JOIN leaveType ON leave.typeno = leaveType.typeno WHERE leave.levstatus = 1 AND leave.empno = ?";
            pstmt2 = conn.prepareStatement(sql2);
            pstmt2.setInt(1, dto.getEmpNo());
            rs2 = pstmt2.executeQuery();

            while(rs2.next()){
                hashMap.put("title", rs2.getString("typename"));
                hashMap.put("start", rs2.getString("startday"));
                hashMap.put("end", rs2.getString("endday"));
                hashMap.put("color", "#ef6c00");
                jsonObject = new JSONObject(hashMap);
                jsonArray.add(jsonObject);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionHelper.close(rs);
            ConnectionHelper.close(rs2);
            ConnectionHelper.close(pstmt);
            ConnectionHelper.close(pstmt2);
            ConnectionHelper.close(conn);
        }

        return jsonArray;
    }


    public JSONArray calendarAdmin(EmpDto dto) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        PreparedStatement pstmt2 = null;
        ResultSet rs = null;
        ResultSet rs2 = null;

        HashMap<String, String> hashMap = new HashMap<>();
        JSONObject jsonObject;
        JSONArray jsonArray = new JSONArray();

        try{
            conn = ConnectionHelper.getConnection("oracle");
            //출근
            String sql = "SELECT TO_CHAR(STARTTIME, 'YYYY-MM-DD') AS \"date\", COUNT(DISTINCT EMPNO) AS empCount " +
                    "FROM ATT " +
                    "WHERE TRUNC(STARTTIME) BETWEEN TRUNC(SYSDATE) - 1095 AND TRUNC(SYSDATE) " +
                    "GROUP BY TO_CHAR(STARTTIME, 'YYYY-MM-DD')";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while(rs.next()){
                hashMap.put("title", rs.getString("empCount")+"명 출근");
                hashMap.put("start", rs.getString("date"));
                hashMap.put("end", rs.getString("date"));
                hashMap.put("color", "#50bcdf");
                jsonObject = new JSONObject(hashMap);
                jsonArray.add(jsonObject);

            }

            //휴가
            String sql2 = "SELECT TO_CHAR(dt, 'YYYY-MM-DD') AS \"date\", COUNT(EMPNO) AS empCount " +
                    "FROM (" +
                    "  SELECT TRUNC(SYSDATE) - LEVEL + 1 AS dt" +
                    "  FROM dual" +
                    "  CONNECT BY  LEVEL <= ADD_MONTHS(TRUNC(SYSDATE), 3) - ADD_MONTHS(TRUNC(SYSDATE), -36) + 1" +
                    ") dates " +
                    "LEFT JOIN leave ON dt BETWEEN STARTDAY AND ENDDAY AND LEVSTATUS = 1 " +
                    "GROUP BY dt" +
                    " HAVING COUNT(EMPNO) > 0" +
                    " ORDER BY dt";
            pstmt2 = conn.prepareStatement(sql2);
            rs2 = pstmt2.executeQuery();

            while(rs2.next()){
                hashMap.put("title", rs2.getString("empCount")+"명 휴가");
                hashMap.put("start", rs2.getString("date"));
                hashMap.put("end", rs2.getString("date"));
                hashMap.put("color", "#ef6c00");
                jsonObject = new JSONObject(hashMap);
                jsonArray.add(jsonObject);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionHelper.close(rs);
            ConnectionHelper.close(rs2);
            ConnectionHelper.close(pstmt);
            ConnectionHelper.close(pstmt2);
            ConnectionHelper.close(conn);
        }

        return jsonArray;
    }
}
