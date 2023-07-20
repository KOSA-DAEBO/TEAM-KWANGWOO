package edu.kosa.third.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kosa.third.action.Action;
import edu.kosa.third.action.ActionForward;
import edu.kosa.third.dao.UsrInfoDao;
import edu.kosa.third.dto.EmpDto;

public class UpdateEmpInfoServiceAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		
		String empAddr = request.getParameter("empAddr");
		String empTel = request.getParameter("empTel");
		String empEmail = request.getParameter("empEmail");
		int empNo = Integer.parseInt("");
		
		UsrInfoDao usrInfoDao = new UsrInfoDao();
		usrInfoDao.updateEmpInfo(new EmpDto(empAddr, empTel, empEmail, empNo));
		
		forward.setPath("empDetail.do");
		return forward;
	}

}
