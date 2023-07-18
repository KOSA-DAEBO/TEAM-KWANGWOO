package edu.kosa.third.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.kosa.third.action.Action;
import edu.kosa.third.action.ActionForward;
import edu.kosa.third.dao.UsrInfoDao;
import edu.kosa.third.dto.EmpDto;

public class UpdateEmpInfo implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);

//		String usrImage = request.getParameter("usrImage");
		String empName = request.getParameter("empName");
		String empAddr = request.getParameter("empAddr");
		String empTel = request.getParameter("empTel");
		String empEmail = request.getParameter("empEmail");
		String usrId = request.getParameter("usrId");
	
		UsrInfoDao updatedao = new UsrInfoDao();

	    HttpSession session = request.getSession();
	    EmpDto empDto = (EmpDto) session.getAttribute("login");
	    
		empDto.setEmpName(empName);
		empDto.setEmpAddr(empAddr);
		empDto.setEmpTel(empTel);
		empDto.setEmpEmail(empEmail);
		empDto.setUsrId(usrId);

		updatedao.updateEmpInfo(empDto);
		
		forward.setPath("empDetail.do");
		return forward;

	}
}
