package edu.kosa.third.service;

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

		String sNo = request.getParameter("sNo");

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out;
		/*
		 * try { out = response.getWriter();
		 * out.println("<script>alert('연차 일수가 부족합니다.'); window.history.back();</script>"
		 * ); out.flush(); } catch (IOException e) { e.printStackTrace(); }
		 */
		ActionForward forward = new ActionForward();
		forward.setRedirect(false); // True 클라이언트가 새로운 페이지를 요청하게 할 거예요
		forward.setPath("/WEB-INF/views/sal/payInsertForm.jsp");
		HashMap<String, String> map = dao.selectByNo(sNo);
		request.setAttribute("map", map);
		return forward;
	}

}
