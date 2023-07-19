package edu.kosa.third.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import edu.kosa.third.action.Action;
import edu.kosa.third.action.ActionForward;
import edu.kosa.third.dao.ProductDao;

public class BuyProductServiceAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
			StringBuilder requestData = new StringBuilder();
			String data;
			while ((data = br.readLine()) != null) {
				requestData.append(data);
			}
			br.close();

			JSONParser parser = new JSONParser();
			JSONArray jsonArray = (JSONArray) parser.parse(requestData.toString());
			
			String[] itemValue = new String[jsonArray.size()];
			int itemPrice = 0;
			
			for (int i = 0; i < jsonArray.size(); i++) {
				JSONObject jsonObject = (JSONObject) jsonArray.get(i);
				itemValue[i] = (String) jsonObject.get("itemValue");
				itemPrice += Integer.parseInt((String) jsonObject.get("itemPrice"));
			}
			
			ProductDao dao = new ProductDao();
			dao.buyProduct(itemValue, itemPrice);
		} catch (Exception e) {
			e.printStackTrace();
		}
		forward.setPath("/index.jsp");
		return forward;
	}

}
