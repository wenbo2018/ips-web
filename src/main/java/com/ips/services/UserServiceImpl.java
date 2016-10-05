package com.ips.services;

import com.ips.dao.UserDao;
import com.ips.dto.User;
import com.ips.services.api.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by shenwenbo on 2016/10/4.
 */
@Service
public class UserServiceImpl implements UserService{

    @Resource
    private UserDao userDao;

    @Override
    public void add(User user) {

    }

    @Override
    public User load(int userId) {
        return null;
    }

    @Override
    public void delete(int userId) {

    }

    @Override
    public void update(User user) {

    }
}
