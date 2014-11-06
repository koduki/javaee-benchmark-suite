/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.orz.pascal.javaee.simpletester.resources;

import java.util.List;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import cn.orz.pascal.javaee.simpletester.models.Users;
import cn.orz.pascal.javaee.simpletester.models.UsersDao;
import cn.orz.pascal.javaee.commons.annotations.ErrorLog;
import cn.orz.pascal.javaee.commons.annotations.TimeLog;

/**
 *
 * @author koduki
 */
@Path("/accounts")
@TimeLog
@ErrorLog
@Transactional
@Consumes("application/json")
@Produces("application/json")
public class UsersResources {

    @Inject
    UsersDao usersDao;

    @GET
    public List<Users> list() {
        return this.usersDao.findAll();
    }

    @POST
    public Users create(Users user) {
        this.usersDao.create(user);

        return user;
    }
}
