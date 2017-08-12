package com.ips.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by shenwenbo on 2016/10/7.
 */
@Controller
@RequestMapping(value ="/sys")
public class SystemSettingWeb {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    private String index() {
        return "system_setting";
    }


    @RequestMapping(value = "/userAccountSet", method = RequestMethod.GET)
    private String test() {

        return "sys/userAccountSet";
    }

    @RequestMapping(value = "/sysTool", method = RequestMethod.GET)
    private String sysTool() {

        return "sys/sysTool";
    }

    @RequestMapping(value = "/serverSet", method = RequestMethod.GET)
    private String serverSet() {

        return "sys/serverSet";
    }


    @RequestMapping(value = "/mapList", method = RequestMethod.GET)
    private String mapList() {

        return "sys/map_list";
    }

}
