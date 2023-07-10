package edu.kosa.third.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kosa.third.action.Action;
import edu.kosa.third.action.ActionForward;
import edu.kosa.third.dao.ItemDao;
import edu.kosa.third.dto.ItemDto;

public class AddItemServiceAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);

		if(request.getParameter("itemName") == null) {
			forward.setPath("/WEB-INF/views/item/addItem.jsp");
			return forward;
		} else {
			String itemName = request.getParameter("itemName");
			int cost = Integer.parseInt(request.getParameter("cost"));
			int price = Integer.parseInt(request.getParameter("price"));
			int itemClsNo = Integer.parseInt(request.getParameter("itemClsNo"));
			
			ItemDao dao = new ItemDao();
			
			boolean result = dao.insertItem(new ItemDto(itemName, cost, price, itemClsNo));
			
			if(result == false) {
				response.setContentType("text/html;charset=UTF-8");
                PrintWriter out;
				try {
					out = response.getWriter();
					out.println("<script>alert('중복된 상품명이 있습니다.'); window.history.back();</script>");
					out.flush();
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
                return null;
            } else {
                forward.setRedirect(true); // 리다이렉트 방식으로 설정
                forward.setPath("itemList.do");
                return forward;
			}
		}
	}
}