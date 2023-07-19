package edu.kosa.third.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.kosa.third.dto.ItemClsDto;
import edu.kosa.third.dto.ItemDto;
import edu.kosa.third.dto.ItemsDto;
import edu.kosa.third.dto.PIMappingDto;
import edu.kosa.third.dto.ProductDto;
import edu.kosa.third.dto.ProductManageDto;
import edu.kosa.third.utils.ConnectionHelper;

public class ProductDao {

	public ArrayList<ProductDto> selectAll() {
		String sql = "SELECT P.PRODUCTNO, P.PRODUCTNAME, P.THUMBNAILPATH, SUM(I.PRICE) TOTAL_PRICE FROM PRODUCT P JOIN PIMAPPING PI ON P.PRODUCTNO = PI.PRODUCTNO JOIN ITEM I ON PI.ITEMNO = I.ITEMNO GROUP BY P.PRODUCTNO, P.PRODUCTNAME, P.THUMBNAILPATH";
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
				dto.setThumbnailPath(rs.getString(3));
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

	public ProductManageDto selectProductNo(int productNo) {
		String sql;
		Connection conn = ConnectionHelper.getConnection("oracle");
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ProductManageDto dto = null;
		
		try {
			sql = "SELECT * FROM PRODUCT WHERE PRODUCTNO = ?";
			
			ProductDto pDto = new ProductDto();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, productNo);
			rs = pstmt.executeQuery();
			rs.next();
			pDto.setProductNo(rs.getInt("productNo"));
			pDto.setProductName(rs.getString("productName"));
			pDto.setImagePath(rs.getString("imagePath"));
			
			sql = "SELECT P.*, I.*, IC.itemClsName FROM PIMapping P JOIN Item I ON P.itemNo = I.itemNo JOIN ItemCls IC ON I.itemClsNo = IC.itemClsNo WHERE P.productNo = ?";
			pstmt.clearParameters();
			
			List<PIMappingDto> pimDtoList = new ArrayList<>();
			List<ItemsDto> itemsDtoList = new ArrayList<>();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, productNo);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				PIMappingDto pimDto = new PIMappingDto();
				ItemDto itemDto = new ItemDto();
				ItemClsDto itemClsDto = new ItemClsDto();
				
				pimDto.setMappingNo(rs.getInt("mappingNo"));
				pimDto.setProductNo(rs.getInt("productNo"));
				pimDto.setItemNo(rs.getInt("itemNo"));
				
				itemDto.setItemNo(rs.getInt("itemNo"));
				itemDto.setItemName(rs.getString("itemName"));
				itemDto.setCost(rs.getInt("cost"));
				itemDto.setPrice(rs.getInt("price"));
				itemDto.setStock(rs.getInt("stock"));
				itemDto.setItemClsNo(rs.getInt("itemClsNo"));
				
				itemClsDto.setItemClsName(rs.getString("itemClsName"));
				
				ItemsDto itemsDto = new ItemsDto(itemDto, itemClsDto);
				pimDtoList.add(pimDto);
				itemsDtoList.add(itemsDto);
			}
			
