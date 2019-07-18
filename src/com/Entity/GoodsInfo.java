package com.Entity;

public class GoodsInfo {
    private int id;
    private String goodsInfoName;
    private String goodInfoPic;
    private String goodsInfoPrice;
    private String goodsInfoDescription;
    private String goodsStock;
    private String flag;

    public GoodsInfo(int id, String goodsInfoName, String goodInfoPic, String goodsInfoPrice, String goodsInfoDescription, String goodsStock, String flag) {
        this.id = id;
        this.goodsInfoName = goodsInfoName;
        this.goodInfoPic = goodInfoPic;
        this.goodsInfoPrice = goodsInfoPrice;
        this.goodsInfoDescription = goodsInfoDescription;
        this.goodsStock = goodsStock;
        this.flag = flag;
    }

    public GoodsInfo(String goodsInfoName, String goodInfoPic, String goodsInfoPrice, String goodsInfoDescription, String goodsStock, String flag) {
        this.goodsInfoName = goodsInfoName;
        this.goodInfoPic = goodInfoPic;
        this.goodsInfoPrice = goodsInfoPrice;
        this.goodsInfoDescription = goodsInfoDescription;
        this.goodsStock = goodsStock;
        this.flag = flag;
    }

    public GoodsInfo(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGoodsInfoName() {
        return goodsInfoName;
    }

    public void setGoodsInfoName(String goodsInfoName) {
        this.goodsInfoName = goodsInfoName;
    }

    public String getGoodInfoPic() {
        return goodInfoPic;
    }

    public void setGoodInfoPic(String goodInfoPic) {
        this.goodInfoPic = goodInfoPic;
    }

    public String getGoodsInfoPrice() {
        return goodsInfoPrice;
    }

    public void setGoodsInfoPrice(String goodsInfoPrice) {
        this.goodsInfoPrice = goodsInfoPrice;
    }

    public String getGoodsInfoDescription() {
        return goodsInfoDescription;
    }

    public void setGoodsInfoDescription(String goodsInfoDescription) {
        this.goodsInfoDescription = goodsInfoDescription;
    }

    public String getGoodsStock() {
        return goodsStock;
    }

    public void setGoodsStock(String goodsStock) {
        this.goodsStock = goodsStock;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}
