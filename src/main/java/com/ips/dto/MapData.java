package com.ips.dto;

import java.util.Date;

/**
 * Created by shenwenbo on 2017/2/16.
 */
public class MapData {
    private int id;
    private String mapName;
    private String mapUrl;
    private String mapDesc;

    private Date datetime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMapName(String originalFilename) {
        return mapName;
    }

    public void setMapName(String mapName) {
        this.mapName = mapName;
    }

    public String getMapUrl() {
        return mapUrl;
    }

    public void setMapUrl(String mapUrl) {
        this.mapUrl = mapUrl;
    }

    public String getMapName() {
        return mapName;
    }

    public String getMapDesc() {
        return mapDesc;
    }

    public void setMapDesc(String mapDesc) {
        this.mapDesc = mapDesc;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }
}
