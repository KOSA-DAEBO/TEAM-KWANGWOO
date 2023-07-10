package edu.kosa.third.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kosa.third.action.Action;
import edu.kosa.third.action.ActionForward;
import edu.kosa.third.dao.ItemDao;
import edu.kosa.third.dto.ItemDto;

public class UpdateItemServiceAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		
		int itemNo = Integer.parseInt(request.getParameter("itemNo"));
		String itemName = request.getParameter("itemName");
		int cost = Integer.parseInt(request.getParameter("cost"));
		int price = Integer.parseInt(request.getParameter("price"));
		int itemClsNo = Integer.parseInt(request.getParameter("itemClsNo"));
		
		ItemDao dao = new ItemDao();
		
		dao.updateItem(new ItemDto(itemNo, itemName, cost, price, itemClsNo));
		
		forward.setPath("itemList.do?listNo=2");
        return forward;
	}

}
