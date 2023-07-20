package edu.kosa.third.service;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import edu.kosa.third.action.Action;
import edu.kosa.third.action.ActionForward;
import edu.kosa.third.dao.UsrInfoDao;
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
        	String fileName = "";
        	
        	if(multi.getFilesystemName("file") != null) {
        		fileName = multi.getFilesystemName("file");
        		String originalFileName = multi.getOriginalFileName("file");
        		int index = originalFileName.indexOf(".");
        		String fileExt = originalFileName.substring(index + 1);
        		
        		String original = realPath + "\\" + fileName;
        		String thumbnail = realPath2 + "\\" + fileName;
        		
        		Thumbnail.createUsrImage(original, thumbnail, fileExt);
        	}
        	
        	String deleteOriginal = realPath + "\\" + fileName;
        	File deleteFile = new File(deleteOriginal);
        	if(deleteFile.exists() && deleteFile.isFile()) {
        		deleteFile.delete();
        	}
        	
        	if(fileName.equals("")) {
        		fileName = dto.getImagePath();
        	}
        	
        	String empTel = multi.getParameter("empTel");
        	String empEmail = multi.getParameter("empEmail");
        	String empAddr = multi.getParameter("sample6_address") + " " + multi.getParameter("sample6_detailAddress");
        	
        	String saveImage = usrImagePath + "/" + fileName;
        	
        	String beforeImg = dto.getImagePath().substring(9);
        	if(beforeImg.equals("usericon.png")) {
        		beforeImg = "";
        	}
        	
        	String deleteImg = realPath2 + "\\" + beforeImg;
        	File deleteImage = new File(deleteImg);
        	if(deleteImage.exists() && deleteImage.isFile()) {
        		deleteImage.delete();
        	}
        	
        	UsrInfoDao dao = new UsrInfoDao();
        	
        	dto.setEmpTel(empTel);
        	dto.setEmpEmail(empEmail);
        	dto.setEmpAddr(empAddr);
        	dto.setImagePath(saveImage);
        	
        	dao.updateEmpInfo(dto);
        	
        	session.setAttribute("login", dto);
        	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		forward.setPath("empDetail.do");
		return forward;
	}

}
