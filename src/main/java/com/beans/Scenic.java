package com.beans;

public class Scenic {
	private int id;
	private String site;
	private String adultprice;
	private String childprice;
	private String introduce;
	private String img;
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public String getAdultprice() {
		return adultprice;
	}
	public void setAdultprice(String adultprice) {
		this.adultprice = adultprice;
	}
	public String getChildprice() {
		return childprice;
	}
	public void setChildprice(String childprice) {
		this.childprice = childprice;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	
	@Override
	public String toString() {
		return "Scenic [img=" + img + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	

}
