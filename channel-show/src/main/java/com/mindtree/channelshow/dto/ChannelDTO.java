package com.mindtree.channelshow.dto;

import java.util.List;

import com.mindtree.channelshow.entity.ChannelGroup;

public class ChannelDTO 
{
	private int channelId;
	private String channelName;
	private int channelPrice;
	
	private ChannelGroupDTO channelGroupDTO;
	private List<ShowDTO> showDTOs;
	public ChannelDTO() {
		super();
	}
	
	public ChannelDTO(int channelId, String channelName, int channelPrice, ChannelGroupDTO channelGroupDTO,
			List<ShowDTO> showDTOs) {
		super();
		this.channelId = channelId;
		this.channelName = channelName;
		this.channelPrice = channelPrice;
		this.channelGroupDTO = channelGroupDTO;
		this.showDTOs = showDTOs;
	}

	public int getChannelId() {
		return channelId;
	}
	public void setChannelId(int channelId) {
		this.channelId = channelId;
	}
	public String getChannelName() {
		return channelName;
	}
	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}
	public int getChannelPrice() {
		return channelPrice;
	}
	public void setChannelPrice(int channelPrice) {
		this.channelPrice = channelPrice;
	}
	
	public ChannelGroupDTO getChannelGroupDTO() {
		return channelGroupDTO;
	}

	public void setChannelGroupDTO(ChannelGroupDTO channelGroupDTO) {
		this.channelGroupDTO = channelGroupDTO;
	}

	public List<ShowDTO> getShowDTOs() {
		return showDTOs;
	}
	public void setShowDTOs(List<ShowDTO> showDTOs) {
		this.showDTOs = showDTOs;
	}
	public ChannelDTO(String channelName) {
		super();
		this.channelName = channelName;
	}
	/*@Override
	public int compareTo(ChannelDTO c) 
	{
		int result = this.getChannelPrice() - c.getChannelPrice();
		
		if(result == 0)
		{
			return this.getChannelName().compareTo(c.getChannelName());
		}
		return result;
	}*/
	
	

}
