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
		
		int newDeptNo = Integer.parseInt(request.getParameter("deptNo"));
		String newDeptName = request.getParameter("deptName");
		String BeforeDeptName = request.getParameter("");
		DeptDao deptdao = new DeptDao();
		System.out.println("newDeptName"+newDeptName);
		System.out.println("newDeptNo"+newDeptNo);
		deptdao.updateDept(new DeptDto(newDeptNo, newDeptName));
		forward.setPath("/deptMenu.do");
		return forward;
	}
}
