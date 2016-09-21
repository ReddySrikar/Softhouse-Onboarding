package com.bth.softboarder.db;

import com.bth.softboarder.entities.Admins;
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
public interface AdminDAO {

    @SqlUpdate("create table if not exists USERS(id int primary key auto_increment, username varchar(255), emailid varchar(255), password varchar(255), confirm_password varchar(255), status varchar(255))")
    public void createAdminsTable();

    @SqlQuery("select * from USERS where status = 'admin';")
    public List<Admins> getBy();

    @SqlQuery("select * from USERS where username = :username AND password= :password;")
    public Admins getBy(@Bind("username") String username, @Bind("password") String password);

    //@SqlUpdate("insert into USERS (username,emailid,password,confirm_password) values (:username,:emailid,:password,:confirm_password);")
    //public void insertAdmin(@BindBean Admins admins);

}
