package edu.kosa.third.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kosa.third.action.Action;
import edu.kosa.third.action.ActionForward;
import edu.kosa.third.dao.DeptDao;
import edu.kosa.third.dto.DeptDto;

public class TotalDeptServiceAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		DeptDao deptDao = new DeptDao();

		List<DeptDto> deptList = deptDao.totalDept();
		request.setAttribute("deptList", deptList);

		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/WEB-INF/views/deptMenu2/deptList.jsp");
		return forward;
	}

}
