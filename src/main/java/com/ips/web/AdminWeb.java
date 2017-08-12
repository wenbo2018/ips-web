package com.ips.web;

import com.github.pagehelper.PageInfo;
import com.ips.dao.UserDao;
import com.ips.dto.PositioningData;
import com.ips.dto.RadioSignalStrength;
import com.ips.dto.User;
import com.ips.services.api.PositioningDataService;
import com.ips.services.api.RadioSignalStrengthService;
import com.ips.services.api.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by shenwenbo on 2016/11/10.
 */
@Controller
@RequestMapping(value ="/admin")
public class AdminWeb {


    @Resource
    private PositioningDataService positioningDataService;

    @Resource
    private UserService userService;


    @Resource
    private RadioSignalStrengthService radioSignalStrengthService;


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    private String index() {

        return "index";
    }
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    private String login() {


        return "admin/index";
    }

    @RequestMapping(value = "/PositioningDataAdmin", method = RequestMethod.GET)
    private  String positioningDataAdminIndex(Model model) {
        PageInfo<PositioningData> pageInfo=positioningDataService.queryByPage(1,10);
        model.addAttribute("totalPage",pageInfo.getTotal());
        model.addAttribute("total_radio_Page",pageInfo.getTotal());
        return "admin/PositioningDataAdmin";
    }

    /**
     * 返回定位数据json代码
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/PositioningDataAdminPage", method = RequestMethod.POST)
    @ResponseBody
    private List<PositioningData>  positioningShow(int pageIndex,int pageSize) {
        PageInfo<PositioningData> pageInfo=positioningDataService.queryByPage(pageIndex,pageSize);
        return pageInfo.getList();
    }



    /**
     * 返回wifi数据json代码
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/RadioDataAdminPage", method = RequestMethod.POST)
    @ResponseBody
    private List<RadioSignalStrength>  wifiShow(int pageIndex,int pageSize) {
        PageInfo<RadioSignalStrength> pageInfo=radioSignalStrengthService.queryByPage(pageIndex,pageSize);
        return pageInfo.getList();
    }



    @RequestMapping(value = "/UserAdmin", method = RequestMethod.GET)
    private  String puserAdminIndex(Model model) {
        PageInfo<User> pageInfo=userService.queryByPage(1,10);
        model.addAttribute("totalPage",pageInfo.getTotal());
        return "admin/UserAdmin";
    }

    @RequestMapping(value = "/UserAdminPage", method = RequestMethod.POST)
    @ResponseBody
    private List<User>  userPageShow(int pageIndex,int pageSize) {
        PageInfo<User> pageInfo=userService.queryByPage(pageIndex,pageSize);
        return pageInfo.getList();
    }


    @RequestMapping(value = "/DeleteUser", method = RequestMethod.GET)
    private String deleteUser(int userId) {
        userService.delete(userId);
       return  "admin/UserAdmin";
    }

    @RequestMapping(value = "/UpdateUser", method = RequestMethod.GET)
    private String updateUser(int userId) {
        userService.delete(userId);
        return  "admin/UpdateUser";
    }

}
