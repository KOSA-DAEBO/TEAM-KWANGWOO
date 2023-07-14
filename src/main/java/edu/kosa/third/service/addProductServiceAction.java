package edu.kosa.third.service;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import edu.kosa.third.action.Action;
import edu.kosa.third.action.ActionForward;

public class addProductServiceAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);

		try {
			Part filePart = request.getPart("file");
			String fileName = filePart.getSubmittedFileName();
			String savePath = "./images"; // 파일 저장 경로 지정
			
			filePart.write(savePath + File.separator + fileName);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		forward.setPath("productList.do");
		return forward;
	}

}
