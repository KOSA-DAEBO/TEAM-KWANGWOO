package edu.kosa.third.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.kosa.third.action.Action;
import edu.kosa.third.action.ActionForward;
import edu.kosa.third.dao.LeaveDao;

public class LeaveApproveServiceAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		LeaveDao dao = new LeaveDao();
		HttpSession session = request.getSession();
		int leaveNo = Integer.parseInt((String)session.getAttribute("leaveNo"));
		String startDay = (String)session.getAttribute("startDay");
		String endDay = (String)session.getAttribute("endDay");
		String usrId = "crush0327";
		int num = Integer.parseInt(request.getParameter("approveType"));
		String resultdata = "";
		
		int su = dao.approveLeave(num,leaveNo);
		
		if(su>0 && num==1) {
			dao.decAnnualLeave(startDay, endDay, usrId) ;
			resultdata ="휴가를 승인 처리하였습니다.";
		} else if(su==0) {
			resultdata = "휴가 승인/반려에 실패하였습니다.";
		} else if(su>0 && num==2) {
			resultdata ="휴가를 반려 처리하였습니다.";
		}
		
		request.setAttribute("data", resultdata);

		ActionForward forward = new ActionForward();
		forward.setRedirect(false); // True 클라이언트가 새로운 페이지를 요청하게 할 거예요
		forward.setPath("/WEB-INF/views/leave/leaveMain.jsp");
		return forward;
	}

}
