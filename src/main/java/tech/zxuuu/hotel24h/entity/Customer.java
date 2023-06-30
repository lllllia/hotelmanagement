package tech.zxuuu.hotel24h.entity;

// 员工类
public class Customer {

    private String CustomerID; // 顾客账号
    private String CustomerPassword; // 顾客密码
    private String CustomerName; // 顾客姓名
    private String CustomerCitizenID;
    private String CustomerContact;
    private String CustomerUsername;

    public Customer(String id, String password, String name,String citizenID,String contact,String username) {
        this.CustomerID = id;
        this.CustomerPassword = password;
        this.CustomerName = name;
        this.CustomerCitizenID=citizenID;
        this.CustomerContact=contact;
        this.CustomerUsername=username;
    }

    public Customer() {
    }

    public String getId() {
        return CustomerID;
    }

    public void setId(String id) {
        this.CustomerID = id;
    }

    public String getPassword() {
        return CustomerPassword;
    }

    public void setPassword(String password) {
        this.CustomerPassword = password;
    }

    public String getName() {
        return CustomerName;
    }

    public void setName(String name) {
        this.CustomerName = name;
    }

    public String getContact(){
        return CustomerContact;
    }

    public void setContact(String contact) {
        this.CustomerContact = contact;
    }

    public String getUsername(){
        return CustomerUsername;
    }

    public void setUsername(String username) {
        this.CustomerUsername = username;
    }

}
