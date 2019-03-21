package com.source.root.tools.format;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

/**
 * @ClassName: PinYin
 * @Description: TODO(杩欓噷鐢ㄤ竴鍙ヨ瘽鎻忚堪杩欎釜绫荤殑浣滅敤)
 * @author MR.Guo xiaodangjia456@163.com
 * @date 2014骞�鏈�3鏃�涓嬪崍3:27:22 鎿庡ぉ -->鏉庡コ澹細15539238989
 */
public class PinYinUtil {

	private static PinYinUtil pinyin;

	private static HanyuPinyinOutputFormat hypyFormat = new HanyuPinyinOutputFormat();

	/**
	 * @Title: getInstance
	 * @Description: TODO
	 * @return: PinYin
	 */
	public static PinYinUtil getInstance() {
		if (pinyin == null) {
			synchronized (pinyin) {
				if (pinyin == null) {
					pinyin = new PinYinUtil();
				}
			}
		}
		return pinyin;
	}

	/**
	 * 杩斿洖灏忓啓鎷奸煶
	 * 
	 * @param name
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public static String LowerCase(String name) {
		hypyFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
		hypyFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
		String result = "";
		try {
			result = PinyinHelper.toHanyuPinyinString(name, hypyFormat, "");
		} catch (BadHanyuPinyinOutputFormatCombination e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 杩斿洖澶у啓鎷奸煶
	 * 
	 * @param name
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public static String UpperCase(String name) {
		hypyFormat.setCaseType(HanyuPinyinCaseType.UPPERCASE);
		hypyFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
		String result = "";
		try {
			result = PinyinHelper.toHanyuPinyinString(name, hypyFormat, "");
		} catch (BadHanyuPinyinOutputFormatCombination e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * @param args
	 */
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// hypyFormat.setVCharType(HanyuPinyinVCharType.WITH_U_UNICODE);
		String a = LowerCase("娴嬭瘯鎷奸煶");
		String b = UpperCase("娴嬭瘯鎷奸煶");
		try {
			System.out.println(PinyinHelper.toHanyuPinyinString("娴嬭瘯鎷奸煶",
					hypyFormat, "-"));
		} catch (BadHanyuPinyinOutputFormatCombination e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		System.out.println(a);
		System.out.println(b);
	}

}
