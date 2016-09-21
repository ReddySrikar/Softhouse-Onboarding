package com.bth.softboarder.db;

import com.bth.softboarder.entities.Inventorys;
import com.bth.softboarder.entities.Users;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

import java.util.List;


/**
 * Created by DIVYA on 16-09-2016.
 */

@RegisterMapperFactory(BeanMapperFactory.class)
public interface InventoryDAO {
    @SqlUpdate("create table if not exists inventory (id int primary key auto_increment, type varchar(255), model varchar(255), quantity int (100))")
    public void createInventorysTable();

    @SqlQuery("select * from inventory;")
    public List<Inventorys> getBy();

    @SqlUpdate("insert into inventory (type,model,quantity) values (:type,:model,:quantity);")
    public void insertInventory(@BindBean Inventorys inventorys);
}
