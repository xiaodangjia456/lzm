package com.source.root.img.task;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.source.root.framework.comm.pager.Query;
import com.source.root.img.entity.ImgInsect;
import com.source.root.img.service.ImgInsectService;
import com.source.root.img.service.ImgPictureService;
import com.source.root.img.service.ImgSporeService;
import com.source.root.site.entity.Site;
import com.source.root.site.service.SiteService;
import com.source.root.tools.format.DateUtil;
import com.source.root.tools.ftp.ReadFTPFilesUtil;

@SuppressWarnings("unused")
public class TimerReadImgPath {
	public static Logger log = Logger.getLogger(TimerReadImgPath.class);

	@Autowired
	private SiteService siteService;
	@Autowired
	private ImgInsectService imginsectService;
	@Autowired
	private ImgPictureService imgpictureService;
	@Autowired
	private ImgSporeService imgsporeService;

	public void readInsectImgPath() {
		log.error("--------->  读取FTP图片路径  Start");
		String date = DateUtil.dateToString(new Date());
		List<Site> list = siteService.findAll(new Query());
		if (list != null && list.size() > 0) {
			for (Site site : list) {
				String model = "/insect/";
				if (StringUtils.isNotBlank(site.getSiteAlias())) {
					String siteAlias = site.getSiteAlias();
					ReadFTPFilesUtil read = new ReadFTPFilesUtil(false);
					try {
						if (read.login("192.168.3.15", 21, "ftpUser", "111111")) {
							read.List(model, siteAlias, date, "jpg");
						}
						read.disConnection();
					} catch (IOException e) {
						continue;
					}
					List<String> files = read.arFiles;
					if (files != null && files.size() > 0) {
						for (String fp : files) {
							ImgInsect ii = new ImgInsect();
							ii.setCreateTime(new Date()); // 记录时间
							ii.setDeviceId(null); // 设备Id
							ii.setImgDate(date); // 图片日期
							ii.setImgName(fp.substring(fp.lastIndexOf("/") + 1, fp.length())); // 图片名称
							ii.setImgPath(fp); // 图片路径
							ii.setImgType(null); // 图片类型
							ii.setSiteAlias(site.getSiteAlias()); // 站点别名
							ii.setSiteId(site.getId()); // 站点Id
							Query query = new Query();
							query.addAndCondition("siteId", site.getId().toString());
							query.addAndCondition("imgPath", "'" + fp + "'");
							int count = imginsectService.getCountByQuery(query);
							if (count < 1) {
								imginsectService.save(ii);
							}
						}
					}
					read.arFiles.clear();
				}
			}
		}
		log.error("--------->  读取FTP图片路径  End");
	}
}
