package edu.kosa.third.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kosa.third.action.Action;
import edu.kosa.third.action.ActionForward;

public class AddDeptServiceAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		int deptNo = Integer.parseInt(request.getParameter("deptNo"));
		String deptName = request.getParameter("deptName");
		
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/addDept.do");
		return forward;
	}
}
