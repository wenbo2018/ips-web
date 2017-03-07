package com.ips.web.admin;

import com.github.pagehelper.PageInfo;
import com.ips.dto.*;
import com.ips.services.api.*;
import com.ips.util.ExcelUtil;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by shenwenbo on 2017/2/15.
 */
@Controller
@RequestMapping(value = "/admins/datas")
public class PositioningDataController {

    @Resource
    private PositioningDataService positioningDataService;

    @Resource
    private RadioSignalStrengthService radioSignalStrengthService;

    @Resource
    private DataCollectRecordService dataCollectRecordService;
    @Resource
    private ApStringMacService apStringMacService;
    @Resource
    private MapDataService mapDataService;

    @RequestMapping(value = "/imuPagses", method = RequestMethod.GET)
    @ResponseBody
    public PageModel<PositioningData> pageModel(int pageIndex, int pageSize) {
        PageInfo<PositioningData> pageInfo = positioningDataService.queryByPage(pageIndex + 1, pageSize);
        PageModel<PositioningData> pageModel = new PageModel<PositioningData>();
        pageModel.setList(pageInfo.getList());
        pageModel.setPageIndex(pageInfo.getPageNum());
        pageModel.setTotal((int) pageInfo.getTotal());
        pageModel.setPageSize(pageInfo.getPageSize());
        return pageModel;
    }


