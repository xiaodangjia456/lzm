package com.source.root.tools.file;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.hssf.util.HSSFColor;

@SuppressWarnings({ "deprecation", "resource" })
public class ExcelFileOutUtil {

	// private static Logger logger = Logger.getLogger(ExcelFileOutUtil.class);

	public static String xlsFile = "C:/test.xls"; // 浜х敓鐨凟xcel鏂囦欢鐨勫悕绉�

	private static List<String[]> list = null;

	public static List<String[]> creatList() {
		list = new ArrayList<String[]>();
		String[] arr = null;
		for (int i = 0; i < 10; i++) {
			arr = new String[] { "A" + i, "B" + i, "C" + i, "D" + i, "E" + i };
			list.add(arr);
		}
		return list;
	}

	public static void creatXLS(List<String[]> list, String fileName) {
		try {
			HSSFWorkbook workbook = new HSSFWorkbook(); // 浜х敓宸ヤ綔绨垮璞�
			HSSFSheet sheet = workbook.createSheet(); // 浜х敓宸ヤ綔琛ㄥ璞�
			sheet.setDefaultRowHeight((short) 400);
			sheet.setDefaultColumnWidth(10);
			// 璁剧疆绗竴涓伐浣滆�?鐨勫悕绉颁负firstSheet
			// 涓轰簡宸ヤ綔琛ㄨ兘鏀寔涓枃锛岃缃瓧绗︾紪鐮佷负UTF_16
			workbook.setSheetName(0, "Sheet1");
			for (int i = 0; i < list.size(); i++) {
				// 浜х敓涓��?
				HSSFRow row = sheet.createRow((short) i);
				for (int j = 0; j < list.get(0).length; j++) {
					// if (j == 1) {
					// sheet.setColumnWidth(j, 600*30);
					// }
					// 浜х敓绗竴涓崟鍏冩�?
					HSSFCell cell = row.createCell((short) j);
					// 寰�涓�釜鍗曞厓鏍间腑鍐欏叆淇℃伅
					cell.setCellValue(list.get(i)[j]);
				}
			}
			// 杈撳嚭娴�?
			FileOutputStream fOut = new FileOutputStream(fileName);
			workbook.write(fOut);
			fOut.flush();
			fOut.close();
			// logger.info("鏂囦欢鐢熸垚鎴愬姛锛�?;
		} catch (Exception e) {
			// logger.error("鏂囦欢鐢熸垚澶辫触锛�?+ e);
		}
	}

	/**
	 * 固定第一列（每三行一合并）
	 * 
	 * @param list
	 * @param fileName
	 */
	public static void creatXLS_Region(List<String[]> list, String fileName) {
		try {
			HSSFWorkbook workbook = new HSSFWorkbook(); // 浜х敓宸ヤ綔绨垮璞�
			HSSFSheet sheet = workbook.createSheet(); // 浜х敓宸ヤ綔琛ㄥ璞�
			sheet.setDefaultRowHeight((short) 600);
			sheet.setDefaultColumnWidth(20);

			HSSFCellStyle centerstyle = workbook.createCellStyle();
			centerstyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 左右居中
			centerstyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 上下居中
			// 璁剧疆绗竴涓伐浣滆�?鐨勫悕绉颁负firstSheet
			// 涓轰簡宸ヤ綔琛ㄨ兘鏀寔涓枃锛岃缃瓧绗︾紪鐮佷负UTF_16
			workbook.setSheetName(0, "Sheet1");
			int regionIndex = 0;
			for (int i = 0; i < list.size(); i++) {
				regionIndex = regionIndex + 3;
				HSSFRow row;
				if (i < list.size() / 3) {
					CellRangeAddress range = new CellRangeAddress(i * 3 + 1, regionIndex, 0, 0);
					sheet.addMergedRegion(range);
				}
				row = sheet.createRow((short) i);
				for (int j = 0; j < list.get(0).length; j++) {
					// 浜х敓绗竴涓崟鍏冩�?
					HSSFCell cell = row.createCell((short) j);
					if (j == 0) {
						cell.setCellStyle(centerstyle);
					}
					// 寰�涓�釜鍗曞厓鏍间腑鍐欏叆淇℃伅
					cell.setCellValue(list.get(i)[j]);
				}
			}
			// 杈撳嚭娴�?
			FileOutputStream fOut = new FileOutputStream(fileName);
			workbook.write(fOut);
			fOut.flush();
			fOut.close();
			// logger.info("鏂囦欢鐢熸垚鎴愬姛锛�?;
		} catch (Exception e) {
			// logger.error("鏂囦欢鐢熸垚澶辫触锛�?+ e);
		}
	}

