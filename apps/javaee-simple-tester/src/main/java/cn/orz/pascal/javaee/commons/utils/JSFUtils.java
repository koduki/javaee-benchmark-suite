/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.orz.pascal.javaee.commons.utils;

/**
 *
 * @author koduki
 */
public class JSFUtils {

    private JSFUtils() {
    }

    public static String $(String name) {
        return name + "?faces-redirect=true";
    }
}
