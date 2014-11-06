/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.orz.pascal.javaee.commons.utils;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import lombok.Getter;

/**
 *
 * @author koduki
 */
@Named
@RequestScoped
public class RequestIdGenerator {

    @Getter
    String id;

    @PostConstruct
    public void init() {
        this.id = String.valueOf(Math.random());
    }
}
