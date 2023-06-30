package tech.zxuuu.hotel24h.service;

import tech.zxuuu.hotel24h.entity.Customer;

import java.util.List;

public interface LoginService {

    Customer empLogin(String customerId, String customerPassword);

    Customer empLogin2(String customerId);

    void changePwd(String customerId, String newPwd);

    boolean insertCustomer(Customer cus);

}