			dto = new ProductManageDto(pDto, pimDtoList, itemsDtoList);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionHelper.close(rs);
			ConnectionHelper.close(pstmt);
			ConnectionHelper.close(conn);
		}
		
		return dto;
	}

	public int insertProduct(ProductDto productDto) {
		String sql;
		Connection conn = ConnectionHelper.getConnection("oracle");
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int productNo = -1;
		
		try {
			sql = "INSERT INTO PRODUCT(PRODUCTNAME, IMAGEPATH, THUMBNAILPATH) VALUES (?, ?, ?)";
			pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, productDto.getProductName());
			pstmt.setString(2, productDto.getImagePath());
			pstmt.setString(3, productDto.getThumbnailPath());
			pstmt.executeUpdate();
			
			pstmt.clearParameters();
			
			sql = "SELECT MAX(productNo) FROM PRODUCT";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				productNo = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionHelper.close(rs);
			ConnectionHelper.close(pstmt);
			ConnectionHelper.close(conn);
		}
		
		return productNo;
	}

	public void insertPIMapping(int productNo, String[] values) {
		String sql = "INSERT INTO PIMAPPING(PRODUCTNO, ITEMNO) VALUES (?, ?)";
		
		Connection conn = ConnectionHelper.getConnection("oracle");
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			for (int i = 0; i < values.length; i++) {
				pstmt.setInt(1, productNo);
				pstmt.setInt(2, Integer.parseInt(values[i]));
				pstmt.executeUpdate();
				pstmt.clearParameters();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionHelper.close(pstmt);
			ConnectionHelper.close(conn);
		}
	}

	public void deleteProduct(int productNo) {
		String sql;
		
		Connection conn = ConnectionHelper.getConnection("oracle");
		PreparedStatement pstmt = null;
		
		try {
			sql = "DELETE FROM PIMAPPING WHERE PRODUCTNO = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, productNo);
			pstmt.executeUpdate();
			pstmt.clearParameters();
			
			sql = "DELETE FROM PRODUCT WHERE PRODUCTNO = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, productNo);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionHelper.close(pstmt);
			ConnectionHelper.close(conn);
		}
	}

	public ProductDto selectProduct(int productNo) {
		String sql = "SELECT * FROM PRODUCT WHERE PRODUCTNO = ?";
		
		Connection conn = ConnectionHelper.getConnection("oracle");
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ProductDto dto = new ProductDto();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, productNo);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto.setProductNo(productNo);
				dto.setProductName(rs.getString("productName"));
				dto.setImagePath(rs.getString("imagePath"));
				dto.setThumbnailPath(rs.getString("thumbnailPath"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionHelper.close(rs);
			ConnectionHelper.close(pstmt);
			ConnectionHelper.close(conn);
		}
		
		return dto;
	}

	public void updateProduct(ProductDto productDto) {
		String sql = "UPDATE PRODUCT SET PRODUCTNAME = ?, IMAGEPATH = ?, THUMBNAILPATH = ? WHERE PRODUCTNO = ?";
		Connection conn = ConnectionHelper.getConnection("oracle");
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, productDto.getProductName());
			pstmt.setString(2, productDto.getImagePath());
			pstmt.setString(3, productDto.getThumbnailPath());
			pstmt.setInt(4, productDto.getProductNo());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionHelper.close(pstmt);
			ConnectionHelper.close(conn);
		}
	}

	public void updatePIMapping(ArrayList<PIMappingDto> dtos, String[] values) {
		String sql = "UPDATE PIMAPPING SET ITEMNO = ? WHERE MAPPINGNO = ?";
		Connection conn = ConnectionHelper.getConnection("oracle");
		PreparedStatement pstmt = null;
		
		try {
			for (int i = 0; i < values.length; i++) {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, Integer.parseInt(values[i]));
				pstmt.setInt(2, dtos.get(i).getMappingNo());
				pstmt.executeUpdate();
				pstmt.clearParameters();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionHelper.close(pstmt);
			ConnectionHelper.close(conn);
		}
	}

	public ArrayList<PIMappingDto> getMapping(int productNo) {
		String sql = "SELECT MAPPINGNO FROM PIMAPPING WHERE PRODUCTNO = ?";
		Connection conn = ConnectionHelper.getConnection("oracle");
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<PIMappingDto> list = new ArrayList<>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, productNo);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				PIMappingDto dto = new PIMappingDto();
				dto.setMappingNo(rs.getInt("mappingNo"));
				
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

	public void buyProduct(String[] itemValue, int itemPrice) {
		String sql = "UPDATE ITEM SET STOCK = STOCK - 1 WHERE ITEMNO = ?";
		Connection conn = ConnectionHelper.getConnection("oracle");
		PreparedStatement pstmt = null;
		try {
			for (int i = 0; i < itemValue.length; i++) {
				int itemNo = Integer.parseInt(itemValue[i]);
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, itemNo);
				pstmt.executeUpdate();
				pstmt.clearParameters();
			}
			
			sql = "INSERT INTO Money (profit, cost, tAmount, cause) VALUES (?, 0, (SELECT tAmount + ? FROM Money WHERE mNo = (SELECT MAX(mNo) FROM Money)), '제품 판매')";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, itemPrice);
			pstmt.setInt(2, itemPrice);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionHelper.close(pstmt);
			ConnectionHelper.close(conn);
		}
	}
}
