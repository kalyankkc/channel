package com.mindtree.channelshow.dto;

public class ShowDTO 
{
	private int showId;
	private String showName;
	private ChannelDTO channelDTO;
	public ShowDTO() {
		super();
	}
	public ShowDTO(int showId, String showName, ChannelDTO channelDTO) {
		super();
		this.showId = showId;
		this.showName = showName;
		this.channelDTO = channelDTO;
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
	public ChannelDTO getChannelDTO() {
		return channelDTO;
	}
	public void setChannelDTO(ChannelDTO channelDTO) {
		this.channelDTO = channelDTO;
	}
	
}
