package edu.kosa.third.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kosa.third.action.Action;
import edu.kosa.third.action.ActionForward;
import edu.kosa.third.dao.ItemClsDao;
import edu.kosa.third.dao.ItemDao;
import edu.kosa.third.dao.ProductDao;
import edu.kosa.third.dto.ItemClsDto;
import edu.kosa.third.dto.ItemsDto;
import edu.kosa.third.dto.ProductManageDto;

public class CustomProductDetailServiceAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		
		int productNo = Integer.parseInt(request.getParameter("productNo"));
		
		ProductDao dao = new ProductDao();
		ItemDao itemDao = new ItemDao();
		ProductManageDto dto = dao.selectProductNo(productNo);
		ArrayList<ItemsDto> list = itemDao.selectAll();
		ItemClsDao clsDao = new ItemClsDao();
		ArrayList<ItemClsDto> clsList = clsDao.selectAll();
		
		request.setAttribute("dto", dto);
		request.setAttribute("list", list);
		request.setAttribute("clsList", clsList);
		
		forward.setPath("/WEB-INF/views/product/detailCustomProduct.jsp");
		
		return forward;
	}

}
