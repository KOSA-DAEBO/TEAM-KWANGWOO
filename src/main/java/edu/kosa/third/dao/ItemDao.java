package edu.kosa.third.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import edu.kosa.third.dto.ItemClsDto;
import edu.kosa.third.dto.ItemDto;
import edu.kosa.third.dto.ItemsDto;
import edu.kosa.third.utils.ConnectionHelper;

public class ItemDao {

	public ArrayList<ItemsDto> selectAll() {
		String sql = "SELECT I.*, IC.ITEMCLSNAME FROM ITEM I JOIN ITEMCLS IC ON I.ITEMCLSNO = IC.ITEMCLSNO";
		ArrayList<ItemsDto> list = new ArrayList<>();
		Connection conn = ConnectionHelper.getConnection("oracle");
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ItemDto dto = new ItemDto();
				ItemClsDto cDto = new ItemClsDto();
				
				
				dto.setItemNo(rs.getInt("itemNo"));
				dto.setItemName(rs.getString("itemName"));
				dto.setCost(rs.getInt("cost"));
				dto.setPrice(rs.getInt("price"));
				dto.setStock(rs.getInt("stock"));
				dto.setItemClsNo(rs.getInt("itemclsno"));
				cDto.setItemClsName(rs.getString("itemClsName"));
				
				ItemsDto dtos = new ItemsDto(dto, cDto);
				
				list.add(dtos);
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

	public void insertItem(ItemDto itemDto) {
		String sql = "insert into item(itemname, cost, price, stock, itemclsno) VALUES (?, ?, ?, 0, ?)";
		Connection conn = ConnectionHelper.getConnection("oracle");
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, itemDto.getItemName());
			pstmt.setInt(2, itemDto.getCost());
			pstmt.setInt(3, itemDto.getPrice());
			pstmt.setInt(4, itemDto.getItemClsNo());
			
			pstmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionHelper.close(pstmt);
			ConnectionHelper.close(conn);
		}
	}
}
