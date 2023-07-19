package edu.kosa.third.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.kosa.third.action.Action;
import edu.kosa.third.action.ActionForward;
import edu.kosa.third.dao.UsrInfoDao;
import edu.kosa.third.dto.EmpDetailsDto;
import edu.kosa.third.dto.EmpDto;

public class DetailEmpInfoServiceAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		UsrInfoDao dao = new UsrInfoDao();
		
		HttpSession session = request.getSession();
		EmpDto empdto = (EmpDto) session.getAttribute("login");
		
		EmpDetailsDto empInfo = dao.detailEmpInfo(empdto.getEmpNo());
		request.setAttribute("empInfo", empInfo);
		
			
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/WEB-INF/views/usrinfo/detailEmpInfo.jsp");
		return forward;
	}
}
