package com.ips.web.admin;

import com.ips.dto.User;
import com.ips.services.api.UserService;
import com.ips.util.MD5Util;
import lombok.experimental.PackagePrivate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by shenwenbo on 2017/2/15.
 */
@Controller
@RequestMapping(value ="/sso")
public class AdminController {

    @Resource
    private UserService userService;


    @RequestMapping(value = "/admins/index", method = RequestMethod.GET)
    public String index() {
      return "web/index";
    }



    @RequestMapping(value = "/admins/users", method = RequestMethod.GET)
    public String users() {
        return "web/user/users";
    }



    @RequestMapping(value = "/admins/datas", method = RequestMethod.GET)
    public String datas() {
        return "web/data/datas";
    }

    @RequestMapping(value = "/admins/maps", method = RequestMethod.GET)
    public String maps() {
        return "web/data/maps";
    }


    @RequestMapping(value = "/admins/apis", method = RequestMethod.GET)
    public String apis() {
        return "web/api/apis";
    }


    @RequestMapping(value = "/loginCheck", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,String> loginCheck(String username,String password,HttpServletRequest request) {
        Map<String,String> code=new HashMap<>();
        if (userService.queryByUserNameAndPassWord(username,MD5Util.encryption(password))!=null) {
            HttpSession session = request.getSession();
            session.setAttribute("Global.USER_SESSION_KEY", username);
            code.put("code","200");
            return code;//转向到前画面
        }
        code.put("code","401");
        code.put("message","用户名或密码错误");
        return code;
    }


    @RequestMapping(value = "/signUpAdd", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,String> signUpAdd(String username,String password,String email,HttpServletRequest request) {
        Map<String,String> code=new HashMap<>();

        if (userService.loadByUserName(username)==null) {
            User user=new User();
            user.setUsername(username);
            user.setPassword(MD5Util.encryption(password));
            user.setEmail(email);
            userService.add(user);
            HttpSession session = request.getSession();
            session.setAttribute("Global.USER_SESSION_KEY", username);
            code.put("code","200");
            return code;//转向到前画面
        }
        code.put("code","401");
        code.put("message","用户名被占用");
        return code;
    }



    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "web/signin";
    }

    @RequestMapping(value = "/sginup", method = RequestMethod.GET)
    public String signin() {
        return "web/signup";
    }


    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute("Global.USER_SESSION_KEY");
        return "web/signin";
    }


}
