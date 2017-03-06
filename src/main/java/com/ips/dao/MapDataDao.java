package com.ips.dao;

import com.ips.dto.MapData;

import java.util.List;

/**
 * Created by shenwenbo on 2017/2/16.
 */
public interface MapDataDao {
    List<MapData> list();
    public void add(MapData mapData);
    public void delete(int mapId);
}
