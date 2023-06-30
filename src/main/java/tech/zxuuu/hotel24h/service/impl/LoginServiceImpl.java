package tech.zxuuu.hotel24h.service.impl;

import ch.ethz.ssh2.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.zxuuu.hotel24h.entity.Customer;
import tech.zxuuu.hotel24h.service.LoginService;
import tech.zxuuu.hotel24h.mapper.CustomerMapper;

import java.util.List;

@Service("loginService")
public class LoginServiceImpl implements LoginService {

    @Autowired
    private CustomerMapper CustomerMapper;

    @Override
    public Customer empLogin(String customerId, String customerPassword) {
        List<Customer> customers = this.CustomerMapper.selectCustomerWhenLogin(customerId, customerPassword);
        if (customers.isEmpty() || customers.size() > 1) {
            return null;
        } else {
            return customers.get(0);
        }
    }

    @Override
    public Customer empLogin2(String customerId) {
        List<Customer> customers = this.CustomerMapper.selectCustomerWhenLogin2(customerId);
        if (customers.isEmpty() || customers.size() > 1) {
            return null;
        } else {
            return customers.get(0);
        }
    }

    @Override
    public void changePwd(String customerId, String newPwd) {
        //empMapper.updateEmp(new Emp(empId, newPwd, ""));
    }


    @Override
    public boolean insertCustomer(Customer cus) {
        Customer customer = empLogin2(cus.getId());
        if (customer == null) {//不存在该用户，可以注册
            CustomerMapper.insertCustomerLogin(cus);
            return true;
        }
        else return false;
    }


}
