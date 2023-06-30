package tech.zxuuu.hotel24h.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.zxuuu.hotel24h.entity.Emp;
import tech.zxuuu.hotel24h.mapper.EmpMapper;
import tech.zxuuu.hotel24h.mapper.ReserveMapper;
import tech.zxuuu.hotel24h.service.AdminService;

import java.util.List;
import java.util.Date;

@Service("adminService")
public class AdminServiceImpl implements AdminService {

    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private ReserveMapper reserveMapper;

    @Override
    public List<Emp> queryAllEmp() {
        return empMapper.selectAllEmployee();
    }
    @Override
    public void deleteEmp(int id)
    {
        empMapper.deleteEmp(id);
    }
    @Override
    public void deleteReserve(int id)
    {
        reserveMapper.deleteReserve(id);
    }
    @Override
    public boolean insertEmp(Emp emp) {
        Emp employee = empLogin(emp.getName(),emp.getEmployeePhone());
        if (employee== null) {//不存在该员工，可以插入
            empMapper.insertEmp(emp);
            return true;
        }
        else return false;
    }
    @Override
    public void updateEmp(int id,String state)
    {
        empMapper.updateEmpState(id, state);
    }
    @Override
    public void updateRoom(int id,String state)
    {
        reserveMapper.changeRoomStatebyReserve(state,id);
    }
    @Override
    public Emp empLogin(String EmployeeName,String EmployeePhone) {
        List<Emp> emps = this.empMapper.selectEmpWhenLogin(EmployeeName,EmployeePhone);
        if (emps.isEmpty() || emps.size() > 1) {
            return null;
        } else {
            return emps.get(0);
        }
    }
    @Override
    public int getIncome(Date S,Date E)
    {
        return reserveMapper.IncomebyMonth(S,E);
    }
    @Override
    public int getCount(Date S,Date E)
    {
        return reserveMapper.NumberbyMonth(S,E);
    }
    @Override
    public float getRate(Date S,Date E)
    {
        float rate;
        rate=reserveMapper.OccupybyMonth(S,E)/reserveMapper.RoomNumber();
        return rate;
    }
    @Override
    public float getSorce(Date S,Date E)
    {
        return reserveMapper.ScorebyMonth(S,E);
    }
}
