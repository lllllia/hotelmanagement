package tech.zxuuu.hotel24h.entity;

import java.util.Date;

public class Monthly {
    private Date MonthlyDate;
    private Integer MonthlyIncome;
    private Float MonthlyRoom;
    private Float MonthlyAttendance;
    private Float MonthlyScore;

    public Monthly(Date date, Integer income, Float room, Float attendance, Float score) {
        this.MonthlyDate = date;
        this.MonthlyIncome = income;
        this.MonthlyRoom = room;
        this.MonthlyAttendance=attendance;
        this.MonthlyScore=score;
    }

    public Monthly() {
    }

    public Date getDate() {
        return MonthlyDate;
    }


    public Integer getIncome() {
        return MonthlyIncome;
    }


    public Float getRoom() {
        return MonthlyRoom;
    }

    public Float getAttendance() {
        return MonthlyAttendance;
    }

    public Float getScore() {
        return MonthlyScore;
    }

    /*
    public void setContact(String contact) {
        this.contact = contact;
    }*/
}
