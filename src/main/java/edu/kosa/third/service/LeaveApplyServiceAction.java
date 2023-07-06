package edu.kosa.third.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
		String startDay = request.getParameter("startDay");
		String endDay = request.getParameter("endDay");
		String reason = request.getParameter("reason");
		String usrId = "crush0327";
		String resultdata = "";
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		long days = 0;
		try {
			Date sd = sdf.parse(startDay);
			Date ed = sdf.parse(endDay);
			long sec = ((ed.getTime() - sd.getTime())) / 1000;
			days = sec / (24 * 60 * 60);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if (typeNo.equals("10") && dao.checkAnnual(usrId) < (int) (days + 1)) {
			resultdata = "연차 일수가 부족하여 휴가 신청에 실패하였습니다.";
		} else if (dao.checkDays(usrId, startDay, endDay)) {
			resultdata = "선택 하신 날짜에 중복으로 휴가가 신청되어 있습니다.";
		} else {
			dao.applyLeave(typeNo, startDay, endDay, reason, usrId);
			resultdata = "휴가 신청 완료.";
		}
		request.setAttribute("data", resultdata);

		ActionForward forward = new ActionForward();
		forward.setRedirect(false); // True 클라이언트가 새로운 페이지를 요청하게 할 거예요
		forward.setPath("/WEB-INF/views/leave/leaveMain.jsp");
		return forward;
	}

}
