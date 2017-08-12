package com.ips.redis;

import java.io.Serializable;

/**
 * Created by shenwenbo on 2017/3/6.
 */
public class RedisKeyDto implements Serializable{

    private static final long serialVersionUID = 8848809780626060827L;

    private String keys;
    private String values;

    public String getKeys() {
        return keys;
    }

    public void setKeys(String keys) {
        this.keys = keys;
    }

    public String getValues() {
        return values;
    }

    public void setValues(String values) {
        this.values = values;
    }
}
