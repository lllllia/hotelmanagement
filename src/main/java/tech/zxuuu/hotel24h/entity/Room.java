package tech.zxuuu.hotel24h.entity;

// 房间类
public class Room {
  private String RoomID; // 房号
  private String RoomType; // 房间类型，请查看对照表
  private Integer RoomPrice; // 房间价格
  private String RoomState;

  public Room(String Roomid, String Roomtype, Integer price, String RoomState) {
    this.RoomID = Roomid;
    this.RoomType = Roomtype;
    this.RoomPrice = RoomPrice;
    this.RoomState=RoomState;
  }

  public Room() {
  }

  public String getId() {
    return RoomID;
  }

  public void setId(String id) {
    this.RoomID = id;
  }

  public String getType() {
    return RoomType;
  }

  public void setType(String type) {
    this.RoomType = type;
  }

  public String getRoomState() {
    return RoomState;
  }

  public void setRoomState(String RoomState) {
    this.RoomState = RoomState;
  }

  public Integer getRoomPrice() {
    return RoomPrice;
  }

  public void setId(Integer roomPrice) {
    this.RoomPrice = roomPrice;
  }

  @Override
  public String toString() {
    return "Room{" +
      "id=" + RoomID +
      ", type='" + RoomType + '\'' +
      ", price=" + RoomPrice +
      '}';
  }
}
