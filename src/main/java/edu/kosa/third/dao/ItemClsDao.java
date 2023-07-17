package edu.kosa.third.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import edu.kosa.third.dto.ItemClsDto;
import edu.kosa.third.utils.ConnectionHelper;

public class ItemClsDao {

	public ArrayList<ItemClsDto> selectAll() {
		String sql = "SELECT * FROM ITEMCLS";
		Connection conn = ConnectionHelper.getConnection("oracle");
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<ItemClsDto> list = new ArrayList<>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ItemClsDto dto = new ItemClsDto();
				
				dto.setItemClsNo(rs.getInt("itemClsNo"));
				dto.setItemClsName(rs.getString("itemClsName"));
				
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionHelper.close(rs);
			ConnectionHelper.close(pstmt);
			ConnectionHelper.close(conn);
		}
		
		return list;
	}

}
