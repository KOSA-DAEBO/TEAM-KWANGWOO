package edu.kosa.third.service;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import edu.kosa.third.action.Action;
import edu.kosa.third.action.ActionForward;
import edu.kosa.third.dao.ProductDao;
import edu.kosa.third.dto.PIMappingDto;
import edu.kosa.third.dto.ProductDto;
import edu.kosa.third.utils.Thumbnail;

public class UpdateProductServiceAction implements Action {

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
        int productNo = 0;
        
        try {
        	ServletContext context = request.getServletContext();
        	realPath = context.getRealPath(savePath);
        	realPath2 = context.getRealPath(thumbnailPath);
        	
        	MultipartRequest multi = new MultipartRequest(request, realPath, maxSize, encType, new DefaultFileRenamePolicy());
        	
        	String fileName = multi.getFilesystemName("file");
        	String originalFileName = multi.getOriginalFileName("file");
        	int index = originalFileName.indexOf(".");
        	String fileExt = originalFileName.substring(index + 1);
        	
        	String original = realPath + "\\" + fileName;
        	String thumbnail = realPath2 + "\\" + fileName;
        	
        	Thumbnail.createImage(original, thumbnail, fileExt);
        	
        	productNo = Integer.parseInt(multi.getParameter("productNo"));
        	String productName = multi.getParameter("productName");
        	String[] values = multi.getParameterValues("updateSelectContent");
        	String saveImage = savePath + "/" + fileName;
        	String saveThumbImage = thumbnailPath + "/" + fileName;
        	
        	ProductDao dao = new ProductDao();
        	ProductDto pDto = dao.selectProduct(productNo);
        	
        	String beforeImg = pDto.getImagePath().substring(9);
        	String beforeThumbnail = pDto.getThumbnailPath().substring(12);
        	
        	String deleteImg = realPath + "\\" + beforeImg;
        	String deleteThumbnail = realPath2 + "\\" + beforeThumbnail;
        	
        	File deleteImage = new File(deleteImg);
        	File deleteThumbImg = new File(deleteThumbnail);
        	
        	if(deleteImage.exists() && deleteImage.isFile()) {
        		deleteImage.delete();
        	}
        	if(deleteThumbImg.exists() && deleteThumbImg.isFile()) {
        		deleteThumbImg.delete();
        	}
        	
        	dao.updateProduct(new ProductDto(productNo, productName, saveImage, saveThumbImage));
        	
        	ArrayList<PIMappingDto> dtos = dao.getMapping(productNo);
        	
        	dao.updatePIMapping(dtos, values);
		} catch (Exception e) {
			e.printStackTrace();
		}
        
        forward.setPath("detailProduct.do?productNo=" + productNo);
		return forward;
	}

}
