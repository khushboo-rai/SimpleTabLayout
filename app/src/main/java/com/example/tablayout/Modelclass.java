package com.example.tablayout;

public class Modelclass {

    String retailer_id;
    String product_id;
    String status;
    String stock_availability;
    String product_name;
    String productimage;

    public Modelclass() {
    }

    public Modelclass(String retailer_id, String product_id, String status, String stock_availability, String product_name, String productimage) {
        this.retailer_id = retailer_id;
        this.product_id = product_id;
        this.status = status;
        this.stock_availability = stock_availability;
        this.product_name = product_name;
        this.productimage = productimage;
    }

    public String getRetailer_id() {
        return retailer_id;
    }

    public String getProduct_id() {
        return product_id;
    }

    public String getStatus() {
        return status;
    }

    public String getStock_availability() {
        return stock_availability;
    }

    public String getProduct_name() {
        return product_name;
    }

    public String getProductimage() {
        return productimage;
    }

    public void setRetailer_id(String retailer_id) {
        this.retailer_id = retailer_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setStock_availability(String stock_availability) {
        this.stock_availability = stock_availability;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public void setProductimage(String productimage) {
        this.productimage = productimage;
    }
}
