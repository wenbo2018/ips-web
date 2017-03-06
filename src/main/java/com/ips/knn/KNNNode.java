package com.ips.knn;

/**
 * Created by shenwenbo on 2016/12/23.
 */
public class KNNNode {
    private int index; // 元组标号
    private double distance; // 与测试元组的距离
    private int c; // 所属类别

    public KNNNode(int index, double distance, int c) {
        super();
        this.index = index;
        this.distance = distance;
        this.c = c;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }
}
