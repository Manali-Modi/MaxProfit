package com.example.maxprofit.model;

public class ShareDetail {

    private String companyName;
    private double buyValue;
    private double sellValue;
    private double profitOnOne;

    public ShareDetail(String companyName, double buyValue, double sellValue) {
        this.companyName = companyName;
        this.buyValue = buyValue;
        this.sellValue = sellValue;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public double getBuyValue() {
        return buyValue;
    }

    public void setBuyValue(double buyValue) {
        this.buyValue = buyValue;
    }

    public double getSellValue() {
        return sellValue;
    }

    public void setSellValue(double sellValue) {
        this.sellValue = sellValue;
    }

    public double getProfitOnOne() {
        return profitOnOne;
    }

    public void setProfitOnOne(double profitOnOne) {
        this.profitOnOne = profitOnOne;
    }
}
