package edu.kosa.third.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kosa.third.action.Action;
import edu.kosa.third.action.ActionForward;
import edu.kosa.third.dao.DeptDao;
import edu.kosa.third.dto.DeptDto;

public class AddDeptServiceAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		if (request.getParameter("deptName") == null) {
			forward.setPath("deptMenu.do");
			return forward;
		} else {
			String deptName = request.getParameter("deptName");
			int deptNo = Integer.parseInt(request.getParameter("deptNo"));
			DeptDao deptdao = new DeptDao();
				
			boolean result = deptdao.insertDept(new DeptDto(deptNo, deptName));

			if (result == false) {//이름은 null 이 아니다.
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out;
				try {
					out = response.getWriter();
					out.println("<script>alert('부서를 추가할 수 없습니다.'); window.history.back();</script>");
					out.flush();
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				return null;
			} else {
				forward.setRedirect(true); // 리다이렉트 방식으로 설정
				forward.setPath("deptMenu.do");
				return forward;
			}
		}
	}
}
