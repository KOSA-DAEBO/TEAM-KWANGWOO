package edu.kosa.third.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kosa.third.action.Action;
import edu.kosa.third.action.ActionForward;
import edu.kosa.third.dao.UsrInfoDao;
import edu.kosa.third.dto.EmpDetailsDto;

public class EmpDetailInfoServiceAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		UsrInfoDao dao = new UsrInfoDao();

		EmpDetailsDto empList = dao.detailEmpInfo();
		
		request.setAttribute("empList", empList);
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/WEB-INF/views/usrinfo/detailEmpInfo.jsp");
		return forward;
	}
}
