package edu.kosa.third.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kosa.third.action.Action;
import edu.kosa.third.action.ActionForward;
import edu.kosa.third.dao.ItemDao;
import edu.kosa.third.dto.ItemDto;

public class AddItemServiceAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);

		if(request.getParameter("itemName") == null) {
			forward.setPath("/WEB-INF/views/item/addItem.jsp");
			return forward;
		} else {
			String itemName = request.getParameter("itemName");
			int cost = Integer.parseInt(request.getParameter("cost"));
			int price = Integer.parseInt(request.getParameter("price"));
			int itemClsNo = Integer.parseInt(request.getParameter("itemClsNo"));
			
			ItemDao dao = new ItemDao();
			
			dao.insertItem(new ItemDto(itemName, cost, price, itemClsNo));
			
			request.removeAttribute("itemName");
			forward.setPath("itemList.do");
			return forward;
		}
	}
}