package com.ips.services.api;

import com.github.pagehelper.PageInfo;
import com.ips.dto.ApiCountData;
import com.ips.dto.ApiData;
import com.ips.dto.api.TopApi;

import java.util.Date;
import java.util.List;

/**
 * Created by shenwenbo on 2017/2/17.
 */
public interface ApiDataService {
    void add(ApiData apiData);
    /**
     * PositioningData 分页查询接口
     * @param pageIndex
     * @param pageSize
     * @return
     */
    PageInfo<ApiData> queryByPage(Integer pageIndex, Integer pageSize);

    void delete(int id);


    List<ApiCountData> queryListByFirstDayToNow(String first, String second);

    List<TopApi> quertTo10API();
}
