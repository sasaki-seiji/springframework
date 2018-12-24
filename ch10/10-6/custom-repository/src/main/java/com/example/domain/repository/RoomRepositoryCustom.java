package com.example.domain.repository;

import java.util.List;

import com.example.domain.model.Room;

public interface RoomRepositoryCustom {
	List<Room> findByCriteria(RoomCriteria criteria);
}
