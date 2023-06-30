package tech.zxuuu.hotel24h.service;

import tech.zxuuu.hotel24h.entity.Emp;

import java.util.List;
import java.util.Date;

public interface AdminService {

    List<Emp> queryAllEmp();

    void deleteEmp(int id);

    void deleteReserve(int id);

    boolean insertEmp(Emp emp);

    void updateEmp(int id,String state);

    void updateRoom(int id,String state);

    Emp empLogin(String EmployeeName,String EmployeePhone);

    int getIncome(Date S,Date E);

    int getCount(Date S,Date E);

    float getRate(Date S,Date E);

    float getSorce(Date S,Date E);
    /*
    List<Emp> queryEmp(Emp emp);

    Boolean verifyAdmin(String adminPwd);

    Boolean updateEmp(Emp emp);

    void insertEmp(Emp emp);

    Boolean deleteEmp(String empId, String empName);

    void changeAdminPwd(String password);
*/
}
