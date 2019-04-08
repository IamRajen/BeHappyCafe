package com.rajendramishra.swipeable;

public class Orders {

    String Id,itemWithQuantityAndPrice,currentDate,total_price;

    public Orders() {
    }

    public String getTotal_price() {
        return total_price;
    }

    public void setTotal_price(String total_price) {
        this.total_price = total_price;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getItemWithQuantityAndPrice() {
        return itemWithQuantityAndPrice;
    }

    public void setItemWithQuantityAndPrice(String itemWithQuantityAndPrice) {
        this.itemWithQuantityAndPrice = itemWithQuantityAndPrice;
    }

    public String getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(String currentDate) {
        this.currentDate = currentDate;
    }

    public Orders(String id, String itemWithQuantityAndPrice,String total_price, String currentDate) {
        this.Id = id;
        this.itemWithQuantityAndPrice = itemWithQuantityAndPrice;
        this.currentDate = currentDate;
        this.total_price=total_price;
    }
}
