package com.mindtree.channelshow.service.serviceimpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.channelshow.dto.ChannelDTO;
import com.mindtree.channelshow.dto.ChannelGroupDTO;
import com.mindtree.channelshow.dto.ShowDTO;
import com.mindtree.channelshow.entity.Channel;
import com.mindtree.channelshow.entity.ChannelGroup;
import com.mindtree.channelshow.entity.Show;
import com.mindtree.channelshow.exception.ChannelShowServiceException;
import com.mindtree.channelshow.exception.NoSuchChannelFoundException;
import com.mindtree.channelshow.exception.NoSuchChannelGroupFoundException;
import com.mindtree.channelshow.repository.ChannelGroupRepository;
import com.mindtree.channelshow.repository.ChannelRepository;
import com.mindtree.channelshow.repository.ShowRepository;
import com.mindtree.channelshow.service.ChannelGroupService;

@Service
public class ChannelGroupServiceImpl implements ChannelGroupService {
	@Autowired
	ChannelGroupRepository channelGroupRepository;
	@Autowired
	ChannelRepository channelRepository;
	@Autowired
	ShowRepository showRepository;
	ModelMapper modelMapper = new ModelMapper();

	@Override
	public String insertChannelGroup(List<ChannelGroupDTO> channelGroupDTO) {
		for (ChannelGroupDTO channelGroupDTO2 : channelGroupDTO) {
			ChannelGroup channelGroup = modelMapper.map(channelGroupDTO2, ChannelGroup.class);
			channelGroupRepository.save(channelGroup);
		}
		return "channel group inserted";
	}

	@Override
	public String insertChannel(List<ChannelDTO> channelDTO) {

		for (ChannelDTO channelDTO2 : channelDTO) {
			Channel channel = modelMapper.map(channelDTO2, Channel.class);
			channelRepository.save(channel);
		}
		return "channel inserted";
	}

	@Override
	public String insertShow(List<ShowDTO> showDTOs) {
		for (ShowDTO showDTO : showDTOs) {
			Show show = modelMapper.map(showDTO, Show.class);
			showRepository.save(show);

		}
		return "show inserted";
	}

	@Override
	public String addChannelToChannelGroup(int channelGroupID, ChannelDTO channel) throws ChannelShowServiceException {
		ChannelGroup channelGroup;
		try {
			channelGroup = channelGroupRepository.findById(channelGroupID)
					.orElseThrow(() -> new NoSuchChannelGroupFoundException("NO SUCH CHANNEL GROUP FOUND WITH THID ID"));
		} catch (NoSuchChannelGroupFoundException e) {
			throw new ChannelShowServiceException(e.getMessage());
		}

		Channel channel2 = channelRepository.findByChannelName(channel.getChannelName()).get();

		channel2.setChannelGroup(channelGroup);

		channelRepository.save(channel2);
		return "channel added to channel group";
	}

	@Override
	public String addShowsToChannel(int channelID, ShowDTO showDTO) throws ChannelShowServiceException {
		Channel channel = null;
		try {
			channel = channelRepository.findById(channelID)
					.orElseThrow(() -> new NoSuchChannelFoundException("NO SUCH CHANNEL FOUND WITH THID ID"));
		} catch (NoSuchChannelFoundException e) {
			throw new ChannelShowServiceException(e.getMessage());
		}

		Show show = showRepository.findByShowName(showDTO.getShowName()).get();

		show.setChannel(channel);
		showRepository.save(show);
		return "show added to channel";
	}

	@Override
	public ChannelGroup getAllShowsSortedByPrice(int channelGroupID) {

		ChannelGroup channelGroup = channelGroupRepository.findById(channelGroupID).get();
		List<Channel> channels = new ArrayList<>();

		channelGroup.getChannels().forEach(i -> {
			channels.add(i);
		});
		// Collections.sort(channels, Channel.priceComparator);
		Collections.sort(channels);
		channelGroup.setChannels(channels);
		return channelGroup;
	}

}
