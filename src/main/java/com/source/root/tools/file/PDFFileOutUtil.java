package com.source.root.tools.file;

/**
 * IText说明

 iText �?Lowagie.com 站点（请参阅 参�?资料）免费提供的 Java 库�?
 iText 库的功能很强大，支持 HTML、RTF �?XML 文档的生成，此外还能够生�?PDF 文档�?
 可以从多种字体中选择文档中所使用的字体�?
 同时，iText 的结构允许使用相同的代码生成以上任意类型的文档�?
 http://itextpdf.com/官网
 http://sourceforge.net/projects/itext/files/源码
 * iText API�?
 com.lowagie.text.Document 是生�?PDF 的主要的类�?它是�?��使用的第�?��类�?�?���?��创建文档，将�?���?��写入器向文档中写入内容�?
 com.lowagie.text.pdf.PdfWriter 就是�?�� PDF 写入器�?下面列出了�?常需要使用的类：
 com.lowagie.text.Paragraph —�? 这个类表示一个缩进的段落�?
 com.lowagie.text.Chapter —�? 这个类表�?PDF 文档中的章节。使�?Paragraph 作为题目并使�?int 作为章节号码来创建它�?
 com.lowagie.text.Font —�? 这个类包含了全部的字体规范，例如字体、大小�?样式和颜色�?各种字体都在这个类中声明为静态常数�?
 com.lowagie.text.List —�? 这个类表示一个列表，按顺序包含许�?ListItems�?
 com.lowagie.text.Table —�? 这个类表示包含单元格的表，单元格有序地排列在矩阵中�?
 */
