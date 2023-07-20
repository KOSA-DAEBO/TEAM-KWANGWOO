package edu.kosa.third.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kosa.third.action.Action;
import edu.kosa.third.action.ActionForward;
import edu.kosa.third.dao.UsrInfoDao;
import edu.kosa.third.dto.CustomerDto;

public class DeleteCustomServiceAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		
		int customerNo = Integer.parseInt(request.getParameter("customNo"));
		UsrInfoDao dao = new UsrInfoDao();
		
		dao.deleteCustomInfo(new CustomerDto(customerNo, null, null, null, null, null, null, null));

		forward.setPath("customList.do");
		return forward;
	}

}
