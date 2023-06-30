package tech.zxuuu.hotel24h.entity;

import java.util.Date;

public class Clean {
    private Date CleanTime;
    private Integer CleanRoomID;
    private Integer CleanEmployeeID;

    public Clean(Date time, Integer roomid, Integer empid) {
        this.CleanTime = time;
        this.CleanRoomID = roomid;
        this.CleanEmployeeID = empid;
    }

    public Clean() {
    }

    public Date getTime() {
        return CleanTime;
    }

    public void setTime(Date time) {
        this.CleanTime = time;
    }

    public Integer getRoomid() {
        return CleanRoomID;
    }

    public void setRoomid(Integer roomid) {
        this.CleanRoomID = roomid;
    }

    public Integer getEmpid() {
        return CleanEmployeeID;
    }

    public void setEmpid(Integer empid) {
        this.CleanEmployeeID = empid;
    }
}
