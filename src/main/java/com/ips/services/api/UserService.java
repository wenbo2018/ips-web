package com.ips.services.api;

import com.ips.dto.User;

/**
 * Created by shenwenbo on 2016/10/4.
 */
public interface UserService {

    public void add(User user);

    public User load(int userId);

    public void delete(int userId);

    public void update(User user);

}
