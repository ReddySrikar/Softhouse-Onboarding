package com.bth.softboarder.entities;

/**
 * Created by DIVYA on 01-09-2016.
 */
public class Orders {

    int id;
    String emp_id;
    String emp_name;
    String model;

    //int flag;

    public Orders() {
        super();
    }

    public Orders(int id) {
        super();
        this.id = id;
    }

    public Orders(int id, String emp_id) {
        super();
        this.id = id;
        this.emp_id = emp_id;
    }

    public Orders(int id, String emp_id, String emp_name) {
        super();
        this.id = id;
        this.emp_id = emp_id;
        this.emp_name = emp_name;
    }

    public Orders(int id, String emp_id, String emp_name, String model) {
        super();
        this.id = id;
        this.emp_id = emp_id;
        this.emp_name = emp_name;
        this.model = model;
    }

    public Orders(String emp_id, String emp_name, String model) {
        super();
        this.emp_id = emp_id;
        this.emp_name = emp_name;
        this.model = model;
    }

    /**
     * public Users(int id, String emp_id, String emp_name, String model, int flag) {
     super();
     this.id = id;
     this.emp_id = emp_id;
     this.emp_name = emp_name;
     this.model = model;
     this.flag = flag;
     }
     **/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(String emp_id) {
        this.emp_id = emp_id;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", emp_id='" +  emp_id+ '\'' +
                ", emp_name='" + emp_name + '\'' +
                ", model='" + model + '\'' +
                '}';
    }

}