	public static void creatXLS_TradeWeekTotal(List<String[]> list, String fileName) {
		try {
			HSSFWorkbook workbook = new HSSFWorkbook(); // 浜х敓宸ヤ綔绨垮璞�
			HSSFSheet sheet = workbook.createSheet(); // 浜х敓宸ヤ綔琛ㄥ璞�
			sheet.setDefaultRowHeight((short) 800);
			sheet.setDefaultColumnWidth(5);
			sheet.setColumnWidth(0, 15000);
			sheet.setColumnWidth(1, 4000);
			sheet.setColumnWidth(2, 4000);
			sheet.setColumnWidth(3, 6000);
			sheet.setColumnWidth(4, 4000);

			HSSFCellStyle centerstyle = workbook.createCellStyle();
			centerstyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 左右居中
			centerstyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 上下居中
			// 璁剧疆绗竴涓伐浣滆�?鐨勫悕绉颁负firstSheet
			// 涓轰簡宸ヤ綔琛ㄨ兘鏀寔涓枃锛岃缃瓧绗︾紪鐮佷负UTF_16
			workbook.setSheetName(0, "出口企业");
			for (int i = 0; i < list.size(); i++) {
				HSSFRow row;
				if (i == 0 || i == 1) {
					CellRangeAddress range = new CellRangeAddress(i, i, 0, 4);
					sheet.addMergedRegion(range);
				}
				row = sheet.createRow((short) i);
				for (int j = 0; j < list.get(i).length; j++) {
					HSSFCell cell = row.createCell((short) j);
					// 设置行高
					row.setHeight((short) 600);
					// 设置字体
					HSSFFont contentfont = workbook.createFont();
					contentfont.setFontName("宋体");
					contentfont.setFontHeightInPoints((short) 14);// 字体大小
					HSSFCellStyle contentStyle = workbook.createCellStyle();
					if (j == 0) {
						if(i==list.size()-1){
							contentStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 左右居中
						}else{
							contentStyle.setAlignment(HSSFCellStyle.ALIGN_LEFT);// 左右居中
						}
					} else {
						contentStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 左右居中
					}
					contentStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 上下居中
					//contentStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN); // 设置单元格的边框为粗体
					contentStyle.setTopBorderColor(HSSFColor.BLACK.index);
					contentStyle.setBorderTop((short) 1);
					contentStyle.setLeftBorderColor(HSSFColor.BLACK.index);
					contentStyle.setBorderLeft((short) 1);
					contentStyle.setRightBorderColor(HSSFColor.BLACK.index);
					contentStyle.setBorderRight((short) 1);
					contentStyle.setBottomBorderColor(HSSFColor.BLACK.index);
					contentStyle.setBorderBottom((short) 1);
					contentStyle.setFont(contentfont);
					if (list.get(i).length <= 1) {
						if (i == 0 || i == 1) {
							HSSFFont headfont = workbook.createFont();
							if (i == 0) {
								// 设置行高
								row.setHeight((short) 1200);
								// 设置字体
								headfont.setFontName("宋体");
								headfont.setFontHeightInPoints((short) 20);// 字体大小
								headfont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);// 加粗
								HSSFCellStyle titleStyle = workbook.createCellStyle();
								titleStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 左右居中
								titleStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 上下居中
								//titleStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN); // 设置单元格的边框为粗体
								titleStyle.setBottomBorderColor(HSSFColor.BLACK.index);
								titleStyle.setBorderBottom((short) 1);
								titleStyle.setFont(headfont);
								cell.setCellStyle(titleStyle);
							}else{
								contentStyle.setTopBorderColor(HSSFColor.BLACK.index);
								contentStyle.setBorderTop((short) 1);
								contentStyle.setAlignment(HSSFCellStyle.ALIGN_RIGHT);// 左右居中
								cell.setCellStyle(contentStyle);
							}
						}
					} else {
						cell.setCellStyle(contentStyle);
					}
					// 寰�涓�釜鍗曞厓鏍间腑鍐欏叆淇℃伅
					cell.setCellValue(list.get(i)[j]);
				}
			}
			// 杈撳嚭娴�?
			FileOutputStream fOut = new FileOutputStream(fileName);
			workbook.write(fOut);
			fOut.flush();
			fOut.close();
			// logger.info("鏂囦欢鐢熸垚鎴愬姛锛�?;
		} catch (Exception e) {
			// logger.error("鏂囦欢鐢熸垚澶辫触锛�?+ e);
		}
	}

	public static void main(String args[]) {
		creatXLS(creatList(), xlsFile);
		// creatXLS_Region(creatList(), xlsFile);
	}
}
