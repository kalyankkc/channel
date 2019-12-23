package com.mindtree.channelshow.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.channelshow.dto.ChannelDTO;
import com.mindtree.channelshow.dto.ChannelGroupDTO;
import com.mindtree.channelshow.dto.ShowDTO;
import com.mindtree.channelshow.entity.ChannelGroup;
import com.mindtree.channelshow.exception.ChannelShowServiceException;
import com.mindtree.channelshow.service.ChannelGroupService;

@RestController
public class ChannelShowAppController {
	@Autowired
	ChannelGroupService channelGroupService;

	@PostMapping(path = "/channelGroup")
	public String insertChannelGroup(@RequestBody List<ChannelGroupDTO> channelGroupDTO) {
		return channelGroupService.insertChannelGroup(channelGroupDTO);
	}

	@PostMapping(path = "/channel")
	public String insertChannel(@RequestBody List<ChannelDTO> channelDTO) {
		return channelGroupService.insertChannel(channelDTO);
	}

	@PostMapping(path = "/show")
	public String insertShow(@RequestBody List<ShowDTO> showDTOs) {
		return channelGroupService.insertShow(showDTOs);
	}

	@PostMapping(path = "/addChannelToChannelGroup/{channelGroupID}")
	public String addChannelToChannelGroup(@PathVariable int channelGroupID, @RequestBody ChannelDTO channelDTO)
			throws ChannelShowServiceException {
		return channelGroupService.addChannelToChannelGroup(channelGroupID, channelDTO);
	}

	@PostMapping(path = "/addShowsToChannel/{channelID}")
	public String addShowsToChannel(@PathVariable int channelID, @RequestBody ShowDTO showDTO)
			throws ChannelShowServiceException {
		return channelGroupService.addShowsToChannel(channelID, showDTO);
	}

	@GetMapping(path = "/getAllShowsSortedByPrice/{channelGroupID}")
	public ChannelGroup getAllShowsSortedByPrice(@PathVariable int channelGroupID) {
		return channelGroupService.getAllShowsSortedByPrice(channelGroupID);
	}

}
