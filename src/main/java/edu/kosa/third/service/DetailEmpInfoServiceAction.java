package edu.kosa.third.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kosa.third.action.Action;
import edu.kosa.third.action.ActionForward;
import edu.kosa.third.dao.UsrInfoDao;
import edu.kosa.third.dto.EmpDetailsDto;

public class DetailEmpInfoServiceAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		UsrInfoDao dao = new UsrInfoDao();

		EmpDetailsDto empList = dao.detailempInfo();
		
		request.setAttribute("empList", empList);
		System.out.println("services"+empList.getEmpdto().getEmpName());
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/WEB-INF/views/usrinfo/detailEmpInfo.jsp");
		return forward;
	}
}
