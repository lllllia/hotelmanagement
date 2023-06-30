package tech.zxuuu.hotel24h.service;

import tech.zxuuu.hotel24h.entity.Room;

import java.util.List;

import java.util.Date;

public interface RoomService {
  List<Room> getAllRooms();

  void updateRoom(int id,String state);

  int cost(int id);

}

  //Integer addRoom(Room room);

  //Integer updateRoom(Room room);

  //Integer deleteRoom(Integer roomId);


