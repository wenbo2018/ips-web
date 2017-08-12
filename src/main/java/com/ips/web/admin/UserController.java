package com.ips.web.admin;

import com.github.pagehelper.PageInfo;
import com.ips.dto.PageModel;
import com.ips.dto.User;
import com.ips.services.api.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by shenwenbo on 2017/2/15.
 */
@Controller
@RequestMapping(value ="/admins/users")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping(value = "/userPagses", method = RequestMethod.GET)
    @ResponseBody
    public PageModel<User> pageModel(int pageIndex,int pageSize) {
        PageInfo<User> pageInfo=userService.queryByPage(pageIndex+1,pageSize);
        PageModel<User> pageModel=new PageModel<User>();
        pageModel.setList(pageInfo.getList());
        pageModel.setPageIndex(pageInfo.getPageNum());
        pageModel.setTotal((int) pageInfo.getTotal());
        pageModel.setPageSize(pageInfo.getPageSize());
        return pageModel;
    }

    /***
     * 根据userId删除User
     * @param userId
     * @return
     */
    @RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,String> deleteUserByUserId(int userId) {
        Map<String,String> code=new HashMap<>();
        userService.delete(userId);
        code.put("code","200");
        return code;
    }

}
