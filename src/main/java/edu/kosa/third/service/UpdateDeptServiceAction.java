package edu.kosa.third.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kosa.third.action.Action;
import edu.kosa.third.action.ActionForward;
import edu.kosa.third.dao.DeptDao;
import edu.kosa.third.dto.DeptDto;

public class UpdateDeptServiceAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		
		int deptNo = Integer.parseInt(request.getParameter("deptNo"));
		String deptName = request.getParameter("deptName");

		DeptDao deptdao = new DeptDao();

		deptdao.updateDept(new DeptDto(deptNo, deptName));
		forward.setPath("/deptMenu.do");
		return forward;
	}
}
