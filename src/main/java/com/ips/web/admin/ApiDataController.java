package com.ips.web.admin;

import com.github.pagehelper.PageInfo;
import com.ips.dto.ApiCountData;
import com.ips.dto.ApiData;
import com.ips.dto.PageModel;
import com.ips.dto.User;
import com.ips.dto.api.TopApi;
import com.ips.services.api.ApiDataService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by shenwenbo on 2017/2/18.
 */
@Controller
@RequestMapping(value ="/admins/apis")
public class ApiDataController {


    @Resource
    private ApiDataService apiDataService;


    @RequestMapping(value = "/apiRequestPagses", method = RequestMethod.GET)
    @ResponseBody
    public PageModel<ApiData> apiRequestPagses(int pageIndex, int pageSize) {
        PageInfo<ApiData> pageInfo=apiDataService.queryByPage(pageIndex+1,pageSize);
        PageModel<ApiData> pageModel=new PageModel<ApiData>();
        pageModel.setList(pageInfo.getList());
        pageModel.setPageIndex(pageInfo.getPageNum());
        pageModel.setTotal((int) pageInfo.getTotal());
        pageModel.setPageSize(pageInfo.getPageSize());
        return pageModel;
    }



    /***
     * 根据apiId删除User
     * @param apiId
     * @return
     */
    @RequestMapping(value = "/deleteApiData", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,String> deleteUserByUserId(int apiId) {
        Map<String,String> code=new HashMap<>();
        apiDataService.delete(apiId);
        code.put("code","200");
        return code;
    }

    @RequestMapping(value = "/apICountData", method = RequestMethod.GET)
    @ResponseBody
    public List<ApiCountData> quertDayData() {
        return apiDataService.queryListByFirstDayToNow(getPastDate(6),getPastDate(0));
    }


    public  String getPastDate(int past) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - past);
        Date today = calendar.getTime();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String result = format.format(today);
        return result;
    }



    @RequestMapping(value = "/apITop", method = RequestMethod.GET)
    @ResponseBody
    public List<TopApi> quertApiTop() {
        return apiDataService.quertTo10API();
    }


}
