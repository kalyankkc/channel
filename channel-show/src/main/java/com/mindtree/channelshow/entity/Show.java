package com.mindtree.channelshow.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "shows")
public class Show 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int showId;
	private String showName;
	@ManyToOne
	private Channel channel;
	
	
	public Show() {
		super();
	}


	public Show(int showId, String showName, Channel channel) {
		super();
		this.showId = showId;
		this.showName = showName;
		this.channel = channel;
	}


	public int getShowId() {
		return showId;
	}


	public void setShowId(int showId) {
		this.showId = showId;
	}


	public String getShowName() {
		return showName;
	}


	public void setShowName(String showName) {
		this.showName = showName;
	}


	public Channel getChannel() {
		return channel;
	}


	public void setChannel(Channel channel) {
		this.channel = channel;
	}
	
	
	
}

