package com.ips.dao;

import com.github.pagehelper.PageInfo;
import com.ips.dto.PositioningData;
import com.ips.dto.User;

import java.util.List;

/**
 * Created by shenwenbo on 2017/2/15.
 */
public interface UserDao {


    public void add(User user);

    public User load(int userId);

    public User loadByUserName(String username);

    public void delete(int userId);

    public void update(User user);

    List<User> list();

    User queryByUserNameAndPassWord(String username,String password);

}
