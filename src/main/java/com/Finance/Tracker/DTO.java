package com.Finance.Tracker;

public class DTO {

    private String category;
    private float amount;
    private String date;

    public void setCategory(String category){
        this.category = category;
    }

    public String getCategory(){
        return category;
    }

    public void setAmount(float amount){
        this.amount = amount;
    }

    public float getAmount(){
        return amount;
    }

    public void setDate(String date){
        this.date = date;
    }

    public String getDate(){
        return date;
    }

}
