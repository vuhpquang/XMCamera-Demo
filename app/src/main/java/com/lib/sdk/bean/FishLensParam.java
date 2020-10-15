package com.lib.sdk.bean;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by zhangyongyong on 2017-09-15-15:43.
 */

public class FishLensParam {

    private int CenterOffsetX;
    private int CenterOffsetY;
    private int ImageHeight;
    private int ImageWidth;
    private int LensType;
    private String PCMac;
    private int Radius;
    private int Version;
    private int ViewAngle;
    private int ViewMode;
    private int Zoom;

    @JSONField(name = "CenterOffsetX")
    public void setCenterOffsetX(int CenterOffsetX) {
        this.CenterOffsetX = CenterOffsetX;
    }

    @JSONField(name = "CenterOffsetX")
    public int getCenterOffsetX() {
        return CenterOffsetX;
    }

    @JSONField(name = "CenterOffsetY")
    public void setCenterOffsetY(int CenterOffsetY) {
        this.CenterOffsetY = CenterOffsetY;
    }

    @JSONField(name = "CenterOffsetY")
    public int getCenterOffsetY() {
        return CenterOffsetY;
    }

    @JSONField(name = "ImageHeight")
    public void setImageHeight(int ImageHeight) {
        this.ImageHeight = ImageHeight;
    }

    @JSONField(name = "ImageHeight")
    public int getImageHeight() {
        return ImageHeight;
    }

    @JSONField(name = "ImageWidth")
    public void setImageWidth(int ImageWidth) {
        this.ImageWidth = ImageWidth;
    }

    @JSONField(name = "ImageWidth")
    public int getImageWidth() {
        return ImageWidth;
    }

    @JSONField(name = "LensType")
    public void setLensType(int LensType) {
        this.LensType = LensType;
    }

    @JSONField(name = "LensType")
    public int getLensType() {
        return LensType;
    }

    @JSONField(name = "PCMac")
    public void setPCMac(String PCMac) {
        this.PCMac = PCMac;
    }

    @JSONField(name = "PCMac")
    public String getPCMac() {
        return PCMac;
    }

    @JSONField(name = "Radius")
    public void setRadius(int Radius) {
        this.Radius = Radius;
    }

    @JSONField(name = "Radius")
    public int getRadius() {
        return Radius;
    }

    @JSONField(name = "Version")
    public void setVersion(int Version) {
        this.Version = Version;
    }

    @JSONField(name = "Version")
    public int getVersion() {
        return Version;
    }

    @JSONField(name = "ViewAngle")
    public void setViewAngle(int ViewAngle) {
        this.ViewAngle = ViewAngle;
    }

    @JSONField(name = "ViewAngle")
    public int getViewAngle() {
        return ViewAngle;
    }

    @JSONField(name = "ViewMode")
    public void setViewMode(int ViewMode) {
        this.ViewMode = ViewMode;
    }

    @JSONField(name = "ViewMode")
    public int getViewMode() {
        return ViewMode;
    }

    @JSONField(name = "Zoom")
    public void setZoom(int Zoom) {
        this.Zoom = Zoom;
    }

    @JSONField(name = "Zoom")
    public int getZoom() {
        return Zoom;
    }


}