    @RequestMapping(value = "/deleteImu", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> deleteImu(int imuId) {
        Map<String, String> code = new HashMap<>();
        positioningDataService.delete(imuId);
        code.put("code", "200");
        return code;
    }


    @RequestMapping(value = "/wifiPagses", method = RequestMethod.GET)
    @ResponseBody
    public PageModel<RadioSignalStrength> pageModel2(int pageIndex, int pageSize) {
        PageInfo<RadioSignalStrength> pageInfo = radioSignalStrengthService.queryByPage(pageIndex + 1, pageSize);
        PageModel<RadioSignalStrength> pageModel = new PageModel<RadioSignalStrength>();
        pageModel.setList(pageInfo.getList());
        pageModel.setPageIndex(pageInfo.getPageNum());
        pageModel.setTotal((int) pageInfo.getTotal());
        pageModel.setPageSize(pageInfo.getPageSize());
        return pageModel;
    }


    @RequestMapping(value = "/deleteWifi", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> deleteWifi(int wifiId) {
        Map<String, String> code = new HashMap<>();
        radioSignalStrengthService.delete(wifiId);
        code.put("code", "200");
        return code;
    }


    @RequestMapping(value = "/dataRecoderPagses", method = RequestMethod.GET)
    @ResponseBody
    public PageModel<DataCollectRecord> pageModel3(int pageIndex, int pageSize) {
        PageInfo<DataCollectRecord> pageInfo = dataCollectRecordService.queryByPage(pageIndex + 1, pageSize);
        PageModel<DataCollectRecord> pageModel = new PageModel<DataCollectRecord>();
        pageModel.setList(pageInfo.getList());
        pageModel.setPageIndex(pageInfo.getPageNum());
        pageModel.setTotal((int) pageInfo.getTotal());
        pageModel.setPageSize(pageInfo.getPageSize());
        return pageModel;
    }


    @RequestMapping(value = "/deleteRecoder", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> deleteRecoder(int recoderId) {
        Map<String, String> code = new HashMap<>();
        dataCollectRecordService.delete(recoderId);
        code.put("code", "200");
        return code;
    }


    @RequestMapping(value = "/apPagses", method = RequestMethod.GET)
    @ResponseBody
    public PageModel<ApStringMac> pageModel4(int pageIndex, int pageSize) {
        PageInfo<ApStringMac> pageInfo = apStringMacService.queryByPage(pageIndex + 1, pageSize);
        PageModel<ApStringMac> pageModel = new PageModel<ApStringMac>();
        pageModel.setList(pageInfo.getList());
        pageModel.setPageIndex(pageInfo.getPageNum());
        pageModel.setTotal((int) pageInfo.getTotal());
        pageModel.setPageSize(pageInfo.getPageSize());
        return pageModel;
    }


    @RequestMapping(value = "/deleteAp", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> deleteAp(int apId) {
        Map<String, String> code = new HashMap<>();
        apStringMacService.delete(apId);
        code.put("code", "200");
        return code;
    }


    @RequestMapping(value = "/mapPagses", method = RequestMethod.GET)
    @ResponseBody
    public PageModel<MapData> pageModel5(int pageIndex, int pageSize) {
        PageInfo<MapData> pageInfo = mapDataService.queryByPage(pageIndex + 1, pageSize);
        PageModel<MapData> pageModel = new PageModel<MapData>();
        pageModel.setList(pageInfo.getList());
        pageModel.setPageIndex(pageInfo.getPageNum());
        pageModel.setTotal((int) pageInfo.getTotal());
        pageModel.setPageSize(pageInfo.getPageSize());
        return pageModel;
    }


    @RequestMapping(value = "/deleteMap", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> deleteMap(int mapId) {
        Map<String, String> code = new HashMap<>();
        mapDataService.delete(mapId);
        code.put("code", "200");
        return code;
    }

    @RequestMapping("/uploadFile")
    @ResponseBody
    public Map<String, Object> updatePhoto(HttpServletRequest request, String mapName,
                                           String mapDesc, HttpServletResponse response, @RequestParam("myFile") MultipartFile myFile) {
        Map<String, Object> json = new HashMap<String, Object>();
        try {
            //输出文件后缀名称
            System.out.println(myFile.getOriginalFilename());
            DateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");
            //图片名称
            String name = df.format(new Date());

            Random r = new Random();
            for (int i = 0; i < 3; i++) {
                name += r.nextInt(10);
            }
            //
            String ext = FilenameUtils.getExtension(myFile.getOriginalFilename());
            //保存图片       File位置 （全路径）   /upload/fileName.jpg
            //相对路径
            String path = "/" + name + "." + ext;
            //            //判断线下线上环境
            File file;
            String realurl = request.getSession().getServletContext().getRealPath("resource/images");
            String url;
            String os = System.getProperty("os.name");
            if (os.toLowerCase().startsWith("win")) {
                url = "G:/data/upload/images";
                file = new File(url + path);
            } else {
                url = "/data/project/upload/images";
                file = new File(url + path);
            }
            FileUtils.copyInputStreamToFile(myFile.getInputStream(), file);
            FileUtils.copyInputStreamToFile(myFile.getInputStream(), new File(realurl + path));
            MapData mapData = new MapData();
            mapData.setMapUrl(path);
            mapData.setMapName(mapName);
            mapData.setMapDesc(mapDesc);
            mapDataService.add(mapData);
            json.put("success", url + path);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return json;

    }

    /***
     * 将数据导出Excel
     * @param request
     * @param position
     * @param response
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/downEcxel", method = RequestMethod.GET)
    public void download(HttpServletRequest request, int position, int type, HttpServletResponse response) throws IOException {
        String fileName = null;
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        if (type == 1) {
            fileName = "IMU_Excel数据" + System.currentTimeMillis();
            //填充projects数据
            List<PositioningData> projects = positioningDataService.queryByPosition(position);
            List<Map<String, Object>> list = createExcelRecord(projects);
            String columnNames[] = {"Id", "magneticX", "magneticY", "magneticZ", "accelerationX", "accelerationY",
                    "accelerationZ", "orientationX", "orientationY", "orientationZ", "gyroscopeX", "gyroscopeY",
                    "gyroscopeZ", "campassX", "campassY", "campassZ", "position", "datetime", "indexId"};//map中
            String keys[] = {"Id", "magneticX", "magneticY", "magneticZ", "accelerationX", "accelerationY", "accelerationZ",
                    "orientationX", "orientationY", "orientationZ", "gyroscopeX", "gyroscopeY", "gyroscopeZ", "campassX",
                    "campassY", "campassZ", "position", "datetime", "indexId"};//map中的key
            try {
                ExcelUtil.createWorkBook(list, keys, columnNames).write(os);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (type == 2) {
            fileName = "WIFI_Excel数据" + System.currentTimeMillis();
            List<RadioSignalStrength> projects = radioSignalStrengthService.queryByPosition(position);
            List<Map<String, Object>> listWIFI = createExcelRecordwifi(projects);
            String columnNamesWIFI[] = {"ID", "AP1", "AP2", "AP3", "AP4", "AP5", "AP6", "AP7", "AP8", "AP9", "AP10", "CIN"};
            String keysWIFI[] = {"Id", "AP1", "AP2", "AP3", "AP4", "AP5", "AP6", "AP7", "AP8", "AP9", "AP10", "CIN"};
            ExcelUtil.createWorkBook(listWIFI, keysWIFI, columnNamesWIFI).write(os);
        }
        byte[] content = os.toByteArray();
        InputStream is = new ByteArrayInputStream(content);
        // 设置response参数，可以打开下载页面
        response.reset();
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment;filename=" + new String((fileName + ".xls").getBytes(), "iso-8859-1"));
        ServletOutputStream out = response.getOutputStream();
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            bis = new BufferedInputStream(is);
            bos = new BufferedOutputStream(out);
            byte[] buff = new byte[2048];
            int bytesRead;
            // Simple read/write loop.
            while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
                bos.write(buff, 0, bytesRead);
            }
        } catch (final IOException e) {
            throw e;
        } finally {
            if (bis != null)
                bis.close();
            if (bos != null)
                bos.close();
        }
    }

    /***
     * 构造Radio数据
     * @param projects
     * @return
     */
    private List<Map<String, Object>> createExcelRecordwifi(List<RadioSignalStrength> projects) {
        List<Map<String, Object>> listmap = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("sheetName", "sheet1");
        listmap.add(map);
        RadioSignalStrength project = null;
        for (int j = 0; j < projects.size(); j++) {
            project = projects.get(j);
            Map<String, Object> mapValue = new HashMap<String, Object>();
            mapValue.put("Id", project.getId());
            mapValue.put("AP1", project.getAP1());
            mapValue.put("AP2", project.getAP2());
            mapValue.put("AP3", project.getAP3());
            mapValue.put("AP4", project.getAP4());
            mapValue.put("AP5", project.getAP5());
            mapValue.put("AP6", project.getAP6());
            mapValue.put("AP7", project.getAP7());
            mapValue.put("AP8", project.getAP8());
            mapValue.put("AP9", project.getAP9());
            mapValue.put("AP10", project.getAP10());
            mapValue.put("CIN", project.getCin());
            listmap.add(mapValue);
        }
        return listmap;
    }


    /***
     * 构造PositioningData数据
     * @param projects
     * @return
     */
    private List<Map<String, Object>> createExcelRecord(List<PositioningData> projects) {
        List<Map<String, Object>> listmap = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("sheetName", "sheet1");
        listmap.add(map);
        PositioningData project = null;
        for (int j = 0; j < projects.size(); j++) {
            project = projects.get(j);
            Map<String, Object> mapValue = new HashMap<String, Object>();
            mapValue.put("Id", project.getId());
            mapValue.put("magneticX", project.getMagneticX());
            mapValue.put("magneticY", project.getMagneticY());
            mapValue.put("magneticZ", project.getMagneticZ());
            mapValue.put("accelerationX", project.getAccelerationX());
            mapValue.put("accelerationY", project.getAccelerationY());
            mapValue.put("accelerationZ", project.getAccelerationZ());
            mapValue.put("orientationX", project.getOrientationX());
            mapValue.put("orientationY", project.getOrientationY());
            mapValue.put("orientationZ", project.getOrientationZ());
            mapValue.put("gyroscopeX", project.getGyroscopeX());
            mapValue.put("gyroscopeY", project.getGyroscopeY());
            mapValue.put("gyroscopeZ", project.getGyroscopeZ());
            mapValue.put("campassX", project.getCampassX());
            mapValue.put("campassY", project.getCampassY());
            mapValue.put("campassZ", project.getCampassZ());
            mapValue.put("position", project.getPosition());
            mapValue.put("datetime", project.getDatetime());
            mapValue.put("indexId", project.getIndexId());
            listmap.add(mapValue);
        }
        return listmap;
    }
}
