package edu.kosa.third.service;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import edu.kosa.third.action.Action;
import edu.kosa.third.action.ActionForward;
import edu.kosa.third.dto.EmpDto;
import edu.kosa.third.utils.Thumbnail;

public class UpdateEmpInfoServiceAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		String realPath = "";
        String realPath2 = "";
        String savePath = "./images"; // 원본 이미지 저장 경로
        String usrImagePath = "./userImage"; // 썸네일 이미지 저장 경로
        String encType = "UTF-8";
        int maxSize = 1024 * 1024 * 5; //file upload 할 수 있는 최대 file 용량 - 5MB
        
        HttpSession session = request.getSession();
        EmpDto dto = (EmpDto) session.getAttribute("login");
        int empNo = dto.getEmpNo();
        
        try {
        	ServletContext context = request.getServletContext();
        	realPath = context.getRealPath(savePath);
        	realPath2 = context.getRealPath(usrImagePath);
        	
        	MultipartRequest multi = new MultipartRequest(request, realPath, maxSize, encType, new DefaultFileRenamePolicy());
        	
        	if(multi.getFilesystemName("file") != null) {
        		String fileName = multi.getFilesystemName("file");
        		String originalFileName = multi.getOriginalFileName("file");
        		int index = originalFileName.indexOf(".");
        		String fileExt = originalFileName.substring(index + 1);
        		
        		String original = realPath + "\\" + fileName;
        		String thumbnail = realPath2 + "\\" + fileName;
        		
        		Thumbnail.createUsrImage(original, thumbnail, fileExt);
        	}
        	
        	String empTel = multi.getParameter("empTel");
        	String empEmail = multi.getParameter("empEmail");
        	
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		forward.setPath("empDetail.do");
		return forward;
	}

}
