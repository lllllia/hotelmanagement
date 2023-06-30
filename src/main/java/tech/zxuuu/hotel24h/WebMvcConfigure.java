package tech.zxuuu.hotel24h;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import tech.zxuuu.hotel24h.interceptor.LoginInterceptor;
import tech.zxuuu.hotel24h.interceptor.AdminInterceptor;

@Configuration
public class WebMvcConfigure implements WebMvcConfigurer {

  @Autowired
  private LoginInterceptor loginInterceptor;

  @Autowired
  private AdminInterceptor adminInterceptor;

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(loginInterceptor).addPathPatterns("/listing.html","/contact-us.html","/index.html","/admin/html/peronlist.html","/hotel-detail.html");
    //registry.addInterceptor(adminInterceptor).addPathPatterns("/admin/adminindex.html","/admin/html/admin-list.html","/admin/html/member-list.html","/admin/html/member-add.html","/admin/loupanchart.html","/admin./ht1/index_v1.html");
  }


  /*
  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/**")
      .allowedOrigins("http://localhost:5500", "http://127.0.0.1:5500", "http://127.0.0.1:5500", "http://127.0.0.1:5500")
      .allowCredentials(true)
      .allowedMethods("*")
      .maxAge(3600);
  }*/

}
