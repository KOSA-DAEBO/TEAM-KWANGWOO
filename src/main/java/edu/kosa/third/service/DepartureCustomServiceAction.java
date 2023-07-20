package edu.kosa.third.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.kosa.third.action.Action;
import edu.kosa.third.action.ActionForward;
import edu.kosa.third.dao.UsrInfoDao;
import edu.kosa.third.dto.CustomerDto;
import edu.kosa.third.dto.UsrDto;

public class DepartureCustomServiceAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		
		int customNo = Integer.parseInt(request.getParameter("customNo"));
		
		HttpSession session = request.getSession();
		
		UsrInfoDao dao = new UsrInfoDao();
		CustomerDto customDto = (CustomerDto) session.getAttribute("loginCustomer");
		dao.deleteCustomInfo(customDto);
		
		forward.setPath("customList.do");
		return forward;
	}
}
