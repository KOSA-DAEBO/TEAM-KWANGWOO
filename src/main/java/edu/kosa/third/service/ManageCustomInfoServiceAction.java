package edu.kosa.third.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.kosa.third.action.Action;
import edu.kosa.third.action.ActionForward;
import edu.kosa.third.dao.UsrInfoDao;
import edu.kosa.third.dto.CustomerDto;
import edu.kosa.third.dto.EmpDto;

public class ManageCustomInfoServiceAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		
		HttpSession session = request.getSession();
		CustomerDto dto = (CustomerDto) session.getAttribute("loginCustomer");
		
		int customNo = (dto.getCustomerNo());
		UsrInfoDao usrInfoDao = new UsrInfoDao();

		CustomerDto customDto = usrInfoDao.customDetail(customNo);
		
		request.setAttribute("customInfo", customDto);
		forward.setPath("/WEB-INF/views/usrinfo/customManage.jsp");
		return forward;
	}

}
