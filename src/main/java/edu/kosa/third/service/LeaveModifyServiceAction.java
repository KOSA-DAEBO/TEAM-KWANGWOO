package edu.kosa.third.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.kosa.third.action.Action;
import edu.kosa.third.action.ActionForward;
import edu.kosa.third.dao.LeaveDao;

public class LeaveModifyServiceAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		LeaveDao dao = new LeaveDao();
		HttpSession session = request.getSession();
		String levStatus = (String) session.getAttribute("levStatus");
		String typeNo = request.getParameter("leaveType");
		String startDay = request.getParameter("startDay");
		String endDay = request.getParameter("endDay");
		String reason = request.getParameter("reason");
		int leaveNo = Integer.parseInt(request.getParameter("leaveNo"));
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out;
		
		/*if(levStatus.equals("1")) {
			try {
				out = response.getWriter();
				out.println("<script>alert('승인된 휴가의 삭제는 관리자에게 문의해주세요.');</script>");
				out.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}*/
		
		dao.modifyLeave(startDay, endDay, reason, Integer.parseInt(typeNo), leaveNo);
		
		ActionForward forward = new ActionForward();
		forward.setPath("/WEB-INF/views/leave/leaveDetail.jsp");
		ArrayList<HashMap<String, String>> list = dao.selectByNo(leaveNo+"");
		request.setAttribute("list", list);
		return forward;
	}
}
