
package com.example.alex.testlist;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OrderRow {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("price")
    @Expose
    private String price;
    @SerializedName("price_10")
    @Expose
    private String price10;
    @SerializedName("sale")
    @Expose
    private String sale;
    @SerializedName("sale_proc")
    @Expose
    private String saleProc;
    @SerializedName("kol")
    @Expose
    private String kol;
    @SerializedName("block")
    @Expose
    private Integer block;
    @SerializedName("noskidka")
    @Expose
    private Integer noskidka;
    @SerializedName("price_zak")
    @Expose
    private Integer priceZak;
    @SerializedName("sclad")
    @Expose
    private String sclad;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPrice10() {
        return price10;
    }

    public void setPrice10(String price10) {
        this.price10 = price10;
    }

    public String getSale() {
        return sale;
    }

    public void setSale(String sale) {
        this.sale = sale;
    }

    public String getSaleProc() {
        return saleProc;
    }

    public void setSaleProc(String saleProc) {
        this.saleProc = saleProc;
    }

    public String getKol() {
        return kol;
    }

    public void setKol(String kol) {
        this.kol = kol;
    }

    public Integer getBlock() {
        return block;
    }

    public void setBlock(Integer block) {
        this.block = block;
    }

    public Integer getNoskidka() {
        return noskidka;
    }

    public void setNoskidka(Integer noskidka) {
        this.noskidka = noskidka;
    }

    public Integer getPriceZak() {
        return priceZak;
    }

    public void setPriceZak(Integer priceZak) {
        this.priceZak = priceZak;
    }

    public String getSclad() {
        return sclad;
    }

    public void setSclad(String sclad) {
        this.sclad = sclad;
    }

}
