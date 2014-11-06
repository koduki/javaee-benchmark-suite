/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.orz.pascal.javaee.simpletester.backingbeans;

import cn.orz.pascal.javaee.simpletester.models.Users;
import cn.orz.pascal.javaee.simpletester.models.UsersDao;
import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author koduki
 */
@Named
@ViewScoped
@Transactional
public class Accounts implements Serializable {

    @Inject
    UsersDao usersDao;

    @Setter
    @Getter
    String firstName;
    @Setter
    @Getter
    String lastName;
    @Setter
    @Getter
    int age;

    public String create() {
        System.err.println("hoge:" + firstName);
        
        Users user = new Users(firstName, lastName, age);
        //usersDao.create(user);
        
        
        
        return this.usersDao.findAll().toString();
    }
}
