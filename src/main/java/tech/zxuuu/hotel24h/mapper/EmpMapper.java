package tech.zxuuu.hotel24h.mapper;

import org.apache.ibatis.annotations.*;
import tech.zxuuu.hotel24h.entity.Emp;
import tech.zxuuu.hotel24h.entity.Room;
import tech.zxuuu.hotel24h.provider.EmpSQLProvider;

import java.util.List;
//员工管理：查看员工信息，修改员工状态
@Mapper
public interface EmpMapper {

    @Insert("INSERT INTO employee " + "VALUES(#{EmployeeID},#{EmployeeName},#{EmployeeGender},#{EmployeePhone},#{EmployeeEmail},#{EmployeeAddress},#{EmployeeState})")
    void insertEmp(Emp emp);

    @SelectProvider(type = EmpSQLProvider.class, method = "selectEmp")
    List<Emp> selectEmp(Emp emp);

    @UpdateProvider(type = EmpSQLProvider.class, method = "updateEmp")
    Integer updateEmp(Emp emp);

    @Update("UPDATE employee SET EmployeePassword = #{EmployeePassword} WHERE EmployeeID = #{EmployeeID}")
    void changeEmpPwd(String password);

    /*@Update("UPDATE employee SET EmployeeState=#{EmployeeState} WHERE Employee=#{Employee} ")
    public void updateEmpStatus(Emp emp);*/

    @Select("SELECT * FROM employee WHERE EmployeeName = #{EmployeeName} AND EmployeePhone=#{EmployeePhone}")
    List<Emp> selectEmpWhenLogin(String EmployeeName,String EmployeePhone);

    @Update("UPDATE employee SET EmployeeState=#{state} WHERE EmployeeID=#{id} ")
    void updateEmpState(int id,String state);

    @Select("SELECT * FROM employee")
    List<Emp> selectAllEmployee();

    //@Select("SELECT * FROM employee WHERE id = #{empId} AND password = #{empPassword} ")
    //List<Emp> selectEmpWhenLogin(String empId, String empPassword);

    @Delete("DELETE FROM employee WHERE EmployeeID = #{id}")
    void deleteEmp(int id);
}
