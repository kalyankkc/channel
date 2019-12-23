package com.mindtree.channelshow.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.channelshow.entity.Show;

@Repository
public interface ShowRepository extends JpaRepository<Show, Integer>{

	Optional<Show> findByShowName(String showName);

}
