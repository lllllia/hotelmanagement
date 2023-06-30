package tech.zxuuu.hotel24h.entity;

import java.util.Date;

// 房间预订记录类
public class Reserve {
  private Integer ReserveID; // 订单号
  private String ReserveRoomID; // 房间号
  private Date ReserveTime;
  private Date startDate; // 开始时间
  private Date endDate; // 结束时间

  private String Comment; // 打分
  private String status; // 状态，0：预定还没来；1：预定了在住；2：已退房未评论；3：已退房已评论
  private Integer ReserveCost;// 订单价格
  private String ReserveName;
  private String ReserveContact;
  @Override
  public String toString() {
    return "Reserve{" +
      "id='" + ReserveID + '\'' +
      ", roomId=" + ReserveRoomID +
     ", ReserveTime=" +ReserveTime +
      ", startDate=" + startDate +
      ", endDate=" + endDate +
      ", status=" + status +
      '}';
  }

  public Integer getId() {
    return ReserveID;
  }

  public void setId(Integer id) {
    this.ReserveID = id;
  }

  public String getRoomId() {
    return ReserveRoomID;
  }

  public void setRoomId(String roomId) {
    this.ReserveRoomID = roomId;
  }

  public Date getReserveTime() {
    return ReserveTime;
  }

  public void setReserveTime(Date ReserveTime) {
    this.ReserveTime = ReserveTime;
  }

  public Integer getReserveCost() {
    return ReserveCost;
  }

  public void setReserveCost(Integer ReserveCost) {
    this.ReserveCost = ReserveCost;
  }

  public String getReserverName() {
    return ReserveName;
  }

  public void setReserverName(String ReserverName) {
    this.ReserveName = ReserverName;
  }

  public String getReserverContact() {
    return ReserveContact;
  }

  public void setReserverPhone(String reserverPhone) {
    this.ReserveContact = reserverPhone;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public Reserve() {
  }

  public Reserve(Integer ReserveID, String ReserveRoomID,String ReserveName, String ReserveContact, Date ReserveTime, String status, Date startDate, Date endDate,Integer ReserveCost) {
    this.ReserveID = ReserveID;
    this.ReserveRoomID = ReserveRoomID;
    this.ReserveTime=ReserveTime;
    this.startDate = startDate;
    this.endDate = endDate;
    this.ReserveCost = ReserveCost;
    this.status = status;
    this.ReserveName=ReserveName;
    this.ReserveContact=ReserveContact;
  }
}


