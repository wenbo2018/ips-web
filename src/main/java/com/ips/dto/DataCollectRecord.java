package com.ips.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by shenwenbo on 2016/10/30.
 */
public class DataCollectRecord implements Serializable{

    private int id;

    private int position;

    private String mobilePhone;

    private int dataSizes;

    private Date datetime;

    /****
     * 1代表WiFi数据，2代表IMU,3代表WIFI+imu
     */
    private int dataType;


    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public int getDataSizes() {
        return dataSizes;
    }

    public void setDataSizes(int dataSizes) {
        this.dataSizes = dataSizes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public int getDataType() {
        return dataType;
    }

    public void setDataType(int dataType) {
        this.dataType = dataType;
    }
}
