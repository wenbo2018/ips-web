package com.ips.dto;

import java.io.Serializable;
import java.util.Date;

public class RssIData implements Serializable{


	private String ssid;
	private int rss;
	private int position;
	private String macAddress;

	private int indexId;

	public int getIndexId() {
		return indexId;
	}

	public void setIndexId(int indexId) {
		this.indexId = indexId;
	}

	public String getSsid() {
		return ssid;
	}

	public void setSsid(String ssid) {
		this.ssid = ssid;
	}

	public int getRss() {
		return rss;
	}

	public void setRss(int rss) {
		this.rss = rss;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public String getMacAddress() {
		return macAddress;
	}

	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}
}
