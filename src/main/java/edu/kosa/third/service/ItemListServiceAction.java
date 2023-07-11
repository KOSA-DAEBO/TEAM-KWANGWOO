package edu.kosa.third.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kosa.third.action.Action;
import edu.kosa.third.action.ActionForward;
import edu.kosa.third.dao.ItemDao;
import edu.kosa.third.dto.ItemsDto;

public class ItemListServiceAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		String listNo = request.getParameter("listNo");
		
		ItemDao dao = new ItemDao();
		ArrayList<ItemsDto> list = dao.selectAll();
		
		
		request.setAttribute("list", list);
		forward.setRedirect(false);
		if(listNo != null && listNo.equals("2")) {
			forward.setPath("/WEB-INF/views/item/checkItem.jsp");
		} else {
			forward.setPath("/WEB-INF/views/item/itemList.jsp");
		}
		
		return forward;
	}

}
