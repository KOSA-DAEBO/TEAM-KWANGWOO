package edu.kosa.third.service;

import java.sql.Date;
import java.util.ArrayList;
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
		
		dao.totalEmpInfo();
		String usrId = "doldol";
		
		
		int empNo = Integer.parseInt("11");
		
		String empName = "김똘똘";
		
		Date hireDate = Date.valueOf("1993-07-06");
//		Date hireDate = Date.valueOf("23/07/06");
		
		EmpDto empInfo = new EmpDto();
		empInfo.setUsrId(usrId);
		empInfo.setEmpNo(empNo);
		empInfo.setEmpName(empName);
		empInfo.setHireDate(hireDate);

		List<EmpDto> empList = new ArrayList<>();
		empList.add(empInfo);
		
		request.setAttribute("empMap", empList);
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/WEB-INF/views/selectinfo/showEmpInfo.jsp");
		return forward;
	}
}
