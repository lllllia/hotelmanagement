package tech.zxuuu.hotel24h.interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Configuration
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    //@Bean
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        Object id = session.getAttribute("customerID");
        System.out.println("110");
        System.out.println(id);
        if (id != null) {
            return true;
        } else {
            //request.getRequestDispatcher("/signin").forward(request, response);
            response.sendRedirect(request.getContextPath() + "/signin.html");
            return false;
        }
    }
}
