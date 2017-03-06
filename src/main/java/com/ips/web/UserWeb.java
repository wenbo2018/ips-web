package com.ips.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by shenwenbo on 2016/10/4.
 */
@Controller
@RequestMapping(value ="/User")
public class UserWeb {

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


}
