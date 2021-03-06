package com.bth.softboarder.db;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

import com.bth.softboarder.entities.Users;
import java.util.List;
/**
 * Created by Srikar on 31-08-2016.
 */


@RegisterMapperFactory(BeanMapperFactory.class)
public interface UserDAO {
    @SqlUpdate("create table if not exists USERS(id int primary key auto_increment, username varchar(255), emailid varchar(255), password varchar(255), confirm_password varchar(255), status varchar(255))")
    public void createUsersTable();

    @SqlUpdate("insert into USERS (username,emailid,password,confirm_password) values (:username,:emailid,:password,:confirm_password);")
    public void insertUser(@BindBean Users users);

    @SqlQuery("SELECT * FROM USERS WHERE id = :id;")
    Users getBy(@Bind("id") int id);

    //@SqlQuery("Select * from App_Filter_USERS where username = :username;")
    //public Users getBy(@Bind("username") String username);

    //@SqlQuery("select id,username,emailid from USERS;")
    @SqlQuery("select * from USERS where username = :username AND password= :password;")
    public Users getBy(@Bind("username") String username, @Bind("password") String password);

    @SqlQuery("SELECT * FROM USERS WHERE username = :username;")
    Users getBy(@Bind("username") String username);

    @SqlQuery("select * from USERS where emailid = :emailid")
    public Users findUserByEmail(@Bind String emailid);

    @SqlQuery("SELECT * FROM USERS;")
    public List<Users> getBy();
}
