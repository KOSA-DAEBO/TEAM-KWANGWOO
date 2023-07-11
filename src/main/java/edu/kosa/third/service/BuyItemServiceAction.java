package edu.kosa.third.service;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kosa.third.action.Action;
import edu.kosa.third.action.ActionForward;
import edu.kosa.third.dao.ItemDao;
import edu.kosa.third.dto.ItemDto;

public class BuyItemServiceAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		
		try {
			String jsonData = request.getReader().lines()
			        .reduce("", (accumulator, actual) -> accumulator + actual);
			
			String[] jsonObjects = jsonData.substring(2, jsonData.length() - 2).split("\\},\\s*\\{");
			
			int totalPrice = 0;
			for (String jsonObject : jsonObjects) {
				String[] str = jsonObject.replaceAll("\"", "").split(",");
				int itemNo = Integer.parseInt(str[0].split(":")[1]);
				int stock = Integer.parseInt(str[1].split(":")[1]);
				int price = Integer.parseInt(str[2].split(":")[1]);
				
				totalPrice += price;
				
				ItemDao dao = new ItemDao();
				dao.buyItem(new ItemDto(itemNo, stock));
			}
			
			ItemDao dao = new ItemDao();
			
			dao.costMoney(totalPrice);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		forward.setPath("itemList.do?listNo=3");
		return forward;
	}
}
