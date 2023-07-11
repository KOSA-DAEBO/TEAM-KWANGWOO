package edu.kosa.third.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kosa.third.action.Action;
import edu.kosa.third.action.ActionForward;
import edu.kosa.third.dao.UsrInfoDao;
import edu.kosa.third.dto.EmpDto;

public class SelectEmpInfoServiceAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		UsrInfoDao dao = new UsrInfoDao();

		List<EmpDto> empList = dao.totalEmpInfo();

		request.setAttribute("empList", empList);
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/WEB-INF/views/selectinfo/showEmpInfo.jsp");
		return forward;
	}
}
