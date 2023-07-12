package edu.kosa.third.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import edu.kosa.third.dto.ProductDto;
import edu.kosa.third.utils.ConnectionHelper;

public class ProductDao {

	public ArrayList<ProductDto> selectAll() {
		String sql = "SELECT P.productNo, P.productName, SUM(I.price) total_price FROM Product P JOIN PIMapping PI ON P.productNo = PI.productNo JOIN Item I ON PI.itemNo = I.itemNo GROUP BY P.productNo, P.productName";
		Connection conn = ConnectionHelper.getConnection("oracle");
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionHelper.close(pstmt);
			ConnectionHelper.close(conn);
		}
		
		return null;
	}

}
