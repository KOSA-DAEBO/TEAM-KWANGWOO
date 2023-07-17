package edu.kosa.third.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kosa.third.action.Action;
import edu.kosa.third.action.ActionForward;
import edu.kosa.third.dao.ProductDao;
import edu.kosa.third.dto.ProductManageDto;

public class ProductInfoServiceAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		
		int productNo = Integer.parseInt(request.getParameter("productNo"));
		
		ProductDao dao = new ProductDao();
		
		ProductManageDto dto = dao.selectProductNo(productNo);
		request.setAttribute("dto", dto);
		forward.setPath("/WEB-INF/views/product/detailProduct.jsp");
		
		return forward;
	}

}
