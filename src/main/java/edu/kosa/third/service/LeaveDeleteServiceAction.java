package edu.kosa.third.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.kosa.third.action.Action;
import edu.kosa.third.action.ActionForward;
import edu.kosa.third.dao.LeaveDao;

public class LeaveDeleteServiceAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		LeaveDao dao = new LeaveDao();
		HttpSession session = request.getSession();
		String levStatus = (String) session.getAttribute("levStatus");
		String typeNo = (String) session.getAttribute("typeNo");
		String startDay = (String) session.getAttribute("startDay");
		String endDay = (String) session.getAttribute("endDay");
		String usrId = (String) session.getAttribute("usrId");
		
		int leaveNo = Integer.parseInt(request.getParameter("leaveNo"));
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out;
		
		if(levStatus.equals("1")) {
			try {
				out = response.getWriter();
				out.println("<script>alert('승인된 휴가의 삭제는 관리자에게 문의해주세요.');</script>");
				out.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		dao.deleteLeave(leaveNo);
		
		if (levStatus.equals("1") && typeNo.equals("10")) 
			dao.incAnnualLeave(startDay, endDay, usrId );
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/leaveList.do?listNum=1");
		return forward;
	}

}
