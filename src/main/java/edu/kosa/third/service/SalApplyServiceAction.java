package edu.kosa.third.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.kosa.third.action.Action;
import edu.kosa.third.action.ActionForward;
import edu.kosa.third.dao.SalDao;

public class SalApplyServiceAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		SalDao dao = new SalDao();
		HttpSession session = request.getSession();
		String slistNum = request.getParameter("slistNum");

		String sNo = request.getParameter("sNo");

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out;

		ActionForward forward = new ActionForward();
		forward.setRedirect(false); // True 클라이언트가 새로운 페이지를 요청하게 할 거예요

		if (slistNum != null && slistNum.equals("3")) {
			String total = request.getParameter("total");
			String empNo = request.getParameter("empNo");
			String bonus = request.getParameter("allowance3");
			
			int a = dao.applySal(total, empNo, bonus);
			if (a > 0) {
				try {
					out = response.getWriter();
					out.println("<script>alert('급여 입력이 완료 되었습니다.'); location.href='salList.do';</script>");
					out.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			forward.setPath("/salList.do");
			return forward;
		}

		forward.setPath("/WEB-INF/views/sal/payInsertForm.jsp");
		HashMap<String, String> map = dao.selectByNo(sNo);
		request.setAttribute("map", map);
		return forward;
	}

}
