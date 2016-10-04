package com.bth.softboarder.db;

import com.bth.softboarder.entities.Orders;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

import java.util.List;

/**
 * Created by Srikar on 01-09-2016.
 */

@RegisterMapperFactory(BeanMapperFactory.class)
public interface OrderDAO {

    @SqlUpdate("create table if not exists orders (id int primary key auto_increment, emp_id varchar(255), emp_name varchar(255), phmodel varchar (255), lapmodel varchar (255),flag int(11))")
    public void createOrdersTable();

    @SqlUpdate("insert into orders (emp_id,emp_name,phmodel,lapmodel) values (:emp_id,:emp_name,:phmodel,:lapmodel);")
    public void insertOrder(@BindBean Orders orders);

    @SqlQuery("SELECT * FROM orders WHERE id = :id;")
    public Orders getBy(@Bind("id") int id);

    //@SqlQuery("SELECT * FROM orders WHERE emp_name = :emp_name;")
    //public Orders getBy(@Bind("emp_name") String emp_name);

    //@SqlQuery("select id,emp_id,emp_name,model from orders;")
    //public Orders getBy(String emp_id, String emp_name, String model);

    @SqlUpdate("UPDATE orders SET flag=1 WHERE id = :id;")
    public void updateOrder(@Bind("id") int id);

    @SqlQuery("select * from orders;")
    public List<Orders> getBy();


    @SqlUpdate("UPDATE orders SET flag=2 WHERE id = :id;")
    public void deleteOrderById(@Bind("id") int id);


}

