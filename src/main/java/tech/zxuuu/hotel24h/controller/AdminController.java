package tech.zxuuu.hotel24h.controller;

import org.apache.avro.data.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tech.zxuuu.hotel24h.entity.*;
import tech.zxuuu.hotel24h.service.RoomService;
import tech.zxuuu.hotel24h.service.AdminService;
import tech.zxuuu.hotel24h.service.ReserveService;
import tech.zxuuu.hotel24h.util.JSONUtils;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.List;
import java.util.Date;
import java.util.Calendar;
import com.alibaba.fastjson.JSON;
//import static org.apache.zookeeper.client.ZooKeeperSaslClient.login;

@Controller
public class AdminController {

  @Autowired
  private AdminService adminService;
  @Autowired
  private ReserveService reserveService;
  @Autowired
  private RoomService RoomService;
  int i=3;

  @GetMapping("/admin/login.html")
  public String turnToAdminLogin() {
    return "admin/login";
  }

  @GetMapping("admin/html/admin-list.html")
  public String turnToAdminListPage() {
    return "admin/html/admin-list";
  }

  @GetMapping("admin/admin-list.html")
  public String turnToAdminList1Page() {
    return "admin/admin-list";
  }

  @GetMapping(path = "/admin/html/peronlist.html")
  public String turnToReservePage() {
    return "admin/html/peronlist";
  }

  @GetMapping("/admin/html/member-list.html")
  public String turnToAdminMemberPage() {
    return "admin/html/member-list";
  }

  @GetMapping("/admin/html/member-add.html")
  public String turnToAdminMemberAddPage() {
    return "admin/html/member-add";
  }

  @GetMapping("/admin/ht1/index_v1.html")
  public String turnToMonthlyPage() {
    return "admin/ht1/index_v1";
  }

  @GetMapping("/admin/adminindex.html")
  public String turnToAdminPage() {
    return "admin/adminindex";
  }

  @GetMapping("/admin/house_list.html")
  public String turnToHousePage() {
    return "admin/house_list";
  }

  @GetMapping("/admin/loupanchart.html")
  public String turnToChartPage() {
    return "admin/loupanchart";
  }

  @GetMapping("/your-backend-member-api-endpoint")
  public @ResponseBody String getMemberData() {
    List<Emp> memberData = adminService.queryAllEmp();
    Map<String, Object> dataMap = new HashMap<>();
    dataMap.put("memberData", memberData);
    return JSONUtils.buildJSON(dataMap);
  }
  @GetMapping("/your-backend-order-api-endpoint")
  public @ResponseBody String getOrderData() {
    List<Reserve> orderData = reserveService.queryAllReserves("空闲");
    Map<String, Object> dataMap = new HashMap<>();
    dataMap.put("orderData", orderData);
    return JSONUtils.buildJSON(dataMap);
  }
  @GetMapping("/your-backend-api-endpoint")
  public @ResponseBody String getRoomData() {
    List<Room> roomData = RoomService.getAllRooms();
    Map<String, Object> dataMap = new HashMap<>();
    dataMap.put("roomData", roomData);
    return JSONUtils.buildJSON(dataMap);
  }
  @DeleteMapping("/your-backend-delete-api-endpoint")//删除员工
  public @ResponseBody String deleteEmp(@RequestParam("id") Integer id) {
    adminService.deleteEmp(id);
    return "success";
  }
  @DeleteMapping("/delete-reserve")//删除订单
  public @ResponseBody String deleteReserve(@RequestParam("id") Integer id) {
    adminService.deleteReserve(id);
    return "success";
  }
  @PostMapping("/your-backend-save-employee-api-endpoint")
  public @ResponseBody String insertEmp(@RequestBody Map<String, String> empDataMap) {
    i++;
    String username=empDataMap.get("username");
    String gender=empDataMap.get("gender");
    String phonenumber=empDataMap.get("phonenumber");
    String email=empDataMap.get("email");
    String address=empDataMap.get("address");
    String state=empDataMap.get("state");
    Emp emp=new Emp(i,username,gender,phonenumber,email,address,state);
    boolean flag=adminService.insertEmp(emp);
    Map<String, Boolean> responseMap = new HashMap<>();
    if(flag)
      responseMap.put("success", true);
    else
      responseMap.put("success",false);
    // 将原始 Map 参数转换为新的 Map 参数
    Map<String, Object> newResponseMap = new HashMap<>();
    for (Map.Entry<String, Boolean> entry : responseMap.entrySet()) {
      newResponseMap.put(entry.getKey(), entry.getValue());
    }
    // 调用 JSONUtils.buildJSON() 方法并传递新的 Map 参数
    return JSONUtils.buildJSON(newResponseMap);
  }

