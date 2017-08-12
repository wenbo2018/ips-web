package com.ips.web;

import com.ips.dto.User;
import com.ips.services.api.SmsVerificationCodeService;
import com.ips.services.api.UserService;
import com.ips.util.MD5Util;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by shenwenbo on 2016/10/4.
 */
@Controller
@RequestMapping(value ="/User")
public class UserWeb {

    private  static String regExp = "^((13[0-9])|(15[^4])|(18[0,2,3,5-9])|(17[0-8])|(147))\\d{8}$";

    @Resource
    private SmsVerificationCodeService messageService;
    @Resource
    UserService userService;

    @RequestMapping(value = "/UserPhotoUpload", method = RequestMethod.GET)
    private String userPhotoUpload() {

        return "user/UserPhotoUpload";
    }

    @RequestMapping(value = "/UserLogin", method = RequestMethod.GET)
    private String userLogin() {

        return "user/UserLogin";
    }

    @RequestMapping(value = "/UserLoginCheck", method = RequestMethod.POST)
    private String userLoginCheck() {

        return "user/UserLogin";
    }

    //http接口地址:ip/api/online/positioning/mapConstruction
    @RequestMapping(value = "/getCheckCode", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,String> getCheckCode(String phone) {
        Map<String,String> result=new HashMap<>();
        result.put("code","200");
        Pattern p = Pattern.compile(regExp);
        Matcher m = p.matcher(phone);
        if (!m.matches()) {
            result.put("code","401");
            result.put("message","请输入正确的手机号码");
        }
        String msg=messageService.sendMessage(phone);
        return result;
    }

    //http接口地址:ip/api/online/positioning/mapConstruction
    @RequestMapping(value = "/checkCode", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,String> checkCode(@RequestBody Map<String, String> parms) {
        Map<String,String> result=new HashMap<>();
        result.put("code","200");
        String phone=parms.get("phone");
        String code=parms.get("code");
        if (!messageService.checkIsCorrectCode(phone,code)) {
            result.put("code","401");
            result.put("message","验证码不正确，请输入正确的验证码");
        }
        //首次认证时创建用户账号默认手机号码为用户名及密码
        if (userService.loadByUserName(String.valueOf(phone))==null) {
            User user=new User();
            user.setUsername(phone);
            user.setPassword(MD5Util.encryption(phone));
            userService.add(user);
        }
        result.put("md5code",MD5Util.encryption(phone));
        return result;
    }


}
