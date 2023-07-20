package edu.kosa.third.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kosa.third.action.Action;
import edu.kosa.third.action.ActionForward;
import edu.kosa.third.dao.UsrInfoDao;
import edu.kosa.third.dto.CustomerDto;

public class ManageCustomInfoServiceAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		
		UsrInfoDao usrInfoDao = new UsrInfoDao();
		int customNo = Integer.parseInt(request.getParameter("customerNo"));

		CustomerDto customDto = usrInfoDao.customDetail(customNo);
		
		request.setAttribute("customInfo", customDto);
		System.out.println();
		forward.setPath("/WEB-INF/views/usrinfo/customManage.jsp");
		return forward;
	}

}
