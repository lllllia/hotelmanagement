package tech.zxuuu.hotel24h.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Configuration
public class AdminInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        Object id = session.getAttribute("adminPass");
        System.out.println("120");
        System.out.println(id);
        if (id != null) {
            return true;
        } else {
            //request.getRequestDispatcher("/signin").forward(request, response);
            response.sendRedirect(request.getContextPath() + "/admin/login.html");
            return false;
        }
    }
}
