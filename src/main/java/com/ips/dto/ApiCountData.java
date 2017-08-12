package com.ips.dto;

import java.util.Date;

/**
 * Created by shenwenbo on 2017/2/19.
 */
public class ApiCountData {
    private Date date;
    private int count;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
