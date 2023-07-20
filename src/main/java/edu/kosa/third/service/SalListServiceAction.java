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
import edu.kosa.third.dto.EmpDto;

public class SalListServiceAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {

		SalDao dao = new SalDao();
		String slistNum = request.getParameter("slistNum");
		String sNo = request.getParameter("sNo");
		HttpSession session = request.getSession();
		EmpDto dto = (EmpDto) session.getAttribute("login");

		String field1 = request.getParameter("field1");
		String field2 = request.getParameter("field2");
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
		} else if (slistNum != null && slistNum.equals("4")) {
			forward.setPath("/WEB-INF/views/sal/salList2.jsp");
			ArrayList<HashMap<String, String>> list = dao.selectAllById(dto.getUsrId());
			request.setAttribute("list", list);
			return forward;
		} else if (field1 != null && field2 != null) {
			if(field1.equals("지급연도")||field2.equals("지급월")) {
				try {
					out = response.getWriter();
					out.println(
							"<script>alert('지급연도와 지급월을 선택해주세요.'); location.href='salList.do';</script>");
					out.flush();
					forward.setPath("/WEB-INF/views/sal/salList.jsp");
					ArrayList<HashMap<String, String>> list = dao.selectTM();
					request.setAttribute("list", list);

					return forward;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			ArrayList<HashMap<String, String>> list = dao.selectMonth(field1, field2);
			String title = field1 + " " + field2;
			forward.setPath("/WEB-INF/views/sal/salList3.jsp");
			request.setAttribute("list", list);
			request.setAttribute("title", title);
			return forward;
		}

		forward.setPath("/WEB-INF/views/sal/salList.jsp");
		ArrayList<HashMap<String, String>> list = dao.selectTM();
		request.setAttribute("list", list);

		return forward;
	}

}
