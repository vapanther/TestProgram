package com.crosscode.ConsumerDB.bean;

import javax.persistence.*;

@Entity
@Table(name="IPAddress")
public class IpAddress {

	private String IP;
	@Id
	public String getIP() {
		return IP;
	}

	public void setIP(String iP) {
		IP = iP;
	}
	
}
