package edu.kosa.third.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kosa.third.action.Action;
import edu.kosa.third.action.ActionForward;
import edu.kosa.third.dao.DeptDao;
import edu.kosa.third.dto.DeptDto;

public class TotalDeptServiceAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		DeptDao deptdao = new DeptDao();
		
		DeptDto deptDto = deptdao.deptAll(request);
		request.setAttribute("deptList", deptList);
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/WEB-INF/views/usrinfo/detailEmpInfo.jsp");
		return forward;
	}

}
