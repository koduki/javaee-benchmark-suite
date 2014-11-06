/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cn.orz.pascal.javaee.commons.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.validation.Constraint;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import javax.validation.Payload;
import cn.orz.pascal.javaee.commons.validators.RequiredValidator;

@Target({ METHOD,FIELD, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy={RequiredValidator.class})
public @interface Required {

    String message() default "may not be empty";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}