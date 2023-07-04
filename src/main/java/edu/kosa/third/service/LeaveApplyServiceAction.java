package edu.kosa.third.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kosa.third.action.Action;
import edu.kosa.third.action.ActionForward;
import edu.kosa.third.dao.LeaveDao;

public class LeaveApplyServiceAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		LeaveDao dao = new LeaveDao();

		String typeNo = request.getParameter("leaveType");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String reason = request.getParameter("reason");
		int num = dao.applyLeave(typeNo, startDate, endDate, reason);

		String resultdata = "";
		if (num > 0) {
			resultdata = "휴가 신청이 성공적으로 이루어졌습니다.";
		} else {
			resultdata = "휴가 신청에 실패하였습니다.";
		}

		request.setAttribute("data", resultdata);

		ActionForward forward = new ActionForward();
		forward.setRedirect(false); // True 클라이언트가 새로운 페이지를 요청하게 할 거예요
		forward.setPath("/index.html");
		return forward;

	}

}
