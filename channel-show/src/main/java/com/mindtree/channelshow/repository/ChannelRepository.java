package com.mindtree.channelshow.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.channelshow.entity.Channel;

@Repository
public interface ChannelRepository extends JpaRepository<Channel, Integer> {

	Optional<Channel>  findByChannelName(String channelName);

}
