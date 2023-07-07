package edu.kosa.third.service;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kosa.third.action.Action;
import edu.kosa.third.action.ActionForward;
import edu.kosa.third.dao.LeaveDao;

public class LeaveListServiceAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		LeaveDao dao = new LeaveDao();
		String listNum = request.getParameter("listNum");

		ActionForward forward = new ActionForward();
		forward.setRedirect(false); // True 클라이언트가 새로운 페이지를 요청하게 할 거예요

		if (listNum != null && listNum.equals("1"))
			forward.setPath("/WEB-INF/views/leave/leaveList.jsp");
		else if (listNum != null && listNum.equals("2"))
			forward.setPath("/WEB-INF/views/leave/leaveList2.jsp");
		else if (listNum != null && listNum.equals("3")) {
			ArrayList<HashMap<String, String>> list = dao.selectById("crush0327");
			forward.setPath("/WEB-INF/views/leave/leaveList3.jsp");
			request.setAttribute("list", list);
			return forward;
		}
		else if (listNum != null && listNum.equals("4")) {
			ArrayList<HashMap<String, String>> list = dao.selectById("crush0327");
			forward.setPath("/WEB-INF/views/leave/leaveList4.jsp");
			request.setAttribute("list", list);
			return forward;
		} else {
			forward.setPath("/WEB-INF/views/leave/leaveDetail.jsp");
			String num = request.getParameter("No");
			ArrayList<HashMap<String, String>> list = dao.selectByNo(num);
			request.setAttribute("list", list);
			return forward;
		}
		ArrayList<HashMap<String, String>> list = dao.selectAll();
		request.setAttribute("list", list);

		return forward;
	}

}
