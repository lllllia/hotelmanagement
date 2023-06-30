package tech.zxuuu.hotel24h.entity;

// 员工类
public class Manager {

    private String id; // 经理账号
    private String password; // 经理密码
    private String name; // 经理姓名
    private String contact;

    public Manager(String id, String password, String name,String contact) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.contact=contact;
    }

    public Manager() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
