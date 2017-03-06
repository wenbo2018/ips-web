package com.ips.dao;

import com.ips.dto.ApStringMac;

import java.util.List;

/**
 * Created by shenwenbo on 2017/2/12.
 */
public interface ApStringMacDao {

    public void addApStringMac(ApStringMac apStringMac);

    public void deleteApStringMac();

    public List<ApStringMac> list();

    public void delete(int apId);

}
