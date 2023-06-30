package tech.zxuuu.hotel24h.mapper;

import org.apache.ibatis.annotations.*;
import tech.zxuuu.hotel24h.entity.Comment;
//import tech.zxuuu.hotel24h.entity.Room;
import tech.zxuuu.hotel24h.entity.Reserve;
import tech.zxuuu.hotel24h.provider.EmpSQLProvider;

import java.util.Date;
import java.util.List;
//顾客信息
@Mapper
public interface CommentMapper {

    @Insert("INSERT INTO comment " +
            "VALUES(#{CommentName},#{CommentRoomID},#{CommentPhone},#{CommentEmail},#{CommentScore},#{CommentTime})")
    void insertComment(Comment comment);

    @Select("SELECT * FROM comment WHERE CommentTime>=#{startDate} and CommentTime<=#{endDate}")
    List<Comment> selectCustomerWhenLogin(Date startDate, Date endDate);//用户登录查询

    //@Select("SELECT * FROM employee WHERE id = #{empId} AND password = #{empPassword} ")
    //List<Emp> selectEmpWhenLogin(String empId, String empPassword);

    //@Delete("DELETE FROM tb_emp WHERE id = #{empId} AND name = #{empName} AND id <> 'admin' ")
    //Integer deleteEmp(String empId, String empName);



}
