package tech.zxuuu.hotel24h.service;

import tech.zxuuu.hotel24h.entity.Reserve;
import tech.zxuuu.hotel24h.entity.Comment;

import java.util.Date;
import java.util.List;

public interface ReserveService {

  void addReserve(Reserve reserve);

  void Reserve(Reserve reserve,String state);

  void insertComment(Comment comment);

  List<Reserve> queryAllReserves(String state);

  List<Reserve> searchRooms(Date checkIn, Date checkOut);

  List<Reserve> getpersonList(String username);

  //void deleteReserve(String Id);

  //List<Integer> getAvailableRoomIds(Date start, Date end);
}
