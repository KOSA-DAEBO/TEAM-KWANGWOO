package edu.kosa.third.utils;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class Thumbnail {

	public static void createImage(String loadFile, String saveFile, String fileExt) throws Exception {

		File save = new File(saveFile); // 썸네일 이미지

		// loadFile은 원본이미지 파일
		BufferedImage im = ImageIO.read(new File(loadFile));

		int width = 90; // 축소
		int height = 90;

		// 메모리에 이미지 공간을 생성
		BufferedImage thumb = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

		Graphics2D g2 = thumb.createGraphics();

		// 메모리의 이미지 공간에 원본 이미지를 width, height 크기로 구한다.
		// 실제로 그려주는 부분
		g2.drawImage(im, 0, 0, width, height, null);
		ImageIO.write(thumb, fileExt.toUpperCase(), save); // 메모리에 그린 이미지를 파일로 저장
	}
}
