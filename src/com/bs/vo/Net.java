package com.bs.vo;

public class Net {
	private int type;
	private int id1;
	private int id2;
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getId1() {
		return id1;
	}
	public void setId1(int id1) {
		this.id1 = id1;
	}
	public int getId2() {
		return id2;
	}
	public void setId2(int id2) {
		this.id2 = id2;
	}
	public Net(int type, int id1, int id2) {
		super();
		this.type = type;
		this.id1 = id1;
		this.id2 = id2;
	}
}
