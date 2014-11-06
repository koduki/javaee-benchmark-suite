/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.orz.pascal.javaee.commons.validators;

import cn.orz.pascal.javaee.commons.annotations.Required;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class RequiredValidator implements ConstraintValidator<Required, String> {

    @Override
    public void initialize(Required constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        } else if (value.trim().isEmpty()) {
            return false;
        }
        return true;
    }

}
