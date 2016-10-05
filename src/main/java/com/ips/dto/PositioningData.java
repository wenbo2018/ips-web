package com.ips.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by shenwenbo on 2016/10/4.
 */
@Getter
@Setter
public class PositioningData implements Serializable{

    private static final long serialVersionUID = -6006128773192303417L;

    private double magneticX;
    private double magneticY;
    private double magneticZ;

    private double accelerationX;
    private double accelerationY;
    private double accelerationZ;

    private double orientationX;
    private double orientationY;
    private double orientationZ;

    private double gyroscopeX;
    private double gyroscopeY;
    private double gyroscopeZ;

    private double campassX;
    private double campassY;
    private double campassZ;

    private int position;
}
