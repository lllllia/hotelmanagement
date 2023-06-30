package tech.zxuuu.hotel24h.entity;
import java.util.Date;
// 员工类
public class Emp {

  private int EmployeeID; // 员工账号
  private String EmployeePassword; // 员工密码
  private String EmployeeName; // 员工姓名
  private String EmployeeGender;
  private String EmployeePhone;
  private String EmployeeEmail;
  private String EmployeeAddress;
  private Date EmployeeTime;
  private String EmployeeCitizenID;
  private String EmployeeState;
  private String EmployeeContact;

  public Emp(int id, String name,String EmployeeGender,String EmployeePhone,String EmployeeEmail,String EmployeeAddress,String EmployeeState) {
    this.EmployeeID = id;
    this.EmployeeName=name;
    this.EmployeeGender = EmployeeGender;
    this.EmployeePhone = EmployeePhone;
    this.EmployeeEmail = EmployeeEmail;
    this.EmployeeAddress = EmployeeAddress;
    //this.EmployeeTime = EmployeeTime;
    this.EmployeeState=EmployeeState;
  }

  public Emp() {
  }

  public int getId() {
    return EmployeeID;
  }

  public void setId(int id) {
    this.EmployeeID = id;
  }

  public String getPassword() {
    return EmployeePassword;
  }

  public void setPassword(String password) {
    this.EmployeePassword = password;
  }

  public String getName() {
    return EmployeeName;
  }

  public void setName(String name) {
    this.EmployeeName = name;
  }

  public String getEmployeeGender() {
    return EmployeeGender;
  }

  public void setEmployeeGender(String gender) {
    this.EmployeeGender = gender;
  }
  public String getEmployeePhone() {
    return EmployeePhone;
  }

  public void setEmployeePhone(String phone) {
    this.EmployeePhone = phone;
  }

  public String getEmployeeEmail() {
    return EmployeeEmail;
  }

  public void setEmployeeEmail(String email) {
    this.EmployeeEmail = email;
  }

  public String getEmployeeAddress() {
    return EmployeeAddress;
  }

  public void setEmployeeAddress(String address) {
    this.EmployeeAddress = address;
  }

  public Date getEmployeeTime() {
    return EmployeeTime;
  }

  public void setEmployeeTime(Date time) {
    this.EmployeeTime = time;
  }

  public String getEmployeeState() {
    return EmployeeState;
  }

  public void setEmployeeState(String state) {
    this.EmployeeState = state;
  }
}
