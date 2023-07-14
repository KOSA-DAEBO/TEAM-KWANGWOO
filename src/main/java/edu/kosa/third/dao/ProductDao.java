package edu.kosa.third.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import edu.kosa.third.dto.ProductDto;
import edu.kosa.third.utils.ConnectionHelper;

public class ProductDao {

	public ArrayList<ProductDto> selectAll() {
		String sql = "SELECT P.PRODUCTNO, P.PRODUCTNAME, p.imagepath, SUM(I.PRICE) TOTAL_PRICE FROM PRODUCT P JOIN PIMAPPING PI ON P.PRODUCTNO = PI.PRODUCTNO JOIN ITEM I ON PI.ITEMNO = I.ITEMNO GROUP BY P.PRODUCTNO, P.PRODUCTNAME, p.imagepath";
		Connection conn = ConnectionHelper.getConnection("oracle");
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<ProductDto> list = new ArrayList<>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ProductDto dto = new ProductDto();
				
				dto.setProductNo(rs.getInt(1));
				dto.setProductName(rs.getString(2));
				dto.setImagePath(rs.getString(3));
				dto.setTotalPrice(rs.getInt(4));
				
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionHelper.close(pstmt);
			ConnectionHelper.close(conn);
		}
		
		return list;
	}

}
