package edu.kosa.third.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kosa.third.action.Action;
import edu.kosa.third.action.ActionForward;
import edu.kosa.third.dto.DeptDto;

public class DeptManageServiceAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		DeptDto deptDto = new DeptDto();
		
		String deptName = request.getParameter("deptName");
		int deptNo = Integer.parseInt(request.getParameter("deptNo"));
		
		return null;
	}
}
