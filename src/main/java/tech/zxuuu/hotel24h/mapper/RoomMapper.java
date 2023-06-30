package tech.zxuuu.hotel24h.mapper;

import org.apache.ibatis.annotations.*;
import tech.zxuuu.hotel24h.entity.Room;

import java.util.Date;
import java.util.List;
//房间信息管理：查看信息
@Mapper
public interface RoomMapper {
  //@Insert("INSERT INTO tb_room VALUE(#{id},#{type},#{price})")
  //void insertRoom(Room room);

  @Select("SELECT * FROM room WHERE RoomID=#{RoomID}")
  Room selectRoomById(Integer RoomID);

  @Select("SELECT * FROM room")
  List<Room> selectAllRooms();

  @Select("SELECT * FROM room where RoomState=#{RoomState}")
  List<Room> selectByState(Integer RoomState);
  //@Update("UPDATE tb_room SET type=#{type}, price=#{price} WHERE id=#{id} ")
  //void updateRoom(Room room);

  @Select("SELECT DISTINCT RoomType FROM room where Roomstate='available'")
  List<Room> selectEmptyRoom();

  @Update("update room set RoomState = #{newState} where RoomID=#{RoomID}")
  void changeRoomState(String newState,Integer RoomID);

  @Select("SELECT RoomCost FROM room where RoomID=#{RoomID}")
  int selectRoomCost(Integer RoomID);

  //@Delete("DELETE FROM tb_room WHERE id=#{id}")
  //void deleteRoom(Integer roomId);
}
