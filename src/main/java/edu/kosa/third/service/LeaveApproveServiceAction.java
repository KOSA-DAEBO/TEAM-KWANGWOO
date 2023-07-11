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

public class LeaveApproveServiceAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String levStatus = (String) session.getAttribute("levStatus");
		if (!levStatus.equals("0")) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out;
			try {
				out = response.getWriter();
				out.println("<script>alert('이미 승인(반려)처리 된 휴가 신청서입니다.'); location.href='leaveList.do?listNum=2';</script>");
				out.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		if(levStatus.equals("0")) {
		LeaveDao dao = new LeaveDao();
		int leaveNo = Integer.parseInt((String) session.getAttribute("leaveNo"));
		String startDay = (String) session.getAttribute("startDay");
		String endDay = (String) session.getAttribute("endDay");
		String typeNo = (String) session.getAttribute("typeNo");
		String usrId = "crush0327";
		int num = Integer.parseInt(request.getParameter("approveType"));
		if (typeNo.equals("10") && num==1) {
			DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			long days = 0;
			int annual = dao.checkAnnual(usrId);
			try {
				Date sd = sdf.parse(startDay);
				Date ed = sdf.parse(endDay);
				long sec = ((ed.getTime() - sd.getTime())) / 1000;
				days = sec / (24 * 60 * 60);
				annual -= (days + 1);

			} catch (ParseException e) {
				e.printStackTrace();
			}
			if (annual < 0) {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out;
				try {
					out = response.getWriter();
					out.println("<script>alert('연차일수가 부족하여, 승인 처리가 불가능합니다. '); location.href='leaveList.do?No="+leaveNo+"';</script>");
					out.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}
				ActionForward forward = new ActionForward();
				forward.setRedirect(false); // True 클라이언트가 새로운 페이지를 요청하게 할 거예요
				forward.setPath("/leaveList.do?listNum=2");
				return forward;
			}
		}

		String resultdata = "";

		int su = dao.approveLeave(num, leaveNo);
		
		if (su > 0 && num == 1) {
			if(typeNo.equals("10"))
			dao.decAnnualLeave(startDay, endDay, usrId);
			resultdata = "휴가를 승인 처리하였습니다.";
		} else if (su == 0) {
			resultdata = "휴가 승인/반려에 실패하였습니다.";
		} else if (su > 0 && num == 2) {
			resultdata = "휴가를 반려 처리하였습니다.";
		}

		request.setAttribute("data", resultdata);
		}
		ActionForward forward = new ActionForward();
		forward.setRedirect(false); // True 클라이언트가 새로운 페이지를 요청하게 할 거예요
		forward.setPath("/leaveList.do?listNum=2");
		return forward;
	}

}
