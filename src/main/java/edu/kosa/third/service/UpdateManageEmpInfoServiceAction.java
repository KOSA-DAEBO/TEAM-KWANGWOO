package edu.kosa.third.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kosa.third.action.Action;
import edu.kosa.third.action.ActionForward;
import edu.kosa.third.dao.UsrInfoDao;
import edu.kosa.third.dto.EmpDto;

public class UpdateManageEmpInfoServiceAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		
		String empName = request.getParameter("empName");
		int deptNo = Integer.parseInt(request.getParameter("deptNo"));
		int posNo = Integer.parseInt(request.getParameter("posNo"));
		int salary = Integer.parseInt(request.getParameter("salary"));
		int empNo = Integer.parseInt(request.getParameter("empNo"));
		UsrInfoDao usrInfoDao = new UsrInfoDao();
		usrInfoDao.updateManageEmpInfo(new EmpDto(empName, deptNo, posNo, salary, empNo));
		
		forward.setPath("/WEB-INF/views/usrinfo/manageEmpInfo.jsp");
        return forward;
	}

}
