package com.Finance.Tracker;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jdk.jfr.Name;


@jakarta.persistence.Entity
@Table(name = "financeDB")
public class Entity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Nullable Integer id;


    private String category;
    private float amount;
    private String date;

    public void setID(Integer id){
        this.id = id;
    }
    public Integer getID(){
        return id;
    }

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
