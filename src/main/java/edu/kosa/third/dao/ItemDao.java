package edu.kosa.third.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import edu.kosa.third.dto.ItemClsDto;
import edu.kosa.third.dto.ItemDto;
import edu.kosa.third.utils.ConnectionHelper;

public class ItemDao {

	public List<ItemDto> selectAll() {
		String sql = "SELECT I.*, IC.ITEMCLSNAME FROM ITEM I JOIN ITEMCLS IC ON I.ITEMCLSNO = IC.ITEMCLSNO";
		ArrayList<ItemDto> list = new ArrayList<>();
		Connection conn = ConnectionHelper.getConnection("oracle");
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ItemDto dto = new ItemDto();
				
				dto.setItemNo(rs.getInt("itemNo"));
				dto.setItemName(rs.getString("itemName"));
				dto.setCost(rs.getInt("cost"));
				dto.setPrice(rs.getInt("price"));
				dto.setStock(rs.getInt("stock"));
				dto.setItemClsNo(rs.getInt("itemclsno"));
				
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
