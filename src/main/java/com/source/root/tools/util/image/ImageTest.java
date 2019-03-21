package com.source.root.tools.util.image;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.*;

public class ImageTest {
	
	public static void main(String args[]) {
		int[] rgb = new int[3];

		File file = new File("D:/大昭的孢子程序/站点2孢子图片/2013-09-05/06_45_59.jpg");
		BufferedImage bi = null;
		try {
			bi = ImageIO.read(file);
		} catch (Exception e) {
			e.printStackTrace();
		}

		int width = bi.getWidth();
		int height = bi.getHeight();
		int minx = bi.getMinX();
		int miny = bi.getMinY();
		System.out.println("width=" + width + ",height=" + height + ".");
		System.out.println("minx=" + minx + ",miniy=" + miny + ".");

		int a = 0;
		int b = 0;
		int c = 0;
		int s = 0;
		int s1 = 0;
		for (int i = minx; i < width; i++) {
			for (int j = miny; j < height; j++) {
				// System.out.print(bi.getRGB(jw, ih));
				int pixel = bi.getRGB(i, j);
				rgb[0] = (pixel & 0xff0000) >> 16;
				rgb[1] = (pixel & 0xff00) >> 8;
				rgb[2] = (pixel & 0xff);
				if (a < rgb[0]) {
					a = rgb[0];
				}
				if (b < rgb[1]) {
					b = rgb[1];
				}
				if (c < rgb[2]) {
					c = rgb[2];
				}
				if (rgb[0] < 90 && rgb[1] < 110 && rgb[2] < 160 && rgb[0] > 70
						&& rgb[1] > 71 && rgb[2] > 90) {
					System.out.println("i=" + i + ",j=" + j + ":(" + rgb[0]
							+ "," + rgb[1] + "," + rgb[2] + ")" + s1);
					s1++;
				}
				s++;
			}
		}
		System.out
				.println("(" + rgb[0] + "," + rgb[1] + "," + rgb[2] + ")" + s);

	}
}
