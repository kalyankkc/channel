package com.mindtree.channelshow.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mindtree.channelshow.dto.ChannelDTO;
import com.mindtree.channelshow.dto.ChannelGroupDTO;
import com.mindtree.channelshow.dto.ShowDTO;
import com.mindtree.channelshow.entity.ChannelGroup;
import com.mindtree.channelshow.exception.ChannelShowServiceException;

@Service
public interface ChannelGroupService {

	/**
	 * @param channelGroupDTO
	 * @return whether channel group is inserted or not
	 */
	String insertChannelGroup(List<ChannelGroupDTO> channelGroupDTO);

	/**
	 * @param channelDTO
	 * @return whether channel is inserted or not
	 */
	String insertChannel(List<ChannelDTO> channelDTO);

	/**
	 * @param showDTOs
	 * @return whether show is inserted or not
	 */
	String insertShow(List<ShowDTO> showDTOs);

	/**
	 * @param channelGroupID
	 * @param channelDTO
	 * @return whether channel is added to channel group or not
	 * @throws ChannelShowServiceException
	 */
	String addChannelToChannelGroup(int channelGroupID, ChannelDTO channelDTO) throws ChannelShowServiceException;

	/**
	 * @param channelID
	 * @param showDTO
	 * @return whether show is added to channel or not
	 * @throws ChannelShowServiceException
	 */
	String addShowsToChannel(int channelID, ShowDTO showDTO) throws ChannelShowServiceException;

	/**
	 * @param channelGroupID
	 * @return shows sorted based on the Channel price
	 */
	ChannelGroup getAllShowsSortedByPrice(int channelGroupID);

}
