package edu.kosa.third.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kosa.third.action.Action;
import edu.kosa.third.action.ActionForward;
import edu.kosa.third.dao.DeptDao;
import edu.kosa.third.dto.DeptDto;

public class DeleteDeptServiceAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		String deptname = request.getParameter("deptName");
		int deptno = Integer.parseInt(request.getParameter("deptNo"));
		
		DeptDao dao = new DeptDao();
		dao.deleteDept(new DeptDto(deptno, deptname));
		
		forward.setPath("/deptMenu.do");
		return forward;
	}
}
