package tech.zxuuu.hotel24h.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tech.zxuuu.hotel24h.entity.Customer;
import tech.zxuuu.hotel24h.entity.Comment;
import tech.zxuuu.hotel24h.entity.Reserve;
import tech.zxuuu.hotel24h.entity.Room;
import tech.zxuuu.hotel24h.service.LoginService;
import tech.zxuuu.hotel24h.service.RoomService;
import tech.zxuuu.hotel24h.service.ReserveService;
import tech.zxuuu.hotel24h.service.AdminService;
import tech.zxuuu.hotel24h.util.JSONUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDate;
import java.time.ZoneId;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.concurrent.TimeUnit;

@Controller
public class LoginController {

  @Autowired
  private LoginService loginService;
  @Autowired
  private RoomService roomService;
  @Autowired
  private ReserveService reserveService;

  @Autowired
  private AdminService adminService;

  int i=7;
  Date dateS,dateE;
  String roomCount,guestCount;
  String searchS,searchE;
  String USERNAME;
  @RequestMapping(path = "/")
  public String turnIndexPage() {
    return "index1";
  }

  @GetMapping(path = "/logout")
  public String logout(HttpSession session) {
    session.invalidate();
    return "signin";
  }

  @GetMapping(path = "/signin.html")
  public String turnToLoginPage() {
    return "signin";
  }

  @GetMapping(path = "/register.html")
  public String turnToRegisterPage() {
    return "register";
  }

  @GetMapping(path = "/adminPage")
  public String turnToAdminPage() {
    return "admin/login";
  }

  @GetMapping(path = "/index.html")
  public String turnToIndexPage() {
    return "index";
  }

  @GetMapping(path = "/index1.html")
  public String turnToIndex1Page() {
    return "index1";
  }

  @GetMapping(path = "/listing.html")
  public String Listing() {
    return "listing";
  }

  @GetMapping(path = "/traveler-information.html")
  public String Info() {
    return "traveler-information";
  }

  @GetMapping(path = "/hotel-detail.html")
  public String Detail() {
    return "hotel-detail";
  }

