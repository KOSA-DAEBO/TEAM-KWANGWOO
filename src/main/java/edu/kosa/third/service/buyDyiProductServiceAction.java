package edu.kosa.third.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kosa.third.action.Action;
import edu.kosa.third.action.ActionForward;

public class buyDyiProductServiceAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringBuilder requestData = new StringBuilder();
			String data = br.readLine();
			
			System.out.println(data);
			while (data != null) {
				System.out.println("돌아감?3");
				requestData.append(data);
			}
			
			System.out.println(data);
			System.out.println("왜 데이터가 안나올까나....");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