import java.awt.Color;
import java.io.FileOutputStream;
import java.io.IOException;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class PDFFileOutUtil {

	/**
	 * 生成PDF的方�?
	 * 
	 * @return boolean
	 */
	public static boolean createPDF(String pdfPath) {

		Document document = new Document();// 建立�?��Document对象
		document.setPageSize(PageSize.A4);// 设置页面大小
		try {
			PdfWriter.getInstance(document, new FileOutputStream(pdfPath));// 建立�?��PdfWriter对象
			document.open();
			// BaseFont bfChinese = BaseFont.createFont("STSong-Light",
			// "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);// 设置中文字体
			BaseFont bfChinese = BaseFont.createFont(
					"c:\\windows\\fonts\\simkai.ttf", BaseFont.IDENTITY_H,
					BaseFont.EMBEDDED);
			@SuppressWarnings("unused")
			Font titleFont = new Font(bfChinese, 15, Font.BOLD);// 设置字体大小
			Font headFont = new Font(bfChinese, 10, Font.BOLD);// 设置字体大小
			// Font headFont1 = new Font(bfChinese, 10, Font.BOLD);// 设置字体大小
			// Font headFont2 = new Font(bfChinese, 10, Font.NORMAL);// 设置字体大小
			Font headFont3 = new Font(bfChinese, 10, Font.NORMAL, new Color(
					255, 0, 0));// 设置字体大小
			document.add(new Paragraph("标题", headFont));
			float[] widths = { 140f, 60f, 320f, 120f, 110f, 110f, 190f };// 设置表格的列�?
			PdfPTable table = new PdfPTable(widths);// 建立�?��pdf表格
			table.setSpacingBefore(30f);// 设置表格上面空白宽度
			table.setTotalWidth(535);// 设置表格的宽�?
			table.setLockedWidth(true);// 设置表格的宽度固�?
			table.getDefaultCell().setBorder(1);// 设置表格默认为边�?
			PdfPCell cell = new PdfPCell(new Paragraph("Taony125 testPdf 中文字体",
					headFont));// 建立�?��单元�?
			cell.setBorderColor(new Color(255, 0, 0));
			// cell.setBorderColorBottom(new Color(255, 0, 0));
			// cell.setBorderColorLeft(new Color(255, 0, 0));
			// cell.setBorderColorRight(new Color(255, 0, 0));
			// cell.setBorderColorTop(new Color(255, 0, 0));
			// cell.setBorder(1);// 设置单元格无边框
			cell.setColspan(2);// 设置合并单元格的列数
			table.addCell(cell);// 增加单元�?
			cell = new PdfPCell(
					new Paragraph("Taony125 testPdf 中文字体", headFont));
			// // cell.setBorder(0);
			// cell.setFixedHeight(20);
			cell.setColspan(2);// 设置合并单元格的列数
			// cell.setHorizontalAlignment(Element.ALIGN_CENTER);// 设置内容水平居中显示
			// cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(cell);
			cell = new PdfPCell(new Paragraph("Taony125 testPdf 中文字体",
					headFont3));
			// // cell.setBorder(0);
			// cell.setFixedHeight(20);
			cell.setColspan(3);// 设置合并单元格的列数
			// cell.setHorizontalAlignment(Element.ALIGN_CENTER);// 设置内容水平居中显示
			// cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(cell);
			// table.addCell(new Paragraph("Taony125 testPdf 中文字体", headFont2));
			document.add(table);
			Image image = Image
					.getInstance("C:/Users/Administrator/Desktop/snyq_03.jpg");
			// image.scaleAbsolute(300, 300);
			image.scalePercent(50); // 原图片大小的百分�?
			System.out.println(image.getWidth());
			document.add(image);

		} catch (DocumentException de) {
			System.err.println(de.getMessage());
			return false;
		} catch (IOException ioe) {
			System.err.println(ioe.getMessage());
			return false;
		}
		document.close();
		return true;

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// // step 1: creation of a document-object
		// Document document = new Document();
		// try {
		// // step 2:
		// // we create a writer that listens to the document
		// // and directs a PDF-stream to a file
		// PdfWriter.getInstance(document, new FileOutputStream(
		// "D:\\ChinesePDF005_" + new java.util.Date().getTime()
		// + ".pdf"));
		// // step 3: we open the document
		// document.open();
		// // step 4: we add content to the document
		// // 楷体�?
		// BaseFont bfComic = BaseFont.createFont(
		// "c:\\windows\\fonts\\simkai.ttf", BaseFont.IDENTITY_H,
		// BaseFont.NOT_EMBEDDED);
		// // 方正舒体
		// BaseFont bfComic2 = BaseFont.createFont(
		// "c:\\windows\\fonts\\FZSTK.TTF", BaseFont.IDENTITY_H,
		// BaseFont.NOT_EMBEDDED);
		// // 方正姚体
		// BaseFont bfComic3 = BaseFont.createFont(
		// "c:\\windows\\fonts\\FZYTK.TTF", BaseFont.IDENTITY_H,
		// BaseFont.NOT_EMBEDDED);
		// // 仿宋�?
		// BaseFont bfComic4 = BaseFont.createFont(
		// "c:\\windows\\fonts\\SIMFANG.TTF", BaseFont.IDENTITY_H,
		// BaseFont.NOT_EMBEDDED);
		// // 黑体
		// BaseFont bfComic5 = BaseFont.createFont(
		// "c:\\windows\\fonts\\SIMHEI.TTF", BaseFont.IDENTITY_H,
		// BaseFont.NOT_EMBEDDED);
		// // 华文彩云
		// BaseFont bfComic6 = BaseFont.createFont(
		// "c:\\windows\\fonts\\STCAIYUN.TTF", BaseFont.IDENTITY_H,
		// BaseFont.NOT_EMBEDDED);
		// // 华文仿宋
		// BaseFont bfComic7 = BaseFont.createFont(
		// "c:\\windows\\fonts\\STFANGSO.TTF", BaseFont.IDENTITY_H,
		// BaseFont.NOT_EMBEDDED);
		// // 华文细黑
		// BaseFont bfComic8 = BaseFont.createFont(
		// "c:\\windows\\fonts\\STXIHEI.TTF", BaseFont.IDENTITY_H,
		// BaseFont.NOT_EMBEDDED);
		// // 华文新魏
		// BaseFont bfComic9 = BaseFont.createFont(
		// "c:\\windows\\fonts\\STXINWEI.TTF", BaseFont.IDENTITY_H,
		// BaseFont.NOT_EMBEDDED);
		// // 华文行楷
		// BaseFont bfComic0 = BaseFont.createFont(
		// "c:\\windows\\fonts\\STXINGKA.TTF", BaseFont.IDENTITY_H,
		// BaseFont.NOT_EMBEDDED);
		// // 华文中宋
		// BaseFont bfComic99 = BaseFont.createFont(
		// "c:\\windows\\fonts\\STZHONGS.TTF", BaseFont.IDENTITY_H,
		// BaseFont.NOT_EMBEDDED);
		// // 隶书
		// BaseFont bfComic11 = BaseFont.createFont(
		// "c:\\windows\\fonts\\SIMLI.TTF", BaseFont.IDENTITY_H,
		// BaseFont.NOT_EMBEDDED);
		// // 幼圆
		// BaseFont bfComic14 = BaseFont.createFont(
		// "c:\\windows\\fonts\\SIMYOU.TTF", BaseFont.IDENTITY_H,
		// BaseFont.NOT_EMBEDDED);
		// Font font = new Font(bfComic11, 14);
		// String text1 =
		// "啊发生的发球特工是大哥是法国时的风格是This is the quite popular True Type font (繁體字測試VS�?��字测�? ==>"
		// + new java.util.Date();
		// document.add(new Paragraph(text1, font));
		// Font headFont = new Font(bfComic11, 14);// 设置字体大小
		// Font headFont1 = new Font(bfComic11, 1);// 设置字体大小
		// Font headFont2 = new Font(bfComic11, 14);// 设置字体大小
		// float[] widths = { 140f, 60f, 320f, 120f, 110f, 110f, 190f };//
		// 设置表格的列�?
		// PdfPTable table = new PdfPTable(widths);// 建立�?��pdf表格
		// table.setSpacingBefore(20f);// 设置表格上面空白宽度
		// table.setTotalWidth(535);// 设置表格的宽�?
		// table.setLockedWidth(true);// 设置表格的宽度固�?
		// table.getDefaultCell().setBorder(1);// 设置表格默认为边�?
		// PdfPCell cell = new PdfPCell(new Paragraph("Taony125 testPdf 中文字体",
		// headFont));// 建立�?��单元�?
		// // cell.setBorder(0);//设置单元格无边框
		// // cell.setColspan(7);// 设置合并单元格的列数
		// table.addCell(cell);// 增加单元�?
		// cell = new PdfPCell(
		// new Paragraph("Taony125 testPdf 中文字体", headFont));
		// // cell.setBorder(0);
		// cell.setFixedHeight(20);
		// cell.setColspan(7);// 设置合并单元格的列数
		// cell.setHorizontalAlignment(Element.ALIGN_CENTER);// 设置内容水平居中显示
		// cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		// table.addCell(cell);
		// cell = new PdfPCell(new Paragraph("Taony125 testPdf 中文字体",
		// headFont1));
		// // cell.setBorder(0);
		// cell.setFixedHeight(20);
		// // cell.setColspan(7);// 设置合并单元格的列数
		// cell.setHorizontalAlignment(Element.ALIGN_CENTER);// 设置内容水平居中显示
		// cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		// table.addCell(cell);
		// table.addCell(new Paragraph("Taony125 testPdf 中文字体", headFont2));
		// document.add(table);
		// } catch (DocumentException de) {
		// System.err.println(de.getMessage());
		// } catch (IOException ioe) {
		// System.err.println(ioe.getMessage());
		// }
		// // step 5: we close the document
		// document.close();
		// System.out.println(">>> Export : " + "D:\\ChinesePDF005__.pdf");
		PDFFileOutUtil.createPDF("D:\\ChinesePDF005_.pdf");
	}
}