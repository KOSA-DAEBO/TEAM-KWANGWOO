package edu.kosa.third.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kosa.third.action.Action;
import edu.kosa.third.action.ActionForward;

public class DeptManageViewServiceAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		String deptMenu = request.getParameter("selectDept");

		ActionForward forward = new ActionForward();
		forward.setRedirect(false);

		if (deptMenu != null && deptMenu.equals("deptInsert"))
			forward.setPath("WEB-INF/views/deptMenu/insertDept.jsp");
		else if (deptMenu != null && deptMenu.equals("updateDept"))
			forward.setPath("WEB-INF/views/deptMenu/updateDept.jsp");
		else if (deptMenu != null && deptMenu.equals("deleteDept"))
			forward.setPath("WEB-INF/views/deptMenu/deleteDept.jsp");
		return forward;
	}

}
