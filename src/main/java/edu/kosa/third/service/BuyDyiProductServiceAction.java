package edu.kosa.third.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kosa.third.action.Action;
import edu.kosa.third.action.ActionForward;
import edu.kosa.third.dao.ProductDao;

public class BuyDyiProductServiceAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);

		String[] values = request.getParameterValues("buyProductSelect");
		int totalPrice = Integer.parseInt(request.getParameter("totalPrice").replaceAll(",", "").split(" ")[0]);
		
		ProductDao dao = new ProductDao();
		dao.buyProduct(values, totalPrice);
		
		forward.setPath("/index.jsp");
		return forward;
	}

}
