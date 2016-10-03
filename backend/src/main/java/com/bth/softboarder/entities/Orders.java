package com.bth.softboarder.entities;

/**
 * Created by Srikar on 01-09-2016.
 */
public class Orders {

    int id;
    String emp_id;
    String emp_name;
    String lapmodel;
    String phmodel;
    int flag;

    public Orders() {
        super();
    }

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

    public String getLapmodel() {
        return lapmodel;
    }

    public void setLapmodel(String lapmodel) {
        this.lapmodel = lapmodel;
    }

    public String getPhmodel() {
        return phmodel;
    }

    public void setPhmodel(String phmodel) {
        this.phmodel = phmodel;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", emp_id='" +  emp_id+ '\'' +
                ", emp_name='" + emp_name + '\'' +
                ", phmodel='" + phmodel + '\'' +
                ", lapmodel='" + lapmodel + '\'' +
                ", flag='" + flag + '\'' +
                '}';
    }
}