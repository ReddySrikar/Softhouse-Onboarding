package com.bth.softboarder.entities;

/**
 * Created by Srikar on 16-09-2016.
 */
public class Inventorys {

    int id;
    String type;
    String model;
    int quantity;

    public Inventorys() {
        super();
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
