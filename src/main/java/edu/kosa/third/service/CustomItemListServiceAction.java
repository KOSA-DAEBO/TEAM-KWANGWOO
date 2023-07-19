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

public class CustomItemListServiceAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		
		ItemDao dao = new ItemDao();
		ArrayList<ItemsDto> list = dao.selectAll();
		
		ItemClsDao clsDao = new ItemClsDao();
		ArrayList<ItemClsDto> clsList = clsDao.selectAll();
		
		request.setAttribute("list", list);
		request.setAttribute("clsList", clsList);
		
		forward.setPath("/WEB-INF/views/product/customItemList.jsp");
		return forward;
	}

}
