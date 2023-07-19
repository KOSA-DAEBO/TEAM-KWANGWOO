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
		String listNum = request.getParameter("listNum");
		HttpSession session = request.getSession();
		EmpDto dto = (EmpDto) session.getAttribute("login");

		String field = request.getParameter("field");
		String search = request.getParameter("search");
		System.out.println(field+" "+search);
		ActionForward forward = new ActionForward();
		forward.setRedirect(false); // True 클라이언트가 새로운 페이지를 요청하게 할 거예요

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = null;

		/*
		if ((listNum != null && listNum.equals("1")) || (listNum != null && listNum.equals("2"))) {
			if (!dto.isRole()) {
				try {
					out = response.getWriter();
					out.println(
							"<script>alert('휴가 관리 메뉴는 관리자만 이용 가능합니다.'); location.href='leaveList.do?listNum=3';</script>");
					out.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}
				ArrayList<HashMap<String, String>> list = dao.selectById(dto.getUsrId());
				forward.setPath("/WEB-INF/views/leave/leaveList3.jsp");
				request.setAttribute("list", list);
				return forward;
			}
		}
		
		if((field!=null) && field.equals("selection")){
			forward.setPath("/WEB-INF/views/leave/leaveList5.jsp");
			ArrayList<HashMap<String, String>> list = dao.selectAll();
			request.setAttribute("list", list);

			return forward;
		}
		
		if (listNum != null && listNum.equals("1"))
			forward.setPath("/WEB-INF/views/leave/leaveList5.jsp");
		else if (listNum != null && listNum.equals("2"))
			forward.setPath("/WEB-INF/views/leave/leaveList2.jsp");
		else if (listNum != null && listNum.equals("3")) {
			ArrayList<HashMap<String, String>> list = dao.selectById(dto.getUsrId());
			forward.setPath("/WEB-INF/views/leave/leaveList3.jsp");
			request.setAttribute("list", list);
			return forward;
		} else if (listNum != null && listNum.equals("4")) {
			ArrayList<HashMap<String, String>> list = dao.selectById(dto.getUsrId());
			forward.setPath("/WEB-INF/views/leave/leaveList4.jsp");
			request.setAttribute("list", list);
			return forward;
		} else if (field != null && field.equals("deptName")) {
			ArrayList<HashMap<String, String>> list = dao.selectByDeptName(search);
			forward.setPath("/WEB-INF/views/leave/leaveList5.jsp");
			request.setAttribute("list", list);
			return forward;
		} else if (field != null && field.equals("empNo")) {
			int empNo = Integer.parseInt(search);
			ArrayList<HashMap<String, String>> list = dao.selectByEmpNo(empNo);
			forward.setPath("/WEB-INF/views/leave/leaveList5.jsp");
			request.setAttribute("list", list);
			return forward;
		} else if (field != null && field.equals("posName")) {
			ArrayList<HashMap<String, String>> list = dao.selectByPosName(search);
			forward.setPath("/WEB-INF/views/leave/leaveList5.jsp");
			request.setAttribute("list", list);
			return forward;
		}

		else {

			forward.setPath("/WEB-INF/views/leave/leaveDetail.jsp");
			String num = request.getParameter("No");
			ArrayList<HashMap<String, String>> list = dao.selectByNo(num);
			request.setAttribute("list", list);
			return forward;
		}
		 */
		forward.setPath("/WEB-INF/views/sal/salList.jsp");
		ArrayList<HashMap<String, String>> list = dao.selectTM();
		request.setAttribute("list", list);

		return forward;
	}

}
