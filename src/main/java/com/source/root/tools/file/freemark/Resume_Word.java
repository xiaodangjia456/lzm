package com.source.root.tools.file.freemark;

/**
 * freemarker To Word
 * @author Administrator
 *
 */
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class Resume_Word {

	private static Configuration configuration = null;
	private static Map<String, Template> allTemplate = null;

	public static File createDoc(Map<String,Object> map, String type, HttpServletRequest request) {
		
		String basePath = request.getSession().getServletContext().getRealPath("/");// 绝对路径
		configuration = new Configuration(Configuration.VERSION_2_3_23);
		configuration.setDefaultEncoding("UTF-8");
		//configuration.setClassForTemplateLoading(Resume_Word.class, basePath + "WEB-INF/static/templates/");
		//configuration.setServletContextForTemplateLoading(request.getSession().getServletContext(), "/WEB-INF/static/templates/");
		try {
			configuration.setDirectoryForTemplateLoading(new File(basePath + "WEB-INF/static/templates/"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		allTemplate = new HashMap<String, Template>();
		try {
			allTemplate.put("companyMonth", configuration.getTemplate("companyMonth.ftl"));
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		String name = "temp" + (int) (Math.random() * 100000) + ".doc";
		File f = new File(name);
		Template t = allTemplate.get(type);
		try {
			// 这个地方不能使用FileWriter因为需要指定编码类型否则声场的word文档会因为有无法识别的编码而无法打开
				Writer w = new OutputStreamWriter(new FileOutputStream(f), "utf-8");
				t.process(map, w);
				w.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return f;
	}
}
