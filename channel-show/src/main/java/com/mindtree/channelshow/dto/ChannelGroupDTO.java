package com.mindtree.channelshow.dto;

import java.util.List;

public class ChannelGroupDTO 
{
	private int channelGroupId;
	private String channelGroupName;
	private List<ChannelDTO> channelDTOs;
	public ChannelGroupDTO(int channelGroupId, String channelGroupName, List<ChannelDTO> channelDTOs) {
		super();
		this.channelGroupId = channelGroupId;
		this.channelGroupName = channelGroupName;
		this.channelDTOs = channelDTOs;
	}
	public ChannelGroupDTO() {
		super();
	}
	public int getChannelGroupId() {
		return channelGroupId;
	}
	public void setChannelGroupId(int channelGroupId) {
		this.channelGroupId = channelGroupId;
	}
	public String getChannelGroupName() {
		return channelGroupName;
	}
	public void setChannelGroupName(String channelGroupName) {
		this.channelGroupName = channelGroupName;
	}
	public List<ChannelDTO> getChannelDTOs() {
		return channelDTOs;
	}
	public void setChannelDTOs(List<ChannelDTO> channelDTOs) {
		this.channelDTOs = channelDTOs;
	}
	
	

}
