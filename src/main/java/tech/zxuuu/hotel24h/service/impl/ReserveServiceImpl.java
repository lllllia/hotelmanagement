package tech.zxuuu.hotel24h.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.zxuuu.hotel24h.entity.Comment;
import tech.zxuuu.hotel24h.entity.Reserve;
import tech.zxuuu.hotel24h.mapper.ReserveMapper;
import tech.zxuuu.hotel24h.mapper.CommentMapper;
import tech.zxuuu.hotel24h.service.ReserveService;

import java.util.Date;
import java.util.List;

@Service("reserveService")
public class ReserveServiceImpl implements ReserveService {

  @Autowired
  private ReserveMapper reserveMapper;
  @Autowired
  private CommentMapper commentMapper;

  @Override
  public List<Reserve> queryAllReserves(String state) {
    return this.reserveMapper.showAllReserves(state);
  }

  @Override
  public List<Reserve> searchRooms(Date checkIn, Date checkOut) {
    return reserveMapper.searchRooms(checkIn, checkOut);
  }

  @Override
  public void addReserve(Reserve reserve) {
    /*Date now = new Date();
    String maxReserve = queryMaxReserveByDate(now);
    String id = String.valueOf(Long.parseLong(maxReserve) + 1);
    reserve.setId(id);
    reserve.setStatus(0);*/
    this.reserveMapper.insertReserve(reserve);
  }
  @Override
  public void Reserve(Reserve reserve,String state)
  {
    this.reserveMapper.reserveRoom(reserve,state);
  }

  @Override
  public void insertComment(Comment comment)
  {
    this.commentMapper.insertComment(comment);
  }

  @Override
  public List<Reserve> getpersonList(String username)
  {
    //String NAME=reserveMapper.selectReserveByCustomer2(username);
    return reserveMapper.selectReserveByCustomer(username);
  }
/*
  @Override
  public String queryMaxReserveByDate(Date date) {
    String pattern = new SimpleDateFormat("yyyyMMdd").format(date);
    pattern += '%';
    String res = this.reserveMapper.selectMaxReserveByDate(pattern);
    if (res == null) {
      return new SimpleDateFormat("yyyyMMdd").format(new Date()) + "000";
    } else {
      return res;
    }
  }

  @Override
  public List<Integer> getAvailableRoomIds(Date start, Date end) {
    return reserveMapper.getAvailableRoomIds(start, end);
  }

  @Override
  public void deleteReserve(String Id) {
    this.reserveMapper.deleteReserve(Id);
  }*/

}
