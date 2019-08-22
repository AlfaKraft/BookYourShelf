package com.tieto.bookyourshelf.library.validation;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.Field;


public class PasswordsEqualConstraintValidator implements
        ConstraintValidator<PasswordsEqualConstraint, Object> {

    private String baseField;
    private String matchField;
    private String message;

    @Override
    public void initialize(PasswordsEqualConstraint constraint) {
        baseField = constraint.baseField();
        matchField = constraint.matchField();
        message = constraint.message();
    }

    @Override
    public boolean isValid(Object object, ConstraintValidatorContext context) {
        try {
            Object baseFieldValue = getFieldValue(object, baseField);
            Object matchFieldValue = getFieldValue(object, matchField);
            return baseFieldValue != null && baseFieldValue.equals(matchFieldValue);
        } catch (Exception e) {
            // log error
            return false;
        }
    }

    private Object getFieldValue(Object object, String fieldName) throws Exception {
        Class<?> clazz = object.getClass();
        Field passwordField = clazz.getDeclaredField(fieldName);
        passwordField.setAccessible(true);
        return passwordField.get(object);
    }

}