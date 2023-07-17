package edu.kosa.third.service;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import edu.kosa.third.action.Action;
import edu.kosa.third.action.ActionForward;
import edu.kosa.third.utils.Thumbnail;

public class addProductServiceAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
        forward.setRedirect(false);

        String realPath = "";
        String realPath2 = "";
        String savePath = "./images"; // 원본 이미지 저장 경로
        String thumbnailPath = "./thumbnail"; // 썸네일 이미지 저장 경로
        String encType = "UTF-8";
        int maxSize = 1024 * 1024 * 5; //file upload 할 수 있는 최대 file 용량 - 5MB

        try {
        	ServletContext context = request.getServletContext();
        	realPath = context.getRealPath(savePath);
        	realPath2 = context.getRealPath(thumbnailPath);

        	MultipartRequest multi = new MultipartRequest(request, realPath, maxSize, encType, new DefaultFileRenamePolicy());
        	
        	String originalFileName = multi.getOriginalFileName("file");
        	int index = originalFileName.indexOf(".");
        	String fileName = originalFileName.substring(0, index);
        	String fileExt = originalFileName.substring(index + 1);
        	
        	File file = new File(originalFileName);
        	
        	String original = realPath + "\\" + fileName;
        	String thumbnail = realPath2 + "\\" + fileName;
        	
        	Thumbnail.createImage(original, thumbnail, fileExt);
        	
        } catch (Exception e) {
            e.printStackTrace();
        }

        forward.setPath("productList.do");
        return forward;
	}

}
