package com.softhouse.onboarder.db;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

//import se.bth.softhouse.entities.Users;

@RegisterMapperFactory(BeanMapperFactory.class)
public interface UserDAO {
    @SqlUpdate("create table orders (serial_number int(11) NOT NULL AUTO_INCREMENT, emp_id int(11) NOT NULL DEFAULT '0', emp_name varchar(100) NOT NULL DEFAULT '', model varchar(100) NOT NULL DEFAULT '',flag int(11) NOT NULL DEFAULT '0', PRIMARY KEY (serial_number))")
    public void createUsersTable();

    /*@SqlUpdate("insert into App_Filter_USERS (username,emailid,password,confirm_password) values (:username,:emailid,:password,:confirm_password);")
    void insertUser(@BindBean Users users);

    @SqlQuery("SELECT * FROM App_Filter_USERS WHERE id = :id;")
    public Users getBy(@Bind("id") int id);

    @SqlQuery("Select * from App_Filter_USERS where username = :username;")
    public Users getBy(@Bind("username") String username);

    @SqlQuery("select id,username,emailid from App_Filter_USERS;")
    public Users getBy();*/
}