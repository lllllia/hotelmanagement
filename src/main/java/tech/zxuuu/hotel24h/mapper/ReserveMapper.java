package tech.zxuuu.hotel24h.mapper;


import org.apache.ibatis.annotations.*;
import tech.zxuuu.hotel24h.entity.Customer;
import tech.zxuuu.hotel24h.entity.Reserve;
import tech.zxuuu.hotel24h.entity.Room;

import java.util.Date;
import java.util.List;

//订单管理：顾客查看订单信息，顾客修改订单信息，酒店管理者查看订单信息，顾客增加/删除订单
@Mapper
public interface ReserveMapper {

  @Select("SELECT ReserveID,ReserveRoomID,ReserveName,ReserveTime,status FROM reserve_in WHERE ReserveContact=#{username}")
  List<Reserve> selectReserveByCustomer(String username);

  @Select("SELECT CustomerName FROM Customer WHERE CustomerID=#{username}")
  String selectReserveByCustomer2(String username);

  @Insert("INSERT INTO reserve_in " +
    "VALUES(#{ReserveID},#{ReserveRoomID},#{ReserveName},#{ReserveContact},#{ReserveTime},#{status},#{startDate},#{endDate},#{ReserveCost})")
  void insertReserve(Reserve reserve);

  @Update("update room set RoomState = #{state} where RoomID=#{reserve.ReserveRoomID}")
  void reserveRoom(Reserve reserve, String state);

  @Select("SELECT ReserveID,ReserveRoomID,ReserveName,ReserveContact,ReserveTime,status FROM reserve_in where status!=#{state}")
  List<Reserve> showAllReserves(String state);

  @Select("SELECT * FROM reserve_in where startDate>=#{startDate} and endDate<=#{endDate}")
  List<Reserve> showReservesbyMonth(Date startDate,Date endDate);

  @Select("SELECT RoomID from room where RoomID not in (SELECT ReserveRoomID FROM reserve_in where #{checkOut}>=startDate and #{checkIn}<=endDate)")
  List<Reserve> searchRooms(Date checkIn, Date checkOut);

  @Delete("DELETE FROM reserve_in WHERE ReserveID=#{id}")
  void deleteReserve(int id);

  @Update("update reserve_in set status = #{newState} where ReserveID=#{id}")
  void changeRoomStatebyReserve(String newState,int id);

  @Select("SELECT SUM(ReserveCost) FROM reserve_in where startDate>=#{startDate} and endDate<=#{endDate}")
  int IncomebyMonth(Date startDate,Date endDate);

  @Select("SELECT COUNT(*) FROM reserve_in where startDate>=#{startDate} and endDate<=#{endDate}")
  int NumberbyMonth(Date startDate,Date endDate);

  @Select("SELECT AVG(CommentScore) FROM comment where CommentTime>=#{startDate} and CommentTime<=#{endDate}")
  float ScorebyMonth(Date startDate,Date endDate);

  @Select("SELECT COUNT(DISTINCT ReserveRoomID) from reserve_in WHERE endDate>=#{startDate} and startDate<=#{endDate}")
  float OccupybyMonth(Date startDate,Date endDate);

  @Select("SELECT COUNT(*) FROM room")
  int RoomNumber();


  /*@Select("SELECT id FROM tb_room WHERE id NOT IN (" +
    "SELECT room_id FROM tb_reserve" +
    "  WHERE (start_date >= #{start} AND start_date <= #{end}) OR" +
    "        (start_date <= #{start} AND end_date >= #{end}) OR" +
    "        (end_date >= #{start} AND end_date <= #{end})" +
    ") ORDER BY id ASC;\n")
  List<Integer> getAvailableRoomIds(Date start, Date end);*/

  //@Update("UPDATE reserve_in SET status=#{status} WHERE id=#{id}")
  //void updateStatus(Integer status, String id);
}
