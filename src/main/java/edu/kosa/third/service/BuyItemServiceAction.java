package edu.kosa.third.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kosa.third.action.Action;
import edu.kosa.third.action.ActionForward;

public class BuyItemServiceAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		
		try {
			String jsonData = request.getReader().lines()
			        .reduce("", (accumulator, actual) -> accumulator + actual);
			System.out.println(jsonData);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		forward.setPath("/WEB-INF/views/item/buyItem.jsp");
		return forward;
	}

}
