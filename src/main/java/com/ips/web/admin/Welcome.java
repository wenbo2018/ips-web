package com.ips.web.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by shenwenbo on 2017/3/6.
 */
@Controller
public class Welcome {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "web/m";
    }

    @RequestMapping(value = {" ", "/"})
    public String index2() {
        return "web/m";
    }
}
