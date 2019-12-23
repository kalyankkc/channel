package com.mindtree.channelshow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.channelshow.entity.ChannelGroup;

@Repository
public interface ChannelGroupRepository extends JpaRepository<ChannelGroup, Integer>{

}
