package com.source.root.framework.template.web.other;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.source.root.tools.format.PinYinUtil;

@Controller
@RequestMapping(value = "/RandomValidateCode")
@SuppressWarnings({ "deprecation" })
public class RandomValidateCode {

	public static final String RANDOMCODEKEY = "RANDOMVALIDATECODEKEY";// 鏀惧埌session涓殑key
	private Random random = new Random();
	private String randString = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";// 闅忔満浜х敓鐨勫瓧绗︿覆

	private int width = 120;// 鍥剧墖瀹�
	private int height = 40;// 鍥剧墖楂�
	private int lineSize = 60;// 骞叉壈绾挎暟閲�
	private int stringNum = 5;// 闅忔満浜х敓瀛楃鏁伴噺

	/*
	 * 鑾峰緱瀛椾綋
	 */
	private Font getFont() {
		return new Font("Fixedsys", Font.CENTER_BASELINE, 25);
	}

	/*
	 * 鑾峰緱棰滆壊
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
	 * 鐢熸垚闅忔満鍥剧墖
	 */
	@RequestMapping(value = "/creat/image")
	public @ResponseBody
	void getRandcode(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		// BufferedImage绫绘槸鍏锋湁缂撳啿鍖虹殑Image绫�Image绫绘槸鐢ㄤ簬鎻忚堪鍥惧儚淇℃伅鐨勭被
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
		Graphics g = image.getGraphics();// 浜х敓Image瀵硅薄鐨凣raphics瀵硅薄,鏀瑰璞″彲浠ュ湪鍥惧儚涓婅繘琛屽悇绉嶇粯鍒舵搷浣�
		g.fillRect(0, 0, width, height);
		g.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 0));
		g.setColor(getRandColor(110, 133));
		// 缁樺埗骞叉壈绾�
		for (int i = 0; i <= lineSize; i++) {
			drowLine(g);
		}
		// 缁樺埗闅忔満瀛楃
		String randomString = "";
		for (int i = 1; i <= stringNum; i++) {
			randomString = drowString(g, randomString, i);
		}
		session.removeAttribute(RANDOMCODEKEY);
		session.setAttribute(RANDOMCODEKEY, randomString);
		g.dispose();
		try {
			ImageIO.write(image, "JPEG", response.getOutputStream());// 灏嗗唴瀛樹腑鐨勫浘鐗囬�杩囨祦鍔ㄥ舰寮忚緭鍑哄埌瀹㈡埛绔�
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * 缁樺埗瀛楃涓�
	 */
	private String drowString(Graphics g, String randomString, int i) {
		g.setFont(getFont());
		g.setColor(new Color(random.nextInt(101), random.nextInt(111), random.nextInt(121)));
		String rand = String.valueOf(getRandomString(random.nextInt(randString.length())));
		randomString += rand;
		g.translate(random.nextInt(3), random.nextInt(3));
		g.drawString(rand, 15 * i, 25);
		return randomString;
	}

	/*
	 * 缁樺埗骞叉壈绾�
	 */
	private void drowLine(Graphics g) {
		int x = random.nextInt(width);
		int y = random.nextInt(height);
		int xl = random.nextInt(13);
		int yl = random.nextInt(15);
		g.drawLine(x, y, x + xl, y + yl);
	}

	/*
	 * 鑾峰彇闅忔満鐨勫瓧绗�
	 */
	public String getRandomString(int num) {
		return String.valueOf(randString.charAt(num));
	}

	/**
	 * Java 本项目使用 图片上传
	 * 
	 * @param imagepath
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws IOException
	 * @throws ParseException
	 */
	@RequestMapping(value = "/image/upload", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String imageUpload(@RequestParam("file") MultipartFile file, HttpServletRequest request,
			HttpServletResponse response, Model model) throws IOException, ParseException {
		int code = -1;
		String msg = "";
		String src = "";
		String title = "";
		String result = "";
		File pic_path = new File(request.getRealPath("") + "/uploadFolder/images");
		if (!pic_path.isDirectory()) {
			pic_path.mkdirs();
		}
		String file_ture_name = PinYinUtil.LowerCase(file.getOriginalFilename());
		src = "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath()
				+ "/uploadFolder/images/" + file_ture_name;

		if (file.getSize() > 10485760) {
			msg = "对不起，上传文件大小不能超过10MB.";
			result = "{\"code\": " + code + " ,\"msg\": \"" + msg + "\",\"data\": {\"src\": \"\",\"title\": \"" + title + "\"}}";
			return result;
		}

		String pic_type = file.getContentType();
		if (pic_type != null && pic_type.isEmpty()) {
			if (pic_type.equals("image/jpeg") || pic_type.endsWith("jpeg") || pic_type.equals("image/jpg")
					|| pic_type.endsWith("jpg") || pic_type.equals("image/png") || pic_type.endsWith("png")
					|| pic_type.equals("image/bmp") || pic_type.endsWith("bmp") || pic_type.equals("image/gif")
					|| pic_type.endsWith("gif")) {
				FileUtils.copyInputStreamToFile(file.getInputStream(), new File(pic_path, file_ture_name));
				code = 0;
				msg = "恭喜您，图片上传成功！";
				result = "{\"code\": " + code + " ,\"msg\": \"" + msg + "\",\"data\": {\"src\": \"" + src
						+ "\",\"title\": \"" + title + "\"}}";
				return result;
			} else {
				msg = "对不起，上传文件格式有误!";
				result = "{\"code\": " + code + " ,\"msg\": \"" + msg + "\",\"data\": {\"src\": \"\",\"title\": \""
						+ title + "\"}}";
				return result;
			}
		} else if (file_ture_name.endsWith("jpeg") || file_ture_name.endsWith("jpg") || file_ture_name.endsWith("png")
				|| file_ture_name.endsWith("bmp") || file_ture_name.endsWith("gif")) {
			FileUtils.copyInputStreamToFile(file.getInputStream(), new File(pic_path, file_ture_name));
			code = 0;
			msg = "恭喜您，图片上传成功！";
			result = "{\"code\": " + code + " ,\"msg\": \"" + msg + "\",\"data\": {\"src\": \"" + src
					+ "\",\"title\": \"" + title + "\"}}";
			return result;
		} else {
			msg = "对不起，上传文件格式有误!";
			result = "{\"code\": " + code + " ,\"msg\": \"" + msg + "\",\"data\": {\"src\": \"\",\"title\": \"" + title
					+ "\"}}";
			return result;
		}

	}
}