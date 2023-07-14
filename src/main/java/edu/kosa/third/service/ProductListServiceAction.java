package edu.kosa.third.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kosa.third.action.Action;
import edu.kosa.third.action.ActionForward;
import edu.kosa.third.dao.ProductDao;
import edu.kosa.third.dto.ProductDto;

public class ProductListServiceAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		
		ProductDao dao = new ProductDao();
		ArrayList<ProductDto> list = dao.selectAll();
		
		request.setAttribute("list", list);
		forward.setPath("/WEB-INF/views/product/productList.jsp");
		
		return forward;
	}

}
