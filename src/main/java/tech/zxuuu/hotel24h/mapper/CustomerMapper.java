package tech.zxuuu.hotel24h.mapper;

import org.apache.ibatis.annotations.*;
import tech.zxuuu.hotel24h.entity.Customer;
//import tech.zxuuu.hotel24h.entity.Room;
import tech.zxuuu.hotel24h.provider.EmpSQLProvider;

import java.util.List;
//顾客信息
@Mapper
public interface CustomerMapper {

    @Insert("INSERT INTO customer(CustomerID, CustomerPassword) VALUES(#{CustomerID}, #{CustomerPassword})")
    void insertCustomerLogin(Customer customer);//注册

    @Select("SELECT * FROM customer WHERE CustomerID = #{CustomerID} AND CustomerPassword = #{CustomerPassword} ")
    List<Customer> selectCustomerWhenLogin(String CustomerID, String CustomerPassword);//用户登录查询

    //@Select("SELECT * FROM employee WHERE id = #{empId} AND password = #{empPassword} ")
    //List<Emp> selectEmpWhenLogin(String empId, String empPassword);

    //@Delete("DELETE FROM tb_emp WHERE id = #{empId} AND name = #{empName} AND id <> 'admin' ")
    //Integer deleteEmp(String empId, String empName);

    @Update("UPDATE customer SET CustomerPassword = #{CustomerPassword} WHERE CustomerID = #{CustomerID}")
    void changeCustomerPwd(String password);

    @Select("SELECT * FROM customer WHERE CustomerID = #{CustomerID}")
    List<Customer> selectCustomerWhenLogin2(String CustomerID);//用户登录查询

}
