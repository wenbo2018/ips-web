package com.ips.services;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ips.dao.ApiDataDao;
import com.ips.dto.ApiCountData;
import com.ips.dto.ApiData;
import com.ips.dto.User;
import com.ips.dto.api.TopApi;
import com.ips.services.api.ApiDataService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by shenwenbo on 2017/2/17.
 */
@Service
public class ApiDataServiceImpl implements ApiDataService {

    @Resource
    private ApiDataDao apiDataDao;

    @Override
    public void add(ApiData apiData) {
        apiDataDao.add(apiData);
    }

    @Override
    public PageInfo<ApiData> queryByPage(Integer pageIndex, Integer pageSize) {
        pageIndex = pageIndex == null?0:pageIndex;
        pageSize = pageSize == null?10:pageSize;
        PageHelper.startPage(pageIndex, pageSize);
        List<ApiData> list = apiDataDao.list();
        //用PageInfo对结果进行包装
        PageInfo<ApiData> page = new PageInfo<ApiData>(list);
        return page;
    }

    @Override
    public void delete(int id) {
        apiDataDao.delete(id);
    }

    @Override
    public List<ApiCountData> queryListByFirstDayToNow(String first, String second) {
      return   apiDataDao.queryListByFirstDayToNow(first,second);
    }

    @Override
    public List<TopApi> quertTo10API() {
        return apiDataDao.quertTo10API();
    }
}
