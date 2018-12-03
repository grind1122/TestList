package com.example.alex.testlist;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class UserOrdersResponse {

    private int status;
    private List<UserOrderItem> data = new ArrayList<>();

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<UserOrderItem> getData() {
        return data;
    }

    public void setData(List<UserOrderItem> data) {
        this.data = data;
    }

    public static UserOrdersResponse fromJson(String json){
        try{
            return new Gson().fromJson(json, UserOrdersResponse.class);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}