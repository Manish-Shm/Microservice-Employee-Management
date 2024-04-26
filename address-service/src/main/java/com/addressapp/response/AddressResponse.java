package com.addressapp.response;

public class AddressResponse {
	private int id;

	private String lane1;

	private String lane3;

	private long zip;

	private String state;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLane1() {
		return lane1;
	}

	public void setLane1(String lane1) {
		this.lane1 = lane1;
	}

	public String getLane3() {
		return lane3;
	}

	public void setLane3(String lane3) {
		this.lane3 = lane3;
	}

	public long getZip() {
		return zip;
	}

	public void setZip(long zip) {
		this.zip = zip;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
