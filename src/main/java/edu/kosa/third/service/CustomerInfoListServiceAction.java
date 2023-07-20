package edu.kosa.third.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kosa.third.action.Action;
import edu.kosa.third.action.ActionForward;
import edu.kosa.third.dao.UsrInfoDao;
import edu.kosa.third.dto.CustomerDto;

public class CustomerInfoListServiceAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		
		UsrInfoDao usrInfoDao = new UsrInfoDao();
		
		List<CustomerDto> customList = usrInfoDao.totalCustom();
		
		request.setAttribute("customList", customList);
		
		forward.setPath("/WEB-INF/views/usrinfo/customList.jsp");
        return forward;
	}

}
