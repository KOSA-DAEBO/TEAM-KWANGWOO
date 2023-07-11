package edu.kosa.third.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kosa.third.action.Action;
import edu.kosa.third.action.ActionForward;

public class SelectCustomerInfoServiceAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		
		String customerUsrId = request.getParameter("customerUsrId");
		String customerName = request.getParameter("customerName");
		String customerEmail = request.getParameter("customerEmail");
		String customerTel = request.getParameter("customerTel");
		String customerAddr = request.getParameter("customerAddr");
		String customerGender = request.getParameter("customerGender");
		String customerBirth = request.getParameter("customerBirth");

		Map<String, Object> customMap = new HashMap<>();
		customMap.put("customerUsrId", customerUsrId);
		customMap.put("customerName", customerName);
		customMap.put("customerEmail", customerEmail);
		customMap.put("customerTel", customerTel);
		customMap.put("customerAddr", customerAddr);
		customMap.put("customerGender", customerGender);
		customMap.put("customerBirth", customerBirth);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/WEB-INF/views/selectinfo/showCustomInfo.jsp");
		return forward;
	}
}
