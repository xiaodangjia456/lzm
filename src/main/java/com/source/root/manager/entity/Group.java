package com.source.root.manager.entity;

public class Group {
	// private static final long serialVersionUID = 5454155825314635342L;

	// alias
	public static final String TABLE_ALIAS = "Group";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_GROUP_CODE = "groupCode";
	public static final String ALIAS_GROUP_NAME = "groupName";
	public static final String ALIAS_INHERIT_CODE = "inheritCode";
	public static final String ALIAS_SORT_NUM = "sortNum";
	public static final String ALIAS_AREA_ID = "areaId";
	public static final String ALIAS_LEVELS = "levels";

	// 可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	// columns START
	//

	private java.lang.Long id;
	// @Length(max=20)

	private java.lang.String groupCode;
	// @Length(max=20)

	private java.lang.String groupName;
	//

	private java.lang.Long inheritCode;
	//

	private java.lang.Integer sortNum;
	//

	private java.lang.Integer areaId;
	//

	private java.lang.Integer levels;

	// columns END

	public Group() {
	}

	public Group(java.lang.Long id) {
		this.id = id;
	}

	public void setId(java.lang.Long id) {
		this.id = id;
	}

	public java.lang.Long getId() {
		return this.id;
	}

	public void setGroupCode(java.lang.String groupCode) {
		this.groupCode = groupCode;
	}

	public java.lang.String getGroupCode() {
		return this.groupCode;
	}

	public void setGroupName(java.lang.String groupName) {
		this.groupName = groupName;
	}

	public java.lang.String getGroupName() {
		return this.groupName;
	}

	public void setInheritCode(java.lang.Long inheritCode) {
		this.inheritCode = inheritCode;
	}

	public java.lang.Long getInheritCode() {
		return this.inheritCode;
	}

	public void setSortNum(java.lang.Integer sortNum) {
		this.sortNum = sortNum;
	}

	public java.lang.Integer getSortNum() {
		return this.sortNum;
	}

	public void setAreaId(java.lang.Integer areaId) {
		this.areaId = areaId;
	}

	public java.lang.Integer getAreaId() {
		return this.areaId;
	}

	public void setLevels(java.lang.Integer levels) {
		this.levels = levels;
	}

	public java.lang.Integer getLevels() {
		return this.levels;
	}

	public String getJson() {
		String jsonResult = "{";
		if (this.id == null) {
			jsonResult += "\"id\":" + "\" \",";
		} else {
			jsonResult += "\"id\":" + "\"" + this.id + "\",";
		}
		if (this.groupCode == null) {
			jsonResult += "\"groupCode\":" + "\" \",";
		} else {
			jsonResult += "\"groupCode\":" + "\"" + this.groupCode + "\",";
		}
		if (this.groupName == null) {
			jsonResult += "\"groupName\":" + "\" \",";
		} else {
			jsonResult += "\"groupName\":" + "\"" + this.groupName + "\",";
		}
		if (this.inheritCode == null) {
			jsonResult += "\"inheritCode\":" + "\" \",";
		} else {
			jsonResult += "\"inheritCode\":" + "\"" + this.inheritCode + "\",";
		}
		if (this.sortNum == null) {
			jsonResult += "\"sortNum\":" + "\" \",";
		} else {
			jsonResult += "\"sortNum\":" + "\"" + this.sortNum + "\",";
		}
		if (this.areaId == null) {
			jsonResult += "\"areaId\":" + "\" \",";
		} else {
			jsonResult += "\"areaId\":" + "\"" + this.areaId + "\",";
		}
		if (this.levels == null) {
			jsonResult += "\"levels\":" + "\" \",";
		} else {
			jsonResult += "\"levels\":" + "\"" + this.levels + "\",";
		}
		jsonResult = jsonResult.substring(0, jsonResult.length() - 1);
		jsonResult += "}";
		return jsonResult;
	}

	public String getTreeJson() {
		String jsonResult = "{";
		jsonResult += "id:" + this.id + ",";
		jsonResult += "pId:" + this.inheritCode + ",";
		jsonResult += "name:" + "\"" + this.groupName + "\",";
		jsonResult += "open:false";
		jsonResult += "}";
		return jsonResult;
	}

	//
	//
	//
	//
}

//
//