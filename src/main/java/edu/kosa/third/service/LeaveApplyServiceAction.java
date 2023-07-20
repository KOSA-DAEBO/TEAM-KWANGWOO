package edu.kosa.third.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.kosa.third.action.Action;
import edu.kosa.third.action.ActionForward;
import edu.kosa.third.dao.LeaveDao;
import edu.kosa.third.dto.EmpDto;

public class LeaveApplyServiceAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		LeaveDao dao = new LeaveDao();
		HttpSession session = request.getSession();
		EmpDto dto = (EmpDto) session.getAttribute("login");
		String usrId = dto.getUsrId();
		
		String typeNo = request.getParameter("leaveType");
		String startDay = request.getParameter("startDay");
		String endDay = request.getParameter("endDay");
		String reason = request.getParameter("reason");
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
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out;
		if (typeNo.equals("10") && dao.checkAnnual(usrId) < (int) (days + 1)) {
			try {
				out = response.getWriter();
				out.println("<script>alert('연차 일수가 부족합니다.'); window.history.back();</script>");
				out.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (dao.checkDays(usrId, startDay, endDay)) {
			try {
				out = response.getWriter();
				out.println("<script>alert('선택 하신 날짜에 중복으로 휴가가 신청되어 있습니다.'); window.history.back();</script>");
				out.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			int num =dao.applyLeave(typeNo, startDay, endDay, reason, usrId);
			if(num>0) resultdata = "휴가 신청 완료.";
			else resultdata="휴가 신청 실패";
		}
		request.setAttribute("data", resultdata);

		ActionForward forward = new ActionForward();
		forward.setRedirect(false); // True 클라이언트가 새로운 페이지를 요청하게 할 거예요
		forward.setPath("/leaveList.do?listNum=3");
		return forward;
	}

}
