package com.source.root.tools.file;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RandomValidateCode {

	public static final String RANDOMCODEKEY = "RANDOMVALIDATECODEKEY";// 閺�儳鍩宻ession娑擃厾娈慿ey
	private Random random = new Random();
	private String randString = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";// 闂呭繑婧�禍褏鏁撻惃鍕摟缁楋缚瑕�

	private int width = 80;// 閸ュ墽澧栫�锟�
	private int height = 26;// 閸ュ墽澧栨锟�
	private int lineSize = 40;// 楠炲弶澹堢痪鎸庢殶闁诧拷
	private int stringNum = 4;// 闂呭繑婧�禍褏鏁撶�妤冾儊閺佷即鍣�

	/*
	 * 閼惧嘲绶辩�妞剧秼
	 */
	private Font getFont() {
		return new Font("Fixedsys", Font.CENTER_BASELINE, 18);
	}

	/*
	 * 閼惧嘲绶辨０婊嗗
	 */
	private Color getRandColor(int fc, int bc) {
		if (fc > 255)
			fc = 255;
		if (bc > 255)
			bc = 255;
		int r = fc + random.nextInt(bc - fc - 16);
		int g = fc + random.nextInt(bc - fc - 14);
		int b = fc + random.nextInt(bc - fc - 18);
		return new Color(r, g, b);
	}

	/**
	 * 閻㈢喐鍨氶梾蹇旀簚閸ュ墽澧�
	 */
	public void getRandcode(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		// BufferedImage缁粯妲搁崗閿嬫箒缂傛挸鍟块崠铏规畱Image缁拷Image缁粯妲搁悽銊ょ艾閹诲繗鍫崶鎯у剼娣団剝浼呴惃鍕
		BufferedImage image = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_BGR);
		Graphics g = image.getGraphics();// 娴溠呮晸Image鐎电钖勯惃鍑aphics鐎电钖�閺�懓顕挒鈥冲讲娴犮儱婀崶鎯у剼娑撳﹨绻樼悰灞芥倗缁夊秶绮崚鑸垫惙娴ｏ拷
		g.fillRect(0, 0, width, height);
		g.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 18));
		g.setColor(getRandColor(110, 133));
		// 缂佹ê鍩楅獮鍙夊缁撅拷
		for (int i = 0; i <= lineSize; i++) {
			drowLine(g);
		}
		// 缂佹ê鍩楅梾蹇旀簚鐎涙顑�
		String randomString = "";
		for (int i = 1; i <= stringNum; i++) {
			randomString = drowString(g, randomString, i);
		}
		session.removeAttribute(RANDOMCODEKEY);
		session.setAttribute(RANDOMCODEKEY, randomString);
		System.out.println(randomString);
		g.dispose();
		try {
			ImageIO.write(image, "JPEG", response.getOutputStream());// 鐏忓棗鍞寸�妯硅厬閻ㄥ嫬娴橀悧鍥拷鏉╁洦绁﹂崝銊ヨ埌瀵繗绶崙鍝勫煂鐎广垺鍩涚粩锟�
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/*
	 * 缂佹ê鍩楃�妤冾儊娑擄拷
	 */
	private String drowString(Graphics g, String randomString, int i) {
		g.setFont(getFont());
		g.setColor(new Color(random.nextInt(101), random.nextInt(111), random
				.nextInt(121)));
		String rand = String.valueOf(getRandomString(random.nextInt(randString
				.length())));
		randomString += rand;
		g.translate(random.nextInt(3), random.nextInt(3));
		g.drawString(rand, 13 * i, 16);
		return randomString;
	}

	/*
	 * 缂佹ê鍩楅獮鍙夊缁撅拷
	 */
	private void drowLine(Graphics g) {
		int x = random.nextInt(width);
		int y = random.nextInt(height);
		int xl = random.nextInt(13);
		int yl = random.nextInt(15);
		g.drawLine(x, y, x + xl, y + yl);
	}

	/*
	 * 閼惧嘲褰囬梾蹇旀簚閻ㄥ嫬鐡х粭锟�
	 */
	public String getRandomString(int num) {
		return String.valueOf(randString.charAt(num));
	}
}