  @PostMapping("/api/updateMemberStatus")
  public @ResponseBody String updateEmpStatus(@RequestBody Map<String, String> empDataMap) {
    System.out.println("!!!");
    String memberId = empDataMap.get("memberId");
    String status = empDataMap.get("status");
    adminService.updateEmp(Integer.parseInt(memberId), status);
    Map<String, Boolean> responseMap = new HashMap<>();
    responseMap.put("success", true);
    Map<String, Object> newResponseMap = new HashMap<>();
    for (Map.Entry<String, Boolean> entry : responseMap.entrySet()) {
      newResponseMap.put(entry.getKey(), entry.getValue());
    }
    // 调用 JSONUtils.buildJSON() 方法并传递新的 Map 参数
    return JSONUtils.buildJSON(newResponseMap);
  }
  @PostMapping("/api/updateRoomStatus")
  public @ResponseBody String updateRoomStatus(@RequestBody Map<String, String> roomDataMap) {
    System.out.println("???");
    String roomNumber= roomDataMap.get("roomNumber");
    String newStatus = roomDataMap.get("status");
    String id=roomDataMap.get("rid");
    adminService.updateRoom(Integer.parseInt(id), newStatus);
    RoomService.updateRoom(Integer.parseInt(roomNumber), newStatus);
    Map<String, Boolean> responseMap = new HashMap<>();
    responseMap.put("success", true);
    Map<String, Object> newResponseMap = new HashMap<>();
    for (Map.Entry<String, Boolean> entry : responseMap.entrySet()) {
      newResponseMap.put(entry.getKey(), entry.getValue());
    }
    // 调用 JSONUtils.buildJSON() 方法并传递新的 Map 参数
    return JSONUtils.buildJSON(newResponseMap);
  }

  @PutMapping("/clean")
  public @ResponseBody String clean(@RequestParam Integer id, @RequestBody Map<String, String> statusDataMap) {
    System.out.println("***");
    String roomid=statusDataMap.get("roomid");
    String newStatus = statusDataMap.get("status");
    adminService.updateRoom(id, newStatus);
    RoomService.updateRoom(Integer.parseInt(roomid), newStatus);
    Map<String, Boolean> responseMap = new HashMap<>();
    responseMap.put("success", true);
    Map<String, Object> newResponseMap = new HashMap<>();
    for (Map.Entry<String, Boolean> entry : responseMap.entrySet()) {
      newResponseMap.put(entry.getKey(), entry.getValue());
    }
    // 调用 JSONUtils.buildJSON() 方法并传递新的 Map 参数
    return JSONUtils.buildJSON(newResponseMap);
  }


  @GetMapping("/month")
  public @ResponseBody String month() {
    Date currentDate = new Date();
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(currentDate);
    // 获取本月第一天：
    calendar.set(Calendar.DAY_OF_MONTH, 1);
    Date firstDayOfMonth = calendar.getTime();
    // 获取本月最后一天：
    calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
    Date lastDayOfMonth = calendar.getTime();
    //System.out.println(firstDayOfMonth,lastDayOfMonth);
    float occupancyRate=adminService.getRate(firstDayOfMonth,lastDayOfMonth);
    int bookingCount=adminService.getCount(firstDayOfMonth,lastDayOfMonth);
    int salesAmount=adminService.getIncome(firstDayOfMonth,lastDayOfMonth);
    Map<String, Object> dataMap = new HashMap<>();
    dataMap.put("occupancyRate", occupancyRate);
    dataMap.put("bookingCount", bookingCount);
    dataMap.put("salesAmount", salesAmount);
    return JSONUtils.buildJSON(dataMap);
  }

  @GetMapping("/month-comment")
  public @ResponseBody String monthcomment() {
    Date currentDate = new Date();
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(currentDate);
    // 获取本月第一天：
    calendar.set(Calendar.DAY_OF_MONTH, 1);
    Date firstDayOfMonth = calendar.getTime();
    // 获取本月最后一天：
    calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
    Date lastDayOfMonth = calendar.getTime();
    float score=adminService.getSorce(firstDayOfMonth,lastDayOfMonth);
    Map<String, Object> dataMap = new HashMap<>();
    dataMap.put("roomData", score);
    return JSONUtils.buildJSON(dataMap);
  }
}
