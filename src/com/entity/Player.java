package com.entity;

public class Player {
	
	private int jcnum;
	private String pname;
	private int runs;
	private int wickets;
	private String tname;
	
	public Player() {
		super();
	}

	public Player(int jcnum, String pname, int runs, int wickets, String tname) {
		super();
		this.jcnum = jcnum;
		this.pname = pname;
		this.runs = runs;
		this.wickets = wickets;
		this.tname = tname;
	}

	public int getJcnum() {
		return jcnum;
	}

	public void setJcnum(int jcnum) {
		this.jcnum = jcnum;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getRuns() {
		return runs;
	}

	public void setRuns(int runs) {
		this.runs = runs;
	}

	public int getWickets() {
		return wickets;
	}

	public void setWickets(int wickets) {
		this.wickets = wickets;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	@Override
	public String toString() {
		return "Player [jcnum=" + jcnum + ", pname=" + pname + ", runs=" + runs + ", wickets=" + wickets + ", tname="
				+ tname + "]";
	}
	
	
	
	

}
