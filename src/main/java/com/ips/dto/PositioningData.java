package com.ips.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by shenwenbo on 2016/10/4.
 */
public class PositioningData implements Serializable{

    private int id;

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

    private double presure;

    private int position;

    private Date datetime;

    private int indexId;

    public int getIndexId() {
        return indexId;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public void setIndexId(int indexId) {
        this.indexId = indexId;
    }

    public double getMagneticX() {
        return magneticX;
    }

    public void setMagneticX(double magneticX) {
        this.magneticX = magneticX;
    }

    public double getMagneticY() {
        return magneticY;
    }

    public void setMagneticY(double magneticY) {
        this.magneticY = magneticY;
    }

    public double getMagneticZ() {
        return magneticZ;
    }

    public void setMagneticZ(double magneticZ) {
        this.magneticZ = magneticZ;
    }

    public double getAccelerationX() {
        return accelerationX;
    }

    public void setAccelerationX(double accelerationX) {
        this.accelerationX = accelerationX;
    }

    public double getAccelerationY() {
        return accelerationY;
    }

    public void setAccelerationY(double accelerationY) {
        this.accelerationY = accelerationY;
    }

    public double getAccelerationZ() {
        return accelerationZ;
    }

    public void setAccelerationZ(double accelerationZ) {
        this.accelerationZ = accelerationZ;
    }

    public double getOrientationX() {
        return orientationX;
    }

    public void setOrientationX(double orientationX) {
        this.orientationX = orientationX;
    }

    public double getOrientationY() {
        return orientationY;
    }

    public void setOrientationY(double orientationY) {
        this.orientationY = orientationY;
    }

    public double getOrientationZ() {
        return orientationZ;
    }

    public void setOrientationZ(double orientationZ) {
        this.orientationZ = orientationZ;
    }

    public double getGyroscopeX() {
        return gyroscopeX;
    }

    public void setGyroscopeX(double gyroscopeX) {
        this.gyroscopeX = gyroscopeX;
    }

    public double getGyroscopeY() {
        return gyroscopeY;
    }

    public void setGyroscopeY(double gyroscopeY) {
        this.gyroscopeY = gyroscopeY;
    }

    public double getGyroscopeZ() {
        return gyroscopeZ;
    }

    public void setGyroscopeZ(double gyroscopeZ) {
        this.gyroscopeZ = gyroscopeZ;
    }

    public double getCampassX() {
        return campassX;
    }

    public void setCampassX(double campassX) {
        this.campassX = campassX;
    }

    public double getCampassY() {
        return campassY;
    }

    public void setCampassY(double campassY) {
        this.campassY = campassY;
    }

    public double getCampassZ() {
        return campassZ;
    }

    public void setCampassZ(double campassZ) {
        this.campassZ = campassZ;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public double getPresure() {
        return presure;
    }

    public void setPresure(double presure) {
        this.presure = presure;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