  @GetMapping(path = "/contact-us.html")
  public String Contact() {
    return "contact-us";
  }


    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Map<String, String> credentials, HttpSession session) {
      USERNAME=credentials.get("username");
      Customer customer = this.loginService.empLogin(credentials.get("username"), credentials.get("password"));
      if (customer == null) {//用户名或密码错误或者用户不存在
        return new ResponseEntity<>("{\"success\":false}", HttpStatus.UNAUTHORIZED);
      } else {//登录成功
        session.setAttribute("customerID", customer.getId());
        //session.setMaxInactiveInterval(600);
        return new ResponseEntity<>("{\"success\":true}", HttpStatus.OK);
      }
    }

    @PostMapping("/register")
    public @ResponseBody String register(@RequestBody Map<String, String> userDataMap) {
      String username = userDataMap.get("username");
      String password = userDataMap.get("password");
      Map<String, Boolean> responseMap = new HashMap<>();
      Customer customer = this.loginService.empLogin(username, password);
      if (customer == null) {//不存在该用户，可以注册
        Customer cus = new Customer(username, password, "","","","");
        loginService.insertCustomer(cus);
        responseMap.put("success", true);
      } else {//已存在该用户，不能注册，请直接登录
        responseMap.put("success", false);
      }
      // 将原始 Map 参数转换为新的 Map 参数
      Map<String, Object> newResponseMap = new HashMap<>();
      for (Map.Entry<String, Boolean> entry : responseMap.entrySet()) {
        newResponseMap.put(entry.getKey(), entry.getValue());
      }
      // 调用 JSONUtils.buildJSON() 方法并传递新的 Map 参数
      return JSONUtils.buildJSON(newResponseMap);
    }

  @PostMapping("/search-rooms")
  public ResponseEntity<Map<String, Object>> searchRooms(@RequestBody Map<String, String> searchData) {
    String checkIn = searchData.get("checkIn");
    String checkOut = searchData.get("checkOut");
    roomCount=searchData.get("roomCount");
    guestCount=searchData.get("guestCount");
    //System.out.println(checkIn);System.out.println(checkOut);
    SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
    Date dateIn = null;
    Date dateOut = null;
    try {
      dateIn = dateFormat.parse(checkIn);
      dateOut = dateFormat.parse(checkOut);
    } catch (ParseException e) {
      e.printStackTrace();
    }
    dateS=dateIn;
    dateE=dateOut;
    searchS=checkIn;
    searchE=checkOut;
    List<Reserve> rooms = this.reserveService.searchRooms(dateIn,dateOut);
    Map<String, Object> dataMap = new HashMap<>();
    dataMap.put("rooms", rooms);
    return ResponseEntity.ok(dataMap);
  }
  @GetMapping("/get-booking-data")
  public @ResponseBody String getBookingData() {
  //public ResponseEntity<Map<String, Object>> getBookingData(@RequestBody Map<String, String> searchData) {
    Map<String, Object> dataMap = new HashMap<>();
    dataMap.put("checkIn", searchS);
    dataMap.put("checkOut", searchE);
    dataMap.put("roomCount", roomCount);
    dataMap.put("guestCount", guestCount);
    return JSONUtils.buildJSON(dataMap);
  }
  @PostMapping("/save-order-data")
  public @ResponseBody String reseverIn(@RequestBody Map<String, String> formData) {
    i++;
    String roomId = formData.get("roomId");
    String guestName = formData.get("guestName");
    String phoneNumber = formData.get("email");
    Date currentDate = new Date();
    long diffInMillies = Math.abs(dateE.getTime() - dateS.getTime());
    long diffInDays = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
    int cost=roomService.cost(Integer.parseInt(roomId))*(int)diffInDays;
    Reserve reserve = new Reserve(i,roomId, guestName,phoneNumber, currentDate,"已预订",dateS,dateE,cost);
    reserveService.addReserve(reserve);
    reserveService.Reserve(reserve,"已预订");
    Map<String, Boolean> responseMap = new HashMap<>();
    responseMap.put("success", true);
    // 将原始 Map 参数转换为新的 Map 参数
    Map<String, Object> newResponseMap = new HashMap<>();
    for (Map.Entry<String, Boolean> entry : responseMap.entrySet()) {
      newResponseMap.put(entry.getKey(), entry.getValue());
    }
    // 调用 JSONUtils.buildJSON() 方法并传递新的 Map 参数
    return JSONUtils.buildJSON(newResponseMap);
  }
  @PostMapping("/save-review")
  public @ResponseBody String review(@RequestBody Map<String, String> reviewDataMap) {
    String name=reviewDataMap.get("name");
    String roomNumber=reviewDataMap.get("roomNumber");
    String phoneNumber=reviewDataMap.get("phoneNumber");
    String email=reviewDataMap.get("email");
    String review=reviewDataMap.get("review");
    Date currentDate = new Date();
    Comment comment=new Comment(name,Integer.parseInt(roomNumber),phoneNumber,email,Integer.parseInt(review),currentDate);
    reserveService.insertComment(comment);
    Map<String, Boolean> responseMap = new HashMap<>();
    responseMap.put("success", true);
    // 将原始 Map 参数转换为新的 Map 参数
    Map<String, Object> newResponseMap = new HashMap<>();
    for (Map.Entry<String, Boolean> entry : responseMap.entrySet()) {
      newResponseMap.put(entry.getKey(), entry.getValue());
    }
    // 调用 JSONUtils.buildJSON() 方法并传递新的 Map 参数
    return JSONUtils.buildJSON(newResponseMap);
  }

  @GetMapping("/your-backend-personOrder-api-endpoint")
  public @ResponseBody String getpersonOrderData() {
    List<Reserve> personOrderData = reserveService.getpersonList(USERNAME);
    Map<String, Object> dataMap = new HashMap<>();
    dataMap.put("personOrderData", personOrderData);
    return JSONUtils.buildJSON(dataMap);
  }

  @PostMapping("/your-backend-deletepersonOrder-api-endpoint")
  public @ResponseBody String deletePersonOrders(@RequestBody List<Integer> data) {
    for(int j=0;j< data.size();j++)
      adminService.deleteReserve(data.get(j));
    Map<String, Boolean> responseMap = new HashMap<>();
    responseMap.put("success", true);
    Map<String, Object> newResponseMap = new HashMap<>();
    for (Map.Entry<String, Boolean> entry : responseMap.entrySet()) {
      newResponseMap.put(entry.getKey(), entry.getValue());
    }
    // 调用 JSONUtils.buildJSON() 方法并传递新的 Map 参数
    return JSONUtils.buildJSON(newResponseMap);
  }
}
