package com.source.root.tools.ftp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.log4j.Logger;

/**
 * 列出FTP服务器上指定目录下面的所有文件
 * 
 * @author BenZhou mailto:zhouzb@qq.com
 *         原文地址:http://zhouzaibao.iteye.com/blog/362866
 */
@SuppressWarnings("unused")
public class ReadFTPFilesUtil {
	private static Logger logger = Logger.getLogger(ReadFTPFilesUtil.class);
	public FTPClient ftp;
	public ArrayList<String> arFiles;

	/**
	 * 重载构造函数
	 * 
	 * @param isPrintCommmand
	 *            是否打印与FTPServer的交互命令
	 */
	public ReadFTPFilesUtil(boolean isPrintCommmand) {
		ftp = new FTPClient();
		arFiles = new ArrayList<String>();
		if (isPrintCommmand) {
			ftp.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out)));
		}
	}

	/**
	 * 登陆FTP服务器
	 * 
	 * @param host
	 *            FTPServer IP地址
	 * @param port
	 *            FTPServer 端口
	 * @param username
	 *            FTPServer 登陆用户名
	 * @param password
	 *            FTPServer 登陆密码
	 * @return 是否登录成功
	 * @throws IOException
	 */
	public boolean login(String host, int port, String username, String password) throws IOException {
		this.ftp.connect(host, port);
		if (FTPReply.isPositiveCompletion(this.ftp.getReplyCode())) {
			if (this.ftp.login(username, password)) {
				this.ftp.setControlEncoding("GBK");
				return true;
			}
		}
		if (this.ftp.isConnected()) {
			this.ftp.disconnect();
		}
		return false;
	}

	/**
	 * 关闭数据链接
	 * 
	 * @throws IOException
	 */
	public void disConnection() throws IOException {
		if (this.ftp.isConnected()) {
			this.ftp.disconnect();
		}
	}

	/**
	 * 递归遍历出目录下面所有文件
	 * 
	 * @param pathName
	 *            需要遍历的目录，必须以"/"开始和结束
	 * @throws IOException
	 */
	public void List(String pathName) throws IOException {
		if (pathName.startsWith("/") && pathName.endsWith("/")) {
			String directory = pathName;
			// 更换目录到当前目录
			this.ftp.changeWorkingDirectory(directory);
			FTPFile[] files = this.ftp.listFiles();
			for (FTPFile file : files) {
				if (file.isFile()) {
					arFiles.add(directory + file.getName());
				} else if (file.isDirectory()) {
					List(directory + file.getName() + "/");
				}
			}
		}
	}

	/**
	 * 递归遍历目录下面指定的文件名
	 * 
	 * @param pathName
	 *            需要遍历的目录，必须以"/"开始和结束
	 * @param ext
	 *            文件的扩展名
	 * @throws IOException
	 */
	public void List(String model, String siteAlias, String date, String ext) {
		if (model.startsWith("/") && model.endsWith("/")) {
			String directory = model;
			// 更换目录到当前目录
			try {
				this.ftp.changeWorkingDirectory(directory);
				ftp.enterLocalActiveMode();
				FTPFile[] files = this.ftp.listFiles();
				for (FTPFile file : files) {
					if (file.isFile()) {
						if (file.getName().endsWith(ext)) {
							arFiles.add(directory + file.getName());
						}
					} else if (file.isDirectory()) {
						if (StringUtils.isNotBlank(file.getName()) && !"null".equals(file.getName()) && (file.getName().equals(model) || file.getName().equals(siteAlias) || file.getName().equals(date))) {
							List(directory + file.getName() + "/", siteAlias, date, ext);
						}
					}
				}
			} catch (IOException e) {
				System.out.println("----------------IOException--------------------");
				return;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		ReadFTPFilesUtil f = new ReadFTPFilesUtil(false);
		if (f.login("192.168.190.205", 21, "ftpUser", "111111")) {
			f.List("/picture/", "beijing", "2018-05-26", "jpg");
		}
		f.disConnection();
		Iterator<String> it = f.arFiles.iterator();
		System.out.println("--------------------");
		while (it.hasNext()) {
			String path = it.next();
			String fileName = path.substring(path.lastIndexOf("/") + 1, path.length());
			System.out.println(it.next() + "---------" + fileName);

		}

	}
}