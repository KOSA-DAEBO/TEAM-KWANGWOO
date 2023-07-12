package edu.kosa.third.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kosa.third.action.Action;
import edu.kosa.third.action.ActionForward;
import edu.kosa.third.dao.ItemDao;

public class DeleteItemServiceAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		int itemNo = Integer.parseInt(request.getParameter("itemNo"));
		
		ItemDao dao = new ItemDao();
		dao.deleteItem(itemNo);
		
		forward.setPath("itemList.do?listNo=2");
		return forward;
	}

}
