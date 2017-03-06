package com.ips.services;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ips.dao.UserDao;
import com.ips.dto.PositioningData;
import com.ips.dto.User;
import com.ips.services.api.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by shenwenbo on 2017/2/15.
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserDao userDao;

    @Override
    public void add(User user) {
       userDao.add(user);
    }

    @Override
    public User load(int userId) {
        return userDao.load(userId);
    }

    @Override
    public void delete(int userId) {
        userDao.delete(userId);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public PageInfo<User> queryByPage(Integer pageIndex, Integer pageSize) {
        pageIndex = pageIndex == null?0:pageIndex;
        pageSize = pageSize == null?10:pageSize;
        PageHelper.startPage(pageIndex, pageSize);
        List<User> list = userDao.list();
        //用PageInfo对结果进行包装
        PageInfo<User> page = new PageInfo<User>(list);
        return page;
    }

    @Override
    public User queryByUserNameAndPassWord(String username, String password) {
        return userDao.queryByUserNameAndPassWord(username,password);
    }

    @Override
    public User loadByUserName(String username) {
        return userDao.loadByUserName(username);
    }
}
