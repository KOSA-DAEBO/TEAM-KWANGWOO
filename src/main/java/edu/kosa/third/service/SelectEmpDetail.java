package edu.kosa.third.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kosa.third.action.Action;
import edu.kosa.third.action.ActionForward;
import edu.kosa.third.dao.UsrInfoDao;
import edu.kosa.third.dto.EmpsDetailDto;

public class SelectEmpDetail implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		UsrInfoDao dao = new UsrInfoDao();
		
		ArrayList<EmpsDetailDto> empList = dao.detailempInfo();
		request.setAttribute("empList", empList);
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/WEB-INF/views/selectinfo/detailEmpInfo.jsp");
		return forward;
	}
}
