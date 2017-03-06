package com.ips.dao;

import com.ips.dto.ApiCountData;
import com.ips.dto.ApiData;
import com.ips.dto.api.TopApi;

import java.util.Date;
import java.util.List;

/**
 * Created by shenwenbo on 2017/2/17.
 */
public interface ApiDataDao {

    void add(ApiData apiData);
    List<ApiData> list();

    void delete(int id);

    List<ApiCountData> queryListByFirstDayToNow(String first, String second);

    List<TopApi> quertTo10API();

}
