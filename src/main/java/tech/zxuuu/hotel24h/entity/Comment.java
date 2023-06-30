package tech.zxuuu.hotel24h.entity;

import java.util.Date;

// 评论类
public class Comment {

  private String CommentName;
  private Integer CommentRoomID;
  private String CommentPhone;
  private String CommentEmail;
  private Integer CommentScore;
  private Date CommentTime;


  public Comment(String CommentName,Integer CommentRoomID,String CommentPhone,String CommentEmail,Integer CommentScore,Date CommentTime) {
    this.CommentName = CommentName;
    this.CommentRoomID = CommentRoomID;
    this.CommentPhone=CommentPhone;
    this.CommentEmail=CommentEmail;
    this.CommentScore=CommentScore;
    this.CommentTime=CommentTime;
  }

  public String getCommentName() {
    return CommentName;
  }

  public void setCommentName(String commentName) {
    this.CommentName = commentName;
  }

  public Integer getCommentRoomID() {
    return CommentRoomID;
  }

  public void setCommentRoomID(Integer commentRoomID) {
    this.CommentRoomID = commentRoomID;
  }

  public Integer getCommentScore() {
    return CommentScore;
  }

  public void setCommentScore(Integer commentScore) {
    this.CommentScore= commentScore;
  }
  public String getCommentPhone() {
    return CommentPhone;
  }

  public void setCommentPhone(String commentPhone) {
    this.CommentPhone = commentPhone;
  }

  public String getCommentEmail() {
    return CommentEmail;
  }

  public void setCommentEmail(String commentEmail) {
    this.CommentEmail = commentEmail;
  }

  public Date getCommentTime() {
    return CommentTime;
  }

  public void setCommentTime(Date commentTime) {
    this.CommentTime = commentTime;
  }
}
