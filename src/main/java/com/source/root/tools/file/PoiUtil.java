package com.source.root.tools.file;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class PoiUtil {
	public static void inputStreamToWord(InputStream is, OutputStream os)
			throws IOException {
		POIFSFileSystem fs = new POIFSFileSystem();
		// 对应于org.apache.poi.hdf.extractor.WordDocument
		fs.createDocument(is, "WordDocument");
		fs.writeFilesystem(os);
		os.close();
		is.close();
	}

	public static void htmlToWord(String input, String wordPath) {
		InputStream is;
		try {
			is = new ByteArrayInputStream(input.getBytes("utf-8"));
			OutputStream os = new FileOutputStream(wordPath);
			inputStreamToWord(is, os);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		String tmp = "<table>  "
				+ " <tr>  <td>中文</td>  <td>中文</td>  <td>中文</td>  <td>中文</td>  </tr>  "
				+ "<tr>  <td>中文</td>  <td>中文</td>  <td>中文</td>  <td>中文</td>  </tr>"

				+ "</table>";
		String content = "<html><head>" + "测试写入word文档" + "</head><body>" + tmp
				+ "</body></html>";
		htmlToWord(content, "d:\\2.xls");
		// InputStream is;
		// try {
		// is = new ByteArrayInputStream(content.getBytes("utf-8"));
		// OutputStream os = new FileOutputStream("d:\\1.doc");
		// inputStreamToWord(is, os);
		// } catch (UnsupportedEncodingException e) {
		// e.printStackTrace();
		// } catch (FileNotFoundException e) {
		// e.printStackTrace();
		// } catch (IOException e) {
		// e.printStackTrace();
		// }

	}

}
