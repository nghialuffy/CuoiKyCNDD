package com.e.myapplication.ui;

import java.io.Serializable;

public class Truyen implements Serializable {
    private String tentruyen;
    private String datatruyen;
    private String tentruyenEng;
    private String datatruyenEng;
    private int sochuong;
    private int chuongdangdoc;
    private String icon;

    public Truyen(){
        this.tentruyen = "";
        this.datatruyen = "";
        this.tentruyenEng="";
        this.datatruyenEng="";
        this.sochuong = 0;
        this.chuongdangdoc = 0;
        this.icon = "";
    }

    public Truyen(String tentruyen, String datatruyen, String tentruyenEng, String datatruyenEng, int sochuong, int chuongdangdoc, String icon) {
        this.tentruyen = tentruyen;
        this.datatruyen = datatruyen;
        this.tentruyenEng = tentruyenEng;
        this.datatruyenEng = datatruyenEng;
        this.sochuong = sochuong;
        this.chuongdangdoc = chuongdangdoc;
        this.icon = icon;
    }

    public String getTentruyenEng() {
        return tentruyenEng;
    }

    public void setTentruyenEng(String tentruyenEng) {
        this.tentruyenEng = tentruyenEng;
    }

    public String getDatatruyenEng() {
        return datatruyenEng;
    }

    public void setDatatruyenEng(String datatruyenEng) {
        this.datatruyenEng = datatruyenEng;
    }

    public String getDatatruyen() {
        return datatruyen;
    }

    public void setDatatruyen(String datatruyen) {
        this.datatruyen = datatruyen;
    }


    public String getTentruyen() {
        return tentruyen;
    }

    public void setTentruyen(String tentruyen) {
        this.tentruyen = tentruyen;
    }

    public int getSochuong() {
        return sochuong;
    }

    public void setSochuong(int sochuong) {
        this.sochuong = sochuong;
    }

    public int getChuongdangdoc() {
        return chuongdangdoc;
    }

    public void setChuongdangdoc(int chuongdangdoc) {
        this.chuongdangdoc = chuongdangdoc;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
