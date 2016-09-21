package com.bth.softboarder.entities;

/**
 * Created by DIVYA on 16-09-2016.
 */
public class Inventorys {

    int id;
    String type;
    String model;
    int quantity;

    public Inventorys() {
        super();
    }

    public Inventorys(int id) {
        super();
        this.id = id;
    }

    public Inventorys(int id, String type) {
        super();
        this.id = id;
        this.type = type;
    }

    public Inventorys(int id, String type, String model) {
        super();
        this.id = id;
        this.type = type;
        this.model = model;
    }

    public Inventorys(int id, String type, String model, int quantity) {
        super();
        this.id = id;
        this.type = type;
        this.model = model;
        this.quantity = quantity;
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
