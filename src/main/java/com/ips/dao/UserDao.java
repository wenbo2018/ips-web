package com.ips.dao;

import com.ips.dto.User;

/**
 * Created by shenwenbo on 2016/10/4.
 */
public interface UserDao {

    public void add(User user);

    public User load(int userId);

    public void delete(int userId);

    public void update(User user);

}
