package org.app.entity;

public class JsonInfo {
	private String info;
	private String flag;
	
	
	public JsonInfo() {
		super();
	}
	public JsonInfo(String info, String flag) {
		super();
		this.info = info;
		this.flag = flag;
	}
	@Override
	public String toString() {
		return "JsonInfo [info=" + info + ", flag=" + flag + "]";
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}

}
