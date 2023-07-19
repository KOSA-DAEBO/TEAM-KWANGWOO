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
import edu.kosa.third.dto.EmpDto;

public class SalListServiceAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {

		SalDao dao = new SalDao();
		String slistNum = request.getParameter("slistNum");
		String sNo = request.getParameter("sNo");
		HttpSession session = request.getSession();
		EmpDto dto = (EmpDto) session.getAttribute("login");

		String field = request.getParameter("field");
		String search = request.getParameter("search");
		System.out.println(field + " " + search);
		ActionForward forward = new ActionForward();
		forward.setRedirect(false); // True 클라이언트가 새로운 페이지를 요청하게 할 거예요

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = null;

		if (slistNum != null && slistNum.equals("1")) {
			forward.setPath("/WEB-INF/views/sal/salEmpList2.jsp");
			ArrayList<HashMap<String, String>> list = dao.selectEmpTM();
			request.setAttribute("list", list);
			return forward;
		} else if (slistNum != null && slistNum.equals("2")) {
			forward.setPath("/WEB-INF/views/sal/salEmpList.jsp");
			ArrayList<HashMap<String, String>> list = dao.selectEmpAll();
			request.setAttribute("list", list);
			return forward;
		}

		forward.setPath("/WEB-INF/views/sal/salList.jsp");
		ArrayList<HashMap<String, String>> list = dao.selectTM();
		request.setAttribute("list", list);

		return forward;
	}

}
