package com.source.root.tools.util.image;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageDemo {

	public void binaryImage() throws IOException {
		File file = new File("D:/大昭的孢子程序/站点2孢子图片/2013-09-05/06_45_59.jpg");
		System.out.println(file);
		BufferedImage image = ImageIO.read(file);

		int width = image.getWidth();
		int height = image.getHeight();

		BufferedImage grayImage = new BufferedImage(width, height,
				BufferedImage.TYPE_BYTE_BINARY);
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				int rgb = image.getRGB(i, j);
				grayImage.setRGB(i, j, rgb);
			}
		}

		File newFile = new File("D:/大昭的孢子程序/站点2孢子图片/2013-09-05/06_45_59_.jpg");

		ImageIO.write(grayImage, "jpg", newFile);
	}

	public void grayImage() throws IOException {
		File file = new File("D:/大昭的孢子程序/站点2孢子图片/2013-09-05/06_45_59.jpg");
		BufferedImage image = ImageIO.read(file);

		int width = image.getWidth();
		int height = image.getHeight();

		BufferedImage grayImage = new BufferedImage(width, height,
				BufferedImage.TYPE_BYTE_GRAY);
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				int rgb = image.getRGB(i, j);
				grayImage.setRGB(i, j, rgb);
			}
		}

		File newFile = new File("D:/大昭的孢子程序/站点2孢子图片/2013-09-05/06_45_59__.jpg");
		ImageIO.write(grayImage, "jpg", newFile);
	}

	public static void main(String[] args) throws IOException {
		ImageDemo demo = new ImageDemo();
		demo.binaryImage();
		demo.grayImage();
	}

}