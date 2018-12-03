
package com.example.alex.testlist;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Order {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("order_rows")
    @Expose
    private List<OrderRow> orderRows = null;
    @SerializedName("skidka")
    @Expose
    private String skidka;
    @SerializedName("dostavka")
    @Expose
    private String dostavka;
    @SerializedName("payed")
    @Expose
    private String payed;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("skidka_rub")
    @Expose
    private Integer skidkaRub;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<OrderRow> getOrderRows() {
        return orderRows;
    }

    public void setOrderRows(List<OrderRow> orderRows) {
        this.orderRows = orderRows;
    }

    public String getSkidka() {
        return skidka;
    }

    public void setSkidka(String skidka) {
        this.skidka = skidka;
    }

    public String getDostavka() {
        return dostavka;
    }

    public void setDostavka(String dostavka) {
        this.dostavka = dostavka;
    }

    public String getPayed() {
        return payed;
    }

    public void setPayed(String payed) {
        this.payed = payed;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getSkidkaRub() {
        return skidkaRub;
    }

    public void setSkidkaRub(Integer skidkaRub) {
        this.skidkaRub = skidkaRub;
    }

}
