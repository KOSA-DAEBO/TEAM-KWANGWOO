package edu.kosa.third.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kosa.third.action.Action;
import edu.kosa.third.action.ActionForward;
import edu.kosa.third.dao.ItemClsDao;
import edu.kosa.third.dao.ItemDao;
import edu.kosa.third.dto.ItemClsDto;
import edu.kosa.third.dto.ItemsDto;

public class getItemServiceAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		
		ItemDao dao = new ItemDao();
		ItemClsDao cDao = new ItemClsDao();
		ArrayList<ItemsDto> list = dao.selectAll();
		ArrayList<ItemClsDto> dtoList = cDao.selectAll();
		
		request.setAttribute("list", list);
		request.setAttribute("dtoList", dtoList);
		forward.setRedirect(false);
		forward.setPath("/WEB-INF/views/product/addProduct.jsp");
		
		return forward;
	}

}
