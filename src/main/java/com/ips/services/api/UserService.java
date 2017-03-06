package com.ips.services.api;

import com.github.pagehelper.PageInfo;
import com.ips.dto.PositioningData;
import com.ips.dto.RssIData;
import com.ips.dto.User;

/**
 * Created by shenwenbo on 2017/2/15.
 */
public interface UserService {

    public void add(User user);

    public User load(int userId);

    public void delete(int userId);

    public void update(User user);

    /**
     * PositioningData 分页查询接口
     * @param pageIndex
     * @param pageSize
     * @return
     */
    PageInfo<User> queryByPage(Integer pageIndex, Integer pageSize);

    User queryByUserNameAndPassWord(String username,String password);

    public User loadByUserName(String username);
}
