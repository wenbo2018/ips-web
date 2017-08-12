package com.ips.aop;

import com.ips.dao.ApiDataDao;
import com.ips.dto.ApiData;
import com.ips.services.api.ApiDataService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by shenwenbo on 2017/2/17.
 */
public class InterceptorAop {



    public void doBefore() {

        System.out.println("========执行前置通知==========");
    }

    public void doAferReturning() {
        System.out.println("=========执行后置通知================");
    }

    public void doAfter() {

        System.out.println("========执行最终通知==========");
    }

    public void doAferThrowing() {




//        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        ApiData apiData=new ApiData();
//        apiData.setApiUrl(request.getRequestURL().toString());
//        apiData.setClientIp(getLocalIp(request));
        apiData.setRequestTotalCount(1);
        apiData.setStatus(0);
        System.out.println("=============执行意外通知================");
    }

    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {

        System.out.println("=========进入判断方法===========");
        Object result = pjp.proceed();
        System.out.println("==========进入退出方法==========");
        return result;
    }


    public  String getLocalIp(HttpServletRequest request) {
        String remoteAddr = request.getRemoteAddr();
        String forwarded = request.getHeader("X-Forwarded-For");
        String realIp = request.getHeader("X-Real-IP");

        String ip = null;
        if (realIp == null) {
            if (forwarded == null) {
                ip = remoteAddr;
            } else {
                ip = remoteAddr + "/" + forwarded.split(",")[0];
            }
        } else {
            if (realIp.equals(forwarded)) {
                ip = realIp;
            } else {
                if(forwarded != null){
                    forwarded = forwarded.split(",")[0];
                }
                ip = realIp + "/" + forwarded;
            }
        }
        return ip;
    }
}
