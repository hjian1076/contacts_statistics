package com.xyk.interceptor;

import com.xyk.entity.User;
import com.xyk.util.memory.MemoryData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 检查用户是否已登录的拦截器
 *
 * @author hejx
 * @email doubihah@foxmail.com
 * @create 2017-05-22 11:26
 **/
public class CheckUserInterceptor extends HandlerInterceptorAdapter {

    private final Logger log = LoggerFactory.getLogger(CheckUserInterceptor.class);


    /**
     * 在业务处理器处理请求之前被调用
     * 如果返回false
     * 从当前的拦截器往回执行所有拦截器的afterCompletion(),再退出拦截器链
     * 如果返回true
     * 执行下一个拦截器,直到所有的拦截器都执行完毕
     * 再执行被拦截的Controller
     * 然后进入拦截器链,
     * 从最后一个拦截器往回执行所有的postHandle()
     * 接着再从最后一个拦截器往回执行所有的afterCompletion()
     */
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {

//        String requestUri = request.getRequestURI();
//        String contextPath = request.getContextPath();
//        String url = requestUri.substring(contextPath.length());
//
//        log.info("requestUri:" + requestUri);
//        log.info("contextPath:" + contextPath);
//        log.info("url:" + url);

        Object user_obj = request.getSession().getAttribute("user");
        if (user_obj == null) {
            log.info("Interceptor：跳转到login页面！");
            response.sendRedirect("/login");
            return false;
        } else {
            User user = (User)user_obj;
            String sessionId = MemoryData.getSessionIDMap().get(user.getId().toString());
            //如果用户名存在放心（即登录放行）
            if(request.getRequestedSessionId().equals(sessionId)){
                return true;
            }else{
                //如果请求的sessionID和此账号Map中存放的sessionID不一致，跳转到登陆页
                //有人把他挤掉了
                log.info("用户被挤掉了,username:"+user.getUsername());
                response.sendRedirect("/login");
                return false;
            }
        }// if (user_obj == null)  else
    }

}


