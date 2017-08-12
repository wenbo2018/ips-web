package com.ips.dto;


import java.util.Date;

/**
 * Created by shenwenbo on 2017/2/17.
 */
public class ApiData {

    private int id;
    private String apiUrl;
    private int requestTotalCount;
    private String clientIp;
    private Date requestTime;

    private int status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getApiUrl() {
        return apiUrl;
    }

    public void setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl;
    }

    public int getRequestTotalCount() {
        return requestTotalCount;
    }

    public void setRequestTotalCount(int requestTotalCount) {
        this.requestTotalCount = requestTotalCount;
    }

    public String getClientIp() {
        return clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    public Date getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(Date requestTime) {
        this.requestTime = requestTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
