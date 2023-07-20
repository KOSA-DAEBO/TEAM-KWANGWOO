package edu.kosa.third.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.kosa.third.action.Action;
import edu.kosa.third.action.ActionForward;
import edu.kosa.third.dao.UsrInfoDao;
import edu.kosa.third.dto.CustomerDto;

public class ChangeCustomInfoServiceAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		HttpSession session = request.getSession();
		CustomerDto dto = (CustomerDto) session.getAttribute("loginCustomer");
		
		String usrId = dto.getUsrId();
		String customName = request.getParameter("customName");
		String customAddr = request.getParameter("customAddr");
		String customTel = request.getParameter("customTel");
		String customEmail = request.getParameter("customEmail");
		String customGender= request.getParameter("customerGender");
	    
		int customNo = Integer.parseInt(request.getParameter("customNo"));

		UsrInfoDao usrInfoDao = new UsrInfoDao();

		usrInfoDao.updateCustomInfo(new CustomerDto(customName, customAddr, customTel, customEmail, customNo));
		
		dto.setCustomerName(customName); 
		dto.setCustomerAddr(customAddr);
		dto.setCustomerTel(customTel);
		dto.setCustomerEmail(customEmail);
		dto.setCustomerGender(customGender);
		dto.setUsrId(usrId);
		dto.setCustomerNo(customNo);
		session.setAttribute("loginCustomer", dto);
		request.setAttribute("customInfo", dto);
		forward.setPath("/WEB-INF/views/usrinfo/customManage.jsp");
		return forward;
	}

}
