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

		int empNo = Integer.parseInt(request.getParameter("empNo"));
		int posNo = Integer.parseInt(request.getParameter("posNo"));
		int salary = Integer.parseInt(request.getParameter("ManageEmpSalary"));
		int deptNo = Integer.parseInt(request.getParameter("deptNo"));



		UsrInfoDao usrInfoDao = new UsrInfoDao();
		usrInfoDao.updateManageEmpInfo(empNo,posNo,salary,deptNo);

		forward.setPath("manageEmpInfo.do?empNo="+empNo);
        return forward;
	}

}
