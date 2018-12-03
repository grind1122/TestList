
package com.example.alex.testlist;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GlobalData {

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("data")
    @Expose
    private List<Order> data = null;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<Order> getData() {
        return data;
    }

    public void setData(List<Order> data) {
        this.data = data;
    }

    public static GlobalData fromJson(String json) {
        try {
            return new Gson().fromJson(json, GlobalData.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
