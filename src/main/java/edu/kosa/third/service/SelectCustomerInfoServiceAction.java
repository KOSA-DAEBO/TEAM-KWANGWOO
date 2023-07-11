package edu.kosa.third.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kosa.third.action.Action;
import edu.kosa.third.action.ActionForward;
import edu.kosa.third.dao.UsrInfoDao;
import edu.kosa.third.dto.CustomerDto;

public class SelectCustomerInfoServiceAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		String usrId = (String) request.getSession().getAttribute("usrId");
		UsrInfoDao dao = new UsrInfoDao();
		CustomerDto customList = dao.detailCustInfo(usrId);

		request.setAttribute("customList", customList);
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/WEB-INF/views/selectinfo/showCustomInfo.jsp");
		return forward;
	}
}
